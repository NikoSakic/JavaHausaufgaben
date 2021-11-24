/**
 * 
 * @author Niko Sakic
 * Einfacher Schiebealgorithmus der Schiebepuzzle loesen soll.
 * Loest nur bis die erste Position wieder 1 ist
 */
public class SchiebAlg1 implements Loesungsalgorithmus{

	/**
	 * Fuehrt auf dem Schiebepuzzle zufaellige Zuege aus, bis der Wert
	 * auf der ersten Stelle (rechte obere Ecke) wieder gleich 1 ist.
	 * @param pz Schiebepuzzle, welches geloest werden soll
	 */
	@Override
	public void loese(Schiebepuzzle pz) {
		while(pz.get(0, 0) != 1) {
			int r = 1 + (int) (Math.random()*14);
			if(pz.istVerschiebbar(r)) {
				pz.schiebe(r);
			}
		}
		
	}

	
}
