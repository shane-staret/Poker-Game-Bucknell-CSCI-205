/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Michael Heller
 * Section: 11 am
 * Date: 12/8/19
 *
 * Project: proj_backup
 * Package: main
 * Class: GameLogic
 *
 * Description:  The main logic of the poker game.  This should be connected to
 * the GUI through the GameController.
 *
 * ****************************************
 */

//TODO
// implement rest of poker game logic
// finish initiating all aspects of game rules
// refactor
// JUnit tests

package game;

import java.util.ArrayList;

/**
 * Main class for the poker game logic
 * @author Michael Heller
 * @version 0.1
 */
public class GameLogic {

    /**
     * Creates the main pot for the poker game
     **/
    private GamePot gamePot;

    /**
     * Creates a River object for the dealt cards per round
     **/
    private River river;

    /**
     * Creates a deck of cards to be used for the poker game
     **/
    private DeckOfCards deck;

    /**
     * Creates dealer object for the poker game
     **/
    private Dealer dealer;

    /**
     * Gives a certain number of CPUs to be created
     **/
    private int numCPUs = 3;

    /**
     * Gives the starting monetary value of each player
     **/
    private int startingMoneyValue = 500;

    /**
     * Creates a list that will contain all CPU players
     **/
    private ArrayList cpuList;


    /**
     * Creates the number of CPUs stated
     *
     * @param numCPUs
     */
    public void createCPUs(int numCPUs, int startingMoneyValue, DeckOfCards shuffledDeck, ArrayList handList) {
        //for the hand use userCards from hand class
        for (int i = 0; i < numCPUs; i++) {
            PlayerChips playerChips = new PlayerChips(startingMoneyValue);
            Hand currHand = (Hand) handList.get(i);
            CPU newCPU = new CPU(playerChips, currHand, gamePot);
            cpuList.add(newCPU);
        }
    }
}
