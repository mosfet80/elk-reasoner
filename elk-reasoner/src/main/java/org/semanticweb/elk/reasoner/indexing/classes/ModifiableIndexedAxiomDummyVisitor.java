package org.semanticweb.elk.reasoner.indexing.classes;

/*-
 * #%L
 * ELK Reasoner Core
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2011 - 2017 Department of Computer Science, University of Oxford
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

import org.semanticweb.elk.reasoner.indexing.model.ModifiableIndexedAxiom;
import org.semanticweb.elk.reasoner.indexing.model.ModifiableIndexedDeclarationAxiom;
import org.semanticweb.elk.reasoner.indexing.model.ModifiableIndexedDisjointClassesAxiom;
import org.semanticweb.elk.reasoner.indexing.model.ModifiableIndexedEquivalentClassesAxiom;
import org.semanticweb.elk.reasoner.indexing.model.ModifiableIndexedObjectPropertyRangeAxiom;
import org.semanticweb.elk.reasoner.indexing.model.ModifiableIndexedSubClassOfAxiom;
import org.semanticweb.elk.reasoner.indexing.model.ModifiableIndexedSubObjectPropertyOfAxiom;

/**
 * A {@link ModifiableIndexedAxiom.Visitor} that always returns {@code null}
 * 
 * @author Yevgeny Kazakov
 *
 * @param <O>
 *            the type of the output
 */
public class ModifiableIndexedAxiomDummyVisitor<O>
		implements ModifiableIndexedAxiom.Visitor<O> {

	@SuppressWarnings("unused")
	protected O defaultVisit(ModifiableIndexedAxiom axiom) {
		return null;
	}

	@Override
	public O visit(ModifiableIndexedDisjointClassesAxiom axiom) {
		return defaultVisit(axiom);
	}

	@Override
	public O visit(ModifiableIndexedSubClassOfAxiom axiom) {
		return defaultVisit(axiom);
	}

	@Override
	public O visit(ModifiableIndexedEquivalentClassesAxiom axiom) {
		return defaultVisit(axiom);
	}

	@Override
	public O visit(ModifiableIndexedSubObjectPropertyOfAxiom axiom) {
		return defaultVisit(axiom);
	}

	@Override
	public O visit(ModifiableIndexedObjectPropertyRangeAxiom axiom) {
		return defaultVisit(axiom);
	}

	@Override
	public O visit(ModifiableIndexedDeclarationAxiom axiom) {
		return defaultVisit(axiom);
	}

}
