/**
 * Last Author : Dirk Date: 21/05/12 Last Action: Steuerung für die Figur hinzugefügt
 */
package bomberman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MoveControl extends JPanel implements KeyListener {
	private Figure figure1;
	private MoveThread moveLeftThread;
	private MoveThread moveRightThread;
	private MoveThread moveUpThread;
	private MoveThread moveDownThread;

	private Field POS;

	public MoveControl(Figure figure1) {
		this.figure1 = figure1;
		addKeyListener(this);
		POS = Bomberman.GetPos();
	}

	public void keyPressed(KeyEvent evt) {
		int keyCode = evt.getKeyCode();
		if (keyCode == KeyEvent.VK_LEFT) {// Startet die MoveThreads für linke
											// Bewegungsrichtung

			// Kann später im Spieler zusammen gefasst werden
			if (POS.getLeftNeighbour()) {
				if (moveLeftThread == null) {
					moveLeftThread = new MoveThread(this.figure1, "left");
					moveLeftThread.start();
				}
				if (!moveLeftThread.isAlive()) {
					moveLeftThread = new MoveThread(this.figure1, "left");
					moveLeftThread.start();
				}

				POS = POS.getLeft();
				String str;
				str = (String) POS.GetSpeicher();
				System.out.println(str);
			} else
				System.out.println("Grenze erreicht, es geht nicht weiter");
			// System.out.println("Links");
		}
		if (keyCode == KeyEvent.VK_RIGHT) {// Startet die MoveThreads für rechte
											// Bewegungsrichtung

			if (POS.getRightNeighbour()) {
				if (moveRightThread == null) {
					moveRightThread = new MoveThread(this.figure1, "right");
					moveRightThread.start();
				}
				if (!moveRightThread.isAlive()) {

					moveRightThread = new MoveThread(this.figure1, "right");

					moveRightThread.start();
				}// Kann später im Spieler zusammen gefasst werden
				POS = POS.getRight();
				String str;
				str = (String) POS.GetSpeicher();
				System.out.println(str);
			} else
				System.out.println("Grenze erreicht, es geht nicht weiter");

			// System.out.println("Rechts");
		}
		if (keyCode == KeyEvent.VK_UP) {// Startet die MoveThreads für obere
										// Bewegungsrichtung

			// Kann später im Spieler zusammen gefasst werden
			if (POS.getTopNeighbour()) {
				if (moveUpThread == null) {
					moveUpThread = new MoveThread(this.figure1, "up");
					moveUpThread.start();
				}
				if (!moveUpThread.isAlive()) {

					moveUpThread = new MoveThread(this.figure1, "up");

					moveUpThread.start();
				}
				POS = POS.getTop();
				String str;
				str = (String) POS.GetSpeicher();
				System.out.println(str);
			} else
				System.out.println("Grenze erreicht, es geht nicht weiter");
			// System.out.println("Oben");
		}
		if (keyCode == KeyEvent.VK_DOWN) {// Startet die MoveThreads für untere
											// Bewegungsrichtung

			// Kann später im Spieler zusammen gefasst werden
			if (POS.getBottomNeighbour()) {
				if (moveDownThread == null) {
					moveDownThread = new MoveThread(this.figure1, "down");
					moveDownThread.start();
				}
				if (!moveDownThread.isAlive()) {

					moveDownThread = new MoveThread(this.figure1, "down");

					moveDownThread.start();
				}
				POS = POS.getBottom();
				String str;
				str = (String) POS.GetSpeicher();
				System.out.println(str);
			} else
				System.out.println("Grenze erreicht, es geht nicht weiter");
			// System.out.println("Unten");
		}

	}

	public void keyReleased(KeyEvent evt) {// Beendet die eben gestarteten
											// MoveThreads
		int keyCode = evt.getKeyCode();
		if (keyCode == KeyEvent.VK_LEFT) {
			moveLeftThread.interrupt();

		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			moveRightThread.interrupt();

		}
		if (keyCode == KeyEvent.VK_UP) {
			moveUpThread.interrupt();

		}
		if (keyCode == KeyEvent.VK_DOWN) {
			moveDownThread.interrupt();

		}
	}

	public void keyTyped(KeyEvent evt) {
	}

	public boolean isFocusTraversable() {
		return true;
	}

}
