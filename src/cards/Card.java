package cards;

/**
 * A class to represent individual cards.
 * 
 * @author Daniel Falcone
 *
 */
public class Card implements CardTemplate {
	/**
	 * Integer to define the max number of cards in a deck.
	 */
	int MAX_CARDS = 52;
	/**
	 * Integer to define the max number of suits.
	 */
	int MAX_SUITS = 4;
	/**
	 * Integer to define the max number of face cards.
	 */
	int MAX_FACES = 13;
	/**
	 * Integer to track the current suit of the card.
	 */
	int curSuit;
	/**
	 * Integer to track the current rank of the card.
	 */
	int curRank;

	/**
	 * Constructor for the individual card.
	 * 
	 * @param rankParam to track the rank of the card
	 * @param suitParam to track the suit of the card
	 */
	public Card(int rankParam, int suitParam) {
		// Set the instance suit variable to the parameter variable
		curSuit = suitParam;
		// Set the instance rank variable to the parameter variable
		curRank = rankParam;
		// If the suit is less than 1 or greater than the max report an error
		if (suitParam < 0 || suitParam > MAX_SUITS) {
			curSuit = 0;
			System.out.println("Error generating card for value " + suitParam + ", " + rankParam);
		}
		// If the rank is less than 1 or greater than the max report an error
		if (rankParam < 0 || rankParam > MAX_FACES) {
			curRank = 0;
			System.out.println("Error generating card for value " + suitParam + ", " + rankParam);
		}

	}

	/**
	 * A method to return the shortened name of the card.
	 */
	public String getShortName() {
		return rankShort[curRank] + suitShort[curSuit] + " ";
	}

	/**
	 * A method to return the full name of the card.
	 */
	public String getLongName() {
		return rankLong[curRank] + " of " + suitLong[curSuit];
	}
}
