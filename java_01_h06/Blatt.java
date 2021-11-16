/**
 * 
 * @author Niko Sakic
 * Klasse Blatt enthaelt drei Spielkarten mit Wert 2 bis 14
 */
public class Blatt {
	// Enthaelt Werte der Karten des Blatts
	private int[] karten = new int[3];
	
	/**
	 * Konstruktor erhaelt ein int Feld und uebergibt es an KartenUebergabe()
	 * @param feld int[]
	 */
	public Blatt(int[] feld) {
		KartenUebergabe(feld);
	}
	
	/**
	 * Gibt die Werte der Karten des Blatts als int[] zurueck
	 * @return int[] ausgabe
	 */
	public int[] getBlatt() {
		int[] ausgabe = new int[3];
		for(int i = 0; i< 3; i++) {
			ausgabe[i] = karten[i];
		}
		return ausgabe;
	}
	
	/**
	 * Ersetzt die Karten mit dem uebergebenen Parameter
	 * Kontrolle des Parameters in KartenUebergabe()
	 * @param feld 
	 */
	public void setBlatt(int[] feld) {
		KartenUebergabe(feld);
	}
	
	/**
	 * Kontrolliert ob das uebergebene int Feld fuer die Spielkarten in Blatt geeignet ist
	 * und uebergibt diese dann
	 * @param feld
	 */
	private void KartenUebergabe(int[] feld) {
		// Das int Feld muss die Laenge 3 haben
		if(feld.length != 3) {
			throw new NumberFormatException("Das Feld muss 3 Elemente haben");
		}
		// Ueberprueft ob alle Werte zwischen 2 und 14 liegen
		for(int i = 0; i< 3; i++) {
			if(feld[i] < 2 || feld[i] > 14) {
				throw new NumberFormatException("Der Wert fuer die Karten muss zwischen 2 und 14 sein");
			}
			karten[i] = feld[i];
		}
	}
	
	/**
	 * Gibt das Blatt und seine Karten als angemessenen String zurueck
	 * @return String Ausgabe als String
	 */
	public String toString() {
		String res = karten[0]+", "+karten[1]+", "+karten[2];
		return res;
	}

}
