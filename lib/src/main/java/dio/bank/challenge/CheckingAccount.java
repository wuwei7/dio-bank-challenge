package dio.bank.challenge;

public class CheckingAccount extends Account {
	
	public void printStatement() {
		System.out.println("=== Checking Account Statement ===");
		super.printStatements();
	}
}
