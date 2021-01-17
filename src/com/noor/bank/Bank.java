package com.noor.bank;

import javax.swing.JOptionPane;

public class Bank {

	private BankAccount[] accounts; // all the bank accounts at this bank
	private int numOfAccounts = 100; // the number of bank accounts

//Constructor
	public Bank() {
		accounts = new BankAccount[100];
		numOfAccounts = 0;
	}

//Creates a new bank account  and returns the account number of this new account.

	public int createNewAccount(String customerName, double openingBalance) {

		BankAccount b = new BankAccount(customerName, openingBalance);
		accounts[numOfAccounts] = b;
		numOfAccounts++;
		return b.getAccountNum();
	}

//Withdraws the given amount from the account whose account number is given. 
	public void withdrawFrom(int accountNum, double amount) {
		for (int i = 0; i < numOfAccounts; i++) {
			if (accountNum == accounts[i].getAccountNum()) {
				accounts[i].withdraw(amount);
				
			} else {
				JOptionPane.showMessageDialog(null, "Account number not found.");
			}
		}

	}

//Deposits the given amount to the account whose account number is given.
	public void depositTo(int accountNum, double amount) {
		for (int i = 0; i < numOfAccounts; i++) {
			if (accountNum == accounts[i].getAccountNum()) {
				accounts[i].deposit(amount);

			}
			else{JOptionPane.showMessageDialog(null, "Account number not found.");}

		}
	}

//Prints the account number, If the account is not available at the bank, it should print a message.
	public void printAccountInfo(int accountNum) {
		for (int i = 0; i < numOfAccounts; i++) {
			if (accountNum == accounts[i].getAccountNum()) {
				JOptionPane.showMessageDialog(null, accounts[i].getAccountInfo());

			} else {
				JOptionPane.showMessageDialog(null, "Account number not found.");
			}
		}
	}

}
