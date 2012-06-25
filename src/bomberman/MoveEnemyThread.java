package bomberman;

public class MoveEnemyThread extends Thread {// Bewegt die übergebene Figur in
												// die
	// übergebene Richtung
	private Enemy Enemy;

	public MoveEnemyThread(Enemy Enemy) {
		this.Enemy = Enemy;

		this.setPriority(MIN_PRIORITY);
	}

	public void run() {
		while (!interrupted()) {
			Enemy.move();
			try {
				sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				interrupt();
			}
		}
	}
}