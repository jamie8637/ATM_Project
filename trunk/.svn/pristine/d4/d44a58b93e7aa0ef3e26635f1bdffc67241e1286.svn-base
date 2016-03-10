package atm;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenu extends JFrame{
	
	private static ATMwelcome welcomeFrame;
	private static MenuPanel menuPanel;
	private static ResultsPanel resultsPanel;
	private JButton jbtLogOut;
	
	public MainMenu() {
		super("ATM");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		
		menuPanel = new MenuPanel();
		resultsPanel = new ResultsPanel();
				
		
		/**
		 * JPanel to Hold Menu Options
		 */
		JPanel p2 = new JPanel(new BorderLayout());
		p2.add(jbtLogOut = new JButton("Log Out"), BorderLayout.SOUTH);
		p2.add(menuPanel, BorderLayout.CENTER);
	
		
		/**
		 * Add Contents to the Frame
		 */
		add(p2, BorderLayout.EAST);
		add(resultsPanel, BorderLayout.CENTER);
	
		/**
		 * Log Out the User
		 */
		jbtLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				welcomeFrame = new ATMwelcome();
				welcomeFrame.setVisible(true);
			}
		});
		
		
	}
	
	public static ResultsPanel getResultsPanel() {
		return resultsPanel;
	}
	
	public static MenuPanel getMenuPanel() {
		return menuPanel;
	}
}
