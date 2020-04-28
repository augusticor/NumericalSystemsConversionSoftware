package views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import constants.*;

/**
 * The results of the base conversions, here the user will see the representations of the input number 
 * @author augusticor
 */
public class ResultsDialog extends JDialog {

	/**Labels of the dialog*/
	private OwnJLabel lblOriginalNumber, lblBase1Img, lblBase1Value, lblBase2Img, lblBase2Value, lblBase3Img, lblBase3Value;	
	
	public ResultsDialog(ActionListener listener) {
		setIconImage(createImageIcon(ConstantsImg.MAIN_ICON).getImage());
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.decode(ConstantsColors.WHITE));
		setSize(400, 600);
		setLayout(new GridBagLayout());
		setResizable(false);
		
		GridBagConstraints c = new GridBagConstraints();
		createGrid(c);
		
		c.gridy = 0; 
		c.weighty = 0.2; 
		c.gridx = 4; 
		c.gridwidth = 6;		
		lblOriginalNumber = new OwnJLabel(null, ConstantsColors.WHITE, ConstantsColors.BLACK);
		add(lblOriginalNumber, c);
		
		c.gridy = 1; 
		c.weighty = 0.2; 
		c.gridx = 0; 
		c.gridwidth = 5;
		lblBase1Img = new OwnJLabel(ConstantsImg.BINARY);
		add(lblBase1Img, c);

		c.gridy = 1; 
		c.weighty = 0.2; 
		c.gridx = 7; 
		c.gridwidth = 2;
		lblBase1Value = new OwnJLabel(null, ConstantsColors.WHITE, ConstantsColors.BLACK);
		add(lblBase1Value, c);
		
		c.gridy = 2; 
		c.weighty = 0.2; 
		c.gridx = 0; 
		c.gridwidth = 5;
		lblBase2Img = new OwnJLabel(ConstantsImg.OCTAL);
		add(lblBase2Img, c);
		
		c.gridy = 2; 
		c.weighty = 0.2; 
		c.gridx = 7; 
		c.gridwidth = 2;
		lblBase2Value = new OwnJLabel(null, ConstantsColors.WHITE, ConstantsColors.BLACK);
		add(lblBase2Value, c);

		c.gridy = 3; 
		c.weighty = 0.2; 
		c.gridx = 0; 
		c.gridwidth = 5;
		lblBase3Img = new OwnJLabel(ConstantsImg.HEXADECIMAL);
		add(lblBase3Img, c);

		c.gridy = 3; 
		c.weighty = 0.2; 
		c.gridx = 7; 
		c.gridwidth = 2;
		lblBase3Value = new OwnJLabel(null, ConstantsColors.WHITE, ConstantsColors.BLACK);
		add(lblBase3Value, c);
	}
	
	/**
	 * Charges the interface for conversion from binary base to the others ones
	 * @param valueInBinary the value to convert
	 * @param decimalConversion the decimal representation of the binary value
	 * @param octalConversion the octal representation of the binary value
	 * @param hexaConversion the hexadecimal representation of the binary value
	 */
	public void binaryToAnyOne(String valueInBinary, String decimalConversion, String octalConversion, String hexaConversion) {
		lblOriginalNumber.setText(valueInBinary);
		
		lblBase1Img.setIcon(createImageIcon(ConstantsImg.DECIMAL));
		lblBase1Value.setText(decimalConversion);

		lblBase2Img.setIcon(createImageIcon(ConstantsImg.OCTAL));
		lblBase2Value.setText(octalConversion);
		
		lblBase3Img.setIcon(createImageIcon(ConstantsImg.HEXADECIMAL));
		lblBase3Value.setText(hexaConversion);
	}
	
	/**
	 * Charges the interface for conversion from decimal base to the others ones
	 * @param valueInDecimal the value to convert
	 * @param binaryConversion the binary representation of the decimal value
	 * @param octalConversion the octal representation of the decimal value
	 * @param hexaConversion the hexadecimal representation of the decimal value
	 */
	public void decimalToAnyOne(String valueInDecimal, String binaryConversion, String octalConversion, String hexaConversion) {
		lblOriginalNumber.setText(valueInDecimal);
		
		lblBase1Img.setIcon(createImageIcon(ConstantsImg.BINARY));
		lblBase1Value.setText(binaryConversion);

		lblBase2Img.setIcon(createImageIcon(ConstantsImg.OCTAL));
		lblBase2Value.setText(octalConversion);
		
		lblBase3Img.setIcon(createImageIcon(ConstantsImg.HEXADECIMAL));
		lblBase3Value.setText(hexaConversion);
	}
	
	/**
	 * Charges the interface for conversion from octal base to the others ones
	 * @param valueInOctal the value to convert
	 * @param decimalConversion the decimal representation of the octal value
	 * @param binaryConversion the binary representation of the octal value
	 * @param hexaConversion the hexadecimal representation of the octal value
	 */
	public void octalToAnyOne(String valueInOctal, String decimalConversion, String binaryConversion, String hexaConversion) {
		lblOriginalNumber.setText(valueInOctal);
		
		lblBase1Img.setIcon(createImageIcon(ConstantsImg.DECIMAL));
		lblBase1Value.setText(decimalConversion);

		lblBase2Img.setIcon(createImageIcon(ConstantsImg.BINARY));
		lblBase2Value.setText(binaryConversion);
		
		lblBase3Img.setIcon(createImageIcon(ConstantsImg.HEXADECIMAL));
		lblBase3Value.setText(hexaConversion);
	}
	
	/**
	 * Charges the interface for conversion from hexadecimal base to the others ones
	 * @param valueInHexa the hexadecimal value to convert
	 * @param decimalConversion the decimal representation of the hexadecimal value
	 * @param octalConversion the octal representation of the hexadecimal value
	 * @param binaryConversion the binary representation of the hexadecimal value
	 */
	public void hexadecimalToAnyOne(String valueInHexa, String decimalConversion, String octalConversion, String binaryConversion) {
		lblOriginalNumber.setText(valueInHexa);
		
		lblBase1Img.setIcon(createImageIcon(ConstantsImg.DECIMAL));
		lblBase1Value.setText(decimalConversion);

		lblBase2Img.setIcon(createImageIcon(ConstantsImg.OCTAL));
		lblBase2Value.setText(octalConversion);
		
		lblBase3Img.setIcon(createImageIcon(ConstantsImg.BINARY));
		lblBase3Value.setText(binaryConversion);
	}
	
	/**
	 * Creates an ImageIcon object
	 * @param path of the file in the source files
	 * @return the created ImageIcon object
	 */
	private ImageIcon createImageIcon(String path) {
		return new ImageIcon(getClass().getResource(path));
	}
	
	/**
	 * Creates the grid for the GridBagLayout
	 * @param c the layout columns
	 */
	private void createGrid(GridBagConstraints c) {
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