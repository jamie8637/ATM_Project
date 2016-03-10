import java.util.List;

import atm.business.api.model.Account;
import atm.business.api.services.BankServiceException;

import com.presentation.service.BankSystemService;

/**
 * Class to handle code for Balance transactions
 */
public class Accounts {


	public static void createAccount() {
		Account account = new Account();
		
		String accountNumber = "625376454836464";
		String customerId = "5";
		String pinNumber = "17363";
		
		account.setAccountNumber(accountNumber);
		account.setCustomerId(customerId);
		account.setPinNumber(pinNumber);
        BankSystemService bankSystemService = new BankSystemService();
        try {
			bankSystemService.createAccount(account);
		} catch (BankServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
