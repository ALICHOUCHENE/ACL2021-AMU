package Painters;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameWonPainter {
	
	public static void draw() 
	   {
	      JFrame f = new JFrame("Congratulations");
	      
	      f.setContentPane(new JLabel(new ImageIcon("src/images/congrats.gif")));
	      
	      f.setSize(720,600);
	      
	      // Definir la disposition sur null
	      f.setLayout(null);
	      
	      f.setBackground(Color.WHITE);
	     
	   
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.setLocationRelativeTo(null);
	      f.setVisible(true);
	      
	      
	   }
}
