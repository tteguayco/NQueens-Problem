package queens8;

/**
 * Marcador de celdas no válidas
 * Dispone de una referencia al tablero 
 */
public class DisabledCellsMarker {
	private Cell[][] cells;
	
	public DisabledCellsMarker(Cell[][] cells) {
		// Se guarda la referencia, no se crea un objeto nuevo
		this.cells = cells;
	}
	
	public DisabledCellsMarker(DisabledCellsMarker anOther) {
		System.out.println(anOther.getCells());
		this.cells = new Cell[anOther.getCells().length][anOther.getCells().length];
		for (int i = 0; i < anOther.getCells().length; i++) {
			for (int j = 0; j < anOther.getCells().length; j++) {
				this.cells[i][j] = new Cell(anOther.getCells()[i][j]);
			}
		}
	}
	
	/**
	 * Deshabilita las filas, columnas, diagonales y rectas
	 * para la reina insertada en la posición (i,j) del tablero
	 * @param i
	 * @param j
	 */
	public void disableCells(int row, int column) {
		disableRow(row, column);
		disableColumn(row, column);
		disableDiagonals(row, column);
		disableLines(row, column);
	}
	
	/**
	 * Deshabilita la fila en la que se ha insertado
	 * la nueva reina
	 */
	private void disableRow(int row, int column) {
		for (int k = 0; k < getCells().length; k++) {
			if (getCells()[row][k].getState() == CellState.EMPTY) {
				getCells()[row][k].setState(CellState.DISABLED);
			}
		}
	}
	
	/**
	 * Deshabilita la columna en la que se ha insertado
	 * la nueva reina
	 */
	private void disableColumn(int row, int column) {
		for (int k = 0; k < getCells().length; k++) {
			if (getCells()[k][column].getState() == CellState.EMPTY) {
				getCells()[k][column].setState(CellState.DISABLED);
			}
		}
	}
	
	/**
	 * Deshabilita las dos diagonales de la reina
	 */
	private void disableDiagonals(int row, int column) {
		// Hacia arriba a la izquierda
		int i = row, j = column;
		while (i > 0 && j > 0) {
			i -= 1;
			j -= 1;
			if (getCells()[i][j].getState() == CellState.EMPTY) {
				getCells()[i][j].setState(CellState.DISABLED);
			}
		}
		
		// Hacia arriba a la derecha
		i = row; 
		j = column;
		while (i > 0 && j < getCells().length - 1) {
			i -= 1;
			j += 1;
			if (getCells()[i][j].getState() == CellState.EMPTY) {
				getCells()[i][j].setState(CellState.DISABLED);
			}
		}
		
		// Hacia abajo a la izquierda
		i = row; 
		j = column;
		while (i < getCells().length - 1 && j > 0) {
			i += 1;
			j -= 1;
			if (getCells()[i][j].getState() == CellState.EMPTY) {
				getCells()[i][j].setState(CellState.DISABLED);
			}
		}
		
		// Hacia abajo a la derecha
		i = row; 
		j = column;
		while (i < getCells().length - 1 && j < getCells().length - 1) {
			i += 1;
			j += 1;
			if (getCells()[i][j].getState() == CellState.EMPTY) {
				getCells()[i][j].setState(CellState.DISABLED);
			}
		}
	}
	
	/**
	 * Deshabilita todas las celdas que pertenezcan a la recta 
	 * que forman la nueva reina y cualquier otra reina ya
	 * colocada sobre el tablero
	 */
	private void disableLines(int row, int column) {
		for (int i = 0; i < getCells().length; i++) {
			for (int j = 0; j < getCells().length; j++) {
				if (getCells()[i][j].getState() == CellState.QUEEN && i != row && j != column) {
					// Se debe hacer una transformación de coordenadas matriciales a coordenadas del plano
					Line line = new Line(column, getCells().length - (row + 1), j, getCells().length - (i + 1));
					// Recorremos de nuevo el tablero para ver qué celdas pertenecen a esta recta que 
					// acabamos de crear
					for (int k = 0; k < getCells().length; k++) {
						for (int r = 0; r < getCells().length; r++) {
							if (line.contains(r, getCells().length - (k + 1)) && getCells()[k][r].getState() != CellState.QUEEN) {
								getCells()[k][r].setState(CellState.DISABLED);
							}
						}
					}
				}
			}
		}
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
}
