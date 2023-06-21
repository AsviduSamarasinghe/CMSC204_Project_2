/*
 * Class: CMSC204  
 * Due: 06/20/2023
 * Asvidu Samarasinghe
*/

@SuppressWarnings("serial")
public class StackOverflowException extends Exception {
	// Constructor
	public StackOverflowException() {
		this("Stack is full");
	}

	public StackOverflowException(String message) {
		super(message);
	}
}
