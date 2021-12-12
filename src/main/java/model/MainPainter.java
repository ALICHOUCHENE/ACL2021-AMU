/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 * 
 */

package model;


import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Painters.PacmanPainter;
import Painters.MonsterPainter;
import engine.GamePainter;
import projectACL.Hero;
import projectACL.Labyrinth;
import projectACL.Monster;
import projectACL.Tile;

public class MainPainter implements GamePainter{
	
	Hero pacman;
	ArrayList<Monster> monsters;

	public MainPainter(PacmanGame game) {
		this.pacman=game.getHero();
		this.monsters=game.getMonstres();
	}

	
	@Override
	public void draw(BufferedImage im) {
		PacmanPainter.draw(im, pacman);
		MonsterPainter.draw(im,monsters);
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
