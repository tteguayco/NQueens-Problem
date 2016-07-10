package queens8;

public class Board {
	private Cell[][] cells;
	private int dimension;
	private DisabledCellsMarker disabledCellsMarker;
	private int numOfQueens;
	
	public Board(int nQueens) {
		cells = new Cell[nQueens][nQueens];
		dimension = nQueens;
		numOfQueens = 0;
		
		for (int i = 0; i < nQueens; i++) {
			for (int j = 0; j < nQueens; j++) {
				cells[i][j] = new Cell();
			}
		}
		
		disabledCellsMarker = new DisabledCellsMarker(cells);
	}
	
	public Board(Board anOther) {
		cells = new Cell[anOther.getDimension()][anOther.getDimension()];
		dimension = anOther.getDimension();
		numOfQueens = anOther.getNumOfQueens();
		
		for (int i = 0; i < getDimension(); i++) {
			for (int j = 0; j < getDimension(); j++) {
				cells[i][j] = new Cell(anOther.getCells()[i][j]);
			}
		}
		
		disabledCellsMarker = new DisabledCellsMarker(cells);
	}
	
	public String toString() {
		String result = "";
		for (int i = 0; i < getDimension(); i++) {
			for (int j = 0; j < getDimension(); j++) {
				result += getCells()[i][j] + " | ";
			}
			result += "\n";
		}
		return result;
	}
	
	/**
	 * Coloca una reina en la casilla especificada
	 * y deshabilita todas aquellas celdas que hagan
	 * cumplir las restricciones del juego
	 * 
	 * Devuelve true si se insertó la reina correctamente
	 * en la posición especificada
	 * @param i
	 * @param j
	 */
	public boolean setQueenAtCell(int i, int j) {
		if (getCells()[i][j].getState() == CellState.DISABLED || getCells()[i][j].getState() == CellState.QUEEN) {
			return false;
			
		} else {
			getCells()[i][j].setState(CellState.QUEEN);
			getDisabledCellsMarker().disableCells(i, j);
			setNumOfQueens(getNumOfQueens() + 1);
			return true;
		}
	}
	
	/**
	 * Devuelve true si el tablero está completo: no hay más
	 * celdas disponibles para colocar más reinas
	 * @return
	 */
	public boolean isFull() {
		for (int i = 0; i < getDimension(); i++) {
			for (int j = 0; j < getDimension(); j++) {
				if (getCells()[i][j].getState() == CellState.EMPTY) {
					return false;
				}
			}
		}
		
		return true;
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}

	public DisabledCellsMarker getDisabledCellsMarker() {
		return disabledCellsMarker;
	}

	public void setDisabledCellsMarker(DisabledCellsMarker disabledCellsMarker) {
		this.disabledCellsMarker = disabledCellsMarker;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public int getNumOfQueens() {
		return numOfQueens;
	}

	public void setNumOfQueens(int numOfQueens) {
		this.numOfQueens = numOfQueens;
	}
}
