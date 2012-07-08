package bomberman;

/**
 * 
 * @author Lukas
 * @version 08.07.2012
 */

public class ChatClient extends Client {

	private EinAusgabe konsole;

	public ChatClient(String name, String serverName, int port) {
		super(serverName, port);
		start();
		verbindung.senden("USER " + name);
	}

	public void trennen() {
		verbindung.senden("QUIT");
		verbindung.schliessen();
	}

	public void zumServerSenden(String nachricht) {
		if (nachricht.equals("WHO"))
			verbindung.senden(nachricht);
		else {
			// Flüstern
			if (nachricht.charAt(0) == '#')
				verbindung.senden("PRIVMSG " + nachricht.substring(1));
			else
				// Nachricht an alle
				verbindung.senden("MSG " + nachricht);
		}
	}

	public void ausgeben(String nachricht) {
		Spielgui.schreib(nachricht);
	}

}
