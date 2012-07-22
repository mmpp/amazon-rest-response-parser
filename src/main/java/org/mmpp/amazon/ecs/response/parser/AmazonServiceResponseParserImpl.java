package org.mmpp.amazon.ecs.response.parser;


import org.mmpp.amazon.ecs.response.model.AbstractResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Amazon検索結果解析クラス
 * @author wataru
 *
 */
public class AmazonServiceResponseParserImpl implements AmazonServiceResponseParser{
	/**
	 * ログ
	 */
	private java.util.logging.Logger logger = java.util.logging.Logger.getLogger(this.getClass().getName());
	private ItemResponseParser _itemResponseParser = null;
	private ItemResponseParser getResponseParser() {
		if(_itemResponseParser==null){
			_itemResponseParser = new ItemResponseParser();
		}
		return _itemResponseParser;
	}

	@Override
	public AbstractResponse parse(Document document) {
		// ItemSearchResponseのエレメントを取得 //
		org.w3c.dom.Element elementItemSearchResponse = document.getDocumentElement();

		AbstractResponse response = parseAbstractResponse(elementItemSearchResponse);
		return response;
	}

	/**
	 * ItemSearchResponseタグを解析をします
	 * @param elementItemSearchResponse ItemSearchResponseタグエレメント情報
	 * @return ItemSearchResponseクラス 
	 */
	private AbstractResponse parseAbstractResponse(Element element) {
		return getResponseParser().parse(element);
	}



}
