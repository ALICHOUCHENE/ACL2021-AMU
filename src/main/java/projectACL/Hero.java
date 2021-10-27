package projectACL;

public class Hero {
		
		private int xPos;
		private int yPos;
		
		//constructors
		public Hero () {
			super();
			this.xPos=0;
			this.yPos=0;
		}
		
		public Hero(int xPos, int yPos) {
			super();
			this.xPos = xPos;
			this.yPos = yPos;
		}
		
		
		//methods
		public void move(Labyrinth laby, char step) {
			int newXPos= this.getxPos();
			int newYPos= this.getyPos();
			
			//avoid upper and lower case confusion
			step= Character.toUpperCase(step);
			
			switch (step) {
				//go Up
				case 'Z':
					newYPos++;
					break;
				// go Down
				case 'S':
					newYPos--;
					break;
				//go left
				case 'Q':
					newXPos--;
					break;
				//go right
				case 'D':
					newXPos++;
					break;
				default:
					break;		
			}
			
			//check if new position is valid
			// if it is change the Hero's xPos and yPos accordingly
			
			if (laby.validatePos(newXPos,newYPos)) {
				this.setxPos(newXPos);
				this.setyPos(newYPos);
			}
		}
		
		public String toString() {
	        return "Hero Position: ( " + this.getxPos() + " , " + this.getyPos() + " )";
	    }
		
		//getters/setters
		public int getxPos() {
			return xPos;
		}

		public void setxPos(int xPos) {
			this.xPos = xPos;
		}

		public int getyPos() {
			return yPos;
		}

		public void setyPos(int yPos) {
			this.yPos = yPos;
		}
		
		
		
		
		
}
