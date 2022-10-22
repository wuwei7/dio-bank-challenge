package dio.bank.challenge;

import java.util.Scanner;

import javax.swing.JOptionPane;

public abstract class Account implements IAccount {

	private static final int DEFAULT_BRANCH = 1;
	private static int sequential = 1;
	
	protected int branchNumber;
	protected int accountNumber;
	protected double balance;
	

	public Account() {
		this.branchNumber = DEFAULT_BRANCH;
		this.accountNumber = sequential++;
	}
	
	@Override
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	@Override
	public int withdraw(double amount) {
		if ((this.balance - amount) >= -1000) {
			this.balance -= amount;
			return 0;
		} else {
			JOptionPane.showMessageDialog(null, "$1000 overdraft limit reached. Give a smaller amount.");
			return 1;
		}
	}
	
	@Override
	public void transfer(double amount, Account targetAccount) {
		this.withdraw(amount);
		targetAccount.deposit(amount);
		this.printStatement();
		System.out.println();
		targetAccount.printStatement();
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
	
	public void askWhichTransaction(int accountType) {
		System.out.println("What would you like to do?");
		System.out.println("Choose 1 for withdrawal");
		System.out.println("Choose 2 for deposit");
		System.out.println("Choose 3 for transfer");
		System.out.println("Choose 4 for statement");
		scannerMethodTransaction(accountType);
		
	}
	
	public void scannerMethodTransaction(int accountType) {
		Scanner scanner = new Scanner(System.in);
		int transaction = Integer.valueOf(scanner.nextLine());
		System.out.println();
		
		if (transaction == 1) {
			withdrawQuestion();
		} else if (transaction == 2) {
			depositQuestion();
		} else if (transaction == 3) {
			transferQuestion(accountType);
		} else if (transaction == 4) {
			printStatement();
		}
		
		scanner.close();
	}
	
	public void withdrawQuestion() {
		System.out.println("How much would you like to withdraw?");
		double amount = scanner();
		callTransaction(1, amount);
	}

	public void depositQuestion() {
		System.out.println("How much would you like to deposit?");
		double amount = scanner();
		callTransaction(2, amount);
	}

	public void transferQuestion(int accountType) {
		if (accountType == 0) {
			System.out.println("How much would you like to transfer?");
			double amount = scanner();
			callTransaction(3, amount);
		} else {
			System.out.println("How much would you like to transfer?");
			double amount = scanner();
			callTransaction(4, amount);
		}
	}
	
	public void callTransaction(int transaction, double amount) {
		
		if (transaction == 1) {
			int overdraft = withdraw(amount);
			if (overdraft == 1) {
				withdrawQuestion();
			} else {
				this.printStatement();				
			}
		} else if (transaction == 2) {
			deposit(amount);
			this.printStatement();
		} else if (transaction == 3) {
			Account savingsAccount = createAccount(0);
			transfer(amount, savingsAccount);
		} else {
			Account checkingAccount = createAccount(1);
			transfer(amount, checkingAccount);
		}
	}
	
	public Account createAccount(int accountType) {
		if (accountType == 0) {
			Account savingsAccount = new SavingsAccount();
			return savingsAccount;
		} else {
			Account checkingAccount = new CheckingAccount();
			return checkingAccount;
		}
	}
	
	public double scanner() {
		Scanner scanner = new Scanner(System.in);
		double amount = Double.valueOf(scanner.nextLine());
		System.out.println();
		return amount;
	}
	
}
