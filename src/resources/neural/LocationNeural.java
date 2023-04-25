package resources.neural;

import jhealy.aicme4j.NetworkBuilderFactory;
import jhealy.aicme4j.net.Activation;
import jhealy.aicme4j.net.Loss;
import jhealy.aicme4j.net.NeuralNetwork;
import jhealy.aicme4j.net.Output;

public class LocationNeural {
	
	private NeuralNetwork net;
	
	public void go() throws Exception {

		net = NetworkBuilderFactory.getInstance()
				.newNetworkBuilder()
				.inputLayer("Input", 7)
				.hiddenLayer("Hidden1", Activation.TANH, 14)
				.outputLayer("Output", Activation.TANH, 7)
				.train(data, expected, 0.001, 0.95, 100000, 0.00001, Loss.MSE) // if relu
				.save("location.dat")
				.build();
		
		System.out.println(net);
		
		double[] inputData = { 1, 0, 0, 0, 0, 2 ,0} ; // example input data
        double predictedClass = net.process(inputData, Output.LABEL_INDEX);
        System.out.println("Predicted class: " + predictedClass);
        
        //spawnAtLocation((int)predictedClass);
	}
	
	public static void main(String[] args) throws Exception {
		new LocationNeural().go();
	}

	double[][] data = { 
			{ 1, 0, 0, 1, 0, 2 ,0}, //Ruins of Dale 
			{ 2, 0, 0, 1, 0, 1 ,1}, //southmirkwood
			{ 2, 0, 1, 1, 0, 0 ,2}, //Goblin Cavern
			{ 2, 0, 1, 2, 0, 1 ,0}, //Trolls Cave
			{ 2, 1, 0, 2, 0, 0 ,1}, // Lonely Mountain
			{ 2, 1, 0, 1, 0, 2 ,2}, // Plains of Rivendell
			{ 1, 0, 0, 0, 0, 2 ,0}, //northmirkwood
			{ 1, 0, 0, 1, 0, 1 ,1},
			{ 1, 0, 1, 1, 0, 0 ,2},
			{ 1, 1, 2, 0, 0, 1 ,0},
			{ 1, 1, 0, 2, 0, 0 ,1},
			{ 1, 1, 0, 1, 0, 2 ,2},
			{ 1, 0, 2, 0, 0, 2 ,0},
			{ 0, 0, 0, 1, 0, 1 ,1},
			{ 0, 0, 1, 1, 0, 0 ,2},
			{ 0, 0, 1, 2, 0, 1 ,0},
			{ 0, 1, 0, 2, 0, 0 ,1},
			{ 0, 1, 0, 1, 0, 2 ,2},
		};

	double[][] expected = {
			{ 1.0, 0.0, 0.0, 0.0, 0.0, 0.0 ,0.0}, 
			{ 0.0, 1.0, 0.0, 0.0, 0.0, 0.0 ,0.0}, 
			{ 0.0, 0.0, 1.0, 0.0, 0.0, 0.0 ,0.0}, 
			{ 0.0, 0.0, 0.0, 1.0, 0.0, 0.0 ,0.0},
			{ 0.0, 0.0, 0.0, 0.0, 1.0, 0.0 ,0.0}, 
			{ 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 ,0.0}, 
			{ 0.0, 0.0, 0.0, 0.0, 1.0, 0.0 ,1.0}, 
			{ 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 ,0.0},
			{ 0.0, 0.0, 0.0, 0.0, 1.0, 0.0 ,0.0}, 
			{ 0.0, 0.0, 0.0, 1.0, 0.0, 0.0 ,0.0}, 
			{ 0.0, 1.0, 0.0, 0.0, 0.0, 0.0 ,0.0}, 
			{ 1.0, 0.0, 0.0, 0.0, 0.0, 0.0 ,0.0},
			{ 0.0, 1.0, 0.0, 0.0, 0.0, 0.0 ,0.0}, 
			{ 0.0, 0.0, 1.0, 0.0, 0.0, 0.0 ,0.0}, 
			{ 0.0, 0.0, 0.0, 1.0, 0.0, 0.0 ,0.0}, 
			{ 0.0, 0.0, 0.0, 0.0, 1.0, 0.0 ,0.0},
			{ 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 ,0.0}, 
			{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 ,1.0} };
}
