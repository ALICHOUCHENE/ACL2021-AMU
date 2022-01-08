package Painters;

import javax.swing.*;


public class Over
{
  
	public static void GOver() 
   {
      JFrame f = new JFrame("It's over");
      
      f.setContentPane(new JLabel(new ImageIcon("src/images/gameover.png")));
      
      f.setSize(720,600);
      
      // Définir la disposition sur null
      f.setLayout(null);
      
      // Créer le bouton
     
     
      // Définir la position et la taille du bouton
   
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
      
      
   }

	
	
}