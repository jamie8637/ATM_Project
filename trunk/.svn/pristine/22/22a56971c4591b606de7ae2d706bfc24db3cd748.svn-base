package atm;

import atm.business.api.services.BankServiceException;

import com.presentation.service.BankSystemService;

/**
 * Class to handle code for Main Menu options
 */
public class MainMenu {

	/**
	 * Display main menu.
	 * @return 
	 */
	public static void displayMainMenu() {
		// Displays main menu after successful login
		int selected = -1;
		ATMmain.isError = false;
		ATMmain.printHeader();
		System.out.printf("%31s%n", "Main Menu");
		System.out.println();
		System.out.printf("%30s\tPress 1\n", "View Account Balance");
		System.out.printf("%30s\tPress 2\n", "Withdraw Funds");
		System.out.printf("%30s\tPress 3\n", "Deposit Funds");
		System.out.printf("%30s\tPress 0\n", "Logout of ATM");
		System.out.println();
		System.out.print("Enter Selection and Press Enter: ");
		
		try {
			selected = ATMmain.sc.nextInt();
		} catch (Exception e) {
			ATMmain.clearScreen();
			ATMmain.printHeader();
			System.out.println("You entered an invalid option.");
			System.out.println();
			System.out.printf("%38s%n", "Press any key to return to Main Menu.");
			System.out.println();
			System.out.println("**************************************************");
			ATMmain.sc.nextLine();
		}
		
		processMainMenuSelection(selected);
	}
	
	public static void processMainMenuSelection(int selected) {
		switch(selected){
		case 0:
			ATMmain.setUser(null);
			break;
		case 1:
			Balance.displayAccountBalanceMenu();
			break;
		case 2:
			Withdrawal.displayAccountTypeSelectionMenu();
			break;
		case 3:
			Deposit.displayDepositSelectionMenu();
			break;
		default:
			displayMainMenu();
			break;
		}
	}
	
}
