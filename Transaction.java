package ATMMachine;

public abstract class Transaction {
	private int accountNumber;
	private Screen screen;
	private BankDatabase bankDatabase;
	
	// Transaction constructor invoked by subclasses using super()
	public Transaction( int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase ){
		accountNumber = userAccountNumber;
		screen = atmScreen;
		bankDatabase = atmBankDatabase;
	}
	
	// return account number
	public int getAccountNumber(){
		return accountNumber;
	}
	
	// return reference to screen
	public Screen getScreen(){
		return screen;
	}
	
	// return reference to bank database
	public BankDatabase getBankDatabase(){
		return bankDatabase;
	}
	
	// perform the transaction (overridden by each subclass)
	abstract public void execute();
}