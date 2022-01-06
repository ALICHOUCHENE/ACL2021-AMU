package Painters;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HelpPanel extends JPanel{						//CLASSE PANEL FENETRE HELP

	private int xFond1;
    private ImageIcon HelpIcon;
    private Image HelpImage;
	public HelpPanel() {
		super();

	     this.HelpIcon = new ImageIcon("src/main/resources/HelpIcon.png");
	     this.HelpImage=this.HelpIcon.getImage();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		g2.drawImage(this.HelpImage,0,0,null);

	}

}
