package game;
import java.util.Random;

import cards.Card;

import java.util.ArrayList;

/**
 * A class to represent the Players of the game.
 * 
 * @author Daniel Falcone
 */
public class Player {
	/**
	 * ArrayList of type Card that will store the hands.
	 */
	private ArrayList<Card> hand = new ArrayList<Card>();
	/**
	 * String to store the name of the players.
	 */
	private String name = "Default";
	/**
	 * Integer to track the score of the games.
	 */
	private int score = 0;
	/**
	 * Instantiate new Random object. To be used to determine which card is going to
	 * be played
	 */
	Random rand = new Random();

	/**
	 * Constructor for the Player class.
	 * 
	 * @param nameParam to set the name of the Player
	 */
	public Player(String nameParam) {
		name = nameParam;
		// If the entered name is empty set it to be 'Default'
		if (nameParam.equals("")) {
			name = "Default";
		}
	}

	/**
	 * A method to add a card to the hand.
	 * 
	 * @param cardParam to specify which card is being added
	 */
	public void addCard(Card cardParam) {
		// Add the card in parameter to the hand
		hand.add(cardParam);
	}

	/**
	 * A method to get the current score.
	 * 
	 * @return the value of the score variable
	 */
	public int getScore() {
		return score;
	}

	/**
	 * A method to get the name of the player.
	 * 
	 * @return the String stored in name
	 */
	public String getName() {
		return name;
	}

	/**
	 * A method to display the current hand.
	 * 
	 * @return the cards one by one
	 */
	public String getHand() {
		// String to store the current card
		String builder = "";
		// Enhanced for loop to add cards to builder
		for (Card c : hand) {
			builder += c.getShortName();
		}
		return builder;
	}

	/**
	 * A method to select a card at random and play it.
	 * 
	 * @return chosen card or null
	 */
	public Card playCard() {
		// Check to see if the hand is out of cards
		if (hand.size() == 0) {
			System.out.print("Player:  Request made to play a card when hand is empty.");
			return null;
		}

		// Play a card at random.
		// Report which card was played.
		int removeCard = rand.nextInt(hand.size());
		Card chosenCard = hand.get(removeCard);
		hand.remove(chosenCard);
		return chosenCard;
	}

	/**
	 * A method to increment the player's score when a hand is won.
	 */
	public void handWon() {
		score++;
	}

	/**
	 * A method to clear the hand of all cards.
	 */
	public void reset() {
		hand.clear();
		// Empty hand arraylist;
		score = 0;
	}
}