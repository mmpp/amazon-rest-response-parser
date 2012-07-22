package org.mmpp.amazon.ecs.response.parser;

import org.mmpp.amazon.ecs.response.model.Item;
import org.mmpp.amazon.ecs.response.model.ItemAttribute;
import org.mmpp.amazon.ecs.response.model.ItemLink;
import org.w3c.dom.Element;

public class ItemParser extends AbstractElementParser<Item>{

	private ItemAttributesParser _itemAttributesParser = null;
	private ItemLinksParser _itemLinksParser = null;
	
	public ItemAttributesParser getItemAttributesParser(){
		if(_itemAttributesParser==null)
			_itemAttributesParser = new ItemAttributesParser();
		return _itemAttributesParser;
	}
	public ItemLinksParser getItemLinksParser(){
		if(_itemLinksParser==null)
			_itemLinksParser = new ItemLinksParser();
		return _itemLinksParser;
	}
	@Override
	public Item parse(Element element) {
		org.mmpp.amazon.ecs.response.model.Item item = new org.mmpp.amazon.ecs.response.model.Item();
		item.setASIN(ElementParserUtil.readElementTextContent(element,"ASIN"));
		item.setDetailPageURL(ElementParserUtil.readElementTextContent(element,"DetailPageURL"));
		// for ItemLinks
		org.w3c.dom.Element elementItemLinks = (org.w3c.dom.Element)(element.getElementsByTagName("ItemLinks").item(0));
		java.util.List<ItemLink> itemLinks = getItemLinksParser().parse(elementItemLinks); 
		item.getItemLinks().addAll(itemLinks);
		// for ItemAttributes
		org.w3c.dom.Element elementItemAttributes = (org.w3c.dom.Element)(element.getElementsByTagName("ItemAttributes").item(0));
		java.util.List<ItemAttribute> itemAttributes = getItemAttributesParser().parse(elementItemAttributes); 
		item.getItemAttributes().addAll(itemAttributes);
		return item;
	}

}
