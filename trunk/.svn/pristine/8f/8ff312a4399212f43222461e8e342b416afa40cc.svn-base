package communications;

import org.junit.Test;

import communications.XmlParserUtility;

import atm.business.api.model.BankUser;

public class TestXmlParserUtility {

	@Test
	public void testXMLParseAuthentication() {
		BankUser user = new BankUser();
		user.setCardNumber("12345");
		user.setPin("123");

		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
				+ "<BankUser>"
				+ "<creditcardnumber>"
				+ user.getCardNumber()
				+ "</creditcardnumber>"
				+ "<pinnumber>"
				+ user.getPin()
				+ "</pinnumber>" + "</BankUser>";

		user = XmlParserUtility.parseAuthentication(xml);
		// assertEquals(123456, user.getCardNumber(),
		// Math.abs(user.getCardNumber()));
	}

}
