package projectACL;

import java.awt.Color;

public abstract class Tile {

	protected static int length = 60;
	protected static int width = 60;
	private boolean canWalkOn=false;
	private boolean finishesGame= false;
	private boolean teleporte = false;
	private String imageSource;
	private String type;
	private Color color;
	
	
	
	
	public static void setLength(int length) {
		Tile.length = length;
	}

	public static void setWidth(int width) {
		Tile.width = width;
	}

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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isTeleporte() {
		return teleporte;
	}

	public void setTeleporte(boolean teleporte) {
		this.teleporte = teleporte;
	}
	
	
	
	
	
	
}