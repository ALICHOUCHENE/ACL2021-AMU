package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectACL.Hero;




class TestHero {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	
	@Test
	public void testCreation() {
		Hero instance;
		instance=new Hero(10,10);
		assertEquals(instance.getxPos(),10);
		assertEquals(instance.getyPos(),10);
		
	}
	
	@Test
	public void testMoveUp() {
		Hero instance;
		instance=new Hero(0,1);
		instance.moveUp();
		assertEquals(instance.getyPos(),5);
		
		
	}
	
	@Test
	public void testMoveRight() {
		Hero instance;
		instance=new Hero(0,1);
		instance.moveRight();
		assertEquals(instance.getxPos(),1);
		
	}



}
