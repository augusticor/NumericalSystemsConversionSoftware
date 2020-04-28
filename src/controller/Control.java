package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import constants.ConstantsGUI;
import exceptions.MyExceptions;
import models.ConversionManager;
import utilities.ActionsEvents;
import views.*;

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
public class Control implements ActionListener {

	/**The main interface for user interaction object*/
	private ConversionMainWindow mainW;
	/**The dialog for the conversions results*/
	private ResultsDialog resultsDialog;

	public Control() {
		mainW = new ConversionMainWindow(this);
		resultsDialog = new ResultsDialog(this);
	}

	/**
	 * Controls all the events from user interface and operations
	 */
	public void actionPerformed(ActionEvent actionE) {
		switch (ActionsEvents.valueOf(actionE.getActionCommand())) {
		case BINARY_TO_ANY:
			binaryToAnyBase();
			break;
		case DECIMAL_TO_ANY:
			decimalToAnyBase();
			break;
		case OCTAL_TO_ANY:
			octalToAnyBase();
			break;
		case HEXADECIMAL_TO_ANY:
			hexadecimalToAnyBase();
			break;
		case INSTRUCTIONS:
			mainW.changeDialogInstructionsVisibility(true);
			break;
		case ABOUT:
			mainW.changeDialogAboutVisibility(true);
			break;
		}
	}

	/**
	 * Switches from binary base to all others (8, 10, 16) and displays the results
	 */
	private void binaryToAnyBase() {
		String valueInBinary = null;
		try {
			valueInBinary = mainW.numberValue();
			resultsDialog.binaryToAnyOne(valueInBinary,
					ConversionManager.convertAnyBaseToDecimal(valueInBinary, 2),
					ConversionManager.convertBinaryToOctal(valueInBinary),
					ConversionManager.convertBinaryToHexadecimal(valueInBinary));
			resultsDialog.setVisible(true);
			mainW.cleanDialog();
		} catch (MyExceptions e) {
			mainW.showErrorMessage(e.getMessage());
		} catch (NumberFormatException numberFormatE) {
			mainW.showErrorMessage(ConstantsGUI.numberFormatE(valueInBinary, 2));
		}
	}

	/**
	 * Switches from decimal base to all others (2, 8, 16) and displays the results
	 */
	private void decimalToAnyBase() {
		String valueInDecimal = null;
		try {
		valueInDecimal = mainW.numberValue();
		resultsDialog.decimalToAnyOne(valueInDecimal,
				ConversionManager.convertDecimalToAnyBase(valueInDecimal, 2), 
				ConversionManager.convertDecimalToAnyBase(valueInDecimal, 8), 
				ConversionManager.convertDecimalToAnyBase(valueInDecimal, 16));
		resultsDialog.setVisible(true);
		mainW.cleanDialog();
		} catch (MyExceptions e) {
			mainW.showErrorMessage(e.getMessage());
		} catch (NumberFormatException numberFormatE) {
			mainW.showErrorMessage(ConstantsGUI.numberFormatE(valueInDecimal, 10));
		}
	}

	/**
	 * Switches from octal base to all others (2, 10, 16) and displays the results
	 */
	private void octalToAnyBase() {
		String valueInOctal = null;
		try {
			valueInOctal = mainW.numberValue();
			resultsDialog.octalToAnyOne(valueInOctal, 
					ConversionManager.convertAnyBaseToDecimal(valueInOctal, 8), 
					ConversionManager.convertOctalNumberToBinary(valueInOctal), 
					ConversionManager.convertOctalToHexadecimal(valueInOctal));
			resultsDialog.setVisible(true);
			mainW.cleanDialog();
		} catch (MyExceptions e) {
			mainW.showErrorMessage(e.getMessage());
		} catch (NumberFormatException numberFormatE) {
			mainW.showErrorMessage(ConstantsGUI.numberFormatE(valueInOctal, 8));
		}
	}

	/**
	 * Switches from hexadecimal base to all others (2, 8, 10) and displays the results
	 */
	private void hexadecimalToAnyBase() {
		String valueInHexadecimal = null;
		try {
			valueInHexadecimal  = mainW.numberValue();
			resultsDialog.hexadecimalToAnyOne(valueInHexadecimal,
					ConversionManager.convertAnyBaseToDecimal(valueInHexadecimal, 16), 
					ConversionManager.convertHexadecimalToOctal(valueInHexadecimal), 
					ConversionManager.convertHexadecimalNumberToBinary(valueInHexadecimal));
			resultsDialog.setVisible(true);
			mainW.cleanDialog();
		} catch (MyExceptions e) {
			mainW.showErrorMessage(e.getMessage());
		} catch (NumberFormatException numberFormatE) {
			mainW.showErrorMessage(ConstantsGUI.numberFormatE(valueInHexadecimal, 16));
		}
	}
}