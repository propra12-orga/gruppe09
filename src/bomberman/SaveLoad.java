package bomberman;

import java.io.IOException;

public class SaveLoad {

	public static void Save() {
		String SaveString;
		SaveString = "";
		for (int i = 1; i != 10; i++) {
			for (int j = 1; j != 10; j++) {
				System.out.print(Playground.field[j][i].getType());
				if ((j == Playground.getSpalte())
						&& (i == Playground.getZeile()))
					SaveString = SaveString + "F";
				else
					SaveString = SaveString + Playground.field[j][i].getType();

			}
			SaveString = SaveString + "\r\n";
		}
		ReadInOut Save = new ReadInOut("test.txt");
		try {
			Save.Overwrite(SaveString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void Load(Figure Figur) {
		// Überschreiben des kompletten feldes, damit es leer ist
		for (int i = 1; i != 10; i++) {
			for (int j = 1; j != 10; j++) {
				SettingProperties.grass(j, i);
			}

			String str = "test.txt";
			ReadInOut file = new ReadInOut(str);
			try {
				StringBuilder StringArray = file.read();
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
