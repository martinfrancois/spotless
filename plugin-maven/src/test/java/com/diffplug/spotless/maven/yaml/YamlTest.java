/*
 * Copyright 2023 DiffPlug
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.diffplug.spotless.maven.yaml;

import org.junit.jupiter.api.Test;

import com.diffplug.spotless.maven.MavenIntegrationHarness;

public class YamlTest extends MavenIntegrationHarness {
	@Test
	public void testFormatYaml_WithJackson_defaultConfig_separatorComments() throws Exception {
		writePomWithJsonSteps("<yaml><jackson/></yaml>");

		setFile("yaml_test.json").toResource("yaml/separator_comments.yaml");
		mavenRunner().withArguments("spotless:apply").runNoError().error();
		assertFile("yaml_test.json").sameAsResource("yaml/separator_comments.clean.yaml");
	}

	@Test
	public void testFormatYaml_WithJackson_defaultConfig_arrayBrackets() throws Exception {
		writePomWithJsonSteps("<yaml><jackson/></yaml>");

		setFile("yaml_test.json").toResource("yaml/array_with_bracket.yaml");
		mavenRunner().withArguments("spotless:apply").runNoError().error();
		assertFile("yaml_test.json").sameAsResource("yaml/array_with_bracket.clean.yaml");
	}

	@Test
	public void testFormatYaml_WithJackson_defaultConfig_multipleComments() throws Exception {
		writePomWithJsonSteps("<yaml><jackson/></yaml>");

		setFile("yaml_test.json").toResource("yaml/multiple_documents.yaml");
		mavenRunner().withArguments("spotless:apply").runNoError().error();
		assertFile("yaml_test.json").sameAsResource("yaml/multiple_documents.clean.yaml");
	}
}
