/**
 * 
 * @author Niko Sakic
 * Die Klasse implementiert Rechenoperation, um einen uebergebenen Wert zu quadrieren
 */
public class Quadrat implements Rechenoperation{

	public Quadrat() {
		
	}
	
	/**
	 * Quadrierung des Parameters
	 * @param double Ein Wert wird zum quadrieren uebergeben
	 * @return Gibt das Ergebnis als double zurueck
	 */
	@Override
	public double berechne(double x) {
		return x*x;
	}
	

}
