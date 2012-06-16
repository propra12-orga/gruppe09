/**
 * Last Author : Dirk Date: 04/06/12 Last Action: Move so bearbeitet, dass sich die Figur nun nicht mehr gegen die Spielinteren grenze steine steuern lässt!
 */
package bomberman;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Figure extends JPanel {
	private int positionX;
	private int positionY;
	private int speed;
	private Image picOfFigure;
	private UpdateFigureThread figureThread;

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
					this.getClass().getResource("grafics/player/3/down.png"));
		}
	}

	public void paint(Graphics g) {

		g.drawImage(picOfFigure, getPositionX(), getPositionY(), this);
		if (!figureThread.isAlive()) {
			figureThread.start();
		}
	}

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

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setPosition(int x, int y) {
		positionX = x;
		positionY = y;
	}

	public boolean IsAtLeftBorder() {
		if (positionX > 30) {
			return false;
		} else {
			return true;
		}

	}

	public boolean IsAtRightBorder() {
		if (positionX < 270) {
			return false;
		} else {
			return true;
		}

	}

	public boolean IsAtUpperBorder() {
		if (positionY > 30) {
			return false;
		} else {
			return true;
		}

	}

	public boolean IsAtBottomBorder() {
		if (positionY < 270) {
			return false;
		} else {
			return true;
		}

	}

}
