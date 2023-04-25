package resources.fuzzy;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class GetEvent {
	private static final String FCL_FILE = "./src/fcl/Event.txt";
	private FIS fis;
	private FunctionBlock fb;
	
	public GetEvent() {
		fis = FIS.load(FCL_FILE, true);
		fb = fis.getFunctionBlock("getEvent"); 
	}
	
	public double getEventLevel(double health) { 
		fis.setVariable("health", health);
		fis.evaluate();
	
		var event = fb.getVariable("event"); 
		
		return event.getValue(); 
	}
}
