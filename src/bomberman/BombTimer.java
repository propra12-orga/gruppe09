package bomberman;

import java.util.TimerTask;

public class BombTimer extends TimerTask {
	private int radius, row, slot;

	public BombTimer(int radius, int row, int slot) {
		this.radius = radius;
		this.row = row;
		this.slot = slot;

	}

	// Startet wenn der Timer abgelaufen ist
	public void run() {

		new Bomb(radius, row, slot).explod();
	}
}