package org.mmpp.amazon.rest.response.parser;

import org.mmpp.amazon.rest.response.model.AbstractItemRequest;
import org.mmpp.amazon.rest.response.model.Request;
import org.w3c.dom.Element;

public class RequestParser extends AbstractElementParser<Request> {

	private ItemRequestParser _parser = null;
	public ItemRequestParser getItemRequestParser(){
		if(_parser==null){
			_parser = new ItemRequestParser();
		}
		return _parser;
	}
	@Override
	public Request parse(Element element) {
		Request request = new Request();
		String isValid = ElementParserUtil.readElementTextContent(element,"IsValid");
		request.setValid(isValid.equals("True"));
		AbstractItemRequest itemRequest = parseItemRequest(element);
		request.setItemRequest(itemRequest);
		return request;
	}

	private AbstractItemRequest parseItemRequest(Element element) {
		return getItemRequestParser().parse(element);
	}

}
