/**
 * Last Author : Dirk Date: 04/06/12 Last Action: Spielflaeche wird nun in einer Schleife gezeichnet und Bilder werden aus der Ordnerstrucktur heraus geladen.
 * */

package bomberman;

import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Playground {
    static Icon icon_Border = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            Playground.class.getResource("grafics/map/block.png")));
    static Icon icon_Grass = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
            Playground.class.getResource("grafics/map/grass.jpg")));
    private static int sizeOfPlayground = 11;// sollte immer ungerade sein
    private static JLabel field[][] = new JLabel[sizeOfPlayground][sizeOfPlayground];

    public static JPanel createPlayground(JPanel backgroundPanel) {
        backgroundPanel.setLayout(null);
        for (int i = 0; i < sizeOfPlayground; i++) {
            for (int j = 0; j < sizeOfPlayground; j++) {
                if (((i % 2 == 0) && (j % 2 == 0)) || ((i == 0) || (i == sizeOfPlayground - 1))
                        || ((j == 0) || (j == sizeOfPlayground - 1))) {
                    field[i][j] = new JLabel(icon_Border);
                } else {
                    field[i][j] = new JLabel(icon_Grass);
                }
                field[i][j].setBounds(i * 30, j * 30, 30, 30);
                backgroundPanel.add(field[i][j]);
            }
        }

        return backgroundPanel;

    }

}
