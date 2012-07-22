package org.mmpp.amazon.ecs.response.parser;

import org.w3c.dom.Element;

public abstract class AbstractElementParser<E> {

	public abstract E parse(Element element);
}
