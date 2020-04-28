package constants;

/**
 * Text for labels and interface communication
 * @author augusticor
 */
public class ConstantsGUI {

	public static final String MAIN_TITLE = "Numerical Conversion Software";
	public static final String BINARY_TO_ANY_BASE = "Converts a number in base 2 (binary) to base 10, 8 and 16";
	public static final String DECIMAL_TO_ANY_BASE = "Converts a number in base 10 (decimal) to base 2, 8 and 16";
	public static final String OCTAL_TO_ANY_BASE = "Converts a number in base 8 (octal) to base 2, 10 and 16";
	public static final String HEXADECIMAL_TO_ANY_BASE = "Converts a number in base 16 (hexadecimal) to base 2, 10 and 8";
	public static final String WRITE_NUMBER_TO_CONVERT = "Write the number to be converted (Available bases : 2, 10, 8, 16)";
	public static final String CONVERT = "Convert the number !!";
	public static final String INFO_SISTEMAS = "About";
	public static final String MY_INFO = "Oscar Augusto Rojas - augusticor";

	public static final String INSTRUCTIONS = "Instructions";
	public static final String INSTRUCTIONS_INFO = "\tINSTRUCTIONS\t\n\n"
												+  "1.  Enter the number to convert in the upper right box.\n\n"
												+  "2.  Select one of the buttons wich indicates :\n"
												+  "\t2.1 Base of the number the Big icon.\n"
												+  "\t2.2 Bases to wich it will be converted.";
	
	/**
	 * Generates and string with an error if the base conversion is wrong Example. 78585(8) this number is not in 8th base because of 8 number 
	 * @param originalNumber the number the user wants to convert
	 * @param base to convert the number (2, 8, 10, 16)
	 * @return an error message explaining that the number is not in the specified base
	 */
	public static final String numberFormatE(String originalNumber, int base) {
		return "Not Possible conversion\nThe number "+ originalNumber + " is not in base " + base;
	}
}