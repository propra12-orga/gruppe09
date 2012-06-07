/**
 * Last Author : Dirk Date: 04/06/12 Last Action: ResettPosition zu setPosition umgeschrieben
 */
package bomberman;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Figure2 extends JPanel {
	private static int positionX;
	private static int positionY;
	private int speed;
	private Image picOfFigure;
	private UpdateThreadFigure2 figureThread;

	public Figure2(int x, int y) {
		positionX = x;
		positionY = y;
		speed = 1;
		figureThread = new UpdateThreadFigure2(this);
	}

	public void paint(Graphics g) {
		picOfFigure = Toolkit.getDefaultToolkit().getImage(
				this.getClass().getResource("grafics/player/3/down.png"));

		g.drawImage(picOfFigure, getPositionX(), getPositionY(), this);
		if (!figureThread.isAlive()) {
			figureThread.start();
		}
	}

	public void move(String direction) {
		if (direction == "left") {
			positionX -= 1;
		} else if (direction == "right") {
			positionX += 1;
		} else if (direction == "up") {
			positionY -= 1;
		} else {
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
}
