package bomberman;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

/**
 * Die Klasse erschafft alle Felder, die vorkommen können. 
 * @author Lukas
 * @version 17/06/12
 *
 */
public class SettingProperties {
	/**
	 * Initialisiert das Feld "Gras" mit den möglichen Eigenschaften.
	 * @param xPos Position des Feldes auf der x-Achse.
	 * @param yPos Position des Feldes auf der y-Achse. 
	 */
	public static void grass(int xPos, int yPos) {
		Playground.field[xPos][yPos]
				.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(
						Playground.class.getResource("grafics/map/grass.jpg"))));
		Playground.field[xPos][yPos].setaccessible(true);
		Playground.field[xPos][yPos].setStargate(false);
		Playground.field[xPos][yPos].setDestroyable(false);
		Playground.field[xPos][yPos].setborder(false);
		Playground.field[xPos][yPos].setBomb(false);
		Playground.field[xPos][yPos].setExplosion(false);
	}
	/**
	 * Initialisiert das Feld "Portal". 
	 * @param xPos Position des Feldes auf der x-Achse.
	 * @param yPos Position des Feldes auf der y-Achse.
	 */
	public static void stargate(int xPos, int yPos) {
		Playground.field[xPos][yPos].setIcon(new ImageIcon(Toolkit
				.getDefaultToolkit().getImage(
						Playground.class.getResource("grafics/map/door.png"))));
		Playground.field[xPos][yPos].setaccessible(true);
		Playground.field[xPos][yPos].setStargate(true);
		Playground.field[xPos][yPos].setDestroyable(false);
		Playground.field[xPos][yPos].setborder(false);
		Playground.field[xPos][yPos].setBomb(false);
		Playground.field[xPos][yPos].setExplosion(false);
	}
	
	/**
	 * Initialisiert das Feld "verstecktes Portal".
	 * @param xPos Position des Feldes auf der x-Achse.
	 * @param yPos Position des Feldes auf der y-Achse.
	 */
	public static void hiddenstargate(int xPos, int yPos) {
		Playground.field[xPos][yPos].setIcon(new ImageIcon(Toolkit
				.getDefaultToolkit().getImage(
						Playground.class.getResource("grafics/map/box.png"))));
		Playground.field[xPos][yPos].setaccessible(false);
		Playground.field[xPos][yPos].setStargate(false);
		Playground.field[xPos][yPos].setHiddenstargate(true);
		Playground.field[xPos][yPos].setDestroyable(true);
		Playground.field[xPos][yPos].setborder(false);
		Playground.field[xPos][yPos].setBomb(false);
		Playground.field[xPos][yPos].setExplosion(false);
	}
	
	/**
	 * Initialisiert eine "Wand".
	 * @param xPos Position des Feldes auf der x-Achse. 
	 * @param yPos Position des Feldes auf der y-Achse. 
	 */
	public static void wall(int xPos, int yPos) {
		Playground.field[xPos][yPos].setIcon(new ImageIcon(Toolkit
				.getDefaultToolkit().getImage(
						Playground.class.getResource("grafics/map/box.png"))));
		Playground.field[xPos][yPos].setaccessible(true);
		Playground.field[xPos][yPos].setStargate(false);
		Playground.field[xPos][yPos].setDestroyable(true);
		Playground.field[xPos][yPos].setborder(false);
		Playground.field[xPos][yPos].setBomb(false);
		Playground.field[xPos][yPos].setExplosion(false);
	}

	/**
	 * Initialisiert eine "Grenze". 
	 * @param xPos Position des Feldes auf der x-Achse. 
	 * @param yPos Position des Feldes auf der y-Achse. 
	 */
	public static void border(int xPos, int yPos) {
		Playground.field[xPos][yPos]
				.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(
						Playground.class.getResource("grafics/map/block.png"))));
		Playground.field[xPos][yPos].setaccessible(false);
		Playground.field[xPos][yPos].setStargate(false);
		Playground.field[xPos][yPos].setDestroyable(false);
		Playground.field[xPos][yPos].setborder(true);
		Playground.field[xPos][yPos].setBomb(false);
		Playground.field[xPos][yPos].setExplosion(false);
	}
}