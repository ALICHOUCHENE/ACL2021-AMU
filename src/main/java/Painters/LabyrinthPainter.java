package Painters;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import projectACL.Floor;
import projectACL.Tile;

public class LabyrinthPainter {
	
	public LabyrinthPainter() {
		super();
	}
	
	public static void colorLabyrinth(BufferedImage im, Tile[][] tiles) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		for (int i=0; i<tiles[0].length;i++) {
			for(int j=0;j<tiles.length;j++) {
				//crayon.setColor(tiles[j][i].getColor());
				//crayon.fillRect(i*Tile.getLength(),j*Tile.getWidth(),Tile.getLength(),Tile.getWidth());
				Image img;
				try {
					String Source = ((tiles[j][i].getImageSource()));
					img=ImageIO.read(new File(Source)); 
					
					crayon.drawImage(img, Tile.getLength() *i,Tile.getWidth()*j,null);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			}
		}
	}
	
}
