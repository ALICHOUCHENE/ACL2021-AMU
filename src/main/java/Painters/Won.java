package Painters;

import javax.swing.*;
import java.awt.*;

public class Won
{
  
	public static void Winner() 
   {
      JFrame f = new JFrame("Congratulations");
      
      f.setContentPane(new JLabel(new ImageIcon("src/images/congrats.gif")));
      
      f.setSize(720,600);
      
      // Définir la disposition sur null
      f.setLayout(null);
      
      f.setBackground(Color.WHITE);
     
   
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
      
      
   }

	
	
}