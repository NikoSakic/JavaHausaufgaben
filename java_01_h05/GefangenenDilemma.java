/**
 * 
 * @author Niko Sakic
 * In der Klasse wird das Spiel GefangenenDilemma ausgetragen.
 */
public class GefangenenDilemma {

	private GefangenenStrategie player1, player2;
	
	/**
	 * Default Konstruktor setzt die Strategien der beiden Spieler zu den uebergebenen Parametern.
	 * @param player1 GefangenenStrategie fuer Spieler 1
	 * @param player2 GefangenenStrategie fuer Spieler 2
	 */
	public GefangenenDilemma(GefangenenStrategie player1, GefangenenStrategie player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	/**
	 * Setzt den Parameter als die Strategie von Spieler1 ein.
	 * @param player1 GefangenenStrategie fuer Spieler 1
	 */
	public void setPlayer1(GefangenenStrategie player1) {
		this.player1 = player1;
	}
	
	/**
	 * Setzt den Parameter als die Strategie von Spieler2 ein.
	 * @param player2 GefangenenStrategie fuer Spieler 2
	 */
	public void setPlayer2(GefangenenStrategie player2) {
		this.player2 = player2;
	}
	
	/**
	 * Die Methode traegt ein Match des Spiels Gefangenendilemmas mit n Zuegen aus
	 * und schreibt das Ergebnis in die Konsole.
	 * @param n Anzahl der erlaubten Zuege
	 */
	public void spiele(int n) {
		int punkte1=0, punkte2 = 0;
		System.out.println("-".repeat(80));
		for(int i = 0; i < n; i++) {
			boolean betrug1 = player1.getNextDecision();
			boolean betrug2 = player2.getNextDecision();
			// If-Else-Kaskade fuer die Bestimmung der Punkte, die beide Spieler erhalten
			if(betrug1 && betrug2) {
				punkte1 += 4;
				punkte2 += 4;
			}else if(!betrug1 && !betrug2) {
				punkte1 += 2;
				punkte2 += 2;
			}else if(!betrug1 && betrug2) {
				punkte1 += 6;
				punkte2 += 1;
			}else {
				punkte1 += 1;
				punkte2 += 6;
			}
			// uebergibt den Spielern jeweils den letzten Zug des anderen
			player1.setOpponentsLastDecision(betrug2);
			player2.setOpponentsLastDecision(betrug1);
		}
		// If-Else-Kaskade fuer die Ausgabe der verschiedenen Spielausgaenge
		if(punkte1 < punkte2) {
			System.out.println("Spieler 1 gewinnt mit "+punkte1+ " Punkten gegen Spieler 2 mit "+punkte2 +" Punkten.");
		}else if(punkte2 < punkte1) {
			System.out.println("Spieler 2 gewinnt mit "+punkte2+ " Punkten gegen Spieler 1 mit "+punkte1 +" Punkten.");
		}else {
			System.out.println("Gleichstand mit jeweils " + punkte1 + " Punkten.");
		}
		System.out.println();
		// setzt die Strategien beider Spielen zurueck um nochmal spielen zu koennen
		player1.reset();
		player2.reset();
	}
	
	// Testfall
	public static void main(String[] args) {
		// Vorgegebener Testfall
		GefangenenDilemma gd = new GefangenenDilemma(new TitForTat(), new PerKind());
		gd.spiele(100);
		// Weitere Tests
		gd.spiele(100);
		gd.setPlayer2(new Random());
		gd.spiele(50);
		gd.setPlayer1(new Pavlov());
		gd.setPlayer2(new Spite());
		gd.spiele(100);
		gd.setPlayer1(new PerKind());
		gd.spiele(100);
		gd.setPlayer2(new Pavlov());
		gd.spiele(60);
		
	}
	
	
}
