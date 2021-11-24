/**
 * 
 * @author Niko Sakic
 * Schiebepuzzle simuliert ein Schiebepuzzle mit den Dimensionen 4x4 da.
 * Das Schiebepuzzle enthaelt 15 Plaettchen, die mit 1 bis 15 markiert sind und eine freie Stelle.
 */
public class Schiebepuzzle {

	// Plaettchen als zweidimensionales Array, leere Stelle hat Wert 0
	private int[][] puzzle;
	// Position der 0 im zweidimensionalen Array
	private int freiX, freiY;
	
	/**
	 * Default Konstruktor
	 * Initialisert die Standardbelegung des Puzzles und setzt freiX und freiY
	 * auf die linke untere Ecke des Puzzles.
	 */
	public Schiebepuzzle() {
		this.puzzle = new int[][] {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,0}};
		this.freiX = 3;
		this.freiY = 3;
	}
	
	/**
	 * Die Methode verschiebt das Plaettchen auf dem der uebergebene Parameter steht.
	 * Das Plaettchen wird mit der freien Stelle vertauscht.
	 * @param i Zahl auf dem Plaettchen
	 */
	public void schiebe(int i) {
		// ueberprueft ob das Plaettchen existiert und verschiebbar ist
		// wenn nicht wird eine Exception geworfen
		if(!istVerschiebbar(i)) {
			throw new WrongMoveException("Zug ist nicht gueltig");
		}
		int posX = 0, posY = 0;
		// durchlaeuft das Array und findet die Position des uebergebenen Plaettchens i
		for(int j = 0; j < 4; j++) {
			for(int m = 0; m < 4; m++) {
				if(this.puzzle[j][m] == i) {
					posX = j;
					posY = m;
				}
			}
		}
		// vertauscht die Werte von i und der freien Stelle im Array
		this.puzzle[this.freiX][this.freiY] = i;
		this.puzzle[posX][posY] = 0;
		// setzt die freie Stelle auf neue Position
		this.freiX = posX;
		this.freiY = posY;
	}
	
	/**
	 * Die Methode ermittelt ob das Plaettchen mit der Zahl i 
	 * verschiebbar ist oder nicht.
	 * Ergebnis wird als boolean ausgegeben.
	 * @param i Zahl auf dem Plaettchen
	 * @return boolean 
	 */
	public boolean istVerschiebbar(int i) {
		// Wirfte eine Exception falls das Plaettchen nicht zwischen 1 und 15 ist,
		// also nicht existiert
		if(i < 1 || i > 15) {
			throw new WrongNumberException("Zahl ist nicht gueltig");
		}
		int posX = 0, posY = 0;
		// durchlaeuft das Array und findet die Position des uebergebenen Plaettchens i
		for(int j = 0; j < 4; j++) {
			for(int m = 0; m < 4; m++) {
				if(this.puzzle[j][m] == i) {
					posX = j;
					posY = m;
				}
			}
		}
		// Das Plaettchen ist verschiebbar, wenn es den Abstand 1 von der freien Stelle hat
		boolean res = (Math.abs(posX-this.freiX)+Math.abs(posY-this.freiY) == 1);
		return res;
	}
	
	/**
	 * Die Methode fuehrt 100 zufaellige Zuege aus um das Puzzle zu mischen.
	 */
	public void mische() {
		int count = 0;
		while(count < 100) {
			// generiert zufealliges Plaettchen
			int r = 1 + (int) (Math.random()*14);
			if(istVerschiebbar(r)) {
				schiebe(r);
				// erhoeht count nur wenn es einen zulaessigen Zug gibt
				count++;
			}
		}
	}
	
	/**
	 * Die Methode gibt den Wert des Arrays puzzle an der uebergebenen
	 * Position zurueck.
	 * @param x Reihe des Arrays
	 * @param y Spalte des Arrays
	 * @return int Wert des Arrays an der Stelle [x][y]
	 */
	public int get(int x, int y) {
		return this.puzzle[x][y];
	}
	
	/**
	 * Die Methode setzt das Array puzzle auf ein bestimmtes Array.
	 * Zum Testen auch praktisch, da zufaellig gemischte Puzzles 
	 * auch schon 1 an erster Stelle haben koennen.
	 * Soll nur mit passenden Arrays aufgerufen werden.
	 * @param a int Array
	 */
	public void setPuzze(int[][] a) {
		// Wirft Exception wenn es weniger als 4 Reihen gibt
		if(a.length<4) {
			throw new NumberFormatException("Array ist zu klein");
		}
		for(int i = 0; i < 4; i++) {
			// Wirft Exception wenn die Reihe weniger als 4 Elemente hat
			if(a[i].length<4) {
				throw new NumberFormatException("Array ist zu klein");
			}
			// kopiert a auf puzzle
			for(int j = 0; j < 4; j++) {
				this.puzzle[i][j] = a[i][j];
				// setzt die Position der freien Stelle
				if(this.puzzle[i][j] == 0) {
					this.freiX = i;
					this.freiY = j;
				}
			}
		}
	}
	
	/**
	 * Die Methode gibt das Schiebepuzzle als geeigneten String aus.
	 * @return String Ausgabe
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < 4; i++) {
	        sb.append("|");
	        for (int j = 0; j < 4; j++) {
	        if(this.puzzle[i][j]!=0) {
	            sb.append(String.format("%2d", this.puzzle[i][j])+"|");
	        }else {
	            sb.append("  |");
	        }
	        
	        }
	        sb.append("\n");
	        sb.append("-".repeat(13)+"\n");
	    }
		sb.append("\n");
		return sb.toString();	
	}
	
	// Test
	public static void main(String[] args) {
		// loest ein zufaellig gemischtes Puzzle
		Schiebepuzzle puzzle = new Schiebepuzzle();
		System.out.println(puzzle.toString());
		puzzle.mische();
		System.out.println(puzzle);
		Loesungsalgorithmus alg1 = new SchiebAlg1();
		alg1.loese(puzzle);
		System.out.println(puzzle);
		// loest das uebergebene Puzzle
		// Beispiel vom Hausaufgabenblatt
		puzzle.setPuzze(new int[][] {{7,8,11,2},{14,0,6,15},{1,4,9,3},{13,5,10,12}});
		System.out.println(puzzle);
		alg1.loese(puzzle);
		System.out.println(puzzle);
	}
}
