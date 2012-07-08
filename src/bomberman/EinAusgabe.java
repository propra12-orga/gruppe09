package bomberman;
/**
 * 
 * @author Lukas
 * @version 08.07.2012
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EinAusgabe {

	// Objekt zum Lesen der Tastatureingabe
	BufferedReader ein;

	public EinAusgabe() {
		// Objekt zum Lesen der Tastatureingabe
		ein = new BufferedReader(new InputStreamReader(System.in));
	}

	public void schreiben(String text) {
		System.out.println(text);
	}

	public String lesen() {
		try {
			return ein.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int liesGanzeZahl() {
		try {
			return Integer.parseInt(ein.readLine());
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public double liesFliesskommaZahl() {
		try {
			return Double.parseDouble(ein.readLine());
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
