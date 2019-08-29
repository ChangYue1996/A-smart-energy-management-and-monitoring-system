/**
*class CurrentAccount
*This class define the rewrite the withdraw method
*@Author ChangYue
*@version 3.0
*/

public class CurrentAccount extends BankAccount{
	private double overdraft_limit = 500;
	private double overdraft_current = 0;
	private int accNo;
	private String accName;
	private double balance ;
	private double cheque;
	//private boolean suspend = false;
	public CurrentAccount(int accNo, String accName) {
	super(accNo,accName);
	this.accNo = accNo;
	this.accName = accName;
	this.balance = 0.0;
	this.cheque = 0.0;
	}
	public CurrentAccount(String accName, int accNo) {
	super(accName,accNo);
	this.accNo = accNo;
	this.accName = accName;
	this.balance = 0.0;
	this.cheque = 0.0;
	}
	public void depositche(double amount) {
	cheque = cheque + amount;
	}
	public double getcheque( ) {
	return cheque;
	}
	public double getoverdraft(){
			return overdraft_current;
	}
	public int getAccNo( ) {
	return accNo;
	}
	public String getAccName( ) {
	return accName;
	}
	public void deposit(double amount) {
	this.balance = this.balance + amount - overdraft_current ;
	System.out.printf("Now,your balance is %.1f\n",this.balance);
	}
/**
*Method withdraw
*This method is used to withdraw amount of cash from an account 
*/
	public void withdraw(double amount) {
	// Failed withdraw
	if(balance < (-overdraft_limit + amount)){
		System.out.printf("Your balance is insufficient.(Reaches your overdraft limit.)\n");
	}
	//Withdraw
	else if(balance >= (-overdraft_limit + amount)){
		overdraft_current = overdraft_current + amount;
		balance = balance - overdraft_current;
		System.out.printf("Withdraw successfully,now your balance is %.1f.\n",balance);
	}
	else{
		System.out.printf("Falied.\n");
	}
	
	}
	public String toString() {
	return "Account number: "+ accNo
	+ "\n" +"Account name: " + accName
	+ "\n" +"Balance: "+ balance+ "\n";
		}
}
