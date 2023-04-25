package resources.fuzzy;

public class EventHandler {
	
	public int handleEvent(int playerHealth) {
		GetEvent getEvent = new GetEvent();
		double eventLevel = getEvent.getEventLevel(playerHealth);

		if (eventLevel < 1) {
			playerHealth -= 20;
			System.out.println("a pack of goblins robbed you in your sleep. Your health is now " + playerHealth);
		} else if (eventLevel < 2) {
			playerHealth -= 7;
			System.out.println("howling orcs kept you awake all night. Your health is now " + playerHealth);
		} else if (eventLevel < 3) {
			System.out.println("you get a sturdy nights sleep. Your health is now " + playerHealth);
		} else if (eventLevel < 4) {
			playerHealth += 10;
			System.out.println("you find a small creek and catch a fish for dinner. Your health is now " + playerHealth);
		} else {
			playerHealth += 20;
			System.out.println("you awake to find your body stronger, the gods smile on your quest. Your health is now " + playerHealth);
		}
		return playerHealth;
	}
}
