package projectACL;
	

public class Boss extends Monster{
	
	static int strength;
	
	
	//constructors
	
	public Boss () {
		
		super();
	}
	
	public Boss(int xPos, int yPos) {
		
		super(xPos,yPos);
}	
	
public void move(Hero hero) {
		
		
		
		int xhero=hero.getxPos();
		int yhero=hero.getyPos();
		int xmonster=this.getxPos();
		int ymonster=this.getyPos();
		int newxPos=0;
		int newyPos=0;
		
		
		// move up left
		
		if (xhero<=xmonster & yhero<=ymonster) {
		
		if( Labyrinth.validatePos(xmonster-1, ymonster) ) {
			
				xmonster--;	
				newxPos=xmonster;
				newyPos=ymonster;
				
					
			}
		 if( Labyrinth.validatePos(xmonster, ymonster-1) ) {
			
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
					
					if( Labyrinth.validatePos(xmonster-1, ymonster) ) {
						
						xmonster--;	
						newxPos=xmonster;
						newyPos=ymonster;
					}
					
					
					
					 if(Labyrinth.validatePos(xmonster, ymonster-1)) {
						
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
			 if( Labyrinth.validatePos(xmonster, ymonster+1)) {
				
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
		}
		
		
	
	}




	public void teleporte( int x , int y) {
		
		int newXPos= x;
		int newYPos= y;
		
		if (Labyrinth.validatePos(newXPos, newYPos)) {
			this.setxPos(newXPos);
			this.setyPos(newYPos);
			
		}
			

		
	}
	
	
	
	
}

