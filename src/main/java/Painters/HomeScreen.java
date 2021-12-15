package Painters;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HomeScreen extends JPanel {
	private ImageIcon icoFond;
	private Image imgFond1;
	public HomeScreen() {
		super();
		icoFond = new ImageIcon("pacman.jpg");	
		this.imgFond1 = this.icoFond.getImage();
		}
			
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		g2.drawImage(this.imgFond1, 300,245,null);
		

}
