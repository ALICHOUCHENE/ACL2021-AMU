package model;

import java.util.Random;
import java.io.BufferedReader;

import java.io.BufferedReader; 

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import engine.Cmd;
import engine.Game;
import projectACL.Monster;
import projectACL.Bullet;
import projectACL.Hero;
import projectACL.Labyrinth;
import projectACL.Monster;
import projectACL.MonsterIntelligent;
import projectACL.Fantum;
import projectACL.Boss;


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
	private int [] levelTable= {500,400,300,200,100};

	
	public PacmanGame(String source) {

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

		
		this.laby=new Labyrinth(1);
		this.hero= this.generateHero();
		this.monsters=this.generateMonsters();
		this.gameTime=System.currentTimeMillis();
	}

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */

	public void evolve(Cmd commande, int level) {
		//System.out.println("Execute "+commande);

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
		break;
		
		case IDLE:
			break;
		}
		
		//bullets kill monsters
		bulletKillMonster();
		
		if( level>=1 & level<=5) 
		moveMonsters(levelTable[level-1]);
		
		if (level==6)
			moveMonsters(levelTable[levelTable.length-1]);
			//moveFantum();
		
		if(level==7)
			moveMonsters(levelTable[levelTable.length-1]);
			//moveFantum();
			//moveBoss();
		
		// evolve bullets
		moveBullets();
		

		
	}

	
	
	
	
	
	/**
	 * verifier si le jeu est fini
	 */
	
	@Override
	public boolean isFinished() {
		// le jeu n'est jamais fini
		return((Labyrinth.getDimX()-1==hero.getxPos()) & (Labyrinth.getDimY()-2==hero.getyPos())); 
		//finish line is (Dimx, Dimy)
		//check GameEngineGraphical if i want to make display changes
	
		
	}
	
	
	public boolean isGameOver() {
		for(int i = 0; i<monsters.size();i++) {
			if(monsters.get(i).getxPos()==hero.getxPos() & monsters.get(i).getyPos()==hero.getyPos()) {
				return true;
			}
		}
		

		return false;
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
			monsters.add(new Boss(pos[0],pos[1]));
		}
		return(monsters);
	}
	
	private void moveMonsters(int speed) {
		long currTime= System.currentTimeMillis();
		if((currTime-gameTime>500)& (!this.monsters.isEmpty())) {
			for(int i = 0; i<monsters.size();i++) {
				monsters.get(i).move(this.getHero());
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

	public Hero getHero() {
		return hero;
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
	
	

}
