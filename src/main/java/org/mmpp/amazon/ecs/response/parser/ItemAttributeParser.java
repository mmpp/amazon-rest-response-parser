package org.mmpp.amazon.ecs.response.parser;

import org.mmpp.amazon.ecs.response.model.Author;
import org.mmpp.amazon.ecs.response.model.Creator;
import org.mmpp.amazon.ecs.response.model.ItemAttribute;
import org.mmpp.amazon.ecs.response.model.Manufacturer;
import org.mmpp.amazon.ecs.response.model.ProductGroup;
import org.mmpp.amazon.ecs.response.model.Title;
import org.w3c.dom.Element;

public class ItemAttributeParser extends AbstractElementParser<ItemAttribute>{

	@Override
	public ItemAttribute parse(Element element) {
		String tagName = element.getTagName();
		if(tagName.equals("Author")){
			Author author = new Author();
			author.setName(ElementParserUtil.readElementTextContent(element));
			return author;
		}
		if(tagName.equals("Manufacturer")){
			Manufacturer manufacturer = new Manufacturer();
			manufacturer.setName(ElementParserUtil.readElementTextContent(element));
			return manufacturer;
		}
		if(tagName.equals("ProductGroup")){
			ProductGroup productGroup = new ProductGroup();
			productGroup.setName(ElementParserUtil.readElementTextContent(element));
			return productGroup;
		}

		if(tagName.equals("Title")){
			Title title = new Title();
			title.setName(ElementParserUtil.readElementTextContent(element));
			return title;
		}
		if(tagName.equals("Creator")){
			Creator creator = new Creator();
			creator.setRole(element.getAttribute("Role"));
			creator.setName(ElementParserUtil.readElementTextContent(element));
			return creator;
		}
		return null;

	}

}
