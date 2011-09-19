/*
 * #%L
 * elk-reasoner
 * 
 * $Id: ElkDataSomeValuesFrom.java 295 2011-08-10 11:43:29Z mak@aifb.uni-karlsruhe.de $
 * $HeadURL: https://elk-reasoner.googlecode.com/svn/trunk/elk-reasoner/src/main/java/org/semanticweb/elk/syntax/interfaces/ElkDataSomeValuesFrom.java $
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
/**
 * @author Markus Kroetzsch, Aug 8, 2011
 */
package org.semanticweb.elk.owl.interfaces;

/**
 * Corresponds to an <a href=
 * "http://www.w3.org/TR/owl2-syntax/#Data_Property_Domain">Data Property
 * Domain<a> in the OWL 2 specification.
 * 
 * @author Markus Kroetzsch
 */
public interface ElkDataPropertyDomainAxiom extends ElkDataPropertyAxiom {

	/**
	 * Get the data property expression that this axiom refers to.
	 * 
	 * @return data property expression
	 */
	public ElkDataPropertyExpression getDataPropertyExpression();

	/**
	 * Get the data range that this axiom refers to.
	 * 
	 * @return data range
	 */
	public ElkDataRange getDataRange();

}