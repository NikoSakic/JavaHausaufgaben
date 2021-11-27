import java.util.ArrayList;

/**
 * 
 * @author Niko Sakic
 * Abstrakte Klasse simuliert eine Schachfigur auf dem Schachbrett.
 * Soll von Schachfiguren ueberschrieben werden.
 */
public abstract class Chessman {

	private Position position;
	
	/**
	 * Konstruktor erhaelt Position der Schachfigur.
	 * @param pos Position
	 */
	public Chessman(Position pos) {
		this.position = new Position(pos.getX(),pos.getY());
	}
	
	/**
	 * Methode gibt die Position der Schachfigur aus.
	 * @return Position
	 */
	public Position getPosition() {
		return new Position(this.position.getX(),this.position.getY());
	}
	
	/**
	 * Die Methode bewegt die Figur zu der uebergebenen Position,
	 * falls dies moeglich ist.
	 * @param pos Position
	 */
	public void moveTo(Position pos) {
		// Ueberprueft ob die Position in einem Zug erreicht werden kann,
		// wenn nicht wird eine Exception geworfen
		if(canMoveTo(pos)) {
			this.position = new Position(pos.getX(),pos.getY());
		}else {
			throw new WrongMoveException("Zug ist unguelitg");
		}
	}
	
	/**
	 * Abstrakte Methode, die von Subklassen ueberschrieben werden soll/muss.
	 * Gibt alle Position, die in einem Zug erreicht werden koennen
	 * als ArrayList zurueck.
	 * @return ArrayList<Position> 
	 */
	public abstract ArrayList<Position> getMoveList();
	
	/**
	 * Methode gibt aus ob die uebergebene Position, in einem Zug erreichbar ist.
	 * Ergebnis wird als boolean ausgegeben.
	 * @param pos gewuenschte Position
	 * @return
	 */
	public boolean canMoveTo(Position pos) {
		// Ueberprueft ob die gewuenschte Position, in der ArrayList
		// der moeglichen Zuege enthalten ist.
		for(Position p : getMoveList()) {
			if(p.getX() == pos.getX() && p.getY() == pos.getY()) {
				return true;
			}
		}
		return false;
	}
	

}
