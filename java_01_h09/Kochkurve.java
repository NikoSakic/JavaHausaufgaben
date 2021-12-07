import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 
 * @author Niko Sakic
 * Kochkurve enthaelt statische Methoden, die die Punkte einer Kochkurve rekursiv bestimmen.
 * Dazu wird in der Main Methode ein Testfall ausgefuert.
 */
public class Kochkurve {

	// Test
	public static void main(String[] args) {
		kochKurve(0,500,500,500,0);
		System.out.println();
		kochKurve(0,500,500,500,1);
		System.out.println();
		kochKurve(0,500,500,500,2);
	}
	
	/**
	 * Die Hilfsfunktion von kochKurveHilfe.
	 * Zwischen dem Anfangs und Endpunk werden je drei Punkte bestimmmt.
	 * Dadurch ergeben sich 4 Strecken, mit denen sich die Funktion rekursiv augeruft.
	 * @param ax Startpunkt x-Koordinate
	 * @param ay Startpunkt y-Koordinate
	 * @param bx Endpunkt x-Koordinate
	 * @param by Endpunkt y-Koordinate
	 * @param rek Rekursiontiefe
	 */
	private static void kochKurveHilfe(double ax, double ay, double bx, double by, int rek){
		DecimalFormat df = new DecimalFormat();
		df.setRoundingMode(RoundingMode.FLOOR);
		df.setMaximumFractionDigits(1);
		df.setDecimalSeparatorAlwaysShown(false);
		if(rek == 0) { // Abruchbedingung mit Ausgabe des ersten Punktes
			System.out.printf("(%s/%s) ",df.format(ax),df.format(ay));
			return;
		}
		double dx = bx-ax, dy = by-ay;
		// erster rekursvier Aufruf vom uebergebenen Startpunkt zum naechsten Punkt
		kochKurveHilfe(ax, ay, ax + ((1./3.)*dx), ay + ((1./3.)*dy), rek-1);
		// mittlerer Punkt: Spitze eines gleichwinkligen Dreiecks
		// h ist die Hoehe des Dreiecks auf der Strecke von a nach b
		double strecke = Math.sqrt(dx*dx+dy*dy);
		double h = (1./3.)*strecke*Math.sin(Math.toRadians(60));
		// nx und ny sind der senkrechte Vektor vom Mittelpunkt der Strecke a bis b
		// zur Spitze des Dreiecks
		double nx = -dy, ny = dx;
		double len = Math.sqrt(nx*nx+ny*ny);
		// nx und ny werden auf die korrekte Laenge skaliert
		nx *= h*(1./len);
		ny *= h*(1./len);
		double spitzex = ax + (0.5*dx)-nx;
		double spitzey = ay + (0.5*dy)-ny;
		kochKurveHilfe(ax + ((1./3.)*dx), ay + ((1./3.)*dy), spitzex, spitzey, rek-1);
		kochKurveHilfe(spitzex, spitzey, ax + ((2./3.)*dx), ay + ((2./3.)*dy), rek-1);
		kochKurveHilfe(ax + ((2./3.)*dx), ay + ((2./3.)*dy), bx, by, rek-1);
	}
	
	/**
	 * Funktion berechnet die Punkte der Kochkurve.
	 * Ruft die rekursive Hilfsfunktion auf.
	 * Liefert die Ausgabe der Rekursiontiefe vor dem rekursiven Algorithmus
	 * und die Ausgabe des letzten Punktes danach.
	 * Zwischen dem Anfangs und Endpunk werden je drei Punkte bestimmmt.
	 * Dadurch ergeben sich 4 Strecken, mit denen die Funktion rekursiv augerufen wird.
	 * @param ax Startpunkt x-Koordinate
	 * @param ay Startpunkt y-Koordinate
	 * @param bx Endpunkt x-Koordinate
	 * @param by Endpunkt y-Koordinate
	 * @param rek Rekursiontiefe
	 */
	public static void kochKurve(double ax, double ay, double bx, double by, int rek) {
		DecimalFormat df = new DecimalFormat();
		df.setRoundingMode(RoundingMode.FLOOR);
		df.setMaximumFractionDigits(1);
		df.setDecimalSeparatorAlwaysShown(false);
		System.out.printf("Rekursiontiefe %d: ",rek);
		kochKurveHilfe(ax,ay,bx,by,rek);
		System.out.printf("(%s/%s)\n",df.format(bx),df.format(by));
		
	}

}
