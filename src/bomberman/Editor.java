package bomberman;

/**
 * Last Author : Lukas Date: 03/06/12 Last Action: Schriftzug Bomberman nach unten gesetzt. Es wird jetzt ein Spielfeld generiert 
 */

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Editor extends JFrame implements ItemListener, MouseListener {

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

	private JPanel backgroundPanel;

	private ImageIcon IconGras;
	private ImageIcon IconGrenze;
	private ImageIcon IconMauer;
	private ImageIcon IconPortal;

	JLabel GewaehltesItemText;
	JLabel GewaehltesItemPic;
	String GewaehltesItemAuswahl;
	private JLabel Gras;
	private JLabel Grenze;
	private JLabel Mauer;
	private JLabel Portal;

	CheckboxGroup checkboxgroupRadio;

	// Checkboxen Auswahl
	Checkbox checkboxGras;
	Checkbox checkboxGrenze;
	Checkbox checkboxMauer;
	Checkbox checkboxPortal;
	Checkbox checkboxSpieler1;

	// Ende der Variablen Deklarationen
	public Editor() {
		super("Bomberman-Editor");
		setSize(600, 450);
		initComponents();
		addMouseListener(this);
	}

	public void paint(Graphics g) {
		super.paint(g);
	}

	private void initComponents() {
		GewaehltesItemAuswahl = "";
		menuBar = new JMenuBar();
		fileMenu = new JMenu();
		SaveMenuItem = new JMenuItem();
		LoadMenuItem = new JMenuItem();
		optionsMenuItem = new JMenuItem();
		exitMenuItem = new JMenuItem();

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

		setJMenuBar(menuBar);

		GewaehltesItemPic = new JLabel();
		GewaehltesItemPic.setBounds(350, 40, 30, 30);
		add(GewaehltesItemPic);

		IconGras = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
				Playground.class.getResource("grafics/map/grass.jpg")));
		IconGrenze = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
				Playground.class.getResource("grafics/map/block.png")));
		IconMauer = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
				Playground.class.getResource("grafics/map/box.png")));
		IconPortal = new ImageIcon(Toolkit.getDefaultToolkit().getImage(
				Playground.class.getResource("grafics/map/door.png")));

		GewaehltesItemText = new JLabel("Derzeit ausgewähltes Element:");
		GewaehltesItemText.setBounds(350, 10, 200, 30);
		add(GewaehltesItemText);

		Gras = new JLabel(IconGras);
		Gras.setBounds(350, 85, 30, 30);
		add(Gras);

		Grenze = new JLabel(IconGrenze);
		Grenze.setBounds(350, 145, 30, 30);
		add(Grenze);

		Mauer = new JLabel(IconMauer);
		Mauer.setBounds(350, 195, 30, 30);
		add(Mauer);

		Portal = new JLabel(IconPortal);
		Portal.setBounds(350, 245, 30, 30);
		add(Portal);

		checkboxgroupRadio = new CheckboxGroup();
		checkboxGras = new Checkbox("Gras", checkboxgroupRadio, false);
		checkboxGras.setBounds(390, 70, 60, 60);
		checkboxGras.addItemListener(this);
		add(checkboxGras);

		checkboxGrenze = new Checkbox("Grenze", checkboxgroupRadio, false);
		checkboxGrenze.setBounds(390, 125, 60, 70);
		checkboxGrenze.addItemListener(this);
		add(checkboxGrenze);

		checkboxMauer = new Checkbox("Mauer", checkboxgroupRadio, false);
		checkboxMauer.setBounds(390, 175, 60, 70);
		checkboxMauer.addItemListener(this);
		add(checkboxMauer);

		checkboxPortal = new Checkbox("Portal", checkboxgroupRadio, false);
		checkboxPortal.setBounds(390, 225, 60, 70);
		checkboxPortal.addItemListener(this);
		add(checkboxPortal);

		checkboxSpieler1 = new Checkbox("Startposition\n Spieler1",
				checkboxgroupRadio, false);
		checkboxSpieler1.setBounds(390, 275, 200, 70);
		checkboxPortal.addItemListener(this);
		add(checkboxSpieler1);

		backgroundPanel.setBackground(Color.white);
		backgroundPanel.setBounds(0, 0, getWidth(), getHeight());

		backgroundPanel = Playground.createPlayground(backgroundPanel, false);
		add(backgroundPanel);

	}

	protected void LoadMenuItemActionPerformed(ActionEvent evt) {
		Bomberman.starteSingleplayer();
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

	public void itemStateChanged(ItemEvent arg0) {

		Checkbox selected = checkboxgroupRadio.getSelectedCheckbox();

		if (selected != null) {
			if (selected.getLabel().equals("Gras")) {
				GewaehltesItemPic.setIcon((Icon) IconGras);
				GewaehltesItemAuswahl = "Gras";
			}
			if (selected.getLabel().equals("Grenze")) {

				GewaehltesItemPic.setIcon((Icon) IconGrenze);
				GewaehltesItemAuswahl = "Grenze";
			}
			if (selected.getLabel().equals("Mauer")) {
				GewaehltesItemPic.setIcon((Icon) IconMauer);
				GewaehltesItemAuswahl = "Mauer";
			}
			if (selected.getLabel().equals("Portal")) {
				GewaehltesItemPic.setIcon((Icon) IconPortal);
				GewaehltesItemAuswahl = "Portal";
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("geklickt");
		System.out.println(e.getX());
		System.out.println(e.getY());
		if (((e.getX() > 30) && (e.getX() < 60))
				&& ((e.getY() > 60) && (e.getY() <= 95))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(1, 1);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(1, 1);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(1, 1);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(1, 1);
		}
		if (((e.getX() > 60) && (e.getX() < 90))
				&& ((e.getY() > 60) && (e.getY() <= 95))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(2, 1);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(2, 1);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(2, 1);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(2, 1);
		}
		if (((e.getX() > 90) && (e.getX() < 120))
				&& ((e.getY() > 60) && (e.getY() <= 95))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(3, 1);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(3, 1);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(3, 1);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(3, 1);
		}
		if (((e.getX() > 120) && (e.getX() < 150))
				&& ((e.getY() > 60) && (e.getY() <= 95))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(4, 1);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(4, 1);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(4, 1);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(4, 1);
		}
		if (((e.getX() > 150) && (e.getX() < 180))
				&& ((e.getY() > 60) && (e.getY() <= 95))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(5, 1);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(5, 1);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(5, 1);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(5, 1);
		}
		if (((e.getX() > 180) && (e.getX() < 210))
				&& ((e.getY() > 60) && (e.getY() <= 95))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(6, 1);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(6, 1);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(6, 1);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(6, 1);
		}
		if (((e.getX() > 210) && (e.getX() < 240))
				&& ((e.getY() > 60) && (e.getY() <= 95))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(7, 1);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(7, 1);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(7, 1);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(7, 1);
		}
		if (((e.getX() > 240) && (e.getX() < 270))
				&& ((e.getY() > 60) && (e.getY() <= 95))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(8, 1);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(8, 1);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(8, 1);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(8, 1);
		}
		if (((e.getX() > 270) && (e.getX() < 300))
				&& ((e.getY() > 60) && (e.getY() <= 95))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(9, 1);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(9, 1);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(9, 1);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(9, 1);
		}
		if (((e.getX() > 30) && (e.getX() < 60))
				&& ((e.getY() > 90) && (e.getY() <= 125))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(1, 2);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(1, 2);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(1, 2);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(1, 2);
		}
		if (((e.getX() > 60) && (e.getX() < 90))
				&& ((e.getY() > 90) && (e.getY() <= 125))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(2, 2);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(2, 2);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(2, 2);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(2, 2);
		}
		if (((e.getX() > 90) && (e.getX() < 120))
				&& ((e.getY() > 90) && (e.getY() <= 125))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(3, 2);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(3, 2);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(3, 2);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(3, 2);
		}
		if (((e.getX() > 120) && (e.getX() < 150))
				&& ((e.getY() > 90) && (e.getY() <= 125))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(4, 2);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(4, 2);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(4, 2);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(4, 2);
		}
		if (((e.getX() > 150) && (e.getX() < 180))
				&& ((e.getY() > 90) && (e.getY() <= 125))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(5, 2);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(5, 2);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(5, 2);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(5, 2);
		}
		if (((e.getX() > 180) && (e.getX() < 210))
				&& ((e.getY() > 90) && (e.getY() <= 125))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(6, 2);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(6, 2);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(6, 2);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(6, 2);
		}
		if (((e.getX() > 210) && (e.getX() < 240))
				&& ((e.getY() > 90) && (e.getY() <= 125))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(7, 2);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(7, 2);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(7, 2);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(7, 2);
		}
		if (((e.getX() > 240) && (e.getX() < 270))
				&& ((e.getY() > 90) && (e.getY() <= 125))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(8, 2);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(8, 2);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(8, 2);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(8, 2);
		}
		if (((e.getX() > 270) && (e.getX() < 300))
				&& ((e.getY() > 90) && (e.getY() <= 125))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(9, 2);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(9, 2);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(9, 2);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(9, 2);
		}
		if (((e.getX() > 30) && (e.getX() < 60))
				&& ((e.getY() > 120) && (e.getY() <= 155))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(1, 3);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(1, 3);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(1, 3);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(1, 3);
		}
		if (((e.getX() > 60) && (e.getX() < 90))
				&& ((e.getY() > 120) && (e.getY() <= 155))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(2, 3);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(2, 3);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(2, 3);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(2, 3);
		}
		if (((e.getX() > 90) && (e.getX() < 120))
				&& ((e.getY() > 120) && (e.getY() <= 155))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(3, 3);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(3, 3);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(3, 3);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(3, 3);
		}
		if (((e.getX() > 120) && (e.getX() < 150))
				&& ((e.getY() > 120) && (e.getY() <= 155))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(4, 3);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(4, 3);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(4, 3);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(4, 3);
		}
		if (((e.getX() > 150) && (e.getX() < 180))
				&& ((e.getY() > 120) && (e.getY() <= 155))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(5, 3);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(5, 3);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(5, 3);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(5, 3);
		}
		if (((e.getX() > 180) && (e.getX() < 210))
				&& ((e.getY() > 120) && (e.getY() <= 155))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(6, 3);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(6, 3);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(6, 3);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(6, 3);
		}
		if (((e.getX() > 210) && (e.getX() < 240))
				&& ((e.getY() > 120) && (e.getY() <= 155))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(7, 3);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(7, 3);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(7, 3);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(7, 3);
		}
		if (((e.getX() > 240) && (e.getX() < 270))
				&& ((e.getY() > 120) && (e.getY() <= 155))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(8, 3);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(8, 3);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(8, 3);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(8, 3);
		}
		if (((e.getX() > 270) && (e.getX() < 300))
				&& ((e.getY() > 120) && (e.getY() <= 155))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(9, 3);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(9, 3);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(9, 3);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(9, 3);
		}
		if (((e.getX() > 30) && (e.getX() < 60))
				&& ((e.getY() > 150) && (e.getY() <= 185))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(1, 4);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(1, 4);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(1, 4);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(1, 4);
		}
		if (((e.getX() > 60) && (e.getX() < 90))
				&& ((e.getY() > 150) && (e.getY() <= 185))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(2, 4);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(2, 4);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(2, 4);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(2, 4);
		}
		if (((e.getX() > 90) && (e.getX() < 120))
				&& ((e.getY() > 150) && (e.getY() <= 185))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(3, 4);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(3, 4);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(3, 4);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(3, 4);
		}
		if (((e.getX() > 120) && (e.getX() < 150))
				&& ((e.getY() > 150) && (e.getY() <= 185))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(4, 4);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(4, 4);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(4, 4);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(4, 4);
		}
		if (((e.getX() > 150) && (e.getX() < 180))
				&& ((e.getY() > 150) && (e.getY() <= 185))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(5, 4);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(5, 4);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(5, 4);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(5, 4);
		}
		if (((e.getX() > 180) && (e.getX() < 210))
				&& ((e.getY() > 150) && (e.getY() <= 185))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(6, 4);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(6, 4);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(6, 4);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(6, 4);
		}
		if (((e.getX() > 210) && (e.getX() < 240))
				&& ((e.getY() > 150) && (e.getY() <= 185))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(7, 4);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(7, 4);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(7, 4);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(7, 4);
		}
		if (((e.getX() > 240) && (e.getX() < 270))
				&& ((e.getY() > 150) && (e.getY() <= 185))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(8, 4);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(8, 4);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(8, 4);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(8, 4);
		}
		if (((e.getX() > 270) && (e.getX() < 300))
				&& ((e.getY() > 150) && (e.getY() <= 185))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(9, 4);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(9, 4);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(9, 4);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(9, 4);
		}
		if (((e.getX() > 30) && (e.getX() < 60))
				&& ((e.getY() > 180) && (e.getY() <= 215))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(1, 5);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(1, 5);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(1, 5);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(1, 5);
		}
		if (((e.getX() > 60) && (e.getX() < 90))
				&& ((e.getY() > 180) && (e.getY() <= 215))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(2, 5);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(2, 5);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(2, 5);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(2, 5);
		}
		if (((e.getX() > 90) && (e.getX() < 120))
				&& ((e.getY() > 180) && (e.getY() <= 215))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(3, 5);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(3, 5);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(3, 5);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(3, 5);
		}
		if (((e.getX() > 120) && (e.getX() < 150))
				&& ((e.getY() > 180) && (e.getY() <= 215))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(4, 5);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(4, 5);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(4, 5);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(4, 5);
		}
		if (((e.getX() > 150) && (e.getX() < 180))
				&& ((e.getY() > 180) && (e.getY() <= 215))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(5, 5);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(5, 5);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(5, 5);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(5, 5);
		}
		if (((e.getX() > 180) && (e.getX() < 210))
				&& ((e.getY() > 180) && (e.getY() <= 215))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(6, 5);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(6, 5);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(6, 5);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(6, 5);
		}
		if (((e.getX() > 210) && (e.getX() < 240))
				&& ((e.getY() > 180) && (e.getY() <= 215))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(7, 5);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(7, 5);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(7, 5);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(7, 5);
		}
		if (((e.getX() > 240) && (e.getX() < 270))
				&& ((e.getY() > 180) && (e.getY() <= 215))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(8, 5);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(8, 5);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(8, 5);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(8, 5);
		}
		if (((e.getX() > 270) && (e.getX() < 300))
				&& ((e.getY() > 180) && (e.getY() <= 215))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(9, 5);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(9, 5);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(9, 5);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(9, 5);
		}
		if (((e.getX() > 30) && (e.getX() < 60))
				&& ((e.getY() > 210) && (e.getY() <= 245))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(1, 6);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(1, 6);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(1, 6);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(1, 6);
		}
		if (((e.getX() > 60) && (e.getX() < 90))
				&& ((e.getY() > 210) && (e.getY() <= 245))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(2, 6);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(2, 6);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(2, 6);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(2, 6);
		}
		if (((e.getX() > 90) && (e.getX() < 120))
				&& ((e.getY() > 210) && (e.getY() <= 245))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(3, 6);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(3, 6);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(3, 6);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(3, 6);
		}
		if (((e.getX() > 120) && (e.getX() < 150))
				&& ((e.getY() > 210) && (e.getY() <= 245))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(4, 6);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(4, 6);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(4, 6);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(4, 6);
		}
		if (((e.getX() > 150) && (e.getX() < 180))
				&& ((e.getY() > 210) && (e.getY() <= 245))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(5, 6);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(5, 6);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(5, 6);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(5, 6);
		}
		if (((e.getX() > 180) && (e.getX() < 210))
				&& ((e.getY() > 210) && (e.getY() <= 245))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(6, 6);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(6, 6);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(6, 6);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(6, 6);
		}
		if (((e.getX() > 210) && (e.getX() < 240))
				&& ((e.getY() > 210) && (e.getY() <= 245))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(7, 6);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(7, 6);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(7, 6);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(7, 6);
		}
		if (((e.getX() > 240) && (e.getX() < 270))
				&& ((e.getY() > 210) && (e.getY() <= 245))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(8, 6);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(8, 6);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(8, 6);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(8, 6);
		}
		if (((e.getX() > 270) && (e.getX() < 300))
				&& ((e.getY() > 210) && (e.getY() <= 245))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(9, 6);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(9, 6);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(9, 6);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(9, 6);
		}
		if (((e.getX() > 30) && (e.getX() < 60))
				&& ((e.getY() > 240) && (e.getY() <= 275))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(1, 7);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(1, 7);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(1, 7);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(1, 7);
		}
		if (((e.getX() > 60) && (e.getX() < 90))
				&& ((e.getY() > 240) && (e.getY() <= 275))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(2, 7);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(2, 7);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(2, 7);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(2, 7);
		}
		if (((e.getX() > 90) && (e.getX() < 120))
				&& ((e.getY() > 240) && (e.getY() <= 275))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(3, 7);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(3, 7);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(3, 7);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(3, 7);
		}
		if (((e.getX() > 120) && (e.getX() < 150))
				&& ((e.getY() > 240) && (e.getY() <= 275))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(4, 7);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(4, 7);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(4, 7);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(4, 7);
		}
		if (((e.getX() > 150) && (e.getX() < 180))
				&& ((e.getY() > 240) && (e.getY() <= 275))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(5, 7);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(5, 7);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(5, 7);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(5, 7);
		}
		if (((e.getX() > 180) && (e.getX() < 210))
				&& ((e.getY() > 240) && (e.getY() <= 275))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(6, 7);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(6, 7);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(6, 7);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(6, 7);
		}
		if (((e.getX() > 210) && (e.getX() < 240))
				&& ((e.getY() > 240) && (e.getY() <= 275))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(7, 7);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(7, 7);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(7, 7);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(7, 7);
		}
		if (((e.getX() > 240) && (e.getX() < 270))
				&& ((e.getY() > 240) && (e.getY() <= 275))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(8, 7);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(8, 7);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(8, 7);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(8, 7);
		}
		if (((e.getX() > 270) && (e.getX() < 300))
				&& ((e.getY() > 240) && (e.getY() <= 275))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(9, 7);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(9, 7);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(9, 7);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(9, 7);
		}
		if (((e.getX() > 30) && (e.getX() < 60))
				&& ((e.getY() > 270) && (e.getY() <= 305))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(1, 8);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(1, 8);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(1, 8);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(1, 8);
		}
		if (((e.getX() > 60) && (e.getX() < 90))
				&& ((e.getY() > 270) && (e.getY() <= 305))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(2, 8);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(2, 8);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(2, 8);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(2, 8);
		}
		if (((e.getX() > 90) && (e.getX() < 120))
				&& ((e.getY() > 270) && (e.getY() <= 305))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(3, 8);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(3, 8);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(3, 8);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(3, 8);
		}
		if (((e.getX() > 120) && (e.getX() < 150))
				&& ((e.getY() > 270) && (e.getY() <= 305))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(4, 8);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(4, 8);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(4, 8);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(4, 8);
		}
		if (((e.getX() > 150) && (e.getX() < 180))
				&& ((e.getY() > 270) && (e.getY() <= 305))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(5, 8);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(5, 8);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(5, 8);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(5, 8);
		}
		if (((e.getX() > 180) && (e.getX() < 210))
				&& ((e.getY() > 270) && (e.getY() <= 305))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(6, 8);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(6, 8);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(6, 8);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(6, 8);
		}
		if (((e.getX() > 210) && (e.getX() < 240))
				&& ((e.getY() > 270) && (e.getY() <= 305))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(7, 8);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(7, 8);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(7, 8);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(7, 8);
		}
		if (((e.getX() > 240) && (e.getX() < 270))
				&& ((e.getY() > 270) && (e.getY() <= 305))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(8, 8);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(8, 8);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(8, 8);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(8, 8);
		}
		if (((e.getX() > 270) && (e.getX() < 300))
				&& ((e.getY() > 270) && (e.getY() <= 305))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(9, 8);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(9, 8);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(9, 8);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(9, 8);
		}
		if (((e.getX() > 30) && (e.getX() < 60))
				&& ((e.getY() > 300) && (e.getY() <= 335))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(1, 9);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(1, 9);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(1, 9);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(1, 9);
		}
		if (((e.getX() > 60) && (e.getX() < 90))
				&& ((e.getY() > 300) && (e.getY() <= 335))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(2, 9);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(2, 9);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(2, 9);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(2, 9);
		}
		if (((e.getX() > 90) && (e.getX() < 120))
				&& ((e.getY() > 300) && (e.getY() <= 335))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(3, 9);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(3, 9);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(3, 9);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(3, 9);
		}
		if (((e.getX() > 120) && (e.getX() < 150))
				&& ((e.getY() > 300) && (e.getY() <= 335))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(4, 9);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(4, 9);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(4, 9);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(4, 9);
		}
		if (((e.getX() > 150) && (e.getX() < 180))
				&& ((e.getY() > 300) && (e.getY() <= 335))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(5, 9);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(5, 9);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(5, 9);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(5, 9);
		}
		if (((e.getX() > 180) && (e.getX() < 210))
				&& ((e.getY() > 300) && (e.getY() <= 335))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(6, 9);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(6, 9);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(6, 9);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(6, 9);
		}
		if (((e.getX() > 210) && (e.getX() < 240))
				&& ((e.getY() > 300) && (e.getY() <= 335))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(7, 9);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(7, 9);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(7, 9);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(7, 9);
		}
		if (((e.getX() > 240) && (e.getX() < 270))
				&& ((e.getY() > 300) && (e.getY() <= 335))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(8, 9);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(8, 9);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(8, 9);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(8, 9);
		}
		if (((e.getX() > 270) && (e.getX() < 300))
				&& ((e.getY() > 300) && (e.getY() <= 335))) {
			if (GewaehltesItemAuswahl == "Gras")
				SettingProperties.grass(9, 9);
			if (GewaehltesItemAuswahl == "Grenze")
				SettingProperties.border(9, 9);
			if (GewaehltesItemAuswahl == "Mauer")
				SettingProperties.wall(9, 9);
			if (GewaehltesItemAuswahl == "Portal")
				SettingProperties.stargate(9, 9);
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
