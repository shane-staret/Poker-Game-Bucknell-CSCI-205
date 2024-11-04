package game;

/**
 * A class that represents the chips that the pot contains for the current hand
 *
 * @author sd043
 */
public class GamePot {
    /** Integer value to hold how much is currently in the game pot */
    private int gameAmount;

    public GamePot() {
        this.gameAmount = 0;
    }

    public int getGameAmount() {
        return gameAmount;
    }

    public void setGameAmount(int gameAmount) {
        this.gameAmount = gameAmount;
    }

    /** Add money to the pot based on how much the player is betting */
    public void addPlayerBets(int bet) {
        gameAmount += bet;
    }

    /** Gives the pot to the winner of the hand and resets the amount to 0 */
    public int resetPot() {
        System.out.println("Congratulations! You have won this hand. You received $" + gameAmount);
        return gameAmount;
    }
}
