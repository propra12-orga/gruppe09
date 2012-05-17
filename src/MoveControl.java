/**
 * Last Author : Lukas Date: 05/05/12 Last Action: Grundlegende Abfragen mit Events für die Steuerung implementiert
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
			// Kann später im Spieler zusammen gefasst werden
			if (POS.getLeftNeighbour()) {
				POS = POS.getLeft();
				String str;
				str = (String) POS.GetSpeicher();
				System.out.println(str);
			} else
				System.out.println("Grenze erreicht, es geht nicht weiter");
			// Hier Code einfügen um Spielfigur nach links zu bewegen
			// System.out.println("Links");
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			if (POS.getRightNeighbour()) {
				// Kann später im Spieler zusammen gefasst werden
				POS = POS.getRight();
				String str;
				str = (String) POS.GetSpeicher();
				System.out.println(str);
			} else
				System.out.println("Grenze erreicht, es geht nicht weiter");

			// Hier Code einfügen um Spielfigur nach rechts zu bewegen
			// System.out.println("Rechts");
		}
		if (keyCode == KeyEvent.VK_UP) {
			// Kann später im Spieler zusammen gefasst werden
			if (POS.getTopNeighbour()) {
				POS = POS.getTop();
				String str;
				str = (String) POS.GetSpeicher();
				System.out.println(str);
			} else
				System.out.println("Grenze erreicht, es geht nicht weiter");
			// Hier Code einfügen um Spielfigur nach oben zu bewegen
			// System.out.println("Oben");
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			// Kann später im Spieler zusammen gefasst werden
			if (POS.getBottomNeighbour()) {

				POS = POS.getBottom();
				String str;
				str = (String) POS.GetSpeicher();
				System.out.println(str);
			} else
				System.out.println("Grenze erreicht, es geht nicht weiter");
			// Hier Code einfügen um Spielfigur nach unten zu bewegen
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
