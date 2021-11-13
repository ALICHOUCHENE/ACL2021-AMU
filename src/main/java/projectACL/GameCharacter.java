package projectACL;

public class GameCharacter {
	
	private int xPos;
	private int yPos;
	
	//constructors
	public GameCharacter () {
		this.xPos=0;
		this.yPos=0;
					}
	public GameCharacter(int xPos,int yPos) {
		this.xPos=xPos;
		this.yPos=yPos;
	}
	
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
}
