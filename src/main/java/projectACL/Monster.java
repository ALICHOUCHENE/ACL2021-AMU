package projectACL;
import java.util.Random;
public class Monster extends GameCharacter {
	
	static int strength;
	
	
	//constructors
	
	public Monster () {
		super();
	}
	
	public Monster(int xPos, int yPos) {
		
		super(xPos,yPos);
}

	public void move() {
		
		int newXPos= this.getxPos();
		int newYPos= this.getyPos();
		float randomStep;
		Random rand=new Random();
		
		// get the next step
		
		randomStep=randomStep();

		// define a random direction
		
		int pos=2;
		float randomPos=rand.nextInt(pos);

		if (randomPos == 1)
			newXPos+=randomStep;
		else
			newYPos+=randomStep;
		
		if (Labyrinth.validatePos(newXPos,newYPos)) {
			this.setxPos((int) newXPos);
			this.setyPos((int)newYPos);
		}
	}
	
	
	public String toString() {
		
        return "Monster Position: ( " + this.getxPos() + " , " + this.getyPos() + " )";
    }
	
	
	// choose the next step 1 or -1 for x and y
	
	
	private float randomStep() {
		
		Random rand=new Random();
		int randomStep=0;
		
		// define a random step
		
		int step=3;
		do {
		randomStep=rand.nextInt(step)-1;
		}while(randomStep==0);

		return randomStep;
	}
	
	
	// adding some intelligence to monsters
	
	public void moveIntelligent(Hero hero) {
		
		int [][]map= {
		     {0,0,0,0,0,0,0,0,0,0,0,0},
		     {3,1,1,1,1,0,1,1,1,1,1,0},
		     {0,1,0,0,0,0,4,0,0,0,1,0},
		     {0,1,1,1,1,0,1,0,1,0,1,0},
		     {0,1,0,1,1,0,1,0,1,1,4,0},
		     {0,0,0,1,4,1,1,0,1,1,1,0},
		     {0,1,1,1,1,1,1,1,1,0,0,0},
		     {0,1,0,0,1,0,1,1,1,1,1,0},
		     {0,1,1,0,1,0,0,0,1,1,1,0},
		     {0,0,0,0,1,1,1,0,0,0,1,0},
		     {0,1,1,1,1,1,1,0,1,0,1,2},
		     {0,0,0,0,0,0,0,0,0,0,0,0}
	};
		
		int xhero=hero.getxPos();
		int yhero=hero.getyPos();
		int xmonster=this.getxPos();
		int ymonster=this.getyPos();
		int newxPos=0;
		int newyPos=0;
		
		//System.out.println("***");
		//System.out.println("pos monster:");
		//System.out.println(xmonster);
		//System.out.println(ymonster);
		//System.out.println(map[ymonster][xmonster]);
		//System.out.println("***");
	    //System.out.println("pos hero:");
		//System.out.println(xhero);
		//System.out.println(yhero);
		
		// move up left
		
		if (xhero<=xmonster & yhero<=ymonster) {
		
		if( map[ymonster][xmonster - 1] == 1 || map[ymonster][xmonster - 1]==3 ) {
				xmonster--;	
				newxPos=xmonster;
				newyPos=ymonster;
				
					
			}
		 if( map[ymonster - 1][xmonster] == 1 ) {
			
				ymonster--;	
				newxPos=xmonster;
				newyPos=ymonster;
				
			}
		 else 
			 
			 this.move();
		 
		}
		
		
		// move up right 
		
		if (xhero>=xmonster & yhero <= ymonster) {
					
					if( map[ymonster][xmonster+1] == 1 || map[ymonster][xmonster+1] == 3) {
							xmonster++;	
							newxPos=xmonster;
							newyPos=ymonster;
								
						}
					
					if( map[ymonster][xmonster-1] == 1 ) {
						xmonster--;	
						newxPos=xmonster;
						newyPos=ymonster;
					}
					
					
					
					 if( map[ymonster-1][xmonster] == 1) {
						
							ymonster--;	
							newxPos=xmonster;
							newyPos=ymonster;
							
						}
					 else 
						 
						 this.move();
					 
					}
		
		// move down left
		
		if (xhero<=xmonster & yhero>=ymonster) {
			
			if( map[ymonster][xmonster-1] == 1 || map[ymonster][xmonster-1] == 3) {
					xmonster--;	
					newxPos=xmonster;
					newyPos=ymonster;
						
				}
			 if( map[ymonster + 1][xmonster] == 1 || map[ymonster + 1][xmonster] == 3) {
				
					ymonster++;	
					newxPos=xmonster;
					newyPos=ymonster;
					
				}
			 else 
				 
				 this.move();
			 
			}
		
		// move down right
		
		if (xhero>=xmonster & yhero>=ymonster) {
			
			if( map[ymonster][xmonster + 1] == 1 || map[ymonster][xmonster + 1] == 3) {
					xmonster++;	
					newxPos=xmonster;
					newyPos=ymonster;
						
				}
			 if( map[ymonster + 1][xmonster] == 1 || map[ymonster + 1][xmonster] == 3) {
				
					ymonster++;	
					newxPos=xmonster;
					newyPos=ymonster;
					
				}
			 else 
				 
				 this.move();
			 
			}
		
		
		
		if (Labyrinth.validatePos(newxPos,newyPos)) {
			this.setxPos( newxPos);
			this.setyPos( newyPos);
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	public void strike(GameCharacter character) {
		
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
