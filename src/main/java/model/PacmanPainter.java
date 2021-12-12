package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import projectACL.Hero;

import engine.GamePainter;

import projectACL.Labyrinth;
import projectACL.Monster;
import projectACL.Tile;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 * 
 */
public class PacmanPainter implements GamePainter {

	
	Hero pacman;
	Monster monster;

	/**
	 * appelle constructeur parent
	 * 
	 * @param game
	 *            le jeutest a afficher
	 */

	public PacmanPainter(PacmanGame game) {
		this.pacman=game.getHero();
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	@Override
	public void draw(BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setColor(Color.blue);
		crayon.fillOval(pacman.getxPos()*Tile.getLength(),pacman.getyPos()*Tile.getWidth(),Tile.getLength(),Tile.getWidth());
	}
	
	

	@Override
	public int getWidth() {
		return (Labyrinth.getDimX())*Tile.getLength();
	}

	@Override
	public int getHeight() {
		return (Labyrinth.getDimY())*Tile.getWidth();
	}

}
