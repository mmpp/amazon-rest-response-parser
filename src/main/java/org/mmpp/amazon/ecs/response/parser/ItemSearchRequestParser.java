package org.mmpp.amazon.ecs.response.parser;

import org.mmpp.amazon.ecs.response.model.ItemSearchRequest;
import org.w3c.dom.Element;

public class ItemSearchRequestParser extends AbstractItemRequestParser<ItemSearchRequest>{

	@Override
	public ItemSearchRequest parse(Element element) {
		ItemSearchRequest itemSearchRequest = new ItemSearchRequest();
		itemSearchRequest.setAuthor(ElementParserUtil.readElementTextContent(element, "Author"));
		String itemPage = ElementParserUtil.readElementTextContent(element, "ItemPage");
		itemSearchRequest.setItemPage(Integer.valueOf(itemPage));
		itemSearchRequest.setResponseGroup(ElementParserUtil.readElementTextContent(element, "ResponseGroup"));
		itemSearchRequest.setSearchIndex(ElementParserUtil.readElementTextContent(element, "SearchIndex"));
		return itemSearchRequest;
	}

}
