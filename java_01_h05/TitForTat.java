/**
 * 
 * @author Niko Sakic
 * Klasse, die das Interface GefangenenStrategie implementiert.
 * TitForTat ist eine Spielstrategie, in der zuerst kooperiert wird
 * und danach alle Zuege des Gegenspieler kopiert werden.
 */
public class TitForTat implements GefangenenStrategie{

	boolean opponent;
	boolean ersteRunde;
	
	/**
	 * Default Konstruktor setzt beim Aufruf ersteRunde auf true
	 */
	public TitForTat() {
		ersteRunde = true;
	}
	
	/**
	 * Die Methode ermittelt den naechsten Zug.
	 * @return boolean In der ersten Runde wird false ausgegeben. Danach immer der letzte Zug des Gegners.
	 */
	@Override
	public boolean getNextDecision() {
		if(ersteRunde) {
			ersteRunde = false;
			return false;
		}
		return opponent;
	}

	/**
	 * Die Methode uebergibt der Klasse den letzten Zug des Gegners.
	 * @param decision false steht fuer Kooperation, true fuer Betrug
	 */
	@Override
	public void setOpponentsLastDecision(boolean decision) {
		this.opponent = decision;
	}
	
	/**
	 * Die Methode soll am Ende eines Spiels aufgerufen zu werden,
	 * um mit dem gleichen Objekt nochmal spielen zu koennen.
	 * Setzt den boolean ersteRunde dafuer wieder auf true.
	 */
	public void reset() {
		ersteRunde = true;
	}

}
