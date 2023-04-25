package ie.atu.sw.ai;

import java.util.Random;
import java.util.Scanner;

import resources.fuzzy.EnemyDamageHandler;

public class EnemyEncounter {
	private Scanner s;
	private Enemy enemy;
	private EnemyDamageHandler enemyDamageHandler;

	public EnemyEncounter(Enemy enemy) {
		this.enemy = enemy;
		s = new Scanner(System.in);
		enemyDamageHandler = new EnemyDamageHandler();
	}

	public int startEncounter(int playerDamage, int playerHealth) {
		Random rand = new Random();

		boolean isFighting = true;
		while (isFighting) {
			System.out.println("Choose your action: (1) Attack, (2) CounterAttack, (3) QuickJab");
			String input = s.nextLine().toLowerCase();

			if (input.equals("1") || input.equals("attack")) {
				int defense = rand.nextInt(5) + 1; // generate a random number
				int damageDealt = playerDamage - defense;
				enemy.setHealth(enemy.getHealth() - damageDealt); // update enemy health
				System.out.println("You swipe your weapon with your might dealing " + damageDealt + " damage to the " + enemy.getType() + "!");
				
				// player takes damge
				int enemyDamage = enemyDamageHandler.handleDamage(enemy);
				int damageTaken = enemyDamage;
				playerHealth -= damageTaken;
				System.out.println("Your health is now " + playerHealth);
				
			} else if (input.equals("2") || input.equals("counterattack")) {
			    int enemyDamage = enemyDamageHandler.handleDamage(enemy);
			    int damageTaken = enemyDamage;

			    // Calculate the chance of success
			    int successChance = 60; // 60% chance of success
			    boolean isSuccess = (new Random().nextInt(100) + 1) <= successChance;

			    if (isSuccess) {
			        System.out.println("But you successfully counter-attacked, took no damage and dealt " + playerDamage);
			        enemy.setHealth(enemy.getHealth() - playerDamage); // update enemy health
			        System.out.println("Your health is now " + playerHealth);
			    } else {
			        playerHealth -= damageTaken;
			        System.out.println("You attempted to counter-attack, but the " + enemy.getType() + " was too fast and dealt " + damageTaken + " damage to you!");
			        System.out.println("Your health is now " + playerHealth);
			    }
			    
			} else if (input.equals("3") || input.equals("quickjab")) {
				int damageDealt = playerDamage - 5;
				enemy.setHealth(enemy.getHealth() - damageDealt); // update enemy health
				System.out.println("You side step your enemy and jab a weak point dealing " + damageDealt + " damage to the " + enemy.getType() + "!");
				
				// player takes damge
				int enemyDamage = enemyDamageHandler.handleDamage(enemy);
				int damageTaken = enemyDamage;
				playerHealth -= damageTaken;
				System.out.println("Your health is now " + playerHealth);
			} else {
				System.out.println("Invalid input. Choose your action: (1) Attack, (2) Defend, (3) QuickJab");
				continue;
			}

			if (enemy.getHealth() <= 0) {
				System.out.println("You defeated the " + enemy.getType() + "!");
                System.out.println();
				isFighting = false;
				return playerHealth;
			} else if (playerHealth <= 0) {
				System.out.println("You have been defeated by the " + enemy.getType() + " your journey is over!");
				System.exit(0);
				return playerHealth;
			}
		}
		
		return playerHealth;
	}
}