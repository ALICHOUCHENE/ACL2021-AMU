package start;

import model.PacmanPainter;
import engine.GameEngineGraphical;
import model.MonsterPainter;
import model.PacmanController;
import model.PacmanGame;

import projectACL.Labyrinth;
import projectACL.Hero;
import projectACL.Labyrinth;
import projectACL.Monster;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		/*
		Hero pacman = new Hero(0,1);
		Labyrinth laby = new Labyrinth(1);			
		*/
		// creation du jeu particulier et de son afficheur
		PacmanGame game = new PacmanGame("helpFilePacman.txt");
		PacmanPainter painter = new PacmanPainter(game);
		PacmanController controller = new PacmanController();


		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
		engine.run();
			
	}

}
