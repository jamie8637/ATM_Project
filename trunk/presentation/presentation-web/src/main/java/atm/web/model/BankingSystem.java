package atm.web.model;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.util.List;

import javax.faces.convert.BigDecimalConverter;
import javax.persistence.Convert;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;

import atm.business.api.model.BankUser;
import atm.business.api.model.Customer;
import atm.business.api.services.*;

import com.presentation.service.BankSystemService;
import com.presentation.service.CustomerSystemService;

/**
 * This class represents the banking subsystem and implements a Singleton design
 * pattern (I think..).
 * 
 * @author Adrian R. and Aaron Bickhaus
 */

public class BankingSystem {

	private static BankingSystem instance = null;
	private BankUser user;
	private BigDecimal balance;
	static Logger logger = Logger.getLogger("org.apache.log4j.PatternLayout");
	
	protected BankingSystem() {
	}

	private Customer customer;

	/**
	 * Returns an instance of Banking System.
	 * 
	 * @return BankingSystem
	 */
	public static BankingSystem getInstance() {
		if (instance == null)
			instance = new BankingSystem();
		return instance;
	}

	/**
	 * Authenticates a BankUser.
	 * 
	 * @param request
	 * @param response
	 * @return Boolean
	 * @throws Exception 
	 */
	public Boolean authenticate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		user = new BankUser();
		user.setCardNumber(request.getParameter("cardnumber"));
		user.setPin(request.getParameter("pin"));

		BankSystemService.connect();

		return BankSystemService.validateUserLogin(user);
	}
	
	/**
	 * Creates a customer
	 * 
	 * @param request
	 * @param response
	 * @return Boolean
	 * @throws Exception
	 */
	public Boolean createCustomer(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		customer = new Customer();
		customer.setAddress(request.getParameter("txtAddress"));
		customer.setCity(request.getParameter("txtCity"));
		customer.setCustomerFirst(request.getParameter("txtFirstName"));
		customer.setCustomerId(null);
		customer.setCustomerLast(request.getParameter("txtLastName"));
		customer.setEmail(request.getParameter("txtEmail"));
		customer.setPassword(request.getParameter("txtPassword"));
		customer.setPhone(request.getParameter("txtPhone"));
		customer.setPostal(request.getParameter("txtPostalCode"));
		customer.setState(request.getParameter("txtState"));
		customer.setUsername(request.getParameter("txtUserName"));

		BankSystemService.connect();
		try {
			BankSystemService.createCustomer(customer);
			
			return true;
		} catch (BankServiceException e) {
			logger.error("BankServiceException Class:BankingSystem in createCustomer");
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Retrieves account balance.
	 * 
	 * @return
	 * @throws BankServiceException
	 */
	public double getBalance(String cardNumber) throws BankServiceException {

		user = new BankUser();
		user.setCardNumber(cardNumber);
		balance = BankSystemService.getBalanace(user);
		return balance.doubleValue();
	}

	/**
	 * Makes a deposit
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public boolean makeDeposit(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		try {
			String accountSubId =  BankSystemService.
					getAccountSubIds((session.getAttribute("cardNumber")).toString(),
								1);
			
			String formatSubId = accountSubId.replace(",8", "");
		
			
			String amount = request.getParameter("txtAmount");
			BigDecimal bigAmount = new BigDecimal(amount);
					
			BankSystemService.makeDeposit(Integer.parseInt(formatSubId), bigAmount);
			
			
			
		} catch (BankServiceException e) {
			// TODO Auto-generated catch block
			logger.error("BankServiceException Class:BankingSystem in makeDeposit");
			e.printStackTrace();
			return false;
		}
		return true;
			
	}

	/**
	 * Makes a withdrawal
	 * 
	 * @param request
	 * @param response
	 * @return boolean
	 */
	public boolean makeWithdraw(HttpServletRequest request,
			HttpServletResponse response) {
	
		HttpSession session = request.getSession();
		
		try {
			String accountSubId =  BankSystemService.
					getAccountSubIds((session.getAttribute("cardNumber")).toString(),
								1);
			
			String formatSubId = accountSubId.replace(",8", "");
		
			
			String amount = request.getParameter("txtAmount");
			BigDecimal bigAmount = new BigDecimal(amount);
			
			BankSystemService.makeWithdrawl(Integer.parseInt(formatSubId), bigAmount);
		} catch (BankServiceException e) {
			// TODO Auto-generated catch block
			logger.error("BankServiceException Class:BankingSystem in makeWithdraw");
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
