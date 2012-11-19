/**
 * Copyright 2010-2012 Ralph Schaer <ralphschaer@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.ralscha.extdirectspring.generator;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/testApplicationContext.xml")
public class ModelGeneratorBeansWithAssociationTest {

	@Autowired
	private DefaultListableBeanFactory applicationContext;

	@Test
	public void testBook() throws IOException {
		MockHttpServletResponse response = new MockHttpServletResponse();
		ModelGenerator.writeModel(new MockHttpServletRequest(), response, Book.class, OutputFormat.EXTJS4, true);
		GeneratorTestUtil.compareExtJs4Code("Book", response.getContentAsString(), true);

		response = new MockHttpServletResponse();
		ModelGenerator.writeModel(new MockHttpServletRequest(), response, Book.class, OutputFormat.TOUCH2, false);
		GeneratorTestUtil.compareTouch2Code("Book", response.getContentAsString(), false);

		response = new MockHttpServletResponse();
		ModelGenerator.writeModel(new MockHttpServletRequest(), response, Book.class, OutputFormat.EXTJS4, true);
		GeneratorTestUtil.compareExtJs4Code("Book", response.getContentAsString(), true);

		response = new MockHttpServletResponse();
		ModelGenerator.writeModel(new MockHttpServletRequest(), response, Book.class, OutputFormat.TOUCH2, true);
		GeneratorTestUtil.compareTouch2Code("Book", response.getContentAsString(), true);
	}

	@Test
	public void testAuthor() throws IOException {
		MockHttpServletResponse response = new MockHttpServletResponse();
		ModelGenerator.writeModel(new MockHttpServletRequest(), response, Author.class, OutputFormat.EXTJS4, true);
		GeneratorTestUtil.compareExtJs4Code("Author", response.getContentAsString(), true);

		response = new MockHttpServletResponse();
		ModelGenerator.writeModel(new MockHttpServletRequest(), response, Author.class, OutputFormat.TOUCH2, false);
		GeneratorTestUtil.compareTouch2Code("Author", response.getContentAsString(), false);

		response = new MockHttpServletResponse();
		ModelGenerator.writeModel(new MockHttpServletRequest(), response, Author.class, OutputFormat.EXTJS4, true);
		GeneratorTestUtil.compareExtJs4Code("Author", response.getContentAsString(), true);

		response = new MockHttpServletResponse();
		ModelGenerator.writeModel(new MockHttpServletRequest(), response, Author.class, OutputFormat.TOUCH2, true);
		GeneratorTestUtil.compareTouch2Code("Author", response.getContentAsString(), true);
	}

	@Test
	public void testBookWithOneAuthor() throws IOException {
		MockHttpServletResponse response = new MockHttpServletResponse();
		ModelGenerator.writeModel(new MockHttpServletRequest(), response, BookWithOneAuthor.class, OutputFormat.EXTJS4,
				true);
		GeneratorTestUtil.compareExtJs4Code("BookWithOneAuthor", response.getContentAsString(), true);

		response = new MockHttpServletResponse();
		ModelGenerator.writeModel(new MockHttpServletRequest(), response, BookWithOneAuthor.class, OutputFormat.TOUCH2,
				false);
		GeneratorTestUtil.compareTouch2Code("BookWithOneAuthor", response.getContentAsString(), false);

		response = new MockHttpServletResponse();
		ModelGenerator.writeModel(new MockHttpServletRequest(), response, BookWithOneAuthor.class, OutputFormat.EXTJS4,
				true);
		GeneratorTestUtil.compareExtJs4Code("BookWithOneAuthor", response.getContentAsString(), true);

		response = new MockHttpServletResponse();
		ModelGenerator.writeModel(new MockHttpServletRequest(), response, BookWithOneAuthor.class, OutputFormat.TOUCH2,
				true);
		GeneratorTestUtil.compareTouch2Code("BookWithOneAuthor", response.getContentAsString(), true);
	}

}