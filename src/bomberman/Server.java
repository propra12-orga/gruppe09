package bomberman;
/**
 * 
 * @author Lukas
 * @version 08.07.2012
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class Server {

	private Mitarbeiter mitarbeiter;
	private ServerSocket serverSocket;
	private int port;

	public Server(int port) {
		this.port = port;
	}

	public void start() {
		try {
			// TCP-Socketobjekt f�r eingehende Verbindungesw�nsche
			serverSocket = new ServerSocket(port);
			while (true) {
				// Warten auf eingehende Verbindungsw�nsche
				// Erzeugung eines Sockets zur Kommunikation mit dem Client
				Socket socket = serverSocket.accept();
				System.out.println("Verbindung von " + socket);
				// f�r den Client wird ein eigener Thread gestartet
				Verbindung verbindung = new Verbindung(socket);
				mitarbeiter = new Mitarbeiter(verbindung, this);
				mitarbeiter.start();
			}
		} catch (IOException e) {
			System.out.println("Verbindungsfehler");
		}

	}

	public abstract void protokoll(Verbindung verbindung);

	public class Mitarbeiter extends Thread {
		private Verbindung verbindung;
		private Server server;

		public Mitarbeiter(Verbindung verbindung, Server server) {
			super();
			this.verbindung = verbindung;
			this.server = server;
		}

		public void run() {
			server.protokoll(verbindung);
		}
	}

}
