package projectACL;

import java.util.Random;

public class MonsterSmart extends Monster {
	
	String[] frames = { "./images/monster/monsterSmart.png", "./images/monster/monsterSmart.png", "./images/monster/monsterSmart.png"};
	
	//constructors
	public MonsterSmart () {
		super();
		this.setImageSource(frames[0]);
	}
	
	public MonsterSmart(int xPos, int yPos) {
		super(xPos,yPos);
		this.setImageSource(frames[0]);
	}

	
	// animating the moving of the monster
	public String getframe() {
		if (getImageSource()==(frames[0])) {
			
			return(frames[1]);
		}
		else if (getImageSource()==(frames[1])) {
			return(frames[2]);
		}
		else return(frames[0]);
	}
	
public void move(Hero hero) {
		
		
		
		int xhero=hero.getxPos();
		int yhero=hero.getyPos();
		int xmonster=this.getxPos();
		int ymonster=this.getyPos();
		int newxPos=0;
		int newyPos=0;
		
		
		
		if (xhero<=xmonster & yhero<=ymonster) {
		
			if( Labyrinth.validatePos(xmonster-1, ymonster) ) {
			
				xmonster--;	
				newxPos=xmonster;
				newyPos=ymonster;
				
					
			}
			else if( Labyrinth.validatePos(xmonster, ymonster-1) ) {
			
				ymonster--;	
				newxPos=xmonster;
				newyPos=ymonster;
				
			}
			else 
			 
				super.move(hero);
		 
		}
		
		
		// move up right 
		
		if (xhero>=xmonster & yhero <= ymonster) {
					
					if( Labyrinth.validatePos(xmonster+1, ymonster)) {
						
							xmonster++;	
							newxPos=xmonster;
							newyPos=ymonster;
								
						}
					
					else if( Labyrinth.validatePos(xmonster-1, ymonster) ) {
						
						xmonster--;	
						newxPos=xmonster;
						newyPos=ymonster;
					}
					
					
					
					else if(Labyrinth.validatePos(xmonster, ymonster-1)) {
						
							ymonster--;	
							newxPos=xmonster;
							newyPos=ymonster;
							
						}
					 else 
						 
						 super.move(hero);
					 
					}
		
		// move down left
		
		if (xhero<=xmonster & yhero>=ymonster) {
			
			if( Labyrinth.validatePos(xmonster-1, ymonster)) {
					xmonster--;	
					newxPos=xmonster;
					newyPos=ymonster;
						
				}
			else if( Labyrinth.validatePos(xmonster, ymonster+1)) {
				
					ymonster++;	
					newxPos=xmonster;
					newyPos=ymonster;
					
				}
			 else 
				 
				 super.move(hero);
			 
			}
		
		// move down right
		
		if (xhero>=xmonster & yhero>=ymonster) {
			
			if( Labyrinth.validatePos(xmonster+1, ymonster)) {
				
					xmonster++;	
					newxPos=xmonster;
					newyPos=ymonster;
						
				}
			 if( Labyrinth.validatePos(xmonster, ymonster+1)) {
				
					ymonster++;	
					newxPos=xmonster;
					newyPos=ymonster;

					
				}
			 else 
				 
				 super.move(hero);
			 
			}
		
		
		
		if (Labyrinth.validatePos(newxPos,newyPos)) {
			this.setxPos( newxPos);
			this.setyPos( newyPos);
			this.setImageSource(getframe()); // animating the moving of the monster
		}
		
	}
	
	
	public String toString() {
        return "Monster Position: ( " + this.getxPos() + " , " + this.getyPos() + " )";
    }
	
	
}