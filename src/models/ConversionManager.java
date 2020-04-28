package models;

import exceptions.MyExceptions;
import utilities.Utilities;

/**
 * Logic class, converts the input number in any base to any other
 * @author augusticor
 */
public class ConversionManager {

	/**
	 * Converts the not decimal part of a number (2, 8, 16) to decimal
	 * @param value to be converted
	 * @param multiplicator	the value base
	 * @return the decimal representation of the original value
	 */
	private static double convertFloatPartToDecimal(String value, int multiplicator) {
		double result = 0;
		for (int i = 1; i < value.length(); i++) {
			result += Character.getNumericValue(value.charAt(i)) * (Math.pow(multiplicator, (i * -1)));
		}
		return result;
	}

	/**
	 * Converts any base to base 10
	 * @param value the value to be converted
	 * @param valueBase the base of the original value
	 * @return the decimal representation of the number
	 */
	public static String convertAnyBaseToDecimal(String value, int valueBase) {
		String[] number = Utilities.splitNotDecimalNumber(value);
		if (number.length == 2) {
			return String.valueOf(Integer.parseInt(number[0], valueBase) + convertFloatPartToDecimal(0 + number[1], valueBase));
		}
		else {
			return String.valueOf(Integer.parseInt(number[0], valueBase));
		}
	}

	/**
	 * Converts the not decimal part from a number in base 10 to any base
	 * @return the converted value
	 */
	private static String convertFloatDecimalToAnyBase(double floatDecimal, int multiplicator) {
		String result = "";
		for (int i = 0; i < 4; i++) {
			floatDecimal *= multiplicator;
			if ((long)floatDecimal > 9) {
				result += Integer.toHexString((int)floatDecimal);
			} else {
				result += Utilities.splitNotDecimalNumber(String.valueOf(floatDecimal))[0];
			}
			floatDecimal = Double.parseDouble("0." + Utilities.splitNotDecimalNumber(String.valueOf(floatDecimal))[1]);
		}
		return result.toUpperCase();
	}

	/**
	 * Converts integer part of a decimal value to any base
	 * @param decimalValue the value in base 10
	 * @param baseToConvert the base to be converted
	 * @return the value converted in base inserted
	 */
	private static String convert10DecimalPartToAnyBase(int decimalValue, int baseToConvert) {
		switch (baseToConvert) {
		case 2:
			return Integer.toBinaryString(decimalValue);
		case 8:
			return Integer.toOctalString(decimalValue);
		case 16:
			return Integer.toHexString(decimalValue).toUpperCase();
		}
		return "The value couldn´t be converted";
	}

	/**
	 * Converts decimal number to any base
	 * @param decimalValue the number in base 10
	 * @param baseToConvert the base to convert
	 * @return the number in the new base
	 */
	public static String convertDecimalToAnyBase(String decimalValue, int baseToConvert) {
		String[] number = Utilities.splitNotDecimalNumber(decimalValue);
		if (number.length == 2) {
			return convert10DecimalPartToAnyBase(Integer.parseInt(number[0]), baseToConvert) + "." + convertFloatDecimalToAnyBase(Double.parseDouble("0." + number[1]), baseToConvert);
		}
		else {
			return convert10DecimalPartToAnyBase(Integer.parseInt(number[0]), baseToConvert);
		}
	}

	//--------------------------------------	2 -> 8 && 8 -> 2 -------------------------------------------------

	/**
	 * Converts the decimal part of a binary number to octal
	 * @param binaryValue the value in base 2
	 * @return the value converted to base 2
	 */
	private static String decimalBinaryPartToOctal(String binaryValue) {
		while (binaryValue.length() % 3 != 0) {
			binaryValue = "0" + binaryValue;
		}
		String aux = "" + binaryValue.charAt(0);
		String result = "";
		for (int i = 0; i < binaryValue.length(); i++) {
			if (i % 3 == 2) {
				result += convertAnyBaseToDecimal(aux, 2);
				if (binaryValue.length() - 1 != i) {
					aux = ""+binaryValue.charAt(i + 1);
				}
			} else {
				aux += binaryValue.charAt(i + 1);
			}
		}
		return result;
	}

	/**
	 * Converts the not decimal part of a binary number to octal
	 * @param binaryValue the value in binary
	 * @return the value converted in base 8
	 */
	private static String floatBinaryPartToOctal(String binaryValue) {
		while (binaryValue.length() % 3 != 0) {
			binaryValue += "0";
		}
		String aux = "" + binaryValue.charAt(0);
		String result = "";
		for (int i = 0; i < binaryValue.length(); i++) {
			if (i % 3 == 2) {
				result += convertAnyBaseToDecimal(aux, 2);
				if (binaryValue.length() - 1 != i) {
					aux = ""+binaryValue.charAt(i + 1);
				}
			} else {
				aux += binaryValue.charAt(i + 1);
			}
		}
		return result;
	}

	/**
	 * Converts any binary number to base 8
	 * @param binaryValue the original value in binary
	 * @return the value in base 8
	 */
	public static String convertBinaryToOctal(String binaryValue) {
		String[] number = Utilities.splitNotDecimalNumber(binaryValue);
		if (number.length == 2) {
			return decimalBinaryPartToOctal(number[0]) + "."+ floatBinaryPartToOctal(number[1]);
		} else {
			return decimalBinaryPartToOctal(number[0]);
		}
	}

	/**
	 * Converts an octal integer part to binary
	 * @param numberInOctal number in base 8
	 * @return the number in binary
	 * @throws MyExceptions if the number is not in base 8
	 */
	private static String convertIntegerOctalPartToBinary(String numberInOctal) throws MyExceptions {
		String result = "";
		String aux = "";
		for (int i = 0; i < numberInOctal.length(); i++) {
			int aux2 = Character.getNumericValue(numberInOctal.charAt(i));
			if (aux2 > 7) {
				throw new MyExceptions("The number " + aux2 + " is not in base 8");
			}
			aux = convertDecimalToAnyBase(""+numberInOctal.charAt(i), 2);
			while (aux.length() < 3) {
				aux = "0" + aux;
			}
			result += aux;
		}
		return result;
	}

	/**
	 * Allows to convert any number in base 8 to it´s representation in binary
	 * @param octalNumber number in base 8
	 * @return the number in binary representation
	 * @throws MyExceptions if the number is not in base 8
	 */
	public static String convertOctalNumberToBinary(String octalNumber) throws MyExceptions {
		String[] number = Utilities.splitNotDecimalNumber(octalNumber);
		if (number.length == 2) {
			return convertIntegerOctalPartToBinary(number[0]) + "." + convertIntegerOctalPartToBinary(number[1]);
		} else {
			return convertIntegerOctalPartToBinary(octalNumber);
		}
	}

	//--------------------------------------------------------------------------------------------------

	//--------------------------------------	2 -> 16 && 16 -> 2 -------------------------------------------------

	/**
	 * Converts the integer part of a binary number to hexadecimal base
	 * @param binaryValue the base 2 number to convert
	 * @return the hexadecimal representation of binaryValue
	 */
	private static String decimalBinaryPartToHexadecimal(String binaryValue) {
		while (binaryValue.length() % 4 != 0) {
			binaryValue = "0" + binaryValue;
		}
		String aux = "" + binaryValue.charAt(0);
		int auxHexa = 0;
		String result = "";
		for (int i = 0; i < binaryValue.length(); i++) {
			if (i % 4 == 3) {
				auxHexa = Integer.parseInt(convertAnyBaseToDecimal(aux, 2));
				if (auxHexa > 9) {
					result += convertDecimalToAnyBase(String.valueOf(auxHexa), 16);
				} else {
					result += auxHexa;
				}
				if (binaryValue.length() - 1 != i) {
					aux = ""+binaryValue.charAt(i + 1);
				}
			} else {
				aux += binaryValue.charAt(i + 1);
			}
		}
		return result.toUpperCase();
	}

	/**
	 * Converts the float part of a binary number to hexadecimal base
	 * @param binaryValue the value to convert
	 * @return the float part of the input number in 16 base
	 */
	private static String floatBinaryPartToHexadecimal(String binaryValue) {
		while (binaryValue.length() % 4 != 0) {
			binaryValue += "0";
		}
		String aux = "" + binaryValue.charAt(0);
		int auxHexa = 0;
		String result = "";
		for (int i = 0; i < binaryValue.length(); i++) {
			if (i % 4 == 3) {
				auxHexa = Integer.parseInt(convertAnyBaseToDecimal(aux, 2));
				if (auxHexa > 9) {
					result += convertDecimalToAnyBase(String.valueOf(auxHexa), 16);
				} else {
					result += auxHexa;
				}
				result += convertAnyBaseToDecimal(aux, 2);
				if (binaryValue.length() - 1 != i) {
					aux = ""+binaryValue.charAt(i + 1);
				}
			} else {
				aux += binaryValue.charAt(i + 1);
			}
		}
		return result.toUpperCase();
	}

	/**
	 * Converts binary base to hexadecimal base
	 * @param binaryValue a binary, base 2 number
	 * @return the representation of the original number in base 16
	 */
	public static String convertBinaryToHexadecimal(String binaryValue) {
		String[] number = Utilities.splitNotDecimalNumber(binaryValue);
		if (number.length == 2) {
			return decimalBinaryPartToHexadecimal(number[0]) + "."+ floatBinaryPartToHexadecimal(number[1]);
		} else {
			return decimalBinaryPartToHexadecimal(number[0]);
		}
	}

	/**
	 * Allow to convert the integer part of a hexadecimal number to binary
	 * @param numberInHexa original number to convert
	 * @return the integer part converted to binary 16 to 2
	 * @throws MyExceptions an exception if a input value number is not in base 16
	 */
	private static String convertIntegerHexadecimalPartToBinary(String numberInHexa) throws MyExceptions {
		String result = "";
		String aux = "";
		for (int i = 0; i < numberInHexa.length(); i++) {
			int aux2 = Character.getNumericValue(numberInHexa.charAt(i));
			if (aux2 > 15) {
				throw new MyExceptions("The number " + aux2 + " is not in base 16");
			}
			aux = convertDecimalToAnyBase(convertAnyBaseToDecimal(""+numberInHexa.charAt(i), 16), 2);
			while (aux.length() < 4) {
				aux = "0" + aux;
			}
			result += aux;
		}
		return result;
	}

	/**
	 * Converts any hexadecimal number to base 2 (binary)
	 * @param hexadecimalNumber the number to convert
	 * @return the binary representation of the original hexadecimal number
	 * @throws MyExceptions an error message if the hexadecimal input is not in base 16
	 */
	public static String convertHexadecimalNumberToBinary(String hexadecimalNumber) throws MyExceptions {
		String[] number = Utilities.splitNotDecimalNumber(hexadecimalNumber);
		if (number.length == 2) {
			return convertIntegerHexadecimalPartToBinary(number[0]) + "." + convertIntegerOctalPartToBinary(number[1]);
		} else {
			return convertIntegerHexadecimalPartToBinary(hexadecimalNumber);
		}
	}

	//-----------------------------------------------------	16 -> 8 (16 -> 10 -> 8) -----------------------------------
	//-----------------------------------------------------	8 -> 16 (8 -> 10 -> 16) -----------------------------------

	/**
	 * Converts hexadecimal base to octal base
	 * @param numberInHexadecimal the number in 16 base to convert
	 * @return the octal representation of the hexadecimal input number
	 */
	public static String convertHexadecimalToOctal(String numberInHexadecimal) {
		return convertDecimalToAnyBase(convertAnyBaseToDecimal(numberInHexadecimal, 16), 8);
	}

	/**
	 * Converts any octal number to hexadecimal
	 * @param numberInOctal the input number in base 8 to convert
	 * @return the hexadecimal representation of the original 8 base number
	 */
	public static String convertOctalToHexadecimal(String numberInOctal) {
		return convertDecimalToAnyBase(convertAnyBaseToDecimal(numberInOctal, 8), 16);
	}
}