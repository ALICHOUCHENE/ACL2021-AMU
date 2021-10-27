package projectACL;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		
		Labyrinth laby = new  Labyrinth(10, 100);
		Hero pacman = new Hero();
		
		System.out.println("Welcome to Pacman");
		System.out.println("To move up use the ,,Z,, key");
		System.out.println("To move down use the ,,S,, key");
		System.out.println("To move left use the ,,Q,, key");
		System.out.println("To move right use the ,D, key");
		System.out.println("");
		
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
		
		while (true) {
			System.out.println(pacman);
			System.out.println("Enter your move");
			String userInput = scanner.nextLine();  // Read user input
			char step = userInput.charAt(0);
			pacman.move(laby, step);
		}
		
	}
}
