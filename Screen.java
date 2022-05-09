package ATMMachine;

public class Screen {
	// display a message without a new line
	public void displayMessage( String message ){
		System.out.print( message );
	}
	
	// display a message with a new line
	public void displayMessageLine( String message ){
		System.out.println( message );
	}
	
	// displays a dollar amount up-to 2 decimal places
	public void displayDollarAmount( double amount ){
		System.out.printf( "$%,.2f", amount );
	}
}
