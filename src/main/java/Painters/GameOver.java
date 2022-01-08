package Painters;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GameOver
{
   
	private static boolean Try_Again = false;
	
	public static void GameO() 
   {
      JFrame f = new JFrame("Game Over");
      
      f.setContentPane(new JLabel(new ImageIcon("src/images/gameover.png")));
      
      f.setSize(720,600);
      
      // Définir la disposition sur null
      f.setLayout(null);
      
      // Créer le bouton
      JButton btn = new JButton("TryAgain");
      
      btn.setForeground(Color.WHITE);
      btn.setBackground(Color.RED);
      btn.setFont(new Font("Arial", Font.PLAIN, 30));
      btn.setFocusPainted(false);
     
      // Définir la position et la taille du bouton
      btn.setBounds(250,525,200,35);
      f.add(btn);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
      
      btn.addActionListener(new ActionListener() {							//ACTION DE START
          public void actionPerformed(ActionEvent e) {
         	Try_Again=true;
          }
      });
         
   }
	//setters and getters
    public static boolean TryAgain() {
		return Try_Again;
	}

	public static void setTryAgain(boolean Try_again) {
		GameOver.Try_Again = Try_Again;
	}

	
	
}