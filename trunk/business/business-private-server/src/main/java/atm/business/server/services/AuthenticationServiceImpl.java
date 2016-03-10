package atm.business.server.services;

import org.apache.log4j.Logger;

import atm.business.api.services.AuthenticationException;
import atm.business.api.services.AuthenticationService;
import atm.business.server.dal.AuthenticationAttemptDao;
import atm.business.server.dal.BankUserDao;
import atm.business.server.dal.SessionDao;
import data.AccountRepository;

/**
 * 
 * @author Mike Wilson
 * 
 */
public class AuthenticationServiceImpl implements AuthenticationService {

	private Logger logger = Logger.getLogger(CustomerServiceImpl.class);

	private BankUserDao bankUserDao;
	private SessionDao sessionDao;
	private AuthenticationAttemptDao authenticationAttemptDao;

	public AuthenticationServiceImpl() {

	}

	public void setBankUserDao(BankUserDao bankUserDao) {
		this.bankUserDao = bankUserDao;
	}

	public void setSessionDao(SessionDao sessionDao) {
		this.sessionDao = sessionDao;
	}

	public void setAuthenticationAttemptDao(
			AuthenticationAttemptDao authenticationAttemptDao) {
		this.authenticationAttemptDao = authenticationAttemptDao;
	}

	public boolean authenticate(String cardNumber, String pin)
			throws AuthenticationException {

		try {
			if (!AccountRepository.getInstance().authenticate(cardNumber, pin)) {
				throw new AuthenticationException("Invalid card number or pin");
			}
		} catch (AuthenticationException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new AuthenticationException("Failed authentication attempt: "
					+ e.getMessage());
		}

		return true;
	}
}
