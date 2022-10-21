package dio.bank.challenge;

public abstract class Account implements IAccount {

	protected static final int DEFAULT_BRANCH = 1;
	
	protected int branchNumber;
	protected int accountNumber;
	protected double balance;
	
	
	@Override
	public void deposit(double amount) {
		
	}
	
	@Override
	public void withdraw(double amount) {
		
	}
	
	@Override
	public void transfer(double amount, Account targetAccount) {
		
	}
	
	public int getBranchNumber() {
		return branchNumber;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
}
