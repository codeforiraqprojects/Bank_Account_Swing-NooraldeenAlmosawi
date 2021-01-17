package com.noor.bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.peer.PanelPeer;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTabbedPane;

public class BankAccountSwing {
	Bank myBank = new Bank();

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtOpBal;
	JPanel panelOpen;
	JPanel panel;
	JPanel panelDeposit;
	JPanel panelWithdraw;
	JPanel panelPrint;
	private JTextField txtAccountDep;
	private JTextField txtDepAmount;
	private JTextField txtAccountWith;
	private JTextField txtWithAmount;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankAccountSwing window = new BankAccountSwing();
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
	public BankAccountSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setBounds(450, 100, 600, 400);

		panel = new JPanel();
		frame.getContentPane().add(panel, "name_421286544739694");
		panel.setLayout(null);

		JRadioButton rdbtnCreat = new JRadioButton("Create a new bank account");
		rdbtnCreat.setFont(new Font("Arial Black", Font.PLAIN, 16));
		rdbtnCreat.setBounds(37, 77, 286, 29);
		panel.add(rdbtnCreat);

		JRadioButton rdbtnDeposit = new JRadioButton("Deposit to a bank account");
		rdbtnDeposit.setFont(new Font("Arial Black", Font.PLAIN, 16));
		rdbtnDeposit.setBounds(37, 136, 286, 29);
		panel.add(rdbtnDeposit);

		JRadioButton rdbtnWithdraw = new JRadioButton("Withdraw to bank account");
		rdbtnWithdraw.setFont(new Font("Arial Black", Font.PLAIN, 16));
		rdbtnWithdraw.setBounds(37, 197, 286, 29);
		panel.add(rdbtnWithdraw);

		JRadioButton rdbtnNewPrint = new JRadioButton("Print account balance");
		rdbtnNewPrint.setFont(new Font("Arial Black", Font.PLAIN, 16));
		rdbtnNewPrint.setBounds(37, 254, 286, 29);
		panel.add(rdbtnNewPrint);

		JLabel lblChooseOne = new JLabel("Choose One:");
		lblChooseOne.setFont(new Font("Areeq Al-Gafelh", Font.PLAIN, 20));
		lblChooseOne.setBounds(37, 32, 121, 20);
		panel.add(lblChooseOne);

		JButton btnChoose = new JButton("Submit");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnCreat.isSelected()) {
					panel.setVisible(false);
					panelOpen.setVisible(true);

				}

				if (rdbtnDeposit.isSelected()) {
					panel.setVisible(false);
					panelDeposit.setVisible(true);

				}
				if (rdbtnWithdraw.isSelected()) {

					panel.setVisible(false);
					panelWithdraw.setVisible(true);

				}
				if (rdbtnNewPrint.isSelected()) {
					panel.setVisible(false);
					panelPrint.setVisible(true);
				}

			}
		});
		btnChoose.setForeground(SystemColor.text);
		btnChoose.setBackground(SystemColor.activeCaption);
		btnChoose.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnChoose.setBounds(393, 260, 143, 51);
		panel.add(btnChoose);

		ButtonGroup buttonG = new ButtonGroup();
		buttonG.add(rdbtnCreat);
		buttonG.add(rdbtnDeposit);
		buttonG.add(rdbtnWithdraw);
		buttonG.add(rdbtnNewPrint);

		panelOpen = new JPanel();
		frame.getContentPane().add(panelOpen, "name_421289469361812");
		panelOpen.setLayout(null);

		JLabel lblPleaseFillIn = new JLabel("Please Fill in the following fields");
		lblPleaseFillIn.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblPleaseFillIn.setBounds(41, 34, 259, 20);
		panelOpen.add(lblPleaseFillIn);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(138, 112, 69, 20);
		panelOpen.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Opening Balance:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(38, 173, 169, 31);
		panelOpen.add(lblNewLabel_1);

		txtName = new JTextField();
		txtName.setBounds(210, 111, 244, 45);
		panelOpen.add(txtName);
		txtName.setColumns(10);

		txtOpBal = new JTextField();
		txtOpBal.setBounds(210, 172, 244, 45);
		panelOpen.add(txtOpBal);
		txtOpBal.setColumns(10);

		JButton btnOpSubmit = new JButton("Create");
		btnOpSubmit.setForeground(SystemColor.window);
		btnOpSubmit.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnOpSubmit.setBackground(SystemColor.activeCaption);
		btnOpSubmit.setBounds(105, 268, 137, 45);
		panelOpen.add(btnOpSubmit);

		btnOpSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = txtName.getText();
				String s2 = txtOpBal.getText();
				Double da = Double.parseDouble(s2);
				JOptionPane.showMessageDialog(null,
						"Account was created and it has the following number: " + myBank.createNewAccount(s1, da));

			}
		});

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelOpen.setVisible(false);
				panel.setVisible(true);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnBack.setBackground(SystemColor.activeCaption);
		btnBack.setBounds(351, 268, 137, 45);
		panelOpen.add(btnBack);

		panelDeposit = new JPanel();
		frame.getContentPane().add(panelDeposit, "name_423193276991598");
		panelDeposit.setLayout(null);

		JLabel label = new JLabel("Please Fill in the following fields");
		label.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		label.setBounds(42, 29, 259, 20);
		panelDeposit.add(label);

		txtAccountDep = new JTextField();
		txtAccountDep.setColumns(10);
		txtAccountDep.setBounds(211, 106, 244, 45);
		panelDeposit.add(txtAccountDep);

		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAccountNumber.setBounds(28, 116, 157, 20);
		panelDeposit.add(lblAccountNumber);

		txtDepAmount = new JTextField();
		txtDepAmount.setColumns(10);
		txtDepAmount.setBounds(211, 167, 244, 45);
		panelDeposit.add(txtDepAmount);

		JLabel lblDepositAmount = new JLabel("Deposit Amount");
		lblDepositAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDepositAmount.setBounds(39, 172, 169, 31);
		panelDeposit.add(lblDepositAmount);

		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setForeground(Color.WHITE);
		btnDeposit.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnDeposit.setBackground(SystemColor.activeCaption);
		btnDeposit.setBounds(106, 263, 137, 45);
		panelDeposit.add(btnDeposit);

		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s3 = txtAccountDep.getText();
				Integer d1 = Integer.parseInt(s3);
				String s4 = txtDepAmount.getText();
				Double d2 = Double.parseDouble(s4);

				myBank.depositTo(d1, d2);
			}

		});

		JButton btnBackDep = new JButton("Back");
		btnBackDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDeposit.setVisible(false);
				panel.setVisible(true);
			}

		});
		btnBackDep.setForeground(Color.WHITE);
		btnBackDep.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnBackDep.setBackground(SystemColor.activeCaption);
		btnBackDep.setBounds(352, 263, 137, 45);
		panelDeposit.add(btnBackDep);

		panelWithdraw = new JPanel();
		frame.getContentPane().add(panelWithdraw, "name_423562562090214");
		panelWithdraw.setLayout(null);

		JLabel label_1 = new JLabel("Please Fill in the following fields");
		label_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		label_1.setBounds(63, 27, 259, 20);
		panelWithdraw.add(label_1);

		JLabel label_2 = new JLabel("Account Number");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(49, 114, 157, 20);
		panelWithdraw.add(label_2);

		txtAccountWith = new JTextField();
		txtAccountWith.setColumns(10);
		txtAccountWith.setBounds(232, 104, 244, 45);
		panelWithdraw.add(txtAccountWith);

		JLabel lblWithdrawAmount = new JLabel("WithDraw Amount");
		lblWithdrawAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWithdrawAmount.setBounds(36, 170, 169, 31);
		panelWithdraw.add(lblWithdrawAmount);

		txtWithAmount = new JTextField();
		txtWithAmount.setColumns(10);
		txtWithAmount.setBounds(232, 165, 244, 45);
		panelWithdraw.add(txtWithAmount);

		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelWithdraw.setVisible(false);
				panel.setVisible(true);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial Black", Font.PLAIN, 16));
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(373, 261, 137, 45);
		panelWithdraw.add(button);

		JButton btnWithDraw = new JButton("WithDraw");
		btnWithDraw.setForeground(Color.WHITE);
		btnWithDraw.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnWithDraw.setBackground(SystemColor.activeCaption);
		btnWithDraw.setBounds(127, 261, 137, 45);

		btnWithDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s5 = txtAccountWith.getText();
				Integer d3 = Integer.parseInt(s5);
				String s6 = txtWithAmount.getText();
				Double d4 = Double.parseDouble(s6);

				myBank.withdrawFrom(d3, d4);

			}
		});
		panelWithdraw.add(btnWithDraw);

		panelPrint = new JPanel();
		frame.getContentPane().add(panelPrint, "name_3494909469523");
		panelPrint.setLayout(null);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(212, 82, 244, 45);
		panelPrint.add(textField);

		JLabel label_3 = new JLabel("Account Number");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(29, 92, 157, 20);
		panelPrint.add(label_3);

		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aa = textField.getText();
				Integer ii = Integer.parseInt(aa);

				myBank.printAccountInfo(ii);

			}
		});
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnPrint.setBackground(SystemColor.activeCaption);
		btnPrint.setBounds(107, 240, 137, 45);
		panelPrint.add(btnPrint);

		JButton btnBackPrint = new JButton("Back");
		btnBackPrint.setForeground(Color.WHITE);
		btnBackPrint.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnBackPrint.setBackground(SystemColor.activeCaption);
		btnBackPrint.setBounds(353, 240, 137, 45);
		panelPrint.add(btnBackPrint);
		btnBackPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrint.setVisible(false);
				panel.setVisible(true);
				
			}
		});

	}
}
