package Painters;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import projectACL.Hero;
import projectACL.Tile;

public class PacmanPainter {
		
	public PacmanPainter() {
	}
	
	public static void draw(BufferedImage im, Hero pacman) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setColor(Color.blue);
		crayon.fillOval(pacman.getxPos()*Tile.getLength(),pacman.getyPos()*Tile.getWidth(),Tile.getLength(),Tile.getWidth());
	}
}
