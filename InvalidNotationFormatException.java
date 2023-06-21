/*
 * Class: CMSC204  
 * Due: 06/20/2023
 * Asvidu Samarasinghe
*/
@SuppressWarnings("serial")
public class InvalidNotationFormatException extends Exception {
	public InvalidNotationFormatException() 
	{
		super("Notation format is not correct");
	}
}