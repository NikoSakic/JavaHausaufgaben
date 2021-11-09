/**
 * 
 * @author Niko Sakic
 * Klasse, die das Interface GefangenenStrategie implementiert.
 * Spite ist eine Spielstrategie, in der zuerst kooperiert wird
 * bis der Gegner den Spieler einmal betruegt. 
 * Danach wird immer betrogen.
 */
public class Spite implements GefangenenStrategie{

	public boolean betrogen;
	
	/**
	 * Default Konstruktor setzt fest, dass der Spieler noch nicht betrogen wurde
	 */
	public Spite() {
		betrogen = false;
	}

	/**
	 * Bestimmt naechsten Zug, indem ausgegeben wird,
	 * ob der Spieler schon betrogen wurde.
	 */
	@Override
	public boolean getNextDecision() {
		return betrogen;
	}

	/**
	 * Die Methode uebergibt der Klasse den letzten Zug des Gegners.
	 * @param decision false steht fuer Kooperation, true fuer Betrug
	 */
	@Override
	public void setOpponentsLastDecision(boolean decision) {
		if(decision) {
			betrogen = true;
		}
	}
	
	/**
	 * Die Methode soll am Ende eines Spiels aufgerufen zu werden,
	 * um mit dem gleichen Objekt nochmal spielen zu koennen.
	 * Setzt den boolean betrogen dafuer wieder auf false.
	 */
	public void reset() {
		betrogen = false;
	}
}
