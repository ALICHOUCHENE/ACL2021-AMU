package projectACL;


public abstract class Tile {

	protected static final int length = 20;
	protected static final int width = 20;
	private boolean canWalkOn;
	private boolean finishesGame;
	private String imageSource;
	
	
	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}

	public boolean isFinishesGame() {
		return finishesGame;
	}

	public void setFinishesGame(boolean finishesGame) {
		this.finishesGame = finishesGame;
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