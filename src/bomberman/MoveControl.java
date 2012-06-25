/**
 * Last Author : Dirk Date: 04/06/12 Last Action: MoveThread wird nun nur beendet, wenn er auch existiert
 */
package bomberman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.JPanel;

/**
 * Die Klasse steuert die Figur(en).
 * 
 * @author Natalie
 * @version 17/06/12
 * 
 */
public class MoveControl extends JPanel implements KeyListener {

	private Figure figure1;
	private Figure figure2;
	private stargate OpenWindow;
	Timer timer = new Timer();

	public MoveControl(Figure figure1, Figure figure2) {
		this.figure1 = figure1;
		this.figure2 = figure2;
		addKeyListener(this);

	}

	/**
	 * Die Methode keyPressed verarbeitet den eigegebenen Befehl. Dafür wird die
	 * Position des Feldes ermittelt sowie ob es sich dabei um ein begehbares
	 * Feld handelt. Ist das zu betretende Feld das Portal, so ist das Spiel
	 * gewonnen, andernfalls bewegt sich die Figur um ein Feld nach rechts,
	 * links, oben oder unten. In den letzten 4 if-Anweisungen werden die
	 * MoveThreads für Bewegungsrichtungen gestartet.
	 */
	public void keyPressed(KeyEvent evt) {

		int keyCode = evt.getKeyCode();
		// Steuerung für Figur1
		if ((Bomberman.IsSingleplayer()) || (Bomberman.IsMultiplayer())) {
			if ((keyCode == KeyEvent.VK_LEFT)
					&& (Playground.field[Playground.getSpalte() - 1][Playground
							.getZeile()].isaccessible())) {// Startet die
				// MoveThreads
				if (Playground.field[Playground.getSpalte() - 1][Playground
						.getZeile()].isStargate()) {
					EndGame.EndtheGame(true, false, false, false);
				}
				figure1.move("left");
				Playground.setSpalte(Playground.getSpalte() - 1);
				System.out.print(Playground.getSpalte());
				System.out.print('|');
				System.out.print(Playground.getZeile());
				System.out.println(' ');

			}
			// System.out.println("Links");

			if ((keyCode == KeyEvent.VK_RIGHT)
					&& (Playground.field[Playground.getSpalte() + 1][Playground
							.getZeile()].isaccessible())) // Bewegungsrichtung
			{
				if (Playground.field[Playground.getSpalte() + 1][Playground
						.getZeile()].isStargate()) {
					EndGame.EndtheGame(true, false, false, false);
				}
				figure1.move("right");
				Playground.setSpalte(Playground.getSpalte() + 1);
				System.out.print(Playground.getSpalte());
				System.out.print('|');
				System.out.print(Playground.getZeile());
				System.out.println(' ');

			}

			if ((keyCode == KeyEvent.VK_UP)
					&& (Playground.field[Playground.getSpalte()][Playground
							.getZeile() - 1].isaccessible())) {// Startet die
				// MoveThreads für obere
				// Bewegungsrichtung
				if (Playground.field[Playground.getSpalte()][Playground
						.getZeile() - 1].isStargate()) {
					EndGame.EndtheGame(true, false, false, false);
				}
				figure1.move("up");
				Playground.setZeile(Playground.getZeile() - 1);
				System.out.print(Playground.getSpalte());
				System.out.print('|');
				System.out.print(Playground.getZeile());
				System.out.println(' ');

				// else
				// System.out.println("Grenze erreicht, es geht nicht weiter");
				// System.out.println("Oben");
			}

			if ((keyCode == KeyEvent.VK_DOWN)
					&& (Playground.field[Playground.getSpalte()][Playground
							.getZeile() + 1].isaccessible())) {
				if (Playground.field[Playground.getSpalte()][Playground
						.getZeile() + 1].isStargate()) {
					EndGame.EndtheGame(true, false, false, false);
				}
				figure1.move("down");
				Playground.setZeile(Playground.getZeile() + 1);
				System.out.print(Playground.getSpalte());
				System.out.print('|');
				System.out.print(Playground.getZeile());
				System.out.println(' ');

			}

			if (keyCode == KeyEvent.VK_Z) {
				SaveLoad.Load(figure1);
			}

			if (keyCode == KeyEvent.VK_ENTER) {
				if (!Playground.field[Playground.getSpalte()][Playground
						.getZeile()].isStargate()) {
					SettingProperties.bomb1(Playground.getSpalte(),
							Playground.getZeile());

					timer.schedule(new BombTimer(2, Playground.getSpalte(),
							Playground.getZeile()), 1500);
				}

			}
		}

		// Ab hier beginnt die steuerung für Figur 2
		if (Bomberman.IsMultiplayer()) {
			if ((keyCode == KeyEvent.VK_A)
					&& (Playground.field[Playground.getSpalte2() - 1][Playground
							.getZeile2()].isaccessible())) {// Startet die
				// MoveThreads
				if (Playground.field[Playground.getSpalte2() - 1][Playground
						.getZeile2()].isStargate()) {
					// stargate endgame = new stargate(1);
				}
				figure2.move("left");
				Playground.setSpalte2(Playground.getSpalte2() - 1);
				System.out.println("Links");
				System.out.print(Playground.getSpalte2());
				System.out.print('|');
				System.out.print(Playground.getZeile2());
				System.out.println(' ');
			}
			if ((keyCode == KeyEvent.VK_D)
					&& (Playground.field[Playground.getSpalte2() + 1][Playground
							.getZeile2()].isaccessible())) // Bewegungsrichtung
			{
				if (Playground.field[Playground.getSpalte2() + 1][Playground
						.getZeile2()].isStargate()) {
					// stargate endgame = new stargate(1);
				}
				figure2.move("right");
				Playground.setSpalte2(Playground.getSpalte2() + 1);
				System.out.println("Rechts");
				System.out.print(Playground.getSpalte2());
				System.out.print('|');
				System.out.print(Playground.getZeile2());
				System.out.println(' ');
			}
			if ((keyCode == KeyEvent.VK_W)
					&& (Playground.field[Playground.getSpalte2()][Playground
							.getZeile2() - 1].isaccessible())) {// Startet die
				// MoveThreads für obere
				// Bewegungsrichtung
				if (Playground.field[Playground.getSpalte2()][Playground
						.getZeile2() - 1].isStargate()) {
					// stargate endgame = new stargate(1);
				}
				figure2.move("up");
				Playground.setZeile2(Playground.getZeile2() - 1);
				System.out.println("Oben");
				System.out.print(Playground.getSpalte2());
				System.out.print('|');
				System.out.print(Playground.getZeile2());
				System.out.println(' ');
			}
			if ((keyCode == KeyEvent.VK_S)
					&& (Playground.field[Playground.getSpalte2()][Playground
							.getZeile2() + 1].isaccessible())) {
				if (Playground.field[Playground.getSpalte2()][Playground
						.getZeile2() + 1].isStargate()) {
					// stargate endgame = new stargate(1);
				}
				figure2.move("down");
				Playground.setZeile2(Playground.getZeile2() + 1);
				System.out.println("Unten");
				System.out.print(Playground.getSpalte2());
				System.out.print('|');
				System.out.print(Playground.getZeile2());
				System.out.println(' ');
			}

			if (keyCode == KeyEvent.VK_R) {
				if (!Playground.field[Playground.getSpalte2()][Playground
						.getZeile2()].isStargate()) {
					SettingProperties.bomb1(Playground.getSpalte2(),
							Playground.getZeile2());

					timer.schedule(new BombTimer(1, Playground.getSpalte2(),
							Playground.getZeile2()), 1500);
				}
			}
		}

	}

	/**
	 * Beendet die gestarteten MoveThreads.
	 */
	public void keyReleased(KeyEvent evt) {
	}

	public void keyTyped(KeyEvent evt) {
	}

	public boolean isFocusTraversable() {
		return true;
	}

}
