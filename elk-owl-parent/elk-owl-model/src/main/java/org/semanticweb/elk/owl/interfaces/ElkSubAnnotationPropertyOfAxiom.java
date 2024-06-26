/*
 * #%L
 * elk-reasoner
 * 
 * $Id: ElkSubObjectPropertyOfAxiom.java 295 2011-08-10 11:43:29Z mak@aifb.uni-karlsruhe.de $
 * $HeadURL: https://elk-reasoner.googlecode.com/svn/trunk/elk-reasoner/src/main/java/org/semanticweb/elk/syntax/interfaces/ElkSubObjectPropertyOfAxiom.java $
 * %%
 * Copyright (C) 2011 Oxford University Computing Laboratory
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
package org.semanticweb.elk.owl.interfaces;

import org.semanticweb.elk.owl.visitors.ElkSubAnnotationPropertyOfAxiomVisitor;

/**
 * Corresponds to an
 * <a href= "http://www.w3.org/TR/owl2-syntax/#Annotation_Subproperties">
 * Annotation Subproperty Axiom</a> in the OWL 2 specification.
 * 
 * @author Frantisek Simancik
 *
 */
public interface ElkSubAnnotationPropertyOfAxiom extends ElkAnnotationAxiom {

	/**
	 * Get the sub annotation property of this axiom.
	 * 
	 * @return sub annotation property
	 */
	public ElkAnnotationProperty getSubAnnotationProperty();

	/**
	 * Get the super annotation property of this axiom.
	 * 
	 * @return super annotation property
	 */
	public ElkAnnotationProperty getSuperAnnotationProperty();

	/**
	 * Accept an {@link ElkSubAnnotationPropertyOfAxiomVisitor}.
	 * 
	 * @param visitor
	 *            the visitor that can work with this axiom type
	 * @param <O>
	 *            the type of the output of the visitor
	 * @return the output of the visitor
	 */
	public <O> O accept(ElkSubAnnotationPropertyOfAxiomVisitor<O> visitor);

	/**
	 * A factory for creating instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 */
	interface Factory {

		/**
		 * Create an {@link ElkSubAnnotationPropertyOfAxiom}
		 * 
		 * @param subProperty
		 *            the sub-{@link ElkAnnotationProperty} for which the object
		 *            should be created
		 * @param superProperty
		 *            the super-{@link ElkAnnotationProperty} for which the
		 *            object should be created
		 * @return an {@link ElkSubAnnotationPropertyOfAxiom} corresponding to
		 *         the input
		 */
		public ElkSubAnnotationPropertyOfAxiom getSubAnnotationPropertyOfAxiom(
				ElkAnnotationProperty subProperty,
				ElkAnnotationProperty superProperty);
	}

}
