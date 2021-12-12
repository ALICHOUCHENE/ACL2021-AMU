package projectACL;

import java.awt.Color;

public class Door extends Tile{
	public Door(){
		this.setCanWalkOn(true);
		this.setFinishesGame(true);
		this.setType("Door");
		this.setColor(Color.GREEN);
	}
}
