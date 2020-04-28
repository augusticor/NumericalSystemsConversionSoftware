package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import constants.*;
import exceptions.MyExceptions;
import utilities.ActionsEvents;

/**
 * The main frame to communicate with the user of the software
 * Uses GridBagLayout
 * @author augusticor
 */
public class ConversionMainWindow extends JFrame {

	/**Minimum width of the window*/
	private static final int MINIMUM_WIDTH = 760;
	/**Minimum height of the window*/
	private static final int MINIMUM_HEIGHT = 650;
	/**An object of the software information dialog*/
	private JDAbout aboutDialog;
	/**A dialog object for instructions*/
	private InstructionsDialog instructionsDialog;
	/**A text field where the user types the number to convert*/
	private JTextField txtFNumber;

	public ConversionMainWindow(ActionListener actionListener) {
		setTitle(ConstantsGUI.MAIN_TITLE);
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.decode(ConstantsColors.WHITE));
		setIconImage(new ImageIcon(getClass().getResource(ConstantsImg.MAIN_ICON)).getImage()); 
		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		createGrid(c);
		
		c.gridy = 0; 
		c.weighty = 0.015; 
		c.gridx = 10; 
		c.gridwidth = 1;
		add(new OwnJButton(ConstantsImg.INSTRUCTIONS, ConstantsGUI.INSTRUCTIONS, ConstantsColors.WHITE, ActionsEvents.INSTRUCTIONS.toString(), actionListener), c);
		instructionsDialog = new InstructionsDialog();
		
		c.gridy = 0; 
		c.weighty = 0.015; 
		c.gridx = 11; 
		c.gridwidth = 1;
		aboutDialog = new JDAbout();
		add(new OwnJButton(ConstantsImg.ABOUT, ConstantsGUI.INFO_SISTEMAS, ConstantsColors.WHITE, ActionsEvents.ABOUT.toString(), actionListener), c);
		aboutDialog = new JDAbout();
		
		c.gridy = 0; 
		c.weighty = 0.015; 
		c.gridx = 2; 
		c.gridwidth = 4;
		txtFNumber = new JTextField();
		txtFNumber.setBorder(BorderFactory.createTitledBorder(ConstantsGUI.WRITE_NUMBER_TO_CONVERT));
		txtFNumber.setFont(new Font("Vivaldi", 1, 25));
		add(txtFNumber, c);
		
		c.gridy = 1; 
		c.weighty = 0.49; 
		c.gridx = 0; 
		c.gridwidth = 6;
		add(new OwnJButton(ConstantsImg.BINARY_TO_ANY_BASE, ConstantsGUI.BINARY_TO_ANY_BASE, ConstantsColors.WHITE, ActionsEvents.BINARY_TO_ANY.toString(), actionListener), c);

		c.gridy = 1; 
		c.weighty = 0.49; 
		c.gridx = 6; 
		c.gridwidth = 6;
		add(new OwnJButton(ConstantsImg.DECIMAL_TO_ANY_BASE, ConstantsGUI.DECIMAL_TO_ANY_BASE, ConstantsColors.WHITE, ActionsEvents.DECIMAL_TO_ANY.toString(), actionListener), c);

		c.gridy = 2; 
		c.weighty = 0.49; 
		c.gridx = 0; 
		c.gridwidth = 6;
		add(new OwnJButton(ConstantsImg.OCTAL_TO_ANY_BASE, ConstantsGUI.OCTAL_TO_ANY_BASE, ConstantsColors.WHITE, ActionsEvents.OCTAL_TO_ANY.toString(), actionListener), c);

		c.gridy = 2; 
		c.weighty = 0.49; 
		c.gridx = 6; 
		c.gridwidth = 6;
		add(new OwnJButton(ConstantsImg.HEXADECIMAL_TO_ANY_BASE, ConstantsGUI.HEXADECIMAL_TO_ANY_BASE, ConstantsColors.WHITE, ActionsEvents.HEXADECIMAL_TO_ANY.toString(), actionListener), c);

		setVisible(true);
	}

	/**
	 * Cleans the dialog when the user converts to a base, for a next input
	 */
	public void cleanDialog() {
		txtFNumber.setText(null);
	}
	
	/**
	 * Gets the written number by the user
	 * @return the number value to convert
	 * @throws MyExceptions if the user press the conversion button with this field empty
	 */
	public String numberValue() throws MyExceptions {
		if (!txtFNumber.getText().equals("")) {
			return txtFNumber.getText();
		} else {
			throw new MyExceptions("For make a conversion write a number first !!");
		}
	}
	
	/**
	 * Changes the visibility of the dialog for instructions
	 * @param visibility true or false
	 */
	public void changeDialogInstructionsVisibility(boolean visibility) {
		instructionsDialog.setVisible(true);
	}
	
	/**
	 * Changes the visibility of the software about dialog
	 * @param visibility true or false
	 */
	public void changeDialogAboutVisibility(boolean visibility) {
		aboutDialog.setVisible(visibility);
	}

	/**
	 * Displays a message in a JOptionPane object
	 * @param errorMessage to show to the user
	 */
	public void showErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage, "¡ ERROR !", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Creates the grid for the GridBagLayout
	 * @param c the layout columns
	 */
	public void createGrid(GridBagConstraints c) {
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridheight = 1;
		c.weighty = 0.01;

		for (int i = 0; i < 12; i++) {
			c.gridx = i;
			add(new JLabel(""), c);
		}
	}
}