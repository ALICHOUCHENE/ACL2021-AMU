package start;

import model.MainPainter;
import Painters.HomeScreenPainter;
import engine.GameEngineGraphical;
import model.PacmanController;
import model.PacmanGame;
import projectACL.Hero;



/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		HomeScreenPainter.HomeScreenPaint();
		while (HomeScreenPainter.isGameStarted()==false) {
			System.out.println("Game hasn't started yet");
		}

		// creation du jeu particulier et de son afficheur
		PacmanGame game = new PacmanGame("helpFilePacman.txt");
		MainPainter painter = new MainPainter(game);
		PacmanController controller = new PacmanController();


		// classe qui lance le moteur de jeu generique
		
		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);

		engine.run();

	
		
		System.out.println("Dead");
		}

}
