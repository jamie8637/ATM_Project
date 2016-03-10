package atm;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import atm.business.api.services.BankServiceException;
import atm.business.api.model.AccountSub;
import com.presentation.service.BankSystemService;

/**
 * Class to handle code for Balance transactions
 */
public class Balance {
	public static void displayAccountBalance(int option, int selection) {
		// Displays Account Balance menu options
		String accountName = "";
		BigDecimal balance = new BigDecimal(0.0);
		AccountSub account = new AccountSub();
		
		if(option == 1){
			accountName = "Checking";
			account = ATMmain.checkingAccounts.get(selection - 1);
		} else if (option == 2){
			accountName = "Savings";
			account = ATMmain.savingsAccounts.get(selection - 1);
		} else {
			//displayMainMenu();
		}
		
		try {
			balance = BankSystemService.getAccountSubBalance(account.getAccountSubId());
		} catch (BankServiceException e) {
			ATMmain.displayErrorMessage("There was an error. Please try again later.");
		}
			
		if(!ATMmain.isError){
			ATMmain.printHeader();
			System.out.printf("%21s %s%n", accountName.toUpperCase(), "ACCOUNT BALANCE");
			System.out.println();
			System.out.printf("%30s%n", ATMmain.formatMoney.format(balance));
			System.out.println();
			System.out.printf("%30s\tPress 0\n", "Return to Main Menu");
			System.out.println();
			System.out.print("Enter Selection and Press Enter: ");
			try{
				processAccountBalanceSelection(ATMmain.sc.nextInt());
			} catch (Exception e){
				ATMmain.sc.nextLine();
				displayAccountBalance(option, selection);
			}
		}
	}
	
	

	private static void processAccountBalanceSelection(int selected) {
		switch(selected){
		case 1:
			break;
		default:
			ATMmain.isError=true;
			//displayMainMenu();
			break;
		}
	}
	
	public static void displayAccountBalanceMenu() {
		// Displays Account Balance menu options
		ATMmain.printHeader();
		System.out.printf("%36s%n", "VIEW ACCOUNT BALANCE");
		System.out.println();
		
		if(ATMmain.checkingAccounts.size() > 0){
			System.out.printf("%30s\tPress 1\n", "Checking Account");
		}
		
		if(ATMmain.savingsAccounts.size() > 0){
			System.out.printf("%30s\tPress 2\n", "Savings Account");
		}
		
		System.out.printf("%30s\tPress 0\n", "Return to Main Menu");
		System.out.println();
		System.out.print("Enter Selection and Press Enter: ");
		try{
			int selection =  ATMmain.sc.nextInt();
			if (selection > 0){
				Balance.displayAccountIdsMenu(selection);
			}
		} catch (Exception e){
			ATMmain.sc.nextLine();
			displayAccountBalanceMenu();
		}
	}
	
	public static void displayAccountIdsMenu(int option) {
		// Displays Account Balance menu options
		ATMmain.printHeader();
		String accountName = "";
		List<AccountSub> accounts = new ArrayList<AccountSub>();
		
		if(option == 1){
			accountName = "Checking";
			accounts = ATMmain.checkingAccounts;
		} else if (option == 2){
			accountName = "Savings";
			accounts = ATMmain.savingsAccounts;
		} else {
			//displayMainMenu();
		}
		
		System.out.printf("%21s %s%n", accountName.toUpperCase(), "ACCOUNT SELECTION");
		System.out.println();
		
		int i = 1;
		for (AccountSub acct : accounts){
			System.out.printf("%30s\tPress %s\n", "Acct# " + acct.getAccountSubId(), i + "" );
			i++;
		}
		
		System.out.printf("%30s\tPress 0\n", "Return to Main Menu");
		System.out.println();
		System.out.print("Enter Selection and Press Enter: ");
		try{
			int selection =  ATMmain.sc.nextInt();
			if (selection > 0){
				Balance.displayAccountBalance(option, selection);
			}
		} catch (Exception e){
			ATMmain.sc.nextLine();
			displayAccountIdsMenu(option);
		}
	}
	
	
}
