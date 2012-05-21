package bomberman;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

/*Last Author: Lukas
 * Date: 09.05.12
 * 
 * Benutzung von ReadInOut :
 * Die Klasse dient zum auslesen und speichern von Textdateien.
 * Zum Benutzen muss ein neuer Typ der Klasse ReadInOut erzeugt werden
 * und dem Construktor der Dateiname �bergeben werden. 
 * Das die Datei im Projekt ordner liegt ist obligatorisch.
 * Danach kann man die Methoden Read oder Overwrite ganz normal aufrufen.
 * 
 * Funktionen Doku:
 * read();
 * gibt derzeit den eingelesen Text auf der Konsole aus, muss noch an das Projekt angepasst werden (String r�ckgabe)
 * 
 * Overwrite (String);
 * Ben�tigt einen Parameter des Types String, diesen schreibt er dann  in die Datei. Achtung! Diese funktion �berschreibt die gesamte Datei, der Rest geht verloren! 
 *
 * Beispiel f�r Erzeugung der ReadInOut-Klasse
 *String fileName = "test.txt";
 ReadInOut test = new ReadInOut( fileName);
 */
public class ReadInOut {

	// Attributdeklaration
	private static String fFileName;
	private static String fEncoding;

	ReadInOut(String aFileName) {
		fEncoding = "UTF-8";// Standart UTF-8 Kann ge�ndert werden, wei� aber
							// net wieso wir das machen sollten
		fFileName = aFileName;
	}

	void read() throws IOException {
		print("Einlesen der Datei:.");
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
		print("Text: " + text);
	}

	void Overwrite(String Text) throws IOException {
		print("Datei wird �berschrieben " + fFileName);
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