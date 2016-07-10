package queens8;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class WarningSolutionsFrame extends JFrame {
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 70;
	private static final String INFO_IMG_PATH = "./img/info.png";
	private static final int PADDING = 10;
	
	public WarningSolutionsFrame() {
		ImageIcon infoIcon = new ImageIcon(INFO_IMG_PATH);
		JLabel message = new JLabel("  There is no more solutions to show!");
		JPanel contentPanel = new JPanel();
		Border padding = BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING);

		contentPanel.setBorder(padding);
		message.setIcon(infoIcon);
		contentPanel.add(message);
		add(contentPanel);
		setTitle("Warning");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
