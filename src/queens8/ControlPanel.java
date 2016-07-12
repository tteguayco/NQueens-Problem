package queens8;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	private static final String[] N_QUEENS_OPTIONS = {"4", "5", "6", "7", "8", "9", "10"};
	private static final int COMBOBOX_SELECTED_iNDEX = 4;
	
	private JButton nextButton;
	private JButton prevButton;
	private JComboBox nQueensComboBox;
	private JLabel nQueensLabel;
	
	public ControlPanel() {
		nextButton = new JButton("NEXT");
		prevButton = new JButton("PREVIOUS");
		nQueensComboBox = new JComboBox(N_QUEENS_OPTIONS);
		nQueensLabel = new JLabel("   Select the number of queens:");
		
		nQueensComboBox.setSelectedIndex(COMBOBOX_SELECTED_iNDEX);
		
		setLayout(new FlowLayout());
		add(nextButton);
		add(prevButton);
		add(nQueensLabel);
		add(nQueensComboBox);
	}

	public JButton getNextButton() {
		return nextButton;
	}

	public void setNextButton(JButton nextButton) {
		this.nextButton = nextButton;
	}

	public JButton getPrevButton() {
		return prevButton;
	}

	public void setPrevButton(JButton prevButton) {
		this.prevButton = prevButton;
	}

	public JComboBox getnQueensComboBox() {
		return nQueensComboBox;
	}

	public void setnQueensComboBox(JComboBox nQueensComboBox) {
		this.nQueensComboBox = nQueensComboBox;
	}
}
