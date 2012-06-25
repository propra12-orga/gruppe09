package bomberman;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Die Klasse initialisiert das Portal. Sie ermöglicht das Beenden des Spiels
 * sowie das Starten eines neuen Spiels.
 * 
 * @author Lukas
 * @version 17/06/2012
 * 
 */
public class stargate extends JFrame {
	private EndGameWinner endgame;
	private EndGameLost endgameLost;
	private EndGameDraw EndGameDraw;
	private JButton StartnewGame = new JButton("Neues Spiel starten");

	public stargate(boolean win, int player, boolean draw) {
		super("Spiel beendet!");
		setSize(250, 250);
		if (Bomberman.IsSingleplayer() == true)
			EndSinglePlayer(win, player);
		else if (Bomberman.IsMultiplayer() == true)
			EndMultiPlayer(win, player, draw);
	}

	public void EndSinglePlayer(boolean win, int player) {
		if (win == true) {
			endgame = new EndGameWinner();
			Container c = this.getContentPane();

			GridBagLayout gbl = new GridBagLayout();
			c.setLayout(gbl);

			addComponent(c, gbl, endgame, 0, 0, 5, 2, 1.0, 1.0);
			addComponent(c, gbl, StartnewGame, 2, 3, 1, 1, 0, 0);
			StartnewGame.addActionListener(new ActionListenerStartNewGame());
			File f = new File("win.wav");
			AudioClip sound = null;
			try {
				sound = Applet.newAudioClip(f.toURL());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sound.play();
			endgame.setImage(player);
			setVisible(true);
		} else if (win == false) {
			endgameLost = new EndGameLost();

			Container c = this.getContentPane();

			GridBagLayout gbl = new GridBagLayout();
			c.setLayout(gbl);

			addComponent(c, gbl, endgameLost, 0, 0, 5, 2, 1.0, 1.0);
			addComponent(c, gbl, StartnewGame, 2, 3, 1, 1, 0, 0);
			StartnewGame.addActionListener(new ActionListenerStartNewGame());
			File f = new File("lost.wav");
			AudioClip sound = null;
			try {
				sound = Applet.newAudioClip(f.toURL());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sound.play();
			endgameLost.setImage();
			setVisible(true);
		}
	}

	public void EndMultiPlayer(boolean win, int player, boolean draw) {
		if (draw == true) {
			EndGameDraw = new EndGameDraw();
			Container c = this.getContentPane();

			GridBagLayout gbl = new GridBagLayout();
			c.setLayout(gbl);

			addComponent(c, gbl, EndGameDraw, 0, 0, 5, 2, 1.0, 1.0);
			addComponent(c, gbl, StartnewGame, 2, 3, 1, 1, 0, 0);
			StartnewGame.addActionListener(new ActionListenerStartNewGame());
			File f = new File("win.wav");
			AudioClip sound = null;
			try {
				sound = Applet.newAudioClip(f.toURL());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sound.play();
			EndGameDraw.setImage();
			setVisible(true);
		} else if (win == true) {
			endgame = new EndGameWinner();
			Container c = this.getContentPane();

			GridBagLayout gbl = new GridBagLayout();
			c.setLayout(gbl);

			addComponent(c, gbl, endgame, 0, 0, 5, 2, 1.0, 1.0);
			addComponent(c, gbl, StartnewGame, 2, 3, 1, 1, 0, 0);
			StartnewGame.addActionListener(new ActionListenerStartNewGame());
			File f = new File("win.wav");
			AudioClip sound = null;
			try {
				sound = Applet.newAudioClip(f.toURL());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sound.play();
			endgame.setImage(player);
			setVisible(true);
		}

	}

	static void addComponent(Container cont, GridBagLayout gbl, Component c,
			int x, int y, int width, int height, double weightx, double weighty) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints(c, gbc);
		cont.add(c);
	}
}

class EndGameWinner extends JComponent {
	private Image Figure1Wins;

	/**
	 * Setzt ein neues Bild, falls ein Spieler gewinnt.
	 */
	public void setImage(int player) {
		if (player == 0) {
			Figure1Wins = (Toolkit.getDefaultToolkit().getImage(this.getClass()
					.getResource("grafics/player/1/win.png")));
		} else {
			Figure1Wins = (Toolkit.getDefaultToolkit().getImage(this.getClass()
					.getResource("grafics/player/4/win.png")));
		}

		if (Figure1Wins != null)
			repaint();
	}

	protected void paintComponent(Graphics g) {
		if (Figure1Wins != null)
			g.drawImage(Figure1Wins, 0, 0, this);
	}
}

class EndGameLost extends JComponent {
	private Image image;

	/**
	 * Setzt ein neues Bild, falls ein Spieler verliertg.
	 */
	public void setImage() {
		image = (Toolkit.getDefaultToolkit().getImage(this.getClass()
				.getResource("grafics/gameend/sp_lost.png")));
		if (image != null)
			repaint();
	}

	protected void paintComponent(Graphics g) {
		if (image != null)
			g.drawImage(image, 0, 0, this);
	}
}

class EndGameDraw extends JComponent {
	private Image ImageDraw;

	/**
	 * Setzt ein neues Bild, falls ein Spieler gewinnt.
	 */
	public void setImage() {
		ImageDraw = (Toolkit.getDefaultToolkit().getImage(this.getClass()
				.getResource("grafics/gameend/draw.png")));

		if (ImageDraw != null)
			repaint();
	}

	protected void paintComponent(Graphics g) {
		if (ImageDraw != null)
			g.drawImage(ImageDraw, 0, 0, this);
	}
}

class ActionListenerStartNewGame implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Bomberman.resetPositions();

	}
}