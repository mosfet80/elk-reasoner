package org.semanticweb.elk.reasoner.saturation.rules;

/*
 * #%L
 * ELK Reasoner
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2011 - 2016 Department of Computer Science, University of Oxford
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

import org.semanticweb.elk.reasoner.saturation.inferences.ClassInference;

/**
 * An object using which {@link ClassInference}s can be produced
 * 
 * @author "Yevgeny Kazakov"
 * 
 */
public interface ClassInferenceProducer {

	/**
	 * Produces a new {@link ClassInference}.
	 * 
	 * @param inference
	 *            the {@link ClassInference} to be produced
	 */
	public void produce(ClassInference inference);

}
