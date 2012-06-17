package bomberman;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Die Klasse initialisiert Feldelemente. 
 * @author Lukas
 * @version 17/06/12
 *
 */
public class FeldElement extends JLabel {
	private boolean accessible = false; // begehbares Feld
	private boolean stargate = false; // Portal
	private boolean destroyable = false; // zerstörbares Feld
	private boolean border = false; // Grenze
	private boolean bomb = false; // Bombe
	private boolean hiddenstargate = false; // verstecktes Portal
	private boolean explosion = false; // Explosion
	
	/** Klassenkonstruktor.
	 * Initialisiert ein Bild auf einem Feld.
	 * 
	 * @param imageIcon
	 */
	public FeldElement(ImageIcon imageIcon) {
		super(imageIcon);
	}
	
	/**
	 * Gibt die Begehbarkeit eines Feldes zurück.
	 * @return true oder false
	 */
	public boolean isaccessible() {
		return accessible;
	}
	/**
	 * Regelt die Begehbarkeit eines Feldes. 
	 * @param accessible
	 */
	public void setaccessible(boolean accessible) {
		this.accessible = accessible;
	}
	
	/**
	 * Gibt zurück, ob es sich bei einem Feld um das Portal handelt. 
	 * @return true oder false
	 */
	public boolean isStargate() {
		return stargate;
	}
	
	/**
	 * Regelt das Auftreten des Portals.
	 * @param stargate
	 */
	public void setStargate(boolean stargate) {
		this.stargate = stargate;
	}
	
	/**
	 * Gibt die Zerstörbarkeit eines Feldes zurück.
	 * @return true oder false
	 */
	public boolean isDestroyable() {
		return destroyable;
	}
	
	/**
	 * Regelt die Zerstörbarkeit eines Feldes.
	 * @param destroyable
	 */
	public void setDestroyable(boolean destroyable) {
		this.destroyable = destroyable;
	}
	
	/**
	 * Gibt zurück, ob es sich bei einem Feld um eine äußere Grenze handelt. 
	 * @return true odr false
	 */
	public boolean isborder() {
		return border;
	}
	
	/**
	 * Regelt das Auftreten einer Grenze.
	 * @param border
	 */
	public void setborder(boolean border) {
		this.border = border;
	}
	
	/**
	 * Gibt zurück, ob auf dem Feld eine Bombe ist. 
	 * @return true oder false
	 */
	public boolean isBomb() {
		return bomb;
	}

	/**
	 * Setzt eine Bombe.
	 * @param bomb
	 */
	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}
	
	/**
	 * Gibt zurück, ob auf dem Feld eine Explosion ist. 
	 * @return true oder false
	 */
	public boolean isExplosion() {
		return explosion;
	}
	
	/**
	 * Setzt eine Explostion.
	 * @param explosion
	 */
	public void setExplosion(boolean explosion) {
		this.explosion = explosion;
	}
	
	/**
	 * Gibt zurück, ob es sich bei einem Feld um ein verstecktes Portal handelt. 
	 * @return true oder false
	 */
	public boolean isHiddenstargate() {
		return hiddenstargate;
	}
	
	/**
	 * Setzt ein verstecktes Portal. 
	 * @param hiddenstargate
	 */
	public void setHiddenstargate(boolean hiddenstargate) {
		this.hiddenstargate = hiddenstargate;
	}
}