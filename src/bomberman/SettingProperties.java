package bomberman;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class SettingProperties {
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