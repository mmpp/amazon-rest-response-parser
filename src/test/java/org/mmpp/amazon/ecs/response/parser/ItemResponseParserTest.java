package org.mmpp.amazon.ecs.response.parser;

import static org.junit.Assert.*;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.mmpp.amazon.ecs.response.model.AbstractResponse;
import org.mmpp.amazon.ecs.response.parser.ItemResponseParser;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

public class ItemResponseParserTest {

	@Test
	public void testParseElement() throws DOMException, ParserConfigurationException {
		Element element = createElement("Hoge");
		AbstractResponse response = new ItemResponseParser().parse(element);
		assertNull(response);
	}
	
	private Element createElement(String tagName) throws DOMException, ParserConfigurationException {
		return ElementUtil.createElement(tagName);
	}

}
