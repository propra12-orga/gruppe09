package bomberman;

/*
 * Folgende Fälle können eintreten
 * 1. Fall - Singeplayer, Spieler sprengt sich selbst -> Spiel verloren
 2. Fall - Singleplayer, Spieler erreicht das Tor -> Spiel gewonnen
 3. Fall - Multiplayer , Spieler 1 sprengt sich selbst -> Spieler 2 gewinnt
 4. Fall - Multiplayer, Spieler 2 sprengt sich selbst -> Spieler 1 gewinnt
 5. Fall - Multiplayer Beide Sprengen sich -> Unentschieden
 6. Fall - Spieler 1 erreicht das Tor - > Spieler 1 gewinnt
 7. Fall - Spieler 2 erreicht das Tor -> Spieler 2 gewinnt

 */

public class EndGame {

	public static void EndtheGame(boolean Win, boolean selfkill) {

		if (Bomberman.IsSingleplayer()) {

			stargate endgame;
			if (Win == true)
				endgame = new stargate(true, 0);
			if (selfkill == true)
				endgame = new stargate(false, 0);

		} else if (Bomberman.IsMultiplayer()) {

		}

	}
}
