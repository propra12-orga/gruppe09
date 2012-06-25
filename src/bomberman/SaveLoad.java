package bomberman;

import java.io.File;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JFileChooser;

public class SaveLoad extends JComponent {

	static JFileChooser fc;

	public static void Save() {

		fc = new JFileChooser();
		String SaveString;
		SaveString = "";
		for (int i = 1; i != 10; i++) {
			for (int j = 1; j != 10; j++) {
				// System.out.print(Playground.field[j][i].getType());
				if ((j == Playground.getSpalte())
						&& (i == Playground.getZeile()))
					SaveString = SaveString + "F";
				else
					SaveString = SaveString + Playground.field[j][i].getType();

			}
			SaveString = SaveString + "\r\n";
		}
		int returnVal = fc.showSaveDialog(fc);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			ReadInOut Save = new ReadInOut(file);
			try {
				Save.Overwrite(SaveString);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void Load(Figure Figur) {
		fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(fc);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			// Überschreiben des kompletten feldes, damit es leer ist
			for (int i = 1; i != 10; i++) {
				for (int j = 1; j != 10; j++) {
					SettingProperties.grass(j, i);
				}

				ReadInOut Openedfile = new ReadInOut(file);
				try {
					StringBuilder StringArray = Openedfile.read();
					String text = StringArray.toString();

					int x = 0;
					for (int j = 1; j != 10; j++) {
						for (int k = 1; k != 12; k++) {
							char c = text.charAt(x);
							if (c == 'W')
								SettingProperties.wall(k, j);
							if (c == 'D') {
								SettingProperties.hiddenstargate(k, j);
							}
							if (c == 'S')
								SettingProperties.stargate(k, j);
							if (c == 'G')
								SettingProperties.grass(k, j);
							if (c == 'B')
								SettingProperties.border(k, j);
							if (c == 'F') {
								SettingProperties.grass(k, j);
								Figur.setPosition(k * 30, j * 30);
								Playground.setSpalte(k);
								Playground.setZeile(j);
							}
							x++;
						}
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}
