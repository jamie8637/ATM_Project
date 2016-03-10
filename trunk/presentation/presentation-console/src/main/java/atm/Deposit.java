package atm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.presentation.service.BankSystemService;

import atm.business.api.model.Account;
import atm.business.api.model.AccountSub;
import atm.business.api.services.BankServiceException;

/**
 * Class to handle code for Deposit transactions
 */
public class Deposit {
	Account account;
	static BigDecimal entry;
	static int CheckingOrSavings = 0;
	static int accountSelected = -1;
	static int accountSubId = 0;
	
	public static void displayDepositMenu() {
		ATMmain.printHeader();
		System.out.printf("%21s %s%n", "", "DEPOSIT");
		System.out.println();
		System.out.printf("%46" +
				"s%n", "Enter Total Deposit Amount or 0 to Cancel");
		System.out.println();
		System.out.println();
		System.out.print("Type Selection and Press Enter: ");
		try {
			BigDecimal value = ATMmain.sc.nextBigDecimal();
			processDepositSelection(value);
		} catch(Exception e) {
			ATMmain.sc.nextLine();
			displayDepositMenu();
		}
	}
	
	public static void displayDepositConfirmation() {
		ATMmain.printHeader();
		System.out.printf("%15s %s%n", "", "DEPOSIT COMPLETE");
		System.out.println();
		System.out.printf("%45s%n", ATMmain.formatMoney.format(entry) + " was deposited successfully.");
		System.out.println();
		System.out.printf("%30s\tPress 0\n", "Return to Main Menu");
		System.out.println();
		System.out.print("Type Selection and Press Enter: ");
		try {
			BigDecimal value = ATMmain.sc.nextBigDecimal();
			processDepositSelection(value);
		} catch(Exception e) {
			ATMmain.sc.nextLine();
			displayDepositConfirmation();
		}
	}
	
	public static void displayInsertDeposit() {
		ATMmain.printHeader();
		System.out.printf("%15s %s%n", "", "INSERT DEPOSIT");
		System.out.println();
		System.out.printf("%49s%n", "Insert your checks/cash into deposit slot below");
		System.out.println();
		System.out.printf("%32s  Press 1\n", "After Deposit Is Complete");
		System.out.printf("%32s  Press 0\n", "Cancel Deposit");
		System.out.println();
		System.out.print("Type Selection and Press Enter: ");
		try {
			processDepositEntered(ATMmain.sc.nextInt());
		} catch(Exception e) {
			ATMmain.sc.nextLine();
			displayInsertDeposit();
		}
	}
	
	public static void displayDepositError(String message) {
		ATMmain.printHeader();
		System.out.printf("%15s","", "DEPOSIT ERROR");
		System.out.println();
		System.out.printf("%40s%n", message);
		System.out.println();
		System.out.printf("%30s\tPress 0\n", "Return to Main Menu");
		System.out.println();
		System.out.print("Type Selection and Press Enter: ");
		try {
			processDepositSelection(ATMmain.sc.nextBigDecimal());
		} catch(Exception e) {
			ATMmain.sc.nextLine();
			displayDepositError(message);
		}
	}
	
	private static void processDepositSelection(BigDecimal bigDecimal) {
		entry = bigDecimal;
		if(entry.compareTo(BigDecimal.ZERO) == 0){
			//Cancel deposit and return to main menu
		} else if(entry.compareTo(BigDecimal.ZERO) < 0){
			displayDepositError("You entered an invalid deposit amount.");
		}else {
			//DEPOSIT FUNDS
			displayInsertDeposit();
		}
		
	}
	
	private static void processDepositEntered(int nextInt) {
		switch(nextInt){
		case 0:
			break;
		default:
			try {
				BankSystemService.makeDeposit(accountSubId, entry);
				displayDepositConfirmation();
			} catch (BankServiceException bse) {
				bse.printStackTrace();
				displayDepositError(bse.getMessage());
			} catch (Exception ex){
				ex.printStackTrace();
				displayDepositError("There was an error with your deposit");
			}
			break;
		}
	}
	
	public static void displayDepositSelectionMenu() {
		// Displays Account Balance menu options
		ATMmain.printHeader();
		System.out.printf("%36s%n", "DEPOSIT FUNDS");
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
				Deposit.displayAccountIdsMenu(selection);
			}
		} catch (Exception e){
			ATMmain.sc.nextLine();
			displayDepositSelectionMenu();
		}
	}
	
	public static void displayAccountIdsMenu(int option) {
		// Displays Account Balance menu options
		ATMmain.printHeader();
		String accountName = "";
		List<AccountSub> accounts = new ArrayList<AccountSub>();
		CheckingOrSavings = option;
		if(CheckingOrSavings == 1){
			accountName = "Checking";
			accounts = ATMmain.checkingAccounts;
		} else if (CheckingOrSavings == 2){
			accountName = "Savings";
			accounts = ATMmain.savingsAccounts;
		} else {
			//displayMainMenu();
		}
		
		System.out.printf("%21s %s%n", accountName.toUpperCase(), "ACCOUNT DEPOSIT");
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
				accountSelected = selection;
				accountSubId = accounts.get(accountSelected - 1).getAccountSubId();
				Deposit.displayDepositMenu();
			}
		} catch (Exception e){
			ATMmain.sc.nextLine();
			displayAccountIdsMenu(option);
		}
	}

}
