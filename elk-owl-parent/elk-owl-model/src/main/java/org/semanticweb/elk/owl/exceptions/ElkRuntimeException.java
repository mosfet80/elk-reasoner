/*
 * #%L
 * ELK OWL Object Interfaces
 * 
 * $Id$
 * $HeadURL$
 * %%
 * Copyright (C) 2011 - 2012 Department of Computer Science, University of Oxford
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
package org.semanticweb.elk.owl.exceptions;

/**
 * The top level ELK runtime exception
 * 
 * @author "Yevgeny Kazakov"
 * 
 */
public class ElkRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3395450547234499302L;

	/**
	 * 
	 */
	public ElkRuntimeException() {
		super();
	}

	/**
	 */
	public ElkRuntimeException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	public ElkRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 */
	public ElkRuntimeException(Throwable cause) {
		super(cause);
	}

}