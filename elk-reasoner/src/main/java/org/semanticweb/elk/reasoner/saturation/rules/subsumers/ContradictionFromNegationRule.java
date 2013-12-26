package org.semanticweb.elk.reasoner.saturation.rules.subsumers;
/*
 * #%L
 * ELK Reasoner
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2011 - 2013 Department of Computer Science, University of Oxford
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

import org.semanticweb.elk.reasoner.indexing.hierarchy.ElkUnexpectedIndexingException;
import org.semanticweb.elk.reasoner.indexing.hierarchy.IndexedClassExpression;
import org.semanticweb.elk.reasoner.indexing.hierarchy.IndexedObjectComplementOf;
import org.semanticweb.elk.reasoner.indexing.hierarchy.ModifiableOntologyIndex;
import org.semanticweb.elk.reasoner.saturation.SaturationStateWriter;
import org.semanticweb.elk.reasoner.saturation.conclusions.Contradiction;
import org.semanticweb.elk.reasoner.saturation.context.Context;
import org.semanticweb.elk.reasoner.saturation.rules.ChainableRule;
import org.semanticweb.elk.reasoner.saturation.rules.CompositionRuleVisitor;
import org.semanticweb.elk.util.collections.chains.Chain;
import org.semanticweb.elk.util.collections.chains.Matcher;
import org.semanticweb.elk.util.collections.chains.ModifiableLinkImpl;
import org.semanticweb.elk.util.collections.chains.ReferenceFactory;
import org.semanticweb.elk.util.collections.chains.SimpleTypeBasedMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The composition rule producing {@link Contradiction} when processing the
 * negated {@link IndexedClassExpression} of an
 * {@link IndexedObjectComplementOf} if this {@link IndexedObjectComplementOf}
 * is contained in the {@code Context}.
 * 
 * @author "Yevgeny Kazakov"
 */
public class ContradictionFromNegationRule extends
		ModifiableLinkImpl<ChainableRule<IndexedClassExpression>> implements
		ChainableRule<IndexedClassExpression> {

	// logger for events
	private static final Logger LOGGER_ = LoggerFactory
			.getLogger(ContradictionFromNegationRule.class);

	private static final String NAME_ = "ObjectComplementOf Clash";

	private IndexedClassExpression negation_;

	private ContradictionFromNegationRule(
			ChainableRule<IndexedClassExpression> tail) {
		super(tail);

	}

	private ContradictionFromNegationRule(IndexedClassExpression complement) {
		this((ChainableRule<IndexedClassExpression>) null);
		this.negation_ = complement;
	}

	public static void addRulesFor(IndexedObjectComplementOf negation,
			ModifiableOntologyIndex index) {
		index.add(negation.getNegated(), new ContradictionFromNegationRule(
				negation));
	}

	public static void removeRulesFor(IndexedObjectComplementOf negation,
			ModifiableOntologyIndex index) {
		index.remove(negation.getNegated(), new ContradictionFromNegationRule(
				negation));
	}

	@Override
	public String getName() {
		return NAME_;
	}

	// TODO: hide this method
	public IndexedClassExpression getNegation() {
		return negation_;
	}

	@Override
	public void apply(IndexedClassExpression premise, Context context,
			SaturationStateWriter writer) {
		LOGGER_.trace("Applying {} to {}", NAME_, context);

		if (negation_ != null && context.getSubsumers().contains(negation_))
			writer.produce(context, Contradiction.getInstance());
	}

	@Override
	public boolean addTo(Chain<ChainableRule<IndexedClassExpression>> ruleChain) {
		ContradictionFromNegationRule rule = ruleChain.getCreate(MATCHER_,
				FACTORY_);
		boolean changed = false;

		if (negation_ != null && rule.negation_ != negation_) {
			if (rule.negation_ == null)
				rule.negation_ = negation_;
			else
				throw new ElkUnexpectedIndexingException(getName()
						+ " complement value " + rule.negation_
						+ " cannot be overwritten with " + negation_);
			changed = true;
		}

		return changed;

	}

	@Override
	public boolean removeFrom(
			Chain<ChainableRule<IndexedClassExpression>> ruleChain) {
		ContradictionFromNegationRule rule = ruleChain.find(MATCHER_);
		boolean changed = false;

		if (rule != null) {
			if (negation_ != null && rule.negation_ == negation_) {
				rule.negation_ = null;
				changed = true;
			}

			if (rule.isEmpty()) {
				ruleChain.remove(MATCHER_);
			}
		}

		return changed;

	}

	@Override
	public void accept(CompositionRuleVisitor visitor,
			IndexedClassExpression premise, Context context,
			SaturationStateWriter writer) {
		visitor.visit(this, premise, context, writer);
	}

	/**
	 * @return {@code true} if this rule never does anything
	 */
	private boolean isEmpty() {
		return negation_ == null;
	}

	private static final Matcher<ChainableRule<IndexedClassExpression>, ContradictionFromNegationRule> MATCHER_ = new SimpleTypeBasedMatcher<ChainableRule<IndexedClassExpression>, ContradictionFromNegationRule>(
			ContradictionFromNegationRule.class);

	private static final ReferenceFactory<ChainableRule<IndexedClassExpression>, ContradictionFromNegationRule> FACTORY_ = new ReferenceFactory<ChainableRule<IndexedClassExpression>, ContradictionFromNegationRule>() {
		@Override
		public ContradictionFromNegationRule create(
				ChainableRule<IndexedClassExpression> tail) {
			return new ContradictionFromNegationRule(tail);
		}
	};

}