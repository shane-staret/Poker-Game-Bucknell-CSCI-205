/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Shane Staret
 * Section: 01
 * Date: 11/14/19
 * Time: 11 - 11:52
 *
 * Project: csci205_Kings_Disciples
 * Package: controller
 * Class: GameController
 *
 * Description:
 * The class that will contain the actual code that allows the GUI of the menu to interact with the data so that
 * the logic of the game GUI may work properly
 * ****************************************
 */
package controller;

import game.PlayerChips;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import main.PokerMain;
import view.ViewUtility;

/**
 * The class that will contain the actual code that allows the GUI of the menu to interact with the data so that
 * the logic of the game GUI may work properly
 *
 * @author sfs015
 */
public class GameController {

    /** Array that stores the PlayerChips objects */
    private PlayerChips[] playerChipsArray = new PlayerChips[PokerMain.getSettingsController().getNumOfCpus() + 1];

    /**
     * Constructor that properly sets up the controller of the game
     */
    public GameController() {
        setUpPlayerPots();

        setUpHandlers();
    }

    public PlayerChips[] getPlayerChipsArray() {
        return playerChipsArray;
    }

    /** A method that properly sets up the individual player pots for the game */
    private void setUpPlayerPots() {
        for(int i = 0; i < PokerMain.getSettingsController().getNumOfCpus() + 1; i++)
            playerChipsArray[i] = new PlayerChips(PokerMain.getSettingsController().getStartingChipAmount());
    }

    /**
     * A method that checks if a String is a positive int
     * @see
     * <a href = "https://stackoverflow.com/questions/237159/whats-the-best-way-to-check-if-a-string-represents-an-integer-in-java"</a>
     *
     * @param amount - The amount specified by the user in the popup TextField
     * @return A boolean that determines whether the String given is a positive int
     */
    private boolean isPositiveInteger(String amount) {
        if (amount == null) {
            return false;
        }

        int length = amount.length();
        if (length == 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            char c = amount.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    /** A method that sets up the event handlers associated with the game */
    private void setUpHandlers() {
        PokerMain.getGameView().getBackToMenuButton().setOnMouseClicked(event -> {

            // create alert to notify user's that by going back to the menu, they reset the game
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "You will lose all progress in this game if you press \"OK\"!", ButtonType.OK, ButtonType.CANCEL);
            alert.setTitle("WARNING!");
            alert.setHeaderText("Are you sure you want to go back to the menu?");
            alert.showAndWait();

            if(alert.getResult() == ButtonType.OK)
                PokerMain.getMenuView().createMenuSceneGraph(PokerMain.getPrimaryStage());
        });

        PokerMain.getGameView().getBetButton().setOnMouseClicked(event -> {
            PokerMain.getGameView().displayAmountPopUp("Bet");
            //TODO - implement game logic to handle a bet
        });

        PokerMain.getGameView().getRaiseButton().setOnMouseClicked(event -> {
            PokerMain.getGameView().displayAmountPopUp("Raise");
            //TODO - implement game logic to handle a raise
        });

        PokerMain.getGameView().getCallButton().setOnMouseClicked(event -> {
            //TODO - implement game logic to handle a call
        });

        PokerMain.getGameView().getCheckButton().setOnMouseClicked(event -> {
            //TODO - implement game logic to handle a check
        });

        PokerMain.getGameView().getFoldButton().setOnMouseClicked(event -> {
            // create alert to notify user's that by going back to the menu, they reset the game
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "You will lose the hand if you continue!", ButtonType.OK, ButtonType.CANCEL);
            alert.setTitle("WARNING!");
            alert.setHeaderText("Are you sure you want to fold?");
            alert.showAndWait();
            //TODO - implement game logic to handle a fold
        });

        PokerMain.getGameView().getCancelButton().setOnMouseClicked(event -> {
            PokerMain.getGameView().getAmountPopUp().close();
        });

        PokerMain.getGameView().getActionButton().setOnMouseClicked(event -> {
            if(!isPositiveInteger(PokerMain.getGameView().getAmountTextField().getText())) {

                // create alert to notify user that they must enter a positive int
                Alert alert = new Alert(Alert.AlertType.ERROR, "You must enter a positive integer.", ButtonType.OK);
                alert.setTitle("Invalid Input!");
                alert.setHeaderText("Invalid input!");
                alert.showAndWait();
            }

            else if(Integer.parseInt(PokerMain.getGameView().getAmountTextField().getText()) > getPlayerChipsArray()[0].getPlayerAmount()) {
                // create alert to notify user that they must enter a positive int
                Alert alert = new Alert(Alert.AlertType.ERROR, "You must enter a chip amount that is not greater than your current number of chips.", ButtonType.OK);
                alert.setTitle("Too Many Chips!");
                alert.setHeaderText("Too many chips!");
                alert.showAndWait();
            }

            else {
                PokerMain.getDealer().addBetToGamePot(getPlayerChipsArray()[0], Integer.parseInt(PokerMain.getGameView().getAmountTextField().getText()));

                PokerMain.getGameView().getPlayerVbox().getChildren().removeAll(PokerMain.getGameView().getPlayerChipText(), PokerMain.getGameView().getPlayerStackPane(), PokerMain.getGameView().getPlayerText());

                PokerMain.getGameView().setPlayerChipText(new Text("Chips: " + getPlayerChipsArray()[0].getPlayerAmount()));
                PokerMain.getGameView().setPotText(new Text("Pot Amount: " + PokerMain.getGamePot().getGameAmount()));

                PokerMain.getGameView().getPokerTableStackPane().getChildren().removeAll(PokerMain.getGameView().getPokerTable(), PokerMain.getGameView().getCardVbox());

                VBox cardVbox = new VBox(ViewUtility.NORMAL_VBOX_SPACING);
                cardVbox.setAlignment(Pos.CENTER);
                cardVbox.setPadding(new Insets(ViewUtility.PADDING));

                PokerMain.getGameView().setCardVbox(cardVbox);
                PokerMain.getGameView().getCardVbox().getChildren().addAll(PokerMain.getGameView().getPlayerAndCpuCardsHbox(), PokerMain.getGameView().getDealerCardsHbox(), PokerMain.getGameView().getPotText());
                PokerMain.getGameView().getPokerTableStackPane().getChildren().addAll(PokerMain.getGameView().getPokerTable(), PokerMain.getGameView().getCardVbox());

                PokerMain.getGameView().getPlayerVbox().getChildren().addAll(PokerMain.getGameView().getPlayerChipText(), PokerMain.getGameView().getPlayerStackPane(), PokerMain.getGameView().getPlayerText());

                PokerMain.getGameView().getAmountPopUp().close();
            }
        });
    }

}