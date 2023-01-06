package cards;
/**
 * An interface to define a card.
 * 
 * @author Daniel Falcone
 *
 */
public interface CardTemplate {

	/**
	 * Integer to define the max number of cards.
	 */
	final static int MAX_CARDS = 52;
	/**
	 * Integer to define the max number of suits.
	 */
	final static int MAX_SUITS = 4;
	/**
	 * Integer to define the max number of face cards.
	 */
	final static int MAX_FACES = 13;

	/**
	 * Character array to store letters for each suit.
	 */
	static char[] suitShort = new char[] { 's', 'h', 'd', 'c' };

	/**
	 * String array to store letters and numbers for each card in a suit.
	 */
	static String[] rankShort = new String[] { "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2" };
	/**
	 * String array to store the full names of the suits.
	 */
	static String[] suitLong = new String[] { "Spades", "Hearts", "Diamonds", "Clubs" };
	/**
	 * String array to store the written values of the number or face of the card.
	 */
	static String[] rankLong = new String[] { "Ace", "King", "Queen", "Jack", "Ten", "Nine", "Eight", "Seven", "Six",
			"Five", "Four", "Three", "Two" };

	/**
	 * Method to return the short form of the name of the card.
	 * 
	 * @return the short name of the card
	 */
	public String getShortName();

	/**
	 * Method to return the full name of the card.
	 * 
	 * @return the full name of the card
	 */
	public String getLongName();
}
