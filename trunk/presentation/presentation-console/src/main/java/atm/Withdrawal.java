package atm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.presentation.service.BankSystemService;

import atm.business.api.model.Account;
import atm.business.api.model.AccountSub;
import atm.business.api.services.BankServiceException;

/**
 * Class to handle code for Withdrawal transactions
 */
public class Withdrawal {
	Account account;
	static BigDecimal entry;
	static int CheckingOrSavings = 0;
	static int accountSelected = -1;
	static int accountSubId = 0;
	
	public static void displayWithdrawMenu() {
		ATMmain.printHeader();
		System.out.printf("%21s %s%n", "", "WITHDRAWAL");
		System.out.println();
		System.out.printf("%47s%n", "Enter Amount to Withdraw or 0 to Cancel");
		System.out.println();
		System.out.println();
		System.out.print("Type Selection and Press Enter: ");
		try{
			processWithdrawalSelection(ATMmain.sc.nextBigDecimal());
		}  catch(Exception e) {
			ATMmain.sc.nextLine();
			displayWithdrawMenu();
		}
	}

	public static void displayWithdrawalConfirmation() {
		ATMmain.printHeader();
		System.out.printf("%15s %s%n", "", "WITHDRAWAL COMPLETE");
		System.out.println();
		System.out.printf("%40s%n", ATMmain.formatMoney.format(entry) + " is being dispensed.");
		System.out.println();
		System.out.printf("%30s\tPress 0\n", "Return to Main Menu");
		System.out.println();
		System.out.print("Type Selection and Press Enter: ");
		try {
			processWithdrawalSelection(ATMmain.sc.nextBigDecimal());
		} catch(Exception e) {
			ATMmain.sc.nextLine();
			displayWithdrawalConfirmation();
		}
	}
	
	public static void displayWithdrawalError(String message) {
		ATMmain.printHeader();
		System.out.printf("%15s","", "WITHDRAWAL ERROR");
		System.out.println();
		System.out.printf("%40s%n", message);
		System.out.println();
		System.out.printf("%30s\tPress 0\n", "Return to Main Menu");
		System.out.println();
		System.out.print("Type Selection and Press Enter: ");
		try {
			processWithdrawalSelection(ATMmain.sc.nextBigDecimal());
		}  catch(Exception e) {
			ATMmain.sc.nextLine();
			displayWithdrawalError(message);
		}
	}
	
	private static void processWithdrawalSelection(BigDecimal bigDecimal) {
		entry = bigDecimal;
		if(entry.compareTo(BigDecimal.ZERO) == 0){
			//Cancel withdrawal and return to main menu
		} else if(entry.compareTo(BigDecimal.ZERO) < 0){
			displayWithdrawalError("You entered an invalid amount.");
		} else {
			//WITHDRAW FUNDS
			try {
				BankSystemService.makeWithdrawl(accountSubId, entry);
				displayWithdrawalConfirmation();
			} catch (BankServiceException bse) {
				bse.printStackTrace();
				displayWithdrawalError(bse.getMessage());
			} catch (Exception ex) {
				ex.printStackTrace();
				displayWithdrawalError(ex.getMessage());
			}
		}
		
	}	
	
	public static void displayAccountTypeSelectionMenu() {
		ATMmain.printHeader();
		System.out.printf("%36s%n", "WITHDRAW FUNDS");
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
		try {
			int selection =  ATMmain.sc.nextInt();
			if (selection > 0){
				Withdrawal.displayAccountIdsMenu(selection);
			}
		} catch(Exception e) {
			ATMmain.sc.nextLine();
			displayAccountTypeSelectionMenu();
		}
	}
	
	public static void displayAccountIdsMenu(int option) {
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
		} else if (CheckingOrSavings > 2){
			displayAccountTypeSelectionMenu();
		} else {
			//displayMainMenu();
			
		}
		
		System.out.printf("%21s %s%n", accountName.toUpperCase(), "ACCOUNT WITHDRAWAL");
		System.out.println();
		
		int i = 1;
		for (AccountSub acct : accounts){
			System.out.printf("%30s\tPress %s\n", "Acct# " + acct.getAccountSubId(), i + "" );
			i++;
		}
		
		System.out.printf("%30s\tPress 0\n", "Return to Main Menu");
		System.out.println();
		System.out.print("Enter Selection and Press Enter: ");
		try {
			int selection =  ATMmain.sc.nextInt();
			if (selection > 0){
				accountSelected = selection;
				accountSubId = accounts.get(accountSelected - 1).getAccountSubId();
				Withdrawal.displayWithdrawMenu();
			}
		}  catch(Exception e) {
			ATMmain.sc.nextLine();
			displayAccountIdsMenu(option);
		}
	}
}
