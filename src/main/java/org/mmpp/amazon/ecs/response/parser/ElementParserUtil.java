package org.mmpp.amazon.ecs.response.parser;

import java.util.Map;

import org.w3c.dom.Element;

/**
 * エレメント関連ツール
 * @author wataru
 *
 */
public class ElementParserUtil {

	/**
	 * 指定タグのタグ名で括っているテキストコンテンツを取得します<br> 
	 * &lt;タグ名&gt; 
	 *  抽出文字列 
	 * &lt;/タグ名&gt; 
	 * @param element ルートエレメント 
	 * @param tagName 配下のタグ名 
	 * @return テキストコンテンツ (null = テキストコンテンツなし) 
	 */
	public static String readElementTextContent(Element element,String tagName) {
		org.w3c.dom.Element valueElement = (org.w3c.dom.Element)(element.getElementsByTagName(tagName)).item(0);
		if(valueElement==null)
			return null;
		return readElementTextContent(valueElement);
	}
	/**
	 * タグ名で括っているテキストコンテンツを取得します<br>
	 * &lt;タグ名&gt; 
	 *  抽出文字列 
	 * &lt;/タグ名&gt; 
	 * @param element エレメント変数 
	 * @return テキストコンテンツ 
	 */
	public static String readElementTextContent(Element element){
		return element.getTextContent();
	}
	public static void appendMapReadTextContent(Map<String, String> maps,Element element, String tagName) {
		org.w3c.dom.NodeList nodes = element.getElementsByTagName(tagName);
		for(int i = 0 ; i < nodes.getLength() ; i ++ ) {
			org.w3c.dom.Element elementItem = (org.w3c.dom.Element)nodes.item(i);
			String key = elementItem.getAttribute("Name");
			String value =elementItem.getAttribute("Value");
			
			maps.put(key, value);
		}
	}
}
