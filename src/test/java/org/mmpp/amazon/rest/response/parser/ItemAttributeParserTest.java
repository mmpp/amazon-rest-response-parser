package org.mmpp.amazon.rest.response.parser;

import static org.junit.Assert.*;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.mmpp.amazon.rest.response.model.Author;
import org.mmpp.amazon.rest.response.model.ItemAttribute;
import org.mmpp.amazon.rest.response.model.Manufacturer;
import org.mmpp.amazon.rest.response.parser.ElementUtil;
import org.mmpp.amazon.rest.response.parser.ItemAttributeParser;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

public class ItemAttributeParserTest {

	@Test
	public void testParseAuthor() throws DOMException, ParserConfigurationException {
		org.w3c.dom.Element elementAuthor = createElement("Author");
		elementAuthor.setTextContent("名前");
		ItemAttributeParser parser = new ItemAttributeParser();
		ItemAttribute itemAttribute = parser.parse(elementAuthor);
		assertTrue(itemAttribute instanceof Author);
		Author author = (Author)itemAttribute;
		assertEquals("名前",author.getName());
	}
	@Test
	public void testParseManufacturer() throws DOMException, ParserConfigurationException {
		org.w3c.dom.Element elementAuthor = createElement("Manufacturer");
		elementAuthor.setTextContent("名前");
		ItemAttributeParser parser = new ItemAttributeParser();
		ItemAttribute itemAttribute = parser.parse(elementAuthor);
		assertTrue(itemAttribute instanceof Manufacturer);
		Manufacturer manufacturer = (Manufacturer)itemAttribute;
		assertEquals("名前",manufacturer.getName());
	}

	@Test
	public void testParseNull() throws DOMException, ParserConfigurationException {
		org.w3c.dom.Element elementAuthor = createElement("名前");
		elementAuthor.setTextContent("名前");
		ItemAttributeParser parser = new ItemAttributeParser();
		ItemAttribute itemAttribute = parser.parse(elementAuthor);
		assertNull(itemAttribute);
	}
	private Element createElement(String tagName) throws DOMException, ParserConfigurationException {
		return ElementUtil.createElement(tagName);
	}


}
