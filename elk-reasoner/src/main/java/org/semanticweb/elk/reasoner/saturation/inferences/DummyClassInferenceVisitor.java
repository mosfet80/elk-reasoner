/**
 * 
 */
package org.semanticweb.elk.reasoner.saturation.inferences;

/*
 * #%L
 * ELK Reasoner
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2011 - 2015 Department of Computer Science, University of Oxford
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

/**
 * A {@link ClassInference.Visitor} that returns {@code null}, can be used as a
 * prototype of other visitors by overriding default methods or or other visit
 * methods
 * 
 * @author Pavel Klinov
 * 
 *         pavel.klinov@uni-ulm.de
 * 
 * @author Yevgeny Kazakov
 * 
 * @param <O>
 *            the type of the output
 */
public class DummyClassInferenceVisitor<O>
		implements
			ClassInference.Visitor<O> {

	/**
	 * @param inference
	 *            the visited {@link ClassInference}
	 * @return the output of the visitor ({@code null} by default)
	 */
	protected O defaultVisit(ClassInference inference) {
		return null;
	}

	protected O defaultVisit(SubClassInference inference) {
		return defaultVisit((ClassInference) inference);
	}

	@Override
	public O visit(BackwardLinkComposition inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(BackwardLinkOfObjectHasSelf inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(BackwardLinkOfObjectSomeValuesFrom inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(BackwardLinkReversedExpanded inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(ClassInconsistencyOfDisjointSubsumers inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(ClassInconsistencyOfObjectComplementOf inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(ClassInconsistencyOfOwlNothing inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(ClassInconsistencyPropagated inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(ContextInitializationNoPremises inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(DisjointSubsumerFromSubsumer inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(ForwardLinkComposition inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(ForwardLinkOfObjectHasSelf inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(ForwardLinkOfObjectSomeValuesFrom inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(PropagationGenerated inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(SubClassInclusionComposedDefinedClass inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(SubClassInclusionComposedOfDecomposed inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(SubClassInclusionComposedObjectIntersectionOf inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(SubClassInclusionComposedObjectSomeValuesFrom inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(SubClassInclusionComposedObjectUnionOf inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(SubClassInclusionDecomposedFirstConjunct inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(SubClassInclusionDecomposedSecondConjunct inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(SubClassInclusionExpandedDefinition inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(SubClassInclusionExpandedFirstEquivalentClass inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(SubClassInclusionExpandedSecondEquivalentClass inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(SubClassInclusionExpandedSubClassOf inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(SubClassInclusionObjectHasSelfPropertyRange inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(SubClassInclusionOwlThing inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(SubClassInclusionRange inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(SubClassInclusionTautology inference) {
		return defaultVisit(inference);
	}

	@Override
	public O visit(SubContextInitializationNoPremises inference) {
		return defaultVisit(inference);
	}

}
