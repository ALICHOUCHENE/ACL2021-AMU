package projectACL;

public class MonsterIntelligent extends Monster{
	
static int strength;
	
	
	//constructors
	
	public MonsterIntelligent () {
		super();
	}
	
	public MonsterIntelligent(int xPos, int yPos) {
		
		super(xPos,yPos);
}
public void move(Hero hero) {
		
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
	    System.out.println("pos hero:");
		System.out.println(xhero);
		System.out.println(yhero);
		
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
			 
			 super.move(hero);
		 
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
						 
						 super.move(hero);
					 
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
				 
				 super.move(hero);
			 
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
				 
				 super.move(hero);
			 
			}
		
		
		
		if (Labyrinth.validatePos(newxPos,newyPos)) {
			this.setxPos( newxPos);
			this.setyPos( newyPos);
		}
		
		
		
		
		
		
		
		
		
	}
}
