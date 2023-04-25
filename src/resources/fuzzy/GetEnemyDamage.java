package resources.fuzzy;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

public class GetEnemyDamage {
	private static final String FCL_FILE = "./src/fcl/EnemyDamage.txt";
	private FIS fis;
	private FunctionBlock fb;
	
	public GetEnemyDamage() {
		fis = FIS.load(FCL_FILE, true);
		fb = fis.getFunctionBlock("getEnemyEvent"); 
	}
	
	public double getDamageLevel(double health) { 
		fis.setVariable("health", health);
		fis.evaluate();
	
		var damage = fb.getVariable("damage"); 
		
		return damage.getValue(); 
	}
}
