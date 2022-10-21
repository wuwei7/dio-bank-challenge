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
		System.out.println("Balance: " + getBalance());
	}
	
	@Override
	public void withdraw(double amount) {
		if ((this.balance - amount) >= -1000) {
			this.balance -= amount;
			System.out.println("Balance: " + getBalance());
		} else {
			JOptionPane.showMessageDialog(null, "$1000 overdraft limit reached. Give a smaller amount.");
			withdrawQuestion();
		}
	}
	
	@Override
	public void transfer(double amount, Account targetAccount) {
		this.withdraw(amount);
		targetAccount.deposit(amount);
		System.out.println("Balance: " + getBalance());
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
	
	public void askClientWhichTransaction() {
		System.out.println("What would you like to do?");
		System.out.println("Choose 1 for withdrawal");
		System.out.println("Choose 2 for deposit");
		System.out.println("Choose 3 for transfer");
		System.out.println("Choose 4 for statement");
		scannerMethodTransaction();
		
	}
	
	public void scannerMethodTransaction() {
		Scanner scanner = new Scanner(System.in);
		int value = Integer.valueOf(scanner.nextLine());
		
		if (value == 1) {
			withdrawQuestion();
		} else if (value == 2) {
			depositQuestion();
		} else if (value == 3) {
			transferQuestion();
		} else if (value == 4) {
			printStatement();
		}
	}
	
	public void withdrawQuestion() {
		System.out.println("How much would you like to withdraw?");
		scannerMethod(1);
	}

	public void depositQuestion() {
		System.out.println("How much would you like to deposit?");
		scannerMethod(2);
	}

	public void transferQuestion() {
		System.out.println("How much would you like to transfer?");
		scannerMethod(3);
	}
	
	public void scannerMethod(int value) {
		Scanner scanner = new Scanner(System.in);
		double amount = Double.valueOf(scanner.nextLine());
		
		if (value == 1) {
			withdraw(amount);
		} else if (value == 2) {
			deposit(amount);
		} else if (value == 3) {
			transfer(amount, null);
		}
	}
}
