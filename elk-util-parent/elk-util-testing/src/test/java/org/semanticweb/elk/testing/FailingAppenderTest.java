package org.semanticweb.elk.testing;

/*-
 * #%L
 * ELK Utilities for Testing
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2011 - 2024 Department of Computer Science, University of Oxford
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

import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FailingAppenderTest {

	// logger for this class
	private static final Logger LOGGER_ = LoggerFactory
			.getLogger(FailingAppenderTest.class);

	@Test
	public void testLogError() {
		assertThrows("Logg errors should fail tests", AssertionError.class,
				() -> LOGGER_.error("Test error message"));
	}

}
