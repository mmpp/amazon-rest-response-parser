package org.mmpp.amazon.rest.response.parser;

import org.mmpp.amazon.rest.response.model.ItemLookupRequest;
import org.w3c.dom.Element;


public class ItemLookupRequestParser extends AbstractItemRequestParser<ItemLookupRequest> {

	@Override
	public ItemLookupRequest parse(Element element) {
		ItemLookupRequest itemLookuphRequest = new ItemLookupRequest();
		itemLookuphRequest.setIdType(ElementParserUtil.readElementTextContent(element, "IdType"));
		itemLookuphRequest.setItemId(ElementParserUtil.readElementTextContent(element, "ItemId"));
		itemLookuphRequest.setResponseGroup(ElementParserUtil.readElementTextContent(element, "ResponseGroup"));
		itemLookuphRequest.setSearchIndex(ElementParserUtil.readElementTextContent(element, "SearchIndex"));
		itemLookuphRequest.setVariationPage(ElementParserUtil.readElementTextContent(element, "VariationPage"));
		return itemLookuphRequest;
	}

}
