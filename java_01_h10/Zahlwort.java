import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 * @author Niko Sakic
 * Die Klasse Zahlwort ordnet Zahlen von 1 bis 9999 die dazugehoerigen
 * deutschen Zahlenwoerter zu.
 * Die Klasse erzeugt auch einen Stream vom Typ String mit allen Zahlenwoertern
 * zwischen zwei angegegebenen Zahlen.
 */
public class Zahlwort {

	/**
	 * Die Methode ordnet der uebergebenen Zahl ein Zahlenwort zu.
	 * Dabei wird Rekursion verwendet.
	 * @param x Zahl
	 * @return String Zahlenwort
	 */
	public static String getZahlwort(int x) {
		// Es wird eine Exception geworfen wenn der Parameter nicht
		// zwischen 1 und 9999 liegt
		if(x < 1 || x > 9999) {
			throw new ArithmeticException("x muss zwischen 1 und 9999 liegen.");
		}
		String s = ""+x;
		StringBuilder sb = new StringBuilder();
		// die Zahlenwoerter werden u.a. aus diesen beiden Arrays zusammengesetzt
		String[] einser = {"ein","zwei","drei","vier","fuenf","sechs","sieben","acht","neun"};
		String[] zehner = {"zehn","zwanzig","dreissig","vierzig","fuenfzig","sechzig","siebzig","achtzig","neunzig"};
		// Zahlwort wird bei Laenge 1 ueber das erste Array bestimmt
		if(s.length()==1) {
			sb.append(einser[x-1]); 
			if(x==1) {
				sb.append("s");
			}
			return sb.toString();
		}
		// Zahlwort wird bei Laenge 2 aus beiden Arrays zusammengesetzt
		if(s.length()==2) {
			if(s.charAt(1)=='0') {
				return zehner[x/10-1];
			}
		    // Ausnahmen zwischen 10 und 19
			// hier kein und zwischen Zehner und Einer
			if(x==11) {return "elf";}
			if(x==12) {return "zwoelf";}
			// sechs und sieben werden gekuerzt, da sonst
			// sechszehn und siebenzehn ausgegeben wuerde
			if(s.charAt(0)=='1') {
				sb.append(einser[x%10-1]);
				if(s.charAt(1)=='6') {sb.deleteCharAt(sb.length()-1);}
				if(s.charAt(1)=='7') {sb.delete(sb.length()-2,sb.length());}
				sb.append(zehner[x/10-1]);
				return sb.toString();
			}
			sb.append(einser[x%10-1]);
			sb.append("und");
			sb.append(zehner[x/10-1]);
			return sb.toString();
		}
		// Fall von Laenge 3
		if(s.length()==3) {
			// die erste Ziffer wird als Index des Arrays genommen
			// dann wird "hundert" angehaengt 
			int k = x/100;
			sb.append(einser[k-1]);
			sb.append("hundert");
			//sb.append("und");
			// danach rekursiver Aufruf mit next
			int next = x%100;  // enthaelt die naechsten beiden Ziffer
			if((""+next).charAt(0)=='0') {
				next = next%10;  // next wird zur letzten Ziffer, wenn die zweite null ist
			}
			sb.append(getZahlwort(next));
			return sb.toString();
		}
		// Fall von Laenge 4
		if(s.length()==4) {
			// der praefix vor tausend wird ueber die erste Ziffer und
			// das Array einser bestimmt
			int k = x/1000;
			sb.append(einser[k-1]);
			sb.append("tausend");
			// danach rekursiver Aufruf mit den drei weiteren Ziffern
			int next = x%1000;
			sb.append(getZahlwort(next));
			return sb.toString();
		}
		return sb.toString();
	}
	
	/**
	 * Die Methode erzeugt einen Stream vom Typ String.
	 * Dieser enthaelt die Zahlworte der Zahlen zwischen
	 * den beiden Uebergabewerten. Beide inklusiv.
	 * @param start Startwert
	 * @param stop Endwert
	 * @return Stream<String> Stream der Zahlworte
	 */
	public static Stream<String> getZahlStream(int start, int stop){
		// zuerst wird ein IntStream von start bis stop erzeugt
		// dieser wird mit mapToObj zu Stream von Strings umgewandelt
		// Aufruf von getZahlwort fuer die Bestimmung der Strings
		return IntStream.rangeClosed(start, stop).mapToObj(num->getZahlwort(num));
	}
	
	
}
