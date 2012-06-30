package bomberman;

import java.util.TimerTask;
/**
 * 
 * 
 * @author Lukas
 * @version 25/06/2012
 *
 */
public class ExplosionsTimer extends TimerTask {
	private int rad, xPos, yPos;

	public ExplosionsTimer(int rad, int xPos, int yPos) {
		this.rad = rad;
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public void run() {
		SettingProperties.grass(xPos, yPos);

		int x = xPos + 1;
		while ((x < 10) && (x <= xPos + rad)
				&& (!Playground.field[x][yPos].isborder())) {

			if (x >= 0 && x <= 10
					&& Playground.field[x][yPos].isHiddenstargate())
				SettingProperties.stargate(x, yPos);
			else if (x >= 0 && x <= 10
					&& Playground.field[x][yPos].isaccessible())
				SettingProperties.grass(x, yPos);
			x++;
		}

		x = xPos - 1;
		while ((x >= 0) && (x >= xPos - rad)
				&& (!Playground.field[x][yPos].isborder())) {

			if (x >= 0 && x <= 10
					&& Playground.field[x][yPos].isHiddenstargate())
				SettingProperties.stargate(x, yPos);
			else if (x >= 0 && x <= 10
					&& Playground.field[x][yPos].isaccessible()) {
				SettingProperties.grass(x, yPos);
			}

			x--;
		}

		int y = yPos + 1;
		while ((y < 10) && (y <= yPos + rad)
				&& (!Playground.field[xPos][y].isborder())) {
			if (y >= 0 && y <= 10
					&& Playground.field[xPos][y].isHiddenstargate())
				SettingProperties.stargate(xPos, y);

			else if (y >= 0 && y <= 10
					&& Playground.field[xPos][y].isaccessible()) {
				SettingProperties.grass(xPos, y);
			}
			y++;
		}

		y = yPos - 1;
		while ((y >= 0) && (y >= yPos - rad)
				&& (!Playground.field[xPos][y].isborder())) {
			if (y >= 0 && y <= 10
					&& Playground.field[xPos][y].isHiddenstargate())
				SettingProperties.stargate(xPos, y);
			else if (y >= 0 && y <= 10
					&& Playground.field[xPos][y].isaccessible()) {
				SettingProperties.grass(xPos, y);
			}
			y--;
		}

	}
}