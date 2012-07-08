package bomberman;

/**
 * 
 * @author Lukas
 * @version 08.07.2012
 */

public abstract class Client {

	protected Verbindung verbindung;
	private ClientLauscher lauscher;

	public Client(String serverName, int port) {
		verbindung = new Verbindung(serverName, port);
		lauscher = new ClientLauscher(verbindung, this);
	}

	protected void start() {
		lauscher.start();
	}

	public void ausgeben(String text) {
	}

	class ClientLauscher extends Thread {

		private Verbindung verbindung;
		private Client client;
		private boolean weiter;

		public ClientLauscher(Verbindung verbindung, Client client) {
			this.verbindung = verbindung;
			this.client = client;
		}

		public synchronized void run() {
			String nachricht;
			nachricht = verbindung.empfangen();
			while (nachricht != null) {
				System.out.println(nachricht);
				ausgeben(nachricht);
				nachricht = verbindung.empfangen();
			}
		}

	}

}
