import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
/**
*class CreditAgency
*This class define a list of loss credit user who can not open an account.
*@Author ChangYue
*@version 3.0
*/
public class CreditAgency {
	CreditAgency(){
		String path = CreditAgency.class.getResource("/").getFile();
        File file = new File(path+"losscredit.txt");
        if(!file.exists()){
            file.getParentFile().mkdirs();
            } 
        try{
        file.createNewFile();

        //losscredit should be a name list,formate is "a name"+"\n"
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("\r\n"+"Tommus"+"\r\n"+"Anna"+"\r\n");
        bw.flush();
        bw.close();
        fw.close();}catch (Exception e) {
        System.out.println("Failed to create a file"); 
        e.printStackTrace();
        }

	}

}
