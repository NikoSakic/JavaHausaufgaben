/**
 * 
 * @author Niko Sakic
 * Klasse, die Positionen auf einem Schachbrett mit x und y Koordinaten speichert.
 * Es gibt die Koordinaten von 1 bis 8 auf beiden Achsen.
 */
public class Position {

	private int x;
	private int y;
	
	/**
	 * Konstruktor erhaelt einen x und einen y Wert und
	 * uebergibt diese an die Attribute
	 * @param x x-Koordinate
	 * @param y y-Koordinate
	 */
	public Position(int x, int y) {
		// Ueberprueft ob die Koordinaten auf dem Schachbrett liegen
		// falls nicht wird eine Exception geworfen.
		if(isValid(x,y)) {
		    this.x = x;
		    this.y = y;
		}else {
			throw new WrongPositionException("Position ungueltig. Koordinaten muessen zwischen 1 und 8 liegen.");
		}
	}
	
	/**
	 * Die Methode gibt die x-Koordinate als int zurueck
	 * @return int x-Wert
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Die Methode gibt die y-Koordinate als int zurueck
	 * @return int y-Wert
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Die Methode ueberprueft ob die Koordinaten der uebergebenen Position
	 * und des this Objektes uebereinstimmen.
	 * @param p Position
	 * @return boolean
	 */
	public boolean equals(Position p) {
		return (this.x == p.getX() && this.y == p.getY());
	}
	
	/**
	 * Die Methode ueberprueft ob die uebergebenen x und y Koordinaten
	 * auf dem Schachbrett liegen, also zwischen 1 und 8 liegen.
	 * @param x x-Koordinate
	 * @param y y-Koordinate
	 * @return boolean
	 */
	public static boolean isValid(int x, int y) {
		return (x >= 1 && x <= 8 && y >= 1 && y <= 8);
	}

	/**
	 * Ausgabe der Position auf dem Schachbrett.
	 * Format: (x/y)
	 * @return String Position als Text
	 */
	public String toString() {
		return "("+x+"/"+y+")";
	}

}
