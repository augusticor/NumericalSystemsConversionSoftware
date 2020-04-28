package views;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * A class for create multiple label objects with similar characteristics
 * @author augusticor
 */
public class OwnJLabel extends JLabel {

	public OwnJLabel(String text, String background, String foreground) {
		setText(text);
		setFont(new Font("Verdana", 0, 15));
		setBackground(Color.decode(background));
		setForeground(Color.decode(foreground));
	}

	//Jlabel Img
	public OwnJLabel(String imgUrl) {
		setHorizontalAlignment(JLabel.CENTER);
		setIcon(createImageIcon(imgUrl));
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