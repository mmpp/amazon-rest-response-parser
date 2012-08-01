package org.mmpp.amazon.rest.response.parser;

import org.mmpp.amazon.rest.response.model.OperationRequest;
import org.w3c.dom.Element;

public class OperationRequestParser extends AbstractElementParser<OperationRequest>{

	@Override
	public OperationRequest parse(Element element) {
		OperationRequest request = new OperationRequest();
		org.w3c.dom.Element elementHTTPHeaders = (org.w3c.dom.Element)(element.getElementsByTagName("HTTPHeaders").item(0));
		ElementParserUtil.appendMapReadTextContent(request.getHTTPHeaders(),elementHTTPHeaders,"Header");
		request.setRequestId(ElementParserUtil.readElementTextContent(element,"RequestId"));
		request.setRequestProcessingTime(ElementParserUtil.readElementTextContent(element,"RequestProcessingTime"));
		org.w3c.dom.Element elementArguments = (org.w3c.dom.Element)(element.getElementsByTagName("Arguments").item(0));
		ElementParserUtil.appendMapReadTextContent(request.getArguments(),elementArguments,"Argument");
		return request;
	}

}
