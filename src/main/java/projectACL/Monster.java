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

	public void move(Hero hero) {
		
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
