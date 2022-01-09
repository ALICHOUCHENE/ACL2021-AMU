package projectACL;

import java.awt.Color;

public class Wormhole extends Tile {
	public Wormhole() {
		this.setCanWalkOn(true);
		this.setFinishesGame(false);
		this.setType("Floor");
		this.setColor(Color.BLACK);
		this.setTeleporte(true);
		//this.setImageSource("./images/wormhole.png");
	}
}


