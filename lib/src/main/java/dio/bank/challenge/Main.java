package dio.bank.challenge;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System.in);
		
		Account checkingAccount = new CheckingAccount();
		Account savingsAccount = new SavingsAccount();
		
		checkingAccount.withdraw(1000);
		savingsAccount.deposit(1500);
		
		
		checkingAccount.printStatement();
		System.out.println();
		savingsAccount.printStatement();
	}

}
