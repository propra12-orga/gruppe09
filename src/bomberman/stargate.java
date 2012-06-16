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

public class stargate extends JFrame {
	private EndGame endgame = new EndGame();
	private JButton StartnewGame = new JButton("Neues Spiel starten");

	public stargate() {
		super("Spiel gewonnen!");
		setSize(250, 250);
		EndGame endgame = new EndGame();

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
		endgame.setImage();
		setVisible(true);

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

class EndGame extends JComponent {
	private Image Figure1Wins;

	public void setImage() {
		Figure1Wins = (Toolkit.getDefaultToolkit().getImage(this.getClass()
				.getResource("grafics/player/1/win.png")));
		if (Figure1Wins != null)
			repaint();
	}

	protected void paintComponent(Graphics g) {
		if (Figure1Wins != null)
			g.drawImage(Figure1Wins, 0, 0, this);
	}
}

class ActionListenerStartNewGame implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Bomberman.starteSingleplayer();

	}
}