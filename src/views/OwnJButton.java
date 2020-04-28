package views;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * A class for create multiple buttons objects with similar characteristics
 * @author augusticor
 */
public class OwnJButton extends JButton {

	private static final long serialVersionUID = 1L;
	
	public OwnJButton(String img, String toolTipText, String backGround, String actionCommand, ActionListener actionListener) {
		setIcon(createImageIcon(img));
		setToolTipText(toolTipText);
		setBackground(Color.decode(backGround));
		setBorderPainted(false);
		setActionCommand(actionCommand);
		addActionListener(actionListener);
	}
	
	public OwnJButton(String text, String backGround, String actionCommand, ActionListener actionListener) {
		setText(text);
		setForeground(Color.BLACK);
		setBackground(Color.decode(backGround));
		setActionCommand(actionCommand);
		addActionListener(actionListener);
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