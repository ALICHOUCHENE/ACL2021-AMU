package projectACL;


public abstract class Tile {

	protected static final int length = 20;
	protected static final int width = 20;
	private boolean canWalkOn;
	
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