package dio.bank.challenge;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Type 1 to create a checking account and 2 to create a savings account: ");
		scanner();
		System.out.println();
		
	}
	
	public static void scanner() {
		Scanner scanner = new Scanner(System.in);
		int value = Integer.valueOf(scanner.nextLine());
		System.out.println();
		askWhichAccount(value);
	}
	
	public static void askWhichAccount(int value) {
		if (value == 1) {
			Account checkingAccount = new CheckingAccount();
			checkingAccount.askWhichTransaction(0);
		} else if (value == 2) {
			Account savingsAccount = new SavingsAccount();
			savingsAccount.askWhichTransaction(1);
		} else {
			System.out.print("Invalid number. Please choose 1 for checking account and 2 for savings account: ");
			scanner();
		}
	}

}
