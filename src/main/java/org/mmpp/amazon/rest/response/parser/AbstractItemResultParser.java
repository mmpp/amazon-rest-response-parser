package org.mmpp.amazon.rest.response.parser;

import org.mmpp.amazon.rest.response.model.AbstractItemResult;
import org.mmpp.amazon.rest.response.model.Item;
import org.mmpp.amazon.rest.response.model.Request;
import org.w3c.dom.Element;

public abstract class AbstractItemResultParser<E extends AbstractItemResult> extends AbstractElementParser<E> {
	private RequestParser _requestParser = null;
	private ItemParser _itemParser = null;

	@Override
	public abstract E parse(Element element) ;

	public RequestParser getRequestParser(){
		if(_requestParser==null){
			_requestParser = new RequestParser();
		}
		return _requestParser;
	}
	public ItemParser getItemParser(){
		if(_itemParser==null){
			_itemParser = new ItemParser();
		}
		return _itemParser;
	}

	protected Item parseItem(Element element) {
		return getItemParser().parse(element);
	}
	protected Request parseRequest(Element element) {
		return getRequestParser().parse(element);
	}

}
