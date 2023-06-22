import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JPanel;
import java.awt.Label;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Checkbox;
import java.awt.Choice;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;




public class Main {
	
	CardLayout cl = new CardLayout();
	CardLayout transactionCl = new CardLayout();
	JPanel container = new JPanel();
	
	
	private JFrame frame;
	private JTextField fNameField;
	private JTextField mNameField;
	private JTextField lNameField;
	private JTextField bDayField;
	private JTextField fatherField;
	private JTextField motherField;
	private JTextField conNumField;
	private JTextField pinNumField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 525, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(container);
		container.setLayout(cl);//sets the layout of "container" as CardLayout
		//"container" panel is now a parent component where we store all of the child panel
//MAIN PANEL-------------------------------------------------------------------
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(UIManager.getColor("Button.darkShadow"));
		container.add(mainPanel, "0");// container.add( component to add, component tag);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		mainPanel.setLayout(gbl_mainPanel);//sets "mainPanel" as a grid bag layout
		
		JButton regButton = new JButton("Register");
		regButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(container, "2");// cl.show( parent component, child tag component)
			}
		});

		GridBagConstraints gbc_regButton = new GridBagConstraints();
		gbc_regButton.gridx = 0;
		gbc_regButton.gridy = 3;
		mainPanel.add(regButton, gbc_regButton);
		
		JButton logInButton = new JButton("Log In");
		logInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(container, "1");
			}
		});
		
		
		GridBagConstraints gbc_logInButton = new GridBagConstraints();
		gbc_logInButton.fill = GridBagConstraints.HORIZONTAL;//fills the entire cell
		gbc_logInButton.insets = new Insets(0, 0, 5, 0);
		gbc_logInButton.gridx = 0;//row
		gbc_logInButton.gridy = 2;//coloumn
		mainPanel.add(logInButton, gbc_logInButton);

		Label menuLabel = new Label("Welcome");
		menuLabel.setForeground(Color.WHITE);
		menuLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		GridBagConstraints gbc_menuLabel = new GridBagConstraints();
		gbc_menuLabel.anchor = GridBagConstraints.EAST;
		gbc_menuLabel.insets = new Insets(0, 0, 5, 0);
		gbc_menuLabel.gridx = 0;
		gbc_menuLabel.gridy = 1;
		mainPanel.add(menuLabel, gbc_menuLabel);
		
//-------------------------------------------------------------------	

//Log-In-------------------------------------------------------------
		JPanel logInPanel = new JPanel();
		logInPanel.setBackground(SystemColor.activeCaption);
		container.add(logInPanel, "1");
		logInPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel transactionPanel = new JPanel();
		transactionPanel.setForeground(new Color(255, 255, 255));
		transactionPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		transactionPanel.setLayout(transactionCl);
		logInPanel.add(transactionPanel, BorderLayout.CENTER);
		
		JPanel withdrawPanel = new JPanel();
		withdrawPanel.setBackground(new Color(102, 153, 204));
		transactionPanel.add(withdrawPanel, "0");
		withdrawPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Withdraw Money");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		withdrawPanel.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel depositPanel = new JPanel();
		depositPanel.setBackground(new Color(153, 51, 255));
		transactionPanel.add(depositPanel, "1");
		
		JLabel lblDepositMoney = new JLabel("Deposit Money");
		lblDepositMoney.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepositMoney.setFont(new Font("Tahoma", Font.BOLD, 17));
		depositPanel.add(lblDepositMoney);
		
		JPanel balanceInquiryPanel = new JPanel();
		balanceInquiryPanel.setBackground(new Color(204, 153, 0));
		transactionPanel.add(balanceInquiryPanel, "2");
		
		JLabel lblBalanceInquiry = new JLabel("Balance Inquiry");
		lblBalanceInquiry.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalanceInquiry.setFont(new Font("Tahoma", Font.BOLD, 17));
		balanceInquiryPanel.add(lblBalanceInquiry);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(0, 153, 153));
		logInPanel.add(buttonPanel, BorderLayout.WEST);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		buttonPanel.setLayout(gbl_buttonPanel);
		
		JButton btnNewButton = new JButton("Log out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//this button when pressed pops up a prompt dialouge
				// yes = 0, no = 1
				if(0 ==JOptionPane.showConfirmDialog(null, "Are you sure?", "Logging out", JOptionPane.YES_NO_OPTION)) { 
					
					cl.show(container, "0");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 100, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		buttonPanel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Withdraw");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transactionCl.show(transactionPanel, "0");
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 2;
		buttonPanel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Deposit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transactionCl.show(transactionPanel, "1");
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 3;
		buttonPanel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Balance Inquiry");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transactionCl.show(transactionPanel, "2");
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 180, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 4;
		buttonPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		
		
		
		
		
		
//-------------------------------------------------------------------
		
		
		
		
		
//Register Panel-----------------------------------------------------
		JPanel regPanel = new JPanel();
		regPanel.setBackground(Color.LIGHT_GRAY);
		regPanel.setForeground(Color.DARK_GRAY);
		container.add(regPanel, "2");
		GridBagLayout gbl_regPanel = new GridBagLayout();
		regPanel.setLayout(gbl_regPanel);
		
		JLabel fNameLabel = new JLabel("First Name: ");
		GridBagConstraints gbc_fNameLabel = new GridBagConstraints();
		gbc_fNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fNameLabel.anchor = GridBagConstraints.EAST;
		gbc_fNameLabel.gridx = 0;
		gbc_fNameLabel.gridy = 1;
		regPanel.add(fNameLabel, gbc_fNameLabel);
		
		fNameField = new JTextField();
		GridBagConstraints gbc_fNameField = new GridBagConstraints();
		gbc_fNameField.insets = new Insets(0, 0, 5, 0);
		gbc_fNameField.anchor = GridBagConstraints.WEST;
		gbc_fNameField.gridx = 1;
		gbc_fNameField.gridy = 1;
		regPanel.add(fNameField, gbc_fNameField);
		fNameField.setColumns(10);
		
		JLabel mNameLabel = new JLabel("Middle Name: ");
		GridBagConstraints gbc_mNameLabel = new GridBagConstraints();
		gbc_mNameLabel.anchor = GridBagConstraints.EAST;
		gbc_mNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_mNameLabel.gridx = 0;
		gbc_mNameLabel.gridy = 2;
		regPanel.add(mNameLabel, gbc_mNameLabel);
		
		mNameField = new JTextField();
		GridBagConstraints gbc_mNameField = new GridBagConstraints();
		gbc_mNameField.insets = new Insets(0, 0, 5, 0);
		gbc_mNameField.anchor = GridBagConstraints.WEST;
		gbc_mNameField.fill = GridBagConstraints.VERTICAL;
		gbc_mNameField.gridx = 1;
		gbc_mNameField.gridy = 2;
		regPanel.add(mNameField, gbc_mNameField);
		mNameField.setColumns(10);
		
		JLabel lNameLabel = new JLabel("Last Name: ");
		GridBagConstraints gbc_lNameLabel = new GridBagConstraints();
		gbc_lNameLabel.anchor = GridBagConstraints.EAST;
		gbc_lNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lNameLabel.gridx = 0;
		gbc_lNameLabel.gridy = 3;
		regPanel.add(lNameLabel, gbc_lNameLabel);
		
		lNameField = new JTextField();
		GridBagConstraints gbc_lNameField = new GridBagConstraints();
		gbc_lNameField.insets = new Insets(0, 0, 5, 0);
		gbc_lNameField.anchor = GridBagConstraints.WEST;
		gbc_lNameField.gridx = 1;
		gbc_lNameField.gridy = 3;
		regPanel.add(lNameField, gbc_lNameField);
		lNameField.setColumns(10);
		
		JLabel bDayLabel = new JLabel("Birthdate: ");
		GridBagConstraints gbc_bDayLabel = new GridBagConstraints();
		gbc_bDayLabel.anchor = GridBagConstraints.BELOW_BASELINE_TRAILING;
		gbc_bDayLabel.insets = new Insets(0, 0, 5, 5);
		gbc_bDayLabel.gridx = 0;
		gbc_bDayLabel.gridy = 4;
		regPanel.add(bDayLabel, gbc_bDayLabel);
		
		String[] gender = {"Male", "Female"};
		
		bDayField = new JTextField();
		GridBagConstraints gbc_bDayField = new GridBagConstraints();
		gbc_bDayField.insets = new Insets(0, 0, 5, 0);
		gbc_bDayField.anchor = GridBagConstraints.WEST;
		gbc_bDayField.gridx = 1;
		gbc_bDayField.gridy = 4;
		regPanel.add(bDayField, gbc_bDayField);
		bDayField.setColumns(10);
		
		JLabel gLabel = new JLabel("Sex: ");
		GridBagConstraints gbc_gLabel = new GridBagConstraints();
		gbc_gLabel.anchor = GridBagConstraints.EAST;
		gbc_gLabel.insets = new Insets(0, 0, 5, 5);
		gbc_gLabel.gridx = 0;
		gbc_gLabel.gridy = 5;
		regPanel.add(gLabel, gbc_gLabel);
		JComboBox sexComboBox = new JComboBox(gender);
		GridBagConstraints gbc_sexComboBox = new GridBagConstraints();
		gbc_sexComboBox.anchor = GridBagConstraints.WEST;
		gbc_sexComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_sexComboBox.gridx = 1;
		gbc_sexComboBox.gridy = 5;
		regPanel.add(sexComboBox, gbc_sexComboBox);
		
		JLabel fatherLabel = new JLabel("Father Name: ");
		GridBagConstraints gbc_fatherLabel = new GridBagConstraints();
		gbc_fatherLabel.anchor = GridBagConstraints.EAST;
		gbc_fatherLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fatherLabel.gridx = 0;
		gbc_fatherLabel.gridy = 6;
		regPanel.add(fatherLabel, gbc_fatherLabel);
		
		fatherField = new JTextField();
		GridBagConstraints gbc_fatherField = new GridBagConstraints();
		gbc_fatherField.anchor = GridBagConstraints.WEST;
		gbc_fatherField.insets = new Insets(0, 0, 5, 0);
		gbc_fatherField.gridx = 1;
		gbc_fatherField.gridy = 6;
		regPanel.add(fatherField, gbc_fatherField);
		fatherField.setColumns(10);
		
		JLabel motherLabel = new JLabel("Mother Name: ");
		GridBagConstraints gbc_motherLabel = new GridBagConstraints();
		gbc_motherLabel.anchor = GridBagConstraints.EAST;
		gbc_motherLabel.insets = new Insets(0, 0, 5, 5);
		gbc_motherLabel.gridx = 0;
		gbc_motherLabel.gridy = 7;
		regPanel.add(motherLabel, gbc_motherLabel);
		
		motherField = new JTextField();
		GridBagConstraints gbc_motherField = new GridBagConstraints();
		gbc_motherField.anchor = GridBagConstraints.WEST;
		gbc_motherField.insets = new Insets(0, 0, 5, 0);
		gbc_motherField.gridx = 1;
		gbc_motherField.gridy = 7;
		regPanel.add(motherField, gbc_motherField);
		motherField.setColumns(10);
		
		JLabel conNumLabel = new JLabel("Contact No. ");
		GridBagConstraints gbc_conNumLabel = new GridBagConstraints();
		gbc_conNumLabel.anchor = GridBagConstraints.EAST;
		gbc_conNumLabel.insets = new Insets(0, 0, 5, 5);
		gbc_conNumLabel.gridx = 0;
		gbc_conNumLabel.gridy = 8;
		regPanel.add(conNumLabel, gbc_conNumLabel);
		
		conNumField = new JTextField();
		GridBagConstraints gbc_conNumField = new GridBagConstraints();
		gbc_conNumField.insets = new Insets(0, 0, 5, 0);
		gbc_conNumField.anchor = GridBagConstraints.WEST;
		gbc_conNumField.gridx = 1;
		gbc_conNumField.gridy = 8;
		regPanel.add(conNumField, gbc_conNumField);
		conNumField.setColumns(10);
		
		JLabel pinNumLabel = new JLabel("Pin Number: ");
		GridBagConstraints gbc_pinNumLabel = new GridBagConstraints();
		gbc_pinNumLabel.anchor = GridBagConstraints.EAST;
		gbc_pinNumLabel.insets = new Insets(0, 0, 5, 5);
		gbc_pinNumLabel.gridx = 0;
		gbc_pinNumLabel.gridy = 9;
		regPanel.add(pinNumLabel, gbc_pinNumLabel);
		
		pinNumField = new JTextField();
		GridBagConstraints gbc_pinNumField = new GridBagConstraints();
		gbc_pinNumField.anchor = GridBagConstraints.WEST;
		gbc_pinNumField.insets = new Insets(0, 0, 5, 0);
		gbc_pinNumField.gridx = 1;
		gbc_pinNumField.gridy = 9;
		regPanel.add(pinNumField, gbc_pinNumField);
		pinNumField.setColumns(10);
		
		JLabel IniDepLabel = new JLabel("Initial Deposit: 500 Php");
		GridBagConstraints gbc_IniDepLabel = new GridBagConstraints();
		gbc_IniDepLabel.insets = new Insets(0, 0, 5, 0);
		gbc_IniDepLabel.anchor = GridBagConstraints.WEST;
		gbc_IniDepLabel.gridx = 1;
		gbc_IniDepLabel.gridy = 10;
		regPanel.add(IniDepLabel, gbc_IniDepLabel);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(0 ==JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel registration?", "Warning", JOptionPane.YES_NO_OPTION)) {
					
					cl.show(container, "0");
				}
			}
		});
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.fill = GridBagConstraints.BOTH;
		gbc_cancelButton.insets = new Insets(0, 0, 5, 0);
		gbc_cancelButton.gridx = 1;
		gbc_cancelButton.gridy = 11;
		regPanel.add(cancelButton, gbc_cancelButton);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_registerButton = new GridBagConstraints();
		gbc_registerButton.insets = new Insets(0, 0, 5, 0);
		gbc_registerButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_registerButton.anchor = GridBagConstraints.SOUTH;
		gbc_registerButton.gridx = 1;
		gbc_registerButton.gridy = 12;
		regPanel.add(registerButton, gbc_registerButton);
		
		
		
		
		
		
		
//-------------------------------------------------------------------
		
		
		
	}
	

}
