package org.mmpp.amazon.ecs.response.parser;

import org.mmpp.amazon.ecs.response.model.ItemLookupResult;
import org.mmpp.amazon.ecs.response.model.Request;
import org.w3c.dom.Element;


public class ItemLookupResultParser extends AbstractItemResultParser<ItemLookupResult> {

	@Override
	public ItemLookupResult parse(Element element) {
		ItemLookupResult itemResult = new ItemLookupResult();
		org.w3c.dom.Element elementRequest = (org.w3c.dom.Element)(element.getElementsByTagName("Request").item(0));
		Request request = parseRequest(elementRequest);
		itemResult.setRequest(request);
		org.w3c.dom.NodeList items = element.getElementsByTagName("Item");
		for(int i = 0 ; i < items.getLength() ; i ++ ) {
			org.w3c.dom.Element elementItem = (org.w3c.dom.Element)items.item(i);
			org.mmpp.amazon.ecs.response.model.Item item = parseItem(elementItem);
			itemResult.getItems().add(item);
		}
		
		return itemResult;
	}

}
