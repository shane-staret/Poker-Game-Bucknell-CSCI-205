/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Michael Heller
 * Section: 11 am
 * Date: 11/17/19
 *
 * Project: csci205_Kings_Disciples
 * Package: main
 * Class: Card
 *
 * Description: Card class to create card objects
 *
 * ****************************************
 */

package game;

/**
 * Card class to create Card objects for the game
 * @author Michael Heller
 * @version 0.1
 */
public class Card {

    /** provides a number for the card object.  Jack = 11, etc. **/
    private int num;

    /** provides a suit for the card object **/
    private String suit;

    /** provides color to the card object **/
    private String color;

    /**
     * constructor for the Card class
     */
    public Card(int num, String suit, String color) {

        this.color = color;
        this.num = num;
        this.suit = suit;

    }

    /**
     * getter method for the number on the card
     * @return
     */
    public int getNum() {
        return num;
    }

    /**
     * setter method for the number on the card
     * @param num
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * getter method for the suit on the card
     * @return
     */
    public String getSuit() {
        return suit;
    }

    /**
     * setter method for the suit on the card
     * @param suit
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }

    /**
     * getter method for the color on the card
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * setter method for the color on the card
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * main method for the card class
     * @param args
     */
    public static void main(String[] args) {
    }
}
