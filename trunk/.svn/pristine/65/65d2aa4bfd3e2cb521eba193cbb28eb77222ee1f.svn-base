package atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import atm.business.api.model.AccountSub;


public class BalancePanel extends JPanel {
	
	private MenuPanel menuPanel = MainMenu.getMenuPanel();
	private ResultsPanel resultsPanel = MainMenu.getResultsPanel();
	private JButton jbtCheckings, jbtSavings, jbtBack;
	private JButton[] jbtAccounts;
	AccountSub account = new AccountSub();
	private Boolean showMainButtons = true;
	
	
	public BalancePanel() {
		
		// Add Buttons to Balance Panel
		add(jbtCheckings = new JButton("Checkings"));
		add(jbtSavings = new JButton("Savings"));
		add(jbtBack = new JButton("Back"));
		
		// Set the Layout of the Balance Panel
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(boxLayout);
		jbtCheckings.setMaximumSize(jbtCheckings.getPreferredSize());
		jbtSavings.setMaximumSize(jbtCheckings.getPreferredSize());
		jbtBack.setMaximumSize(jbtCheckings.getPreferredSize());
		
		jbtCheckings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupCheckingsGUI();
			}
		});
		
		jbtSavings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupSavingsGUI();
			}
		});
		
		jbtBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupBackGUI();
			}
		});
	}
	
	public void setupCheckingsGUI() {
		resultsPanel.getLblTotalFunds().setText("Total Funds: $");
		resultsPanel.getLblTotalFunds().setVisible(true);
		resultsPanel.getLblBalance().setVisible(true);
		displayAccountIdsMenu(1);
	}
	
	public void setupSavingsGUI() {
		resultsPanel.getLblTotalFunds().setText("Total Funds: $");
		resultsPanel.getLblTotalFunds().setVisible(true);
		displayAccountIdsMenu(2);
	}
	
	
	/**
	 * Used for Back Button to hide elements
	 */
	public void setupBackGUI() {
		removeAll();
		add(menuPanel.getAccountBalance());
		add(menuPanel.getDepositFunds());
		add(menuPanel.getWithdrawFunds());
		resultsPanel.getLblTitle().setText("Welcome to the ATM!");
		resultsPanel.getLblTotalFunds().setVisible(false);
		resultsPanel.getLblBalance().setVisible(false);
		validate();
		repaint();
	}
	
	public JButton createAccountButton(String label){
		JButton button = new JButton(label);
		return button;
	}
	
	public void toggleCheckingSavingsButtons(){
		showMainButtons = !showMainButtons;
		jbtCheckings.setVisible(showMainButtons);
		jbtSavings.setVisible(showMainButtons);
		jbtBack.setVisible(showMainButtons);
	}
	
	public void hideAccountIdButtons(){
		for(JButton btn : jbtAccounts){
			btn.setVisible(false);
		}
	}
	
	public void displayAccountIdsMenu(int option) {
		// Displays Account Balance menu options
		String accountName = "";
		List<AccountSub> accounts = new ArrayList<AccountSub>();
		int numAccounts = 0;
		
		if(option == 1){
			accountName = "Checking";
			accounts = ATMwelcome.checkingAccounts;
			numAccounts = ATMwelcome.checkingAccounts.size();
			
		} else if (option == 2){
			accountName = "Savings";
			accounts = ATMwelcome.savingsAccounts;
			numAccounts = ATMwelcome.savingsAccounts.size();
		}

		if (numAccounts > 0){
			jbtAccounts = new JButton[numAccounts + 1];
			int i = 0;
			for (AccountSub acct : accounts){
				jbtAccounts[i] = createAccountButton(acct.getAccountSubId().toString());
				add(jbtAccounts[i]);
				i++;
			}
			
			JButton jbtBack2 = new JButton("Back");
			jbtBack2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					hideAccountIdButtons();
					toggleCheckingSavingsButtons();
				}
			});
			jbtAccounts[numAccounts] = jbtBack2;
			add(jbtBack2);
			
			toggleCheckingSavingsButtons();
		}
		
		
		
		//Balance.displayAccountBalance(option, selection);
	}
}
