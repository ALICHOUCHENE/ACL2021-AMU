package Painters;

import javax.swing.JFrame;

public class MainPainter {
	public static HomeScreen homescreen;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 JFrame fenetre= new JFrame("JEU PACMAN");
		 fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 fenetre.setSize(1920,1080);
		 fenetre.setLocationRelativeTo(null);
		 fenetre.setResizable(false);
		 fenetre.setAlwaysOnTop(true);
		 homescreen = new HomeScreen();
		 fenetre.setContentPane(homescreen);
		 fenetre.setVisible(true);

	}

}
