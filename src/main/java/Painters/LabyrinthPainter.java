package Painters;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import projectACL.Floor;
import projectACL.Hero;
import projectACL.Tile;

public class LabyrinthPainter {
	
	public LabyrinthPainter() {
		super();
	}
	
	public static void colorLabyrinth(BufferedImage im, Tile[][] tiles,Hero pacman) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();

		int HP = pacman.getlives();
		for (int i=0; i<tiles.length;i++) {
			for(int j=0;j<tiles[0].length;j++) {
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
				}		
			}
		}
		for (int k=0;k<HP;k++){ 
			Image img2;
			try {
			String Source2 = ("src/images/heart.png");
			img2=ImageIO.read(new File(Source2)); 
			crayon.drawImage(img2, Tile.getLength()*(k+3),Tile.getWidth()*(tiles[0].length-1),null);
	}	catch (IOException e) {
		e.printStackTrace();
	}
	
}
		}}
