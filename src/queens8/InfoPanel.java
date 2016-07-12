package queens8;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {
	private static final String TIME_LABEL_MESSAGE = "  Time spent: ";
	private static final String QUEENS_LABEL_MESSAGE = "  Queens positioning: ";
	
	private JLabel timeLabel;
	private JLabel queenPositionsLabel;

	public InfoPanel() {
		timeLabel = new JLabel(TIME_LABEL_MESSAGE);
		queenPositionsLabel = new JLabel(QUEENS_LABEL_MESSAGE);
		
		setLayout(new GridLayout(2, 1));
		add(timeLabel);
		add(queenPositionsLabel);
	}
	
	public void addTime(String time) {
		getTimeLabel().setText(TIME_LABEL_MESSAGE + time);
	}
	
	public void addQueenPositions(String positions) {
		getQueenPositionsLabel().setText(QUEENS_LABEL_MESSAGE + positions);
	}

	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public void setTimeLabel(JLabel timeLabel) {
		this.timeLabel = timeLabel;
	}

	public JLabel getQueenPositionsLabel() {
		return queenPositionsLabel;
	}

	public void setQueenPositionsLabel(JLabel queenPositionsLabel) {
		this.queenPositionsLabel = queenPositionsLabel;
	}
}
