/**
 * Last Author : Dirk Date: 04/06/12 Last Action: MoveThread wird nun nur beendet, wenn er auch existiert
 */
package bomberman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * Die Klasse steuert die Figur(en). 
 * @author Natalie
 * @version 17/06/12
 *
 */
public class MoveControl extends JPanel implements KeyListener {

	private Figure figure1;
	private Figure figure2;
	private stargate OpenWindow;

	public MoveControl(Figure figure1, Figure figure2) {
		this.figure1 = figure1;
		this.figure2 = figure2;
		addKeyListener(this);

	}

	/**
	 * Die Methode keyPressed verarbeitet den eigegebenen Befehl. Dafür wird die Position 
	 * des Feldes ermittelt sowie ob es sich dabei um ein begehbares Feld handelt. 
	 * Ist das zu betretende Feld das Portal, so ist das Spiel gewonnen, 
	 * andernfalls bewegt sich die Figur um ein Feld nach rechts, links, oben oder
	 * unten. 
	 * In den letzten 4 if-Anweisungen werden die MoveThreads für Bewegungsrichtungen
	 * gestartet.
	 */
	public void keyPressed(KeyEvent evt) {

		int keyCode = evt.getKeyCode();
		if ((keyCode == KeyEvent.VK_LEFT)
				&& (Playground.field[Playground.getZeile()][Playground
						.getSpalte() - 1].isaccessible())) {// Startet die
															// MoveThreads
			if (Playground.field[Playground.getZeile()][Playground.getSpalte() - 1]
					.isStargate()) {
				stargate endgame = new stargate();
			}
			figure1.move("left");
			Playground.setSpalte(Playground.getSpalte() - 1);
		}
		// System.out.println("Links");

		if ((keyCode == KeyEvent.VK_RIGHT)
				&& (Playground.field[Playground.getZeile()][Playground
						.getSpalte() + 1].isaccessible())) // Bewegungsrichtung
		{
			if (Playground.field[Playground.getZeile()][Playground.getSpalte() + 1]
					.isStargate()) {
				stargate endgame = new stargate();
			}
			figure1.move("right");
			Playground.setSpalte(Playground.getSpalte() + 1);

		}

		if ((keyCode == KeyEvent.VK_UP)
				&& (Playground.field[Playground.getZeile() - 1][Playground
						.getSpalte()].isaccessible())) {// Startet die
														// MoveThreads für obere
			// Bewegungsrichtung
			if (Playground.field[Playground.getZeile() - 1][Playground
					.getSpalte()].isStargate()) {
				stargate endgame = new stargate();
			}
			figure1.move("up");
			Playground.setZeile(Playground.getZeile() - 1);

			// else
			// System.out.println("Grenze erreicht, es geht nicht weiter");
			// System.out.println("Oben");
		}

		if ((keyCode == KeyEvent.VK_DOWN)
				&& (Playground.field[Playground.getZeile() + 1][Playground
						.getSpalte()].isaccessible())) {
			if (Playground.field[Playground.getZeile() + 1][Playground
					.getSpalte()].isStargate()) {
				stargate endgame = new stargate();
			}
			figure1.move("down");
			Playground.setZeile(Playground.getZeile() + 1);

		}

		if (keyCode == KeyEvent.VK_Z) {
			for (int i = 0; i != 10; i++) {
				for (int j = 0; j != 10; j++) {
					if (Playground.field[i][j].isHiddenstargate() == true)
						SettingProperties.stargate(j, i);
				}
			}
		}
		
		if (keyCode == KeyEvent.VK_A) { //Startet die MoveThreads für die linke
			//Bewegungsrichtung. 
			figure2.move("left");
			System.out.println("Links");
		}
		if (keyCode == KeyEvent.VK_D) {// Startet die MoveThreads für rechte
			// Bewegungsrichtung
			figure2.move("right");
			System.out.println("Rechts");
		}
		if (keyCode == KeyEvent.VK_W) {// Startet die MoveThreads für linke
			// Bewegungsrichtung
			figure2.move("up");
			System.out.println("Oben");
		}
		if (keyCode == KeyEvent.VK_S) {// Startet die MoveThreads für linke
			// Bewegungsrichtung
			figure2.move("down");
			System.out.println("Unten");
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
