/**
 * 
 * @author Niko Sakic
 * Die Klasse implementiert Rechenoperation, um Additionen durchzufuehren
 */
public class Addition implements Rechenoperation{

	private double summand;
	/**
	 * Default Konstruktor
	 * @param x Ein double wird uebergeben. Dieser soll dann in berechne() mit dessen Parameter addiert werden
	 */
	public Addition(double x) {
		summand = x;
	}

	/**
	 * Addition vom uebergebenen Wert und dem Parameter des Konstruktors
	 * @param double Ein Wert wird zum addieren uebergeben
	 * @return Gibt das Ergebnis als double zurueck
	 */
	@Override
	public double berechne(double x) {
		return x+summand;
	}

}
