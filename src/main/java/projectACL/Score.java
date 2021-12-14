package projectACL;

public class Score {
	
	private Labyrinth laby;
	private Hero hero;
	private Monster monster;
	
	// Constructer
	
	public Score(Labyrinth laby,Hero hero,Monster monster) {
		
		this.laby=laby;
		this.hero=hero;
		this.monster=monster;
		
	}
	
	
	public boolean heroDead(Hero hero,Monster monster) {
		boolean state=false;
		if ((hero.getxPos() == monster.getxPos()) && (hero.getyPos()==monster.getyPos()))
			state=true;
		
		return state;
		
	}
	
	
	
	
	
	
	
	
	

}
