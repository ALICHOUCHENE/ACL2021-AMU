package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectACL.Labyrinth;
import java.io.IOException;




class TestLabyrinth {

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
		Labyrinth instance; 
		instance=new Labyrinth(1);
		assertNotNull(instance);
	}
	
	@Test
	public void testCreationNULL() {
		Labyrinth instance; 
		instance=new Labyrinth(1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> Labyrinth.getDimX()); //Expected .getDimx() to throw, but it didn't
	}
	
	@Test
	public void testEdgeLeft() {
		
		assertFalse(Labyrinth.validatePos(-1, 0));
	}
	
	@Test
	public void testEdgeUp() {
		
		assertFalse(Labyrinth.validatePos(0, -1));
	}
	
	@Test
	public void testEdgeRight() {
		
		assertFalse(Labyrinth.validatePos(13, 0));
	}
	
	@Test
	public void testEdgedown() {
		
		assertFalse(Labyrinth.validatePos(0, 13));
	}

	@Test
	public void validateMouvement() {
		
		assertTrue(Labyrinth.validatePos(9, 8));
	}
	
	@Test
	public void unValidateMouvement() {
		
		assertFalse(Labyrinth.validatePos(2, 7));
	}
	

	

}
