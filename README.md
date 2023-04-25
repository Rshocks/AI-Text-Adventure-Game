# AI-Text-Adventure-Game
An AI text adventure game based on the Hobbit, in which the user must travel to a small number of different locales in order to reach the goal node, the lonely mountain, and kill the dragon.

## Features
Neural Networks: 
1) Based on the player's travel inputs, the AI will predict where they are and present a string when they get at their predicted journey destination.

2) The AI will select which of the four characters the user will play as; each character has a separate set of stats.

Fuzzy Logic:
1) Fuzzy logic will generate a random event for the player to experience while traveling to each destination; the event is determined by the player's health, and the event may drop or raise the player's health based on how low or high their health is.

2) Fuzzy logic governs how hard enemies in the game attack the player; when the enemy has full health, they do less damage, when they have medium health, they do normal damage, and when they are weak, they do extra damage.

## Interaction
Prerequisites: [Eclipse IDE](https://www.eclipse.org/downloads/) and [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

1) Clone this repository to your own environment.
2) In Eclipse create a new Java Project.
3) Configure the aicme4j and jFuzzyLogic jar files in Eclipse by selecting properties, then Java build path, and then adding the two jars to the modulepath.
4) Run LocationNeural and PlayerNeural classes as Java Applications.
5) After that launch the game by using the Runner class then running it as a Java Application.
