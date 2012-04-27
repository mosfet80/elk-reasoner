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
package org.semanticweb.elk.reasoner.taxonomy;

import java.util.Set;

import org.semanticweb.elk.owl.interfaces.ElkClass;

public interface ClassNode {

	/**
	 * Get an unmodifiable set of ElkClass objects that this ClassNode
	 * represents.
	 * 
	 * @return collection of equivalent ElkClass objects
	 */
	public Set<ElkClass> getMembers();

	/**
	 * Get one ElkClass object to canonically represent the classes in this
	 * ClassNode. It is guaranteed that the least object is the least one
	 * according to the ordering defined by PredefinedElkIri.compare().
	 * 
	 * @return canonical ElkClass object
	 */
	public ElkClass getCanonicalMember();

	/**
	 * Get an unmodifiable set of nodes for ElkClass objects that are direct
	 * sub-classes of this ClassNode.
	 * 
	 * @return list of nodes for direct super-classes of this node members
	 */
	public Set<ClassNode> getDirectSuperNodes();

	/**
	 * Computes an unmodifiable set of nodes for ElkClass objects that are
	 * (possibly indirect) super-classes of members of this ClassNode. This is
	 * the smallest set of nodes that contains all direct super-nodes of this
	 * node, and all direct super-nodes of every node in this set.
	 * 
	 * @return set of nodes for sub-classes of this node members
	 */
	public Set<ClassNode> getAllSuperNodes();

	/**
	 * Get an unmodifiable set of nodes for ElkClass objects that are direct
	 * sub-classes of this ClassNode.
	 * 
	 * @return list of nodes for direct sub-classes of this node members
	 */
	public Set<ClassNode> getDirectSubNodes();

	/**
	 * Computes an unmodifiable set of nodes for ElkClass objects that are
	 * (possibly indirect) sub-classes of members of this ClassNode. This is the
	 * smallest set of nodes that contains all direct sub-nodes of this node,
	 * and all direct sub-nodes of every node in this set.
	 * 
	 * @return set of nodes for sub-classes of this node members
	 */
	public Set<ClassNode> getAllSubNodes();

	/**
	 * Returns the class taxonomy to which this node belongs.
	 * 
	 * @return the class taxonomy to which this node belongs
	 */
	public ClassTaxonomy getTaxonomy();
}