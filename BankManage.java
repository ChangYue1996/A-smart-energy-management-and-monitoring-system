import java.util.Scanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.lang.System;

import java.util.Random;
/**
*class BankMange
*This class has most functions ,has to be instantiate first
*@Author ChangYue
*@version 3.0
*/
public class BankManage {
	private int accounts = 0;
	private BankAccount[]Account_Array=new BankAccount[5];
	File file;
	int Age = 0;
	BankManage(){
	}
/**
*Method options
*This method is used to login or create an account
*/
	public void options() {
		Scanner s = null;
		try{		 	 
			 s = new Scanner(System.in); 
             
             System.out.println("Press 1 to Create an account.\nPress 2 to Login an account.(Then you can Deposit funds,Withdraw funds,Clear funds,Close,Suspend or Re-instated an account.) \n"); 
             int op = s.nextInt(); 
             if(op == 1){create_account();s = null;}
             else if(op == 2){login();s= null;}
             else{
             	s= null;
             	System.out.println("Your enter is invalid,please try again!"); 
             	return;
             }

		}catch (Exception e) {
            System.out.println("Your enter is invalid,please try again!"); 
            e.printStackTrace();
        } finally {
            if(s != null){
                s.close();
                s = null;
            }
        }
        s = null;
	}
/**
*Method login
*This method is used to login
*/
	public void login(){
		//login
		Scanner sc_login = null;
		int which_account = 0;//to identify which account is trying to be logined
		int acc_line = 0;
		try{		 	 
			 sc_login = new Scanner(System.in); 
             
             System.out.println("Please enter your ACCOUNT NUMBER:\n");        
             String in_accnum = sc_login.nextLine(); 
             System.out.println("Please enter your PIN:\n"); 
             String in_pin = sc_login.nextLine(); 
             sc_login= null;
             //PIN is 3bits
             int lg_length = in_pin.length();
             if (lg_length!=3) {
             	System.out.println("Your PIN is wrong:\n");
             	return;
             }
             String accandpin = in_accnum+' '+in_pin;
             
			//find if account and pin is right
	        String path2 = BankManage.class.getResource("/").getFile();
	        File acc_pin = new File(path2+"account-PIN.txt");        
    	 	FileReader acc_pin_r = new FileReader(acc_pin);
	        BufferedReader bufferr = new BufferedReader(acc_pin_r);
	         
	        String str = bufferr.readLine();
	        
	        while((str = bufferr.readLine()) != null){
			      //if name not exist in losscredit table.
			      if(!str.contains(accandpin)){
			      	which_account++;
			      	continue;
			      }
			      else if(str.contains(accandpin)){
			      	System.out.println("Login successfully!\n"); 
			      	//System.out.println("get the line of acc-PIN:"+which_account); 
			      	//acc line ==accounts
			      	acc_line = which_account;
			      }
			      else{
             		System.out.println("Your enter is invalid,please try again!"); 
             		return;
             	}

			     }
			
		}catch (Exception e) {
            System.out.println("Your enter is invalid,please try again!"); 
            e.printStackTrace();
            return;
        } finally {
            if(sc_login != null){
                sc_login.close();
                sc_login = null;
            }
        }
        //if the account is suspend
        if (Account_Array[acc_line].getSuspend()==false)
		{//choose
			System.out.println("now your balance is "+Account_Array[acc_line].getBalance());
			Account_Array[acc_line].notice();
		Scanner sc_login_op = null;
		try{		 	 
			 sc_login_op = new Scanner(System.in); 
             
             System.out.println("\nPress 1 to Deposit funds.\nPress 2 to Withdraw funds. \nPress 3 to Clear funds. \nPress 4 to Suspend an account. \nPress 5 to Re-instated an account.\nPress 6 to Close an account.\n");; 
             int lg = sc_login_op.nextInt(); 
             if(lg == 1){save(acc_line);;sc_login_op = null;}
             else if(lg == 2){wd(acc_line);sc_login_op = null;}
             else if(lg == 3){clear(acc_line);sc_login_op = null;}
             else if(lg == 4){suspend(acc_line);sc_login_op = null;}
             else if(lg == 5){reinstated(acc_line);sc_login_op = null;}
             else if(lg == 6){delete_account(acc_line) ; sc_login_op = null;}
             else{
             	System.out.println("Your enter is invalid,please try again!"); 
             	return;
             }
		}catch (Exception e) {
            System.out.println("Your enter is invalid,please try again!"); 
            e.printStackTrace();
        } finally {
            if(sc_login_op != null){
                sc_login_op.close();
                sc_login_op = null;
            }
        }
        sc_login_op = null;
    	}
    	else{
    		System.out.println("Your account is suspended.Please Re-instated first!"); 
    	}
	}
/**
*Method create_account
*This method is used to create an account
*/
	public void create_account() {
		 Scanner sc = null;
		 int num=0;
		 int pin=0;
		 //for judge if the file is create first time
	     int inception = 0;
		 try {
		 	 sc = new Scanner(System.in); 
             System.out.println("Please enter your name"); 
             String name = sc.nextLine(); 
             System.out.println("Please enter your address"); 
             String add = sc.nextLine(); 
             System.out.println("Please enter your year of birth"); 
             int date_year = sc.nextInt(); 
             System.out.println("Please enter your month of birth"); 
             int date_month = sc.nextInt();
             System.out.println("Please enter your day of birth"); 
             int date_day = sc.nextInt();
             System.out.println("Please enter the type of account you want to open.(Please enter Saver or Junior or Current)");
             String type = sc.next(); 
	             if(date_month<3){
	                Age = 2018-date_year;      
	            } 
	            else if(date_month ==3) {
	                if (date_day>24){
	                    Age = 2018-date_year-1;
	                }
	                else{
	                    Age = 2018-date_year;
	                }
	            }
	            else if (date_month >3)  {
	                Age = 2018-date_year-1;
	            }
	            else{
	                System.out.println("Erro."); 
	            }                
             System.out.println("Your information is 	"); 
             System.out.println("Name:"+name+"\n"+"Address:"+add+"\n"+"Age:"+Age+"\n"+"type of account you want to open is "+type);
	        //before open an account,check credit
	        String path1 = CreditAgency.class.getResource("/").getFile();
	        File file = new File(path1+"losscredit.txt");        
    	 	FileReader fr = new FileReader(file);
	        BufferedReader br = new BufferedReader(fr);
	        String str = br.readLine();
	        //create a account_num---PIN table
	       	//create a new file        
			String path = CreditAgency.class.getResource("/").getFile();
	        File file2 = new File(path+"account-PIN.txt");
	       
	        if(!file2.exists()){
	            file2.getParentFile().mkdirs(); 
	            inception = 1; 

	        }
	        file2.createNewFile();
		    // write
	        FileWriter fw = new FileWriter(file2, true);
	        BufferedWriter bw = new BufferedWriter(fw);
	        if(inception==1){
	        bw.write("\r\n");
		    bw.flush();
	    		}
             if(type.toLowerCase().equals("saver")){
			 	  //String str = null;Read each line and print
			      while((str = br.readLine()) != null){
			      //if name not exist in losscredit table.
			      if(!str.equals(name)){
			      	continue;
			      }
			      else if(str.equals(name)){
			      	System.out.println("Sorry,you have a bad credit history,we can not open an account for you.");
			      	System.exit(0);
			      }
			      else{
			      	System.out.println("Sorry,something wrong.");
			      	System.exit(0);
			      }
				}
				Random rand = new Random();
				num = rand.nextInt(9000) + 1000;
				pin = rand.nextInt(900) + 100;
             	System.out.println("Open a Saver account successfully!");
	            bw.write(name+" "+num+" "+pin+"\r\n");
		        bw.flush();
		        bw.close();
		        fw.close();
				System.out.println("Your ACCOUNT NUMBER is "+num);
		        System.out.println("Your PIN is "+pin);
		         BankAccount b = new SaverAccount(name,num);
		        
		        Account_Array[accounts] = b;
		        accounts++;
             }             
             else if(type.toLowerCase().equals("junior")){
             	if(Age<16){
 					while((str = br.readLine()) != null){
				      //if name not exist in losscredit table.
				      if(!str.equals(name)){
				      	continue;
				      }
				      else if(str.equals(name)){
				      	System.out.println("Sorry,you have a bad credit history,we can not open an account for you.");
				      	return;
				      }
				      else{
				      	System.out.println("Sorry,something wrong.");
				      	return;
				      }
					}
             	System.out.println("Open a Junior account successfully!");
				Random rand = new Random();
				num = rand.nextInt(9000) + 1000;
				pin = rand.nextInt(900) + 100;
				bw.write(name+" "+num+" "+pin+"\r\n");
		        bw.flush();
		        bw.close();
		        fw.close();
				System.out.println("Your ACCOUNT NUMBER is "+num);
		        System.out.println("Your PIN is "+pin);
		        BankAccount j = new JuniorAccount(name,num);
		        Account_Array[accounts] = j;
		        accounts++;
             	}
             	else{
             		System.out.println("Your age is not less than 16 years old,so you can not open a Junior account"); 
             	}
             }
             else if(type.toLowerCase().equals("current")){
			      while((str = br.readLine()) != null){
			      //if name not exist in losscredit table.
			      if(!str.equals(name)){
			      	continue;
			      }
			      else if(str.equals(name)){
			      	System.out.println("Sorry,you have a bad credit history,we can not open an account for you.");
			      	System.exit(0);
			      }
			      else{
			      	System.out.println("Sorry,something wrong.");
			      	System.exit(0);
			      }
				}
             	System.out.println("Open a current account successfully!");
				Random rand = new Random();
				num = rand.nextInt(9000) + 1000;
				pin = rand.nextInt(900) + 100;
				bw.write(name+" "+num+" "+pin+"\r\n");
		        bw.flush();
		        bw.close();
		        fw.close();
				System.out.println("Your ACCOUNT NUMBER is "+num);
		        System.out.println("Your PIN is "+pin);
		        BankAccount c = new CurrentAccount(name,num);
		        
		        Account_Array[accounts] = c;
		        accounts++;
				
             }
             else{
             	System.out.println("Erro!Invalid account type!");
             }
             sc = null;

        } catch (Exception e) {
            System.out.println("Your enter is invalid,please try again!"); 
            e.printStackTrace();
        } finally {
            if(sc != null){
                sc.close();
                sc = null;
            }
        }
		//Account_Array[accounts] = account;
		//accounts++;
		
	}
/**
*Method delete_account
*This method is used to delete an account
*/
	public void delete_account(int which) {
		System.out.println(which);
		if(Account_Array[which].getCheck_cheque()){
			//before close account ,check if clear funds.
			for(int i=0;i<Account_Array.length;i++){  
				    for(int j=which;j<Account_Array.length;j++){  
				       if(j+1<Account_Array.length){  
				    	   Account_Array[j]=Account_Array[j+1];  
				                    }  
				             }  
				}
			try{
		        String path3 = BankManage.class.getResource("/").getFile();
		        BufferedReader dbr=new BufferedReader(new FileReader( path3+"account-PIN.txt"));
		        StringBuffer dsb=new StringBuffer(4096);   
			 	String str=null;
		        int lines = 0;
		        while((str = dbr.readLine()) != null){
		        	//if it is the line needed to be deleted
		        	lines++;
		        	if(lines==which+2){
		        		continue;
		        	}
		        	dsb.append(str).append("\r\n");
		        	
		        }
		        dbr.close();
		        BufferedWriter dbw = new BufferedWriter(new FileWriter(path3+"account-PIN.txt"));
		        dbw.write(dsb.toString());
		        dbw.close();

	           } catch (Exception e) {
	            System.out.println("Failed to delete an account."); 
	            e.printStackTrace();
	        }
			accounts--;
			System.out.println("Delete successfully!");
		}
		else{
			System.out.println("Your account have not clear funds yet,so you can not close the account!");
			return;
		}
	}
/**
*Method save
*This method is used to save cash
*/
	public void save(int ac){
		System.out.println("The balance of the account is :"+Account_Array[ac].getBalance());
		Scanner sc_save = null;
		Scanner sc_vol = null;
		try{		 	 
			 sc_save = new Scanner(System.in); 
			 sc_vol = new Scanner(System.in); 
             System.out.println("Which you want to save:\n(Press '1')Deposit cash\n\n(Press '2')Deposit cheque\n");        
             int cc = sc_save.nextInt(); 
             sc_save = null;

             //cash
             if(cc ==1){
				System.out.println("How much you want to desposit,please enter:\n"); 
				String volume = sc_vol.nextLine();
				double vol = Double.valueOf(volume).doubleValue(); 
				Account_Array[ac].deposit(vol);
				System.out.println("Successfully!Now your balance is :"+Account_Array[ac].getBalance()); 
             }
             //cheque
             else if (cc==2){
				System.out.println("How much you want to desposit,please enter:\n"); 
				String volume = sc_vol.nextLine();
				double vol = Double.valueOf(volume).doubleValue(); 
				Account_Array[ac].depositche(vol);
				System.out.println("Successfully!Now your Cheque values (un-cleared):"+Account_Array[ac].getcheque()); 
             }
             else{
             	System.out.println("Your enter is invalid,please try again!"); 
             	return;
             }
         }catch (Exception e) {
            System.out.println("Your enter is invalid,please try again!"); 
            e.printStackTrace();
            return;}
	}
/**
*Method withdraw
*This method is used to withdraw amount of cash from an account 
*/
	public void wd(int ac){
		Scanner sc_vol = null;
		try{	 	 
			sc_vol = new Scanner(System.in); 
            System.out.println("How much you want to Withdraw:\n");        
			String volume = sc_vol.nextLine();
			double vol = Double.valueOf(volume).doubleValue(); 
			
			Account_Array[ac].withdraw(vol);
			 
			sc_vol = null;
            
         }catch (Exception e) {
            System.out.println("Your enter is invalid,please try again!"); 
            e.printStackTrace();
            return;}
	}
/**
*Method suspend
*This method is used to suspend an account
*/
	public void suspend(int ac){
			Account_Array[ac].setSuspend();

	}
/**
*Method clear
*This method is used as an external bank to clear funds in an account.
*/
	public void clear(int ac){
			Account_Array[ac].clear();
			System.out.println("Clear funds,successfully!Now your balance is :"+Account_Array[ac].getBalance());

	}
/**
*Method reinstated
*This method is used to reinstated an account .
*/
	public void reinstated(int ac){
			Account_Array[ac].reinstated();

	}
/**
*Method Traversal_Accounts
*This method is used as an external bank to clear funds in each account.
*/
	public void Traversal_Accounts() {
		
		for(int i=0;i<Account_Array.length;i++){
			//System.out.println();
			//System.out.println(Account_Array[i]);
			//if not clear funds yet
			if(Account_Array[i].getCheck_cheque()==false){
				Account_Array[i].clear();
				System.out.println("Clear funds in account:"+i);
			}
			System.out.println("Clear funds in every account!");

		}
	}
	public int getAccounts() {
		return accounts;
	}
	public void check_credit_create(){
		System.out.println("Please input your\n1. NAME\n2. ADDRESS\n3. DATE OF BIRTH\n4. TYPE OF ACCOUNT TO BE OPENED\n");
	}
}
