/**
 * Last Author : Lukas Date: 03/06/12 Last Action: Schriftzug Bomberman nach unten gesetzt. Es wird jetzt ein Spielfeld generiert 
 */
package bomberman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Spielgui extends JFrame {

	// Variablen Deklarationen
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem singleplayerMenuItem;
	private JMenuItem multiplayerMenuItem;
	private JMenuItem SaveMenuItem;
	private JMenuItem LoadMenuItem;
	private JMenuItem optionsMenuItem;
	private JMenuItem highscoreMenuItem;
	private JMenuItem exitMenuItem;
	private JMenu helpMenu;
	private JMenuItem contentsMenuItem;
	private JMenuItem aboutMenuItem;

	private JLabel bombermanLetters;
	private JLabel BombsPic;
	private static JLabel BombCounter;

	private JLabel FirePic;
	private static JLabel FireCounter;

	private JPanel backgroundPanel;

	// Ende der Variablen Deklarationen
	public Spielgui() {
		super("Bomberman");
		setSize(470, 450);
		initComponents();
	}

	public void paint(Graphics g) {
		super.paint(g);
	}

	private void initComponents() {

		menuBar = new JMenuBar();
		fileMenu = new JMenu();
		singleplayerMenuItem = new JMenuItem();
		multiplayerMenuItem = new JMenuItem();
		SaveMenuItem = new JMenuItem();
		LoadMenuItem = new JMenuItem();
		optionsMenuItem = new JMenuItem();
		highscoreMenuItem = new JMenuItem();
		exitMenuItem = new JMenuItem();
		helpMenu = new JMenu();
		contentsMenuItem = new JMenuItem();
		aboutMenuItem = new JMenuItem();

		bombermanLetters = new JLabel();
		BombsPic = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(Playground.class.getResource("grafics/bomb/3.png"))));
		BombCounter = new JLabel();

		FirePic = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit()
				.getImage(Playground.class.getResource("grafics/bomb/3.png"))));
		FireCounter = new JLabel();

		backgroundPanel = new JPanel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		fileMenu.setMnemonic('f');
		fileMenu.setText("Menu");

		SaveMenuItem.setMnemonic('S');
		SaveMenuItem.setText("Speichern");
		SaveMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(SaveMenuItem);

		LoadMenuItem.setMnemonic('L');
		LoadMenuItem.setText("Laden");
		LoadMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				LoadMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(LoadMenuItem);

		optionsMenuItem.setMnemonic('o');
		optionsMenuItem.setText("Options");
		optionsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				optionsMenuItem1ActionPerformed(evt);
			}
		});

		fileMenu.add(optionsMenuItem);

		exitMenuItem.setMnemonic('x');
		exitMenuItem.setText("Zurück zum Menü");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				exitMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(exitMenuItem);

		menuBar.add(fileMenu);

		helpMenu.setMnemonic('h');
		helpMenu.setText("Help");

		contentsMenuItem.setMnemonic('c');
		contentsMenuItem.setText("Contents");
		contentsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				contentsMenuItemActionPerformed(evt);
			}
		});
		helpMenu.add(contentsMenuItem);

		aboutMenuItem.setMnemonic('a');
		aboutMenuItem.setText("About");
		aboutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				aboutMenuItemActionPerformed(evt);
			}
		});
		helpMenu.add(aboutMenuItem);

		menuBar.add(helpMenu);

		setJMenuBar(menuBar);

		BombsPic.setBounds(330, 100, 30, 30);
		BombsPic.setVisible(true);
		add(BombsPic);

		BombCounter.setFont(new Font("Arial", 1, 16)); // NOI18N
		BombCounter.setForeground(Color.BLACK);
		BombCounter.setHorizontalAlignment(SwingConstants.LEFT);
		BombCounter.setText("Bomben : "
				+ Bomberman.GetFigure1().getBombCounter());
		BombCounter.setBounds(355, 89, getWidth(), 60);
		add(BombCounter);

		FirePic.setBounds(330, 140, 30, 30);
		FirePic.setVisible(true);
		add(FirePic);

		FireCounter.setFont(new Font("Arial", 1, 16)); // NOI18N
		FireCounter.setForeground(Color.BLACK);
		FireCounter.setHorizontalAlignment(SwingConstants.LEFT);
		FireCounter.setText("Feuerkraft : "
				+ Bomberman.GetFigure1().getFirerange());
		FireCounter.setBounds(355, 129, getWidth(), 60);
		add(FireCounter);

		backgroundPanel.setBackground(Color.white);
		backgroundPanel.setBounds(0, 0, getWidth(), getHeight());

		backgroundPanel = Playground.createPlayground(backgroundPanel, true);
		add(backgroundPanel);

	}

	protected void LoadMenuItemActionPerformed(ActionEvent evt) {
		SaveLoad.Load(Bomberman.GetFigure1());

	}

	protected void SaveMenuItemActionPerformed(ActionEvent evt) {
		SaveLoad.Save();

	}

	private void optionsMenuItem1ActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void exitMenuItemActionPerformed(ActionEvent evt) {
		Bomberman.CloseGame();
		Bomberman.OpenMainMenu();
	}

	private void contentsMenuItemActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void aboutMenuItemActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

	public static void UpdateBombCounter() {
		BombCounter.setText("Bomben : "
				+ Bomberman.GetFigure1().getBombCounter());
	}

	public static void UpdateFireCounter() {
		FireCounter.setText("Feuerkraft : "
				+ Bomberman.GetFigure1().getFirerange());
	}
}
