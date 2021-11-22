package model;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import projectACL.GameCharacter;
import projectACL.Hero;

import engine.GamePainter;

import projectACL.Labyrinth;
import projectACL.Monster;
import projectACL.Tile;

public class MonsterPainter implements GamePainter {
	
Monster monster;
public MonsterPainter(Monster monster) {
	this.monster=monster;
}
public void draw(BufferedImage im) {
	Graphics2D crayon = (Graphics2D) im.getGraphics();
	crayon.setColor(Color.red);
	crayon.fillOval(monster.getxPos()*Tile.getLength(),monster.getyPos()*Tile.getWidth(),Tile.getLength(),Tile.getWidth());
}

public int getWidth() {
	return (Labyrinth.getDimX()+1)*Tile.getLength();
}

public int getHeight() {
	return (Labyrinth.getDimY()+1)*Tile.getWidth();
}

}
