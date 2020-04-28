package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import constants.*;

/**
 * A dialog containing the instructions of the software
 * @author augusticor
 */
public class InstructionsDialog extends JDialog {

	public InstructionsDialog() {
		setIconImage(createImageIcon(ConstantsImg.MAIN_ICON).getImage());
		setModal(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 2));
		setSize(992, 426);
		setResizable(false);
	
		JTextArea txtA = new JTextArea(ConstantsGUI.INSTRUCTIONS_INFO);
		txtA.setEditable(false);
		txtA.setLineWrap(true);
		txtA.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
		txtA.setFont(new Font("Consolas", 0, 16));
		add(txtA);
		
		add(new OwnJLabel(ConstantsImg.INSTRUCTIONS1));
	}
	
	/**
	 * Creates an ImageIcon object
	 * @param path of the file in the source files
	 * @return the created ImageIcon object
	 */
	private ImageIcon createImageIcon(String path) {
		return new ImageIcon(getClass().getResource(path));
	}
}