package org.mmpp.amazon.rest.response.parser;

import java.util.List;

import org.mmpp.amazon.rest.response.model.ItemLink;
import org.w3c.dom.Element;

public class ItemLinksParser extends AbstractElementParser<java.util.List<ItemLink>> {

	@Override
	public List<ItemLink> parse(Element element) {
		java.util.List<ItemLink> itemLinks  = new java.util.LinkedList<ItemLink>();
		org.w3c.dom.NodeList items = element.getElementsByTagName("ItemLink");
		for(int i = 0 ; i < items.getLength() ; i ++ ) {
			ItemLink itemLink = new ItemLink();
			org.w3c.dom.Element elementItemLink = (org.w3c.dom.Element)items.item(i);
			itemLink.setDescription(ElementParserUtil.readElementTextContent(elementItemLink,"Description"));
			itemLink.setURL(ElementParserUtil.readElementTextContent(elementItemLink,"URL"));
			itemLinks.add(itemLink);
		}
		return itemLinks;
	}

}
