/**
 * Last Author : Dirk Date: 21.05.2012 Last Action: An 25 FPS angepasst
 */
package bomberman;

public class UpdateThreadFigure2 extends Thread {// Zeichnet den Panel der
													// übergebenen Figur neu
	private Figure2 figure1;

	public UpdateThreadFigure2(Figure2 figure1) {
		this.figure1 = figure1;
		this.setPriority(MIN_PRIORITY);
	}

	public void run() {
		while (!interrupted()) {
			figure1.setVisible(false);
			figure1.update(figure1.getGraphics());
			figure1.setVisible(true);
			try {
				sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				interrupt();
			}
		}
	}
}
