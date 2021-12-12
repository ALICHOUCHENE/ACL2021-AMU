package projectACL;

public class Door extends Tile{
	public Door(){
		this.setCanWalkOn(true);
		this.setFinishesGame(true);
		this.setType("Door");
	}
}
