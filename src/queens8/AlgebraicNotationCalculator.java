package queens8;

public class AlgebraicNotationCalculator {
	private static final String[] LETTERS = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
	
	private Board board;
	
	public AlgebraicNotationCalculator() {

	}
	
	public AlgebraicNotationCalculator(Board board) {
		this.board = board;
	}

	private String getAlgNotForCell(int i, int j) {
		String result = "";
		result += LETTERS[j];
		result += getBoard().getDimension() - i;
		return result;
	}
	
	public String getQueensPositionsInAlgebraicNotation() {
		String result = "";
		int nQueens = 0;
		
		for (int i = 0; i < getBoard().getDimension(); i++) {
			for (int j = 0; j < getBoard().getDimension(); j++) {
				if (getBoard().getCells()[j][i].getState() == CellState.QUEEN) {
					result += getAlgNotForCell(j, i);
					nQueens++;
					if (nQueens < getBoard().getDimension()) {
						result += ", ";
					}
				}
			}
		}
		
		return result;
	}
	
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
}
