package game;

/**
 * A class that represents the chips that a particular player of the game possesses
 *
 * @author sd043
 */
public class PlayerChips {

    /** Private variable to hold how much is in the player's pot */
    private int playerAmount;

    /** Constructor to create the Player's pot */
    public PlayerChips(int playerAmount) {
        this.playerAmount = playerAmount;
    }

    public int getPlayerAmount() {
        return playerAmount;
    }

    public void setPlayerAmount(int playerAmount) {
        this.playerAmount = playerAmount;
    }

    /**
     * Method used to add money to the player's total amount
     * @param chipAmt - amount of money being added
     */
    public void addChips(int chipAmt) {
        playerAmount += chipAmt;
    }

    /** Method for to set the player's pot to 0 and cash them out of the game */
    public void cashOut() {
        System.out.println("Thanks for playing! You are leaving with $" + playerAmount);
        playerAmount = 0;
    }

    /**
     * Removes money from player's total amount like if they are betting
     * @param chipAmt - amount of money being taken away from player's total
     */
    public void removeChips(int chipAmt) {
        playerAmount -= chipAmt;
    }
}
