package projectACL;

import java.util.ArrayList;


import engine.Cmd;

public class Bullet {
	
	private int xPos;
	private int yPos;
	private Cmd direction;
	private boolean bullet_alive=true;
	private long trigger_time;
	private int speed;
	private String imageSource; 
	private String[] sprites = {"./images/fireballUP.png", "./images/fireballDOWN.png", "./images/fireballRIGHT.png", "./images/fireballLEFT.png"};
	
	public Bullet(Hero pacman, Labyrinth laby) {
		this.direction=pacman.getLast_move();
		this.xPos=pacman.getxPos();
		this.yPos=pacman.getyPos();
		this.evolve(laby);
		this.trigger_time=System.currentTimeMillis();
		this.speed=500;//the speed of the bullet
	}
	
	
	//bullets moving in the labyrinth
	public void evolve(Labyrinth laby) {
		if (System.currentTimeMillis()-this.trigger_time>this.speed) {
			int newXpos= this.xPos;
			int newYpos= this.yPos;
			switch(this.direction) {
			case UP:
				newYpos--;
				setImageSource("./images/fireball/fireballUP.png");
				break;
			case DOWN:
				newYpos++;
				setImageSource("./images/fireball/fireballDOWN.png");
				break;
			case RIGHT:
				newXpos++;
				setImageSource("./images/fireball/fireballRIGHT.png");
				break;
			case LEFT:
				newXpos--;
				setImageSource("./images/fireball/fireball.png");
				break;
			default:
				break;			
			}
			if (Labyrinth.validatePos(newXpos, newYpos)) {
				this.xPos=newXpos;
				this.yPos=newYpos;
				this.trigger_time=System.currentTimeMillis();
			}else {
				//the bullet hits a wall or similar and is no longer active
				this.bullet_alive=false;
			}
		}
	}
	
	//getters and setters
	
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

	public boolean isBullet_alive() {
		return bullet_alive;
	}

	public void setBullet_alive(boolean bullet_alive) {
		this.bullet_alive = bullet_alive;
	}


	public long getTrigger_time() {
		return trigger_time;
	}


	public void setTrigger_time(long trigger_time) {
		this.trigger_time = trigger_time;
	}
	
	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}

	
}
