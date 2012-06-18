/**
 * @author Dirk 
 * @version 04/06/12 Last Action: Move so bearbeitet, dass sich die Figur nun nicht mehr gegen die Spielinteren grenze steine steuern lässt!
 */
package bomberman;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

/**
 * Die Klasse repräsentiert die Spielerfigur. Klassenvariablen werden
 * initialisiert.
 * 
 * @author Natalie
 * @version 17/06/12
 */

public class Figure extends JPanel {
	private int positionX;
	private int positionY;
	private int speed;
	private Image picOfFigure;
	private UpdateFigureThread figureThread;

	/**
	 * Klassenkontruktor
	 * 
	 * @param x
	 *            Aktuelle Position auf der x-Achse
	 * @param y
	 *            Aktuelle Position auf der y-Achse
	 * @param c
	 */
	public Figure(int x, int y, int c) {
		positionX = x;
		positionY = y;
		speed = 1;
		figureThread = new UpdateFigureThread(this);
		if (c == 0) {
			picOfFigure = Toolkit.getDefaultToolkit().getImage(
					this.getClass().getResource("grafics/player/1/down.png"));
		} else if (c == 1) {
			picOfFigure = Toolkit.getDefaultToolkit().getImage(
					this.getClass().getResource("grafics/player/4/down.png"));
		}
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
	 * Die Methode move regelt die Bewegung der Spielerfigur(en). Es wird zuerst
	 * die eingebene Richtung überprüft, dann, ob es sich bei dem nächsten Feld
	 * um eine Grenze handelt und falls die nicht zutrifft, wird die Figur auf
	 * dieses Feld bewegt.
	 * 
	 * @param direction
	 *            Eingebene Richtung.
	 */
	public void move(String direction) {

		if (direction == "left") {
			if (IsAtLeftBorder() == false) {

				positionX -= 30;

			}

		} else if (direction == "right") {

			if (IsAtRightBorder() == false) {

				{
					positionX += 30;
				}
			}

		} else if (direction == "up") {

			if (IsAtUpperBorder() == false) {
				positionY -= 30;
			}

		} else {

			if (IsAtBottomBorder() == false) {
				positionY += 30;
			}

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
	 * Gibt die Geschwindigkeit der Figur zurück.
	 * 
	 * @return speed
	 */
	public int getSpeed() {
		return speed;
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

	/**
	 * Überprüft, ob es sich bei einer Position um eine Feldgrenze handelt.
	 * 
	 * @return true oder false
	 */
	public boolean IsAtLeftBorder() {
		if (positionX > 30) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Überprüft, ob es sich bei einer Position um eine Feldgrenze handelt.
	 * 
	 * @return true oder false
	 */
	public boolean IsAtRightBorder() {
		if (positionX < 270) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Überprüft, ob es sich bei einer Position um eine Feldgrenze handelt.
	 * 
	 * @return true oder false
	 */
	public boolean IsAtUpperBorder() {
		if (positionY > 30) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Überprüft, ob es sich bei einer Position um eine Feldgrenze handelt.
	 * 
	 * @return true oder false
	 */
	public boolean IsAtBottomBorder() {
		if (positionY < 270) {
			return false;
		} else {
			return true;
		}

	}

}
