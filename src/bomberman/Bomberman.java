/**
 * @author Dirk 
 * @version 09/06/12 Last Action: Es wird nun die Collision der Spielinternen grenzsteine unter initalize festgelegt
 */
package bomberman;

import java.awt.Container;

/**
 * Die Klasse Bomberman initialisiert mindestens eine neue Figur und ihre
 * Position auf dem Spielfeld.
 * 
 * @author Natalie
 * @version 17/06/12
 * 
 * 
 */
public class Bomberman {
	static Figure figure1, figure2;

	static Gui gui;
	static Container contentPane;
	static Boolean Singleplayer, Multiplayer;
	public static int numberOfFields = 9;// sollte immer ungerade sein

	/**
	 * Initialisiert ein neues Spielfeld und zwei neue Figuren.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		gui = new Gui();
		gui.setVisible(true);
		figure1 = new Figure(30, 30, 0);
		figure2 = new Figure(270, 270, 1);
		Singleplayer = false;
		Multiplayer = false;

		Container contentPane = gui.getContentPane();
		contentPane.add(new MoveControl(figure1, figure2));

	}

	/**
	 * Startet ein neues Spiel mit einem Spieler. Es wird zuerst eine Figur
	 * hinzugefügt und ihre Position ermittelt, bevor die Gui aufgebaut wird.
	 * 
	 */
	public static void starteSingleplayer() {
		gui.setVisible(false);
		gui.update(gui.getGraphics());
		gui.add(figure1, 0);
		resetPosition();
		Singleplayer = true;
		gui.setVisible(true);
	}

	/**
	 * Startet ein neues Spiel mit zwei Spielern.
	 */
	public static void starteMultiplayer() {
		gui.setVisible(false);
		gui.update(gui.getGraphics());
		starteSingleplayer();
		gui.add(figure2, 0);
		Singleplayer = false;
		Multiplayer = true;

		resetPositions();

		gui.setVisible(true);
	}

	/**
	 * Bestimmt die Position der Figur zum Spielanfang.
	 */
	private static void resetPosition() {
		figure1.setPosition(30, 30);
		// fields muss hier noch zurueck gesetzt werden
	}

	/**
	 * Bestimmt die Positionen der beiden Figuren zum Spielanfang.
	 */
	static void resetPositions() {
		figure1.setPosition(30, 30);
		figure2.setPosition(270, 270);
		// fields muss hier noch zurueck gesetzt werden
	}

	public static boolean IsSingleplayer() {
		if (Singleplayer == true)
			return true;
		else
			return false;

	}

	public static boolean IsMultiplayer() {
		if (Multiplayer == true)
			return true;
		else
			return false;

	}
}
