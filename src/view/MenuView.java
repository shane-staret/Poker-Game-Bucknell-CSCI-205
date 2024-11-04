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
 * Package: view
 * Class: MenuView
 *
 * Description:
 * The class that will contain the actual code that allows the GUI of the menu to properly work
 * ****************************************
 */
package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.PokerMain;

/** The class that will contain the actual code that allows the GUI of the menu to properly work
 *
 * @author sfs015
 */
public class MenuView {

    /** The scene that the menu GUI will exist in */
    private Scene menuScene;

    /** The root window layout of the menu GUI */
    private VBox menuRoot;

    /** The HBox that holds the buttons used to play and exit the game */
    private HBox menuButtonsHbox;

    /** The text that will hold the description header */
    private Text descriptionHeaderText;

    /** The text that holds the description of the poker game */
    private Text descriptionText;

    /** Button for playing the game */
    private Button playButton;

    /** Button for going to the settings area for the game */
    private Button settingsButton;

    /** Button for exiting the menu */
    private Button exitButton;

    /** The Stage that the player will put their name into */
    private Stage namePopUp;

    /** The layout for the name popup */
    private VBox nameRoot;

    /** The layout for the buttons on the name popup */
    private HBox nameButtonsHbox;

    /** The Text that describes the popup */
    private Text nameText;

    /** The TextField the user will enter their name into */
    private TextField nameTextField;

    /** Ok button */
    private Button okButton;

    /** Cancel button */
    private Button cancelButton;

    /** The Scene that the user will enter their name into */
    private Scene nameScene;

    /** Default constructor that calls methods to properly setup the menu GUI */
    public MenuView() {
        setUpLayout();

        setUpItems();

        setUpPopUps();

        setUpFunctionality();
    }

    public Stage getNamePopUp() {
        return namePopUp;
    }

    public TextField getNameTextField() {
        return nameTextField;
    }

    public Button getOkButton() {
        return okButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public Scene getMenuScene() {
        return menuScene;
    }

    public void setMenuScene(Scene menuScene) {
        this.menuScene = menuScene;
    }

    /** A method that retrieves the main window layout of the menu GUI */
    public VBox getMenuRoot() {
        return menuRoot;
    }

    public Button getPlayButton() {
        return playButton;
    }

    public Button getSettingsButton() {
        return settingsButton;
    }

    public Button getExitButton() {
        return exitButton;
    }

    /**
     * A method that creates the menu Scene in the GUI
     *
     * @param primaryStage - the Stage that the GUI functions on
     */
    public void createMenuSceneGraph(Stage primaryStage) {
        primaryStage.setTitle("Texas Hold 'Em Poker Menu");

        if(getMenuScene() == null)
            setMenuScene(new Scene(getMenuRoot()));

        primaryStage.setScene(getMenuScene());
        primaryStage.sizeToScene();
        primaryStage.show();
        PokerMain.centerWindowOnScreen();
    }

    /** A method that properly displays a popup box allowing a user to make their name */
    public void displayNamePopUp() {
        namePopUp = new Stage();
        getNamePopUp().initModality(Modality.APPLICATION_MODAL);

        getNamePopUp().setTitle("Name Window");

        nameRoot.getChildren().removeAll(nameText, nameTextField, nameButtonsHbox);

        nameText = new Text("Enter your name (up to " + ViewUtility.MAX_NAME_LENGTH + " chars).");

        nameRoot.getChildren().addAll(nameText, nameTextField, nameButtonsHbox);

        namePopUp.setScene(nameScene);
        namePopUp.show();
    }

    /** A method that sets up the objects that compose the layout of the menu GUI */
    private void setUpLayout() {
        menuRoot = new VBox(ViewUtility.NORMAL_VBOX_SPACING);
        getMenuRoot().setAlignment(Pos.CENTER);
        getMenuRoot().setPadding(new Insets(ViewUtility.PADDING));
        getMenuRoot().setPrefWidth(ViewUtility.MENU_AND_SETTINGS_ROOT_WIDTH);
        getMenuRoot().setPrefHeight(ViewUtility.MENU_AND_SETTINGS_ROOT_HEIGHT);

        menuButtonsHbox = new HBox(ViewUtility.NORMAL_HBOX_SPACING);
        menuButtonsHbox.setAlignment(Pos.CENTER);
    }

    /** A method that sets up the items that compose the menu GUI */
    private void setUpItems() {
        descriptionHeaderText = new Text("Game Description");
        descriptionHeaderText.setTextAlignment(TextAlignment.CENTER);
        descriptionHeaderText.setFont(Font.font(ViewUtility.TEXT_FONT_FAMILY, ViewUtility.HEADER_TEXT_FONT_WEIGHT, ViewUtility.HEADER_TEXT_FONT_SIZE));

        descriptionText = new Text("The CSCI 205 final project for John Colbert, Michael Heller, Sami Dunn, and Shane Staret.\nTeam Name: King's Disciples (yeah yeah roll your eyes all you want)\n\nThis is a Java program that simulates a Texas Hold 'Em game of poker using a JavaFX UI.\nThe user (you!) is up against three mediocre CPU players. Good luck!\n\nSelect \"Play\" to play a game of Texas Hold 'Em Poker.\nSelect \"Settings\" to change the game's settings.\nSelect \"Exit\" to exit Texas Hold 'Em Poker.");
        descriptionText.setTextAlignment(TextAlignment.CENTER);
        descriptionText.setFont(Font.font(ViewUtility.TEXT_FONT_FAMILY, ViewUtility.REGULAR_TEXT_FONT_WEIGHT, ViewUtility.REGULAR_TEXT_FONT_SIZE));

        playButton = new Button("Play");
        getPlayButton().setPrefWidth(ViewUtility.BUTTON_WIDTH);

        settingsButton = new Button("Settings");
        getSettingsButton().setPrefWidth(ViewUtility.BUTTON_WIDTH);

        exitButton = new Button("Exit");
        getExitButton().setPrefWidth(ViewUtility.BUTTON_WIDTH);
    }

    /** A method that properly sets up the layout and items that will go in the popup window */
    private void setUpPopUps() {

        nameRoot = new VBox(ViewUtility.NORMAL_VBOX_SPACING);
        nameRoot.setAlignment(Pos.CENTER);
        nameRoot.setPadding(new Insets(ViewUtility.PADDING));

        nameButtonsHbox = new HBox(ViewUtility.NORMAL_HBOX_SPACING);
        nameButtonsHbox.setAlignment(Pos.CENTER);
        nameButtonsHbox.setPadding(new Insets(ViewUtility.PADDING));

        nameText = new Text();

        nameTextField = new TextField();
        getNameTextField().setMaxWidth(ViewUtility.TEXT_FIELD_WIDTH);

        okButton = new Button("OK");
        getOkButton().setMinWidth(ViewUtility.BUTTON_WIDTH);
        getOkButton().setAlignment(Pos.TOP_CENTER);

        cancelButton = new Button("Cancel");
        getCancelButton().setMinWidth(ViewUtility.BUTTON_WIDTH);
        getCancelButton().setAlignment(Pos.TOP_CENTER);

        nameButtonsHbox.getChildren().addAll(okButton, cancelButton);
        nameButtonsHbox.setAlignment(Pos.CENTER);

        nameRoot.getChildren().addAll(nameText, nameTextField, nameButtonsHbox);
        nameRoot.setAlignment(Pos.CENTER);

        nameScene = new Scene(nameRoot, ViewUtility.POP_UP_WIDTH, ViewUtility.POP_UP_HEIGHT);
    }


    /** A method that relates the layout objects to the items to make a functional menu GUI */
    private void setUpFunctionality() {
        menuButtonsHbox.getChildren().addAll(getPlayButton(), getSettingsButton(), getExitButton());
        getMenuRoot().getChildren().addAll(descriptionHeaderText, descriptionText, menuButtonsHbox);
    }

}