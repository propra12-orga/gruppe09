/**
 * Last Author : Dirk Date: 21/05/12 Last Action: Diesen Kommentar hinzugefügt 
 */
package bomberman;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Border extends JPanel {
	private int positionX, positionY, speed;
	private Image picOfFigure;
	private UpdateFigureThread figureThread;

	public Border(int x, int y) {
		positionX = x;
		positionY = y;
		speed = 1;
		// figureThread = new UpdateFigureThread(this);
	}

	public void paint(Graphics g) {
		picOfFigure = Toolkit.getDefaultToolkit().getImage(
				this.getClass().getResource("grafics/map/block.png"));

		g.drawImage(picOfFigure, getPositionX(), getPositionY(), this);

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
}
