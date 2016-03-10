package atm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class will handle all the necessary GUI components for Deposit/Balance/Withdraw Panels.
 * Will also feature methods to process Deposit/Withdraw/Balance Events.
 */
public class ResultsPanel extends JPanel {
	
	static BigDecimal entry;
	private static JButton btnDeposit;
	private static JButton btnWithdraw;
	private static JLabel lblAmount;
	private static JLabel lblBalance;
	private static JLabel lblTitle;
	private static JLabel lblTotalFunds;
	private static JTextField txtAmountField;
	
	private Color color = Color.BLACK;
	
	public ResultsPanel() {
		// Setup the GUI
		setupScreen();
		
	}
	
	private void processDeposit(BigDecimal bigDecimal) {
		entry = bigDecimal;
		if(entry.compareTo(BigDecimal.ZERO) == 0){
			JOptionPane.showMessageDialog(getParent(), "Please enter something higher than 0");
		} else if(entry.compareTo(BigDecimal.ZERO) < 0){
			JOptionPane.showMessageDialog(getParent(), "You entered an invalid deposit amount.");
		}else {
			//DEPOSIT FUNDS
		}
	}
	
	private void processWithdraw(BigDecimal bigDecimal) {
		entry = bigDecimal;
		if(entry.compareTo(BigDecimal.ZERO) == 0){
			JOptionPane.showMessageDialog(getParent(), "Please enter something higher than 0");
		} else if(entry.compareTo(BigDecimal.ZERO) < 0){
			JOptionPane.showMessageDialog(getParent(), "You entered an invalid deposit amount.");
		}else {
			//WITHDRAW FUNDS
		}
	}
	
	public JButton getBtnDeposit() {
		return btnDeposit;
	}
	
	public JButton getBtnWithdraw() {
		return btnWithdraw;
	}
	
	public JLabel getLblBalance() {
		return lblBalance;
	}
	
	public JLabel getLblTitle() {
		return lblTitle;
	}
	
	public JLabel getLblAmount() {
		return lblAmount;
	}
	
	public JLabel getLblTotalFunds() {
		return lblTotalFunds;
	}
	
	public JTextField getTxtAmountField() {
		return txtAmountField;
	}

	public void setupScreen() {
		/**
		 * Initial Layout Prior to User Interaction
		 */
		// Set Border for Results Panel
		setBorder(BorderFactory.createLineBorder(color));
		// Set Absolute Layout Positioning
		setLayout(null);
		
		// Initialize Buttons
		btnDeposit = new JButton("Deposit");
		btnWithdraw = new JButton("Withdraw");
		
		// Initialize Labels
		lblAmount = new JLabel(""); // Filler
		lblBalance = new JLabel("");
		lblTitle = new JLabel("Welcome to the ATM!");
		lblTotalFunds = new JLabel("");
		
		// Initialize TextFields
		txtAmountField = new JTextField(25);
		
		
		/**
		 * Add Components to the Screen
		 */
		
		// Add Title
		add(getLblTitle());
		getLblTitle().setLocation(150, 5);
		getLblTitle().setSize(150, 50);
		
		// Add AmountToDeposit/Withdraw
		add(getLblAmount());
		getLblAmount().setLocation(20, 50);
		getLblAmount().setSize(300, 50);
		getLblAmount().setVisible(false);
		
		// Add Balance Amount
		add(getLblBalance());
		getLblBalance().setLocation(50, 50);
		getLblBalance().setSize(50, 50);
		getLblBalance().setVisible(false);
		
		// Add Total Funds - Initially False
		add(getLblTotalFunds());
		getLblTotalFunds().setVisible(false);
		getLblTotalFunds().setLocation(20, 50);
		getLblTotalFunds().setSize(100, 20);
		
		// Add TextField - Initially False
		add(txtAmountField);
		getTxtAmountField().setVisible(false);
		getTxtAmountField().setLocation(250, 65);
		getTxtAmountField().setSize(50, 20);
		
		// Add DepositButton - Initially False and Handle Event
		add(btnDeposit);
		getBtnDeposit().setVisible(false);
		getBtnDeposit().setLocation(125, 120);
		getBtnDeposit().setSize(100, 25);
		getBtnDeposit().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entry = new BigDecimal(getTxtAmountField().getText().toString());
				processDeposit(entry);
			}
		});
		
		// Add WithdrawButton - Initially False and Handle Event
		add(btnWithdraw);
		getBtnWithdraw().setVisible(false);
		getBtnWithdraw().setLocation(125, 120);
		getBtnWithdraw().setSize(100, 25);
		getBtnWithdraw().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entry = new BigDecimal(getTxtAmountField().getText().toString());
				processWithdraw(entry);		
			}
		});
	}
	
	


}
