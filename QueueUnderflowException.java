/*
 * Class: CMSC204  
 * Due: 06/20/2023
 * Asvidu Samarasinghe
*/

@SuppressWarnings("serial")
public class QueueUnderflowException extends Exception {
	// Constructor
	public QueueUnderflowException() {
		this("Queue is empty");
	}

	public QueueUnderflowException(String message) {
		super(message);
	}

}
