package start;

import projectACL.Labyrinth;
import projectACL.Tile;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	
	public GUI() {
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1));
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Mr Pacman Begins");
		frame.setSize(Labyrinth.getDimX()*Tile.getLength(),Labyrinth.getDimY()*Tile.getWidth());
		//frame.pack();
		frame.setVisible(true);
		
	}
}
