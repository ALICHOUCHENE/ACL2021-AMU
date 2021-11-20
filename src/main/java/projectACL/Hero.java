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
		
		//update hero's position
		public void moveUp() {
			int newYPos= this.getyPos();
			int newXPos= this.getxPos();
			newYPos--;
			//checks if the new position is valid before updating
			if (Labyrinth.validatePos(newXPos, newYPos))
				this.setyPos(newYPos);
			else System.out.println(" Hero can't move up ");
			
		}

		public void moveDown() {
			int newYPos= this.getyPos();
			int newXPos= this.getxPos();
			newYPos++;
			if (Labyrinth.validatePos(newXPos, newYPos))
				this.setyPos(newYPos);
			else System.out.println(" Hero can't move down ");
				
		}
		
		public void moveRight() {
			int newXPos= this.getxPos();
			int newYPos= this.getyPos();
			newXPos++;
			if (Labyrinth.validatePos(newXPos, newYPos))
				this.setxPos(newXPos);
			else System.out.println(" Hero can't move right ");
			
		}
		
		public void moveLeft() {
			int newXPos= this.getxPos();
			int newYPos= this.getyPos();
			newXPos--;
			if (Labyrinth.validatePos(newXPos, newYPos))
				this.setxPos(newXPos);
			else System.out.println(" Hero can't move left ");
			
		}
		
		
		//display hero's position
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
