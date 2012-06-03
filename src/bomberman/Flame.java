/**
 * Last Author : Natalie Date: 03/06/12 Last Action:Klasse erstellt
 */

package bomberman;

public class Flame {
	
		public static int [] [] table_flames;
		
		//Position der Flammen
		public int case_x, case_y;
		
		//Länge der Flamme
		public int distance;
		
		//Richtung der Flamme
		public int[] direction;
		
		//Gibt an ob Flamme eine Mauer zerstören kann
		public boolean last; 
		
		//Gibt das Ende der Flamme an;
		public int end; 
		
		private static final int DELAY = Explosion.getDelay();
		
		public Flame(int case_x, int case_y, int distance, int [] direction, boolean last){
			this.case_x=case_x;
			this.case_y=case_y;
			this.distance=distance; 
			this.direction=direction;
			this.last=last; 
			this.end=DELAY;
			table_flames[case_x][case_y]++;
				
		}
}
