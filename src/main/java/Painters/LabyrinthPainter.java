package Painters;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import projectACL.Tile;

public class LabyrinthPainter {
	
	public LabyrinthPainter() {
		super();
	}
	
	public static void colorLabyrinth(BufferedImage im, Tile[][] tiles) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		for (int i=0; i<tiles.length;i++) {
			for(int j=0;j<tiles[0].length;j++) {
				crayon.setColor(tiles[j][i].getColor());
				crayon.fillRect(i*Tile.getLength(),j*Tile.getWidth(),Tile.getLength(),Tile.getWidth());
				
			}
		}
	}
	
}
