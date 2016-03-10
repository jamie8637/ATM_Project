package communications;

import static org.junit.Assert.*;

import org.junit.Test;

public class AuthenticationResponseTest {

	/**
	 * Method used to test authentication response desciption
	 */
	 
	@Test
	public void testAuthenticationResponseErrorDescription() {
		AuthenticationResponse response = new AuthenticationResponse();
		
		response.setAuthenticationErrorDescription("Balance Error!");
		
		assertEquals("Balance Error!", response.getAuthenticationErrorDescription());
	}
	
	@Test
	public void testAuthenticationResponseCode() {
		AuthenticationResponse response = new AuthenticationResponse(5,"String");
		
		assertEquals(5, response.getAuthenticationResponseCode());
		response.setAuthenticationResponseCode(3);
		assertEquals(3, response.getAuthenticationResponseCode());
	}
	
}
