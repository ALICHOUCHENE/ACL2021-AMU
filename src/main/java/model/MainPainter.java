/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 * 
 */

package model;


import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Painters.PacmanPainter;
import Painters.MonsterPainter;
import Painters.LabyrinthPainter;
import Painters.ScorePainter;

import engine.GamePainter;
import projectACL.Hero;
import projectACL.Labyrinth;
import projectACL.Monster;
import projectACL.Score;
import projectACL.Tile;

public class MainPainter implements GamePainter{
	
	Hero pacman;
	ArrayList<Monster> monsters;
	Tile[][] tiles;
	

	public MainPainter(PacmanGame game) {
		this.pacman=game.getHero();
		this.monsters=game.getMonstres();
		this.tiles=Labyrinth.getBuild();
	}

	
	@Override
	public void draw(BufferedImage im) {
		LabyrinthPainter.colorLabyrinth(im, tiles);
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
	
	@Override
	public void drawResult(BufferedImage im, String result) {
		ScorePainter.result(im,result);
	}


	@Override
	public void drawResult(String result) {
		
	}
}
