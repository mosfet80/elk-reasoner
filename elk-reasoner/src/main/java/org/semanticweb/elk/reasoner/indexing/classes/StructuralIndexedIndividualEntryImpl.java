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
package org.semanticweb.elk.reasoner.indexing.classes;

import org.semanticweb.elk.owl.interfaces.ElkNamedIndividual;
import org.semanticweb.elk.reasoner.indexing.model.IndexedClassEntity;
import org.semanticweb.elk.reasoner.indexing.model.IndexedEntity;
import org.semanticweb.elk.reasoner.indexing.model.StructuralIndexedIndividualEntry;
import org.semanticweb.elk.reasoner.indexing.model.StructuralIndexedSubObject;
import org.semanticweb.elk.util.hashing.HashGenerator;

/**
 * Implements {@link StructuralIndexedIndividualEntry}
 * 
 * @author Frantisek Simancik
 * @author "Yevgeny Kazakov"
 */
class StructuralIndexedIndividualEntryImpl extends
		ModifiableIndexedClassEntityImpl<StructuralIndexedIndividualEntryImpl, StructuralIndexedIndividualEntry<?>>
		implements
		StructuralIndexedIndividualEntry<StructuralIndexedIndividualEntryImpl> {

	/**
	 * The represented {@link ElkNamedIndividual}
	 */
	private final ElkNamedIndividual elkEntity_;

	StructuralIndexedIndividualEntryImpl(ElkNamedIndividual elkEntity) {
		super(structuralHashCode(elkEntity));
		this.elkEntity_ = elkEntity;
	}

	@Override
	public ElkNamedIndividual getElkEntity() {
		return elkEntity_;
	}

	static int structuralHashCode(ElkNamedIndividual elkEntity) {
		return HashGenerator.combinedHashCode(StructuralIndexedIndividualEntryImpl.class,
				elkEntity.getIri());
	}

	@Override
	public StructuralIndexedIndividualEntryImpl structuralEquals(Object other) {
		if (this == other) {
			return this;
		}
		if (other instanceof StructuralIndexedIndividualEntryImpl) {
			StructuralIndexedIndividualEntryImpl secondEntry = (StructuralIndexedIndividualEntryImpl) other;
			if (getElkEntity().getIri()
					.equals(secondEntry.getElkEntity().getIri()))
				return secondEntry;
		}
		// else
		return null;
	}

	@Override
	public final <O> O accept(IndexedClassEntity.Visitor<O> visitor) {
		return visitor.visit(this);
	}

	@Override
	public final <O> O accept(IndexedEntity.Visitor<O> visitor) {
		return visitor.visit(this);
	}

	@Override
	public <O> O accept(StructuralIndexedSubObject.Visitor<O> visitor) {
		return visitor.visit(this);
	}

}