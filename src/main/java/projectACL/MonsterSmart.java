package projectACL;

import java.util.Random;

import engine.Cmd;

public class MonsterSmart extends Monster {
	
	private Cmd lastmove;
	String[] frames = { "./images/monster/monsterSmart.png", "./images/monster/monsterSmartLeft.png", "./images/monster/monsterSmartRight.png"};
	
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
		
		String frame="";
		switch(getLastMove()) {
		
		case RIGHT:
			 frame= frames[2];
			 break;
		case LEFT:
			frame=frames[1];
			break;
		case UP:
			frame=frames[0];
			break;
		case DOWN:
			frame= frames[0];
			break;
		
		}
		return(frame);
		
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
				setLastMove( Cmd.LEFT) ;
				newxPos=xmonster;
				newyPos=ymonster;
				
					
			}
			else if( Labyrinth.validatePos(xmonster, ymonster-1) ) {
			
				ymonster--;	
				setLastMove(Cmd.DOWN);
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
							setLastMove(Cmd.RIGHT);
							newxPos=xmonster;
							newyPos=ymonster;
								
						}
					
					else if( Labyrinth.validatePos(xmonster-1, ymonster) ) {
						
						xmonster--;	
						setLastMove(Cmd.LEFT);
						newxPos=xmonster;
						newyPos=ymonster;
					}
					
					
					
					else if(Labyrinth.validatePos(xmonster, ymonster-1)) {
						
							ymonster--;	
							setLastMove(Cmd.DOWN);
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
					setLastMove(Cmd.LEFT);
					newxPos=xmonster;
					newyPos=ymonster;
						
				}
			else if( Labyrinth.validatePos(xmonster, ymonster+1)) {
				
					ymonster++;	
					setLastMove(Cmd.UP);
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
					setLastMove(Cmd.RIGHT);
					newxPos=xmonster;
					newyPos=ymonster;
						
				}
			 if( Labyrinth.validatePos(xmonster, ymonster+1)) {
				
					ymonster++;	
					setLastMove(Cmd.UP);
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
	
	public Cmd getLastMove() {
		return(lastmove);	
	}
	public void setLastMove(Cmd lastmove) {
		this.lastmove=lastmove;
	}
	
	
}