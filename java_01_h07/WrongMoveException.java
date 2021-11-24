/**
 * 
 * @author Niko Sakic
 * Eigene Exception, die geworfen werden soll, wenn ein Zug in Schiebepuzzle nicht gueltig ist
 */
public class WrongMoveException extends RuntimeException{

	// Konstruktor ruft Konstruktor der Basisklasse mit uebergebener Nachricht auf
	public WrongMoveException(String s) {
		super(s);
	}
}
