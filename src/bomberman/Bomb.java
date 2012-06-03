/**
 * Last Author : Natalie Date: 03/06/12 Last Action: Klasse erstellt
 */
package bomberman;


public class Bomb {

	//das Spielfeld
	public Playground playground; 
	
	//Anzahl der Bilder für die Animation der Bombe
	public int images;
	
	//Position der Bombe in den Feldern
	public int case_x, case_y; 
	
	//Gibt an, dass eine Bombe gezuendet wurde
	public boolean detonator; 
	
	//Gibt den Radius der Bombe an
	int radius = 0; 
	
	//Gibt den Bombenleger an
	public Figure figure;
	
	//GIbt die Zündungszeit an
	public int delay;
	
	// Erzeugt eine neue Bombe
	public Bomb (int case_x, int case_y, boolean detonator, int radius, Figure figure, int delay, int images){
		this.case_x=case_x;
		this.case_y=case_y;
		this.detonator=detonator; 
		this.figure=figure;
		this.delay=delay;
		this.images=images;
		
	}
		
	public void explode() {
		figure.plantBomb(this);
	}
		

    public boolean isExplosion(int x, int y) {
        return false;
    }
}
