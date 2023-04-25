package resources.neural;

import jhealy.aicme4j.net.NeuralNetwork;
import jhealy.aicme4j.net.Output;

public class GetLocation {
	public static String predictLocation(double[] input) throws Exception {
		// Load the neural network
		NetworkModels models = new NetworkModels();
		models.load();
		NeuralNetwork loc = models.getLoc();

		// Use the neural network to make a prediction
		double output = loc.process(input, Output.LABEL_INDEX);
		int location = (int) output;

		return getLocationString(location);
	}

	// Utility method to get the index of the maximum value in an array
	private static String getLocationString(int location) {
		switch (location) {
		case 0:
			return "The company comes to a smoldering husk of a city, Dale once a great city now dust. A foul smell leans heavy in the air, the company too late realize it's the smell of orc, a regiment of them are bearing down upon the company!";
		case 1:
			return "The company has reached the edge of south forest, Gandalf finds something resembling a path to walk, you weave your way through the dark forest when suddenly massive spiders ambush the company!";
		case 2:
			return "The company choose the route to goblin territory, suddenly you fall into a trap and are swarmed by Goblins, you ready to defend yourself!";
		case 3:
			return "The company choose to go through the pass rumored to have trolls, you glance to your left as a three massive Trolls attempt to steal a company member to eat, your ready your weapon!";
		case 4:
			return "The remaining company arrive on the lonely mountain, as you enter the once great halls now in ruin, a great golden drake appears from the dark, prepare for the end!";
		case 5:
			return "The company has arrived at the Plains of Rivendell, orcs have spotted you, a Warg has lunged forth attacking you!";
		case 6:
			return "You have chosen the northern route in mirkwood, soon you lose the path and are ambushed by orcs!";
		default:
			return "Invalid location";
		}
	}
}
