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
 * Class: River
 *
 * Description:  Class to initiate a river for the poker game
 *
 * ****************************************
 */

package game;

import java.util.ArrayList;

/**
 * River class to create the river of cards for the round of poker
 * @author Michael Heller
 * @version 0.1
 */
public class River {

    /** List of cards that compose the river **/
    private ArrayList<Card> cardList;

    /**
     * constructor for the River class
     */
    public River(ArrayList<Card> cardList) {
        this.cardList = cardList;
    }

    /**
     * getter method for the list of cards
     * @return cardList
     */
    public ArrayList<Card> getCardList() {
        return cardList;
    }

    /**
     * setter method for the list of cards
     * @param cardList
     */
    public void setCardList(ArrayList<Card> cardList) {
        this.cardList = cardList;
    }

    /**
     * main method for the River class
     * @param args
     */
    public static void main(String[] args) { }
}
