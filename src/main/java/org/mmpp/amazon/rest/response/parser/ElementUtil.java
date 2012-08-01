package org.mmpp.amazon.rest.response.parser;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;

public class ElementUtil {
	private static javax.xml.parsers.DocumentBuilder _documentBuilder = null;;
	public static javax.xml.parsers.DocumentBuilder getDocumentBuilder() throws ParserConfigurationException{
		if(_documentBuilder==null){
			javax.xml.parsers.DocumentBuilderFactory  docBFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
			_documentBuilder = docBFactory.newDocumentBuilder();
		}
		return _documentBuilder;
	}
	private static org.w3c.dom.Document _document = null;
	public static org.w3c.dom.Element createElement(String tagName) throws DOMException, ParserConfigurationException{
		return getDocument().createElement(tagName);
	}
	public static org.w3c.dom.Document getDocument() throws ParserConfigurationException{
		if(_document==null){
			_document = getDocumentBuilder().newDocument(); 
		}
		return _document;
	}
}
