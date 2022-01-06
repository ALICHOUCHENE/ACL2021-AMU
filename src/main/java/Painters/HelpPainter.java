package Painters;

import javax.swing.JFrame;

import Painters.HelpPanel;

public class HelpPainter {
	public static HelpPanel screen;
	public HelpPainter() {
    JFrame fenetreHelp= new JFrame("Help");


    fenetreHelp.setSize(700,420);
    fenetreHelp.setLocationRelativeTo(null);
    fenetreHelp.setResizable(false);
    fenetreHelp.setAlwaysOnTop(false);
    screen= new HelpPanel();
    fenetreHelp.setContentPane(screen);// Méthode qui permet d'afficher la fenêtre HELP
    fenetreHelp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    fenetreHelp.setVisible(true);
}
}