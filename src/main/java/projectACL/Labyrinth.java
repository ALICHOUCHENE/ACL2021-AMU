package projectACL;

//class Labyrinth: a maze with 2 dimensions dimx an dimy
public class Labyrinth {
		private final static int dimx=25;
		private final static int dimy=25;
	
		// Constructor
		public  Labyrinth(int dimx, int dimy) {
			super();
		}
	
		// this function checks if the hero's movement (x,y) is valid in the labyrinth or not
		public boolean validatePos(int xPos, int yPos) {
			return (( 0 <= xPos ) && (xPos <= this.getDimX())  && (0 <= yPos) && (yPos <= this.getDimY()));
		}
		
		//getters
		public static int getDimX() {
			return Labyrinth.dimx;
		}
		
		public static int getDimY() {
			return Labyrinth.dimy;
		}
	
		

		/*
		// main
		public static void main(String[] args){
			int xPos=10; 		// should be xPos=Hero.xPos and yPos=Hero.yPos
			int yPos=10;
			
			Labyrinth Laby = new  Labyrinth(10, 100);	//create an object Labyrinth, we can change dimx and dimy values here
			
			System.out.println("Labyrinth atributes (dimx, dimy) are ( "+  Laby.dimx + " , " + Laby.dimy + " )"); 		 // test if the object Labyrinth is created
			System.out.println("The new position " + xPos + ", " + yPos + " is valid: " + Laby.validatePos(xPos,yPos));  //test if the movement of the hero is valid
		}
		 */
}
