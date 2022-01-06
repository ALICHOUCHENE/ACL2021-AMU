package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import engine.Cmd;
import model.PacmanGame;
import projectACL.Hero;
import projectACL.Labyrinth;
import projectACL.Monster;


class TestPacmanGame {
	
	Labyrinth laby;
	Hero hero;
	PacmanGame game;
	ArrayList<Monster> monstres;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
		game= new PacmanGame("helpFilePacman.txt", 0);
	}
	
	@Test
	void testEvolveRight() throws Exception{
		this.hero= this.game.getHero();
		int oldXPos = this.hero.getxPos();
		int oldYPos = this.hero.getyPos();
		game.evolve(Cmd.RIGHT);
		this.hero = this.game.getHero();
		assertTrue(hero.getxPos() == oldXPos +1);
		assertTrue(hero.getyPos() == oldYPos);
	}
	
	@Test
	void testEvolveLeft() throws Exception{
		this.hero= this.game.getHero();
		int oldXPos = this.hero.getxPos();
		int oldYPos = this.hero.getyPos();
		game.evolve(Cmd.LEFT);
		this.hero = this.game.getHero();
		assertTrue(hero.getxPos() == oldXPos -1);
		assertTrue(hero.getyPos() == oldYPos);
	}
	
	@Test
	void testEvolveUp() throws Exception{
		this.hero= this.game.getHero();
		int oldXPos = this.hero.getxPos();
		int oldYPos = this.hero.getyPos();
		game.evolve(Cmd.UP);
		this.hero = this.game.getHero();
		assertTrue(hero.getxPos() == oldXPos);
		assertTrue(hero.getyPos() == oldYPos -1);
	}
	
	@Test
	void testEvolveDown() throws Exception{
		this.hero= this.game.getHero();
		int oldXPos = this.hero.getxPos();
		int oldYPos = this.hero.getyPos();
		game.evolve(Cmd.DOWN);
		this.hero = this.game.getHero();
		assertTrue(hero.getxPos() == oldXPos);
		assertTrue(hero.getyPos() == oldYPos +1);
	}
	
	@Test
	void testLabyrintheRightBoundary() throws Exception{
		//placer le pacman a l extremite droite
		this.hero = new Hero (Labyrinth.getDimX()-1,0);
		int oldXPos = this.hero.getxPos();
		int oldYPos = this.hero.getyPos();
		game.setHero(this.hero);
		game.evolve(Cmd.RIGHT);
		this.hero = this.game.getHero();
		assertTrue(hero.getxPos()==oldXPos);
		assertTrue(hero.getyPos()==oldYPos);
	}
	
	@Test
	void testLabyrintheLeftBoundary() throws Exception{
		//placer le pacman a l extremite droite
		this.hero = new Hero (0,0);
		int oldXPos = this.hero.getxPos();
		int oldYPos = this.hero.getyPos();
		game.setHero(this.hero);
		game.evolve(Cmd.LEFT);
		this.hero = this.game.getHero();
		assertTrue(hero.getxPos()==oldXPos);
		assertTrue(hero.getyPos()==oldYPos);
	}
	
	@Test
	void testLabyrintheUpBoundary() throws Exception{
		//placer le pacman a l extremite droite
		this.hero = new Hero (0,0);
		int oldXPos = this.hero.getxPos();
		int oldYPos = this.hero.getyPos();
		game.setHero(this.hero);
		game.evolve(Cmd.UP);
		this.hero = this.game.getHero();
		assertTrue(hero.getxPos()==oldXPos);
		assertTrue(hero.getyPos()==oldYPos);
	}
	
	@Test
	void testLabyrintheDownBoundary() throws Exception{
		//placer le pacman a l extremite droite
		this.hero = new Hero (0,Labyrinth.getDimY()-1);
		int oldXPos = this.hero.getxPos();
		int oldYPos = this.hero.getyPos();
		game.setHero(this.hero);
		game.evolve(Cmd.DOWN);
		this.hero = this.game.getHero();
		assertTrue(hero.getxPos()==oldXPos);
		assertTrue(hero.getyPos()==oldYPos);
	}

}
