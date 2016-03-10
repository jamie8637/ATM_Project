package data;



/**
 * QueryDataTest.java Tests the QueryData class
 * 
 * @author Database Layer Team
 * @date 9/10/2013
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;

import org.junit.Test;
//import main.java.data.AccountDAO;
//import main.java.data.AccountRepository;

public class RepositoryTest {

	
	
	public static void main(String[] args) throws Exception{
	}
		
	
	@Test
	public void authenticateTest() {
		
		//TestUtils.configureTestDatabase();
		AccountDAO accountDAO = AccountRepository.getInstance();
		
		try {
			// check the method with correct card number and pin number
			assertEquals("authenticate method failed", true, accountDAO.authenticate("1234123412341234", "12345"));
			
			// test the method with incorrect card number and pin number
			assertEquals("authenticate method failed", false, accountDAO.authenticate("9998887776661234", "8920"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*@Test
	 * 
	 * GETBALANCE in AccountRepository will need to allow sending a connection in, or else it cannot be tested.
	 * 
	public void testGetBalance(){
		AccountDAO accountDAO = AccountRepository.getInstance();
		
		try{
			Connection connection = DataUtils.connect();
			int iCustomerId = DataUtils.processStatementGetId("insert into customer (customerfirst) values ('John');", connection, false);
			int iAccountId = DataUtils.processStatementGetId("insert into account (primarycustomerid, cardnumber, pinnumber) values (" + iCustomerId + ", '1234123412349999', '9819');", connection, false);
			int iAccountSubId = DataUtils.processStatementGetId("insert into accountsub (accountid, accounttype, availablebalance) values (" + iAccountId + ", 0, 50.00);", connection, false);
						
			assertEquals("Balance for AccountSubId is: " + accountDAO.getBalance(iAccountSubId, connection), 50.00, accountDAO.getBalance(iAccountSubId, connection));
			connection.rollback();
			connection.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	*/

	
}
