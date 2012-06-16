/**
 * Last Author : Dirk Date: 09/06/12 Last Action: Es wird nun die Collision der Spielinternen grenzsteine unter initalize festgelegt
 */
package bomberman;

import java.awt.Container;

public class Bomberman {
	static Figure figure1, figure2;

	static Gui gui;
	static Container contentPane;
	public static int numberOfFields = 9;// sollte immer ungerade sein

	public static void main(String[] args) {
		gui = new Gui();
		gui.setVisible(true);
		figure1 = new Figure(30, 30, 0);
		figure2 = new Figure(270, 270, 1);

		Container contentPane = gui.getContentPane();
		contentPane.add(new MoveControl(figure1, figure2));

	}

	public static void starteSingleplayer() {
		gui.setVisible(false);
		// OpenWindow.setVisible(false);
		gui.update(gui.getGraphics());
		gui.add(figure1, 0);
		resetPosition();

		gui.setVisible(true);
	}

	public static void starteMultiplayer() {
		gui.setVisible(false);
		gui.update(gui.getGraphics());
		starteSingleplayer();
		gui.add(figure2, 0);

		resetPositions();

		gui.setVisible(true);
	}

	private static void resetPosition() {
		figure1.setPosition(30, 30);
		// fields muss hier noch zurueck gesetzt werden
	}

	private static void resetPositions() {
		figure1.setPosition(30, 30);
		figure2.setPosition(270, 270);
		// fields muss hier noch zurueck gesetzt werden
	}

}
