package communications;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import atm.business.api.model.BankUser;

import communications.XMLFactory;
import communications.AuthenticationResponse;

public class TestXMLFactory {

	//@Test
	// test to ensure bank is returning correct xml string
	public void testXMLFactory() {

		BankUser user = new BankUser();
		user.setCardNumber("123456");
		user.setPin("1234");
		assertEquals(
				"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
						+ "<BankUser>" + "<creditcardnumber>" + 123456
						+ "</creditcardnumber>" + "<pinNumber>" + 1234
						+ "</pinNumber>" + "</BankUser>",
				XMLFactory.authenicationXML(user));
	}

	//@Test
	// test used to test xml fatory authentication response
	public void testXMLFactoryAuthenticationResponse() {

		AuthenticationResponse response = new AuthenticationResponse();
		response.setAuthenticationResponseCode(5);
		response.setAuthenticationErrorDescription("success");

		assertEquals(
				"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
						+ "<AuthenticationResponse>" + "<responsecode>" + 5
						+ "</responsecode>" + "<responsemessage>" + "success"
						+ "</responsemessage>" + "</AuthenticationResponse>",
				XMLFactory.authenicationXMLResponse(response));
	}

}
