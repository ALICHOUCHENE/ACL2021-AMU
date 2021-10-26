package projectACL;

//class Labyrinth: a maze with 2 dimensions dimx an dimy
public class Labyrinth {
		private int dimx;
		private int dimy;
	
		// Constructor
		public  Labyrinth(int dimx, int dimy) {
			this.dimx=dimx;
			this.dimy=dimy;	
		}
	
		// this function checks if the hero's movement (x,y) is valid in the labyrinth or not
		public boolean validatePos(int xPos, int yPos) {
			return (( 0 <= xPos ) && (xPos <= this.getDimX())  && (0 <= yPos) && (yPos <= this.getDimY()));
		}
		
		//getters
		public int getDimX() {
			return this.dimx;
		}
		
		public int getDimY() {
			return this.dimy;
		}
	
		//setters
		public void setDimX(int dimx) {
			this.dimx=dimx;
		}
		
		public void setDimY(int dimy) {
			this.dimy=dimy;
		}
		

		
		// main
		public static void main(String[] args){
			int xPos=10; 		// should be xPos=Hero.xPos and yPos=Hero.yPos
			int yPos=10;
			
			Labyrinth Laby = new  Labyrinth(10, 100);	//create an object Labyrinth, we can change dimx and dimy values here
			
			System.out.println("Labyrinth atributes (dimx, dimy) are ( "+  Laby.dimx + " , " + Laby.dimy + " )"); 		 // test if the object Labyrinth is created
			System.out.println("The new position " + xPos + ", " + yPos + " is valid: " + Laby.validatePos(xPos,yPos));  //test if the movement of the hero is valid
		}
}
