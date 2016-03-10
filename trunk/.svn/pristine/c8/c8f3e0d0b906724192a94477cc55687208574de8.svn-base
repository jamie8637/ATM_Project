package atm;
import atm.business.api.model.BankUser;

/**
 * Class to handle login
 */
public class Login {

	/**
	 * Display login screen.
	 * 
	 * @return the bank user
	 */
	protected static BankUser displayLoginScreen() {
		BankUser user = new BankUser();
		// Display login screen asking user to input credentials
		ATMmain.printHeader();
		System.out.println();
		System.out.printf("%38s", "Enter your account number: ");
		user.setCardNumber(ATMmain.sc.nextLine());
		System.out.printf("%38s", "Enter your pin: ");
		user.setPin(ATMmain.sc.nextLine());
		return user;
	}

	/**
	 * Display invalid login.
	 */
	protected static void displayInvalidLogin() {
		// Displays error after wrong user/pin entered.
		ATMmain.printHeader();
		System.out.printf("%31s%n", "LOGIN ERROR");
		System.out.println();
		System.out.printf("%42s%n", "ERROR - Your PIN was not correct");
		System.out.println();
		System.out.printf("%38s%n", "Press any key to try again.");
		System.out.println();
		System.out.println("**************************************************");
		ATMmain.sc.nextLine();
	}
	
}
