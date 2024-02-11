package PersonAndDate;

import java.util.Random;
import java.util.Scanner;

public class GuessMaster {
	private int numberOfCandidateEntities;
	private Entity[] entities;
	
	//no argument constructor
	public GuessMaster() {
		this.numberOfCandidateEntities = 0;
		this.entities = new Entity[10];
	}
	
	//argument constructor
	public GuessMaster(int numberOfCandidateEntities, Entity[] entities) {
		this.numberOfCandidateEntities = numberOfCandidateEntities;
		this.entities = entities;
	}
	
	//Accessors
	public int getNumOfCan() {
		return numberOfCandidateEntities;
	}
	
	public Entity getEntity(int index) {
		return entities[index];
	}
	
	//suggested methods
	//add an entity to the list
    public void addEntity(Entity entity) {
        // Increment number of entities
        this.entities[numberOfCandidateEntities++] = entity;
    }
	
    //plays the game
	public void playGame(Entity entity) {
		boolean tryAgain = true; //flag to check in they guessed correctly
		Scanner keyboard = new Scanner(System.in); 

		System.out.println("You will guess the birthday of " + entity.getName());
		
		while(tryAgain) { //while they haven't guessed correctly
			System.out.println("Enter your guess: ");
			String playerInput = keyboard.nextLine();
			
			//checks for exit or quit command
			if(playerInput.toLowerCase().equals("exit") || playerInput.toLowerCase().equals("quit")) {
				System.out.println("exiting...");
				System.exit(0);
			}
			
			   
			//creates date objects for guess and actual date to be compared
			Date playerGuess = new Date(playerInput);
			Date entityDate = entity.born();

			

				//checks if date is equal, less, or greater
				if(playerGuess.equals(entityDate)) {
					System.out.println("BINGO. You got it!!");
					tryAgain = false;
				}else if(playerGuess.precedes(entityDate)) {
					System.out.println("Incorrect. Try a later date.");
				}else {
					System.out.println("Incorrect. Try an earlier date");
				}
			}
		
	}

	//plays the game with an index
	public void playGame(int entityInd) {
		Entity newEntity = entities[entityInd];
		playGame(newEntity);
	}
	
	//plays the game with a random entity
	public void playGame() {
		playGame(getRandomEntityInd());
	}	
	
	//gets a random index for random play game
	int getRandomEntityInd() {
		Random rand = new Random();
		return rand.nextInt(numberOfCandidateEntities);
	}
	
	public static void main(String[] args) {
		Entity trudeau = new Entity(
				"Justin Trudeau", new Date("December", 25, 1971));
				Entity dion = new Entity("Celine Dion", new Date("March", 30, 1968));
				Entity usa = new Entity("United States", new Date("July", 4, 1776));
				Entity alex = new Entity("Alex", new Date("November", 17, 2003)); 
				Entity sydney = new Entity("Sydney", new Date("April", 30, 2004)); 
				Entity auston = new Entity("Auston Matthews", new Date("September", 17, 1997));
				Entity connor = new Entity("Connor McDavid", new Date("January", 13, 1997));
				GuessMaster gm = new GuessMaster();
				gm.addEntity(trudeau);
				gm.addEntity(dion);
				gm.addEntity(usa);
				gm.addEntity(alex);
				gm.addEntity(sydney);
				gm.addEntity(auston);
				gm.addEntity(connor);
				
				
				System.out.println("Welcome to Guessmaster!");
				System.out.println("Type exit or quit at anytime to exit");
				
				while(true) {
					gm.playGame();
				}	
	}
}
