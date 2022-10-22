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
	public void withdraw(double amount) {
		if ((this.balance - amount) >= -1000) {
			this.balance -= amount;
		} else {
			JOptionPane.showMessageDialog(null, "$1000 overdraft limit reached. Give a smaller amount.");
			withdrawQuestion();
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
	
	public void askWhichTransaction(int value) {
		System.out.println("What would you like to do?");
		System.out.println("Choose 1 for withdrawal");
		System.out.println("Choose 2 for deposit");
		System.out.println("Choose 3 for transfer");
		System.out.println("Choose 4 for statement");
		scannerMethodTransaction(value);
		
	}
	
	public void scannerMethodTransaction(int value) {
		Scanner scanner = new Scanner(System.in);
		int transaction = Integer.valueOf(scanner.nextLine());
		System.out.println();
		
		if (transaction == 1) {
			withdrawQuestion();
		} else if (transaction == 2) {
			depositQuestion();
		} else if (transaction == 3 && (value == 0 || value == 1)) {
			transferQuestion(value);
		} else if (transaction == 4) {
			printStatement();
		}
		
		scanner.close();
	}
	
	public void withdrawQuestion() {
		System.out.println("How much would you like to withdraw?");
		scannerMethod(1);
	}

	public void depositQuestion() {
		System.out.println("How much would you like to deposit?");
		scannerMethod(2);
	}

	public void transferQuestion(int value) {
		if (value == 0) {
			Account account = createAccount(value);
			System.out.println("How much would you like to transfer?");
			scannerMethod(account);
		} else {
			Account account = createAccount(value);
			System.out.println("How much would you like to transfer?");
			scannerMethod(account);
		}
	}
	
	public void scannerMethod(int value) {
		Scanner scanner = new Scanner(System.in);
		double amount = Double.valueOf(scanner.nextLine());
		System.out.println();
		
		if (value == 1) {
			withdraw(amount);
		} else if (value == 2) {
			deposit(amount);
		}
		
		scanner.close();
	}
	
	public void scannerMethod(Account account) {
		Scanner scanner = new Scanner(System.in);
		double amount = Double.valueOf(scanner.nextLine());
		System.out.println();
		
		Account savingsAccount = new SavingsAccount();
		Account checkingAccount = new CheckingAccount();
		
		if (checkingAccount.equals(account)) {
			transfer(amount, savingsAccount);
		} else {
			transfer(amount, checkingAccount);
		}
		
		scanner.close();
	}
	
	public Account createAccount(int value) {
		if (value == 0) {
			Account savingsAccount = new SavingsAccount();
			return savingsAccount;
		} else {
			Account checkingAccount = new CheckingAccount();
			return checkingAccount;
		}
	}
}
