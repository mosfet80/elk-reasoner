/**
 * 
 */
package org.semanticweb.elk.owl.parsing.javacc;
/*
 * #%L
 * ELK OWL JavaCC Parser
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

/**
 * @author Pavel Klinov
 *
 *         pavel.klinov@uni-ulm.de
 * @param <T>
 *            the type of the lexer created by this factory
 */
public interface JavaCCLexerFactory<T> {

	/**
	 * 
	 * @param nativeLexer The lexer which has physical access to the input stream of characters
	 * @return a JavaCC warpper lexer
	 */
	public T createLexer(T nativeLexer);
}
