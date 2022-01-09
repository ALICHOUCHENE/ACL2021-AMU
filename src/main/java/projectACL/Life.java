package projectACL;
import java.awt.Color;
public class Life extends Tile {
		private int xpos;
		private int yPos;
		private boolean exist=true;
		public Life() {
			this.setCanWalkOn(true);
			this.setFinishesGame(false);
			this.setType("Floor");

			// add image path
			
			this.setImageSource("./images/heart.png");
		}
		
		// once the hero took the heart, its image will dissapear
		public void updateIcone1() {
			this.setImageSource("./images/grass-hero.png");
		}
		
		public void updateIcone2() {
			this.setImageSource("./images/grass.png");
		}
		
		
	public void setXpos(int xPos) {
		this.xpos=xPos;
	}
	
	
	public void setYpos(int yPos) {
		this.yPos=yPos;
	}
	public int getXpos() {
		return(this.xpos);
	}
	
	
	public int getYpos() {
		return(this.yPos);
	}
	public boolean getState() {
		return(this.exist);
	}
	
	public void setState() {
		this.exist=false;
	}
	
	
}
