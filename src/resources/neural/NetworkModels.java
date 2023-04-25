package resources.neural;

import jhealy.aicme4j.net.Aicme4jUtils;
import jhealy.aicme4j.net.NeuralNetwork;

public class NetworkModels {
	
	private NeuralNetwork player;
	private NeuralNetwork loc;
	
	public void load() throws Exception {
		loc = Aicme4jUtils.load("./location.dat");
		player = Aicme4jUtils.load("./player.dat");
	}
	
	public NeuralNetwork getLoc() {
        return loc;
    }
	
	public NeuralNetwork getPlayer() {
        return player;
    }
}
