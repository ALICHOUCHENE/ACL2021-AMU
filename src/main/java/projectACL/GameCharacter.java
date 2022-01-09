package projectACL;

abstract class GameCharacter {
	
	private int xPos;
	private int yPos;
	private boolean teleporting = false;
	
	private String ImageSource;
	
	//constructors
	public GameCharacter () {
		this.xPos=0;
		this.yPos=0;
					}
	public GameCharacter(int xPos,int yPos) {
		this.xPos=xPos;
		this.yPos=yPos;
	}
	
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}



	abstract public void move(Hero hero);
	abstract public void strike(GameCharacter character);
	
	public void moveToPos( int [] pos) {
		int newXPos= pos[0];
		int newYPos= pos[1];
		if (Labyrinth.validatePos(newXPos, newYPos)) {
			this.setxPos(newXPos);
			this.setyPos(newYPos);	
		}	
	}
	
	public boolean teleporte() {
			
			int [] newPos;
			if ((newPos=Labyrinth.teleporte(this.getxPos(), this.getyPos()))!=null) {
				if (!this.isTeleporting()) {
					this.moveToPos(newPos);
					this.setTeleporting(true);
					return true;
				}
			}else {
				if (this.isTeleporting()) {
					this.setTeleporting(false);
				}
			}
			return false;
		}
	
	
	public void setImageSource(String ImageSource) {
		this.ImageSource = ImageSource;
	}
	
	public String getImageSource() {
		return ImageSource;
	}
	
	public boolean isTeleporting() {
		return teleporting;
	}

	public void setTeleporting(boolean teleporting) {
		this.teleporting = teleporting;
	}



}








