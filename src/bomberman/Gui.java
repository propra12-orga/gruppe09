/**
 * Last Author : Dirk Date: 02/06/12 Last Action: Automatisch erzeugten Quelltext auf das reduziert, was wir brauchen.
 *  Anweisungen sortiert und für die Übersichtlichkeit Imports hinzugefügt.
 */
package bomberman;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Gui extends JFrame {

    // Variablen Deklarationen
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem singleplayerMenuItem;
    private JMenuItem multiplayerMenuItem;
    private JMenuItem optionsMenuItem;
    private JMenuItem highscoreMenuItem;
    private JMenuItem exitMenuItem;
    private JMenu helpMenu;
    private JMenuItem contentsMenuItem;
    private JMenuItem aboutMenuItem;

    private JLabel bombermanLetters;
    private JPanel backgroundPanel;

    // Ende der Variablen Deklarationen
    public Gui() {
        setSize(700, 400);
        initComponents();
    }

    private void initComponents() {

        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        singleplayerMenuItem = new JMenuItem();
        multiplayerMenuItem = new JMenuItem();
        optionsMenuItem = new JMenuItem();
        highscoreMenuItem = new JMenuItem();
        exitMenuItem = new JMenuItem();
        helpMenu = new JMenu();
        contentsMenuItem = new JMenuItem();
        aboutMenuItem = new JMenuItem();

        bombermanLetters = new JLabel();
        backgroundPanel = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Menu");

        singleplayerMenuItem.setMnemonic('s');
        singleplayerMenuItem.setText("Singleplayer");
        singleplayerMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                singleplayerMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(singleplayerMenuItem);

        multiplayerMenuItem.setMnemonic('p');
        multiplayerMenuItem.setText("Multiplayer");
        multiplayerMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                multiplayerMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(multiplayerMenuItem);

        optionsMenuItem.setMnemonic('o');
        optionsMenuItem.setText("Options");
        optionsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                optionsMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(optionsMenuItem);

        highscoreMenuItem.setMnemonic('h');
        highscoreMenuItem.setText("Highscore");
        highscoreMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                highscoreMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(highscoreMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
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

        bombermanLetters.setFont(new Font("Blade Runner Movie Font", 1, 24)); // NOI18N
        bombermanLetters.setForeground(new Color(51, 255, 0));
        bombermanLetters.setHorizontalAlignment(SwingConstants.CENTER);
        bombermanLetters.setText("Bomberman");
        bombermanLetters.setBounds(0, 0, getWidth(), 60);
        add(bombermanLetters);

        backgroundPanel.setBackground(new Color(0, 0, 0));
        backgroundPanel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundPanel);
    }

    private void singleplayerMenuItemActionPerformed(ActionEvent evt) {
        Bomberman.starteSingleplayer();
    }

    private void multiplayerMenuItemActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void optionsMenuItem1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void highscoreMenuItemActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void exitMenuItemActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void contentsMenuItemActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void aboutMenuItemActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

}
