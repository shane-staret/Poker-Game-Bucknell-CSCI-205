/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Michael Heller
 * Section: 11 am
 * Date: 12/5/19
 *
 * Project: proj_backup
 * Package: game
 * Class: Player
 *
 * Description:  Player abstract class to define the basic functions for a
 * user or CPU player
 *
 * ****************************************
 */

package game;

/**
 * Abstract player class to define any player in the poker game
 * @author Michael Heller
 * @version 0.1
 */
public abstract class Player {

    /** initializes a playerChips object to keep track of the player's amount **/
    private PlayerChips playerChips;

    /** new hand for the round **/
    private Hand roundHand;

    /** takes in the game pot for the round **/
    private GamePot pot;

    /** boolean that allows the player to check **/
    private boolean check;

    /**
     * Constructor for the Player class
     * @param playerChips
     * @param roundHand
     */
    public Player(PlayerChips playerChips, Hand roundHand, GamePot pot) {
        this.playerChips = playerChips;
        this.roundHand = roundHand;
        this.pot = pot;
        this.check = false;
    }

    /**
     * getter method for the PlayerChips object
     * @return playerChips
     */
    public PlayerChips getPlayerChips() {
        return playerChips;
    }

    /**
     * setter method for the PlayerChips object
     * @param playerChips
     */
    public void setPlayerChips(PlayerChips playerChips) {
        this.playerChips = playerChips;
    }

    /**
     * getter method for the players hand for the round
     * @return roundHand
     */
    public Hand getRoundHand() {
        return roundHand;
    }

    /**
     * setter method for the player's hand for the round
     * @param roundHand
     */
    public void setRoundHand(Hand roundHand) {
        this.roundHand = roundHand;
    }

    /**
     * getter method for the round's GamePot object
     * @return pot
     */
    public GamePot getPot() {
        return pot;
    }

    /**
     * setter method for the round's GamePot object
     * @param pot
     */
    public void setPot(GamePot pot) {
        this.pot = pot;
    }

    /**
     * checks the boolean 'check'
     * @return check
     */
    public boolean isCheck() {
        return check;
    }

    /**
     * can set check to true or false
     * @param check
     */
    public void setCheck(boolean check) {
        this.check = check;
    }

    /**
     * makes a raise to the pot from the player
     * @param raiseAmount
     */
    public void makeRaise(int raiseAmount) {
        playerChips.removeChips(raiseAmount);
        pot.addPlayerBets(raiseAmount);
    }

    /**
     * calls the other bets from the table
     * @param betAmount
     */
    public void callBet(int betAmount) {
        playerChips.removeChips(betAmount);
        pot.addPlayerBets(betAmount);
    }

    /**
     * increases the amount that the player has won
     */
    public void increaseWinnings() {
        playerChips.addChips(pot.getGameAmount());
        pot.resetPot();
    }

    /**
     * allows the player to fold thus giving up on the round
     */
    public void fold() {
        roundHand = null;
    }

    /**
     * if called, the player is ready to check
     */
    public void playerCheck() {
        check = true;
    }

    /**
     * main class for the player class
     * @param args
     */
    public static void main(String[] args) {

    }
}
