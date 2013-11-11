package com.ttaylorr.apcs.bankaccount;

public class CheckingAccount extends BankAccount {

	private static final double FEE = 2.0;
	private static final double MIN_BALANCE = 50.0;
	
	public CheckingAccount() {
		super();
	}
	
	public CheckingAccount(double balance) {
		super(balance);
	}
	
	@Override
	public void withdraw(double amt) {
		super.withdraw(amt);
		
		if(this.getBalance() < MIN_BALANCE) {
			super.withdraw(2.0);
		}
	}
	
}
