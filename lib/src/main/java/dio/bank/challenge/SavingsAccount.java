package dio.bank.challenge;

public class SavingsAccount extends Account {
	
	public void printStatement() {
		System.out.println("=== Savings Account Statement ===");
		super.printStatements();
	}
}
