import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Niko Sakic
 * Die Klasse Rechenoperationsliste wird benutzt um eine Liste von Rechenoperationen
 * aufzustellen und um damit zu rechnen.
 */
public class Rechenoperationsliste {

	private ArrayList<Rechenoperation> operationen;
	/**
	 * Default Konstruktor erstellt eine leere ArrayList vom Typ Rechenoperation
	 */
	public Rechenoperationsliste() {
		operationen = new ArrayList<>();
	}
	
	/**
	 * Fuegt der Liste eine weitere Rechenoperation hinzu.
	 * @param operation Objekt einer Klasse, die das Interface Rechenoperation implementiert.
	 */
	public void add(Rechenoperation operation) {
		operationen.add(operation);
	}
	
	/**
	 * Die Methode wendet alle Rechenoperationen in der Liste auf alle Elemente
	 * eines Feldes an.
	 * @param feld Eine Double Feld wird der Methode zum rechnen uebergeben.
	 * @return Die Methode gibt ein Feld mit allen Ergebnissen der Rechenoperationen zurueck.
	 */
	public double[] transform(double[] feld) {
		// Legt ein neues Array an
		double[] r = new double[feld.length];
		for(int i = 0; i < feld.length; i++) { // geht das Array durch
			r[i] = feld[i];
			// der urspruengliche Wert wird im neuen Array gespeichert
			// Danach werden alle Rechenoperationen auf das Element angewendet
			for(Rechenoperation x: operationen) { // Geht alle Rechenoperationen durch und wendet sie an
				r[i] = x.berechne(r[i]);
			}
		}
		return r;
	}
	
	public static void main(String[] args) {
		double[] ausgangsfeld = { 1, 3, 5, 6 };
		Rechenoperationsliste r = new Rechenoperationsliste();
		// Berechnet die Funktion (x^2)+2
		r.add(new Quadrat());
		r.add(new Addition(2));
		// Berechnung und Ausgabe
		double[] test1 = r.transform(ausgangsfeld); 
		// ergibt {3,11,27,38}
		System.out.println(Arrays.toString(test1));
		// fuegt der Rechenoperationsliste eine weitere Rechenoperation hinzu
		// und berechnet daher insgesamt Math.sqrt((x^2)+2)
		r.add(new Quadratwurzel());
		// Berechnung und Ausgabe
		double[] test2 = r.transform(ausgangsfeld);
		// ergibt { 1.7320508075688772,
		// 3.3166247903554,
		// 5.196152422706632,
		// 6.164414002968976}
		System.out.println(Arrays.toString(test2));
	}

}
