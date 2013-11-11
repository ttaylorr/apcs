package com.ttaylorr.apcs.bankaccount;

public class BankAccount {

	private double balance;
	
	public BankAccount() {
		this.balance = 0;
	}
	
	public BankAccount(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amt) {
		this.balance += amt;
	}
	
	public void withdraw(double amt) {
		this.balance -= amt;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
}
