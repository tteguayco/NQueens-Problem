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
	private ControlPanel controlPanel;
	private InfoPanel infoPanel;
	private WarningSolutionsFrame warningSolFrame;
	private Clock clock;
	private AlgebraicNotationCalculator algNotCalculator;
	
	public QueensFrame() {
		solGenerator = new SolutionsGenerator(DEFAULT_NQUEENS);
		boardPanel = new BoardPanel();
		indexSolution = 0;
		controlPanel = new ControlPanel();
		infoPanel = new InfoPanel();
		warningSolFrame = new WarningSolutionsFrame();
		clock = new Clock();
		algNotCalculator = new AlgebraicNotationCalculator();
		
		setLayout(new BorderLayout());
		add(boardPanel, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.NORTH);
		add(infoPanel, BorderLayout.SOUTH);
		
		updateSolution();
		
		controlPanel.getNextButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nextSolution();
			}
			
		});
		
		controlPanel.getPrevButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				prevSolution();
			}
		});
		
		controlPanel.getnQueensComboBox().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int nQueens = Integer.parseInt(controlPanel.getnQueensComboBox().getSelectedItem().toString());
				solGenerator = new SolutionsGenerator(nQueens);
				updateSolution();
				resetIndexSolution();
				repaint();
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
			getAlgNotCalculator().setBoard(getBoardPanel().getBoard());
			getInfoPanel().addQueenPositions(getAlgNotCalculator().getQueensPositionsInAlgebraicNotation());
			repaint();
		} else {
			getWarningSolFrame().setVisible(true);
		}
	}
	
	/**
	 * Se le pasa al tablero la solución anterior para 
	 * pintarla, si la hay
	 */
	public void prevSolution() {
		if (getIndexSolution() > 0) {
			setIndexSolution(getIndexSolution() - 1);
			getBoardPanel().setBoard(getSolutions().get(getIndexSolution()));
			getAlgNotCalculator().setBoard(getBoardPanel().getBoard());
			getInfoPanel().addQueenPositions(getAlgNotCalculator().getQueensPositionsInAlgebraicNotation());
			repaint();
		} 
	}
	
	/**
	 * Actualiza la información de la interfaz para mostrar la siguiente
	 * solución
	 */
	private void updateSolution() {
		getClock().start();
		getSolGenerator().solve();
		getClock().stop();
		setSolutions(getSolGenerator().getSolutions());
		if (getSolutions().size() > 0) {
			getBoardPanel().setBoard(getSolutions().get(0));
			getAlgNotCalculator().setBoard(getBoardPanel().getBoard());
			
			getInfoPanel().addTime(getClock().getElapsedTime() + " ms");
			getInfoPanel().addQueenPositions(getAlgNotCalculator().getQueensPositionsInAlgebraicNotation());
		} else {
			getWarningSolFrame().setVisible(true);
		}
	}
	
	public void resetIndexSolution() {
		setIndexSolution(0);
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

	public WarningSolutionsFrame getWarningSolFrame() {
		return warningSolFrame;
	}

	public void setWarningSolFrame(WarningSolutionsFrame warningSolFrame) {
		this.warningSolFrame = warningSolFrame;
	}

	public ControlPanel getControlPanel() {
		return controlPanel;
	}

	public void setControlPanel(ControlPanel controlPanel) {
		this.controlPanel = controlPanel;
	}

	public InfoPanel getInfoPanel() {
		return infoPanel;
	}

	public void setInfoPanel(InfoPanel infoPanel) {
		this.infoPanel = infoPanel;
	}

	public Clock getClock() {
		return clock;
	}

	public void setClock(Clock clock) {
		this.clock = clock;
	}

	public AlgebraicNotationCalculator getAlgNotCalculator() {
		return algNotCalculator;
	}

	public void setAlgNotCalculator(AlgebraicNotationCalculator aglNotCalculator) {
		this.algNotCalculator = aglNotCalculator;
	}
}
