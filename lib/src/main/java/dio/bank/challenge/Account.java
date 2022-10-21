package dio.bank.challenge;

public abstract class Account implements IAccount {

	protected static final int DEFAULT_BRANCH = 1;
	
	protected int branchNumber;
	protected int accountNumber;
	protected double balance;
	
	@Override
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	@Override
	public void withdraw(double amount) {
		this.balance -= amount;
		
	}
	
	@Override
	public void transfer(double amount, Account targetAccount) {
		this.withdraw(amount);
		targetAccount.deposit(amount);
	}
	
	protected void printStatements() {
		System.out.println(String.format("Branch Number: %d", this.branchNumber));
		System.out.println(String.format("Account Number: %d", this.accountNumber));
		System.out.println(String.format("Account Balance: %.2f", this.balance));
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
