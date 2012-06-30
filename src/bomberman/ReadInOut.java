package bomberman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

/**
 * Die Klasse dient dem Auslesen und Speichern von Dateien (zB level1.txt). Zum
 * Benutzen muss ein neuer Typ der Klasse ReadInOut erzeugt werden. Beispiel für
 * Erzeugung der ReadInOut-Klasse: String fileName = "test.txt"; ReadInOut test
 * = new ReadInOut(fileName);
 * 
 * Danach kann man die Methoden Read oder Overwrite ganz normal aufrufen.
 * 
 * @author Lukas
 * @version 25/06/12
 * 
 */
public class ReadInOut {

	// Attributdeklaration
	private static File fFileName;
	private static String fEncoding;

	ReadInOut(File aFileName) {
		fEncoding = "UTF-8";// Standart UTF-8 Kann geändert werden, weiß aber
							// net wieso wir das machen sollten
		fFileName = aFileName;
	}

	/**
	 * Gibt derzeit den eingelesen Text auf der Konsole aus.
	 * 
	 * @return String
	 * @throws IOException
	 */
	public StringBuilder read() throws IOException {
		StringBuilder text = new StringBuilder();
		String NL = System.getProperty("line.separator");
		Scanner scanner = new Scanner(new FileInputStream(fFileName), fEncoding);
		try {
			while (scanner.hasNextLine()) {
				text.append(scanner.nextLine() + NL);
			}
		} finally {
			scanner.close();
		}

		return text;
	}

	/**
	 * Benötigt einen Parameter des Types String, diesen schreibt er dann in die
	 * Datei. Achtung! Diese Funktion überschreibt die gesamte Datei, der Rest
	 * geht verloren.
	 * 
	 * @param Text
	 * @throws IOException
	 */
	void Overwrite(String Text) throws IOException {
		print("Datei wird überschrieben " + fFileName);
		Writer out = new OutputStreamWriter(new FileOutputStream(fFileName),
				fEncoding);
		try {
			out.write(Text);
		} finally {
			out.close();
		}
	}

	void Save(String Text) throws IOException {
		Writer out = new OutputStreamWriter(new FileOutputStream(fFileName),
				fEncoding);
		try {
			out.write(Text);
		} finally {
			out.close();
		}
	}

	// Hilfsmethode, weil ich zu faul war immer System usw zu schreiben
	private void print(String aMessage) {
		System.out.println(aMessage);
	}

}