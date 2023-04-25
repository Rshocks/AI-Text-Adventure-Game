package resources.fuzzy;

import ie.atu.sw.ai.Enemy;

public class EnemyDamageHandler {
	public int handleDamage(Enemy enemy) {
        GetEnemyDamage getDamage = new GetEnemyDamage();
        double damageLevel = getDamage.getDamageLevel(enemy.getHealth());

        int damage = 0;
        if (damageLevel < 1.5) {
            damage = enemy.getDamage() / 2;
            System.out.println("Your attacker flails at you ineffectively. You take " + damage + " damage");
        } else if (damageLevel < 2.5) {
            damage = enemy.getDamage();
            System.out.println("Your enemy knocks the wind out of you but you recover your footing. You take " + damage + " damage");
        } else if (damageLevel < 3) {
            damage = enemy.getDamage() + 3;
            System.out.println("You enduring a series of devastating strikes from your enemy. You take " + damage + " damage");
        }
        return damage;
    }
}
