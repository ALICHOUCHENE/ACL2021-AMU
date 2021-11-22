package projectACL;

//class Labyrinth: a maze with 2 dimensions dimx an dimy
public class Labyrinth {
		
		private final static int dimx=12;
		private final static int dimy=12;
		private Tile[][] build= new Tile[dimx][dimy];
		private String level;
		private int [] startPos= new int [2];
		private int [] endPos= new int [2];
		
	
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


		public String getLevel() {
			return level;
		}

		public void setLevel(String level) {
			this.level = level;
		}

		public int [] getStartPos() {
			return startPos;
		}

		public void setStartPos(int [] startPos) {
			this.startPos = startPos;
		}

		public int [] getEndPos() {
			return endPos;
		}

		public void setEndPos(int [] endPos) {
			this.endPos = endPos;
		}
	
}
