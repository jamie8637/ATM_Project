package data;

/**
 * AccountDAOTest.java contains the Unit tests for the make deposit and make withdrawal methods. 
 * @author Database Layer Team
 * @date 10/28/13
 */

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;

import org.junit.Test;

import atm.business.api.model.FundType;

public class AccountDAOTest {
	
//	public static void main(String[] args) throws Exception{
		
		
//	}
	//Deposit Test
	
	@Test
	public void testMakeDepositLongBigDecimal() {

		//TestUtils.configureTestDatabase();
		
		AccountDAO accountDAO = AccountRepository.getInstance();
		
			try{				
				int acctSubId = 1;
				
				BigDecimal balanceBefore;
				// Balance Before
				balanceBefore = accountDAO.getBalance(acctSubId, false);
				System.out.printf("\n\nDeposit Test:\n");
				System.out.printf("\nBalance before is: " + balanceBefore);
				//amount to deposit
				BigDecimal testDeposit = new BigDecimal(0.01).setScale(2,  RoundingMode.HALF_UP);
				//add the testDeposit amount to the before balance
				BigDecimal balanceAfter = balanceBefore.add(testDeposit);
				
				System.out.printf("\nBalance for AccountSubId should be: " + balanceAfter);
				//make the deposit
				BigDecimal newBalance = accountDAO.makeDeposit(acctSubId, testDeposit, FundType.CASH, false);
				System.out.printf("\nBalance after is: " + balanceAfter);
				//verify
				assertEquals("Balance for AccountSubId should be: " + balanceAfter.toString(), newBalance, balanceAfter);
			
			} catch (Exception e){
				e.printStackTrace();
			}
		
	}
	
	//Withdrawal Test
	@Test
	public void testMakeWithdrawalLongBigDecimal() {
		AccountDAO accountDAO = AccountRepository.getInstance();
				
		try{
			int acctSubId;
			acctSubId = 1;
			BigDecimal balanceBefore;
		
			// Balance Before
			balanceBefore = accountDAO.getBalance(acctSubId, false);
			System.out.printf("\nWithdrawal Test:\n");
			System.out.printf("\nBalance before is: "+ balanceBefore);
			
			//amount to withdraw
			BigDecimal testWithdrawal = new BigDecimal(0.01).setScale(2,  RoundingMode.HALF_UP);
			//subtract the testWithdrawal amount from the before balance
			BigDecimal balanceAfter = balanceBefore.subtract(testWithdrawal);
				
			System.out.println("\nBalance for AccountSubId should be: " + balanceAfter);
			
			//make the withdrawal
			BigDecimal newBalance = accountDAO.makeWithdrawal(acctSubId, testWithdrawal, false);
			System.out.printf("\nNew Balance is: " + newBalance);
			System.out.printf("\nBalance after is: " + balanceAfter);
			
			//verify
			assertEquals("Balance for AccountSubId should be: " + balanceAfter.toString(), newBalance, balanceAfter);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	} 

}
