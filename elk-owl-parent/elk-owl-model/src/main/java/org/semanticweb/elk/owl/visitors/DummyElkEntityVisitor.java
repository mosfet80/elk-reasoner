package org.semanticweb.elk.owl.visitors;

/*
 * #%L
 * ELK OWL Object Interfaces
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

import org.semanticweb.elk.owl.interfaces.ElkEntity;

/**
 * An {@link ElkEntityVisitor} that does not do anything and returns
 * {@code null}
 * 
 * @author "Yevgeny Kazakov"
 *
 * @param <O>
 *            the output type of the visitor
 */
public class DummyElkEntityVisitor<O> extends AbstractElkEntityVisitor<O> {

	@Override
	protected O defaultVisit(ElkEntity entity) {
		// no-op
		return null;
	}

}
