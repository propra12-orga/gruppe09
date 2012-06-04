/**
 * Last Author : Lukas Date: 04/06/12 Last Action: Initalize vereinfacht. Baut sich jetzt einfacher auf*/
package bomberman;

import java.awt.Container;

public class Bomberman {
	static Figure figure1;
	static Gui gui;
	static Field Fields[][] = new Field[9][9];
	private static Field POS;

	public static void main(String[] args) {
		gui = new Gui();
		// gui.setTitle("Bomberman");
		// gui.setSize(300, 200);
		// gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		initalize();

		figure1 = new Figure(0, 0);

		Container contentPane = gui.getContentPane();
		contentPane.add(new MoveControl(figure1));

	}

	public static void starteSingleplayer() {
		gui.setVisible(false);
		gui.update(gui.getGraphics());

		gui.add(figure1, 0);
		Figure.resetPosition();

		gui.setVisible(true);
	}

	public static void initalize() {
		POS = new Field();
		int i = 0, j = 0;
		while (i != 9) {
			j = 0;
			while (j != 9) {
				Fields[i][j] = new Field();

				j++;
			}
			i++;
		}
		i = 0;
		while (i <= Fields.length) {
			j = 0;
			while (j <= Fields.length) {
				if ((i == 0) && (j == 0)) {
					Fields[i][j].fillField(null, Fields[i + 1][j], null,
							Fields[i][j + 1], "FELD1");
				} else if ((i == 0) && (j < 8)) {
					Fields[i][j].fillField(null, Fields[i + 1][j],
							Fields[i][j - 1], Fields[i][j + 1], "Obere Grenze");
				} else if ((i == 0) && (j == 8)) {
					Fields[i][j].fillField(null, Fields[i + 1][j],
							Fields[i][j - 1], null, "Obere und rechte Grenze");
				} else if (((i != 0) && (i < 8)) && (j == 0)) {
					Fields[i][j].fillField(Fields[i - 1][j], Fields[i + 1][j],
							null, Fields[i][j + 1], "Linke Grenze");
				} else if ((i == 8) && (j == 0)) {
					Fields[i][j].fillField(Fields[i - 1][j], null, null,
							Fields[i][j + 1], "Linke und untere Grenze");
				} else if ((i == 8) && ((j != 0) && (j < 8))) {
					Fields[i][j]
							.fillField(Fields[i - 1][j], null,
									Fields[i][j - 1], Fields[i][j + 1],
									"untere Grenze");
				} else if ((i == 8) && (j == 8)) {
					Fields[i][j].fillField(Fields[i - 1][j], null,
							Fields[i][j - 1], null, "Rechte und untere Grenze");
				} else if ((i < 8) && (j == 8)) {
					Fields[i][j].fillField(Fields[i - 1][j], Fields[i + 1][j],
							Fields[i][j - 1], null, "Rechte Grenze");
				} else if ((i > 0) && (i < 8) && ((j > 0) && (j < 8))) {
					Fields[i][j].fillField(Fields[i - 1][j], Fields[i + 1][j],
							Fields[i][j - 1], Fields[i][j + 1], "Spielfeld");
				}

				j++;
			}
			i++;
		}

		POS = Fields[0][0];

	}

	public static Field GetPos() {
		return POS;
	}

}
