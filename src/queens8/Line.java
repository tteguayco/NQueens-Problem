package queens8;

public class Line {
	private double m;
	private double n;
	
	/**
	 * Construye una recta a partir de dos puntos del plano
	 */
	public Line(int x1, int y1, int x2, int y2) {
		if ((x2 - x1) != 0) {
			m = (double) (y2 - y1) / (double) (x2 - x1);
		} else {
			m = 0;
		}
		
		n = m * (-1) * x1 + y1;
	}
	
	/**
	 * True si el punto pertenece a la recta
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean contains(int x, int y) {
		if (y == y(x)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Evalúa el punto x en la recta, devolviendo
	 * el punto en y correspondiente a dicho valor
	 * @param x
	 * @return
	 */
	public double y(int x) {
		return (getM() * x + getN());
	} 

	public String toString() {
		String result = "";
		result += "y = " + getM() + "x + " + getN();
		return result;
	}
	
	public double getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public double getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}
