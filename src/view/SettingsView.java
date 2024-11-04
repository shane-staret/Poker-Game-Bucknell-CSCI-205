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
 * Class: SettingsView
 *
 * Description:
 * The class that will contain the actual code that allows the GUI of the settings to properly work
 * ****************************************
 */
package view;

import game.PlayerEnum;
import game.PokerTableEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.PokerMain;

import java.util.ArrayList;

/** The class that will contain the actual code that allows the GUI of the settings to properly work
 *
 * @author sfs015
 */
public class SettingsView {
    /** The scene that the settings GUI will exist in */
    private Scene settingsScene;

    /** The root window layout of the settings GUI */
    private VBox settingsRoot;

    /** The layout that the dropdown boxes will be in */
    private GridPane dropdownGridpane;

    /** The text that will hold the settings header */
    private Text settingsHeaderText;

    /** The text that goes above the type of player dropdown menu */
    private Text numOfCpusText;

    /** The text that goes above the color of poker table dropdown menu */
    private Text colorOfPokerTableText;

    /** The text that goes above the color of player dropdown menu */
    private Text colorOfPlayerText;

    /** The text that goes above the starting chip amount dropdown menu */
    private Text startingChipAmountText;

    /** The text that goes above the show chips dropdown menu */
    private Text showCpuChipAmountText;

    /** The text that goes above the show CPU hand dropdown menu */
    private Text showCpuHandText;

    /**
     * ArrayList that gets all options for the dropdown menu when a user is selecting the color of the poker table,
     * will copy this list into an observable list so it may appear on the GUI
     */
    private ArrayList<String> colorOfPokerTableOptions = new ArrayList<>();

    /**
     * ArrayList that gets all options for the dropdown menu when a user is selecting the color of the player,
     * will copy this list into an observable list so it may appear on the GUI
     */
    private ArrayList<String> colorOfPlayerOptions = new ArrayList<>();

    /** List that holds all the options for the dropdown menu when a user is selecting the number of CPUs to play against */
    private final ObservableList<String> NUM_OF_CPUS_OPTIONS = FXCollections.observableArrayList("1", "2", "3", "4");

    /** List that holds all the options for the dropdown menu when a user is selecting the color of the poker table */
    private ObservableList<String> COLOR_OF_POKER_TABLE_OPTIONS;

    /** List that holds all the options for the dropdown menu when a user is selecting the color of the player */
    private ObservableList<String> COLOR_OF_PLAYER_OPTIONS;

    /** List that holds all the options for the dropdown menu when a user is selecting the starting amount of chips */
    private final ObservableList<String> STARTING_CHIP_AMOUNT_OPTIONS = FXCollections.observableArrayList("100", "200", "300", "400", "500", "600", "700", "800", "900", "1000");

    /** List that holds all the options for the dropdown menu when a user is selecting to show all chip amounts */
    private final ObservableList<String> SHOW_CPU_CHIP_AMOUNT_OPTIONS = FXCollections.observableArrayList("Yes", "No");

    /** List that holds all the options for the dropdown menu when a user is selecting to show CPU hands after the hand is over */
    private final ObservableList<String> SHOW_CPU_HAND_OPTIONS = FXCollections.observableArrayList("Yes", "No");

    /** Dropdown menu that holds the options for the number of CPUs to play against */
    private final ChoiceBox numOfCpusDropdown = new ChoiceBox(NUM_OF_CPUS_OPTIONS);

    /** Dropdown menu that holds the options for the color of the poker table */
    private ChoiceBox colorOfPokerTableDropdown;

    /** Dropdown menu that holds the options for the color of the player */
    private ChoiceBox colorOfPlayerDropdown;

    /** Dropdown menu that holds the options for the starting chip amount */
    private final ChoiceBox startingChipAmountDropdown = new ChoiceBox(STARTING_CHIP_AMOUNT_OPTIONS);

    /** Dropdown menu that holds the options for showing all chip amounts */
    private final ChoiceBox showCpuChipAmountDropdown = new ChoiceBox(SHOW_CPU_CHIP_AMOUNT_OPTIONS);

    /** Dropdown menu that holds the options for showing CPU hands after the hand is over */
    private final ChoiceBox showCpuHandDropdown = new ChoiceBox(SHOW_CPU_HAND_OPTIONS);

    /** Button that confirms the user's settings */
    private Button saveButton;

    /** Default constructor that calls methods to properly setup the settings GUI */
    public SettingsView() {
        setUpLayout();

        setUpColorDropdowns();

        setUpItems();

        setUpFunctionality();
    }

    public ArrayList<String> getColorOfPokerTableOptions() {
        return colorOfPokerTableOptions;
    }

    public Scene getSettingsScene() {
        return settingsScene;
    }

    public void setSettingsScene(Scene settingsScene) {
        this.settingsScene = settingsScene;
    }

    /** A method that retrieves the main window layout of the settings GUI */
    public VBox getSettingsRoot() {
        return settingsRoot;
    }

    public ChoiceBox getNumOfCpusDropdown() {
        return numOfCpusDropdown;
    }

    public ChoiceBox getColorOfPokerTableDropdown() {
        return colorOfPokerTableDropdown;
    }

    public ChoiceBox getColorOfPlayerDropdown() {
        return colorOfPlayerDropdown;
    }

    public ChoiceBox getStartingChipAmountDropdown() {
        return startingChipAmountDropdown;
    }

    public ChoiceBox getShowCpuChipAmountDropdown() {
        return showCpuChipAmountDropdown;
    }

    public ChoiceBox getShowCpuHandDropdown() {
        return showCpuHandDropdown;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    /**
     * A method that creates the settings Scene in the GUI
     *
     * @param primaryStage - the Stage that the GUI functions on
     */
    public void createSettingsSceneGraph(Stage primaryStage) {
        primaryStage.setTitle("Texas Hold 'Em Poker Settings");

        if(getSettingsScene() == null)
            setSettingsScene(new Scene(getSettingsRoot()));

        primaryStage.setScene(getSettingsScene());
        primaryStage.sizeToScene();
        primaryStage.show();
        PokerMain.centerWindowOnScreen();
    }

    /** A method that properly sets up the dropdown menus where a color must be decided */
    private void setUpColorDropdowns() {

        // add all the possible colors to the poker table color ArrayList
        for(int i = 0; i < PokerTableEnum.values().length; i++)
            colorOfPokerTableOptions.add(PokerTableEnum.values()[i].getStringColor());

        // copy poker table color ArrayList contents into observable list so it may appear on the GUI
        COLOR_OF_POKER_TABLE_OPTIONS = FXCollections.observableArrayList(colorOfPokerTableOptions);

        // set up the poker table color dropdown menu with the right color options
        colorOfPokerTableDropdown = new ChoiceBox(COLOR_OF_POKER_TABLE_OPTIONS);

        // add all the possible colors to the player color ArrayList
        for(int i = 0; i < PlayerEnum.values().length; i++)
            colorOfPlayerOptions.add(PlayerEnum.values()[i].getStringColor());

        // copy poker table color ArrayList contents into observable list so it may appear on the GUI
        COLOR_OF_PLAYER_OPTIONS = FXCollections.observableArrayList(colorOfPlayerOptions);

        // set up the poker table color dropdown menu with the right color options
        colorOfPlayerDropdown = new ChoiceBox(COLOR_OF_PLAYER_OPTIONS);
    }

    /** A method that sets up the objects that compose the layout of the settings GUI */
    public void setUpLayout() {
        settingsRoot = new VBox(ViewUtility.NORMAL_VBOX_SPACING);
        getSettingsRoot().setAlignment(Pos.CENTER);
        getSettingsRoot().setPadding(new Insets(ViewUtility.PADDING));
        getSettingsRoot().setPrefWidth(ViewUtility.MENU_AND_SETTINGS_ROOT_WIDTH);
        getSettingsRoot().setPrefHeight(ViewUtility.MENU_AND_SETTINGS_ROOT_HEIGHT);

        dropdownGridpane = new GridPane();
        dropdownGridpane.setHgap(ViewUtility.GRIDPANE_HGAP);
        dropdownGridpane.setVgap(ViewUtility.GRIDPANE_VGAP);
        dropdownGridpane.setAlignment(Pos.CENTER);
    }

    /** A method that sets up the items that compose the settings GUI */
    public void setUpItems() {
        settingsHeaderText = new Text("Settings");
        settingsHeaderText.setFont(Font.font(ViewUtility.TEXT_FONT_FAMILY, ViewUtility.HEADER_TEXT_FONT_WEIGHT, ViewUtility.HEADER_TEXT_FONT_SIZE));

        numOfCpusText = new Text("Number of CPU opponents:");

        colorOfPokerTableText = new Text("Color of poker table:");

        colorOfPlayerText = new Text("Color of player:");

        startingChipAmountText = new Text("Starting chip amount:");

        showCpuChipAmountText = new Text("Show opponent chips?:");

        showCpuHandText = new Text("Show opponent hand after?:");

        getNumOfCpusDropdown().setPrefWidth(ViewUtility.DROPDOWN_WIDTH);
        getNumOfCpusDropdown().setValue(NUM_OF_CPUS_OPTIONS.get(ViewUtility.NUM_OF_CPUS_DEFAULT_CHOICE));
        getNumOfCpusDropdown().setPrefHeight(ViewUtility.DROPDOWN_HEIGHT);
        getNumOfCpusDropdown().setPrefWidth(ViewUtility.DROPDOWN_WIDTH);

        getColorOfPokerTableDropdown().setPrefWidth(ViewUtility.DROPDOWN_WIDTH);
        getColorOfPokerTableDropdown().setValue(COLOR_OF_POKER_TABLE_OPTIONS.get(ViewUtility.COLOR_OF_POKER_TABLE_DEFAULT_CHOICE));
        getColorOfPokerTableDropdown().setPrefHeight(ViewUtility.DROPDOWN_HEIGHT);
        getColorOfPokerTableDropdown().setPrefWidth(ViewUtility.DROPDOWN_WIDTH);

        getColorOfPlayerDropdown().setPrefWidth(ViewUtility.DROPDOWN_WIDTH);
        getColorOfPlayerDropdown().setValue(COLOR_OF_PLAYER_OPTIONS.get(ViewUtility.COLOR_OF_PLAYER_DEFAULT_CHOICE));
        getColorOfPlayerDropdown().setPrefHeight(ViewUtility.DROPDOWN_HEIGHT);
        getColorOfPlayerDropdown().setPrefWidth(ViewUtility.DROPDOWN_WIDTH);

        getStartingChipAmountDropdown().setPrefWidth(ViewUtility.DROPDOWN_WIDTH);
        getStartingChipAmountDropdown().setValue(STARTING_CHIP_AMOUNT_OPTIONS.get(ViewUtility.STARTING_CHIP_AMOUNT_DEFAULT_CHOICE));
        getStartingChipAmountDropdown().setPrefHeight(ViewUtility.DROPDOWN_HEIGHT);
        getStartingChipAmountDropdown().setPrefWidth(ViewUtility.DROPDOWN_WIDTH);

        getShowCpuChipAmountDropdown().setPrefWidth(ViewUtility.DROPDOWN_WIDTH);
        getShowCpuChipAmountDropdown().setValue(SHOW_CPU_CHIP_AMOUNT_OPTIONS.get(ViewUtility.SHOW_CPU_CHIP_AMOUNT_DEFAULT_CHOICE));
        getShowCpuChipAmountDropdown().setPrefHeight(ViewUtility.DROPDOWN_HEIGHT);
        getShowCpuChipAmountDropdown().setPrefWidth(ViewUtility.DROPDOWN_WIDTH);

        getShowCpuHandDropdown().setPrefWidth(ViewUtility.DROPDOWN_WIDTH);
        getShowCpuHandDropdown().setValue(SHOW_CPU_HAND_OPTIONS.get(ViewUtility.SHOW_CPU_HAND_DEFAULT_CHOICE));
        getShowCpuHandDropdown().setPrefHeight(ViewUtility.DROPDOWN_HEIGHT);
        getShowCpuHandDropdown().setPrefWidth(ViewUtility.DROPDOWN_WIDTH);

        saveButton = new Button("Save");
        getSaveButton().setAlignment(Pos.CENTER);
        getSaveButton().setPrefWidth(ViewUtility.BUTTON_WIDTH);
    }

    /** A method that relates the layout objects to the items to make a functional settings GUI */
    public void setUpFunctionality() {
        GridPane.setConstraints(numOfCpusText, 0, 0);
        GridPane.setConstraints(numOfCpusDropdown, 0, 1);
        GridPane.setConstraints(colorOfPokerTableText, 1, 0);
        GridPane.setConstraints(colorOfPokerTableDropdown, 1, 1);
        GridPane.setConstraints(colorOfPlayerText, 2, 0);
        GridPane.setConstraints(colorOfPlayerDropdown, 2, 1);
        GridPane.setConstraints(startingChipAmountText, 0, 2);
        GridPane.setConstraints(startingChipAmountDropdown, 0, 3);
        GridPane.setConstraints(showCpuChipAmountText, 1, 2);
        GridPane.setConstraints(showCpuChipAmountDropdown, 1, 3);
        GridPane.setConstraints(showCpuHandText, 2, 2);
        GridPane.setConstraints(showCpuHandDropdown, 2, 3);

        dropdownGridpane.getChildren().addAll(numOfCpusText, numOfCpusDropdown, colorOfPokerTableText, colorOfPokerTableDropdown, colorOfPlayerText, colorOfPlayerDropdown, startingChipAmountText, startingChipAmountDropdown, showCpuChipAmountText, showCpuChipAmountDropdown, showCpuHandText, showCpuHandDropdown);

        getSettingsRoot().getChildren().addAll(settingsHeaderText, dropdownGridpane, saveButton);
    }
}