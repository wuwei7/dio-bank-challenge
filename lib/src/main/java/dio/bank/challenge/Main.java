package dio.bank.challenge;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Type 1 for checking account and 2 for savings account: ");
		int value = Integer.valueOf(scanner.nextLine());
		askWhichAccount(value);
		
	}
	
	public static void askWhichAccount(int value) {
		if (value == 1) {
			Account checkingAccount = new CheckingAccount();
			checkingAccount.askClientWhichTransaction();
		} else {
			Account savingsAccount = new SavingsAccount();
			savingsAccount.askClientWhichTransaction();
		}
	}

}
