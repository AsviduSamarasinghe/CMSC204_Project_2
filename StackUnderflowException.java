/*
 * Class: CMSC204  
 * Due: 06/20/2023
 * Asvidu Samarasinghe
*/

@SuppressWarnings("serial")
public class StackUnderflowException extends Exception {
	// Constructor
	public StackUnderflowException() {
		this("Stack is empty");
	}

	public StackUnderflowException(String message) {
		super(message);
	}
}
