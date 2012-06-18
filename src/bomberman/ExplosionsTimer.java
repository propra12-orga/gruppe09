package bomberman;

import java.util.TimerTask;

public class ExplosionsTimer extends TimerTask {
	private int rad, xPos, yPos;

	public ExplosionsTimer(int rad, int xPos, int yPos, boolean selfkill) {
		this.rad = rad;
		this.xPos = xPos;
		this.yPos = yPos;
		if (selfkill == true) {
			EndGame.EndtheGame(false, true);
		}
	}

	public void run() {
		SettingProperties.grass(xPos, yPos);

		for (int x = xPos + 1; x <= xPos + rad; x++) {
			if (Playground.field[x][yPos].isborder())
				break;
			if (x >= 0 && x <= 10
					&& Playground.field[x][yPos].isHiddenstargate())
				SettingProperties.stargate(x, yPos);
			else if (x >= 0 && x <= 10
					&& Playground.field[x][yPos].isaccessible()) {
				SettingProperties.grass(x, yPos);
			}
		}

		for (int x = xPos - 1; x >= xPos - rad; x--) {
			if (Playground.field[x][yPos].isborder())
				break;

			if (x >= 0 && x <= 10
					&& Playground.field[x][yPos].isHiddenstargate())
				SettingProperties.stargate(x, yPos);
			else if (x >= 0 && x <= 10
					&& Playground.field[x][yPos].isaccessible()) {
				SettingProperties.grass(x, yPos);
			}
		}
		for (int y = yPos + 1; y <= yPos + rad; y++) {
			if (Playground.field[xPos][y].isborder())
				break;

			if (y >= 0 && y <= 10
					&& Playground.field[xPos][y].isHiddenstargate())
				SettingProperties.stargate(xPos, y);

			else if (y >= 0 && y <= 10
					&& Playground.field[xPos][y].isaccessible()) {
				SettingProperties.grass(xPos, y);
			}
		}

		for (int y = yPos - 1; y >= yPos - rad; y--) {
			if (Playground.field[xPos][y].isborder())
				break;
			if (y >= 0 && y <= 10
					&& Playground.field[xPos][y].isHiddenstargate())
				SettingProperties.stargate(xPos, y);
			else if (y >= 0 && y <= 10
					&& Playground.field[xPos][y].isaccessible()) {
				SettingProperties.grass(xPos, y);
			}
		}

	}
}