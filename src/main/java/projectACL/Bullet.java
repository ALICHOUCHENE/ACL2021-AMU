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
				break;
			case DOWN:
				newYpos++;
				break;
			case RIGHT:
				newXpos++;
				break;
			case LEFT:
				newXpos--;
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
	
	

	
}
