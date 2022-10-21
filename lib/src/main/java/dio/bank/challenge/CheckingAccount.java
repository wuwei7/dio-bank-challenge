package dio.bank.challenge;

public class CheckingAccount extends Account {

	private static int sequential = 1;

	public CheckingAccount() {
		super.branchNumber = DEFAULT_BRANCH;
		super.accountNumber = sequential++;
	}
	
	public void printStatement() {
		System.out.println("=== Checking Account Statement ===");
		super.printStatements();
	}
}
