package org.mmpp.amazon.rest.response.parser;

import org.mmpp.amazon.rest.response.model.AbstractResponse;
import org.w3c.dom.Document;

/**
 * AmazonサービスResponseを解析インタフェイス
 * @author wataru
 *
 */
public interface AmazonServiceResponseParser {
	/**
	 * Response XMLを解析しま�?	 * @param document AmazonサービスResponse XML�??タ
	 * @return 解析結果クラス
	 */
	public AbstractResponse parse(Document document);
}
