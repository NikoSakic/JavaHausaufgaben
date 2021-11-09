
public class Random implements GefangenenStrategie{

	
	@Override
	public boolean getNextDecision() {
		int r = (int) (Math.random()*100);
		return (r<50.);
	}

	/**
	 * Die Methode uebergibt der Klasse den letzten Zug des Gegners.
	 * @param decision false steht fuer Kooperation, true fuer Betrug
	 */
	@Override
	public void setOpponentsLastDecision(boolean decision) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Die Methode soll am Ende eines Spiels aufgerufen zu werden,
	 * um mit dem gleichen Objekt nochmal spielen zu koennen.
	 * Macht nichts, da es hier nicht noetig ist.
	 */
	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

}
