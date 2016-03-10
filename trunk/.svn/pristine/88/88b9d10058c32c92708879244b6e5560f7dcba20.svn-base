package data;



import java.io.StringReader;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;


public class QueryData {
	QueryData() {

	}

		
	/**
	 * createDocumentFromXMLString - Parses XML in string format into a Document object
	 * 
	 * @param xml This is XML in string format to parse into a Document
	 * @return Document of XML data.	 
	 * @throws Exception
	 * @author Dave Lawnicki - 9/10/2013
	 */
	public static Document createDocumentFromXMLString(String xml) throws Exception
    {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        
        InputSource input = new InputSource(new StringReader(xml));
        return docBuilder.parse(input);
    }
	
	/**
	 * createXMLDocumentFromTable - Takes in a "Table" and return a Document of that "table" in Xml format.
	 * 
	 * @param oTable This is an array list containing the data returned from a sql statement
	 * @return Document of XML data. 
	 * @author Dave Lawnicki - 9/9/2013
	 */
	public static Document createXMLDocumentFromTable(List<Map<String, Object>> oTable) {
		if (oTable != null && oTable.size() > 0) {
			// Put column names into ArrayList to use as elements tags.
			List<String> oColumnNames = new ArrayList<>();
			
			for (String s : oTable.get(0).keySet())
				oColumnNames.add(s);
			
			// Build XML Packet.
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
				
				// create root element
				Document doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("root");
				doc.appendChild(rootElement);
				
				try {
					// Go through each "row" and add it as a record to the XML.
					for (int i = 0; i < oTable.size(); i++) {
						
						// staff elements
						Element recordElement = doc.createElement("record");
						rootElement.appendChild(recordElement);
						
						// Add each column and data to the record.
						for (int j = 0; j < oColumnNames.size(); j++) {
							Element docElement = doc.createElement(oColumnNames.toArray()[j].toString());
							
							// Encode the string values to make sure symbols won't break the packet. Need to URLDecoder.decode on other end.
							//docElement.appendChild(doc.createTextNode(URLEncoder.encode(oTable.get(i).get(oColumnNames.toArray()[j].toString()).toString(), "UTF-8")));
							String sValue = oTable.get(i).get(oColumnNames.toArray()[j].toString()) == null ? "" : oTable.get(i).get(oColumnNames.toArray()[j].toString()).toString();
							docElement.appendChild(doc.createTextNode(URLEncoder.encode(sValue, "UTF-8")));
							recordElement.appendChild(docElement);
						}
					}			
					
					return doc;
					
				} catch (Exception e) {				
					e.printStackTrace();
				}
			} 
			catch (ParserConfigurationException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		else
			return null;
	}
	
	/**
	 * getXMLStringFromTable - Takes in a "Table" and return a string of that "table" in Xml format.
	 * 
	 * @param oTable This is an array list containing the data returned from a sql statement
	 * @return String of XML data. 
	 * @author Dave Lawnicki - 9/9/2013
	 */
	public static String getXMLStringFromTable(List<Map<String, Object>> oTable) {
		// Get the Document
		Document doc = createXMLDocumentFromTable(oTable);
		
		if (doc != null) {
			// Convert the doc to string and return if valid.
			try {
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = null;						
				transformer = transformerFactory.newTransformer();
				
				DOMSource source = new DOMSource(doc);
				StringWriter writer = new StringWriter();
		 							
				transformer.transform(source, new StreamResult(writer));
				
				// test show in console
				//System.out.println(writer.toString());
				
				// return xml as string
				return writer.toString();
			}
			catch (Exception e) {
				
			}
		}
		
		return "";
	}
}
