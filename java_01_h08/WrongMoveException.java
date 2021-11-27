/**
 * 
 * @author Niko Sakic
 * Eigenen Exception. Wird geworfen, wenn ein ungueltiger Zug 
 * ausgefuehrt wird, also wenn Chessman oder eine Klasse, die von Chessman erbt,
 * zu einer Position bewegt werden soll, die nicht in einem Zug erreichbar ist.
 */
public class WrongMoveException extends RuntimeException{

	/**
	 * Konstruktor ruft Konstruktor von RuntimeException
	 * mit der uebergebenen Nachricht auf.
	 * @param m Nachricht
	 */
	public WrongMoveException(String m) {
		super(m);
	}

}
