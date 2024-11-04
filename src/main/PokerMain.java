/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Shane Staret
 * Section: 01
 * Date: 11/6/19
 * Time: 11 - 11:52
 *
 * Project: csci205_Kings_Disciples
 * Package: main
 * Class: PokerMain
 *
 * Description:
 * This is a main method that sets up and runs a standard Poker game.
 * ****************************************
 */
package main;


import controller.GameController;
import controller.MenuController;
import controller.SettingsController;
import game.Dealer;
import game.GamePot;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import view.GameView;
import view.MenuView;
import view.SettingsView;

/**
 * This is a main method that sets up and runs a standard Poker game.
 *
 * @author the squad
 */
public class PokerMain extends Application {

    /** The GUI of the menu */
    private static MenuView menuView;

    /** The GUI of the settings */
    private static SettingsView settingsView;

    /** The GUI of the poker game */
    private static GameView gameView;

    /** The Object that determines the logic between the data and the GUI of the menu */
    private static MenuController menuController;

    /** The Object that determines the logic between the data and the GUI of the menu */
    private static SettingsController settingsController;

    /** The Object that determines the logic between the data and the GUI of the poker game */
    private static GameController gameController;

    /** The Object that represents the pot of the game */
    private static GamePot gamePot;

    /** The Object that represents the dealer of the game */
    private static Dealer dealer;

    /** The stage that all scenes appear on */
    private static Stage primaryStage;

    public static MenuView getMenuView() {
        return menuView;
    }

    public static SettingsView getSettingsView() {
        return settingsView;
    }

    public static GameView getGameView() {
        return gameView;
    }

    public static MenuController getMenuController() {
        return menuController;
    }

    public static SettingsController getSettingsController() {
        return settingsController;
    }

    public static GameController getGameController() {
        return gameController;
    }

    public static GamePot getGamePot() {
        return gamePot;
    }

    public static Dealer getDealer() {
        return dealer;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setSettingsView(SettingsView settingsView) {
        PokerMain.settingsView = settingsView;
    }

    public static void setGameView(GameView gameView) {
        PokerMain.gameView = gameView;
    }

    public static void setSettingsController(SettingsController settingsController) {
        PokerMain.settingsController = settingsController;
    }

    public static void setGameController(GameController gameController) {
        PokerMain.gameController = gameController;
    }

    public static void setGamePot(GamePot gamePot) {
        PokerMain.gamePot = gamePot;
    }

    public static void setDealer(Dealer dealer) {
        PokerMain.dealer = dealer;
    }

    /** Properly ends the program when the user clicks the red X button
     *
     * @author sfs015
     */
    private void setUpRedButtonHandler() {
        getPrimaryStage().setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
    }

    /** Centers the window on the user's screen
     *
     * @author sfs015
     */
    public static void centerWindowOnScreen() {
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        getPrimaryStage().setX((primScreenBounds.getWidth() - getPrimaryStage().getWidth()) / 2);
        getPrimaryStage().setY((primScreenBounds.getHeight() - getPrimaryStage().getHeight()) / 2);
    }

    /**
     * The application initialization method. This method is called immediately
     * after the Application class is loaded and constructed. An application may
     * override this method to perform initialization prior to the actual starting
     * of the application.
     *
     * @throws Exception if something goes wrong
     * @author sfs015
     */
    @Override
    public void init() throws Exception {
        super.init();
        menuView = new MenuView();
        settingsView = new SettingsView();
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * @param primaryStage the primary stage for this application, onto which the application scene can be set. Applications may create other stages, if needed, but they will not be primary stages.
     * @author sfs015
     */
    @Override
    public void start(Stage primaryStage) {
        PokerMain.primaryStage = primaryStage;

        menuController = new MenuController();
        settingsController = new SettingsController();

        setUpRedButtonHandler();

        getMenuView().createMenuSceneGraph(getPrimaryStage());
    }

    /** The main method that drives the entirety of the application */
    public static void main(String[] args) {
        launch(args);
    }
}