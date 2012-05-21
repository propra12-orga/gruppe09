/**
 * Last Author : Dirk Date: 21.05.2012 Last Action: An 25 FPS angepasst
 */
package bomberman;

public class UpdateFigureThread extends Thread {// Zeichnet den Panel der
                                                // übergebenen Figur neu
    private Figure figure1;

    public UpdateFigureThread(Figure figure1) {
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
