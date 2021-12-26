
package projectACL;

import engine.Cmd;

public class Hero extends GameCharacter {

	//constructors
		private Cmd last_move = Cmd.IDLE;
		public Hero () {
				super();
			}
			
		public Hero(int xPos, int yPos) {
			super(xPos,yPos);
		}
		
		
		//methods
		
		//update hero's position
		public void moveUp() {
			int newYPos= this.getyPos();
			int newXPos= this.getxPos();
			newYPos--;
			//checks if the new position is valid before updating
			if (Labyrinth.validatePos(newXPos, newYPos)) {
				this.setyPos(newYPos);
				this.last_move=Cmd.UP;
			}
			else System.out.println(" Hero can't move up ");
			
		}

		public void moveDown() {
			int newYPos= this.getyPos();
			int newXPos= this.getxPos();
			newYPos++;
			if (Labyrinth.validatePos(newXPos, newYPos)) {
				this.setyPos(newYPos);
				this.last_move=Cmd.DOWN;
			}
			else System.out.println(" Hero can't move down ");
				
		}
		
		public void moveRight() {
			int newXPos= this.getxPos();
			int newYPos= this.getyPos();
			newXPos++;
			if (Labyrinth.validatePos(newXPos, newYPos)) {
				this.setxPos(newXPos);
				this.last_move=Cmd.RIGHT;
			}
			else System.out.println(" Hero can't move right ");
			
		}
		
		public void moveLeft() {
			int newXPos= this.getxPos();
			int newYPos= this.getyPos();
			newXPos--;
			if (Labyrinth.validatePos(newXPos, newYPos)) {
				this.setxPos(newXPos);
				this.last_move=Cmd.LEFT;
			}
			else System.out.println(" Hero can't move left ");
			
		}
		
		
		//display hero's position
		public String toString() {
	        return "Hero Position: ( " + this.getxPos() + " , " + this.getyPos() + " )";
	    }

		public Cmd getLast_move() {
			return last_move;
		}

		public void setLast_move(Cmd last_move) {
			this.last_move = last_move;
		}
		
		
		
		
		
		
		
}
