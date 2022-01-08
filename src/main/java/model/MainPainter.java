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
import Painters.BulletPainter;
import Painters.LabyrinthPainter;
import Painters.ScorePainter;

import engine.GamePainter;
import projectACL.Bullet;
import projectACL.Hero;
import projectACL.Labyrinth;
import projectACL.Monster;
import projectACL.MonsterSmart;
import projectACL.Score;
import projectACL.Tile;

public class MainPainter implements GamePainter{
	
	Hero pacman;
	ArrayList<Monster> monsters;
	ArrayList<Bullet> bullets;
	Tile[][] tiles;
	

	public MainPainter(PacmanGame game) {
		this.pacman=game.getHero();
		this.monsters=game.getMonstres();
		this.tiles=Labyrinth.getBuild();
		this.bullets= game.getBullets();
	}

	
	@Override
	public void draw(BufferedImage im) {
		LabyrinthPainter.colorLabyrinth(im, tiles,pacman);
		PacmanPainter.draw(im, pacman);
		MonsterPainter.draw(im,monsters);
		BulletPainter.draw(im,bullets);

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
