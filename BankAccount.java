
public class BankAccount 
{
	private double balance;
	
	public BankAccount()
	{
		balance = 0;
	}
	
	public void deposit(double amt)
	{
		balance += amt;
	}
	
	public void withdrawal(double amt)
	{
		balance -= amt;
	}
	
	public double getBalance()
	{
		return balance;
	}
}
