package atm.business.api.services;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import atm.business.api.model.Account;
import atm.business.api.model.AccountSub;
import atm.business.api.model.BankUser;

public interface AccountService {

	BigDecimal getUserBalance(BankUser user) throws BankServiceException;
	BigDecimal getAccountSubBalance(Integer accountsubId) throws BankServiceException;
	List getAccountSubs(String cardNumber) throws BankServiceException;
	void makeDeposit(Integer accountSubId, BigDecimal amount) throws BankServiceException;
	void makeWithdrawl(Integer accountSubId, BigDecimal amount) throws BankServiceException;
	Boolean createAccount(Account account) throws BankServiceException;
	Boolean updateAccount(Account account) throws BankServiceException;
	Boolean createAccountSub(AccountSub accountSub) throws BankServiceException;
	Boolean updateAccountSub(AccountSub accountSub) throws BankServiceException;
	String getAccountSubIds(String cardNumber, Integer accountType) throws BankServiceException;
}
