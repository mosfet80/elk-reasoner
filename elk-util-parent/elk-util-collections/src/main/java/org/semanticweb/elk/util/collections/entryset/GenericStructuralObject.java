package org.semanticweb.elk.util.collections.entryset;

/*-
 * #%L
 * ELK Utilities Collections
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

/**
 * A generic version of {@link StructuralObject} that can be used to define
 * different types of the structural objects. This allows a more specific
 * conversion of structurally equal objects to the required types.
 * 
 * @author Yevgeny Kazakov
 *
 * @param <T>
 *            the type of the structural object
 */
public interface GenericStructuralObject<T extends GenericStructuralObject<T>>
		extends StructuralObject {

	@Override
	T structuralEquals(Object other);

}
