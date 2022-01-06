package projectACL;

import java.awt.Color;

public class Floor extends Tile {
	public Floor() {
		this.setCanWalkOn(true);
		this.setFinishesGame(false);
		this.setType("Floor");
		//this.setColor(Color.WHITE);
		this.setImageSource("./images/grass.png");
	}
}
