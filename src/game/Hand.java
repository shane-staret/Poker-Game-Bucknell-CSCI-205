/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Michael Heller
 * Section: 11 am
 * Date: 11/30/19
 * Time:
 *
 * Project: proj_backup
 * Package: game
 * Class: Hand
 *
 * Description:  class for a hand of poker
 *
 * ****************************************
 */

package game;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Hand class to create an object for each user
 * @author Michael Heller
 * @version 0.1
 */
public class Hand {

    /** the cards in the hand object **/
    private ArrayList<Card> userCards;

    /**
     * constructor for the Hand class
     */
    public Hand(ArrayList<Card> userCards) {
        this.userCards = userCards;
    }

    /**
     * getter method for the user cards
     * @return userCards
     */
    public ArrayList<Card> getUserCards() {
        return userCards;
    }

    /**
     * setter method for the userCards
     * @param userCards
     */
    public void setUserCards(ArrayList<Card> userCards) {
        this.userCards = userCards;
    }

    /**
     * main method for the Hand class
     * @param args
     */
    public static void main(String[] args) { }
}
