package atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WithdrawPanel extends JPanel {

	private MenuPanel menuPanel = MainMenu.getMenuPanel();
	private ResultsPanel resultsPanel = MainMenu.getResultsPanel();
	private JButton jbtCheckings, jbtSavings, jbtBack;
	
	public WithdrawPanel() {
		
		// Add Buttons to Withdraw Panel
		add(jbtCheckings = new JButton("Checkings"));
		add(jbtSavings = new JButton("Savings"));
		add(jbtBack = new JButton("Back"));
		
		// Set the Layout of the Withdraw Panel
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(boxLayout);
		jbtCheckings.setMaximumSize(jbtCheckings.getPreferredSize());
		jbtSavings.setMaximumSize(jbtCheckings.getPreferredSize());
		jbtBack.setMaximumSize(jbtCheckings.getPreferredSize());
		
		jbtCheckings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupGUI();
			}
		});
		
		jbtSavings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupGUI();
			}
		});
		
		jbtBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupBackGUI();	
			}
		});
	}
	
	/**
	 * Used for Checkings / Savings
	 */
	public void setupGUI() {
		resultsPanel.getLblAmount().setText("How much would you like to withdraw?");
		resultsPanel.getLblAmount().setVisible(true);
		resultsPanel.getTxtAmountField().setVisible(true);
		resultsPanel.getBtnWithdraw().setVisible(true);
		validate();
		repaint();
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
		resultsPanel.getLblAmount().setVisible(false);
		resultsPanel.getTxtAmountField().setVisible(false);
		resultsPanel.getTxtAmountField().setText("");
		resultsPanel.getBtnWithdraw().setVisible(false);
		validate();
		repaint();
	}
}
