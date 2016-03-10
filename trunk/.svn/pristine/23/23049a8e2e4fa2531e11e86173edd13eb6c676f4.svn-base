package data;


import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import atm.business.api.model.Account;
import atm.business.api.model.AccountSub;
import atm.business.api.model.FundType;


/**
 * 
 * @author Dave Lawnicki - 10/1/2013
 * Data access interface begins here.
 */
	public interface AccountDAO {
		
	public boolean authenticate(String cardNumber, String pinNumber) throws SQLException, Exception;
	public BigDecimal getBalance(int subAccountId) throws SQLException, Exception;
	public BigDecimal getBalance(int accountSubId, boolean insertTransaction) throws SQLException, Exception;	
	public List<AccountSub> getAccountSubs(String cardNumber) throws SQLException, Exception;
	public String getAccountSubIds(String cardNumber, int accountType) throws SQLException, Exception;
	public BigDecimal makeDeposit(int subAccountId, BigDecimal depositAmount) throws SQLException, Exception; 
	public BigDecimal makeDeposit(int subAccountId, BigDecimal depositAmount, FundType fundType) throws SQLException, Exception;
	public BigDecimal makeDeposit(int subAccountId, BigDecimal depositAmount, FundType fundType, boolean bAllowCommit) throws SQLException, Exception;
	public BigDecimal makeWithdrawal(int subAccountId, BigDecimal withdrawalAmount) throws SQLException, Exception;	
	public BigDecimal makeWithdrawal(int subAccountId, BigDecimal withdrawalAmount, boolean bAllowCommit) throws SQLException, Exception;
	public Boolean createAccount(Account account) throws SQLException, Exception;
	public Boolean updateAccount(Account account) throws SQLException, Exception;
	public Boolean createAccountSub(AccountSub accountSub) throws SQLException,Exception;
	public Boolean updateAccountSub(AccountSub accountSub) throws SQLException, Exception;	
	public BigDecimal getBalanceFromCardNumber(String cardNumber)  throws SQLException, Exception;

}
