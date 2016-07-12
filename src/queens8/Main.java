package queens8;

import javax.swing.JFrame;

public class Main {
	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 540;
	
	public static void main(String[] args) {
		QueensFrame frame = new QueensFrame();
		
		frame.setTitle("N-Queens Puzzle");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
