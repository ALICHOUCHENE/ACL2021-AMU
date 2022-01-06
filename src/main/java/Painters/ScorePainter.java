package Painters;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import projectACL.Hero;
import projectACL.Score;
import projectACL.Tile;


public class ScorePainter {
	public ScorePainter() {
		
	}

	
	
	public static void result(BufferedImage baseImage, String textToWrite) {
		  Graphics2D g2D = (Graphics2D) baseImage.getGraphics();
		  g2D.setColor(new Color(167, 136, 69));
		  
		  g2D.drawString(textToWrite, 5, 5);
		  g2D.dispose();
		}
	
	
	
	
	
	}
	

