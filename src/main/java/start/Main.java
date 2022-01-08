package start;

import model.MainPainter;

import java.io.IOException;

import Painters.GameOver;
import Painters.HomeScreenPainter;
import Painters.Over;
import Painters.Won;
import engine.GameEngineGraphical;
import model.PacmanController;
import model.PacmanGame;
import projectACL.Hero;
import projectACL.Labyrinth;



/**
 * lancement du moteur avec le jeu
 */
public class Main {
	
	private static int numOfLevels =2;
	private static Hero hero= new Hero();


	public static void main(String[] args) throws InterruptedException, IOException {

		HomeScreenPainter.HomeScreenPaint();
		
		while (HomeScreenPainter.isGameStarted()==false) {
			System.out.println("Game hasn't started yet");
		};
		
		

		System.out.println("Game has started !");
		
		for (int level = 1; level<= numOfLevels ; level++) {
			// creation du jeu particulier et de son afficheur
			PacmanGame game = new PacmanGame("helpFilePacman.txt",level);
			MainPainter painter = new MainPainter(game);
			PacmanController controller = new PacmanController();
		
			// classe qui lance le moteur de jeu generique
			
			GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
			engine.run();
			if ((level==2) & (game.isFinished()==true)) {
				Won.Winner();
				break;
			};
			if (game.isGameOver()) {
				GameOver.GameO();
				while (GameOver.TryAgain()==false) {
					System.out.println("Doesn't want to play again");
				};
				if (GameOver.TryAgain()==true) {
					for (int levels = 1; levels<= numOfLevels ; levels++) {
						// creation du jeu particulier et de son afficheur
						PacmanGame game1 = new PacmanGame("helpFilePacman.txt",levels);
						MainPainter painter1 = new MainPainter(game1);
						PacmanController controller1 = new PacmanController();
					
						// classe qui lance le moteur de jeu generique
						
						GameEngineGraphical engine1 = new GameEngineGraphical(game1, painter1, controller1);
						engine1.run();
						if (game1.isGameOver()) {
							Over.GOver();
							break;
						}
					}
				};
				break;
			}
		}

			
	}
	public Hero getHero() {
		return hero;
	}
	public void setHero(Hero hero) {
		this.hero = hero;
	}
}
