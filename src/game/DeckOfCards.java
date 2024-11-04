/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Nichael Heller
 * Section: 11 am
 * Date: 11/17/19
 *
 * Project: csci205_Kings_Disciples
 * Package: main
 * Class: DeckOfCards
 *
 * Description:  Deck of cards to implement for the poker game
 *
 * ****************************************
 */

package game;

import game.Card;

import java.util.ArrayList;
import java.util.Random;

/**
 * Deck of cards class to implement for the poker game
 * @author Michael Heller
 * @version 0.1
 */
public class DeckOfCards {

    /** final variable for the number of cards in a deck **/
    private final int NUMBER_OF_CARDS = 52;

    /** list of Card objects for the deck **/
    private ArrayList<Card> deck;

    /**
     * constructor for the DeckOfCards object
     */
    public DeckOfCards() {

        for (int i = 0; i < NUMBER_OF_CARDS; i++) {
            for (int j = 2; j < 15; j++) {
                Card card = new Card(j, "Spades", "Black");
                deck.add(card);
            }
            for (int c = 2; c < 15; c++) {
                Card card = new Card(c, "Clubs", "Black");
                deck.add(card);
            }
            for (int h = 2; h < 15; h++) {
                Card card = new Card(h, "Hearts", "Red");
                deck.add(card);
            }
            for (int d = 2; d < 15; d++) {
                Card card = new Card(d, "Diamonds", "Red");
                deck.add(card);
            }

        }
    }

    /**
     * getter method for the deck of cards
     * @return
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * setter method for the deck of cards
     * @param deck
     */
    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    /**
     * create random shuffled deck
     * @param deck
     */
    public void shuffleDeck (ArrayList<Card> deck) {
        Random rand = new Random();
        for (int i = deck.size() - 1; i > 0; i--) {
            int randIndex = rand.nextInt(i);
            Card temp = deck.get(i);
            deck.set(i, deck.get(randIndex));
            deck.set(randIndex, temp);
        }
    }

    /**
     * main method for the DeckOfCards class
     * @param args
     */
    public static void main(String[] args) {
    }


}
