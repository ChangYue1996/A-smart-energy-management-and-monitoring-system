/**
*class BankAccount
*This class define the fundamental functions and attributes of every account.
*@author ChangYue
*@version 3.0
*/


public class BankAccount {
	private int accNo;
	private String accName;
	private double balance;
	private boolean suspend = false;
	private double cheque;
	private boolean check_cheque = true;
	public BankAccount(int accNo, String accName) {
	this.accNo = accNo;
	this.accName = accName;
	this.balance = 0.0;
	this.cheque = 0.0;
	}
	public BankAccount(String accName, int accNo) {
	this.accNo = accNo;
	this.accName = accName;
	this.balance = 0.0;
	this.cheque = 0.0;
	}
	public void notice(){
		
	}
/**
*Method setSuspend
*This method is used to suspend an account
*/
	public void setSuspend(){
		this.suspend=true;
		System.out.println("Now your account is suspend!");
	}
/**
*Method getSuspend
*This method is used to get the state of suspend from external
*/
	public boolean getSuspend(){
		return suspend;
	}
	public boolean getCheck_cheque(){
		return check_cheque;
	}
	public int getAccNo( ) {
	return accNo;
	}
	public String getAccName( ) {
	return accName;
	}
	public double getBalance( ) {
	return balance;
	}
	public double getcheque( ) {
	return cheque;
	}
	public void setBalance(double ba){
		this.balance = ba;
	}
	public void setAccName(String accName) {
	this.accName = accName;
	}
/**
*Method deposit
*This method is used to save cash into an account.
*/
	public void deposit(double amount) {
	this.balance = this.balance + amount;
	}
/**
*Method depositche
*This method is used to save cheque.
*/
	public void depositche(double amount) {
	this.cheque = this.cheque + amount;
	this.check_cheque= false;
	}
	public void setCheck_cheque(){
		this.check_cheque = true;
	}
/**
*Method clear
*This method is used to clear cheque into cash
*/
	public void clear(){
		this.balance = this.balance +this.cheque;
		this.cheque = 0;
		this.check_cheque = true;
	}
/**
*Method reinstated()
*This method is used to reinstate an account
*/
	public void reinstated(){
		this.suspend = false;
	}
/**
*Method withdraw
*This method is used to withdraw amount of cash from an account 
*/
	public void withdraw(double amount) {
		System.out.println("In withdraw,your balance is "+this.balance);
	if(this.balance - amount>=0){
		this.balance = this.balance - amount;
		System.out.println("Successfully!Now your balance is :"+this.balance);
	}
	else if (balance - amount<0){
		System.out.println("Erro,You balance is insufficient!");
	}
	}


	public String toString() {
	return "Account number: "+ accNo
	+ "\n" +"Account name: " + accName
	+ "\n" +"Balance: "+ balance+ "\n";
		}
}
