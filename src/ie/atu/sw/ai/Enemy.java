package ie.atu.sw.ai;

public class Enemy {
	
	private EnemyType type;
    private int health;
    private int damage;
    
    public Enemy(EnemyType type, int health, int damage) {
        this.type = type;
        this.health = health;
        this.damage = damage;
    }
    
    public EnemyType getType() {
        return type;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
