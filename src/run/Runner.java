package run;

import controller.Control;

/**
 * This is a software for numerical base conversion, the numerical systems available are:
 * Base 2 (binary)
 * Base 8 (octal)
 * Base 10 (decimal)
 * Base 16 (hexadecimal)
 * It can transform between all these numerical bases  
 * @author augusticor
 * @version 1.0
 * @category numerical software
 * Architecture: M.V.C.
 * Used I.D.E: Eclipse
 * This class connects the interface and the logic
 */
public class Runner {
	public static void main(String[] args) {

		new Control();
	}
}