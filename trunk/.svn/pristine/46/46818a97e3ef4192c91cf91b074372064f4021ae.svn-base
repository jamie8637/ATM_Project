package atm.business.server.services;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import atm.business.api.model.Account;
import atm.business.api.model.AccountSub;
import atm.business.api.model.BankUser;
import atm.business.api.services.AccountService;
import atm.business.api.services.BankServiceException;
import data.AccountDAO;

public class AccountServiceImpl implements AccountService{
	
	private AccountDAO accountDao;
	private Logger logger = Logger.getLogger(AccountServiceImpl.class);

	public AccountDAO getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}
	
	@Override
	public BigDecimal getUserBalance(BankUser user) throws BankServiceException {
		try {
			return accountDao.getBalanceFromCardNumber(user.getCardNumber());
		} catch (SQLException e) {
			throw new BankServiceException("SQL Exception Occurred " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println(e);
			throw new BankServiceException("Unable to convert card number to account ID");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BankServiceException("An Unknown Exception Occurred " + e.getMessage());
		} 
	}
	
	@Override
	public void makeDeposit(Integer accountSubId, BigDecimal amount) throws BankServiceException {
		try {
			accountDao.makeDeposit(accountSubId, amount);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			throw new BankServiceException("SQL Exception Occurred " + e.getMessage());
		} catch (NumberFormatException e) {
			throw new BankServiceException("Unable to convert card number to account ID");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BankServiceException("An Unknown Exception Occurred " + e.getMessage());
		} 
	}
	
	@Override
	public void makeWithdrawl(Integer subAccountId, BigDecimal amount) throws BankServiceException {
		try {
			accountDao.makeWithdrawal(subAccountId, amount);
		} catch (SQLException e) {
			throw new BankServiceException("SQL Exception Occurred " + e.getMessage());
		} catch (NumberFormatException e) {
			throw new BankServiceException("Unable to convert card number to account ID");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BankServiceException("An Unknown Exception Occurred " + e.getMessage());
		} 
	}


	@Override
	public List<AccountSub> getAccountSubs(String cardNumber) throws BankServiceException {
		try {
			return accountDao.getAccountSubs(cardNumber);
		} catch (SQLException e) {
			throw new BankServiceException("SQL Exception Occurred " + e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BankServiceException("An Unknown Exception Occurred " + e.getMessage());
		} 
	}
	
	@Override
	public String getAccountSubIds(String cardNumber, Integer accountType) throws BankServiceException {
		try {
			return accountDao.getAccountSubIds(cardNumber, accountType);
		} catch (SQLException e) {
			throw new BankServiceException("SQL Exception Occurred " + e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BankServiceException("An Unknown Exception Occurred " + e.getMessage());
		} 
	}

	@Override
	public BigDecimal getAccountSubBalance(Integer accountsubId) throws BankServiceException {
		try {
			return accountDao.getBalance(accountsubId);
			//return null;
		//} catch (SQLException e) {
//			throw new BankServiceException("SQL Exception Occurred " + e.getMessage());
		} catch (NumberFormatException e) {
			throw new BankServiceException("Unable to convert card number to account ID");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BankServiceException("An Unknown Exception Occurred " + e.getMessage());
		} 
	}

	@Override
	public Boolean createAccount(Account account) throws BankServiceException {
		// TODO Auto-generated method stub
		try {
			return accountDao.createAccount(account);
		} catch (SQLException e) {
			throw new BankServiceException("SQL Exception Occurred " + e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BankServiceException("An Unknown Exception Occurred " + e.getMessage());
		} 
	}
	
	@Override
	public Boolean updateAccount(Account account) throws BankServiceException {
		// TODO Auto-generated method stub
		try {
			return accountDao.updateAccount(account);	
		} catch(SQLException e){
			throw new BankServiceException("SQL Exception Occured " + e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BankServiceException("An Unknown Exception Occurred " + e.getMessage());
		} 
	}

	@Override
	public Boolean createAccountSub(AccountSub accountSub) throws BankServiceException {
		try {
			return accountDao.createAccountSub(accountSub);
		} catch (SQLException e) {
			throw new BankServiceException("SQL Exception Occured " + e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BankServiceException("An Unknown Exception Occurred " + e.getMessage());
		}
	}
	
	@Override
	public Boolean updateAccountSub(AccountSub accountSub) throws BankServiceException {
		try {
			return accountDao.updateAccountSub(accountSub);
		} catch (SQLException e) {
			throw new BankServiceException("SQL Exception Occured " + e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BankServiceException("An Unknown Exception Occurred " + e.getMessage());
		}		
	}
}
