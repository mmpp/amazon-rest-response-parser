package org.mmpp.amazon.rest.response.parser;

import org.mmpp.amazon.rest.response.model.AbstractItemResponse;
import org.mmpp.amazon.rest.response.model.AbstractItemResult;
import org.mmpp.amazon.rest.response.model.AbstractResponse;
import org.mmpp.amazon.rest.response.model.Error;
import org.mmpp.amazon.rest.response.model.ItemLookupErrorResponse;
import org.mmpp.amazon.rest.response.model.ItemLookupResponse;
import org.mmpp.amazon.rest.response.model.ItemSearchResponse;
import org.mmpp.amazon.rest.response.model.OperationRequest;
import org.w3c.dom.Element;


public class ItemResponseParser extends AbstractElementParser<AbstractResponse> {

	private ItemResultParser _itemResultParser = null;
	private OperationRequestParser _operationRequestParser = null;
	private ErrorParser _errorParser = null;
	public ItemResultParser getItemResultParser(){
		if(_itemResultParser==null){
			_itemResultParser = new ItemResultParser();
		}
		return _itemResultParser;
	}
	public OperationRequestParser getOperationRequestParser(){
		if(_operationRequestParser==null){
			_operationRequestParser = new OperationRequestParser();
		}
		return _operationRequestParser;
	}

	private ErrorParser getErrorParser() {
		if(_errorParser==null){
			_errorParser = new ErrorParser();
		}
		return _errorParser;
	}
	@Override
	public AbstractResponse parse(Element element) {
		if(element.getTagName().equals("ItemSearchResponse"))
			return parseItemSearchResponse(element);
		if(element.getTagName().equals("ItemLookupResponse"))
			return parseItemLookupResponse(element);

		if(element.getTagName().equals("ItemLookupErrorResponse"))
			return parseItemLookupErrorResponse(element);
		return null;
	}

	private AbstractResponse parseItemLookupErrorResponse(Element element) {
		ItemLookupErrorResponse errorResponse = new ItemLookupErrorResponse();
		errorResponse.setRequestId(ElementParserUtil.readElementTextContent(element,"RequestId"));
		org.w3c.dom.Element elementError = (org.w3c.dom.Element)(element.getElementsByTagName("Error").item(0));
		org.mmpp.amazon.rest.response.model.Error error = parseError(elementError);
		errorResponse.setError(error);
		return errorResponse;
	}
	private ItemSearchResponse parseItemSearchResponse(Element element) {
		return (ItemSearchResponse) parseItemResponse(new ItemSearchResponse(),element);
	}
	private ItemLookupResponse parseItemLookupResponse(Element element){
		return (ItemLookupResponse) parseItemResponse(new ItemLookupResponse(),element);		
	}
	private AbstractItemResponse parseItemResponse(AbstractItemResponse itemResponse,Element element){
		// Parse <OpetationRequest> : Tag
		org.w3c.dom.Element elementOperationRequest = (org.w3c.dom.Element)(element.getElementsByTagName("OperationRequest").item(0));
		OperationRequest operationRequest = parseOperationRequest(elementOperationRequest);
		itemResponse.setOperationRequest(operationRequest);
		
		// Parse <Items> : Tag
		org.w3c.dom.Element elementItems = (org.w3c.dom.Element)(element.getElementsByTagName("Items").item(0));
		AbstractItemResult itemResult = parseItemResult(elementItems);
		itemResponse.setItemResult(itemResult);
		return itemResponse;
		
	}
	private AbstractItemResult parseItemResult(Element element) {
		return getItemResultParser().parse(element);
	}

	private OperationRequest parseOperationRequest(Element element) {
		return getOperationRequestParser().parse(element);
	}

	private Error parseError(Element element) {
		return getErrorParser().parse(element);
	}
}
