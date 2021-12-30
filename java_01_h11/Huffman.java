import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author Niko Sakic
 * Die Klasse Huffman entschluesselt eine Nachricht aus einer Datei
 * mit der Huffman Codierung.
 * Fuer die Entschluesselung muss die Decodiertabelle in der Datei
 * mit enthalten sein.
 * Nachricht kann nur Grossbuchstaben und Leerzeichen enthalten
 */
public class Huffman {
	
	/**
	 * Die Funktion erhaelt eine Datei.
	 * Die erste Zeile enthaelt die zu entschluesselnde Nachricht.
	 * Der Rest die Decodierungstabelle.
	 * Die entschluesselte Nachricht wird als String zurueckgegeben
	 * @param f Eingabedatei
	 * @return String decodierte Nachricht
	 */
	public static String decode(File f) {
		String res = "";
		// Die Codierungen einzelner Buchstaben werden in einer HashMap gespeichert
		HashMap<String,Character> codierung = new HashMap<String,Character>();
		Scanner sc = null;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// auslesen der entschluesselten Nachricht
		String text = sc.nextLine();
		// wirft Fehler, wenn zu entschluesselnde Nachricht leer ist
		if(text.isBlank() || text.isEmpty()) {
			throw new IllegalArgumentException("Nachricht darf nicht leer sein");
		}
		int index = 0;
		// durchgehen der Decodiertabelle
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			// leere Zeilen werden uebersprungen
			if(s.isBlank() || s.isEmpty()) {
				index++;
				continue;
			}
			TextPruefung(s); // pruefen ob valide
			// Codierungen werden der HashMap hinzugefuegt
			// die Codierungen stehen entsprechend ihrer Zeile fuer einen Buchstaben
			// zum Beispiel erste Zeile = A
			if(index < 26) {
				codierung.put(s, (char) ('A'+index));
			}else if(index == 26){
				// die letzte Zeile(26) steht fuer das Leerzeichen
				codierung.put(s, ' ');
			}
			index++;
		}
		sc.close();
		StringBuilder sb = new StringBuilder("");
		while(!text.equals("")) {
			// sucht welche Codierung am Anfang der Nachricht vorkommt
			// loescht daraufhin die Codierung aus der Nachricht
			// und fuegt den entsprechenden Nachricht dem StrinbBuilder hinzu
			for(String code : codierung.keySet()) {
				if(text.indexOf(code) == 0) {
					sb.append(codierung.get(code));
					text = text.substring(code.length());
					continue;
				}
			}
			// Fehler wird geworfen, falls es keine passende Codierung gibt
			throw new IllegalArgumentException("keine passende Codierung gefunden\nNachricht oder Tabelle fehlerhaft.");
		} // bricht ab wenn die Nachricht komplett abgearbeitet ist/leer ist
		return sb.toString();
	}
	
	/**
	 * Die Funktion ueberprueft ob der uebergebene String
	 * als Huffman Code/Codierung gueltig ist
	 * @param s Eingabe
	 * @throws IllegalArgumentException
	 */
	private static void TextPruefung(String s) {
		// String ist nicht valide, wenn er nicht nur aus 
		// Einsen und Nullen besteht
		if(!s.replace("1", "").replace("0", "").equals("")) {
			throw new IllegalArgumentException("Code darf nur aus Einsen und Nullen bestehen");
		}
		
	}
	
	// Test
	public static void main(String[] args) {
		File file = new File("message.txt");
		System.out.println(decode(file));
		System.out.println(decode(new File("mississippi.txt")));
	}

}
