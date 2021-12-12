package Painters;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


//import engine.GamePainter;
import projectACL.Monster;
import projectACL.Tile;


public class MonsterPainter {
	
	
	public MonsterPainter() {
		super() ;
	}

	public static void draw(BufferedImage im, ArrayList<Monster> monsters) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		for(int i=0; i<monsters.size(); i++) {
			crayon.setColor(Color.red);
			crayon.fillOval(monsters.get(i).getxPos()*Tile.getLength(),monsters.get(i).getyPos()*Tile.getWidth(),Tile.getLength(),Tile.getWidth());
		}	
	}

}


	