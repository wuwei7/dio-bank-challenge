package dio.bank.challenge;

public interface IAccount {
	
	void deposit(double amount);
	
	int withdraw(double amount);
	
	void transfer(double amount, Account targetAccount);
	
	void printStatement();

}
