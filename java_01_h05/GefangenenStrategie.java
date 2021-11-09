/**
 * 
 * @author Niko Sakic
 * Interface fuer die Strategien zum Spiel GefangenenDilemma
 */
public interface GefangenenStrategie {

	/**
	 * Methode die den naechsten Zug fuer alle Spielstrategien ermittelt.
	 * @return boolean false steht fuer Kooperation, true fuer Betrug
	 */
	public boolean getNextDecision();
	
	/**
	 * Uebergibt den letzten Zug des Gegners als boolean
	 * @param decision false steht fuer Kooperation, true fuer Betrug
	 */
	public void setOpponentsLastDecision(boolean decision);
	
	/**
	 * Die Methode soll am Ende eines Spiels aufgerufen zu werden,
	 * um mit dem gleichen Objekt nochmal spielen zu koennen.
	 */
	public void reset();
}
