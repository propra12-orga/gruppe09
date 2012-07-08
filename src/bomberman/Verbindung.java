package bomberman;
/**
 * 
 * @author Lukas
 * @version 08.07.2012
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Verbindung {
	private Socket s;
	private BufferedReader vomHost;
	private PrintWriter zumHost;
	private String serverName;
	private int port;
	private String fehler;

	public Verbindung(String serverName, int port) {
		this.serverName = serverName;
		this.port = port;
		verbinden();
	}

	public Verbindung(Socket socket) {
		s = socket;
		try {
			// Objekt zum Versenden von Nachrichten �ber den Socket erzeugen
			zumHost = new PrintWriter(s.getOutputStream(), true);
			// Objekt zum Empfangen von Nachrichten �ber das Socketobjekt
			// erzeugen
			vomHost = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String verbinden() {
		try {
			s = new Socket(serverName, port);
			// Objekt zum Versenden von Nachrichten �ber den Socket erzeugen
			zumHost = new PrintWriter(s.getOutputStream(), true);
			// Objekt zum Empfangen von Nachrichten �ber das Socketobjekt
			// erzeugen
			vomHost = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			return "Verbindung : " + s;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public String empfangen() {
		try {
			return vomHost.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void senden(String nachricht) {
		zumHost.println(nachricht);
		zumHost.flush();
	}

	public synchronized void syncSenden(String nachricht) {
		zumHost.println(nachricht);
		zumHost.flush();
	}

	public String eigenerPort() {
		return "" + s.getLocalPort();
	}

	public String eigeneAdresse() {
		return "" + s.getLocalAddress();
	}

	public String entfernteAdresse() {
		return "" + s.getInetAddress();
	}

	public String entfernterPort() {
		return "" + s.getPort();
	}

	public boolean istVerbunden() {
		return s.isConnected();
	}

	public void schliessen() {
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
