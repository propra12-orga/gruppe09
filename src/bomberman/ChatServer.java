package bomberman;

/**
 * 
 * @author Lukas
 * @version 08.07.2012
 */

import java.util.Enumeration;
import java.util.Hashtable;

public class ChatServer extends Server {
	// Verwaltung der Clients
	private Hashtable clients;

	public ChatServer(int port) {
		// Konstruktor der Oberklasse aufrufen
		super(port);
		// Tabelle zur Verwaltung der Clients erzeugen
		clients = new Hashtable();
	}

	/**
	 * Anmeldung durchführen, Client eintragen und alle anderen informieren
	 * Damit die Eintragung in die Hashtabelle nicht unterbrochen wird, erhält
	 * die Methode das Schlüsselwort synchronized
	 */
	public boolean anmelden(Verbindung verbindung) {
		// Anmeldephase
		boolean erfolg = false;
		verbindung.senden("Willkommen beim ChatServer "
				+ verbindung.eigeneAdresse() + " " + verbindung.eigenerPort());
		// Warte auf Benutzernamen
		boolean weiter = true;
		while (weiter) {
			String name = verbindung.empfangen();
			if (name.startsWith("USER")) {
				// Nickname bestimmen
				name = name.substring(5).trim();
				// Wenn Nickname noch nicht vergeben ist, wird er eingetragen
				synchronized (clients) {
					if (!clients.containsKey(name)) {
						// Client in Tabelle eintragen
						clients.put(name, verbindung);
						erfolg = true;
					}
				}
				if (erfolg) {
					verbindung.senden("+OK " + name + " willkommen im Chat");
					// Join Message wird ausgegeben
					String nachricht = name + " hat Chat betreten";
					// Alle clients benachrichtigen
					anAlle(nachricht);
					// Anmeldung beendet
					weiter = false;
				} else {
					verbindung.senden("-ERR bereits angemeldet");
				}
			} else
				verbindung.senden("-ERR Syntaxfehler");
		}
		return erfolg;
	}

	/**
	 * Durchführung des Chat
	 */
	public void chat(Verbindung verbindung) {
		// Chat-Phase
		String nachricht;
		boolean weiter = true;
		// Benutzername des Client ermitteln
		String name = gibName(verbindung);
		// Nachricht vom Client
		nachricht = verbindung.empfangen();
		// Solange der Client angemeldet ist
		while (weiter) {
			// Falls die Verbindung unterbrochen wurde
			if (nachricht == null)
				abmelden(verbindung);
			else {

				if (nachricht.startsWith("MSG"))
					anAlle(name + ": " + nachricht.substring(4));
				// Wer ist im Chat?
				if (nachricht.startsWith("WHO")) {
					// Alle Benutzernamen ermitteln
					Enumeration aufzaehlung = clients.keys();
					while (aufzaehlung.hasMoreElements())
						// Nickname senden
						verbindung.syncSenden((String) aufzaehlung
								.nextElement());
				}
				// Chat verlassen
				if (nachricht.equals("QUIT")) {
					abmelden(verbindung);
					weiter = false;
				}
			}
			if (verbindung.istVerbunden())
				nachricht = verbindung.empfangen();
			else
				weiter = false;
		}
	}

	/**
	 * Entfernt den Client aus der Liste und sendet allen Clients die
	 * entsprechende Nachricht
	 */
	public void abmelden(Verbindung verbindung) {
		// Nickname des Client ermitteln
		String name = gibName(verbindung);
		// Client aus der Liste entfernen, falls er nicht schon entfernt wurde
		synchronized (clients) {
			if (clients.contains(name))
				clients.remove(name);
		}
		// Verlassen des Chats allen anderen bekannt geben
		anAlle(name + " hat Chat verlassen");
		verbindung.schliessen();
	}

	/**
	 * Sendet eine Nachricht an alle Clients, zur Anzeige im Chat-Fenster
	 */
	public void anAlle(String nachricht) {
		Enumeration aufzaehlung = clients.elements();
		while (aufzaehlung.hasMoreElements()) {
			Verbindung verbindung = (Verbindung) aufzaehlung.nextElement();
			// Nachricht zum Client senden, falls die Verbindung noch besteht
			// sonst Empfaenger ebenfalls abmelden
			if (verbindung.istVerbunden())
				verbindung.syncSenden(nachricht);
			else
				abmelden(verbindung);
		}
	}

	public void protokoll(Verbindung verbindung) {
		// Anmeldephase
		if (anmelden(verbindung))
			;
		// Chat + Abmeldephase
		chat(verbindung);
	}

	public String gibName(Verbindung verbindung) {
		boolean gefunden = false;
		String name = "";
		Enumeration aufzaehlung = clients.keys();
		while (aufzaehlung.hasMoreElements() && !gefunden) {
			name = (String) aufzaehlung.nextElement();
			if (verbindung == (Verbindung) clients.get(name))
				gefunden = true;
		}
		if (gefunden)
			return name;
		else
			return null;
	}

	public static void main(String args[]) {
		new ChatServer(1100).start();
	}
}
