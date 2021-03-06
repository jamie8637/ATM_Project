/**
 * Class to handle code for Main Menu options
 */
public class MainMenu {

	/**
	 * Display main menu.
	 * @return 
	 */
	public static int displayMainMenu() {
		// Displays main menu after successful login
		
		System.out.printf("%31s%n", "Main Menu");
		System.out.println();
		System.out.printf("%30s\tPress 1\n", "View Customers");
		System.out.printf("%30s\tPress 2\n", "Create Customer");
		System.out.printf("%30s\tPress 3\n", "Update Customer");
		System.out.println();
		System.out.print("Enter Selection and Press Enter: ");
		return(ManagerMain.sc.nextInt());
		//processMainMenuSelection(ManagerMain.sc.nextInt());
	}
	
	public static void processMainMenuSelection(int selected) {
		switch(selected){
		case 0:
			break;
		case 1:
			Customers.viewCustomers();
			break;
		case 2:
			Customers.createCustomer();
			break;
		case 3:
			Customers.updateCustomer();
			break;
		case 4:
			Accounts.createAccount();
			break;
		}
	}
	
}
