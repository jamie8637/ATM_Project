package atm;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import atm.business.api.model.AccountSub;
import atm.business.api.model.BankUser;

import com.presentation.service.AtmService;
import com.presentation.service.BankSystemService;

/**
 * The Class ATMmain.
 */
public class ATMmain {
	private static final String ATM_VERSION = "1.0.1";
	
	// ATM Initialization Variables
	private static BigDecimal amountInATM = new BigDecimal(1000.00);
	private static String bankName = "SD Bank";

	public static String entered;
	public static Scanner sc = new Scanner(System.in);
	
	public static NumberFormat formatMoney = NumberFormat.getCurrencyInstance();
	private static BankUser user;
	private static Boolean returnToMain;
	public static List<AccountSub> checkingAccounts = new ArrayList<AccountSub>();
	public static List<AccountSub> savingsAccounts = new ArrayList<AccountSub>();
	public static Boolean isError = false;

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		// Initialize ATM with cash and bankType
		AtmService.initializeAtm(amountInATM, bankName);

		// Loop while ATM is functional
		try {
			while (AtmService.isFunctional()) {
				displayWelcomeScreen();
				checkingAccounts.clear();
				savingsAccounts.clear();

				// Stay on welcome screen until user presses Enter key to login
				returnToMain = false;
				entered = sc.nextLine();
				while(entered != null && !returnToMain) {
					user = Login.displayLoginScreen();
					BankSystemService.connect();
					if (BankSystemService.validateUserLogin(user)){
						while (AtmService.isFunctional() && user != null){
							//Get list of checking and savings accounts
							checkingAccounts = BankSystemService.getCheckingAccounts(user.getCardNumber());
							savingsAccounts = BankSystemService.getSavingsAccounts(user.getCardNumber());

							MainMenu.displayMainMenu();
							// TODO Run timer for inactive logout
						}
						returnToMain = true;
						entered = sc.nextLine();
						break;
					} else {
						Login.displayInvalidLogin();
						returnToMain = false;
					}
				}
			}
		} catch (Exception ex) {
			String failureMessage = ex.getMessage();
			AtmService.setFailureState(failureMessage, false);
		}

		if (!AtmService.isFunctional()) {
			// TODO Display error message
		}
	}

	/**
	 * Display welcome screen.
	 */
	private static void displayWelcomeScreen() {
		printHeader();
		System.out.println();
		System.out.printf("%38s%n", "Press Enter key to login.");
		System.out.println();
		System.out.println("**************************************************");
	}

	public static void clearScreen() {
		//Cheat clear screen by using new lines
		for(int i = 0; i < 25; i++){
			System.out.println("");
		}
		
		try {
			Runtime.getRuntime().exec("clear");
			String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (Exception exception) {
		}
	}
	
	public static String getATMversion(){
		return ATM_VERSION;
	}
	
	private static String printATMversion(){
		return "ATM Software v" + getATMversion();
	}
	
	public static void printHeader(){
		clearScreen();
		System.out
				.println("**************************************************");
		System.out.printf("%28s%4s%15s%n ", bankName ,"", printATMversion());
		System.out.println();
	}
	
	public static BankUser getUser(){
		return user;
	}
	
	protected static void setUser(BankUser user){
		ATMmain.user = user;
	}
	
	protected static void displayErrorMessage(String message) {
		ATMmain.isError=true;
		ATMmain.clearScreen();
		ATMmain.printHeader();
		System.out.println(message);
		System.out.println();
		System.out.printf("%38s%n", "Press any key to return to Main Menu.");
		System.out.println();
		System.out.println("**************************************************");
		ATMmain.sc.nextLine();
	}

}
