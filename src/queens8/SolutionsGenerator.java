package queens8;

import java.util.ArrayList;

/**
 * Generador de soluciones para el problema de
 * las ocho reinas con la restricción adicional
 */
public class SolutionsGenerator {
	private Board board;
	private int queensGoal;
	private ArrayList<Board> solutions;
	
	public SolutionsGenerator(int nQueens) {
		board = new Board(nQueens);
		queensGoal = nQueens;
		solutions = new ArrayList<Board>();
	}
	
	/**
	 * Aplicar la búsqueda de soluciones
	 */
	public void solve() {
		solveR(getBoard(), 0);
	}
	
	/**
	 * Búsqueda recursiva
	 * @param newBoard
	 * @param nQueens
	 */
	public void solveR(Board board, int row) {
		//System.out.println(board);
		// Caso base: llegamos a ocho reinas, guardamos la solución
		if (board.getNumOfQueens() == getQueensGoal()) {
			if (board.getNumOfQueens() == getQueensGoal()) {
				//System.out.println("caso base");
				getSolutions().add(board);
			}
			
		} else {
			for (int i = 0; i < board.getDimension(); i++) {
				Board newBoard = new Board(board);
				if (newBoard.getCells()[row][i].getState() == CellState.EMPTY) {
					newBoard.setQueenAtCell(row, i);
					solveR(newBoard, row + 1);
				}
			}
 		}
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public ArrayList<Board> getSolutions() {
		return solutions;
	}

	public void setSolutions(ArrayList<Board> solutions) {
		this.solutions = solutions;
	}

	public int getQueensGoal() {
		return queensGoal;
	}

	public void setQueensGoal(int queensGoal) {
		this.queensGoal = queensGoal;
	}
}
