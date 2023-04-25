package resources.neural;

import ie.atu.sw.ai.Player;
import ie.atu.sw.ai.PlayerType;
import jhealy.aicme4j.net.NeuralNetwork;
import jhealy.aicme4j.net.Output;

public class PlayerPick {

	static int playerHealth = 0;
	static int playerDamage = 0;

	public static int[] pickPlayer() throws Exception {
		NetworkModels models = new NetworkModels();
		models.load();
		NeuralNetwork player = models.getPlayer();

		// Define the input data as a 2D array
		double[][] data = { { 1, 0, 0, 1 }, { 2, 0, 0, 1 }, { 2, 0, 1, 1 }, { 2, 0, 1, 2 }, { 2, 1, 0, 2 },
				{ 2, 1, 0, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 0, 1, 1 }, { 1, 1, 2, 0 }, { 1, 1, 0, 2 },
				{ 1, 1, 0, 1 }, { 1, 0, 2, 0 }, { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 0, 1, 2 }, { 0, 1, 0, 2 },
				{ 0, 1, 0, 1 }, };

		// Generate a random index to select a row from data
		int randomIndex = (int) (Math.random() * data.length);

		// Neural network randomly picks player
		double[] playerInput = data[randomIndex];

		// Player
		double outputPlayer = player.process(playerInput, Output.LABEL_INDEX);
		int labelIndex = (int) outputPlayer;

		String character = getCharacterString(labelIndex);

		System.out.println("Character: " + character);
		
	    return new int[] {playerHealth, playerDamage};
	}

	private static String getCharacterString(int labelIndex) {
		switch (labelIndex) {
		case 0:
			PlayerType typeBilbo = PlayerType.BILBO;
			Player bilbo = new Player(typeBilbo, 70, 10);
			playerHealth = bilbo.getHealth();
			playerDamage = bilbo.getDamage();
			return "Playing as " + bilbo.getType();
		case 1:
			PlayerType typeGandalf = PlayerType.GANDALF;
			Player gandalf = new Player(typeGandalf, 120, 20);
			playerHealth = gandalf.getHealth();
			playerDamage = gandalf.getDamage();
			return "Playing as " + gandalf.getType();
		case 2:
			PlayerType typeThorin = PlayerType.THORIN;
			Player thorin = new Player(typeThorin, 100, 12);
			playerHealth = thorin.getHealth();
			playerDamage = thorin.getDamage();
			return "Playing as " + thorin.getType();
		case 3:
			PlayerType typeDwalin = PlayerType.DWALIN;
			Player dwalin = new Player(typeDwalin, 90, 17);
			playerHealth = dwalin.getHealth();
			playerDamage = dwalin.getDamage();
			return "Playing as " + dwalin.getType();
		default:
			return "Unknown";
		}
	}
}
