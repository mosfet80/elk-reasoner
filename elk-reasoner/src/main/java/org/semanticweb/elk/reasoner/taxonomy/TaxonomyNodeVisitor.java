/**
 * 
 */
package org.semanticweb.elk.reasoner.taxonomy;
/*
 * #%L
 * ELK Reasoner
 * $Id:$
 * $HeadURL:$
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

import java.util.List;

import org.semanticweb.elk.owl.interfaces.ElkEntity;
import org.semanticweb.elk.reasoner.taxonomy.model.TaxonomyNode;


/**
 * @author Pavel Klinov
 *
 * pavel.klinov@uni-ulm.de
 * 
 * @param <T>
 *            the type of objects stored in the nodes 
 */
public interface TaxonomyNodeVisitor<T extends ElkEntity> {

	public void visit(TaxonomyNode<T> node, List<TaxonomyNode<T>> pathFromStart);
}
