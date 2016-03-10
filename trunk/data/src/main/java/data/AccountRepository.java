package data;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import atm.business.api.model.Account;
import atm.business.api.model.AccountSub;
import atm.business.api.model.FundType;
import atm.business.api.model.TransactionType;

public class AccountRepository implements AccountDAO {
	
	/*
	 * Hold an instance of Repository as a singleton.
	 */
	private static AccountRepository instance = new AccountRepository();
	
	/**
	 * The Repository class is intended to be a singleton.  As such, the constructor is private. 
	 */
	private AccountRepository() {
		
	}
	
	/*
	 * 
	 */
	public static AccountRepository getInstance() {
		return instance;
	}	
	
	/**
	 * @param cardNumber
	 * @param pinNumber
	 * @return boolean depending on the user authentication
	 * @throws SQLException
	 * @throws Exception
	 * @author Vandana Arora - 9/18/2013
	 */
	@Override
	public boolean authenticate(String cardNumber, String pinNumber) throws SQLException, Exception {		
		boolean result;
		
		Connection connection = DataUtils.connect();
		String queryString = "SELECT * FROM account WHERE cardnumber = '"
				+ cardNumber + "'" + " AND pinnumber = '" + pinNumber + "' ";

		result = DataUtils.runQuery(queryString, connection);

		connection.close();
		return result;
	}

	/**
	 * getBalance accepts an integer for the account subId and returns a Big Decimal.
	 * The BigDecimal scale of the returned value is setScale(2, RoundingMode.HALF_UP);
	 * @param subAccountId
	 * @return BigDecimal balance of account.
	 * @author Law Barstow  - 10/5/2012
	 */
	@Override
	public BigDecimal getBalance(int accountSubId) throws SQLException, Exception {
		return getBalance(accountSubId, true);
	}
	
	public BigDecimal getBalance(int accountSubId, boolean insertTransaction) throws SQLException, Exception {
		BigDecimal balance;
		List<Map<String, Object>> oResults = null;
		try {
			Connection connection = DataUtils.connect();
			String balanceQuery = "SELECT AvailableBalance from accountsub "
					+ "where accountsubid = " + accountSubId;
			
			oResults = DataUtils.selectData(balanceQuery, connection);
			
			balance = new BigDecimal(oResults.get(0).get("AvailableBalance").toString());
			balance.setScale(2, RoundingMode.HALF_UP);
			
			if (insertTransaction)
				insertTransaction(connection, accountSubId, new BigDecimal("0.00"), TransactionType.INQUIRY, FundType.NONE, balance, balance);
			
			connection.close();
		} catch (Exception e){
			e.printStackTrace();
			balance = new BigDecimal(0.0);
		}
		
		return balance;
	}
	
	public List <AccountSub> getAccountSubs(String cardNumber) throws SQLException, Exception {
		List<Map<String, Object>> oResults = null;
		List<AccountSub> accountSubs = new ArrayList();
		
		try {
			Connection connection = DataUtils.connect();
			
			String accountsubsQuery = "SELECT accountsub.* from accountsub, account "
					+ "where accountsub.AccountId = account.AccountId and account.CardNumber = '" + cardNumber + "'";
			
			oResults = DataUtils.selectData(accountsubsQuery, connection);
			
			for (int i=0; i < oResults.size(); i++){
				AccountSub accountSub = new AccountSub();
				accountSub.setAccountSubId((int) oResults.get(i).get("AccountSubId"));
				accountSub.setAccountType((int) oResults.get(i).get("AccountType"));
				System.out.println("index/id/type: " + i + "/" + accountSub.getAccountSubId() +"/"+accountSub.getAccountType());
			}
			
			connection.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return accountSubs;
		//return oResults;
	}
	
	/**
	 * getAccountSubIds
	 * Gets a comma seaparated list of sub account ids for a give account type
	 * @param cardNumber
	 * @param accountType
	 * @return String comma separated list of accountsubid numbers for a give account type
	 */public String getAccountSubIds(String cardNumber, int accountType) throws SQLException, Exception {
		List<Map<String, Object>> oResults = null;
		StringBuilder accountList = new StringBuilder("");

		try {
			Connection connection = DataUtils.connect();
		
			String accountsubsQuery = "SELECT accountsub.AccountSubId from accountsub, account "
					+ "where accountsub.AccountId = account.AccountId and accountsub.AccountType = " + accountType + " and account.CardNumber = '" + cardNumber + "'";
			
			oResults = DataUtils.selectData(accountsubsQuery, connection);
			
			for (int i=0; i < oResults.size(); i++){
				accountList.append(oResults.get(i).get("AccountSubId"));
				if ( oResults.size() - i != 1){
					accountList.append(",");
				}
			}
			
			connection.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return accountList.toString();
		//return oResults;
	}

	
	/**
	 * 
	 * @param account
	 * @param depositAmount
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	@Override
	public BigDecimal makeDeposit(int subAccountId, BigDecimal depositAmount) throws SQLException, Exception {
		return makeDeposit(subAccountId, depositAmount, FundType.UNKNONWN, true);		
	}
	
	@Override
	public BigDecimal makeDeposit(int subAccountId, BigDecimal depositAmount, FundType fundType) throws SQLException, Exception {
		return makeDeposit(subAccountId, depositAmount, fundType, true);	
	}
	
	/**
	 * 
	 * @param account
	 * @param depositAmount
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	
	public BigDecimal makeDeposit(int subAccountId, BigDecimal depositAmount, FundType fundType, boolean bAllowCommit) throws SQLException, Exception {
		boolean bSuccess = false;
		
		BigDecimal newBalance = new BigDecimal(0);
		BigDecimal currentBalance = new BigDecimal(0);
		
		try {
			currentBalance = getBalance(subAccountId, false);
			newBalance = currentBalance.add(depositAmount);
			
			Connection connection = DataUtils.connect();
			
			try {
				newBalance = makeDepositOrWithdrawl(connection, subAccountId, depositAmount, fundType, currentBalance, newBalance, TransactionType.DEPOSIT);				
				
				if (bAllowCommit)
					connection.commit();
				else
					connection.rollback();
				
				bSuccess = true;
			}
			catch (Exception ex) {
				connection.rollback();
			}
						
			connection.close();
		} 
		catch (Exception e) {
			e.printStackTrace();			
		}
		
		if (bSuccess)
			return newBalance;
		else
			throw new Exception("Deposit Failed.");
	}
	
	/**
	 * 
	 * @param connection - database connection to run statements on
	 * @param account
	 * @param depositAmount
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	private BigDecimal makeDepositOrWithdrawl(Connection connection, int subAccountId, BigDecimal amount, FundType fundType, BigDecimal currentBalance, BigDecimal newBalance, TransactionType transactionType) throws SQLException, Exception {
		boolean bSuccess = false;
		
		try {
			
			String query = "";
			
			if (transactionType == TransactionType.DEPOSIT)
				query = "UPDATE accountsub SET AvailableBalance = AvailableBalance + " + amount + " WHERE accountSubId = " + subAccountId;
			else if (transactionType == TransactionType.WITHDRAWAL)
				query = "UPDATE accountsub SET AvailableBalance = AvailableBalance - " + amount + " WHERE accountSubId = " + subAccountId;					
			
			int rowsAffected = DataUtils.processStatement(query, connection, false);
					
			if (rowsAffected != 1) {				
				throw new Exception("Something went wrong with this account: " + subAccountId);
			}
			
			try {
				insertTransaction(connection, subAccountId, amount, transactionType, fundType, currentBalance, newBalance);
				bSuccess = true;
			}
			catch (Exception ex) {
				throw new Exception("Problem inserting transaction. Cancelled reason: " + ex.getMessage());
			}
			
			currentBalance = getBalance(subAccountId, false);
			
			if (transactionType == TransactionType.DEPOSIT)
				newBalance = currentBalance.add(amount);
			else if (transactionType == TransactionType.WITHDRAWAL)
				newBalance = currentBalance.subtract(amount);
		}
		catch (Exception ex) {
			throw new Exception("Could not make this transaction: " + ex.getMessage());
		}
		
		if (bSuccess)
			return newBalance;
		else
			throw new Exception("Could not make this transaction.");
	}
	
	/**
	 * @TODO handle withdrawal limits and overdraft fees
	 * @param account
	 * @param withdrawalAmount
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	@Override
	public BigDecimal makeWithdrawal(int subAccountId, BigDecimal withdrawalAmount) throws SQLException, Exception {
		return makeWithdrawal(subAccountId, withdrawalAmount, true);
	}
	
	public BigDecimal makeWithdrawal(int subAccountId, BigDecimal withdrawalAmount, boolean bAllowCommit) throws SQLException, Exception {
		boolean bSuccess = false;
		
		BigDecimal newBalance = new BigDecimal(0);
		BigDecimal currentBalance = new BigDecimal(0);
		
		try {
			currentBalance = getBalance(subAccountId, false);
			newBalance = currentBalance.subtract(withdrawalAmount);
			
			Connection connection = DataUtils.connect();
			
			try {
				newBalance = makeDepositOrWithdrawl(connection, subAccountId, withdrawalAmount, FundType.CASH, currentBalance, newBalance, TransactionType.WITHDRAWAL);				
				
				if (bAllowCommit)
					connection.commit();
				else
					connection.rollback();
				
				bSuccess = true;
			}
			catch (Exception ex) {
				connection.rollback();
			}
						
			connection.close();
		} 
		catch (Exception e) {
			e.printStackTrace();			
		}
		
		if (bSuccess)
			return newBalance;
		else
			throw new Exception("Withdrawal Failed.");
	}

	@Override
	public Boolean createAccount(Account account) throws SQLException,
			Exception {
		Integer accountId = 0;

		try {
			Connection connection = DataUtils.connect();

			// use the customer object getters to build the query
			// p.s. you may want to use stringbuilder
			
			String createAccount = "INSERT INTO `ATMDB`.`account` (`AccountId`, `CardNumber`, `PrimaryCustomerId`, `PinNumber`, `FailedAttempts`, `AccountLocked`) "
					+ "VALUES (NULL, '"+account.getAccountNumber()+"', '"+account.getCustomerId()+"', '"+ account.getPinNumber() +"', '0', '0');";
			accountId = DataUtils.processStatementGetId(createAccount,connection, false);// autocommit? thats scary
            connection.commit();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			accountId = 0;
		}

		// should return the accountId of the new customer;
		return (accountId > 0);
	}
	
	public Boolean updateAccount(Account account) throws SQLException, Exception{
		Boolean updateSuccess = false;
		
		try{
			Connection connection = DataUtils.connect();
			String updateAccount = "UPDATE account "
					+ "SET PinNumber = '" + account.getPinNumber()
					+ "' WHERE AccountId = '" + account.getAccountId() + "';";
			
			int rowsAffected = DataUtils.processStatement(updateAccount,connection, false);
			
			if (rowsAffected == 1) {
				updateSuccess = true;
			} else {
				updateSuccess = false;
				connection.rollback();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			updateSuccess = false;
		}
		
		return updateSuccess;
	}
	
		/**
	 * @param Calendar transactionDate
	 * @param BigDecimal amount
	 * @param byte transacionType
	 * @param byte fundType
	 * @param BigDecimal startingBalance
	 * @param BigDecimal endingBalance
	 * @throws SQLException, Exception
	 * @author Law 
	 */
	
	private void insertTransaction (Connection connection, int accountSubId, Calendar transactionDate, BigDecimal amount, TransactionType transactionType, FundType fundType,
			BigDecimal startingBalance, BigDecimal endingBalance) throws SQLException, Exception
		{
		
		String dateString = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");

		if (transactionDate != null) {
			dateString = sdf.format(transactionDate.getTime());
		} 
		
		try {			
			String insertTransactionSQL ="Insert into transaction (accountSubId, transactiondate, amount, transactionType,"
					+ "fundtype, startingBalance, endingBalance) values ( " + Integer.toString(accountSubId) + ", '" +
					dateString + "', " + amount.toString() + ", " + transactionType.ordinal() +
					", "+ fundType.ordinal() + ", " + startingBalance.toString() +  " , " + endingBalance.toString()
					+ " ) ";
			
			int results = DataUtils.processStatement(insertTransactionSQL, connection, false);
						
			if (results == 0)
				throw new Exception("Could not insert transaction");						
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
	}
		
	private void insertTransaction (Connection connection, int accountSubId, BigDecimal amount, TransactionType transactionType, FundType fundType,
			BigDecimal startingBalance, BigDecimal endingBalance) 
			throws SQLException, Exception {
		
		Calendar now = GregorianCalendar.getInstance();
		insertTransaction(connection, accountSubId, now, amount, transactionType, fundType, startingBalance, endingBalance);			
		
	}
	
	
	//AccountSub methods begins here
	
	public Boolean createAccountSub(AccountSub accountSub) throws SQLException,	Exception {
		Integer accountId = 0;
		
		try {
			Connection connection = DataUtils.connect();
			
			String createAccountSub = "INSERT INTO `ATMDB`.`accountsub` (`AccountSubId`, `AccountId`, `AccountType`, `AvailableBalance`, `PendingCredits`, `HoldAmount`, `AwaitingRelease`)"
					+ " VALUES (123, '"+accountSub.getAccountId()+"', '"+accountSub.getAccountType()+"', '"+ accountSub.getAccountBalance() +"','"+accountSub.getPendingCredits()+"','"+
					accountSub.getHoldAmount()+"','"+accountSub.getAwaitingRelease()+"')";
			accountId = DataUtils.processStatementGetId(createAccountSub,connection, false);
		    connection.commit();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			accountId = 0;
		}
		
		return accountId > 0; // Returns true if it was able to create a new subaccount and get the account Id
	}

	@Override//requested method #2
	public Boolean updateAccountSub(AccountSub accountSub) throws SQLException,	Exception {
		int accountId =0;
		
		//Depending on which field is being updated call the update string
		String updateBalance = "UPDATE `ATMDB`.`accountsub` SET `AvailableBalance` = "+accountSub.getAccountBalance()+" WHERE `AccountSubId` = "+
				accountSub.getAccountSubId();
				
		String updateCredits = "UPDATE `ATMDB`.`accountsub` SET `PendingCredits` = "+accountSub.getPendingCredits()+" WHERE `AccountSubId` = "+
				accountSub.getAccountSubId();
		
		String updateHoldAmt = "UPDATE `ATMDB`.`accountsub` SET `HoldAmount` = "+accountSub.getHoldAmount()+" WHERE `AccountSubId` = "+
				accountSub.getAccountSubId();
		
		String updateAwaitingRel = "UPDATE `ATMDB`.`accountsub` SET `AwaitingRelease` = "+accountSub.getAwaitingRelease()+" WHERE `AccountSubId` = "+
				accountSub.getAccountSubId();
						
				try
				{//not sure why I need accountID but I left it in until I get more clarification
					Connection connection = DataUtils.connect();
					accountId = DataUtils.processStatementGetId(updateBalance,connection, false);
					accountId = DataUtils.processStatementGetId(updateCredits,connection, false);
					accountId = DataUtils.processStatementGetId(updateHoldAmt,connection, false);
					accountId = DataUtils.processStatementGetId(updateAwaitingRel,connection, false);
		            connection.commit();
					connection.close();
					 
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
		
		return true;
	}
	
	public List<Map<String,Object>> getAccountSub(int accountSubId)  throws SQLException, Exception {
		//not sure if this should be in the DAO or not. made the return a list instead of an accountsub object
	//	will this return something we can use? trying to use the function Law wrote to return a list of values from the query
	
		List<Map<String,Object>> AccountSubInfo = new ArrayList<Map<String, Object>>();
		
		try {
			Connection connection = DataUtils.connect();
			
			String viewAccountSub = "SELECT * FROM `ATMDB`.`accountsub` WHERE `AccountSubId` = "+accountSubId;
			AccountSubInfo = DataUtils.selectData(viewAccountSub, connection);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return AccountSubInfo;
	}

	@Override
	public BigDecimal getBalanceFromCardNumber(String cardNumber)
			throws SQLException, Exception {
		BigDecimal balance;
		List<Map<String, Object>> oResults = null;
		try {
			Connection connection = DataUtils.connect();
			String balanceQuery = "SELECT * FROM account a LEFT JOIN accountsub asb ON asb.AccountId = a.AccountId WHERE a.CardNumber = '" + cardNumber + "'";
			
			oResults = DataUtils.selectData(balanceQuery, connection);
			
			balance = new BigDecimal(oResults.get(0).get("AvailableBalance").toString());
			balance.setScale(2, RoundingMode.HALF_UP);
			
			connection.close();
		} catch (Exception e){
			e.printStackTrace();
			balance = new BigDecimal(0.0);
		}
		
		return balance;
	}

	
}
