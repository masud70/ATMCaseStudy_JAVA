package ATMMachine;

public class CashDispenser {
	// the default initial number of bills in the cash dispenser
	private final static int INITIAL_COUNT = 500;
	private int count;
	
	// constructor
	public CashDispenser(){
		count = INITIAL_COUNT;
	}
	
	// simulates dispensing of specified amount of cash
	public void dispenseCash( int amount ){
		int billsRequired = amount / 20;
		count -= billsRequired;
	}
	
	// indicates whether cash dispenser can dispense desired amount
	public boolean isSufficientCashAvailable( int amount ){
		int billsRequired = amount / 20;
	
		if ( count >= billsRequired )
			return true;
		else
			return false;
	}
}
