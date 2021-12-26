package Painters;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import projectACL.Bullet;
import projectACL.Tile;

public class BulletPainter {
	
	public BulletPainter() {
		super();
	}
	
	public static void draw(BufferedImage im, ArrayList<Bullet> bullets) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		for(int i=0; i<bullets.size(); i++) {
			crayon.setColor(Color.orange);
			crayon.fillOval(bullets.get(i).getxPos()*Tile.getLength()+Tile.getLength()/4,bullets.get(i).getyPos()*Tile.getWidth()+Tile.getWidth()/4,Tile.getLength()/2,Tile.getWidth()/2);
		}	
	}
}
