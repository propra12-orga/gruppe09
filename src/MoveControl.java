/**
 * Last Author : Lukas Date: 05/05/12 Last Action: Grundlegende Abfragen mit Events f�r die Steuerung implementiert
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MoveControl extends JPanel implements KeyListener {
	private Field POS;

	public MoveControl() {
		addKeyListener(this);
		POS = Bomberman.GetPos();
	}

	public void keyPressed(KeyEvent evt) {
		int keyCode = evt.getKeyCode();
		if (keyCode == KeyEvent.VK_LEFT) {
			// Kann sp�ter im Spieler zusammen gefasst werden
			if (POS.getLeftNeighbour()) {
				POS = POS.getLeft();
				String str;
				str = (String) POS.GetSpeicher();
				System.out.println(str);
			} else
				System.out.println("Grenze erreicht, es geht nicht weiter");
			// Hier Code einf�gen um Spielfigur nach links zu bewegen
			// System.out.println("Links");
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			if (POS.getRightNeighbour()) {
				// Kann sp�ter im Spieler zusammen gefasst werden
				POS = POS.getRight();
				String str;
				str = (String) POS.GetSpeicher();
				System.out.println(str);
			} else
				System.out.println("Grenze erreicht, es geht nicht weiter");

			// Hier Code einf�gen um Spielfigur nach rechts zu bewegen
			// System.out.println("Rechts");
		}
		if (keyCode == KeyEvent.VK_UP) {
			// Kann sp�ter im Spieler zusammen gefasst werden
			if (POS.getTopNeighbour()) {
				POS = POS.getTop();
				String str;
				str = (String) POS.GetSpeicher();
				System.out.println(str);
			} else
				System.out.println("Grenze erreicht, es geht nicht weiter");
			// Hier Code einf�gen um Spielfigur nach oben zu bewegen
			// System.out.println("Oben");
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			// Kann sp�ter im Spieler zusammen gefasst werden
			if (POS.getBottomNeighbour()) {

				POS = POS.getBottom();
				String str;
				str = (String) POS.GetSpeicher();
				System.out.println(str);
			} else
				System.out.println("Grenze erreicht, es geht nicht weiter");
			// Hier Code einf�gen um Spielfigur nach unten zu bewegen
			// System.out.println("Unten");
		}

	}

	public void keyReleased(KeyEvent evt) {
	}

	public void keyTyped(KeyEvent evt) {
	}

	public boolean isFocusTraversable() {
		return true;
	}

}
