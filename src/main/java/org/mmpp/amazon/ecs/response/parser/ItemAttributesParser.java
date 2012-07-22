package org.mmpp.amazon.ecs.response.parser;

import java.util.List;

import org.mmpp.amazon.ecs.response.model.ItemAttribute;
import org.w3c.dom.Element;

public class ItemAttributesParser extends AbstractElementParser<java.util.List<ItemAttribute>>{
	private ItemAttributeParser _parser = null;
	public ItemAttributeParser getItemAttributeParser(){
		if(_parser == null)
			_parser = new ItemAttributeParser();
		return _parser;
	}
	@Override
	public List<ItemAttribute> parse(Element element) {
		java.util.List<ItemAttribute> itemAttributes  = new java.util.LinkedList<ItemAttribute>();
		org.w3c.dom.NodeList nodes = element.getChildNodes();
		for(int i = 0 ; i < nodes.getLength() ; i ++ ) {
			org.w3c.dom.Element item = (org.w3c.dom.Element)nodes.item(i);
			ItemAttribute itemAttribute = getItemAttributeParser().parse(item);
			if(itemAttribute==null)
				continue;
			itemAttributes.add(itemAttribute);
		}
		return itemAttributes;
	}

}
