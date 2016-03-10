import java.util.List;

import atm.business.api.model.Customer;
import atm.business.api.services.BankServiceException;

import com.presentation.service.CustomerSystemService;

/**
 * Class to handle code for Balance transactions
 */
public class Customers {

	public static void viewCustomers() {

		// TODO Call service to get balance for this account
		try {
			List<Customer> customers = CustomerSystemService.getCustomerNames();

			ManagerMain.printHeader();
			System.out.printf("Customers");
			System.out.println();

			for (Customer customer : customers) {
				System.out.println(customer.getCustomerLast() + ", "
						+ customer.getCustomerLast());
			}

			// System.out.printf("%30s\tPress 1\n", "Return to Balanace Menu");
			System.out.printf("%30s\tPress 0\n", "Return to Main Menu");
			System.out.println();
		} catch (BankServiceException e) {
			// TODO Print Error
			ManagerMain.clearScreen();
			ManagerMain.printHeader();
			System.out
					.println("There was an error getting the customer names.\n\tPlease try again later.");
			System.out.println();
			System.out
					.printf("%38s%n", "Press any key to return to Main Menu.");
			System.out.println();
			System.out
					.println("**************************************************");
			ManagerMain.sc.nextInt();
			// displayMainMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createCustomer() {

	}

	public static void updateCustomer() {

	}

}
