package projectACL;


public abstract class Tile {

	protected static final int length = 60;
	protected static final int width = 60;
	private boolean canWalkOn;
	private boolean finishesGame;
	private String imageSource;
	private String type;
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}

	public void setFinishesGame(boolean finishesGame) {
		this.finishesGame = finishesGame;
	}
	
	public boolean isFinishesGame() {
		return finishesGame;
	}

	public Tile() {
		super();
	}

	public boolean isCanWalkOn() {
		return canWalkOn;
	}

	public void setCanWalkOn(boolean canWalkOn) {
		this.canWalkOn = canWalkOn;
	}

	public static int getLength() {
		return length;
	}

	public static int getWidth() {
		return width;
	}
	
	
	
	
}