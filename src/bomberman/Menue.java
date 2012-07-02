package bomberman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Menue extends JFrame {

	private JLabel BombermanName, BombermanPicture;
	private JButton SinglePlayer, Multiplayer, Highscore, Tutorial, Editor,
			Shutdown;
	private ImageIcon Image;

	public Menue() {
		BombermanName = new JLabel();
		Image = new ImageIcon(
				(Toolkit.getDefaultToolkit().getImage(Playground.class
						.getResource("grafics/map/443px-Bomberman.gif"))));

		setSize(600, 450);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(null);

		BombermanName.setFont(new Font("Arial", 1, 24)); // NOI18N
		BombermanName.setForeground(Color.BLACK);
		BombermanName.setHorizontalAlignment(SwingConstants.LEFT);
		BombermanName.setText("Bomberman");
		BombermanName.setBounds(240, 10, getWidth(), 60);
		add(BombermanName);

		BombermanPicture = new JLabel(Image);
		BombermanPicture.setBounds(300, 60, 250, 250);
		add(BombermanPicture);

		SinglePlayer = new JButton("Einzelspieler");
		SinglePlayer.addActionListener(new ButtonMainMenuSingleplayer());
		SinglePlayer.setBounds(20, 80, 200, 50);
		add(SinglePlayer);

		Multiplayer = new JButton("Mehrspieler");
		Multiplayer.addActionListener(new ButtonMainMenuMultiplayer());
		Multiplayer.setBounds(20, 140, 200, 50);
		add(Multiplayer);

		Highscore = new JButton("Bestenliste");
		Highscore.addActionListener(new ButtonMainMenuHighscore());
		Highscore.setBounds(20, 200, 200, 50);
		add(Highscore);

		Tutorial = new JButton("Tutorial");
		Tutorial.addActionListener(new ButtonMainMenuTutorial());
		Tutorial.setBounds(20, 260, 200, 50);
		add(Tutorial);

		Editor = new JButton("Editor");
		Editor.addActionListener(new ButtonMainMenuEditor());
		Editor.setBounds(20, 320, 200, 50);
		add(Editor);

		Shutdown = new JButton("Beenden");
		Shutdown.addActionListener(new ButtonMainMenuShutdown());
		Shutdown.setBounds(300, 320, 200, 50);
		add(Shutdown);

	}

	class ButtonMainMenuSingleplayer implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Bomberman.starteSingleplayer();
			Bomberman.CloseMainMenu();
		}
	}

	class ButtonMainMenuMultiplayer implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Bomberman.starteMultiplayer();
			Bomberman.CloseMainMenu();
		}
	}

	class ButtonMainMenuHighscore implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}

	class ButtonMainMenuTutorial implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}

	class ButtonMainMenuEditor implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Editor edit = new Editor();
			edit.setVisible(true);
			Bomberman.CloseMainMenu();
		}
	}

	class ButtonMainMenuShutdown implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
