package org.semanticweb.elk.reasoner.indexing.caching;

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

import java.util.List;

import org.semanticweb.elk.reasoner.indexing.modifiable.ModifiableIndexedClassExpression;
import org.semanticweb.elk.reasoner.indexing.modifiable.ModifiableIndexedDisjointClassesAxiom;

/**
 * A {@link ModifiableIndexedDisjointClassesAxiom} that can be used for
 * memoization (caching).
 * 
 * @author "Yevgeny Kazakov"
 *
 * @param <T>
 *            the type of the {@link CachedIndexedDisjointClassesAxiom}
 */
public interface CachedIndexedDisjointClassesAxiom extends
		ModifiableIndexedDisjointClassesAxiom,
		CachedIndexedAxiom<CachedIndexedDisjointClassesAxiom> {

	static class Helper extends CachedIndexedObject.Helper {

		public static int structuralHashCode(
				List<? extends ModifiableIndexedClassExpression> members) {
			return combinedHashCode(CachedIndexedDisjointClassesAxiom.class,
					combinedHashCode(members));
		}

		public static CachedIndexedDisjointClassesAxiom structuralEquals(
				CachedIndexedDisjointClassesAxiom first, Object second) {
			if (first == second) {
				return first;
			}
			if (second instanceof CachedIndexedDisjointClassesAxiom) {
				CachedIndexedDisjointClassesAxiom secondEntry = (CachedIndexedDisjointClassesAxiom) second;
				if (first.getMembers().equals(secondEntry.getMembers()))
					return secondEntry;
			}
			// else
			return null;
		}

	}

}
