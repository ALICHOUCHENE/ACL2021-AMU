package projectACL;

import java.awt.Color;

public class Wall extends Tile {
	public Wall() {
		this.setCanWalkOn(false);
		this.setFinishesGame(false);
		this.setType("Wall");
		this.setColor(Color.BLACK);
	}
}
