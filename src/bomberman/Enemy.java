package bomberman;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

/**
 * Die Klasse ist für die KI Gegner. Andere werden von der Enemy-Klasse beerbt
 * 
 * 
 * @author Lukas
 * @version 01/07/12
 */

public class Enemy extends JPanel {
	private int positionX;
	private int positionY;
	private int speed;
	private Image picOfFigure;
	private EnemyUpdateThread figureThread;
	private MoveEnemyThread EnemyMoveThread;
	private String Direction;

	/**
	 * Klassenkontruktor
	 * 
	 * @param x
	 *            Aktuelle Position auf der x-Achse
	 * @param y
	 *            Aktuelle Position auf der y-Achse
	 * @param c
	 */
	public Enemy(int x, int y) {
		positionX = x;
		positionY = y;
		speed = 1;
		figureThread = new EnemyUpdateThread(this);
		EnemyMoveThread = new MoveEnemyThread(this);
		Direction = "Down";

		picOfFigure = Toolkit.getDefaultToolkit().getImage(
				this.getClass().getResource("grafics/player/2/down.png"));

	}

	/**
	 * Die Methode paint stellt fest, ob die Figur existiert und gibt die Figur
	 * an einer bestimmten Stelle wieder.
	 */
	public void paint(Graphics g) {

		g.drawImage(picOfFigure, getPositionX(), getPositionY(), this);
		if (!figureThread.isAlive()) {
			figureThread.start();
		}
	}

	/**
	 * Gibt Position der Figur auf der x-Achse zurück.
	 * 
	 * @return positionX
	 */
	public int getPositionX() {
		return positionX;
	}

	/**
	 * Gibt Position der Figur auf der y-Achse zurück.
	 * 
	 * @return positionY
	 */
	public int getPositionY() {
		return positionY;
	}

	/**
	 * Berechnet die Position der Figur auf der x-Achse und der y-Achse.
	 * 
	 * @param x
	 *            Position auf der x-Achse.
	 * @param y
	 *            Position auf der y-Achse.
	 */
	public void setPosition(int x, int y) {
		positionX = x;
		positionY = y;
	}

	public void move() {
		if (Direction == "Down") {
			if (Playground.field[(positionX / 30)][(positionY / 30) + 1]
					.isaccessible()) {
				positionY += 30;
			} else
				Direction = setDirection();
		}

		else if (Direction == "Up") {
			if (Playground.field[(positionX / 30)][(positionY / 30) - 1]
					.isaccessible()) {
				positionY -= 30;
			} else
				Direction = setDirection();
		} else if (Direction == "Left") {
			if (Playground.field[(positionX / 30) - 1][(positionY / 30)]
					.isaccessible()) {
				positionX -= 30;
			} else
				Direction = setDirection();
		} else if (Direction == "Right") {
			if (Playground.field[(positionX / 30) + 1][(positionY / 30)]
					.isaccessible()) {
				positionX += 30;
			} else
				Direction = setDirection();
		}

	}

	public String setDirection() {
		int rand = (int) (Math.random() * 4) + 1;
		// System.out.println(rand);
		if (rand == 1)
			return "Left";
		else if (rand == 2)
			return "Right";
		else if (rand == 3)
			return "Up";
		else
			return "Down";

	}

	public void startmoving() {
		EnemyMoveThread.start();
	}

	public void stopthreads() {
		EnemyMoveThread.interrupt();
		figureThread.interrupt();
	}

}
