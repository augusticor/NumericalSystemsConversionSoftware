package views;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import constants.*;

/**
 * The information of the software dialog
 * @author augusticor
 */
public class JDAbout extends JDialog {

	public JDAbout() {
		setModal(true);
		getContentPane().setBackground(Color.WHITE);
		setTitle(ConstantsGUI.INFO_SISTEMAS);
		setIconImage(createImageIcon(ConstantsImg.ICON_SISTEMAS).getImage());
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));
		setSize(420, 380);
		setLocationRelativeTo(null);
		setResizable(false);
		
		add(new OwnJLabel(ConstantsImg.ICON_SISTEMAS));
		add(new OwnJLabel(ConstantsGUI.MY_INFO, ConstantsColors.WHITE, ConstantsColors.BLACK));
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