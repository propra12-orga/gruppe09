/**
 * Last Author : Dirk Date: 21/05/12 Last Action: Diesen Kommentar hinzugefügt 
 */
package bomberman;

public class MoveThreadFigure2 extends Thread {// Bewegt die übergebene Figur in
												// die
	// übergebene Richtung
	private Figure2 figure2;
	private String direction;

	public MoveThreadFigure2(Figure2 figure2, String direction) {
		this.figure2 = figure2;
		this.direction = direction;
		this.setPriority(MIN_PRIORITY);
	}

	public void run() {
		while (!interrupted()) {
			figure2.move(direction);
			try {
				sleep(2 / figure2.getSpeed());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				interrupt();
			}
		}
	}
}
