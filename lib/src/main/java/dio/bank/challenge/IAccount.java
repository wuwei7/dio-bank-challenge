package dio.bank.challenge;

public interface IAccount {
	
	void deposit(double amount);
	
	void withdraw(double amount);
	
	void transfer(double amount, Account targetAccount);

}
