/**
 * Last Author : Dirk Date: 04/06/12 Last Action: Move so bearbeitet, dass sich die Figur nun nicht mehr gegen die Spielinteren grenze steine steuern lässt!
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
		POS = Bomberman.getPos();
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

			if (POS.getLeftNeighbour()) {
				if (POS.getX() == 60) {
					if (positionX == POS.getLeft().getX()) {
						System.out.println("Position gewechselt!");
						System.out.println("Alte Position:");
						System.out.print(POS.getX());
						System.out.print('|');
						System.out.print(POS.getY());
						POS = POS.getLeft();
						System.out.println("Neue Position:");
						System.out.print(POS.getX());
						System.out.print('|');
						System.out.print(POS.getY());
					}
				} else {
					if (positionX == POS.getX()) {
						System.out.println("Position gewechselt!");
						System.out.println("Alte Position:");
						System.out.print(POS.getX());
						System.out.print('|');
						System.out.print(POS.getY());
						POS = POS.getLeft();
						System.out.println("Neue Position:");
						System.out.print(POS.getX());
						System.out.print('|');
						System.out.print(POS.getY());
					}
				}
			}

			if (IsAtLeftBorder() == false) {

				if (POS.getLeft() != null) {
					if (POS.getLeft().IsFree() == true) {
						positionX -= 1;
					}
				}
			}
		} else if (direction == "right") {

			if (POS.getRightNeighbour()) {
				if (positionX == POS.getRight().getX()) {
					System.out.println("Position gewechselt!");
					System.out.println("Alte Position:");
					System.out.print(POS.getX());
					System.out.print('|');
					System.out.print(POS.getY());
					POS = POS.getRight();
					System.out.println("Neue Position:");
					System.out.print(POS.getX());
					System.out.print('|');
					System.out.print(POS.getY());
				}
			}

			if (IsAtRightBorder() == false) {

				if (POS.getRight().IsFree() == true) {
					positionX += 1;
				}
			}
		} else if (direction == "up") {

			if (POS.getTopNeighbour()) {

				if (POS.getY() == 60) {
					if (positionY == POS.getTop().getY()) {
						System.out.println("Position gewechselt!");
						System.out.println("Alte Position:");
						System.out.print(POS.getX());
						System.out.print('|');
						System.out.print(POS.getY());
						POS = POS.getTop();
						System.out.println("Neue Position:");
						System.out.print(POS.getX());
						System.out.print('|');
						System.out.print(POS.getY());
					}
				} else {
					if (positionY == POS.getY()) {
						System.out.println("Position gewechselt!");
						System.out.println("Alte Position:");
						System.out.print(POS.getX());
						System.out.print('|');
						System.out.print(POS.getY());
						POS = POS.getTop();
						System.out.println("Neue Position:");
						System.out.print(POS.getX());
						System.out.print('|');
						System.out.print(POS.getY());
					}
				}
			}
			if (IsAtUpperBorder() == false)
				if (POS.getTop().IsFree() == true) {
					positionY -= 1;
				}
		} else {
			if (POS.getBottomNeighbour()) {

				if (positionY == POS.getBottom().getY()) {
					System.out.println("Position gewechselt!");
					System.out.println("Alte Position:");
					System.out.print(POS.getX());
					System.out.print('|');
					System.out.print(POS.getY());
					POS = POS.getBottom();
					System.out.println("Neue Position:");
					System.out.print(POS.getX());
					System.out.print('|');
					System.out.print(POS.getY());
				}
			}
			if (IsAtBottomBorder() == false)
				if (POS.getBottom().IsFree() == true) {
					positionY += 1;
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
