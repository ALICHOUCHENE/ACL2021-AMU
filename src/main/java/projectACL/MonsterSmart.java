package projectACL;

import java.util.Random;
public class MonsterSmart extends Monster {
	
	String[] frames = { "./images/monster/monsterSmart.png", "./images/monster/monsterLeft.png", "./images/monster/monsterRight.png"};
	
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
	
	public void move(Labyrinth laby) {
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
		
		if (laby.validatePos(newXPos,newYPos)) {
			this.setxPos((int) newXPos);
			this.setyPos((int)newYPos);
			this.setImageSource(getframe()); // animating the moving of the monster
		}
	}
	
	
	public String toString() {
        return "Monster Position: ( " + this.getxPos() + " , " + this.getyPos() + " )";
    }
	
	
	// choose the next step 1 or -1 for x and y
	private float randomStep() {
		Random rand=new Random();
		float randomStep=0;
		// define a random step
		int step=3;
		do {
		randomStep=rand.nextInt(step)-1;
		}while(randomStep==0);

		return randomStep;
	}
}