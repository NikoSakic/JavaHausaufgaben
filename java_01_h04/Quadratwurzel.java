/**
 * 
 * @author Niko Sakic
 * Die Klasse implementiert Rechenoperation, um Wurzelziehungen durchzufuehren
 */
public class Quadratwurzel implements Rechenoperation{

	public Quadratwurzel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Zieht die Wurzel des uebergebenen Wertes
	 * @param double Ein Wert wird zum Wurzel ziehen uebergeben
	 * @throws ArithmeticException Wirft eine Exception bei negativen Parametern,
	 *         da keine Wurzel innerhalb der reellen Zahlen gezogen werden kann
	 * @return Gibt das Ergebnis als double zurueck
	 */
	@Override
	public double berechne(double x) {
		if(x < 0 ){
			throw new ArithmeticException();
		}
		return Math.sqrt(x);
	}

}
