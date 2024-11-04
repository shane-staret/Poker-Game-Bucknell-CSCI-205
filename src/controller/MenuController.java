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
 * Class: MenuController
 *
 * Description:
 * The class that will contain the actual code that allows the GUI of the menu to interact with the data so that
 * the logic of the menu GUI may work properly
 * ****************************************
 */
package controller;

import game.Dealer;
import game.GamePot;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import main.PokerMain;
import view.GameView;
import view.ViewUtility;

/**
 * The class that will contain the actual code that allows the GUI of the menu to interact with the data so that
 * the logic of the menu GUI may work properly
 *
 * @author sfs015
 */
public class MenuController {

    /**
     * Constructor that properly sets up the view of the game
     */
    public MenuController() {
        setUpHandlers();
    }

    /** A method that sets up the event handlers associated with the menu */
    private void setUpHandlers() {
        PokerMain.getMenuView().getPlayButton().setOnMouseClicked(event -> {
            PokerMain.getMenuView().displayNamePopUp();
        });

        PokerMain.getMenuView().getOkButton().setOnMouseClicked(event -> {
            if(PokerMain.getMenuView().getNameTextField().getText().length() > 0 && PokerMain.getMenuView().getNameTextField().getText().length() <= ViewUtility.MAX_NAME_LENGTH) {
                PokerMain.setGamePot(new GamePot());
                PokerMain.setDealer(new Dealer());
                PokerMain.setGameView(new GameView());
                PokerMain.setGameController(new GameController());
                PokerMain.getGameView().createGameSceneGraph(PokerMain.getPrimaryStage());
                PokerMain.getMenuView().getNamePopUp().close();
            }

            else {
                // create alert to notify user that they must enter a nickname of the right length
                Alert alert = new Alert(Alert.AlertType.ERROR, "You must enter a name that is not empty and with a maximum length of " + ViewUtility.MAX_NAME_LENGTH + " characters.", ButtonType.OK);
                alert.setTitle("Invalid Input!");
                alert.setHeaderText("Invalid input!");
                alert.showAndWait();
            }
        });

        PokerMain.getMenuView().getCancelButton().setOnMouseClicked(event -> {
            PokerMain.getMenuView().getNamePopUp().close();
        });

        PokerMain.getMenuView().getSettingsButton().setOnMouseClicked(event -> {
            PokerMain.getSettingsView().createSettingsSceneGraph(PokerMain.getPrimaryStage());
        });

        PokerMain.getMenuView().getExitButton().setOnMouseClicked(event -> {
            Platform.exit();
            System.exit(0);
        });
    }

}