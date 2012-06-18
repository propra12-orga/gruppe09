/**
 * Last Author : Dirk Date: 04/06/12 Last Action: Spielflaeche wird nun in einer Schleife gezeichnet und Bilder werden aus der Ordnerstrucktur heraus geladen.
 * */

package bomberman;

import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Die Klasse erzeugt eine Spielfläche.
 * 
 * @author Natalie
 * @version 17/06/12
 * 
 */
public class Playground {

	private static int zeile = 1, spalte = 1, zeile2 = 9, spalte2 = 9;

	static ImageIcon icon_Border = new ImageIcon(Toolkit.getDefaultToolkit()
			.getImage(Playground.class.getResource("grafics/map/block.png")));
	static ImageIcon icon_Grass = new ImageIcon(Toolkit.getDefaultToolkit()
			.getImage(Playground.class.getResource("grafics/map/grass.jpg")));
	static ImageIcon icon_Door = new ImageIcon(Toolkit.getDefaultToolkit()
			.getImage(Playground.class.getResource("grafics/map/door.png")));
	private static int numberOfImages = Bomberman.numberOfFields + 2;

	public static FeldElement field[][] = new FeldElement[numberOfImages][numberOfImages];
	static Figure figure1;
	static Figure figure2;

	/**
	 * Das Spielfeld wird auf einem 2D-Array erzeugt. Es wird eine doppelte
	 * for-Schleife durchlaufen wobei die Begrenzung sowie die Spielfelder
	 * erzeugt werden.
	 * 
	 * @param backgroundPanel
	 */
	public static JPanel createPlayground(JPanel backgroundPanel) {
		backgroundPanel.setLayout(null);
		for (int i = 0; i < numberOfImages; i++) {
			for (int j = 0; j < numberOfImages; j++) {
				if (((i % 2 == 0) && (j % 2 == 0))
						|| ((i == 0) || (i == numberOfImages - 1))
						|| ((j == 0) || (j == numberOfImages - 1))) {
					field[i][j] = new FeldElement(icon_Border);
					SettingProperties.border(i, j);
				} else {
					field[i][j] = new FeldElement(icon_Grass);
					SettingProperties.grass(i, j);
				}

				field[i][j].setBounds(i * 30, j * 30, 30, 30);
				backgroundPanel.add(field[i][j]);
			}
		}
		FillUpWithWalls();
		return backgroundPanel;

	}

	/**
	 * Es wird ein Level eingelesen, auf dem die jeweiligen Feldelemente
	 * verzeichnet sind. Wenn ein Fehler auftritt, wirft die Methode eine
	 * IOException aus.
	 */
	public static void FillUpWithWalls() {
		// Wir lesen lvl 1 aus
		ReadInOut file = new ReadInOut("level1.txt");
		try {
			StringBuilder StringArray = file.read();
			String text = StringArray.toString();

			int i, j, x = 0;
			for (j = 1; j != 10; j++) {
				for (i = 1; i != 12; i++) {
					char c = text.charAt(x);
					if (c == 'W')
						SettingProperties.wall(i, j);
					if (c == 'D') {
						SettingProperties.hiddenstargate(i, j);
					}
					if (c == 'G')
						SettingProperties.grass(i, j);
					if (c == 'B')
						SettingProperties.border(i, j);
					x++;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int getZeile() { // Getters & Setters fuer mehr Flexibilitaet
		// und Sicherheit
		return zeile;
	}

	public static void setZeile(int zeile) {
		Playground.zeile = zeile;
	}

	public static int getSpalte() {
		return spalte;
	}

	public static void setSpalte(int spalte) {
		Playground.spalte = spalte;
	}

	public static int getZeile2() {
		return zeile2;
	}

	public static void setZeile2(int zeile2) {
		Playground.zeile2 = zeile2;
	}

	public static int getSpalte2() {
		return spalte2;
	}

	public static void setSpalte2(int spalte2) {
		Playground.spalte2 = spalte2;
	}
}
