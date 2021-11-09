/**
 * 
 * @author Niko Sakic
 * Klasse, die das Interface GefangenenStrategie implementiert.
 * PerKind ist eine Spielstrategie, in periodisch zweimal kooperiert und dann
 * einmal betrogen wird.
 */
public class PerKind implements GefangenenStrategie{

	private int zug;
	
	/**
	 * Default Konstruktor setzt beim Aufruf den aktuellen Zug auf 1
	 */
	public PerKind() {
		this.zug = 1;
	}
	
	/**
	 * Die Methode ermittelt den naechsten Zug.
	 * Die ersten zwei Male wird kooperiert und 
	 * jedes drittes Mal betrogen.
	 */
	@Override
	public boolean getNextDecision() {
		boolean res = false;
		if(zug%3==0) {
			res = true;
		}
		zug++;
		return res;
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
	 * Dafuer wird der aktuelle Zug auf 1 gesetzt.
	 */
	public void reset() {
		this.zug = 1;
	}

}
