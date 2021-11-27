import java.util.ArrayList;

/**
 * 
 * @author Niko Sakic
 * Klasse ueberschreibt Chessman, um die Schachfigur Rook/Turm zu simulieren.
 */
public class Knight extends Chessman{

	/** 
	 * Konstruktor erhaelt Position der Schachfigur.
	 * Ruft Konstruktor der Oberklasse auf.
	 * @param pos Position
	 */
	public Knight(Position pos) {
		super(pos);
	}

	/**
	 * Methode ueberschreibt abstrakte Klasse aus Chessman.
	 * Gibt alle Positionen, die der Knight/Springer von seiner
	 * aktuellen Position erreichen kann, als 
	 * ArrayList von Position zurueck
	 * @return ArrayList<Position> moegliche Zuege
	 */
	@Override
	public ArrayList<Position> getMoveList() {
		// das Array enthaelt abwechselnd moegliche x und y Zuege
		// r = {x,y,x,y,x,y}
		int[] r = new int[]{1,2,2,1,-1,-2,2,-1,-2,-1,-1,2,-2,1,1,-2};
		ArrayList<Position> positions = new ArrayList<>();
		// geht das Array r durch
		// erhoeht mit i+=2, da in einem Schleifendurchlauf zwei
		// Elemente von r behandelt werden
		for(int i = 0; i < r.length; i+=2) {
			// berechnet moegliche Position
			int x = super.getPosition().getX()+r[i];
			int y = super.getPosition().getY()+r[i+1];
			// Fuegt die Position der ArrayList hinzu, falls sie auf dem Schachbrett liegt
			if(Position.isValid(x, y)) { 
				positions.add(new Position(x,y));
			}
		}
		return positions;
	}
	
	/**
	 * Ueberschreibt die toString Methode.
	 * Enthaelt die Koordinaten und den Namen der Schachfigur "Springer".
	 * @return String Name und Position des Springers
	 */
	@Override
	public String toString() {
		return "Springer: "+super.getPosition().toString();
	}

}
