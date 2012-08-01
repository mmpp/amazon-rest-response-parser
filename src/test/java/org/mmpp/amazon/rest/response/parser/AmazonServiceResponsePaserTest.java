package org.mmpp.amazon.rest.response.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.mmpp.amazon.rest.response.model.AbstractItemRequest;
import org.mmpp.amazon.rest.response.model.AbstractResponse;
import org.mmpp.amazon.rest.response.model.Author;
import org.mmpp.amazon.rest.response.model.Creator;
import org.mmpp.amazon.rest.response.model.ItemAttribute;
import org.mmpp.amazon.rest.response.model.ItemLink;
import org.mmpp.amazon.rest.response.model.ItemLookupErrorResponse;
import org.mmpp.amazon.rest.response.model.ItemLookupRequest;
import org.mmpp.amazon.rest.response.model.ItemLookupResponse;
import org.mmpp.amazon.rest.response.model.ItemLookupResult;
import org.mmpp.amazon.rest.response.model.ItemSearchRequest;
import org.mmpp.amazon.rest.response.model.ItemSearchResponse;
import org.mmpp.amazon.rest.response.model.ItemSearchResult;
import org.mmpp.amazon.rest.response.model.Manufacturer;
import org.mmpp.amazon.rest.response.model.OperationRequest;
import org.mmpp.amazon.rest.response.model.ProductGroup;
import org.mmpp.amazon.rest.response.model.Request;
import org.mmpp.amazon.rest.response.model.Title;
import org.mmpp.amazon.rest.response.parser.AmazonServiceResponseParser;
import org.mmpp.amazon.rest.response.parser.AmazonServiceResponseParserImpl;
import org.mmpp.amazon.rest.response.parser.ElementUtil;

import org.xml.sax.SAXException;


public class AmazonServiceResponsePaserTest {

	@Test
	public void testParse20120628() throws SAXException, IOException, ParserConfigurationException {
        java.io.InputStream in = getClass().getClassLoader().getResourceAsStream("aws_result_sample_2012-06-28.xml");
		javax.xml.parsers.DocumentBuilder builder = ElementUtil.getDocumentBuilder();
		org.w3c.dom.Document document = builder.parse(in); 
		AmazonServiceResponseParser parser = new AmazonServiceResponseParserImpl();
		ItemSearchResponse itemSearchResponse = (ItemSearchResponse)parser.parse(document);
		
		ItemSearchResult itemResult = itemSearchResponse.getItemResult();
		{
			Request request = itemResult.getRequest();
			assertTrue(request.isValid());
			AbstractItemRequest itemRequest = request.getItemRequest();
			ItemSearchRequest itemSearchRequest = (ItemSearchRequest)itemRequest;
			assertEquals("神塚 ときお",itemSearchRequest.getAuthor());
			assertEquals(1,itemSearchRequest.getItemPage());
			assertEquals("Small",itemSearchRequest.getResponseGroup());
			assertEquals("Books",itemSearchRequest.getSearchIndex());
		}
		assertEquals(2,itemResult.getTotalPage());
		assertEquals(17,itemResult.getTotalResult());
		assertEquals("http://www.amazon.co.jp/gp/redirect.html?camp=2025&creative=5143&location=http%3A%2F%2Fwww.amazon.co.jp%2Fgp%2Fsearch%3Fkeywords%3D%25E7%25A5%259E%25E5%25A1%259A%2B%25E3%2581%25A8%25E3%2581%258D%25E3%2581%258A%26url%3Dsearch-alias%253Dbooks-single-index&linkCode=xm2&tag=AssociateTag-22&SubscriptionId=AWSAccessKeyId",itemResult.getMoreSearchResultsUrl());
		java.util.List<org.mmpp.amazon.rest.response.model.Item> items = itemResult.getItems();
		assertEquals(10,items.size());
		{
			org.mmpp.amazon.rest.response.model.Item item = items.get(0);
			assertEquals("406321026X",item.getASIN());
			assertEquals("http://www.amazon.co.jp/%E3%83%90%E3%82%A4%E3%82%AD%E3%83%83%E3%82%BA-1-%E3%82%A2%E3%83%95%E3%82%BF%E3%83%8C%E3%83%BC%E3%83%B3KC-%E7%A5%9E%E5%A1%9A-%E3%81%A8%E3%81%8D%E3%81%8A/dp/406321026X%3FSubscriptionId%3DAWSAccessKeyId%26tag%3DAssociateTag-22%26linkCode%3Dxm2%26camp%3D2025%26creative%3D165953%26creativeASIN%3D406321026X",item.getDetailPageURL());
			java.util.List<ItemLink> itemLinks = item.getItemLinks();
			assertEquals(4,itemLinks.size());
			{
				ItemLink itemLink = itemLinks.get(0);
				assertEquals("Add To Wishlist",itemLink.getDescription());
				assertEquals("http://www.amazon.co.jp/gp/registry/wishlist/add-item.html%3Fasin.0%3D406321026X%26SubscriptionId%3DAWSAccessKeyId%26tag%3DAssociateTag-22%26linkCode%3Dxm2%26camp%3D2025%26creative%3D5143%26creativeASIN%3D406321026X",itemLink.getURL());
			}
			java.util.List<ItemAttribute> itemAttributes = item.getItemAttributes();
			assertEquals(4,itemAttributes.size());
			{
				ItemAttribute itemAttribute = itemAttributes.get(0);
				assertTrue(itemAttribute instanceof Author);
				Author author = (Author)itemAttribute;
				assertEquals("神塚 ときお",author.getName());
			}
			{
				ItemAttribute itemAttribute = itemAttributes.get(1);
				assertTrue(itemAttribute instanceof Manufacturer);
				Manufacturer manufacturer = (Manufacturer)itemAttribute;
				assertEquals("講談社",manufacturer.getName());
			}
			{
				ItemAttribute itemAttribute = itemAttributes.get(2);
				assertTrue(itemAttribute instanceof ProductGroup);
				ProductGroup productGroup = (ProductGroup)itemAttribute;
				assertEquals("Book",productGroup.getName());
			}
			{
				ItemAttribute itemAttribute = itemAttributes.get(3);
				assertTrue(itemAttribute instanceof Title);
				Title title = (Title)itemAttribute;
				assertEquals("バイキッズ 1 (アフタヌーンKC)",title.getName());
			}
			
		}
		OperationRequest request = itemSearchResponse.getOperationRequest();
		java.util.Map<String,String> headers = request.getHTTPHeaders();
		assertEquals(1,headers.size());
		assertEquals("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:12.0) Gecko/20100101 Firefox/12.0",headers.get("UserAgent"));
		java.util.Map<String,String> args = request.getArguments();
		assertEquals(10,args.size());
		assertEquals("ItemSearch",args.get("Operation"));
		assertEquals("AWSECommerceService",args.get("Service"));
		assertEquals("1",args.get("ItemPage"));
		assertEquals("AssociateTag-22",args.get("AssociateTag"));
		assertEquals("Books",args.get("SearchIndex"));
		assertEquals("神塚 ときお",args.get("Author"));
		assertEquals("Signature=",args.get("Signature"));
		assertEquals("AWSAccessKeyId",args.get("AWSAccessKeyId"));
		assertEquals("2012-06-28T06:36:33Z",args.get("Timestamp"));
		assertEquals("カタカナ",args.get("__mk_ja_JP"));

		assertEquals("ce419a7c-e9fe-4b30-abcb-54f1873af99f",request.getRequestId());
		assertEquals("0.0391610000000000",request.getRequestProcessingTime());
		
	}
	@Test
	public void testParse20120630() throws SAXException, IOException, ParserConfigurationException {
        java.io.InputStream in = getClass().getClassLoader().getResourceAsStream("aws_result_sample_2012-06-30.xml");
		javax.xml.parsers.DocumentBuilder builder = ElementUtil.getDocumentBuilder();
		org.w3c.dom.Document document = builder.parse(in); 
		AmazonServiceResponseParser parser = new AmazonServiceResponseParserImpl();
		ItemLookupResponse itemLookupResponse = (ItemLookupResponse)parser.parse(document);
		ItemLookupResult itemResult = itemLookupResponse.getItemResult();
		{
			Request request = itemResult.getRequest();
			assertTrue(request.isValid());
			AbstractItemRequest itemRequest = request.getItemRequest();
			ItemLookupRequest itemLookupRequest = (ItemLookupRequest)itemRequest;
			assertEquals("ISBN",itemLookupRequest.getIdType());
			assertEquals("4774151041",itemLookupRequest.getItemId());
			assertEquals("Small",itemLookupRequest.getResponseGroup());
			assertEquals("Books",itemLookupRequest.getSearchIndex());
			assertEquals("All",itemLookupRequest.getVariationPage());
		}
		java.util.List<org.mmpp.amazon.rest.response.model.Item> items = itemResult.getItems();
		assertEquals(1,items.size());
		{
			org.mmpp.amazon.rest.response.model.Item item = items.get(0);
			assertEquals("4774151041",item.getASIN());
			java.util.List<ItemLink> itemLinks = item.getItemLinks();
			assertEquals(4,itemLinks.size());
			{
				ItemLink itemLink = itemLinks.get(0);
				assertEquals("Add To Wishlist",itemLink.getDescription());
			}
			java.util.List<ItemAttribute> itemAttributes = item.getItemAttributes();
			assertEquals(20,itemAttributes.size());
			{
				ItemAttribute itemAttribute = itemAttributes.get(0);
				assertTrue(itemAttribute instanceof Author);
				Author author = (Author)itemAttribute;
				assertEquals("大塚 弘記",author.getName());
			}
			{
				ItemAttribute itemAttribute = itemAttributes.get(16);
				assertTrue(itemAttribute instanceof Creator);
				Creator creator = (Creator)itemAttribute;
				assertEquals("編集",creator.getRole());
				assertEquals("WEB+DB PRESS編集部",creator.getName());
			}
			
		}
		OperationRequest request = itemLookupResponse.getOperationRequest();
		java.util.Map<String,String> headers = request.getHTTPHeaders();
		assertEquals(1,headers.size());
		assertEquals("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:12.0) Gecko/20100101 Firefox/12.0",headers.get("UserAgent"));
		java.util.Map<String,String> args = request.getArguments();
		assertEquals(9,args.size());
		assertEquals("ItemLookup",args.get("Operation"));
		assertEquals("AWSECommerceService",args.get("Service"));
		assertEquals("AssociateTag-22",args.get("AssociateTag"));
		assertEquals("Books",args.get("SearchIndex"));
		assertEquals("Signature=",args.get("Signature"));
		assertEquals("4774151041",args.get("ItemId"));
		assertEquals("ISBN",args.get("IdType"));
		assertEquals("AWSAccessKeyId",args.get("AWSAccessKeyId"));
		assertEquals("2012-06-30T07:58:08Z",args.get("Timestamp"));

		assertEquals("ed6c75b2-fde0-447e-a333-d0f4bc33ef91",request.getRequestId());
		assertEquals("0.0075570000000000",request.getRequestProcessingTime());

	}

	@Test
	public void test201206302() throws SAXException, IOException, ParserConfigurationException {
        java.io.InputStream in = getClass().getClassLoader().getResourceAsStream("aws_result_sample_2012-06-30-2.xml");
		javax.xml.parsers.DocumentBuilder builder = ElementUtil.getDocumentBuilder();
		org.w3c.dom.Document document = builder.parse(in); 
		AmazonServiceResponseParser parser = new AmazonServiceResponseParserImpl();
		ItemLookupResponse itemLookupResponse = (ItemLookupResponse)parser.parse(document);
		ItemLookupResult itemResult = itemLookupResponse.getItemResult();
		{
			Request request = itemResult.getRequest();
			assertTrue(request.isValid());
			AbstractItemRequest itemRequest = request.getItemRequest();
			ItemLookupRequest itemLookupRequest = (ItemLookupRequest)itemRequest;
			assertEquals("ISBN",itemLookupRequest.getIdType());
			assertEquals("4873112478",itemLookupRequest.getItemId());
			assertEquals("Small",itemLookupRequest.getResponseGroup());
			assertEquals("Books",itemLookupRequest.getSearchIndex());
			assertEquals("All",itemLookupRequest.getVariationPage());
		}

		java.util.List<org.mmpp.amazon.rest.response.model.Item> items = itemResult.getItems();
		assertEquals(1,items.size());
		{
			org.mmpp.amazon.rest.response.model.Item item = items.get(0);
			assertEquals("4873112478",item.getASIN());
			java.util.List<ItemLink> itemLinks = item.getItemLinks();
			assertEquals(4,itemLinks.size());
			java.util.List<ItemAttribute> itemAttributes = item.getItemAttributes();
			assertEquals(9,itemAttributes.size());
			assertAuthor("Tony Bautts",itemAttributes.get(0));
			assertAuthor("Terry Dawson",itemAttributes.get(1));
			assertAuthor("Gregor N. Purdy",itemAttributes.get(2));
			assertCreator("翻訳","高橋 浩和 (監訳)",itemAttributes.get(3));
			assertCreator("翻訳","伊藤 真浩 (監訳)",itemAttributes.get(4));
			assertCreator("翻訳","三好 和人",itemAttributes.get(5));
			
		}
		OperationRequest request = itemLookupResponse.getOperationRequest();
		java.util.Map<String,String> headers = request.getHTTPHeaders();
		assertEquals(1,headers.size());
		assertEquals("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:12.0) Gecko/20100101 Firefox/12.0",headers.get("UserAgent"));
		java.util.Map<String,String> args = request.getArguments();
		assertEquals(9,args.size());
		assertEquals("ItemLookup",args.get("Operation"));
		assertEquals("AWSECommerceService",args.get("Service"));
		assertEquals("AssociateTag-22",args.get("AssociateTag"));
		assertEquals("Books",args.get("SearchIndex"));
		assertEquals("Signature=",args.get("Signature"));
		assertEquals("4873112478",args.get("ItemId"));
		assertEquals("ISBN",args.get("IdType"));
		assertEquals("AWSAccessKeyId",args.get("AWSAccessKeyId"));
		assertEquals("2012-06-30T11:18:24Z",args.get("Timestamp"));

		assertEquals("263d08a7-b318-4b0f-a4a7-0ad493b9087a",request.getRequestId());
		assertEquals("0.0078490000000000",request.getRequestProcessingTime());

	}
	@Test
	public void test20120715ERR() throws SAXException, IOException, ParserConfigurationException {
        java.io.InputStream in = getClass().getClassLoader().getResourceAsStream("aws_result_sample_2012-07-15_err.xml");
		javax.xml.parsers.DocumentBuilder builder = ElementUtil.getDocumentBuilder();
		org.w3c.dom.Document document = builder.parse(in); 
		AmazonServiceResponseParser parser = new AmazonServiceResponseParserImpl();
		AbstractResponse response = parser.parse(document);
		assertTrue(response instanceof ItemLookupErrorResponse);
		ItemLookupErrorResponse itemLookupErrorResponse = (ItemLookupErrorResponse)response;
		assertEquals("3db731eb-4752-4500-9f26-d5c85ef5748b",itemLookupErrorResponse.getRequestId());
		org.mmpp.amazon.rest.response.model.Error error =  itemLookupErrorResponse.getError();
		assertEquals("RequestExpired",error.getCode());
		assertEquals("Request has expired. Timestamp date is 2012-05-11T20:41:32.713Z.",error.getMessage());

	}
	/**
	 * 制作者情報判断
	 * @param assertRole 正解制作役割
	 * @param assertName 正解制作者名
	 * @param itemAttribute Item属性
	 */
	private void assertCreator(String assertRole,String assertName,ItemAttribute itemAttribute){
		assertTrue(itemAttribute instanceof Creator);
		Creator creator = (Creator)itemAttribute;
		assertEquals(assertRole,creator.getRole());
		assertEquals(assertName,creator.getName());
	}
	/**
	 * 著者名の判断
	 * @param assertName 正解著者名
	 * @param itemAttribute Item属性
	 */
	private void assertAuthor(String assertName,ItemAttribute itemAttribute){
		assertTrue(itemAttribute instanceof Author);
		Author author = (Author)itemAttribute;
		assertEquals(assertName,author.getName());
	}
}
