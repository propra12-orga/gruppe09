/**
 * Last Author : Lukas Date: 05/05/12 Last Action: Grundlegende Abfragen mit Events für die Steuerung implementiert
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
			// Hier Code einfügen um Spielfigur nach links zu bewegen
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			// Hier Code einfügen um Spielfigur nach rechts zu bewegen
		}
		if (keyCode == KeyEvent.VK_UP) {
			// Hier Code einfügen um Spielfigur nach oben zu bewegen
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			// Hier Code einfügen um Spielfigur nach unten zu bewegen
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
