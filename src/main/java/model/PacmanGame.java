package model;

import java.io.BufferedReader; 

import java.io.FileReader;
import java.io.IOException;

import engine.Cmd;
import engine.Game;
import projectACL.Hero;
import projectACL.Labyrinth;

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
	private Labyrinth laby = new Labyrinth();
	
	public PacmanGame(String source, Hero hero) {
		this.hero=hero;
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
		
		
		
	}

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */

	public void evolve(Cmd commande) {
		System.out.println("Execute "+commande);
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
	}

	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		// le jeu n'est jamais fini
		return false;
	}

}
