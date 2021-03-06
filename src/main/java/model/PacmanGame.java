package model;

import java.util.Random;


import java.io.BufferedReader;

import java.io.BufferedReader; 

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import engine.Cmd;
import engine.Game;
import projectACL.Bullet;
import projectACL.Hero;
import projectACL.Labyrinth;
import projectACL.Monster;
import projectACL.MonsterIntelligent;
import projectACL.Fantum;
import projectACL.Boss;
import projectACL.MonsterSmart;
import projectACL.Tile;
import projectACL.Door;
import projectACL.Life;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         Version avec personnage qui peut se deplacer. A completer dans les
 *         versions suivantes.
 * 
 */
public class PacmanGame implements Game {

	/**
	 * constructeur avec fichier source pour le help
	 * 
	 */
	

	private Hero hero= new Hero();
	private Labyrinth laby;
	private ArrayList<Monster> monsters;
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private long gameTime;
	private ArrayList<Life> Lives;
	
	private static boolean nextLevel = false;

	
	public PacmanGame(String source, int level) {

		BufferedReader helpReader;
		try {
			helpReader = new BufferedReader(new FileReader(source));
			String ligne;
			while ((ligne = helpReader.readLine()) != null) {
				System.out.println(ligne);
			}
			helpReader.close();
		} catch (IOException e) {
			System.out.println("Help not available");
		}

		this.generateGame(level);
		PacmanGame.setNextLevel(false);

	}

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */

	public void evolve(Cmd commande) {
		//System.out.println("Execute "+commande);
		
		this.hero.teleporte();
		
		switch (commande) {
		
		case RIGHT:
			hero.moveRight();
			break;
			
		case LEFT:
			hero.moveLeft();
		break; 
		
		case UP:
			hero.moveUp();
		break;
		
		case DOWN:
			hero.moveDown();
		break;
		
		case SHOOT:
			this.generateBullet();
			//hero.shoot(); TODO
		break;
		
		case IDLE:
			break;
		}
		//teleporte
		
		
		//
		bulletKillMonster();
		
		// evolve monsters
		moveMonsters();
		
		// evolve bullets
		moveBullets();
		
		// evolve life
		evolveLife();
		}

	
	
	
	
	
	/**
	 * verifier si le jeu est fini
	 */
	public boolean nextlevel() {
		boolean position;
		position=(Labyrinth.getDimX()-1==hero.getxPos()) & (Labyrinth.getDimY()-2==hero.getyPos());
		return(position);
	}
	
	public boolean isFinished() {
		boolean state=false;
		state=(this.laby.getFinishLine()[0]==hero.getxPos()) && (this.laby.getFinishLine()[1]==hero.getyPos());
		return(state);
	}	
	
	public boolean isGameOver() {
		for(int i = 0; i<monsters.size();i++) {
			if(monsters.get(i).getxPos()==hero.getxPos() & monsters.get(i).getyPos()==hero.getyPos()) {
				hero.lose1HP();
				System.out.println(hero.getlives());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
}}

		if (hero.getlives()<=0) {return true;}
		return false;
}
	
	private void generateGame(int level) {
		this.laby=new Labyrinth(level);
		this.hero= this.generateHero();
		this.monsters=this.generateMonsters();
		this.Lives=this.generateLife();
		this.gameTime=System.currentTimeMillis();
	}
	
	
	private Hero generateHero() {
		Hero pacman;
		int[] pacmanPos= laby.getHeroSpawn();
		pacman= new Hero(pacmanPos[0],pacmanPos[1]);
		return(pacman);
	}
	
	private ArrayList<Monster> generateMonsters(){
		ArrayList<int[]> monsterSpawn = laby.getMonsterSpawn();
		ArrayList<Monster> monsters= new ArrayList<Monster>();
		int[] pos;
		for (int i=0;i<monsterSpawn.size();i++) {
			pos=monsterSpawn.get(i);
			if (pos[2]==1)	
				monsters.add(new Monster(pos[0],pos[1]));
			else
				monsters.add(new MonsterSmart(pos[0],pos[1]));
		}
		return(monsters);
	}

	private ArrayList<Life> generateLife(){
		ArrayList<int[]> lifeSpawn = laby.getLifeSpawn();
		ArrayList<Life> Lives= new ArrayList<Life>();
		int[] pos;
		for (int i=0;i<lifeSpawn.size();i++) {
			pos=lifeSpawn.get(i);
			Lives.add(new Life());
			Lives.get(i).setXpos(pos[0]);
			Lives.get(i).setYpos(pos[1]);
		}
		return(Lives);
	}
	
	private void evolveLife() {
		int xHero;
		int yHero;
		int xheart;
		int yheart;
		
		for(int i=0;i<Lives.size();i++) {
			xHero=this.hero.getxPos();
			yHero=this.hero.getyPos();
			xheart=Lives.get(i).getXpos();
			yheart=Lives.get(i).getYpos();
			
			if(xHero==xheart && yHero==yheart && Lives.get(i).getState()) {
				this.hero.addLife();
				Lives.get(i).setState();
				
				
			}
			// update icone
			
			if ((xheart!=xHero | yheart!=yHero) & Lives.get(i).getState()==false) 
				Lives.get(i).updateIcone2();
			
			if (xHero==xheart & yHero==yheart & Lives.get(i).getState()==false)
				Lives.get(i).updateIcone1();
					
			

			}
		}
		
		
	
	
	
	
	
	
	
	
	
	private void moveMonsters() {
		long currTime= System.currentTimeMillis();
		if((currTime-gameTime>500)& (!this.monsters.isEmpty())) {
			for(int i = 0; i<monsters.size();i++) {
				if(!monsters.get(i).teleporte()) {
					monsters.get(i).move(this.hero);
				}
			}
			this.gameTime= System.currentTimeMillis();
		}
	}
	
	private void moveBullets() {
		if(!this.bullets.isEmpty()) {
			for(int i = 0; i<bullets.size();i++) {
				bullets.get(i).evolve(laby);
				if (!bullets.get(i).isBullet_alive()) {
					this.bullets.remove(i);
				}
			}
		}
	}
	
	private void generateBullet() {
		Bullet newBullet = new Bullet(hero,laby);
		if (newBullet.isBullet_alive()) {
			if (this.bullets.isEmpty()) {
				this.bullets.add(newBullet);
			}else {
				//avoid shooting more than one bullet at a time
				int lastIndex=this.bullets.size()-1;
				long lastTrigger= this.bullets.get(lastIndex).getTrigger_time();
				if (newBullet.getTrigger_time()-lastTrigger>200) {
					this.bullets.add(newBullet);
				}
			}
		}
	}
	
	private void bulletKillMonster() {
		if((!this.bullets.isEmpty())&(!this.monsters.isEmpty())){
			for (int i=0; i< bullets.size();i++) {
				for (int j=0;j<monsters.size();j++) {
					if ((bullets.get(i).getxPos()==monsters.get(j).getxPos())&(bullets.get(i).getyPos()==monsters.get(j).getyPos())) {
						this.bullets.remove(i);
						this.monsters.remove(j);
						if((!this.bullets.isEmpty())||(!this.monsters.isEmpty())) {
							break;
						}
					}
				}
				break;
			}
		}
	}
	
	//getters and setters

	
	//getters and setters

	public Hero getHero() {
		return hero;
	}
	public ArrayList<Life> getLife() {
		return Lives;
	}

	public Labyrinth getLaby() {
		return laby;
	}

	public ArrayList<Monster> getMonstres() {
		return monsters;
	}
		
	public ArrayList<Bullet> getBullets() {
		return bullets;

	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public static boolean isNextLevel() {
		return nextLevel;
	}

	public static void setNextLevel(boolean nextLevel) {
		PacmanGame.nextLevel = nextLevel;
	}
	
	
	

	
	
}