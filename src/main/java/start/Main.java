package start;

import model.PacmanPainter;
import engine.GameEngineGraphical;
import model.MonsterPainter;
import model.PacmanController;
import model.PacmanGame;

import projectACL.Hero;
import projectACL.Labyrinth;
import projectACL.Monster;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Monster monster= new Monster(10,10);
		
		Hero pacman = new Hero();

		// creation du jeu particulier et de son afficheur
		PacmanGame game = new PacmanGame("helpFilePacman.txt",pacman);
		PacmanPainter painter = new PacmanPainter(pacman,monster);
		PacmanController controller = new PacmanController();


		// classe qui lance le moteur de jeu generique
		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
		engine.run();
		while (1!=0) {
			monster.move(PacmanGame.laby);}
			
	}

}
