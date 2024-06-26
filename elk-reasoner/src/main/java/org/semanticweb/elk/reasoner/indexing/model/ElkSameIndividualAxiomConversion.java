package org.semanticweb.elk.reasoner.indexing.model;

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

import org.semanticweb.elk.owl.interfaces.ElkIndividual;
import org.semanticweb.elk.owl.interfaces.ElkSameIndividualAxiom;

/**
 * Represents a transformation of an {@link ElkSameIndividualAxiom} to an
 * {@link IndexedSubClassOfAxiom} representing inclusion between two selected
 * {@link ElkIndividual} members of {@link ElkSameIndividualAxiom}.
 * 
 * @see ElkSameIndividualAxiom#getIndividuals()
 * 
 * @author Yevgeny Kazakov
 */
public interface ElkSameIndividualAxiomConversion
		extends
			IndexedSubClassOfAxiomInference {

	@Override
	ElkSameIndividualAxiom getOriginalAxiom();

	/**
	 * @return the position of an {@link ElkIndividual} in the member list of
	 *         the {@link ElkSameIndividualAxiom} that is converted to the
	 *         sub-class of the {@link IndexedSubClassOfAxiom}.
	 * 
	 * @see ElkSameIndividualAxiom#getIndividuals()
	 * @see IndexedSubClassOfAxiom#getSubClass()
	 */
	int getSubIndividualPosition();

	/**
	 * @return the position of an {@link ElkIndividual} in the member list of
	 *         the {@link ElkSameIndividualAxiom} that is converted to the
	 *         super-class of the {@link IndexedSubClassOfAxiom}.
	 * 
	 * @see ElkSameIndividualAxiom#getIndividuals()
	 * @see IndexedSubClassOfAxiom#getSuperClass()
	 */
	int getSuperIndividualPosition();

	/**
	 * The visitor pattern for instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 * @param <O>
	 *            the type of the output
	 */
	interface Visitor<O> {

		O visit(ElkSameIndividualAxiomConversion inference);

	}

}
