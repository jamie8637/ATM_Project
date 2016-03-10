package communications;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import atm.business.api.model.BankUser;


/**
 * @author aaron bickhaus
 * 
 */
public class XmlParserUtility {
	/**
	 * creating logger log4j
	 */
	static Logger logger = Logger.getLogger("org.apache.log4j.PatternLayout");
	
	/**
	 * BLOCK FROM TREY - EXAMPLES
	 */
	public static BankUser parseAuthentication(String xmlString) {
		Document doc = convertStringToDocumnet(xmlString);
		
		BankUser user = new BankUser();
		NodeList nodes = doc.getChildNodes();
		
		for(int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if("creditcardnumber".equals(node.getNodeName())) {
				user.setCardNumber(node.getTextContent());
			} else if ("pinnumber".equals(node.getNodeName())) {
				user.setPin(node.getTextContent());
			}
		}
		logger.info("converted xml document to Bank user object Class:XMLParserUtility, line #50");
		return user;
	}
	/**
	 * author: aaron bickhaus
	 * method used to convert xml string to document and then parse xml document into authenntication response
	 * @param xmlString
	 * @return
	 */
	public static AuthenticationResponse parseAuthenticationResponse(String xmlString) {
		Document doc = convertStringToDocumnet(xmlString);
		
		AuthenticationResponse response = new AuthenticationResponse();
		NodeList nodes = doc.getChildNodes();
		
		for(int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if("responsecode".equals(node.getNodeName())) {
				response.setAuthenticationResponseCode(Integer.parseInt(node.getTextContent()));
			} else if ("responsemessage".equals(node.getNodeName())) {
				response.setAuthenticationErrorDescription(node.getTextContent());
			}
		}
		logger.info("converted xml document to authentication object Class:XMLParserUtility, line #73");
		return response;
	}
	/**
	 * method used to convert a xml document to a string
	 * 
	 * @param doc
	 * @return
	 */
	public static String convertDocumentToString(Document doc) {
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer;

		try {
			/**
			 * transformation of document happens here
			 */
			transformer = tf.newTransformer();
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(doc), new StreamResult(writer));
			String output = writer.getBuffer().toString();

			/**
			 * logging success
			 */
			logger.info("xml conversion to string  successful Class:XMLParserUtility line# 98");

			return output;

		} catch (TransformerException e) {
			e.printStackTrace();
			logger.fatal("Could not transform document to XML", e);
		}
		return null;
	}

	/**
	 * method used to convert string to xml document
	 * 
	 * @param xml
	 * @return
	 */
	public static Document convertStringToDocumnet(String xml) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			/*
			 * building dxml document here
			 */
			builder = factory.newDocumentBuilder();
			Document doc = builder
					.parse(new InputSource(new StringReader(xml)));
			logger.info("success creating xml document");
			return doc;
		} catch (Exception e) {

			e.printStackTrace();
			logger.fatal("Error building document");
		}
		return null;
	}

}
