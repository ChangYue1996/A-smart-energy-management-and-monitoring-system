/**
*class SaverAccount
*This class define the rewrite the withdraw method,and the notice method
*@Author ChangYue
*@version 3.0
*/
public class SaverAccount extends BankAccount{
	private boolean notice = false;
	private double overdraft_limit = 500;
	private double overdraft_current = 0;
	private int accNo;
	private String accName;
	private double balance ;
	private double cheque;
	public SaverAccount(int accNo, String accName) {
		super(accNo,accName);
		this.accNo = accNo;
		this.accName = accName;
		this.balance = 0.0;
		}
	public SaverAccount(String accName, int accNo) {
		super(accName,accNo);
		this.accNo = accNo;
		this.accName = accName;
		this.balance = 0.0;
		}
/**
*Method notice
*This method is used to notice users if he/she can withdraw now
*/
	public void notice(){
		if(this.notice==true){
			System.out.println("NOTICE:your account can withdraw now!");
		}
	}
/**
*Method withdraw
*This method is used to withdraw amount of cash from an account 
*/
	public void withdraw(double amount) {
		System.out.println("Your balance is :"+this.getBalance());

		if(this.notice==true){
			if(this.getBalance()>=amount){
				this.setBalance(this.getBalance()-amount);
				System.out.println("Successfully!Now your balance is :"+this.getBalance());
				this.notice = false;
			}
			else if (this.getBalance() <amount){
			System.out.println("Erro,You balance is insufficient!");
			}
		}
		else if(this.notice ==false){
				System.out.println(" Your account is a saver account,so you can withdraw after 3 days!");
				this.notice = !this.notice;
			}
		}
	public void setNotice(){
		this.notice=true;
		System.out.println("Now you account can withdraw!");
	}
}
