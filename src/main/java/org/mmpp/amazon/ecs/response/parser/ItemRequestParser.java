package org.mmpp.amazon.ecs.response.parser;

import org.mmpp.amazon.ecs.response.model.AbstractItemRequest;
import org.w3c.dom.Element;

public class ItemRequestParser extends AbstractElementParser<AbstractItemRequest> {

	public static final String TAGNAME_SEARCH_REQUEST = "ItemSearchRequest";
	public static final String TAGNAME_LOOKUP_REQUEST = "ItemLookupRequest";
	
	private boolean _lookupMode = false;
	private AbstractItemRequestParser _itemRequestParser = null;
	
	public void setLookupMode(boolean flag){
		_lookupMode = flag;
	}
	public boolean isLookupMode(){
		return _lookupMode;
	}
	public AbstractItemRequestParser getRequestParser(){
		if(_itemRequestParser==null){
			if(isLookupMode()){
				_itemRequestParser = new ItemLookupRequestParser();
			}else{
				_itemRequestParser = new ItemSearchRequestParser();
			}
		}
		return _itemRequestParser;
	}
	@Override
	public AbstractItemRequest parse(Element element) {
		Element elementItemRequest = (org.w3c.dom.Element)(element.getElementsByTagName(TAGNAME_SEARCH_REQUEST).item(0));
		if(elementItemRequest==null){
			elementItemRequest = (org.w3c.dom.Element)(element.getElementsByTagName(TAGNAME_LOOKUP_REQUEST).item(0));
			setLookupMode(true);
		}

		return  getRequestParser().parse(element);
	}

}
