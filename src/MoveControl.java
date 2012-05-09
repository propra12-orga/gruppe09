/**
 * Last Author : Lukas Date: 05/05/12 Last Action: Grundlegende Abfragen mit Events f�r die Steuerung implementiert
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MoveControl extends JPanel implements KeyListener {

	public MoveControl() {
		addKeyListener(this);
	}

	public void keyPressed(KeyEvent evt) {
		int keyCode = evt.getKeyCode();
		if (keyCode == KeyEvent.VK_LEFT) {
			// Hier Code einf�gen um Spielfigur nach links zu bewegen
			System.out.println("Links");
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			// Hier Code einf�gen um Spielfigur nach rechts zu bewegen
			System.out.println("Rechts");
		}
		if (keyCode == KeyEvent.VK_UP) {
			// Hier Code einf�gen um Spielfigur nach oben zu bewegen
			System.out.println("Oben");
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			// Hier Code einf�gen um Spielfigur nach unten zu bewegen
			System.out.println("Unten");
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
