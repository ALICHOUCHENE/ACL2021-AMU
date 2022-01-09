package Painters;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import projectACL.Life;
import projectACL.Tile;

public class LifePainter {
	
	
	public LifePainter() {
		super() ;
	}

	public static void draw(BufferedImage im, ArrayList<Life> Lives) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		for(int i=0; i<Lives.size(); i++) {
			//crayon.setColor(Color.red);
			//crayon.fillOval(monsters.get(i).getxPos()*Tile.getLength(),monsters.get(i).getyPos()*Tile.getWidth(),Tile.getLength(),Tile.getWidth());
			
			
			Image img;
			try {
				String Source = (Lives.get(i).getImageSource());
				
				img=ImageIO.read(new File(Source)); 
				
				crayon.drawImage(img, Tile.getLength()* Lives.get(i).getXpos(),Tile.getWidth()*Lives.get(i).getYpos(),null);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}	
	}

}

