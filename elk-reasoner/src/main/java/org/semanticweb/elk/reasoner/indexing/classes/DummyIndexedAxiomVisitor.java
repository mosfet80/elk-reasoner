package org.semanticweb.elk.reasoner.indexing.classes;

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

import org.semanticweb.elk.reasoner.indexing.model.IndexedAxiom;
import org.semanticweb.elk.reasoner.indexing.model.IndexedDeclarationAxiom;
import org.semanticweb.elk.reasoner.indexing.model.IndexedEquivalentClassesAxiom;
import org.semanticweb.elk.reasoner.indexing.model.IndexedDisjointClassesAxiom;
import org.semanticweb.elk.reasoner.indexing.model.IndexedObjectPropertyRangeAxiom;
import org.semanticweb.elk.reasoner.indexing.model.IndexedSubClassOfAxiom;
import org.semanticweb.elk.reasoner.indexing.model.IndexedSubObjectPropertyOfAxiom;

/**
 * An {@link IndexedAxiom.Visitor} that always returns {@code null}.
 * 
 * @author "Yevgeny Kazakov"
 *
 * @param <O>
 *            the type of the output
 */
public class DummyIndexedAxiomVisitor<O> implements IndexedAxiom.Visitor<O> {

	@SuppressWarnings("unused")
	protected O defaultVisit(IndexedAxiom axiom) {
		return null;
	}

	@Override
	public O visit(IndexedDeclarationAxiom axiom) {
		return defaultVisit(axiom);
	}

	@Override
	public O visit(IndexedEquivalentClassesAxiom axiom) {
		return defaultVisit(axiom);
	}

	@Override
	public O visit(IndexedDisjointClassesAxiom axiom) {
		return defaultVisit(axiom);
	}

	@Override
	public O visit(IndexedObjectPropertyRangeAxiom axiom) {
		return defaultVisit(axiom);
	}

	@Override
	public O visit(IndexedSubClassOfAxiom axiom) {
		return defaultVisit(axiom);
	}

	@Override
	public O visit(IndexedSubObjectPropertyOfAxiom axiom) {
		return defaultVisit(axiom);
	}

}
