package bomberman;

import java.util.Timer;

public class Bomb {

	private int rad, xPos, yPos;
	private boolean SelfkillPlayer1, SelfkillPlayer2;

	boolean destroyrange[] = new boolean[4];

	Timer timer = new Timer();

	public Bomb(int rad, int xPos, int yPos) {
		this.rad = rad;
		this.xPos = xPos;
		this.yPos = yPos;
		SelfkillPlayer1 = false;
		SelfkillPlayer2 = false;
	}

	public void explod() {
		if (!Playground.field[xPos][yPos].isBomb())
			return;

		timer.schedule(new ExplosionsTimer(rad, xPos, yPos), 500);

		SettingProperties.explosion(xPos, yPos);

		for (int i = 0; i <= 3; i++)
			destroyrange[i] = false;

		int x = xPos + 1;
		while ((x < 10) && (x <= xPos + rad)
				&& (!Playground.field[x][yPos].isborder())
				&& (destroyrange[0] == false)) {
			if (x >= 0 && x <= 10) {
				// Auslösen einer kettenreaktion
				if (Playground.field[x][yPos].isBomb()) {
					new Bomb(rad, x, yPos).explod();
					Playground.field[x][yPos].setBomb(false);
				}
				// Gucken ob Spieler1 getötet wird
				if ((x == Playground.getSpalte() && yPos == Playground
						.getZeile())
						|| (xPos == Playground.getSpalte() && yPos == Playground
								.getZeile())) {
					SelfkillPlayer1 = true;
					System.out.println("Spieler im Bombenbereich");
				}
				// Gucken ob Spieler2 getötet wird
				if ((x == Playground.getSpalte2() && yPos == Playground
						.getZeile2())
						|| (xPos == Playground.getSpalte2() && yPos == Playground
								.getZeile2())) {
					SelfkillPlayer2 = true;
					System.out.println("Spieler im Bombenbereich");
				}

				// Zerstören einer Wand
				if (Playground.field[x][yPos].isDestroyable())
					destroyrange[0] = true;
				SettingProperties.explosion(x, yPos);
			}

			x++;
		}

		x = xPos - 1;
		while ((x >= 0) && (x >= xPos - rad)
				&& (!Playground.field[x][yPos].isborder())
				&& (destroyrange[1] == false)) {
			if (x >= 0 && x <= 10) {
				if (Playground.field[x][yPos].isBomb()) {
					new Bomb(rad, x, yPos).explod();
					Playground.field[x][yPos].setBomb(false);
				}
				if ((x == Playground.getSpalte() && yPos == Playground
						.getZeile())
						|| (xPos == Playground.getSpalte() && yPos == Playground
								.getZeile())) {
					SelfkillPlayer1 = true;
					System.out.println("Spieler im Bombenbereich");
				}

				if ((x == Playground.getSpalte2() && yPos == Playground
						.getZeile2())
						|| (xPos == Playground.getSpalte2() && yPos == Playground
								.getZeile2())) {
					SelfkillPlayer1 = true;
					System.out.println("Spieler im Bombenbereich");
				}
				if (Playground.field[x][yPos].isDestroyable())
					destroyrange[1] = true;
				SettingProperties.explosion(x, yPos);
			}

			x--;
		}

		int y = yPos + 1;
		while ((y < 10) && (y <= yPos + rad)
				&& (!Playground.field[xPos][y].isborder())
				&& (destroyrange[2] == false)) {
			if (y >= 0 && y <= 10) {
				if (Playground.field[xPos][y].isBomb()) {
					new Bomb(rad, xPos, y).explod();
					Playground.field[xPos][y].setBomb(false);
				}
				if ((xPos == Playground.getSpalte() && y == Playground
						.getZeile())
						|| (xPos == Playground.getSpalte() && yPos == Playground
								.getZeile())) {
					SelfkillPlayer1 = true;
					System.out.println("Spieler im Bombenbereich");
				}

				if ((xPos == Playground.getSpalte2() && y == Playground
						.getZeile2())
						|| (xPos == Playground.getSpalte2() && yPos == Playground
								.getZeile2())) {
					SelfkillPlayer2 = true;
					System.out.println("Spieler im Bombenbereich");
				}
				if (Playground.field[xPos][y].isDestroyable())
					destroyrange[2] = true;
				SettingProperties.explosion(xPos, y);
			}

			y++;

		}

		y = yPos - 1;
		while ((y >= 0) && (y >= yPos - rad)
				&& (!Playground.field[xPos][y].isborder())
				&& (destroyrange[3] == false)) {
			if (y >= 0 && y <= 10) {
				if (Playground.field[xPos][y].isBomb()) {
					new Bomb(rad, xPos, y).explod();
					Playground.field[xPos][y].setBomb(false);
				}
				if ((xPos == Playground.getSpalte() && y == Playground
						.getZeile())
						|| (xPos == Playground.getSpalte() && yPos == Playground
								.getZeile())) {
					SelfkillPlayer1 = true;
					System.out.println("Spieler im Bombenbereich");
				}
				if ((xPos == Playground.getSpalte2() && y == Playground
						.getZeile2())
						|| (xPos == Playground.getSpalte2() && yPos == Playground
								.getZeile2())) {
					SelfkillPlayer2 = true;
					System.out.println("Spieler im Bombenbereich");
				}
				if (Playground.field[xPos][y].isDestroyable())
					destroyrange[3] = true;
				SettingProperties.explosion(xPos, y);
			}
			y--;
		}

		if ((SelfkillPlayer1 == true) && (SelfkillPlayer2 == true)) {
			EndGame.EndtheGame(false, false, false, true);
		} else if (SelfkillPlayer1 == true) {
			EndGame.EndtheGame(false, SelfkillPlayer1, SelfkillPlayer2, false);
		}

		else if (SelfkillPlayer2 == true) {
			EndGame.EndtheGame(false, SelfkillPlayer1, SelfkillPlayer2, false);
		}

		timer.schedule(new ExplosionsTimer(rad, xPos, yPos), 1000);

	}
}
