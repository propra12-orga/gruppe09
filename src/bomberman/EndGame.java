package bomberman;

public class EndGame {
	/**
	 * Folgende Fälle können eintreten 1. Fall - Singeplayer, Spieler sprengt
	 * sich selbst -> Spiel verloren 2. Fall - Singleplayer, Spieler erreicht
	 * das Tor -> Spiel gewonnen 3. Fall - Multiplayer , Spieler 1 sprengt sich
	 * selbst -> Spieler 2 gewinnt 4. Fall - Multiplayer, Spieler 2 sprengt sich
	 * selbst -> Spieler 1 gewinnt 5. Fall - Multiplayer Beide Sprengen sich ->
	 * Unentschieden 6. Fall - Spieler 1 erreicht das Tor - > Spieler 1 gewinnt
	 * 7. Fall - Spieler 2 erreicht das Tor -> Spieler 2 gewinnt
	 * 
	 * Die Klasse EndGame fasst die möglichen Ausgänge des Spiels zusammen.
	 * 
	 * @author Lukas
	 * @verion 25/06/2012
	 */

	public static void EndtheGame(boolean Win, boolean selfkillplayer1,
			boolean selfkillplayer2, boolean draw) {

		if (Bomberman.IsSingleplayer()) {

			stargate endgame;
			if (Win == true)
				endgame = new stargate(true, 0, false);
			if (selfkillplayer1 == true)
				endgame = new stargate(false, 0, false);

		} else if (Bomberman.IsMultiplayer()) {

			stargate endgame;
			if (draw == true)
				endgame = new stargate(false, 0, true);
			else if (selfkillplayer1 == true)
				endgame = new stargate(true, 1, false);
			else if (selfkillplayer2 == true)
				endgame = new stargate(true, 0, false);
		}

	}
}
