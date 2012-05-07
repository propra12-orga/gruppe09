import java.awt.Container;

import javax.swing.JFrame;

/**
 * Last Author : Lukas Date: 05/05/12 Last Action: Hauptdatei mit mainfunktion
 * erzeugt, Frame fenster eingebaut
 */

public class Bomberman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setTitle("Bomberman");
		frame.setSize(300, 200);

		Container contentPane = frame.getContentPane();
		contentPane.add(new MoveControl());
		frame.show();
	}

}
