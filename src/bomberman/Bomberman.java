/**
 * Last Author : Dirk Date: 09/06/12 Last Action: Es wird nun die Collision der Spielinternen grenzsteine unter initalize festgelegt
 */
package bomberman;

import java.awt.Container;

public class Bomberman {
	static Figure figure1;
	static Figure2 figure2;
	static Gui gui;
	static Container contentPane;
	public static int numberOfFields = 9;// sollte immer ungerade sein
	static Field fields[][] = new Field[numberOfFields][numberOfFields];
	private static Field pos;

	public static void main(String[] args) {
		gui = new Gui();
		gui.setVisible(true);
		initalize();

		figure1 = new Figure(30, 30);
		figure2 = new Figure2(270, 270);

		Container contentPane = gui.getContentPane();
		contentPane.add(new MoveControl(figure1, figure2));

	}

	public static void starteSingleplayer() {
		gui.setVisible(false);
		gui.update(gui.getGraphics());
		gui.add(figure1, 0);

		// contentPane.add(new MoveControl(figure1));
		// gui.add(figure2, 0);

		// resetPosition();

		gui.setVisible(true);
	}

	public static void starteMultiplayer() {
		gui.setVisible(false);
		gui.update(gui.getGraphics());
		starteSingleplayer();
		gui.add(figure2, 0);

		// resetPosition();

		gui.setVisible(true);
	}

	private static void resetPosition() {
		figure1.setPosition(30, 30);
		// fields muss hier noch zurueck gesetzt werden
	}

	public static void initalize() {
		pos = new Field();
		for (int i = 0; i < numberOfFields; i++) {
			for (int j = 0; j < numberOfFields; j++) {
				fields[i][j] = new Field();
			}
		}
		for (int i = 0; i < numberOfFields; i++) {
			for (int j = 0; j < numberOfFields; j++) {
				if ((i == 0) && (j == 0)) {
					fields[i][j].fillField(null, fields[i + 1][j], null,
							fields[i][j + 1], "Obere und linke Grenze");
				} else if ((i == 0) && (j < numberOfFields - 1)) {
					fields[i][j].fillField(null, fields[i + 1][j],
							fields[i][j - 1], fields[i][j + 1], "Obere Grenze");
				} else if ((i == 0) && (j == numberOfFields - 1)) {
					fields[i][j].fillField(null, fields[i + 1][j],
							fields[i][j - 1], null, "Obere und rechte Grenze");
				} else if (((i != 0) && (i < numberOfFields - 1)) && (j == 0)) {
					fields[i][j].fillField(fields[i - 1][j], fields[i + 1][j],
							null, fields[i][j + 1], "Linke Grenze");
				} else if ((i == numberOfFields - 1) && (j == 0)) {
					fields[i][j].fillField(fields[i - 1][j], null, null,
							fields[i][j + 1], "Linke und untere Grenze");
				} else if ((i == numberOfFields - 1)
						&& ((j != 0) && (j < numberOfFields - 1))) {
					fields[i][j]
							.fillField(fields[i - 1][j], null,
									fields[i][j - 1], fields[i][j + 1],
									"untere Grenze");
				} else if ((i == numberOfFields - 1)
						&& (j == numberOfFields - 1)) {
					fields[i][j].fillField(fields[i - 1][j], null,
							fields[i][j - 1], null, "Rechte und untere Grenze");
				} else if ((i < numberOfFields - 1)
						&& (j == numberOfFields - 1)) {
					fields[i][j].fillField(fields[i - 1][j], fields[i + 1][j],
							fields[i][j - 1], null, "Rechte Grenze");
				} else if ((i > 0) && (i < numberOfFields - 1)
						&& ((j > 0) && (j < numberOfFields - 1))) {
					fields[i][j].fillField(fields[i - 1][j], fields[i + 1][j],
							fields[i][j - 1], fields[i][j + 1], "Spielfeld");
				}
			}
		}

		pos = fields[0][0];
		int x, y;
		x = 30;
		for (int i = 0; i < numberOfFields; i++) {
			y = 30;
			for (int j = 0; j < numberOfFields; j++) {
				fields[i][j].setXY(y, x);
				y += 30;
			}
			x += 30;

		}

		fields[1][1].setIsFree(false);
		fields[1][3].setIsFree(false);
		fields[1][5].setIsFree(false);
		fields[1][7].setIsFree(false);

		fields[3][1].setIsFree(false);
		fields[3][3].setIsFree(false);
		fields[3][5].setIsFree(false);
		fields[3][7].setIsFree(false);

		fields[5][1].setIsFree(false);
		fields[5][3].setIsFree(false);
		fields[5][5].setIsFree(false);
		fields[5][7].setIsFree(false);

		fields[7][1].setIsFree(false);
		fields[7][3].setIsFree(false);
		fields[7][5].setIsFree(false);
		fields[7][7].setIsFree(false);
		/*
		 * for (int i = 0; i < numberOfFields; i++) {
		 * 
		 * for (int j = 0; j < numberOfFields; j++) {
		 * System.out.print(fields[i][j].getCoordl()); System.out.print('|');
		 * System.out.print(fields[i][j].getCoordt()); System.out.print(' '); }
		 * System.out.println(' '); }
		 */

	}

	public static Field getPos() {
		return pos;
	}

}
