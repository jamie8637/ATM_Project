package com.presentation.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import atm.business.api.model.Account;
import atm.business.api.model.AccountSub;
import atm.business.api.model.BankUser;
import atm.business.api.model.Customer;
import atm.business.api.services.AccountService;
import atm.business.api.services.AuthenticationException;
import atm.business.api.services.AuthenticationService;
import atm.business.api.services.BankServiceException;
import atm.business.api.services.CustomerService;
import fromBusinesTeam.JAXBContextFactory;
import fromBusinesTeam.StubFactory;
import fromBusinesTeam.TcpClient;

// TODO: Auto-generated Javadoc
/**
 * The Class BankSystemService.
 */
public class BankSystemService {

	private static StubFactory stubFactory;
	private static TcpClient tcpClient;

	/**
	 * Connect.
	 * 
	 * @return true, if successful
	 * @throws Exception 
	 */
	public static boolean connect() throws Exception {
		JAXBContext jaxb = JAXBContextFactory.createContext();
		Properties properties = new Properties();
		properties.load(BankSystemService.class.getClassLoader().getResourceAsStream("server.properties"));
		tcpClient = new TcpClient(properties.getProperty("server.url"), Integer.valueOf(properties.getProperty("server.port")));

		stubFactory = new StubFactory(tcpClient, jaxb.createMarshaller(),
				jaxb.createUnmarshaller());
		return true;
	}

	/**
	 * Disconnect.
	 * 
	 * @return true, if successful
	 */
	public static void disconnect() {
		if (tcpClient != null)
			tcpClient.disconnect();
	}

	/**
	 * Determine if the connection already exists
	 * 
	 * @return
	 */
	public static boolean isClosed() {
		if (tcpClient != null)
			return tcpClient.isConnected();
		else
			return true;
	}

	/**
	 * Validate user login.
	 * 
	 * @param user
	 *            the user
	 * @return true, if successful
	 */
	public static boolean validateUserLogin(BankUser user) {
		boolean result;
		
		if (!isClosed()) {
			AuthenticationService service = stubFactory
					.createStub(AuthenticationService.class);
			try {
				result = service.authenticate(user.getCardNumber(),
						user.getPin());
			} catch (AuthenticationException e) {
				result = false;
			}
		} else {
			result = false;
		}
		
		return result;
	}

	/**
	 * Gets the balanace.
	 * 
	 * @return the balanace
	 * @throws BankServiceException 
	 * this method is useless
	 */
	public static BigDecimal getBalanace(BankUser user) throws BankServiceException {
			
		if(!isClosed()) {
			AccountService service = stubFactory.createStub(AccountService.class);
			return service.getUserBalance(user);
		} else {
			throw new BankServiceException("Not connected to the database");
		}
	}
	
	public static void makeDeposit(int accountSubId, BigDecimal amount) throws BankServiceException {
		
		if(!isClosed()) {
			AccountService service = stubFactory.createStub(AccountService.class);
			service.makeDeposit(accountSubId, amount);
		} else {
			throw new BankServiceException("Not connected to the database");
		}
	}
	
	public static void makeWithdrawl(int accountSubId, BigDecimal amount) throws BankServiceException {
		
		if(!isClosed()) {
			AccountService service = stubFactory.createStub(AccountService.class);
			try {
				service.makeWithdrawl(accountSubId, amount);
			} catch (Exception ex) {
				//if(ex.getMessage().contains("This withdrawl would put the account in a negative balance")) {
					throw new BankServiceException(ex.getMessage());
				//}
			}
		} else {
			throw new BankServiceException("Not connected to the database");
		}
	}
	
	
	/**
	 * Gets the balanace of an AccountSub.
	 * 
	 * @return the balanace
	 * @throws BankServiceException 
	 */
	public static BigDecimal getAccountSubBalance(int accountsubId) throws BankServiceException {
		
		if(!isClosed()) {
			AccountService service = stubFactory.createStub(AccountService.class);
			return service.getAccountSubBalance(accountsubId);
		} else {
			throw new BankServiceException("Not connected to the database");
		}
	}
	
	/**
	 * Gets the list of checking account id numbers
	 * 
	 * @return the list of accountsubs separate by commas
	 * @throws BankServiceException 
	 */
	public static String getAccountSubIds(String cardNumber, int accountType) throws BankServiceException {
		
		if(!isClosed()) {
			AccountService service = stubFactory.createStub(AccountService.class);
			return service.getAccountSubIds(cardNumber, accountType);
		} else {
			throw new BankServiceException("Not connected to the database");
		}
	}
	
	public static List<AccountSub> getCheckingAccounts(String cardNumber) throws BankServiceException{
		List<AccountSub> accountSubs = new ArrayList<AccountSub>();
		String accountCSV = getAccountSubIds(cardNumber, 0);
		if (!accountCSV.equalsIgnoreCase("")){
			String[] accounts = accountCSV.split(",");
			for(String account : accounts){
				AccountSub acct = new AccountSub();
				acct.setAccountSubId(Integer.parseInt(account));
				acct.setAccountType(0);
				accountSubs.add(acct);
			}
		}
		return accountSubs;
	}
	
	public static List<AccountSub> getSavingsAccounts(String cardNumber) throws BankServiceException{
		List<AccountSub> accountSubs = new ArrayList<AccountSub>();
		String accountCSV = getAccountSubIds(cardNumber, 1);
		if (!accountCSV.equalsIgnoreCase("")){
			String[] accounts = accountCSV.split(",");
			for(String account : accounts){
				AccountSub acct = new AccountSub();
				acct.setAccountSubId(Integer.parseInt(account));
				acct.setAccountType(0);
				accountSubs.add(acct);
			}
		}
		return accountSubs;
	}
	
	public static List getAccountSubs(String cardNumber) throws BankServiceException {
		
		if(!isClosed()) {
			AccountService service = stubFactory.createStub(AccountService.class);
			return service.getAccountSubs(cardNumber);
		} else {
			throw new BankServiceException("Not connected to the database");
		}
	}

	public static Boolean createAccount(Account account) throws BankServiceException {
		
		if(!isClosed()) {
			AccountService service = stubFactory.createStub(AccountService.class);
			return service.createAccount(account);
		} else {
			throw new BankServiceException("Not connected to the database");
		}
	}
	
	public static Integer createCustomer(Customer customer) throws BankServiceException {
		
		if(!isClosed()) {
			CustomerService service = stubFactory.createStub(CustomerService.class);
			return service.createCustomer(customer);
		} else {
			throw new BankServiceException("Not connected to the database");
		}
	}
	
	public static Boolean updateCustomer(Customer customer) throws BankServiceException {
		
		if(!isClosed()) {
			CustomerService service = stubFactory.createStub(CustomerService.class);
			return service.updateCustomer(customer);
		} else {
			throw new BankServiceException("Not connected to the database");
		}
	}
	
	/**
	 * Finish Defining Once data model becomes more clear withdrawFunds()
	 * depositFunds() checkBalance()
	 */
}
