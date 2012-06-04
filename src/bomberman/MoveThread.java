/**
 * Last Author : Dirk Date: 21/05/12 Last Action: Diesen Kommentar hinzugef�gt 
 */
package bomberman;

public class MoveThread extends Thread {// Bewegt die �bergebene Figur in die
                                        // �bergebene Richtung
    private Figure figure1;
    private String direction;

    public MoveThread(Figure figure1, String direction) {
        this.figure1 = figure1;
        this.direction = direction;
        this.setPriority(MIN_PRIORITY);
    }

    public void run() {
        while (!interrupted()) {
            figure1.move(direction);
            try {
                sleep(2 / figure1.getSpeed());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                interrupt();
            }
        }
    }
}
