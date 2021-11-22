package projectACL;

//class Labyrinth: a maze with 2 dimensions dimx an dimy
public class Labyrinth {
		
		private final static int dimx=25;
		private final static int dimy=25;
		private Tile[][] level= new Tile[dimx][dimy];
	
		// Constructor
		public  Labyrinth() {
			super();
		}
	
		// this function checks if the hero's movement (x,y) is valid in the labyrinth or not
		public static boolean validatePos(int xPos, int yPos) {
			return (( 0 <= xPos ) && (xPos <= Labyrinth.dimx)  && (0 <= yPos) && (yPos <= Labyrinth.dimy));
		}
		
		//getters
		public static int getDimX() {
			return Labyrinth.dimx;
		}
		
		public static int getDimY() {
			return Labyrinth.dimy;
		}
	
}
