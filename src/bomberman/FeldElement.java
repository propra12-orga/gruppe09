package bomberman;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FeldElement extends JLabel {
	private boolean accessible = false;
	private boolean stargate = false;
	private boolean destroyable = false;
	private boolean border = false;
	private boolean bomb = false;
	private boolean hiddenstargate = false;
	private boolean explosion = false;

	public FeldElement(ImageIcon imageIcon) {
		super(imageIcon);
	}

	public boolean isaccessible() {
		return accessible;
	}

	public void setaccessible(boolean accessible) {
		this.accessible = accessible;
	}

	public boolean isStargate() {
		return stargate;
	}

	public void setStargate(boolean stargate) {
		this.stargate = stargate;
	}

	public boolean isDestroyable() {
		return destroyable;
	}

	public void setDestroyable(boolean destroyable) {
		this.destroyable = destroyable;
	}

	public boolean isborder() {
		return border;
	}

	public void setborder(boolean border) {
		this.border = border;
	}

	public boolean isBomb() {
		return bomb;
	}

	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}

	public boolean isExplosion() {
		return explosion;
	}

	public void setExplosion(boolean explosion) {
		this.explosion = explosion;
	}

	public boolean isHiddenstargate() {
		return hiddenstargate;
	}

	public void setHiddenstargate(boolean hiddenstargate) {
		this.hiddenstargate = hiddenstargate;
	}
}