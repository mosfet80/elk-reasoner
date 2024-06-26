package org.semanticweb.elk.reasoner.saturation.rules.subsumers;

/*-
 * #%L
 * ELK Reasoner Core
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2011 - 2021 Department of Computer Science, University of Oxford
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

import org.semanticweb.elk.owl.predefined.PredefinedElkIris;
import org.semanticweb.elk.reasoner.indexing.model.IndexedPredefinedClass;
import org.semanticweb.elk.reasoner.saturation.context.ContextPremises;
import org.semanticweb.elk.reasoner.saturation.inferences.ClassInconsistencyOfOwlNothing;
import org.semanticweb.elk.reasoner.saturation.rules.ClassInferenceProducer;

/**
 * 
 * TODO
 * 
 * @author "Yevgeny Kazakov"
 * 
 */
public class OwlNothingDecompositionRule extends
		AbstractSubsumerDecompositionRule<IndexedPredefinedClass> {

	public static final String NAME = "owl:Nothing Decomposition";

	private static OwlNothingDecompositionRule INSTANCE_ = new OwlNothingDecompositionRule();

	public static OwlNothingDecompositionRule getInstance() {
		return INSTANCE_;
	}

	@Override
	public String toString() {
		return NAME;
	}

	@Override
	public void apply(IndexedPredefinedClass premise,
			ContextPremises premises, ClassInferenceProducer producer) {
		if (premise.getElkEntity().getIri()
				.equals(PredefinedElkIris.OWL_NOTHING)) {
			producer.produce(new ClassInconsistencyOfOwlNothing(
					premises.getRoot(), premise));
		}
	}

	@Override
	public boolean isTracingRule() {
		return true;
	}

	@Override
	public void accept(SubsumerDecompositionRuleVisitor<?> visitor,
			IndexedPredefinedClass premise, ContextPremises premises,
			ClassInferenceProducer producer) {
		visitor.visit(this, premise, premises, producer);

	}

}
