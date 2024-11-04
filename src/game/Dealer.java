package game;

import main.PokerMain;

/**
 * A class that represents the dealer that manages the money and the cards for a poker game
 *
 * @author sd043
 */
public class Dealer {

    /** Method takes the money away from the Player's chips that they want to bet
     * and adds it to the GamePot
     * @param player - the player that is placing the bet
     * @param betMoney - the amount of money the player is betting/checking/raising with
     */
    public void addBetToGamePot(PlayerChips player, int betMoney) {
        player.removeChips(betMoney);
        PokerMain.getGamePot().addPlayerBets(betMoney);
    }

    /**
     * Method that adds the pot total to the winning player and resets the pot back to 0 for the next hand
     * @param player - winning player of the hand
     */
    public void giveWinnerMoney(PlayerChips player) {
        int winningAmt = PokerMain.getGamePot().getGameAmount();
        player.addChips(winningAmt);
        PokerMain.getGamePot().resetPot();
    }

    /**
     * Splits the winning pot amount between the two players whose hands were tied at the end of the round
     * @param player1 - the first player with a winning hand
     * @param player2 - the second player with a winning hand
     * @param gamePot - pot of the game being currently played that needs split between 2 players
     */
    public void splitPot(PlayerChips player1, PlayerChips player2, GamePot gamePot) {
        int amtToSplit = gamePot.getGameAmount();
        int splitAmt = amtToSplit / 2;
        player1.addChips(splitAmt);
        player2.addChips(splitAmt);
        gamePot.resetPot();
    }
}
