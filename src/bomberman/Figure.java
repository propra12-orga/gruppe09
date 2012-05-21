/**
 * Last Author : Dirk Date: 21/05/12 Last Action: Diesen Kommentar hinzugefügt 
 */
package bomberman;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Figure extends JPanel {
    private int positionX, positionY, speed;
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
}
