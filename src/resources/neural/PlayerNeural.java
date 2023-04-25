package resources.neural;

import jhealy.aicme4j.NetworkBuilderFactory;
import jhealy.aicme4j.net.Activation;
import jhealy.aicme4j.net.Loss;
import jhealy.aicme4j.net.NeuralNetwork;
import jhealy.aicme4j.net.Output;

public class PlayerNeural {
	
	private NeuralNetwork net;
	
	public void go() throws Exception {
		net = NetworkBuilderFactory.getInstance()
				.newNetworkBuilder().inputLayer("Input", 4)
				.hiddenLayer("Hidden1", Activation.RELU, 16)				
				.outputLayer("Output", Activation.RELU, 4)
				.train(data, expected, 0.001, 0.95, 100000, 0.00001, Loss.CEE)
				.save("player.dat")
				.build();
		
		int randomIndex = (int) (Math.random() * data.length);
		System.out.println(net);
		double[] output = data[randomIndex];
		System.out.println(net.process(output, Output.LABEL_INDEX));
		
		int labelIndex = (int) net.process(output, Output.LABEL_INDEX);
	    String character;
	    switch (labelIndex) {
	        case 0:
	            character = "Bilbo";
	            break;
	        case 1:
	            character = "Gandalf";
	            break;
	        case 2:
	            character = "Thorin";
	            break;
	        case 3:
	            character = "Dwalin";
	            break;
	        default:
	            character = "Unknown";
	            break;
	    }
	    System.out.println("Character: " + character);
	}

	public static void main(String[] args) throws Exception {
		new PlayerNeural().go();
	}
	
	double[][] data = { 
			{ 1, 0, 0, 1 },
			{ 2, 0, 0, 1 },
			{ 2, 0, 1, 1 },
			{ 2, 0, 1, 2 },
			{ 2, 1, 0, 2 },
			{ 2, 1, 0, 1 },
			{ 1, 0, 0, 0 },
			{ 1, 0, 0, 1 },
			{ 1, 0, 1, 1 },
			{ 1, 1, 2, 0 },
			{ 1, 1, 0, 2 },
			{ 1, 1, 0, 1 },
			{ 1, 0, 2, 0 },
			{ 0, 0, 0, 1 },
			{ 0, 0, 1, 1 },
			{ 0, 0, 1, 2 },
			{ 0, 1, 0, 2 },
			{ 0, 1, 0, 1 },
		};

	double[][] expected = {
			{ 1.0, 0.0, 0.0, 0.0 }, 
			{ 0.0, 1.0, 0.0, 0.0 }, 
			{ 0.0, 0.0, 1.0, 0.0 }, 
			{ 0.0, 0.0, 0.0, 1.0 },
			{ 0.0, 0.0, 1.0, 0.0 }, 
			{ 0.0, 1.0, 0.0, 0.0 }, 
			{ 1.0, 0.0, 0.0, 0.0 }, 
			{ 0.0, 1.0, 0.0, 0.0 },
			{ 0.0, 0.0, 1.0, 0.0 }, 
			{ 0.0, 0.0, 0.0, 1.0 }, 
			{ 0.0, 0.0, 1.0, 0.0 }, 
			{ 0.0, 1.0, 0.0, 0.0 },
			{ 1.0, 0.0, 0.0, 0.0 }, 
			{ 0.0, 1.0, 0.0, 0.0 }, 
			{ 0.0, 0.0, 1.0, 0.0 }, 
			{ 0.0, 0.0, 0.0, 1.0 },
			{ 0.0, 0.0, 1.0, 0.0 }, 
			{ 0.0, 1.0, 0.0, 0.0 } };
}
