package atm;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXBException;

import atm.business.api.model.AccountSub;
import atm.business.api.model.BankUser;

import com.presentation.service.AtmService;
import com.presentation.service.BankSystemService;
import java.awt.Window.Type;
import java.awt.Color;

public class ATMwelcome extends JFrame {
	
	//Swing Initialization variables
	private static ATMwelcome welcomeFrame = new ATMwelcome();	// Used to transfer frame state and setVisible(false) upon User Login.
	private static MainMenu mainMenu;
	
	// ATM Initialization Variables
	private static BigDecimal amountInATM = new BigDecimal(1000.00);
	private static String bankName = "SD Bank";
	
	private static BankUser user = new BankUser();
	public static List<AccountSub> checkingAccounts = new ArrayList<AccountSub>();
	public static List<AccountSub> savingsAccounts = new ArrayList<AccountSub>();
	
	private JButton btnInsertCard;
	private JButton btnLogin;
	private JButton btnExit;
	
	private JLabel lblAccountNumber;
	private JLabel lblPinNumber;
	private JLabel lblWelcomeToSdbank;
	
	private JPanel contentPane;
	private JTextField accTextField;
	private JTextField pinTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Initialize ATM with cash and bankType
					AtmService.initializeAtm(amountInATM, bankName);
					
					ATMwelcome frame = new ATMwelcome();
					frame.setVisible(true);
					welcomeFrame = frame;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ATMwelcome() {
		setResizable(false);
		setTitle("SDBank ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/**
		 * Display Labels
		 */
		lblWelcomeToSdbank = new JLabel("Welcome to SDBank ATM");
		lblWelcomeToSdbank.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcomeToSdbank.setBounds(85, 30, 254, 24);
		contentPane.add(lblWelcomeToSdbank);
		
		lblAccountNumber = new JLabel("Account Number:");
		lblAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAccountNumber.setBounds(85, 122, 97, 14);
		contentPane.add(lblAccountNumber);
		
		lblPinNumber = new JLabel("Pin Number:");
		lblPinNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPinNumber.setBounds(85, 147, 67, 14);
		contentPane.add(lblPinNumber);
		
		/**
		 * Display TextField for Account Number
		 */
		accTextField = new JTextField();
		accTextField.setEditable(false);
		accTextField.setBounds(192, 120, 147, 20);
		contentPane.add(accTextField);
		accTextField.setColumns(10);
		
		
		/**
		 * Display TextField for Pin Number
		 */
		pinTextField = new JTextField();
		pinTextField.setEditable(false);
		pinTextField.setBounds(192, 145, 147, 20);
		contentPane.add(pinTextField);
		pinTextField.setColumns(10);
		
		// Populate user/pin fields with demo value for Testing Purposes
		accTextField.setText("1234123412341234");
		pinTextField.setText("12345");
		
		/**
		 * Display InsertCard Button
		 */
		btnInsertCard = new JButton("Insert Card");
		btnInsertCard.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnInsertCard.setBounds(128, 65, 181, 23);
		contentPane.add(btnInsertCard);
		btnInsertCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkingAccounts.clear();
				savingsAccounts.clear();
				btnInsertCard.setEnabled(false);
				accTextField.setEditable(true);
				pinTextField.setEditable(true);
				btnLogin.setEnabled(true);
			}
		});
		
		/**
		 * Display Exit Button
		 */
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExit.setBounds(341, 239, 91, 23);
		contentPane.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkingAccounts.clear();
				savingsAccounts.clear();
				System.exit(0);
			}
		});
		
		/**
		 * Display Login Button
		 */
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setEnabled(false);
		btnLogin.setBounds(240, 239, 91, 23);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					// ===================== //
					BankSystemService.connect();
					user.setCardNumber(accTextField.getText());
					user.setPin(pinTextField.getText());
					if (BankSystemService.validateUserLogin(user)){
						//user is valid
						//Populate user checking and savings accounts
						//checkingAccounts = BankSystemService.getCheckingAccounts(user.getCardNumber());
						//savingsAccounts = BankSystemService.getSavingsAccounts(user.getCardNumber());
						mainMenu = new MainMenu();
						mainMenu.setVisible(true);
						welcomeFrame.setVisible(false);
						dispose();
					} else {
						//invalid user
						JOptionPane.showMessageDialog(null, "Invalid Account/Pin Number.", "Error",  JOptionPane.ERROR_MESSAGE);
						accTextField.setText("");
						pinTextField.setText("");
					}
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} finally {
					BankSystemService.disconnect();
				}

			}
		});
	}
}
