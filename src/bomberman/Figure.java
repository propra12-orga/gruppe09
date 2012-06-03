/**
 * Last Author : Natalie Date: 03/06/12 Last Action: ResettPosition eingefügt, setzt die Figur wieder auf 50/50 also startwert
 * Methode plantBomb() eingefuegt
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
			positionX -= 8;
		} else if (direction == "right") {
			positionX += 11;
		} else if (direction == "up") {
			positionY -= 8;
		} else {
			positionY += 8;
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

	public static void ResetPosition() {
		positionX = 50;
		positionY = 50;
	}

	public String plantBomb(Bomb bomb) {
		return("plantBomb" + bomb.case_x + "#" + bomb.case_y +"#"+ bomb.radius);
		
	}
}
