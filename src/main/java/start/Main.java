package start;

import model.MainPainter;

import java.io.IOException;

import engine.GameEngineGraphical;
import model.PacmanController;
import model.PacmanGame;
import projectACL.Hero;



/**
 * lancement du moteur avec le jeu
 */
public class Main {
	
	private static int numOfLevels =2;


	public static void main(String[] args) throws InterruptedException, IOException {

		for (int level = 1; level<= numOfLevels ; level++) {
			// creation du jeu particulier et de son afficheur
			PacmanGame game = new PacmanGame("helpFilePacman.txt",level);
			MainPainter painter = new MainPainter(game);
			PacmanController controller = new PacmanController();
	
	
			// classe qui lance le moteur de jeu generique
			
			GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
			engine.run();
			if (game.isGameOver()) {
				System.out.println("Dead");
				break;
			}
		}
			
	}

}
