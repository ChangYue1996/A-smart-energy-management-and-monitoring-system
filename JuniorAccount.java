public class JuniorAccount extends BankAccount{
	private int accNo;
	private String accName;
	private double balance;
	private boolean suspend = false;
	private double cheque;
	private boolean check_cheque = true;
	public JuniorAccount(int accNo, String accName) {
		super(accNo,accName);
		this.accNo = accNo;
		this.accName = accName;
		this.balance = 0.0;
		}
	public JuniorAccount(String accName, int accNo) {
		super(accName,accNo);
		this.accNo = accNo;
		this.accName = accName;
		this.balance = 0.0;
		}
}


