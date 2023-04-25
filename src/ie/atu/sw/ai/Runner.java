package ie.atu.sw.ai;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) throws Exception {

		System.out.println("************************************************************");
		System.out.println("*      ATU - Dept. Computer Science & Applied Physics      *");
		System.out.println("*                                                          *");
		System.out.println("*            The Hobbit AI Text Adventure Game             *");
		System.out.println("*                    By Ronan Shaughnessy                  *");
		System.out.println("************************************************************");

		System.out.println("Press 1 to begin adventure, Press 2 to quit");

		Scanner s = new Scanner(System.in);
		String input = s.nextLine();

		while (!input.equals("2")) {
			if (input.equals("1")) {
				Game game = new Game();
		        game.run();
			} else { // handle invalid input
				System.out.println("Invalid input. Please press 1 to begin adventure, or press 2 to quit.");
			}
			input = s.nextLine(); // get the next input from the player
		}

		System.out.println("Thanks for playing The Hobbit AI Text Adventure Game!");

	}
}
