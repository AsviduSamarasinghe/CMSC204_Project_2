/*
 * Class: CMSC204  
 * Due: 06/20/2023
 * Asvidu Samarasinghe
*/

@SuppressWarnings("serial")
public class QueueOverflowException extends Exception {
	// Constructor
	public QueueOverflowException() {
		this("Queue is full");
	}

	public QueueOverflowException(String message) {
		super(message);
	}

}
