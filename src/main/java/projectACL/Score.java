package projectACL;

public class Score {
	
	
	private Hero hero;
	private Monster monster;
	private int l; //number of lives
	
	// Constructer
	
	public Score() {
		
	}
	
	
	
	public int lives() {  // TODO game finished when l=0 and not when herodead : for level 2
		if (heroDead() )
			l--;
		return l;
	}
	
	
	public boolean heroDead() {
		boolean state=false;
		if ((hero.getxPos() == monster.getxPos()) && (hero.getyPos()==monster.getyPos())) {
			state=true;
			
		}
		return state;
		
	}
	
	public boolean heroWin() {
		boolean state=false;
		if ((hero.getxPos() == 13) && (hero.getyPos()==13)) {
			state=true;
			
		}
		return state;
		
	}
	
	
	
	
	
	


}
