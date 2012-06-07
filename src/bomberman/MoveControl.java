/**
 * Last Author : Dirk Date: 04/06/12 Last Action: MoveThread wird nun nur beendet, wenn er auch existiert
 */
package bomberman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MoveControl extends JPanel implements KeyListener {
	private Figure figure1;
	private Figure2 figure2;
	private MoveThread moveLeftThread;
	private MoveThread moveRightThread;
	private MoveThread moveUpThread;
	private MoveThread moveDownThread;
	private MoveThreadFigure2 moveLeftThreadFigure2;
	private MoveThreadFigure2 moveRightThreadFigure2;
	private MoveThreadFigure2 moveUpThreadFigure2;
	private MoveThreadFigure2 moveDownThreadFigure2;

	private Field POS;

	public MoveControl(Figure figure1, Figure2 figure2) {
		this.figure1 = figure1;
		this.figure2 = figure2;
		addKeyListener(this);
		POS = Bomberman.getPos();
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

		if (keyCode == KeyEvent.VK_A) {// Startet die MoveThreads für linke
			// Bewegungsrichtung
			if (moveLeftThreadFigure2 == null) {
				moveLeftThreadFigure2 = new MoveThreadFigure2(this.figure2,
						"left");
				moveLeftThreadFigure2.start();
			}
			if (!moveLeftThreadFigure2.isAlive()) {
				moveLeftThreadFigure2 = new MoveThreadFigure2(this.figure2,
						"left");
				moveLeftThreadFigure2.start();
			}
			System.out.println("Links");
		}
		if (keyCode == KeyEvent.VK_D) {// Startet die MoveThreads für linke
			// Bewegungsrichtung
			if (moveRightThreadFigure2 == null) {
				moveRightThreadFigure2 = new MoveThreadFigure2(this.figure2,
						"right");
				moveRightThreadFigure2.start();
			}
			if (!moveRightThreadFigure2.isAlive()) {
				moveRightThreadFigure2 = new MoveThreadFigure2(this.figure2,
						"right");
				moveRightThreadFigure2.start();
			}
			System.out.println("Rechts");
		}
		if (keyCode == KeyEvent.VK_W) {// Startet die MoveThreads für linke
			// Bewegungsrichtung
			if (moveUpThreadFigure2 == null) {
				moveUpThreadFigure2 = new MoveThreadFigure2(this.figure2, "up");
				moveUpThreadFigure2.start();
			}
			if (!moveUpThreadFigure2.isAlive()) {
				moveUpThreadFigure2 = new MoveThreadFigure2(this.figure2, "up");
				moveUpThreadFigure2.start();
			}
			System.out.println("Oben");
		}
		if (keyCode == KeyEvent.VK_S) {// Startet die MoveThreads für linke
			// Bewegungsrichtung
			if (moveDownThreadFigure2 == null) {
				moveDownThreadFigure2 = new MoveThreadFigure2(this.figure2,
						"down");
				moveDownThreadFigure2.start();
			}
			if (!moveDownThreadFigure2.isAlive()) {
				moveDownThreadFigure2 = new MoveThreadFigure2(this.figure2,
						"down");
				moveDownThreadFigure2.start();
			}

			System.out.println("Unten");
		}
	}

	public void keyReleased(KeyEvent evt) {// Beendet die eben gestarteten
											// MoveThreads
		int keyCode = evt.getKeyCode();
		if (keyCode == KeyEvent.VK_LEFT) {
			if (moveLeftThread != null) {
				moveLeftThread.interrupt();
			}
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			if (moveRightThread != null) {
				moveRightThread.interrupt();
			}
		}
		if (keyCode == KeyEvent.VK_UP) {
			if (moveUpThread != null) {
				moveUpThread.interrupt();
			}
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			if (moveDownThread != null) {
				moveDownThread.interrupt();
			}
		}

		if (keyCode == KeyEvent.VK_A) {
			if (moveLeftThreadFigure2 != null) {
				moveLeftThreadFigure2.interrupt();
			}
		}
		if (keyCode == KeyEvent.VK_D) {
			if (moveRightThreadFigure2 != null) {
				moveRightThreadFigure2.interrupt();
			}
		}
		if (keyCode == KeyEvent.VK_W) {
			if (moveUpThreadFigure2 != null) {
				moveUpThreadFigure2.interrupt();
			}
		}
		if (keyCode == KeyEvent.VK_S) {
			if (moveDownThreadFigure2 != null) {
				moveDownThreadFigure2.interrupt();
			}
		}
	}

	public void keyTyped(KeyEvent evt) {
	}

	public boolean isFocusTraversable() {
		return true;
	}

}
