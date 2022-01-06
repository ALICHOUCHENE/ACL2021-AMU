package Painters;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import projectACL.Hero;
import projectACL.Tile;

public class PacmanPainter {
		
	public PacmanPainter() {
	}
	
	public static void draw(BufferedImage im, Hero pacman) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		//crayon.setColor(Color.blue);
		//crayon.fillOval(pacman.getxPos()*Tile.getLength(),pacman.getyPos()*Tile.getWidth(),Tile.getLength(),Tile.getWidth());
		
		Image img;
		try {
			String Source = (pacman.getImageSource());
			
			img=ImageIO.read(new File(Source)); 

//			img = ImageIO.read(new File(herosprite.currentSpriteGet(animationstage, controller.getCommand(),heros.getType())));
			crayon.drawImage(img, Tile.getLength()* pacman.getxPos(),Tile.getWidth()*pacman.getyPos(),null);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
}
