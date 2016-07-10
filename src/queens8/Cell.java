package queens8;

public class Cell {
	private CellState state;
	
	public Cell() {
		state = CellState.EMPTY;
	}
	
	public Cell(Cell anOther) {
		state = anOther.getState();
	}
	
	public String toString() {
		String result = "";
		if (getState() == CellState.QUEEN) {
			result += "@";
		} else if (getState() == CellState.EMPTY) {
			result += " ";
		} else {
			result += "X";
		}
		
		return result;
	}

	public CellState getState() {
		return state;
	}

	public void setState(CellState state) {
		this.state = state;
	}
}
