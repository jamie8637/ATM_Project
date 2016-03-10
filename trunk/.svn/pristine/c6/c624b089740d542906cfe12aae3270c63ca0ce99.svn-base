import java.io.IOException;
import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.text.NumberFormat;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import atm.business.api.model.BankUser;
import atm.business.api.services.BankServiceException;

import com.presentation.service.AtmService;
import com.presentation.service.BankSystemService;
import com.presentation.service.CustomerSystemService;

/**
 * The Class Managermain.
 */
public class ManagerMain {
	private static final String ATM_VERSION = "0.06";
	
	// ATM Initialization Variables
	private static BigDecimal amountInATM = new BigDecimal(1000.00);
	private static String bankName = "SD Bank";

	private static String entered;
	public static Scanner sc = new Scanner(System.in);
	
	public static NumberFormat formatMoney = NumberFormat.getCurrencyInstance();
	private static BankUser user;

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		displayWelcomeScreen();

			entered = sc.nextLine();
			if (entered != null) {
				try {
					CustomerSystemService.connect();
					int selected;
					selected = MainMenu.displayMainMenu();
					System.out.println(selected);
					MainMenu.processMainMenuSelection(selected);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			}

	}

	/**
	 * Display welcome screen.
	 */
	private static void displayWelcomeScreen() {
		System.out.println();
		System.out.printf("%38s%n", "Welcome Manager");
		System.out.println();
		System.out.println("**************************************************");
		System.out.println();
		System.out.printf("%38s%n", "Press any key to login.");
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
			// Handle exception.
		}
	}
	
	public static void printHeader(){
		clearScreen();
		System.out
				.println("**************************************************");
		System.out.printf("Manager Interface = v 1.2.3");
		System.out.println();
	}

}
