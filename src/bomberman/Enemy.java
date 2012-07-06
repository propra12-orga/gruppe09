package bomberman;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;

import javax.swing.JPanel;

/**
 * Die Klasse ist f�r die KI Gegner. Andere werden von der Enemy-Klasse beerbt
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
	Timer timer = new Timer();

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
	 * Gibt Position der Figur auf der x-Achse zur�ck.
	 * 
	 * @return positionX
	 */
	public int getPositionX() {
		return positionX;
	}

	/**
	 * Gibt Position der Figur auf der y-Achse zur�ck.
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
				if (Playground.field[(positionX / 30)][(positionY / 30) + 1]
						.isDestroyable()) {
					SettingProperties.bomb1((positionX / 30), (positionY / 30));

					timer.schedule(new BombTimer(1, (positionX / 30),
							(positionY / 30)), 1500);
				}
			} else
				Direction = setDirection();
		}

		else if (Direction == "Up") {
			if (Playground.field[(positionX / 30)][(positionY / 30) - 1]
					.isaccessible()) {
				positionY -= 30;
				if (Playground.field[(positionX / 30)][(positionY / 30 - 1)]
						.isDestroyable()) {
					SettingProperties.bomb1((positionX / 30), (positionY / 30));

					timer.schedule(new BombTimer(1, (positionX / 30),
							(positionY / 30)), 1500);

					FleeFromBomb(1, positionX / 30, positionY / 30);
				}
				if ((positionX) == Bomberman.GetFigure1().getPositionX()
						&& ((positionY - 30) == Bomberman.GetFigure1()
								.getPositionX())) {
					SettingProperties.bomb1((positionX / 30), (positionY / 30));

					timer.schedule(new BombTimer(1, (positionX / 30),
							(positionY / 30)), 1500);

					FleeFromBomb(1, positionX / 30, positionY / 30);
				}
			} else
				Direction = setDirection();
		} else if (Direction == "Left") {
			if (Playground.field[(positionX / 30) - 1][(positionY / 30)]
					.isaccessible()) {
				positionX -= 30;
				if (Playground.field[(positionX / 30 - 1)][(positionY / 30)]
						.isDestroyable()) {
					SettingProperties.bomb1((positionX / 30), (positionY / 30));

					timer.schedule(new BombTimer(1, (positionX / 30),
							(positionY / 30)), 1500);

					FleeFromBomb(1, positionX / 30, positionY / 30);
				}
			} else
				Direction = setDirection();
		} else if (Direction == "Right") {
			if (Playground.field[(positionX / 30) + 1][(positionY / 30)]
					.isaccessible()) {
				positionX += 30;
				if (Playground.field[(positionX / 30 + 1)][(positionY / 30)]
						.isDestroyable()) {
					SettingProperties.bomb1((positionX / 30), (positionY / 30));

					timer.schedule(new BombTimer(1, (positionX / 30),
							(positionY / 30)), 1500);

					FleeFromBomb(1, positionX / 30, positionY / 30);
				}
			} else
				Direction = setDirection();
		}

	}

	private void FleeFromBomb(int rad, int posX, int posY) {

		if ((Playground.field[(positionX / 30)][(positionY / 30) + 1]
				.isaccessible())) {
			Direction = "Down";

		} else if ((Playground.field[(positionX / 30)][(positionY / 30) - 1]
				.isaccessible())) {
			Direction = "Up";

		} else if ((Playground.field[(positionX / 30) + 1][positionY / 30]
				.isaccessible())) {
			Direction = "Right";
		} else if ((Playground.field[(positionX / 30) - 1][positionY / 30]
				.isaccessible())) {
			Direction = "Left";
		}

	}

	public String setDirection() {
		int rand = (int) (Math.random() * 4) + 1;
		// System.out.println(rand);
		if (((Playground.field[(positionX / 30) - 1][(positionY / 30)]
				.isaccessible()))) {
			if ((rand == 1))
				return "Left";
		}
		if (Playground.field[(positionX / 30) + 1][(positionY / 30)]
				.isaccessible()) {
			if (rand == 2)
				return "Right";
		}
		if (Playground.field[(positionX / 30)][(positionY / 30) - 1]
				.isaccessible()) {
			if ((rand == 3))
				return "Up";
		} else if (Playground.field[(positionX / 30)][(positionY / 30) + 1]
				.isaccessible())
			return "Down";

		return "Up";

	}

	public void startmoving() {
		EnemyMoveThread.start();
	}

	public void stopthreads() {
		EnemyMoveThread.interrupt();
		figureThread.interrupt();
	}

}
