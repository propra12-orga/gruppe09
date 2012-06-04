/**
 * Last Author : Dirk Date: 04/06/12 Last Action: while- zu for-schleifen umgeschrieben und mittels Variable numberOfFields wird die Anzahl der Felder nun dynamisch an die Groesse angepasst 
 */
package bomberman;

import java.awt.Container;

public class Bomberman {
    static Figure figure1;
    static Gui gui;
    public static int numberOfFields = 9;// sollte immer ungerade sein
    static Field fields[][] = new Field[numberOfFields][numberOfFields];
    private static Field pos;

    public static void main(String[] args) {
        gui = new Gui();
        gui.setVisible(true);
        initalize();

        figure1 = new Figure(0, 0);

        Container contentPane = gui.getContentPane();
        contentPane.add(new MoveControl(figure1));

    }

    public static void starteSingleplayer() {
        gui.setVisible(false);
        gui.update(gui.getGraphics());

        gui.add(figure1, 0);
        Figure.resetPosition();

        gui.setVisible(true);
    }

    public static void initalize() {
        pos = new Field();
        for (int i = 0; i < numberOfFields; i++) {
            for (int j = 0; j < numberOfFields; j++) {
                fields[i][j] = new Field();
            }
        }
        for (int i = 0; i < numberOfFields; i++) {
            for (int j = 0; j < numberOfFields; j++) {
                if ((i == 0) && (j == 0)) {
                    fields[i][j].fillField(null, fields[i + 1][j], null, fields[i][j + 1], "FELD1");
                } else if ((i == 0) && (j < numberOfFields - 1)) {
                    fields[i][j].fillField(null, fields[i + 1][j], fields[i][j - 1],
                            fields[i][j + 1], "Obere Grenze");
                } else if ((i == 0) && (j == numberOfFields - 1)) {
                    fields[i][j].fillField(null, fields[i + 1][j], fields[i][j - 1], null,
                            "Obere und rechte Grenze");
                } else if (((i != 0) && (i < numberOfFields - 1)) && (j == 0)) {
                    fields[i][j].fillField(fields[i - 1][j], fields[i + 1][j], null,
                            fields[i][j + 1], "Linke Grenze");
                } else if ((i == numberOfFields - 1) && (j == 0)) {
                    fields[i][j].fillField(fields[i - 1][j], null, null, fields[i][j + 1],
                            "Linke und untere Grenze");
                } else if ((i == numberOfFields - 1) && ((j != 0) && (j < numberOfFields - 1))) {
                    fields[i][j].fillField(fields[i - 1][j], null, fields[i][j - 1],
                            fields[i][j + 1], "untere Grenze");
                } else if ((i == numberOfFields - 1) && (j == numberOfFields - 1)) {
                    fields[i][j].fillField(fields[i - 1][j], null, fields[i][j - 1], null,
                            "Rechte und untere Grenze");
                } else if ((i < numberOfFields - 1) && (j == numberOfFields - 1)) {
                    fields[i][j].fillField(fields[i - 1][j], fields[i + 1][j], fields[i][j - 1],
                            null, "Rechte Grenze");
                } else if ((i > 0) && (i < numberOfFields - 1)
                        && ((j > 0) && (j < numberOfFields - 1))) {
                    fields[i][j].fillField(fields[i - 1][j], fields[i + 1][j], fields[i][j - 1],
                            fields[i][j + 1], "Spielfeld");
                }
            }
        }

        pos = fields[0][0];

    }

    public static Field getPos() {
        return pos;
    }

}
