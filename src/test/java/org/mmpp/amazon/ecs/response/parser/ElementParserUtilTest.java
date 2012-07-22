package org.mmpp.amazon.ecs.response.parser;

import static org.junit.Assert.*;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.mmpp.amazon.ecs.response.parser.ElementParserUtil;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

public class ElementParserUtilTest {

	@Test
	public void testReadElementTextContentElementString() throws DOMException, ParserConfigurationException {
		Element element = createElement("Attribute");
		String value = ElementParserUtil.readElementTextContent(element,"Hoge");
		assertNull(value);
	}

	@Test
	public void testReadElementTextContentElement() throws DOMException, ParserConfigurationException {
		Element element = createElement("Attribute");
		String value = ElementParserUtil.readElementTextContent(element);
		assertEquals("",value);
	}

	
	private Element createElement(String tagName) throws DOMException, ParserConfigurationException {
		return ElementUtil.createElement(tagName);
	}

}
