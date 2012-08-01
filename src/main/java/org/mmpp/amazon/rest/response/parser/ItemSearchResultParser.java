package org.mmpp.amazon.rest.response.parser;

import org.mmpp.amazon.rest.response.model.ItemSearchResult;
import org.mmpp.amazon.rest.response.model.Request;
import org.w3c.dom.Element;


public class ItemSearchResultParser extends AbstractItemResultParser<ItemSearchResult> {

	@Override
	public ItemSearchResult parse(Element element) {
		ItemSearchResult itemResult = new ItemSearchResult();
		org.w3c.dom.Element elementRequest = (org.w3c.dom.Element)(element.getElementsByTagName("Request").item(0));
		Request request = parseRequest(elementRequest);
		itemResult.setRequest(request);
		itemResult.setMoreSearchResultsUrl(ElementParserUtil.readElementTextContent(element,"MoreSearchResultsUrl"));
		org.w3c.dom.NodeList items = element.getElementsByTagName("Item");
		for(int i = 0 ; i < items.getLength() ; i ++ ) {
			org.w3c.dom.Element elementItem = (org.w3c.dom.Element)items.item(i);
			org.mmpp.amazon.rest.response.model.Item item = parseItem(elementItem);
			itemResult.getItems().add(item);
		}
		String totalPages = ElementParserUtil.readElementTextContent(element,"TotalPages");
		itemResult.setTotalPages(Integer.valueOf(totalPages));
		String totalResults = ElementParserUtil.readElementTextContent(element,"TotalResults");
		itemResult.setTotalResults(Integer.valueOf(totalResults));
		
		return itemResult;
	}

}
