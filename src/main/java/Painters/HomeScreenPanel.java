package Painters;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HomeScreenPanel extends JPanel {
    
    private ImageIcon icoFond;
    private Image imgFond1;
    
    public HomeScreenPanel() {											//CLASSE PANEL DU HOMESCREEN
        super();
        icoFond = new ImageIcon("src/main/resources/fondEcran.png");	//ICONE FOND D'ECRAN
        this.imgFond1=this.icoFond.getImage();
          }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;
        g2.drawImage(this.imgFond1,-50,0,null);					// ON PEINT LE FOND
        
        
   
    }

}

