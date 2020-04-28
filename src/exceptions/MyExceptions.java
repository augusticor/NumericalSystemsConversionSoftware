package exceptions;

/**
 * Class for showing a message in case of a runtime exception
 * @author augusticor
 */
public class MyExceptions extends Exception {
	
	/**
	 * Constructor, whenever i call this class it asks me for an error message to display
	 * @param message to display
	 */
	public MyExceptions(String message){
		super(message);
	}
}