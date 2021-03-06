package data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.w3c.dom.Document;


public class QueryDataTest {
	/*
	@Test
	public void testCreateDocumentFromXMLString() {
		try {			
			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><root><record><CustomerFirst>John</CustomerFirst><CustomerId>35</CustomerId><CustomerLast>Smith</CustomerLast><Username>jsmith123</Username><Password>abc123</Password></record></root>";
				
			Document doc = QueryData.createDocumentFromXMLString(xml);
			
			assertTrue("Created Document is null", doc != null);			
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Test
	public void testCreateXMLDocumentFromTable() {
		List<Map<String, Object>> oTable;
		
		try {
			Connection connection = DataUtils.connect();
			// insert a test record.
			try {			
				int iResult = DataUtils.processStatement("INSERT INTO customer (CustomerFirst, CustomerLast, Username, Password) VALUES ('John', 'Smith', 'jsmith123', 'abc123')", connection, true);
				assertEquals("Record insert failed", iResult, 1);
				
				// Get the table data
				oTable = DataUtils.selectData("SELECT * FROM customer WHERE username = 'jsmith123' ", connection);	
				
				try {
					Document doc = QueryData.createXMLDocumentFromTable(oTable);
					assertTrue("Table Document is null", doc != null);			
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			finally {
				// No need to keep the inserted record.
				DataUtils.rollback(connection);
				connection.close();
			}
		} 
		catch (Exception e) {			
			e.printStackTrace();
		}		
	}

	@Test
	public void testGetXMLStringFromTable() {
		List<Map<String, Object>> oTable;
		try {
			// insert a test record.
			Connection connection = DataUtils.connect();
			
			try {
				int iResult = DataUtils.processStatement("INSERT INTO customer (CustomerFirst, CustomerLast, Username, Password) VALUES ('John', 'Smith', 'jsmith123', 'abc123')", connection, false);
				assertEquals("Record insert failed", iResult, 1);
	
				// Get the table data
				oTable = DataUtils.selectData("SELECT customer.* FROM customer WHERE username = 'jsmith123' ", connection);	
				
				String xml = QueryData.getXMLStringFromTable(oTable);
				assertTrue("Xml missing the test record", xml.indexOf("jsmith123") > -1);			
				
			}
			finally {
				// No need to keep the inserted record.
				DataUtils.rollback(connection);
				connection.close();
			}			
		} 
		catch (Exception e) {			
			e.printStackTrace();
		}
	}*/
}
