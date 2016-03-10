package atm;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class MenuPanel extends JPanel {

	private BalancePanel balancePanel;
	private DepositPanel depositPanel;
	private ResultsPanel resultsPanel = new ResultsPanel();
	private WithdrawPanel withdrawPanel;
	private JButton jbtAccountBalance, jbtDepositFunds, jbtWithdrawFunds;
	
	public MenuPanel() {
		
		
		
		// Add Buttons to Menu Panel
		add(jbtAccountBalance = new JButton("Account Balance"));
		add(jbtDepositFunds = new JButton("Deposit Funds"));
		add(jbtWithdrawFunds = new JButton("Withdraw Funds"));
		
		// Set the Layout of the Menu Panel
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(boxLayout);
		jbtAccountBalance.setMaximumSize(jbtAccountBalance.getPreferredSize());
		jbtDepositFunds.setMaximumSize(jbtAccountBalance.getPreferredSize());
		jbtWithdrawFunds.setMaximumSize(jbtAccountBalance.getPreferredSize());
		
		/* Button Action Listeners */
		jbtAccountBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupBalanceGUI();
			}
		});
		
		jbtDepositFunds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupDepositGUI();
			}
		});
		
		jbtWithdrawFunds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupWithdrawGUI();
			}
		});
	}
	
	public void setupBalanceGUI() {
		removeAll();
		balancePanel = new BalancePanel();
		resultsPanel.getLblTitle().setText("Account Balance");
		add(balancePanel);
		validate();
		repaint();
		setVisible(true);
	}
	
	public void setupDepositGUI() {
		removeAll();
		depositPanel = new DepositPanel();
		resultsPanel.getLblTitle().setText("Deposit");
		add(depositPanel);
		validate();
		repaint();
		setVisible(true);
	}
	
	public void setupWithdrawGUI() {
		removeAll();
		withdrawPanel = new WithdrawPanel();
		resultsPanel.getLblTitle().setText("Withdraw");
		add(withdrawPanel);
		validate();
		repaint();
		setVisible(true);
	}
	
	public JButton getAccountBalance() {
		return jbtAccountBalance;
	}
	
	public JButton getDepositFunds() {
		return jbtDepositFunds;
	}
	
	public JButton getWithdrawFunds() {
		return jbtWithdrawFunds;
	}
}
