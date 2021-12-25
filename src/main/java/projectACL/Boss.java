package projectACL;

public class Boss extends Monster{
	
	
	//constructors
	
	public Boss () {
		super();
	}
	
	public Boss(int xPos, int yPos) {
		super(xPos,yPos);
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
