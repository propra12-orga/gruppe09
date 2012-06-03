/**
 * Last Author : Natalie Date: 03/06/12 Last Action:Klasse erstellt
 */

package bomberman;

import java.util.Enumeration;

public class Explosion {
		
	 	private static final int DELAY=1; 
	 	
		//Richtung der Flammen
		private static final int [] LEFT = {-1,0};
		private static final int [] RIGHT = {1,0};
		private static final int [] ABOVE = {0,-1};
		private static final int [] BOTTOM = {0,1};
		
		//Die Position der Explosionen auf den Feldern
		private int case_x, case_y;

		//Anzahl der Flammen
		public int fcreations;
		
		//Länge der Flammen
		private int distance; 
		
		private int delay;
		
		public Explosion(int case_x, int case_y, int fcreations, int distance){
			this.case_x=case_x; 
			this.case_y=case_y;
			this.fcreations=fcreations;
			this.distance=distance;
			
		}
		
		// Gibt Verzögerung zurück
		public static int getDelay() {
			return(DELAY);
		}
		
	
		
		public void explode() {
			delay--;
			if(delay<=0) {
				fcreations--;
				delay=DELAY;
			}
			new Flame(case_x,case_y, distance, LEFT, false);
			new Flame(case_x, case_y,distance, RIGHT, false);
			new Flame(case_x, case_y, distance, ABOVE, false);
			new Flame(case_x, case_y, distance, BOTTOM, false);
			
		}
}
