package bomberman;

import java.awt.Container;

/**
 * Die Klasse Bomberman initialisiert mindestens eine neue Figur und ihre
 * Position auf dem Spielfeld.
 * 
 * @author Lukas
 * @version 25/06/12
 * 
 * 
 */
public class Bomberman {
	static Figure figure1, figure2;
	static Enemy Enemy;

	static Spielgui gui;
	static Container contentPane;
	static Boolean Singleplayer, Multiplayer;
	static Menue Main;
	public static int numberOfFields = 9;// sollte immer ungerade sein

	/**
	 * Initialisiert ein neues Spielfeld und zwei neue Figuren.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Main = new Menue();
		Main.setVisible(true);
		Singleplayer = false;
		Multiplayer = false;

		figure1 = new Figure(30, 30, 0);
		Enemy = new Enemy(30, 210);
		figure2 = new Figure(270, 270, 1);

	}

	public static void InsertEnemys() {
		if (Multiplayer != true)
			gui.add(Enemy, 0);

		gui.setVisible(true);
	}

	/**
	 * Startet ein neues Spiel mit einem Spieler. Es wird zuerst eine Figur
	 * hinzugefügt und ihre Position ermittelt, bevor die Gui aufgebaut wird.
	 * 
	 */
	public static void starteSingleplayer() {
		gui = new Spielgui();
		gui.setVisible(false);
		Container contentPane = gui.getContentPane();
		contentPane.add(new MoveControl(figure1, figure2));
		gui.setVisible(true);

		gui.setVisible(false);
		gui.update(gui.getGraphics());
		InsertEnemys();
		gui.add(figure1, 0);
		Enemy.startmoving();
		resetPosition();
		resetPosition();
		Singleplayer = true;
		gui.setVisible(true);

	}

	/**
	 * Startet ein neues Spiel mit zwei Spielern.
	 */
	public static void starteMultiplayer() {
		if (gui == null)
			gui = new Spielgui();
		gui.setVisible(true);

		Container contentPane = gui.getContentPane();
		contentPane.add(new MoveControl(figure1, figure2));
		gui.setVisible(false);
		gui.update(gui.getGraphics());
		Multiplayer = true;
		starteSingleplayer();
		gui.add(figure2, 0);

		resetPositions();

		gui.setVisible(true);
	}

	/**
	 * Bestimmt die Position der Figur zum Spielanfang.
	 */
	private static void resetPosition() {
		figure1.setPosition(30, 30);
		Playground.setSpalte(1);
		Playground.setZeile(1);
	}

	/**
	 * Bestimmt die Positionen der beiden Figuren zum Spielanfang.
	 */
	static void resetPositions() {
		figure1.setPosition(30, 30);
		Playground.setSpalte(1);
		Playground.setZeile(1);
		figure2.setPosition(270, 270);
		Playground.setSpalte2(9);
		Playground.setZeile2(9);
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

	public static Figure GetFigure1() {
		return figure1;

	}

	public static Enemy GetEnemy() {
		return Enemy;

	}

	public static void OpenMainMenu() {
		Main.setVisible(true);

	}

	public static void CloseMainMenu() {
		Main.setVisible(false);
	}

	public static void CloseGame() {

		figure1.CloseFigureThread();
		figure2.CloseFigureThread();
		Enemy.stopthreads();
		gui.setVisible(false);

		Singleplayer = false;
		Multiplayer = false;

	}
}
