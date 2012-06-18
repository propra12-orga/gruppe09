package bomberman;

import java.util.Timer;

public class Bomb {

	private int rad, xPos, yPos;
	private boolean Selfkill;

	boolean destroyrange[] = new boolean[4];

	Timer timer = new Timer();

	public Bomb(int rad, int xPos, int yPos) {
		this.rad = rad;
		this.xPos = xPos;
		this.yPos = yPos;
		Selfkill = false;
	}

	public void explod() {
		if (!Playground.field[xPos][yPos].isBomb())
			return;

		timer.schedule(new ExplosionsTimer(rad, xPos, yPos, Selfkill), 500);

		SettingProperties.explosion(xPos, yPos);

		for (int i = 0; i <= 3; i++)
			destroyrange[i] = false;

		for (int x = xPos + 1; x <= xPos + rad; x++) {
			if (!Playground.field[x][yPos].isborder()) {
				if (x >= 0 && x <= 10) {
					// Auslösen einer kettenreaktion
					if (Playground.field[x][yPos].isBomb()) {
						new Bomb(rad, x, yPos).explod();
						Playground.field[x][yPos].setBomb(false);
					}
					if ((x == Playground.getSpalte() && yPos == Playground
							.getZeile())
							|| (xPos == Playground.getSpalte() && yPos == Playground
									.getZeile())) {
						System.out.println("Spieler im Bombenbereich");
					}
					// Zerstören einer Wand
					if (Playground.field[x][yPos].isDestroyable())
						destroyrange[0] = true;
					SettingProperties.explosion(x, yPos);
				}
			}

			if (destroyrange[0] == true)
				break;
		}

		for (int x = xPos - 1; x >= xPos - rad; x--) {
			if (!Playground.field[x][yPos].isborder()) {
				if (x >= 0 && x <= 10) {
					if (Playground.field[x][yPos].isBomb()) {
						new Bomb(rad, x, yPos).explod();
						Playground.field[x][yPos].setBomb(false);
					}
					if ((x == Playground.getSpalte() && yPos == Playground
							.getZeile())
							|| (xPos == Playground.getSpalte() && yPos == Playground
									.getZeile())) {
						System.out.println("Spieler im Bombenbereich");
					}
					if (Playground.field[x][yPos].isDestroyable())
						destroyrange[1] = true;
					SettingProperties.explosion(x, yPos);
				}
			}

			if (destroyrange[1] == true)
				break;
		}

		for (int y = yPos + 1; y <= yPos + rad; y++) {
			if (!Playground.field[xPos][y].isborder()) {
				if (y >= 0 && y <= 10) {
					if (Playground.field[xPos][y].isBomb()) {
						new Bomb(rad, xPos, y).explod();
						Playground.field[xPos][y].setBomb(false);
					}
					if ((xPos == Playground.getSpalte() && y == Playground
							.getZeile())
							|| (xPos == Playground.getSpalte() && yPos == Playground
									.getZeile())) {
						System.out.println("Spieler im Bombenbereich");
					}
					if (Playground.field[xPos][y].isDestroyable())
						destroyrange[2] = true;
					SettingProperties.explosion(xPos, y);
				}
			}

			if (destroyrange[2] == true)
				break;
		}

		for (int y = yPos - 1; y >= yPos - rad; y--) {
			if (!Playground.field[xPos][y].isborder()) {
				if (y >= 0 && y <= 10) {
					if (Playground.field[xPos][y].isBomb()) {
						new Bomb(rad, xPos, y).explod();
						Playground.field[xPos][y].setBomb(false);
					}
					if ((xPos == Playground.getSpalte() && y == Playground
							.getZeile())
							|| (xPos == Playground.getSpalte() && yPos == Playground
									.getZeile())) {
						System.out.println("Spieler im Bombenbereich");
					}
					if (Playground.field[xPos][y].isDestroyable())
						destroyrange[3] = true;
					SettingProperties.explosion(xPos, y);
				}
			}

			if (destroyrange[3] == true)
				break;
		}
		timer.schedule(new ExplosionsTimer(rad, xPos, yPos, Selfkill), 1000);

	}

}
