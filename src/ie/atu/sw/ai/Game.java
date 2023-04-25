package ie.atu.sw.ai;

import java.util.Scanner;

import resources.fuzzy.EventHandler;
import resources.neural.GetLocation;
import resources.neural.PlayerPick;

public class Game {
	private Scanner s;

    public Game() {
        s = new Scanner(System.in);
    }

    public void run() throws Exception {
    	String input = "";
    	
    	System.out.println("After an unexpected visit, a company of dwarfs, a hobbit, and an elderly wizard set out from Hobbiton.");
		System.out.println("Their quest is to slay a dragon and take back a home that was long lost.");

		int[] playerStats = PlayerPick.pickPlayer();
		int playerHealth = playerStats[0];
		int playerDamage = playerStats[1];

		System.out.println("Your journey begins, the company sets off for Rivendell, travel by typing 'Onward', after the event, type 'Rivendell' to travel to the location");

		boolean isTravelling = true;
		while (isTravelling) {
			input = s.nextLine().toLowerCase();
			if (input.equals("onward") || input.equals("onwards")) {
				System.out.print("While on the road ");
				EventHandler eventHandler = new EventHandler();
				playerHealth = eventHandler.handleEvent(playerHealth);
				
				System.out.println("Shall the company resume its journey to our current location?");

		        boolean hasChosenLocation = false;
		        while (!hasChosenLocation) {
		            input = s.nextLine().toLowerCase();
		            
					// plains of rivendell
					if (input.equals("rivendell")) {
                        String locationString = GetLocation.predictLocation(new double[] { 2, 1, 0, 1, 0, 2 ,2});
                        System.out.println(locationString);
                        
            			EnemyType typeWrag = EnemyType.WRAG;
            			Enemy wrag = new Enemy(typeWrag, 25, 4);
                        
                        EnemyEncounter ee = new EnemyEncounter(wrag);
                        playerHealth = ee.startEncounter(playerDamage, playerHealth); // pass playerHealth to the startEncounter method
                        
                        System.out.println("The company has fended off the attack, in rivendell the elfs support the quest.");
                        System.out.println("They tell of two paths open through the mountains, one through a massive goblin lair or a trolls cave.");
                        System.out.println("The company cannot decide which route to take and leave it for you to decide");
                        System.out.println("after the road event, type 'goblincave' or 'trollcave' to pick the next location for the company");
                        hasChosenLocation = true;
					}
					//goblin cave
		            else if (input.equals("goblin cave") || input.equals("goblincave")) {
		                String locationString = GetLocation.predictLocation(new double[] { 2, 0, 1, 1, 0, 0 ,2});
		                System.out.println(locationString);
		                playerHealth -= 5;
                        System.out.println("As you fall you twist your leg " + playerHealth);

            			EnemyType typeGoblin = EnemyType.GOBLIN;
            			Enemy goblin = new Enemy(typeGoblin, 15, 3);
            			
            			//first goblin
		                EnemyEncounter ee = new EnemyEncounter(goblin);
		                playerHealth = ee.startEncounter(playerDamage, playerHealth);
		                
            			EnemyType typeGoblinTwo = EnemyType.GOBLIN;
            			Enemy goblinTwo = new Enemy(typeGoblinTwo, 15, 3);
            			
		                //second goblin
		                System.out.println("Another goblin is closing in on you");
		                EnemyEncounter second = new EnemyEncounter(goblinTwo);
		                playerHealth = second.startEncounter(playerDamage, playerHealth); // pass playerHealth to the startEncounter method
		                
                        System.out.println("The company survived the horrid goblins in the mountains, now we advance to mirkwood of which two paths are open north and south road!");
                        System.out.println("After travel type 'NorthMirkwood' or 'SouthMirkwood' to get to the next location!");		                
                        hasChosenLocation = true;
		            } 
					//troll cave
		            else if (input.equals("troll cave") || input.equals("trollcave")) {
		                String locationString = GetLocation.predictLocation(new double[] { 2, 0, 1, 2, 0, 1 ,0});
		                System.out.println(locationString);
		                
            			EnemyType typeTroll = EnemyType.TROLL;
            			Enemy troll = new Enemy(typeTroll, 70, 6);
            			
		                EnemyEncounter ee = new EnemyEncounter(troll);
		                playerHealth = ee.startEncounter(playerDamage, playerHealth); // pass playerHealth to the startEncounter method
		                
                        System.out.println("The combined efforts of the company killed these trolls clearing our pass, now we advance to mirkwood of which two paths are open north and south road!");
                        playerDamage += 5;
                        System.out.println("You find a new weapon in the troll hoard!");
                        System.out.println("After travel type 'NorthMirkwood' or 'SouthMirkwood' to get to the next location!");
		                hasChosenLocation = true;
		            }
					
					//southmirkwood
		            else if (input.equals("southmirkwood")) {
		                String locationString = GetLocation.predictLocation(new double[] { 2, 0, 0, 1, 0, 1 ,1});
		                System.out.println(locationString);
		                
            			EnemyType typeSpider = EnemyType.SPIDER;
            			Enemy spider = new Enemy(typeSpider, 60, 8);
            			
		                EnemyEncounter ee = new EnemyEncounter(spider);
		                playerHealth = ee.startEncounter(playerDamage, playerHealth); // pass playerHealth to the startEncounter method
		                
                        System.out.println("After what you've been through a spider was no match, the company continues down the path, when suddenly fresh air greets you, the forest is behind you!");
                        System.out.println("Now its time to venture forth to dale and then the lonely mountain.");
                        System.out.println("After travel type 'Dale' to get to the next location!");
		                hasChosenLocation = true;
		            }
					
					//northmirkwood
		            else if (input.equals("northmirkwood")) {
		                String locationString = GetLocation.predictLocation(new double[] { 1, 0, 0, 0, 0, 2 ,0});
		                System.out.println(locationString);
		                
            			EnemyType typeOrc = EnemyType.ORC;
            			Enemy orc = new Enemy(typeOrc, 60, 5);
            			
		                EnemyEncounter ee = new EnemyEncounter(orc);
		                playerHealth = ee.startEncounter(playerDamage, playerHealth); // pass playerHealth to the startEncounter method
		                
                        System.out.println("You dipatch the orcs, although the route ahead is blocked, you must go back and take the south route");
                        playerHealth += 5;
                        System.out.println("You find some elfish bread on a recently dead elf your health is now " + playerHealth);
                        System.out.println("After travel type 'SouthMirkwood' to get to the next location!");
		                hasChosenLocation = true;
		            }
					
					//Dale
		            else if (input.equals("dale")) {
		                String locationString = GetLocation.predictLocation(new double[] { 1, 0, 0, 1, 0, 2 ,0});
		                System.out.println(locationString);
		                
            			EnemyType typeOrc = EnemyType.ORC;
            			Enemy orc = new Enemy(typeOrc, 30, 5);
            			
		                EnemyEncounter ee = new EnemyEncounter(orc);
		                playerHealth = ee.startEncounter(playerDamage, playerHealth);
		                
            			EnemyType typeOrcTwo = EnemyType.ORC;
            			Enemy orcTwo = new Enemy(typeOrcTwo, 30, 5);
            			
		                System.out.println("Another orc lunges forth!");
		                EnemyEncounter second = new EnemyEncounter(orcTwo);
		                playerHealth = second.startEncounter(playerDamage, playerHealth);
		                
            			EnemyType typeOrcThree = EnemyType.ORC;
            			Enemy orcThree = new Enemy(typeOrcThree, 30, 5);
            			
		                System.out.println("Another orc wildly attacks you!");
		                EnemyEncounter third = new EnemyEncounter(orcThree);
		                playerHealth = third.startEncounter(playerDamage, playerHealth);
		                
                        System.out.println("At last you dispatch your foes, some of the company have to stay behind to tend to their wounds, you and the rest venture on.");
                        System.out.println("You see the lonely mountain, it seems close although there is still a days walk until we arrive on our quests conclusion.");
                        System.out.println("After travel type 'LonelyMountain' to get to the next location!");
		                hasChosenLocation = true;
		            }
					
					//LonelyMt
		            else if (input.equals("lonelymountain") || input.equals("lonely mountain")) {
		                String locationString = GetLocation.predictLocation(new double[] { 2, 1, 0, 2, 0, 0 ,1});
		                System.out.println(locationString);
		                
		                playerHealth += 30;
		                playerDamage += 3;
		                
                        System.out.println("The compnay sneak into the ancient armory to prepare for the final fight and some rest, you find some mithril armor and weapons.");
                        System.out.println("Your damage is now " + playerDamage + " and your health is now " + playerHealth);
		                
            			EnemyType typeSmaug = EnemyType.SMAUG;
            			Enemy smaug = new Enemy(typeSmaug, 100, 10);
            			
		                EnemyEncounter ee = new EnemyEncounter(smaug);
		                playerHealth = ee.startEncounter(playerDamage, playerHealth);
		                
                        System.out.println("The dragon seems invicible when suddenly a black arrow, fired by a man of dale pierces the drakes underbelly killing the beast.");
                        System.out.println("A few days later a great ceremony is held as the company say their goodbyes and your quest in complete.");
		                hasChosenLocation = true;
		                System.exit(0);
		            } 
		            
		            else {
		                System.out.println("Invalid input");
		            }
		        }
		        System.out.println("Shall the company continue onwards?");
			} else {
				System.out.println("Invalid input. Please type 'Onward' to travel.");
			}
		}
    }
}
