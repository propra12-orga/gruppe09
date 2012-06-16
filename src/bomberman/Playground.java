/**
 * Last Author : Dirk Date: 04/06/12 Last Action: Spielflaeche wird nun in einer Schleife gezeichnet und Bilder werden aus der Ordnerstrucktur heraus geladen.
 * */

package bomberman;

import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Playground {

	private static int zeile = 1, spalte = 1, zeile2 = 8, spalte2 = 8;

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

	public static void FillUpWithWalls() {
		// Wir lesen lvl 1 aus
		ReadInOut file = new ReadInOut("level1.txt");
		try {
			StringBuilder StringArray = file.read();
			String text = StringArray.toString();

			int i, j, x = 0;
			for (i = 1; i != 10; i++) {
				for (j = 1; j != 12; j++) {
					char c = text.charAt(x);
					if (c == 'W')
						SettingProperties.wall(j, i);
					if (c == 'D') {
						SettingProperties.hiddenstargate(j, i);
					}
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
