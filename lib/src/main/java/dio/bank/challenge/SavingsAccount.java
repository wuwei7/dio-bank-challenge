package dio.bank.challenge;

public class SavingsAccount extends Account {
	
	private static int sequential = 1;

	public SavingsAccount() {
		super.branchNumber = DEFAULT_BRANCH;
		super.accountNumber = sequential++;
	}
}
