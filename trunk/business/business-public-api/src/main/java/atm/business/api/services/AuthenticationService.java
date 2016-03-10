package atm.business.api.services;

import atm.business.api.model.Session;

/**
 * Provides authentication functionality.
 * 
 * @author Mike Wilson
 * 
 */
public interface AuthenticationService {

	boolean authenticate(String cardNumber, String pin)
			throws AuthenticationException;

}
