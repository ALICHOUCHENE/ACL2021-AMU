package Painters;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

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
			//crayon.setColor(Color.red);
			//crayon.fillOval(monsters.get(i).getxPos()*Tile.getLength(),monsters.get(i).getyPos()*Tile.getWidth(),Tile.getLength(),Tile.getWidth());
			
			
			Image img;
			try {
				String Source = (monsters.get(i).getImageSource());
				
				img=ImageIO.read(new File(Source)); 
				
				crayon.drawImage(img, Tile.getLength()* monsters.get(i).getxPos(),Tile.getWidth()*monsters.get(i).getyPos(),null);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}	
	}

}


	