package org.mmpp.amazon.rest.response.parser;

import org.mmpp.amazon.rest.response.model.AbstractItemRequest;
import org.w3c.dom.Element;

public abstract class AbstractItemRequestParser<E extends AbstractItemRequest> extends AbstractElementParser<E> {

	@Override
	public abstract E parse(Element element);
}
