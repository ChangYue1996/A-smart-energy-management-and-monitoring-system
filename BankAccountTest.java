/**
*class BankAccountTest
*This class is the test class
*@Author ChangYue
*@version 3.0
*/
public class BankAccountTest {
	public static void main(String[] args) {
		CreditAgency credit = new CreditAgency();
		BankManage Administrator = new BankManage();
		int run = 0;//record running times ,after running 5times,clear funds.
		//
		while(true){
			Administrator.options();
			//System.out.println("Now,there is "+Administrator.getAccounts()+" accounts.");
			run++;
			if(run ==10){
			Administrator.Traversal_Accounts();
			}
		}
		

		

	}
}
