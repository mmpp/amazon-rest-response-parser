package org.mmpp.amazon.rest.response.parser;

import org.mmpp.amazon.rest.response.model.Error;
import org.w3c.dom.Element;

public class ErrorParser extends AbstractElementParser<Error> {

	@Override
	public Error parse(Element element) {
		Error error = new Error();
		error.setCode(ElementParserUtil.readElementTextContent(element,"Code"));
		error.setMessage(ElementParserUtil.readElementTextContent(element,"Message"));
		return error;
	}

}
