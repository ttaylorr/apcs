package com.ttaylorr.apcs.bankaccount;

public class SavingsAccount extends BankAccount {

	private double interestRate;
	
	public SavingsAccount() {
		super();
		this.interestRate = 0;
	}
	
	public SavingsAccount(double balance, double interestRate) {
		super(balance);
		this.interestRate = interestRate;
	}
	
	public void addInterest() {
		this.deposit(this.getBalance() * interestRate);
	}
	
}
