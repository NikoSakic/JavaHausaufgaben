import java.util.Comparator;

/**
 * 
 * @author Niko Sakic
 * Blattvergleich implementiert Comparator, damit Objekte von Blatt verglichen werden koennen
 *
 */
public class BlattVergleich implements Comparator<Blatt>{

	/**
	 * Vergleicht zwei Objekte von Blatt und bestimmt welches gewinnt/verliert als int
	 * Positiver Wert wenn Blatt 1 gewinnt
	 * Negativer Wert wenn Blatt 2 gewinnt
	 * 0 bei Gleichstand
	 * @param o1 Blatt 1
	 * @param o2 Blatt 2
	 * @return int Ergebnis des Vergleichs
	 */
	@Override
	public int compare(Blatt o1, Blatt o2) {
		// Bestimmung ob es bei den Karten Drillinge oder Paare gibt
		boolean drilling1 = istDrilling(o1.getBlatt());
		boolean drilling2 = istDrilling(o2.getBlatt());
		boolean paar1 = istPaar(o1.getBlatt());
		boolean paar2 = istPaar(o2.getBlatt());
		// Bewertung: ein Drilling gewinnt gegen Nicht-Drilling
		if(drilling1 && !drilling2) {
			return 1;
		}else if(!drilling1 && drilling2) {
			return -1;
		}else if(drilling1 && drilling2) { // Der Drilling mit hoeherem Wert gewinnt
			return o1.getBlatt()[0] - o2.getBlatt()[0];
		}else if(paar1 && !paar2) { // Paar gewinnt gegen Nicht-Paar
			return 1;
		}else if(!paar1 && paar2) {
			return -1;
		}else if(paar1 && paar2) { // Bei zwei Paaren gewinnt der hoehere Paarwert
			int erg =  getPaarwert(o1.getBlatt()) - getPaarwert(o2.getBlatt());
			if(erg == 0) { // Bei zwei gleichen Paaren gewinnt das Blatt mit hoeherer dritter Karte
				return getDritteKarte(o1.getBlatt())-getDritteKarte(o2.getBlatt());
			}
			return erg;
		}
		return (summe(o1.getBlatt())-summe(o2.getBlatt()));
	}
	
	/**
	 * Methode bestimmt ob die drei Karten des Blatts identisch sind
	 * @param feld 
	 * @return boolean
	 */
	private boolean istDrilling(int[] feld) {
		return (feld[0] == feld[1] && feld[1] == feld[2]);
	}
	
	/**
	 * Bestimmt ob zwei Karten innerhalb des Blattes identisch sind
	 * @param feld
	 * @return boolean
	 */
	private boolean istPaar(int[] feld) {
		return (feld[0] == feld[1] || feld[1] == feld[2] || feld[0] == feld[2]);
	}
	
	/**
	 * Bestimmt den Wert des Blattes, der nur einmal vorkommt
	 * Soll nur aufgerufen werden, wenn das Blatt ein Paar hat
	 * @param feld
	 * @return int
	 */
	private int getDritteKarte(int[] feld) {
		if(feld[0] == feld[1]) {
			return feld[2];
		}else if(feld[1] == feld[2]) {
			return feld[0];
		}else {
			return feld[1];
		}
	}
	
	/**
	 * Bestimmt den Wert des Paares, wenn das Blatt ein Paar hat
	 * @param feld
	 * @return int
	 */
	private int getPaarwert(int[] feld) {
		if(feld[0] == feld[1]) {
			return feld[0];
		}
		return feld[2];
	}
	
	/**
	 * Bestimmt die Summe aller Karten eines Blattes
	 * @param feld
	 * @return int Summe
	 */
	private int summe(int[] feld) {
		return feld[0]+feld[1]+feld[2];
	}
	

}
