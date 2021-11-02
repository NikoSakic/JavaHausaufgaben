/**
 * 
 * @author Niko Sakic
 * Das Interface Rechenoperation wird von Klassen implementiert,
 * um spezifische Rechenoperationen zu speichern
 */
public interface Rechenoperation {

	/**
	 * Die Methode wird hier angelegt um von den Klassen ueberschrieben 
	 * und gefuellt zu werden
	 * @param x Die Methode erhaelt immer einen Double Wert zum rechnen
	 * @return Die Methode gibt immer einen Double Wert als Ergebnis aus
	 */
	public double berechne(double x);
}
