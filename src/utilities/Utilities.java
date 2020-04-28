package utilities;

/**
 * Useful tools for the project
 * @author augusticor
 */
public class Utilities {

	/**
	 * Splits any number by the dot character
	 * @param value the number to split
	 * @return an array with length 2 [the decimal part of the number]and[the float part of the number]
	 */
	public static final String[] splitNotDecimalNumber(String value) {
		return value.split("\\.");
	}
}