package projectACL;

public class Fantum extends Monster{
	
	// constructors
	
	public Fantum () {
		
		super();
	}
	
	public Fantum(int xPos, int yPos) {
		
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
		
				xmonster--;	
				ymonster--;	
				newxPos=xmonster;
				newyPos=ymonster;
				
		}		
		
		if (xhero>=xmonster & yhero <= ymonster) {
					
				xmonster++;
				xmonster--;	
				newxPos=xmonster;
				newyPos=ymonster;
								
						
		}
		
		// move down left
		
		
		if (xhero<=xmonster & yhero>=ymonster) {
			

				xmonster--;	
				ymonster++;	
				newxPos=xmonster;
				newyPos=ymonster;
					
					
		}
		
		if (xhero>=xmonster & yhero>=ymonster) {
			
				xmonster++;	
				ymonster++;	
				newxPos=xmonster;
				newyPos=ymonster;
										
								 
			}
		
		else 
			super.move(hero);
		
		if(newxPos<=Labyrinth.getDimX()-1 & newxPos>=0 & newyPos<=Labyrinth.getDimY()-1 & newyPos>=0) {
			
		this.setxPos( newxPos);
		this.setyPos( newyPos);
		}
	
	

	
	
	}	
	
}
		
