package com.noor.bank;

import javax.swing.JOptionPane;

public class BankAccount {


	public int acc_no;
	private String name;
	private double amount;
	private static int noOfAccounts = 0;

	public String getAccountInfo() {
		return "Account number: " + acc_no + "\nCustomer Name: " + name + "\nBalance:" + amount + "\n";
	}

	public BankAccount(String n, double amt) {
		name = n;
		amount = amt;
		noOfAccounts++;
		acc_no = noOfAccounts;
	}

	public int getAccountNum() {
		return acc_no;
	}

	public void deposit(double amt) {

		if (amt <= 0) {
			JOptionPane.showMessageDialog(null,"Amount to be deposited should be positive");
		} else {
			amount = amount + amt;
			JOptionPane.showMessageDialog(null,"Amount deposited successfully");

		}
	}

	public void withdraw(double amt) {
		if (amt <= 0) {
			JOptionPane.showMessageDialog(null,"Amount to be withdrawn should be positive");

		} else {
			if (amount < amt) {
				JOptionPane.showMessageDialog(null,"Insufficient balance");
			} else {
				amount = amount - amt;
				JOptionPane.showMessageDialog(null,"Amount withdrawn successfully");

			}
		}
	}


}
