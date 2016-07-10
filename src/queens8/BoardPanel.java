package queens8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {
	private static final int DEFAULT_NQUEENS = 8;
	private static final Color PLAYER1_COLOR = Color.WHITE;
	private static final Color PLAYER2_COLOR = Color.BLACK;
	private static final String QUEEN_IMG_PATH = "./img/queen.png";
	
	private Board board;
	
	public BoardPanel() {
		board = new Board(DEFAULT_NQUEENS);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int colSpaces = getWidth() / getBoard().getDimension();
		int rowSpaces = getHeight() / getBoard().getDimension();
		
		try {
		    File pathToFile = new File(QUEEN_IMG_PATH);
		    Image queenImg = ImageIO.read(pathToFile);
		
			for (int i = 0; i < getBoard().getDimension(); i++) {
				for (int j = 0; j < getBoard().getDimension(); j++) {
					if ((i % 2 == 0) && (j % 2 == 0)) {
						g.setColor(PLAYER1_COLOR);
					} else if ((i % 2 != 0) && (j % 2 == 0)) {
						g.setColor(PLAYER2_COLOR);
					} else if ((i % 2 == 0) && (j % 2 != 0)) {
						g.setColor(PLAYER2_COLOR);
					} else {
						g.setColor(PLAYER1_COLOR);
					}
					
					g.fillRect(j * colSpaces, i * rowSpaces, (j+1) * colSpaces, (i+1) * rowSpaces);
					
					if (getBoard().getCells()[i][j].getState() == CellState.QUEEN) {
						g.drawImage(queenImg, j * colSpaces, i * rowSpaces, colSpaces, rowSpaces, this);
					}
				}
			}
		
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
}
