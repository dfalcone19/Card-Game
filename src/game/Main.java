package game;
import java.util.Random;
import java.util.Scanner;

import cards.Card;

import java.util.ArrayList;

/**
 * Main class for Lab 4 assignment.
 * 
 * @author Daniel Falcone
 */
public class Main {
	/**
	 * An integer to set the max number of players.
	 */
	final int MAX_PLAYERS = 4;

	/**
	 * An ArrayList of type Card to store the cards.
	 */
	ArrayList<Card> deck = new ArrayList<Card>();

	/**
	 * An array of type Player to store players.
	 */
	Player[] playerList = new Player[MAX_PLAYERS];

	/**
	 * A final integer to represent the game starting with a numerical value.
	 * Starting the game is represented by 0
	 */
	public final int STARTING = 0;
	/**
	 * A final integer to represent the game being in progress. The game being in
	 * progress is represented by 1
	 */
	public final int IN_PROGRESS = 1;
	/**
	 * A final integer to represent the game being finished. Ending the game is
	 * represented by 2
	 */
	public final int FINISHED = 2;
	/**
	 * An integer to track the progress of the game. Status has an initial value of
	 * 'STARTING'
	 */
	public int status = STARTING;
	/**
	 * An integer to store the number of the round.
	 */
	public int roundnum = 0;
	/**
	 * An integer to track which player is currently being used.
	 */
	public int curPlayer = 0;
	/**
	 * Instantiate a new Random object. To be used for selecting a player and a card
	 */
	Random rand = new Random();
	/**
	 * Instantiate a new Scanner object.
	 */
	Scanner keyboard = new Scanner(System.in);

	/**
	 * Main method used to instantiate Lab4 object.
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		Main m = new Main();
	}

	/**
	 * Constructor for Lab4 class.
	 */
	public Main() {
		// Nested for loop to populate deck
		for (int iSuit = 0; iSuit < 4; iSuit++) {
			for (int iRank = 0; iRank < 13; iRank++) {
				// Add a new card object with parameters of iRank and iSuit
				deck.add(new Card(iRank, iSuit));
			}
		}

		// Call startGame() method
		startGame();

		// Menu loop
		boolean quitting = false;
		while (!quitting) {
			// Call dealCards() method
			dealCards();
			quitting = showRound();
		}
		System.out.println("Thanks for playing!\nThis Auto-Cards implementation by Daniel Falcone.");
	}

	/**
	 * A method to display the round, prompt the user if they would like to keep
	 * playing, play the cards, pick a winner of the round, check to see if the game
	 * is over, and if it is pick a winner of the entire game.
	 * 
	 * @return True if the user wants to quit
	 */
	public boolean showRound() {
		// Integer to store round number
		int roundNum = 1;
		// Integer to store player offset
		int playerOffset = 0;
		// String to store user response
		String response = "";

		do {
			// Show round number
			System.out.println("This is round " + roundNum + ".");
			// Show of hands.
			for (int i = 0; i < MAX_PLAYERS; i++) {
				System.out.println(playerList[i].getName() + "(" + playerList[i].getScore() + " hands won):"
						+ playerList[i].getHand());
			}

			// User bailout chance.
			System.out.println("Enter q to quit, anything else to play out this round: ");
			response = keyboard.nextLine();
			if (response.equals("q") || response.equals("Q"))
				return true;

			// Players play cards.
			for (int i = 0; i < MAX_PLAYERS; i++) {
				// Determine which player plays which card
				int curPlayer = (i + playerOffset) % MAX_PLAYERS;
				Card tempCard = playerList[curPlayer].playCard();
				System.out.println(playerList[curPlayer].getName() + " plays " + tempCard.getLongName());
				deck.add(tempCard);
			}

			// Pick a winner.
			playerOffset = rand.nextInt(MAX_PLAYERS);
			System.out.println(playerList[playerOffset].getName() + " wins this hand!\n");
			// Increment number of hands won for the winner
			playerList[playerOffset].handWon();
			// Increment rounds
			roundNum++;
		}
		// Run loop until there have been 13 rounds
		while (roundNum < 14);

		System.out.println("Game over!");
		System.out.println("Final scores:");
		// Integer to store max value
		int max = 0;
		// Integer to store chose player
		int chosenPlayer = 0;

		// Display all players and how many hands they won
		for (int i = 0; i < MAX_PLAYERS; i++) {
			System.out.println(playerList[i].getName() + " with " + playerList[i].getScore() + " hands won.");
			// Determine who the winner is
			if (playerList[i].getScore() > max) {
				max = playerList[i].getScore();
				chosenPlayer = i;
			}
		}
		System.out.println(playerList[chosenPlayer].getName() + " has won! (unless they tied)");
		System.out.println("\nAnother game? y to continue: ");
		// See if the user would like to play another game
		response = keyboard.nextLine();
		if (response.equals("y") || response.equals("Y"))
			return false;
		return true;

	}

	/**
	 * A method to distribute cards to all players.
	 */
	public void dealCards() {
		// Clear players out.
		for (int i = 0; i < MAX_PLAYERS; i++) {
			playerList[i].reset();
		}

		System.out.println("Dealing cards...");
		// Integer to store card selection
		int cardSel = 0;
		// Integer to store deck size
		int deckSize = deck.size();
		// Deal cards to players until the deck size is full
		for (int i = 0; i < deckSize; i++) {
			cardSel = rand.nextInt(deck.size());
			playerList[i % MAX_PLAYERS].addCard(deck.get(cardSel));
			deck.remove(cardSel);
		}
	}

	/**
	 * A method to start the game by gathering player names and adding the names to
	 * the playerList array.
	 */
	public void startGame() {
		System.out.println("Welcome to Auto-Cards.");
		System.out.println("Before we start, let's name the four players.");
		// String to store players' names
		String name = "";
		// Get user to enter 4 player names
		for (int i = 0; i < MAX_PLAYERS; i++) {
			do {
				System.out.print("Enter player " + (i + 1) + "'s name: ");
				name = keyboard.nextLine();
				if (name.length() < 3)
					System.out.println("Names must be at least three characters long.");
			}
			// Ensure that the name entered is longer than 3
			while (name.length() < 3);
			// Add new Player object to playerList array with the entered name
			playerList[i] = new Player(name);
		}

	}

}
