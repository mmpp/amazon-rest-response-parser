package org.mmpp.amazon.ecs.response.parser;

import org.mmpp.amazon.ecs.response.model.AbstractItemResult;
import org.w3c.dom.Element;


public class ItemResultParser extends AbstractElementParser<AbstractItemResult> {

	private AbstractItemResultParser _itemResultParser = null;
	private boolean _itemLookup = false;
	public AbstractItemResultParser getAbstractItemResultParser(){
		if(_itemResultParser==null){
			if(isItemLookupMode()){
				_itemResultParser = new ItemLookupResultParser();
			}else{
				_itemResultParser = new ItemSearchResultParser();
			}
		}
		return _itemResultParser;
	}
	public boolean isItemLookupMode(){
		return _itemLookup;
	}
	public void setItemLookupMode(boolean flag){
		_itemLookup = flag;
	}
	@Override
	public AbstractItemResult parse(Element element) {
		setItemLookupMode(((org.w3c.dom.Element)element.getParentNode()).getTagName().equals("ItemLookupResponse"));
		
		return getAbstractItemResultParser().parse(element);
	}


}
