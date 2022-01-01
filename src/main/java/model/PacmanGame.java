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
import projectACL.Tile;
import projectACL.Hero;
import projectACL.Labyrinth;
import projectACL.Door;


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
	private Door door=new Door();

	
	private Labyrinth laby;
	public ArrayList<Monster> monsters;
	private long gameTime;

	
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

	public void evolve(Cmd commande) {
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
		
		case IDLE:
			break;
		}
		// evolve monster
		
		
		moveMonsters();
	}

	/**
	 * verifier si le jeu est fini
	 */
	
	@Override
	public boolean isFinished() {
		// le jeu n'est jamais fini
		//TODO increment level ++ , must make level an attribute in Labyrinth
		//TODO add case level : , in Labyrinth , to decide the text file and the design for each level 
		boolean state=(Labyrinth.getDimX()-1==hero.getxPos()) & (Labyrinth.getDimY()-2==hero.getyPos());
		
		return(state); 
		
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
			monsters.add(new Monster(pos[0],pos[1]));
		}
		return(monsters);
	}
	
	private void moveMonsters() {
		long currTime= System.currentTimeMillis();
		if(currTime-gameTime>500) {
			for(int i = 0; i<monsters.size();i++) {
				monsters.get(i).move(laby);
			}
		this.gameTime= System.currentTimeMillis();
		}
	}

	public Hero getHero() {
		return hero;
	}

	public Labyrinth getLaby() {
		return laby;
	}

	public ArrayList<Monster> getMonstres() {
		return monsters;
	}
	
	

}
