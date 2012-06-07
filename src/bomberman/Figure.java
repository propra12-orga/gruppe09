/**
 * Last Author : Dirk Date: 04/06/12 Last Action: ResettPosition zu setPosition umgeschrieben
 */
package bomberman;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Figure extends JPanel {
	private static int positionX;
	private static int positionY;
	private int speed;
	private Field POS;
	private Image picOfFigure;
	private UpdateFigureThread figureThread;

	public Figure(int x, int y) {
		positionX = x;
		positionY = y;
		speed = 1;
		figureThread = new UpdateFigureThread(this);
	}

	public void paint(Graphics g) {
		picOfFigure = Toolkit.getDefaultToolkit().getImage(
				this.getClass().getResource("grafics/player/1/down.png"));

		g.drawImage(picOfFigure, getPositionX(), getPositionY(), this);
		if (!figureThread.isAlive()) {
			figureThread.start();
		}
	}

	public void move(String direction) {

		if (direction == "left") {
			if (IsAtLeftBorder() == false) {
				positionX -= 1;
			}

		} else if (direction == "right") {
			if (IsAtRightBorder() == false) {
				positionX += 1;
			}
		} else if (direction == "up") {

			if (IsAtUpperBorder() == false)
				positionY -= 1;
		} else {

			if (IsAtBottomBorder() == false)
				positionY += 1;

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

	public static void setPosition(int x, int y) {
		positionX = x;
		positionY = y;
	}

	public String plantBomb(Bomb bomb) {
		return ("plantBomb" + bomb.case_x + "#" + bomb.case_y + "#" + bomb.radius);

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

	public Field getPOS() {
		return POS;
	}

	public void setPOS(Field pOS) {
		POS = pOS;
	}

}
