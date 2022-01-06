package Painters;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;


public class HomeScreenPainter {
    public static HomeScreenPanel homescreen;
    private static boolean gameStarted = false;
    
    public static void HelpWindow() {                   // M�thode qui permet d'afficher la fen�tre HELP

       
    }
    
    public static void HomeScreenPaint() {                //METHODE POUR DESSINER LE HOMESCREEN
        JFrame fenetre= new JFrame("Jeu Pacman");			//FENETRE DU HOMESCREEN


         fenetre.setSize(700,350);
         fenetre.setLocationRelativeTo(null);
         fenetre.setResizable(true);
         fenetre.setAlwaysOnTop(false);
        
         homescreen= new HomeScreenPanel();					//PANEL
             fenetre.setContentPane(homescreen);
             Icon iconStart = new ImageIcon("src/main/resources/startbutton.png");     //ICONE START
             Icon iconHelp = new ImageIcon("src/main/resources/helpButton.png");		//ICONE HELP
             JButton start = new JButton(iconStart);									//JBUTTON START
             JButton help = new JButton(iconHelp);										//JBUTTON HELP
             
             
             start.addActionListener(new ActionListener() {							//ACTION DE START
                 public void actionPerformed(ActionEvent e) {
                	gameStarted=true;
                 }
             });
             help.addActionListener(new ActionListener() {							//ACTION DE HELP
                 public void actionPerformed(ActionEvent e) {
                	 HelpPainter help = new HelpPainter();
                 }
             });
             start.setBounds(200,300,40,40);
             help.setBounds(700,350,200,200);
             start.setBackground(Color.BLACK);
             help.setBackground(Color.BLACK);
             start.setBorder(BorderFactory.createEtchedBorder());
             help.setBorder(BorderFactory.createEtchedBorder());
          
             fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             fenetre.add(start);
             fenetre.add(help);
             fenetre.setVisible(true);
        
    }
    
    //setters and getters
    public static boolean isGameStarted() {
		return gameStarted;
	}

	public static void setGameStarted(boolean gameStarted) {
		HomeScreenPainter.gameStarted = gameStarted;
	}

}
