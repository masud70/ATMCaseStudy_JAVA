package ATMMachine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BankDatabase {
	int len;
	private Account[] accounts;
    
	public BankDatabase(){
		len = (int) Lines();
		accounts = new Account[ len ];
		LoadAccounts();
	}
	
	private void LoadAccounts(){
		File file = new File("F:\\Codes\\JavaCode\\ATMCaseStudy\\src\\ATMMachine\\Account.txt");
		int i = 0;
		
	    try (Scanner sc = new Scanner(file)) {
	    	while (sc.hasNextLine()) {
	    		int theAccountNumber = sc.nextInt();
	    		int thePin = sc.nextInt();
	    		double theAvailableBalance = sc.nextDouble();
	    		double theTotalBalance = sc.nextDouble(); 
	    		accounts[i++] = new Account( theAccountNumber, thePin, theAvailableBalance, theTotalBalance);
	    	}
	    }catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	private long Lines() {
		long lines = 0;
				
		try (BufferedReader reader = new BufferedReader(new FileReader("F:\\Codes\\JavaCode\\ATMCaseStudy\\src\\ATMMachine\\Account.txt"))) {
		    while (reader.readLine() != null) lines++;
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return lines;
	}
	
	// retrieve Account object containing specified account number
	private Account getAccount( int accountNumber ){
		for ( Account each : accounts ){
			if ( each.getAccountNumber() == accountNumber )
			return each;
		}
		return null;
	}
	
	// method for user authentication
	public boolean authenticateUser( int userAccountNumber, int userPIN ){
		Account userAccount = getAccount( userAccountNumber );
		if ( userAccount != null )
			return userAccount.validatePIN( userPIN );
		else
			return false;
	}
	
	public double getAvailableBalance( int userAccountNumber ){
		return getAccount( userAccountNumber ).getAvailableBalance();
	}
	
	public double getTotalBalance( int userAccountNumber ){
		return getAccount( userAccountNumber ).getTotalBalance();
	}
	
	public void credit( int userAccountNumber, double amount ){
		getAccount( userAccountNumber ).credit( amount );
		updateDatabase();
	}
	
	public void debit( int userAccountNumber, double amount ){
		getAccount( userAccountNumber ).debit( amount );
		updateDatabase();
	}
	private void updateDatabase() {
		try {
		      FileWriter myWriter = new FileWriter("F:\\Codes\\JavaCode\\ATMCaseStudy\\src\\ATMMachine\\newFile.txt");
		      for(int i = 0; i<len; i++) {
		    	  myWriter.write(accounts[i].getAccountNumber()+" "+accounts[i].getPin()+" "+accounts[i].getAvailableBalance()+" "+accounts[i].getTotalBalance());
		      }
		      myWriter.close();
		      File file = new File("F:\\Codes\\JavaCode\\ATMCaseStudy\\src\\ATMMachine\\Account.txt");
		      file.delete();
		      File file1 = new File("F:\\Codes\\JavaCode\\ATMCaseStudy\\src\\ATMMachine\\newFile.txt");
		      File rename = new File("F:\\Codes\\JavaCode\\ATMCaseStudy\\src\\ATMMachine\\Account.txt");
		      boolean flag = file1.renameTo(rename);
		      if (flag == true) {
		    	  System.out.println("File Successfully Rename");
		      }
		      
	    }catch (IOException e) {
	    	System.out.println("An error occurred.");
	    	e.printStackTrace();
	    }
	}
}
