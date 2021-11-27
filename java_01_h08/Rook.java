import java.util.ArrayList;

/**
 * 
 * @author Niko Sakic
 * Klasse ueberschreibt Chessman, um die Schachfigur Rook/Turm zu simulieren.
 */
public class Rook extends Chessman{

	/** 
	 * Konstruktor erhaelt Position der Schachfigur.
	 * Ruft Konstruktor der Oberklasse auf.
	 * @param pos Position
	 */
	public Rook(Position pos) {
		super(pos);
	}

	/**
	 * Methode ueberschreibt abstrakte Klasse aus Chessman.
	 * Gibt alle Positionen, die der Turm/Rook von seiner
	 * aktuellen Position erreichen kann, als 
	 * ArrayList von Position zurueck
	 * @return ArrayList<Position> moegliche Zuege
	 */
	@Override
	public ArrayList<Position> getMoveList() {
		// Richtungen auf denen sich der Turm bewegen kann {x,y,x,y}
		// bewegt sich entweder nur auf x oder nur auf y Achse
		int[] richtungen = new int[]{-1,0,0,-1,1,0,0,1};
		ArrayList<Position> positions = new ArrayList<>();
		Position current = super.getPosition();
		int x = current.getX(), y = current.getX();
		// geht alle Elemente des Richtungsarrays durch
		for(int i = 0; i < richtungen.length;i+=2) {
			// durchlaeuft Positionen auf der aktuellen Richtung
			// von der Laenge 1 bis zur Laenge 7
			for(int j = 1; j < 8; j++) {
				int nx = x+richtungen[i]*j;
				int ny = y + richtungen[i+1]*j;
				// Fuegt die Position der ArrayList hinzu, falls sie auf dem Schachbrett liegt
				if(Position.isValid(nx,ny)) {
					positions.add(new Position(nx,ny));
				}
			}

		}
		return positions;
	}
	
	/**
     * Ueberschreibt die toString Methode.
	 * Enthaelt die Koordinaten und den Namen der Schachfigur "Turm".
	 * @return String Name und Position des Turms
	 */
	@Override
	public String toString() {
		return "Turm: "+ super.getPosition().toString();
	}

}
