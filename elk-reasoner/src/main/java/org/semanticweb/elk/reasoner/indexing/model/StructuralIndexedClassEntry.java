package org.semanticweb.elk.reasoner.indexing.model;

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

import org.semanticweb.elk.util.collections.entryset.Entry;

/**
 * A {@link ModifiableIndexedClass} with structural comparison and
 * which can be linked to each other.
 * 
 * @param <T>
 *            The type of structured objects this object can be compared with
 * 
 * @author "Yevgeny Kazakov"
 */
public interface StructuralIndexedClassEntry<T extends StructuralIndexedClassEntry<T>>
		extends ModifiableIndexedClass, StructuralIndexedSubObject<T>,
		Entry<StructuralIndexedClassEntry<?>> {

	/**
	 * The visitor pattern for instances
	 * 
	 * @author Yevgeny Kazakov
	 * 
	 * @param <O>
	 *            the type of the output
	 */
	interface Visitor<O> {

		<T extends StructuralIndexedClassEntry<T>> O visit(T element);

	}

}
