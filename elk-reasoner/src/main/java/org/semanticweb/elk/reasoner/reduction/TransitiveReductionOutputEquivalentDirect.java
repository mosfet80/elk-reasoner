/*
 * #%L
 * ELK Reasoner
 * 
 * $Id$
 * $HeadURL$
 * %%
 * Copyright (C) 2011 Department of Computer Science, University of Oxford
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
package org.semanticweb.elk.reasoner.reduction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.semanticweb.elk.owl.interfaces.ElkClass;
import org.semanticweb.elk.reasoner.indexing.model.IndexedClassExpression;

/**
 * The result of the transitive reduction for a satisfiable
 * {@link IndexedClassExpression}; it contains information about its equivalent
 * classes and direct subsumers.
 * 
 * @author "Yevgeny Kazakov"
 * 
 * @param <R>
 *            the type of the root {@link IndexedClassExpression}s of the
 *            {@link TransitiveReductionJob}s for which this output is computed
 * 
 * @see TransitiveReductionJob
 */
public class TransitiveReductionOutputEquivalentDirect<R extends IndexedClassExpression>
		extends TransitiveReductionOutputEquivalent<R> {

	final List<List<ElkClass>> directSubsumers;

	public TransitiveReductionOutputEquivalentDirect(R root,
			List<ElkClass> equivalent) {
		super(root, equivalent);
		this.directSubsumers = new ArrayList<List<ElkClass>>();
	}

	/**
	 * Returns the list of partial outputs of transitive reduction, containing
	 * equivalent classes of direct, i.e., transitively reduced, subsumers of
	 * the root.
	 * 
	 * @return the list consisting of partial output of transitive reduction for
	 *         direct subsumers of the root
	 */
	public Collection<? extends List<ElkClass>> getDirectSubsumers() {
		return directSubsumers;
	}

	@Override
	public void accept(TransitiveReductionOutputVisitor<R> visitor) {
		visitor.visit(this);
	}

}
