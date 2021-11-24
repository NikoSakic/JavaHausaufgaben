/**
 * 
 * @author Niko Sakic
 * Eigene Exception, die geworfen werden soll, wenn eine uebergebene Zahl kein gueltiges Plaettchen ist,
 * also nicht zwischen 1 und 15 liegt.
 */
public class WrongNumberException extends RuntimeException{
	
	// Konstruktor ruft Konstruktor der Basisklasse mit uebergebener Nachricht auf
	public WrongNumberException(String s) {
		super(s);
	}

}
