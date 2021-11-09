
public class Pavlov implements GefangenenStrategie{

	private boolean ersteRunde;
	private boolean betrug;
	private boolean gegner;
	
	/**
	 * Default Konstruktor setzt beim Aufruf ersteRunde auf true
	 */
	public Pavlov() {
		ersteRunde = true;;
	}
	
	@Override
	public boolean getNextDecision() {
		if(ersteRunde) {
			ersteRunde = false;
			return false;
		}
		betrug = (betrug!=gegner);
		return betrug;
	}

	/**
	 * Die Methode uebergibt der Klasse den letzten Zug des Gegners.
	 * @param decision false steht fuer Kooperation, true fuer Betrug
	 */
	@Override
	public void setOpponentsLastDecision(boolean decision) {
		gegner = decision;
		
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
