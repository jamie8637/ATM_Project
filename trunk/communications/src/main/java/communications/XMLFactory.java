package communications;

import org.apache.log4j.Logger;
import atm.business.api.model.BankUser;

/**
 * 
 * @author aaron Bickhaus
 * 
 */
public class XMLFactory {
	static Logger logger = Logger.getLogger("org.apache.log4j.PatternLayout");

	/**
	 * method used to convert Bankuser to authentication xml
	 * 
	 * @param bankUser
	 * @return
	 */
	public static String authenicationXML(BankUser bankUser) {
		logger.info("converted BankUser to xml string Class:XMLFactory line# 19");
		return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
				+ "<BankUser><creditcardnumber>"
				+ bankUser.getCardNumber()
				+ "</creditcardnumber>"
				+ "<pinNumber>"
				+ bankUser.getPin()
				+ "</pinNumber>" + "</BankUser>";

	}

	/**
	 * method used to convert response class to xml string
	 * 
	 * @param authenticationResponse
	 * @return
	 */
	public static String authenicationXMLResponse(
			AuthenticationResponse authenticationResponse) {
		logger.info("converted Autehntication response to xml string  Class:XMLFactory line# 37");
		return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
				+ "<AuthenticationResponse><responsecode>"
				+ authenticationResponse.getAuthenticationResponseCode()
				+ "</responsecode>"
				+ "<responsemessage>"
				+ authenticationResponse.getAuthenticationErrorDescription()
				+ "</responsemessage>" + "</AuthenticationResponse>";
	}

}
