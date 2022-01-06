package model;

import java.awt.event.KeyEvent;

import engine.Cmd;
import engine.GameController;


/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * controleur de type KeyListener
 * 
 */
public class PacmanController implements GameController {

	/**
	 * commande en cours
	 */
	private Cmd commandeEnCours;
	
	/**
	 * construction du controleur par defaut le controleur n'a pas de commande
	 */
	public PacmanController() {
		this.commandeEnCours = Cmd.IDLE;
	}

	/**
	 * quand on demande les commandes, le controleur retourne la commande en
	 * cours
	 * 
	 * @return commande faite par le joueur
	 */
	public Cmd getCommand() {
		return this.commandeEnCours;
	}

	@Override
	/**
	 * met a jour les commandes en fonctions des touches appuyees
	 */
	public void keyPressed(KeyEvent e) {
		
		
		switch (e.getKeyCode()) {
		//command to move up
		case KeyEvent.VK_W:
			this.commandeEnCours = Cmd.UP;
			break;
		//command to move down
		case KeyEvent.VK_S:
			this.commandeEnCours = Cmd.DOWN;
			break;
		//command to move left
		case KeyEvent.VK_A:
			this.commandeEnCours = Cmd.LEFT;
			break;
		//command to move right
		case KeyEvent.VK_D:
			this.commandeEnCours = Cmd.RIGHT;
			break;
		//command to move up
		case 'Z':
			this.commandeEnCours = Cmd.UP;
			break;
		//command to move left
		case 'Q':
			this.commandeEnCours = Cmd.LEFT;
			break;
		//command to shoot
		case KeyEvent.VK_SPACE:
			this.commandeEnCours = Cmd.SHOOT;
			break;
		}

	}

	@Override
	/**
	 * met a jour les commandes quand le joueur relache une touche
	 */
	public void keyReleased(KeyEvent e) {
		this.commandeEnCours = Cmd.IDLE;
	}

	@Override
	/**
	 * ne fait rien
	 */
	public void keyTyped(KeyEvent e) {

	}

}
