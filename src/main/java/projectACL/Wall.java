package projectACL;

public class Wall extends Tile {
	public Wall() {
		this.setCanWalkOn(false);
		this.setFinishesGame(false);
		this.setType("Wall");
	}
}
