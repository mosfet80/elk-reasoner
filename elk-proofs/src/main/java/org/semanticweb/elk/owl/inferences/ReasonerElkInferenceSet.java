package org.semanticweb.elk.owl.inferences;

import java.util.Collection;
import java.util.List;

/*
 * #%L
 * ELK Proofs Package
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2011 - 2016 Department of Computer Science, University of Oxford
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.semanticweb.elk.exceptions.ElkException;
import org.semanticweb.elk.exceptions.ElkRuntimeException;
import org.semanticweb.elk.matching.Matcher;
import org.semanticweb.elk.owl.interfaces.ElkAxiom;
import org.semanticweb.elk.owl.interfaces.ElkClassExpression;
import org.semanticweb.elk.owl.interfaces.ElkEquivalentClassesAxiom;
import org.semanticweb.elk.owl.interfaces.ElkIndividual;
import org.semanticweb.elk.owl.interfaces.ElkObject;
import org.semanticweb.elk.owl.interfaces.ElkSubClassOfAxiom;
import org.semanticweb.elk.owl.visitors.DummyElkAxiomVisitor;
import org.semanticweb.elk.owl.visitors.ElkAxiomVisitor;
import org.semanticweb.elk.reasoner.Reasoner;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.ClassInconsistency;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.DerivedClassConclusionVisitor;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.SubClassInclusionComposed;
import org.semanticweb.elk.reasoner.tracing.TracingInferenceSet;

/**
 * A view for inferences over {@link ElkAxiom}s provided by {@link Reasoner}.
 * The inferences are computed lazily on request. If {@link Reasoner} is changed
 * by calling {@link #setReasoner(Reasoner)}, the inferences are recomputed (the
 * registered {@link ElkInferenceSet.ChangeListener}s will receive a
 * notification).
 * 
 * @author Yevgeny Kazakov
 */
public class ReasonerElkInferenceSet extends ModifiableElkInferenceSetImpl
		implements TracingInferenceSet.ChangeListener {

	private final ElkAxiom goal_;

	private final ElkObject.Factory elkFactory_;

	private Reasoner reasoner_;

	private final ElkInference.Factory inferenceFactory_;

	private final ElkAxiomVisitor<Void> inferenceGenerator_ = new InferenceGenerator();

	/**
	 * {@code true} when the inferences are retrieved from the reasoner
	 */
	private boolean initialized_ = false;

	public ReasonerElkInferenceSet(ElkAxiom goal,
			ElkObject.Factory elkFactory) {
		super(elkFactory);
		this.goal_ = goal;
		this.elkFactory_ = elkFactory;
		this.inferenceFactory_ = new ElkInferenceOptimizedProducingFactory(this,
				elkFactory);
	}

	public void setReasoner(Reasoner reasoner) {
		synchronized (this) {
			if (reasoner_ != null) {
				reasoner_.getTracingInferences().remove(this);
			}
			this.reasoner_ = reasoner;
			reasoner.getTracingInferences().add(this);
		}
		reset();
	}

	@Override
	public synchronized Collection<? extends ElkInference> get(
			ElkAxiom conclusion) {
		initialize();
		return super.get(conclusion);
	}

	void reset() {
		synchronized (this) {
			if (!initialized_) {
				return;
			}
			// else
			initialized_ = false;
		}
		fireChanged();
	}

	synchronized void initialize() {
		if (initialized_) {
			return;
		}
		// else
		clear();
		goal_.accept(inferenceGenerator_);
		initialized_ = true;
	}

	@Override
	public void inferencesChanged() {
		reset();
	}

	private void addInferencesForSubsumption(final ElkClassExpression subClass,
			final ElkClassExpression superClass) {
		if (superClass.equals(elkFactory_.getOwlThing())) {
			inferenceFactory_.getElkClassInclusionOwlThing(subClass);
		}
		try {
			DerivedClassConclusionVisitor conclusionVisitor = new DerivedClassConclusionVisitor() {

				@Override
				public boolean inconsistentOwlThing(
						ClassInconsistency conclusion) throws ElkException {
					Matcher matcher = new Matcher(
							reasoner_.explainConclusion(conclusion),
							elkFactory_, inferenceFactory_);
					matcher.trace(conclusion, elkFactory_.getOwlThing());
					inferenceFactory_.getElkClassInclusionOwlThing(subClass);
					inferenceFactory_
							.getElkClassInclusionOwlNothing(superClass);
					inferenceFactory_.getElkClassInclusionHierarchy(subClass,
							elkFactory_.getOwlThing(),
							elkFactory_.getOwlNothing(), superClass);
					return true;
				}

				@Override
				public boolean inconsistentIndividual(
						ClassInconsistency conclusion, ElkIndividual entity)
						throws ElkException {
					Matcher matcher = new Matcher(
							reasoner_.explainConclusion(conclusion),
							elkFactory_, inferenceFactory_);
					matcher.trace(conclusion, entity);
					inferenceFactory_.getElkClassInclusionOwlThing(subClass);
					inferenceFactory_
							.getElkClassInclusionOfInconsistentIndividual(
									entity);
					inferenceFactory_
							.getElkClassInclusionOwlNothing(superClass);
					inferenceFactory_.getElkClassInclusionHierarchy(subClass,
							elkFactory_.getOwlThing(),
							elkFactory_.getOwlNothing(), superClass);
					return true;
				}

				@Override
				public boolean inconsistentSubClass(
						ClassInconsistency conclusion) throws ElkException {
					Matcher matcher = new Matcher(
							reasoner_.explainConclusion(conclusion),
							elkFactory_, inferenceFactory_);
					matcher.trace(conclusion, subClass);
					inferenceFactory_
							.getElkClassInclusionOwlNothing(superClass);
					inferenceFactory_.getElkClassInclusionHierarchy(subClass,
							elkFactory_.getOwlNothing(), superClass);
					return true;
				}

				@Override
				public boolean derivedClassInclusion(
						SubClassInclusionComposed conclusion)
						throws ElkException {
					Matcher matcher = new Matcher(
							reasoner_.explainConclusion(conclusion),
							elkFactory_, inferenceFactory_);
					matcher.trace(conclusion, subClass, superClass);
					return true;
				}

			};
			reasoner_.visitDerivedConclusionsForSubsumption(subClass,
					superClass, conclusionVisitor);
		} catch (ElkException e) {
			throw new ElkRuntimeException(e);
		}
	}

	private class InferenceGenerator extends DummyElkAxiomVisitor<Void> {

		@Override
		public Void defaultVisit(ElkAxiom axiom) {
			throw new ElkRuntimeException("Cannot generate proof for " + axiom);
		}

		@Override
		public Void visit(ElkSubClassOfAxiom axiom) {
			addInferencesForSubsumption(axiom.getSubClassExpression(),
					axiom.getSuperClassExpression());
			return null;
		}

		@Override
		public Void visit(ElkEquivalentClassesAxiom axiom) {
			List<? extends ElkClassExpression> equivalent = axiom
					.getClassExpressions();
			ElkClassExpression first = equivalent.get(equivalent.size() - 1);
			for (ElkClassExpression second : equivalent) {
				addInferencesForSubsumption(first, second);
				first = second;
			}
			inferenceFactory_.getElkEquivalentClassesCycle(equivalent);
			return null;
		}

	}

}