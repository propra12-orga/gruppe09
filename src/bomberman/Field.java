/**
 * Last Author : Dirk Date: 09/06/12 Last Action: Neue Attribute x,y in denen die Koordinaten gespeichert werden, sowie diverse set und get methoden 
 */
package bomberman;

public class Field {
	private Field top; // Oberer Nachfolger oder null
	private Field bottom; // Unterer Nachfolger oder null
	private Field left; // Linker Nachfolger oder null
	private Field right; // Rechter Nachfolger oder null
	private Object Speicher; // Entweder Mauer,nichts oder Zieltor
	private boolean IsFree; // Ob das Feld betretbar ist oder nicht TRUE||FALSE
	private int x, y; // Koordinaten zum ‹bergang ins
						// n‰chste Feld

	public Field() {

	}

	public void fillField(Field pTop, Field pBottom, Field pLeft, Field pRight,
			Object pInhalt) {
		top = pTop;
		bottom = pBottom;
		left = pLeft;
		right = pRight;
		Speicher = pInhalt;
		IsFree = true; // standartm‰ﬂig. Ist dem nicht der fall wird es
						// automatisch auf false gesetzt
	}

	public boolean isEmpty() {
		if (Speicher == null) {
			return true;
		}
		return false;
	}

	public Object GetSpeicher() {
		if (isEmpty()) {

			System.out.println("Kein Speicherobjekt gefunden");
			return null;
		} else {
			return Speicher;
		}

	}

	public boolean getLeftNeighbour() {
		if (getLeft() == null) {
			return false;
		} else
			return true;
	}

	public boolean getRightNeighbour() {
		if (getRight() == null) {
			return false;
		} else
			return true;
	}

	public boolean getTopNeighbour() {
		if (getTop() == null) {
			return false;
		} else
			return true;
	}

	public boolean getBottomNeighbour() {
		if (getBottom() == null) {
			return false;
		} else
			return true;
	}

	public boolean IsFree() {
		return IsFree;
	}

	// Get und Setter Methoden eher unwichtig

	public Field getTop() {
		return top;
	}

	public void setTop(Field top) {
		this.top = top;
	}

	public Field getBottom() {
		return bottom;
	}

	public void setBottom(Field bottom) {
		this.bottom = bottom;
	}

	public Field getLeft() {
		return left;
	}

	public void setLeft(Field left) {
		this.left = left;
	}

	public Field getRight() {
		return right;
	}

	public void setRight(Field right) {
		this.right = right;
	}

	public void setIsFree(boolean isFree) {
		IsFree = isFree;
	}

	public int getX() {
		return x;
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getY() {
		return y;
	}

}
