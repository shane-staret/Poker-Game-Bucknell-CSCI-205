/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Michael Heller
 * Section: 11 am
 * Date: 11/26/19
 * Time: 9:18 PM
 *
 * Project: King's Disciples
 * Package: main
 * Class: AnalyzeHands
 *
 * Description:  Ranks the possible hands in a round of poker
 *
 * ****************************************
 */

package game;
//TODO
// implement winning hand function
// connect with CPU class/form CPU class
// correct the "straight" algorithm
// check list and variable accessibility choices
// overall REFACTOR
// test methods

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class to rank the possible hands in a round of poker
 * @author Michael Heller
 * @version 0.1
 */
public class AnalyzeHands {

    /** takes in the river of cards for the round **/
    private River river;

    /** list of user hands **/
    private ArrayList<Hand> handList = new ArrayList<>();


    /**
     * constructor for the AnalyzeHands class
     */
    public AnalyzeHands(River river, ArrayList<Hand> handList) {
        this.river = river;
        this.handList = handList;
    }

    /**
     * getter method for the River object
     * @return river object
     */
    public River getRiver() {
        return river;
    }

    /**
     * setter method for the River object
     * @param river
     */
    public void setRiver(River river) {
        this.river = river;
    }

    /**
     * getter method for the hand list
     * @return handList
     */
    public ArrayList<Hand> getHandList() {
        return handList;
    }

    /**
     * setter method for the handList
     * @param handList
     */
    public void setHandList(ArrayList<Hand> handList) {
        this.handList = handList;
    }

    /**
     * puts all components from a player's hand and the river that could determine a final hand
     * into a list to be analyzed.
     * @param hand
     * @param river
     * @return components
     */
    public ArrayList<Card> createHandComponents(Hand hand, River river) {
        ArrayList<Card> components = new ArrayList<>();
        for (int i = 0; i < hand.getUserCards().size(); i++) {
            components.add(hand.getUserCards().get(i));
        }

        for (int j = 0; j < river.getCardList().size(); j++) {
            components.add(river.getCardList().get(j));
        }
        return components;
    }

    /**
     * Method to return whether or not a given hand is a royal flush
     * @param hand
     * @return if hand is a royal flush
     */
    public boolean royalFlush(Hand hand) {
        //NEEDS CORRECT STRAIGHT ALGORITHM
        ArrayList<Card> components = createHandComponents(hand, river);
        int highCount = 0;
        int spadeCount = 0;
        int clubCount = 0;
        int heartCount = 0;
        int diamondCount = 0;
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).getNum() >= 10) {
                for (int j = 0; j < components.size(); j++) {
                    if (i == j)
                        continue;
                    if (components.get(i).getNum() - components.get(j).getNum() == 1 || components.get(j).getNum() - components.get(i).getNum() == 1)
                        highCount++;
                }
            }
            if (components.get(i).getSuit() == "Spades")
                spadeCount ++;
            if (components.get(i).getSuit() == "Clubs")
                clubCount ++;
            if (components.get(i).getSuit() == "Hearts")
                heartCount ++;
            if (components.get(i).getSuit() == "Diamonds")
                diamondCount ++;
        }

        if (highCount >= 5) {
            if (spadeCount >= 5 || clubCount >= 5 || heartCount >= 5 || diamondCount >= 5)
                return true;
        }
        return false;
    }

    /**
     * Method to return whether or not a given hand is a straight flush
     * @param hand
     * @return if hand is a straight flush
     */
    public boolean straightFlush(Hand hand) {
        //NEEDS CORRECT STRAIGHT ALGORITHM
        ArrayList<Card> components = createHandComponents(hand, river);
        int straightCount = 0;
        int spadeCount = 0;
        int clubCount = 0;
        int heartCount = 0;
        int diamondCount = 0;
        for (int i = 0; i < components.size(); i++) {
            for (int j = 0; j < components.size(); j++) {
                if (i == j)
                    continue;
                if (components.get(i).getNum() - components.get(j).getNum() == 1 || components.get(j).getNum() - components.get(i).getNum() == 1)
                    straightCount++;
            }
            if (components.get(i).getSuit() == "Spades")
                spadeCount ++;
            if (components.get(i).getSuit() == "Clubs")
                clubCount ++;
            if (components.get(i).getSuit() == "Hearts")
                heartCount ++;
            if (components.get(i).getSuit() == "Diamonds")
                diamondCount ++;
        }

        if (straightCount >= 5) {
            if (spadeCount >= 5 || clubCount >= 5 || heartCount >= 5 || diamondCount >= 5)
                return true;
        }
        return false;
    }

    /**
     * Method to return whether or not a given hand is a four of a kind
     * @param hand
     * @return if hand is a four of a kind
     */
    public boolean fourOfAKind(Hand hand) {
        ArrayList<Card> components = createHandComponents(hand, river);
        int valueCount = 0;
        int fourNum = 0;
        for (int i = 0; i < components.size(); i++) {
            for (int j = 0; j < components.size(); j++) {
                if (i == j)
                    continue;
                if (components.get(i).getNum() == components.get(j).getNum()) {
                    fourNum = components.get(i).getNum();
                    valueCount += 2;
                    components.remove(i);
                    components.remove(j);
                    break;
                }
            }
            if (components.get(i).getNum() == fourNum)
                valueCount += 1;
        }
        if (valueCount >= 4)
            return true;
        return false;
    }

    /**
     * Method to return whether or not a given hand is a full house
     * @param hand
     * @return if hand is a full house
     */
    public boolean fullHouse(Hand hand) {
        ArrayList<Card> components = createHandComponents(hand, river);
        int threeCount = 0;
        int twoCount = 0;
        int threeNum = 0;
        for (int i = 0; i < components.size(); i++) {
            for (int j = 0; j < components.size(); j++) {
                if (i == j)
                    continue;
                if (components.get(i).getNum() == components.get(j).getNum()) {
                    threeNum = components.get(i).getNum();
                    threeCount += 2;
                    components.remove(i);
                    components.remove(j);
                    continue;
                }
                if (components.get(i).getNum() == components.get(j).getNum()) {
                    twoCount += 2;
                }
            }
            if (components.get(i).getNum() == threeNum)
                threeCount += 1;
        }
        if (threeCount >= 3 && twoCount >= 2)
            return true;
        return false;
    }

    /**
     * Method to return whether or not a given hand is a flush
     * @param hand
     * @return if hand is a flush
     */
    public boolean flush(Hand hand) {
        ArrayList<Card> components = createHandComponents(hand, river);
        int spadeCount = 0;
        int clubCount = 0;
        int heartCount = 0;
        int diamondCount = 0;
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).getSuit() == "Spades")
                spadeCount ++;
            if (components.get(i).getSuit() == "Clubs")
                clubCount ++;
            if (components.get(i).getSuit() == "Hearts")
                heartCount ++;
            if (components.get(i).getSuit() == "Diamonds")
                diamondCount ++;
        }

        if (spadeCount >= 5 || clubCount >= 5 || heartCount >= 5 || diamondCount >= 5)
            return true;
        return false;
    }

    /**
     * Method to return whether or not a given hand is a straight
     * @param hand
     * @return if hand is a straight
     */
    public boolean straight(Hand hand) {
        //NEEDS CORRECT STRAIGHT ALGORITHM
        ArrayList<Card> components = createHandComponents(hand, river);
        int straightCount = 0;
        for (int i = 0; i < components.size(); i++) {
            for (int j = 0; j < components.size(); j++) {
                if (i == j)
                    continue;
                if (components.get(i).getNum() - components.get(j).getNum() == 1 || components.get(j).getNum() - components.get(i).getNum() == 1)
                    straightCount++;
            }
        }

        if (straightCount >= 5) {
            return true;
        }
        return false;
    }

    /**
     * Method to return whether or not a given hand is a three of a kind
     * @param hand
     * @return if hand is a three of a kind
     */
    public boolean threeOfAKind(Hand hand) {
        ArrayList<Card> components = createHandComponents(hand, river);
        int valueCount = 0;
        int threeNum = 0;
        for (int i = 0; i < components.size(); i++) {
            for (int j = 0; j < components.size(); j++) {
                if (i == j)
                    continue;
                if (components.get(i).getNum() == components.get(j).getNum()) {
                    threeNum = components.get(i).getNum();
                    valueCount += 2;
                    components.remove(i);
                    components.remove(j);
                    break;
                }
            }
            if (components.get(i).getNum() == threeNum)
                valueCount += 1;
        }
        if (valueCount >= 3)
            return true;
        return false;
    }

    /**
     * Method to return whether or not a given hand is a two pair
     * @param hand
     * @return if hand is a two pair
     */
    public boolean twoPair(Hand hand) {
        ArrayList<Card> components = createHandComponents(hand, river);
        int valueCount = 0;
        for (int i = 0; i < components.size(); i++) {
            for (int j = 0; j < components.size(); j++) {
                if (components.get(i).getNum() == components.get(j).getNum())
                    valueCount += 2;
                components.remove(i);
                components.remove(j);
            }
        }
        if (valueCount >= 4)
            return true;
        return false;
    }

    /**
     * Method to return whether or not a given hand is a pair
     * @param hand
     * @return if hand is a pair
     */
    public boolean pair(Hand hand) {
        ArrayList<Card> components = createHandComponents(hand, river);
        for (int i = 0; i < components.size(); i++) {
            for (int j = 0; j < components.size(); j++) {
                if (i == j)
                    continue;
                if (components.get(i).getNum() == components.get(j).getNum())
                    return true;
            }
        }
        return false;
    }

    /**
     * Method to return which hand has the high card
     * @param handList
     * @return hand with the high card
     */
    public Hand highCard(ArrayList<Hand> handList) {
        //NEEDS IMPLEMENTATION FOR A TIE
        List<Integer> valueList = new ArrayList<>();
        for (int hand = 0; hand < handList.size(); hand++) {
            for (int card = 0; card < handList.get(hand).getUserCards().size(); card++) {
                valueList.add(handList.get(hand).getUserCards().get(card).getNum());
            }
        }
        Collections.sort(valueList);
        for (int hand = 0; hand < handList.size(); hand++) {
            for (int card = 0; card < handList.get(hand).getUserCards().size(); card++) {
                if (handList.get(hand).getUserCards().get(card).getNum() == valueList.get(valueList.size() - 1))
                    return handList.get(hand);
            }
        }
        return null;
    }

    /**
     * main method for the analyse hands method
     * @param args
     */
    public static void main(String[] args) { }

}
