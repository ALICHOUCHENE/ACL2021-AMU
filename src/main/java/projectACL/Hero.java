
package projectACL;

import engine.Cmd;

public class Hero extends GameCharacter {

	String[] frames = {"./images/hero/IDLE/hero.png", "./images/hero/IDLE/hero1.png", 
						"./images/hero/move/hero.png", "./images/hero/move/hero1.png", 
						"./images/hero/move/hero2.png", "./images/hero/move/hero3.png",
						"./images/hero/move/heroleft.png", "./images/hero/move/heroleft1.png",
						"./images/hero/move/heroleft2.png", "./images/hero/move/heroleft3.png" 
					};
	
	//constructors
		private Cmd last_move = Cmd.RIGHT;
		
		public Hero () {
				super();
				this.setImageSource(frames[0]);
			}
			
		public Hero(int xPos, int yPos) {
			super(xPos,yPos);
			this.setImageSource(frames[0]);
		}
		
		
		//methods
		
		// animating the moving of the monster
		public String getframe(Cmd commande) {
			String frame="";
			switch(commande) {
			case UP:
				frame = getImageSource();
				break;
			case DOWN:
				frame = getImageSource();
				break;
			case RIGHT:
				if ((getImageSource()== frames[6]) | (getImageSource()==frames[7]) |  (getImageSource()==frames[8]) | (getImageSource()==frames[9])) {
					frame= frames[2];
				}
				
				else if (getImageSource()==frames[2]) {
					frame= frames[3];
				}
				else if (getImageSource()==frames[3]) {
					frame= frames[4];
				}
				else if (getImageSource()==frames[4]) {
					frame= frames[5];
				}
				else if (getImageSource()==frames[5]) {
					frame= frames[2];
				}
				else if (getImageSource()==frames[0]) {
					frame= frames[2];
				}
				break;
			case LEFT:
				//if was right 
				if ((getImageSource()== frames[2]) | (getImageSource()==frames[3]) |  (getImageSource()==frames[4]) | (getImageSource()==frames[5])) {
					frame= frames[6];
				}
				
				//if left
				else if (getImageSource()==frames[6]) {
				frame= frames[7];
				}
				else if (getImageSource()==frames[7]) {
					frame= frames[8];
				}
				else if (getImageSource()==frames[8]) {
					frame= frames[9];
				}
				else if (getImageSource()==frames[9]) {
					frame= frames[6];
				}
			
				else if (getImageSource()==frames[1]) {
					frame= frames[6];
				}
			 
				break;
				
			case IDLE:
				if( (getImageSource()== frames[2]) | (getImageSource()==frames[3]) |  (getImageSource()==frames[4]) | (getImageSource()==frames[5])) {
					frame = frames[0];
				}
				else if ((getImageSource()== frames[6]) | (getImageSource()==frames[7]) |  (getImageSource()==frames[8]) | (getImageSource()==frames[9])) {
				
					frame = frames[1];
				}
			}
			return(frame);
		}
		
		//update hero's position
		public void moveUp() {
			int newYPos= this.getyPos();
			int newXPos= this.getxPos();
			Cmd commande = Cmd.UP;
			newYPos--;
			
			//checks if the new position is valid before updating
			if (Labyrinth.validatePos(newXPos, newYPos)) {
				this.setyPos(newYPos);
				this.last_move=Cmd.UP;
				this.setImageSource(getframe(commande));
			}
				
			else System.out.println(" Hero can't move up ");
			
		}

		public void moveDown() {
			int newYPos= this.getyPos();
			int newXPos= this.getxPos();
			Cmd commande = Cmd.DOWN;
			newYPos++;
			if (Labyrinth.validatePos(newXPos, newYPos)) {
				this.setyPos(newYPos);
				this.last_move=Cmd.DOWN;
				this.setImageSource(getframe(commande));

			}
			else System.out.println(" Hero can't move down ");
				
		}
		 
		public void moveRight() {
			int newXPos= this.getxPos();
			int newYPos= this.getyPos();
			Cmd commande = Cmd.RIGHT;
			newXPos++;
			if (Labyrinth.validatePos(newXPos, newYPos)) {
				this.setxPos(newXPos);
				this.last_move=Cmd.RIGHT;
				this.setImageSource(getframe(commande));
			}
			else System.out.println(" Hero can't move right ");
			
		}
		
		public void moveLeft() {
			int newXPos= this.getxPos();
			int newYPos= this.getyPos();
			Cmd commande = Cmd.LEFT;
			newXPos--;
			if (Labyrinth.validatePos(newXPos, newYPos)) {
				this.setxPos(newXPos);
				this.last_move=Cmd.LEFT;
				this.setImageSource(getframe(commande));
			}
			else System.out.println(" Hero can't move left ");
			
		}
		
		
		
		//display hero's position
		public String toString() {
	        return "Hero Position: ( " + this.getxPos() + " , " + this.getyPos() + " )";
	    }

		public void strike(GameCharacter character) {
			
		}

		
		public void teleporte( int[] newPos) {
			int newXPos= newPos[0];
			int newYPos= newPos[1];
			if (Labyrinth.validatePos(newXPos, newYPos)) { 
				this.setxPos(newXPos);
				this.setyPos(newYPos);
				
			}
		}
		
		public void move(Hero hero) {
		
		}
		public Cmd getLast_move() {
			return last_move;
		}

		public void setLast_move(Cmd last_move) {
			this.last_move = last_move;
		}
		
		
				
		
}
