package queens8;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class QueensFrame extends JFrame {
	private static final int DEFAULT_NQUEENS = 8;
	
	private SolutionsGenerator solGenerator;
	private ArrayList<Board> solutions;
	private BoardPanel boardPanel;
	private int indexSolution;
	private JButton nextSolButton;
	private WarningSolutionsFrame warningSolFrame;
	
	public QueensFrame() {
		solGenerator = new SolutionsGenerator(DEFAULT_NQUEENS);
		boardPanel = new BoardPanel();
		indexSolution = 0;
		nextSolButton = new JButton("NEXT");
		warningSolFrame = new WarningSolutionsFrame();
		
		setLayout(new BorderLayout());
		add(boardPanel, BorderLayout.CENTER);
		add(nextSolButton, BorderLayout.SOUTH);
		solGenerator.solve();
		solutions = solGenerator.getSolutions();
		boardPanel.setBoard(solutions.get(0));
		
		nextSolButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nextSolution();
			}
		});
	}
	
	/**
	 * Le pasa el tablero de la siguiente solución al panel
	 * del tablero para pintarla. Si no hay más soluciones 
	 * que mostrar, se muestra un aviso en una nueva ventana
	 */
	public void nextSolution() {
		if (getIndexSolution() < getSolutions().size() - 1) {
			setIndexSolution(getIndexSolution() + 1);
			getBoardPanel().setBoard(getSolutions().get(getIndexSolution()));
			repaint();
		} else {
			getWarningSolFrame().setVisible(true);
		}
	}

	public SolutionsGenerator getSolGenerator() {
		return solGenerator;
	}

	public void setSolGenerator(SolutionsGenerator solGenerator) {
		this.solGenerator = solGenerator;
	}

	public ArrayList<Board> getSolutions() {
		return solutions;
	}

	public void setSolutions(ArrayList<Board> solutions) {
		this.solutions = solutions;
	}

	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

	public void setBoardPanel(BoardPanel boardPanel) {
		this.boardPanel = boardPanel;
	}

	public int getIndexSolution() {
		return indexSolution;
	}

	public void setIndexSolution(int indexSolution) {
		this.indexSolution = indexSolution;
	}

	public JButton getNextSolButton() {
		return nextSolButton;
	}

	public void setNextSolButton(JButton nextSolButton) {
		this.nextSolButton = nextSolButton;
	}

	public WarningSolutionsFrame getWarningSolFrame() {
		return warningSolFrame;
	}

	public void setWarningSolFrame(WarningSolutionsFrame warningSolFrame) {
		this.warningSolFrame = warningSolFrame;
	}
}
