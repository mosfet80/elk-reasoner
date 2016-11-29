package org.semanticweb.elk.owl.inferences.rewriting;

/*-
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.liveontologies.proof.util.ProofNode;
import org.liveontologies.proof.util.ProofStep;
import org.semanticweb.elk.owl.inferences.ElkClassInclusionHierarchy;
import org.semanticweb.elk.owl.inferences.ElkInference;
import org.semanticweb.elk.owl.interfaces.ElkAxiom;
import org.semanticweb.elk.owl.interfaces.ElkClassExpression;

/**
 * A transformation that rewrites nested {@link ElkClassInclusionHierarchy}
 * inferences into one {@link ElkClassInclusionHierarchy} inference.
 * 
 * For example the sequence of inferences
 * 
 * <pre>
 *       B ⊑ C    C ⊑ D
 *       ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
 * A ⊑ B     B ⊑ D
 * ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
 *       A ⊑ D
 * </pre>
 *
 * is replaced with one inference
 * 
 * <pre>
 * A ⊑ B   B ⊑ C   C ⊑ D
 * ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
 *         A ⊑ D
 * </pre>
 * 
 * The replacement is done provided there is only one inference deriving each
 * premise of the inference and it is {@link ElkClassInclusionHierarchy}.
 * 
 * @author Yevgeny Kazakov
 */
class ElkClassInclusionHierarchyFlattener implements ElkInferenceFlattener {

	/**
	 * the inference to be rewritten
	 */
	private final ElkClassInclusionHierarchy inference_;

	/**
	 * the factory for creating rewritten inferences
	 */
	private final ElkInference.Factory factory_;

	/**
	 * a temporary list to accumulate the parameters of the resulting
	 * {@link ElkClassInclusionHierarchy} inference
	 */
	private List<ElkClassExpression> classExpressions_;

	ElkClassInclusionHierarchyFlattener(ElkClassInclusionHierarchy inference,
			ElkInference.Factory factory) {
		this.inference_ = inference;
		this.factory_ = factory;
	}

	@Override
	public boolean flatten(ProofStep<ElkAxiom> step) {
		classExpressions_ = new ArrayList<ElkClassExpression>();
		flatten(inference_, step);
		List<? extends ElkClassExpression> expressions = inference_
				.getExpressions();
		classExpressions_.add(expressions.get(expressions.size() - 1));
		factory_.getElkClassInclusionHierarchy(classExpressions_);
		return true;
	}

	/**
	 * Perform the transformation for the inference using the proof step to
	 * which it corresponds
	 * 
	 * @param inf
	 * @param step
	 */
	void flatten(ElkClassInclusionHierarchy inf, ProofStep<ElkAxiom> step) {
		List<? extends ElkClassExpression> expressions = inf.getExpressions();
		List<? extends ProofNode<ElkAxiom>> premises = step.getPremises();
		for (int i = 0; i < premises.size(); i++) {
			if (!flatten(premises.get(i))) {
				// inferences for the premise cannot be flattened
				classExpressions_.add(expressions.get(i));
			}
		}
	}

	boolean flatten(ProofNode<ElkAxiom> node) {
		Collection<? extends ProofStep<ElkAxiom>> steps = node.getInferences();
		if (steps.size() > 1) {
			// don't expand multiple inferences
			return false;
		}
		for (ProofStep<ElkAxiom> step : steps) {
			ElkInference inf = FlattenedElkInferenceSet.getInference(step);
			if (inf instanceof ElkClassInclusionHierarchy) {
				flatten((ElkClassInclusionHierarchy) inf, step);
				return true;
			}
		}
		// else
		return false;
	}

}
