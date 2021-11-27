
/**
 * 
 * @author Niko Sakic
 * Eigenen Exception. Wird geworfen, wenn eine ungueltige Position 
 * in der Klasse Position angenommen wird.
 * Ungueltig heisst nicht auf Schachbrett: nicht zwischen 1 und 8
 */
public class WrongPositionException extends RuntimeException{

	/**
	 * Konstruktor ruft Konstruktor von RuntimeException
	 * mit der uebergebenen Nachricht auf.
	 * @param m Nachricht
	 */
	public WrongPositionException(String m) {
		super(m);
	}

}
