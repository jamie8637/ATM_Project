package atm.business.server.services;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import data.AccountDAO;

import atm.business.api.model.Account;
import atm.business.api.model.AccountSub;
import atm.business.api.model.BankUser;
import atm.business.api.model.FundType;
import atm.business.api.services.BankServiceException;
//import data.BankDAO;

public class AccountServiceImplTest {

	AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
	AccountDAO accountDao = new AccountDAO() {

		@Override
		public BigDecimal getBalance(int subAccountId) throws SQLException,
				Exception {
			if (subAccountId == 1) {
				return BigDecimal.ONE;
			} else {
				return null;
			}
		}

		@Override
		public boolean authenticate(String cardNumber, String pinNumber)
				throws SQLException, Exception {
			// TODO Auto-generated method stub
			return false;
		}


		@Override
		public List getAccountSubs(String cardNumber) throws SQLException,
				Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal makeDeposit(int account, BigDecimal depositAmount)
				throws SQLException, Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal makeWithdrawal(int account,
				BigDecimal withdrawalAmount) throws SQLException, Exception {
			// TODO Auto-generated method stub
			return null;
		}




		@Override
		public Boolean createAccount(Account account) throws SQLException,
				Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean updateAccount(Account account) throws SQLException,
				Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean createAccountSub(AccountSub accountSub)
				throws SQLException, Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Boolean updateAccountSub(AccountSub accountSub)
				throws SQLException, Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal getBalance(int arg0, boolean arg1)
				throws SQLException, Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal makeDeposit(int arg0, BigDecimal arg1, FundType arg2)
				throws SQLException, Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal makeDeposit(int arg0, BigDecimal arg1, FundType arg2,
				boolean arg3) throws SQLException, Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal makeWithdrawal(int arg0, BigDecimal arg1, boolean arg2)
				throws SQLException, Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BigDecimal getBalanceFromCardNumber(String arg0)
				throws SQLException, Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getAccountSubIds(String cardNumber, int accountType)
				throws SQLException, Exception {
			// TODO Auto-generated method stub
			return null;
		}
	};
	@Before
	public void setup(){
		accountServiceImpl.setAccountDao(accountDao);
	}
	
	@Test
	public void testExpectingNullPointer() throws BankServiceException  {
		
		BankUser bankUser = new BankUser();
		bankUser.setCardNumber("1");
		
		accountServiceImpl.setAccountDao(null);
		
		Exception exception = null;
		
		try {
			BigDecimal result = accountServiceImpl.getUserBalance(bankUser);
		} catch(BankServiceException e) {
			exception = e;
		}
			
		shouldValidateThrowsExceptionWithMessage(exception, "An Unknown Exception Occurred");
	}	
	
	private void shouldValidateThrowsExceptionWithMessage(final Exception e, final String message) {
	    assertNotNull(e);
	    assertTrue(e.getMessage().contains(message));
	} 
}
