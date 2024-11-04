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
 * Class: GameView
 *
 * Description:
 * The class that will contain the actual code that allows the GUI of the poker game to properly work
 * ****************************************
 */
package view;

import game.PlayerEnum;
import game.PokerTableEnum;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.PokerMain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/** The class that will contain the actual code that allows the GUI of the poker game to properly work
 *
 * @author sfs015
 */
public class GameView {

    /** The root window layout of the game GUI */
    private HBox gameRoot;

    /** The layout for where the actual gameplay will take place */
    private VBox gameplayVbox;

    /** The layout for where the players will be */
    private HBox playersHbox;

    /** The layout for the poker table */
    private StackPane pokerTableStackPane;

    /** The layout for the player cards and the CPU cards */
    private HBox playerAndCpuCardsHbox;

    /** Array that contains the Hboxes that will hold the CPU cards */
    private HBox[] cpuCardsHboxArray;

    /** The layout for the player cards */
    private HBox playerCardsHbox;

    /** The layout for all the cards that appear on the table */
    private VBox cardVbox;

    /** The Image of the player */
    private Image playerImage;

    /** The Image of the dealer */
    private Image dealerImage;

    /** Array that contains the ImageViews of the CPU players */
    private ImageView[] cpuPlayersImage;

    /** The ImageView of the player (allows the Image to properly appear on JavaFX) */
    private ImageView playerImageView;

    /** The ImageView of the dealer (allows the Image to properly appear on JavaFX) */
    private ImageView dealerImageView;

    /** Array that contains the images of the cards that will be dealt to the player */
    private Image[] playerCardImagesArray;

    /** The layout for the flop, river, and turn */
    private HBox dealerCardsHbox;

    /** Array that contains the images of the cards that will be dealt by the dealer on the flop, turn, and river */
    private Image[] dealerCardImagesArray;

    /** The layout for where the action buttons will be */
    private HBox buttonsHbox;

    /** The layout for the player (the circle with the text on top of it along with the number of chips) */
    private VBox playerVbox;

    /** Array that contains the layouts for the CPU players (the circle with the text on top of it along with the number of chips) */
    private VBox[] cpuPlayersVboxes;

    /** The layout for the dealer */
    private StackPane dealerStackPane;

    /** The layout for the player (the circle and the text on top of it) */
    private StackPane playerStackPane;

    /** Array that contains the layouts for the CPU players (the circle and the text on top of it) */
    private StackPane[] cpuPlayersStackPanes;

    /** The button that will bring the player back to the menu */
    private Button backToMenuButton;

    /** The text that will hold the game header */
    private Text gameHeaderText;

    /** The poker table that the game will be played on */
    private Rectangle pokerTable;

    /** The Text that will display the number of chips the player has above them */
    private Text playerChipText;

    /** Array that contains text that displays the number of chips each CPU has */
    private Text[] cpuPlayersChipText;

    /** The text that is placed on the dealer circle so that the user can know this circle is a representation of the dealer */
    private Text dealerText;

    /** The text that is placed on the dealer circle so that the user can know this circle is a representation of the player */
    private Text playerText;

    /** Array that contains the text placed on the CPU circles so that the user can know these circles represent CPU players */
    private Text[] cpuPlayersText;

    /** The circle that represents the dealer */
    private Circle dealerCircle;

    /** The circle that represents the player */
    private Circle playerCircle;

    /** The array that will contain the circles that represent all CPUs */
    private Circle[] cpuPlayersCircle;

    /** The array that will contain the indices of the PlayerEnum enum whose color has already been picked by the dealer/player/CPU players */
    private ArrayList<Integer> usedColors;

    /** The array that will contain the indices of cards that have already been dealt */
    private ArrayList<Integer> usedCards;

    /** The array that will contain the indices of images that have already been assigned to a CPU player */
    private ArrayList<Integer> usedImages;

    /** The button that will allow a player to make a bet */
    private Button betButton;

    /** The button that will allow a player to make a raise */
    private Button raiseButton;

    /** The button that will allow a player to call another's bet */
    private Button callButton;

    /** The button that will allow a player to check */
    private Button checkButton;

    /** The button that will allow a player to fold */
    private Button foldButton;

    /** The layout for the amount pop up */
    private VBox amountRoot;

    /** The layout for the buttons that appear on the pop up window */
    private HBox amountButtonsHbox;

    /** The stage that will hold the pop up window */
    private Stage amountPopUp;

    /** The scene that will hold the pop up window's items */
    private Scene amountScene;

    /** The Text that shows the number of current chips the player has */
    private Text currentNumOfChips;

    /** The Text that shows that the player should enter an amount in the TextField below*/
    private Text amountText;

    /** The Text that shows the amount the pot has */
    private Text potText;

    /** The TextField that a player will enter in the amount they want to bet or raise */
    private TextField amountTextField;

    /** The button that will allow a player to make a bet or raise in the pop up window */
    private Button actionButton;

    /** The button that will allow a player to close out of the pop up window */
    private Button cancelButton;

    /** The DropShadow effect that will be placed on the poker table */
    private DropShadow dropShadow;

    /** Default constructor that calls methods to properly setup the game GUI */
    public GameView() {

        setUpLayout();

        setUpItems();

        setUpPopUps();

        setUpFunctionality();
    }

    public Text getGameHeaderText() {
        return gameHeaderText;
    }

    public Rectangle getPokerTable() {
        return pokerTable;
    }

    public VBox getGameplayVbox() {
        return gameplayVbox;
    }

    public HBox getPlayerAndCpuCardsHbox() {
        return playerAndCpuCardsHbox;
    }

    public HBox getPlayersHbox() {
        return playersHbox;
    }

    public StackPane getPokerTableStackPane() {
        return pokerTableStackPane;
    }

    public HBox getPlayerCardsHbox() {
        return playerCardsHbox;
    }

    public HBox getDealerCardsHbox() {
        return dealerCardsHbox;
    }

    public HBox getButtonsHbox() {
        return buttonsHbox;
    }

    public VBox getPlayerVbox() {
        return playerVbox;
    }

    public VBox getCardVbox() {
        return cardVbox;
    }

    public VBox[] getCpuPlayersVboxes() {
        return cpuPlayersVboxes;
    }

    public StackPane getDealerStackPane() {
        return dealerStackPane;
    }

    public StackPane getPlayerStackPane() {
        return playerStackPane;
    }

    public StackPane[] getCpuPlayersStackPanes() {
        return cpuPlayersStackPanes;
    }

    public VBox getAmountRoot() {
        return amountRoot;
    }

    public HBox getAmountButtonsHbox() {
        return amountButtonsHbox;
    }

    /** A method that retrieves the main window layout of the game GUI */
    public HBox getGameRoot() {
        return gameRoot;
    }

    public Text getPlayerText() {
        return playerText;
    }

    public void setPlayerText(Text playerText) {
        this.playerText = playerText;
        this.playerText.setFont(Font.font(ViewUtility.TEXT_FONT_FAMILY, ViewUtility.PLAYER_TEXT_FONT_WEIGHT, ViewUtility.PLAYER_CPU_TEXT_FONT_SIZE));
    }

    public Circle getPlayerCircle() {
        return playerCircle;
    }

    public Text getPotText() {
        return potText;
    }

    public void setPotText(Text potText) {
        this.potText = potText;
        this.potText.setFont(Font.font(ViewUtility.TEXT_FONT_FAMILY, ViewUtility.POT_TEXT_FONT_WEIGHT, ViewUtility.POT_TEXT_FONT_SIZE));
    }

    public Text getPlayerChipText() {
        return playerChipText;
    }

    public void setPlayerChipText(Text playerChipText) {
        this.playerChipText = playerChipText;
        this.playerChipText.setFont(Font.font(ViewUtility.TEXT_FONT_FAMILY, ViewUtility.PLAYER_TEXT_FONT_WEIGHT, ViewUtility.PLAYER_CPU_TEXT_FONT_SIZE));
    }

    public Button getBackToMenuButton() {
        return backToMenuButton;
    }

    public Button getBetButton() {
        return betButton;
    }

    public Button getRaiseButton() {
        return raiseButton;
    }

    public Button getCallButton() {
        return callButton;
    }

    public Button getCheckButton() {
        return checkButton;
    }

    public Button getFoldButton() {
        return foldButton;
    }

    public Stage getAmountPopUp() {
        return amountPopUp;
    }

    public void setCardVbox(VBox cardVbox) {
        this.cardVbox = cardVbox;
    }

    public void setPlayerVbox(VBox playerVbox) {
        this.playerVbox = playerVbox;
    }

    public TextField getAmountTextField() {
        return amountTextField;
    }

    public Button getActionButton() {
        return actionButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    /**
     * A method that creates the game Scene in the GUI
     *
     * @param primaryStage - the Stage that the GUI functions on
     */
    public void createGameSceneGraph(Stage primaryStage) {
        primaryStage.setTitle("Texas Hold 'Em Poker Game");
        primaryStage.setScene(new Scene(getGameRoot()));
        primaryStage.sizeToScene();
        primaryStage.show();
        PokerMain.centerWindowOnScreen();
    }

    /**
     * A method that sets the color of the dealer/player/CPU players to a random color that hasn't been used yet
     *
     * @return a random color that has not been used yet
     */
    private Color getRandomUnusedColor() {

        // sorts ArrayList in ascending order so rand num generation properly works
        Collections.sort(usedColors);

        // RNG
        Random randomNumberGenerator = new Random();

        // generate a random number that aligns with the ordinal values of the PlayerEnum enum and excludes numbers already used
        int randomColor = randomNumberGenerator.nextInt(PlayerEnum.values().length - usedColors.size());

        // look at each color in the unused colors, if that color has already been used, simply look for the next number possible
        for(int color : usedColors) {

            // if the color hasn't been used yet, then select this random color
            if(randomColor < color)
                break;

            // otherwise, move onto the next possible color to see if that is not chosen
            randomColor++;
        }

        // add new color to the list of used colors
        usedColors.add(randomColor);

        return PlayerEnum.values()[randomColor].getColor();
    }

    /**
     * A method that sets the card of the dealer/player/CPU cards to random cards that haven't been used yet
     *
     * @return a random card that has not been used yet
     */
    private int getRandomUnusedCard() {

        // sorts ArrayList in ascending order so rand num generation properly works
        Collections.sort(usedCards);

        // RNG
        Random randomNumberGenerator = new Random();

        // generate a random number that aligns with the the number of cards there are and excludes numbers already used
        int randomCard = randomNumberGenerator.nextInt(ViewUtility.CARD_NAMES.length - usedCards.size());

        // look at each card in the unused cards, if that card has already been used, simply look for the next number possible
        for(int card : usedCards) {

            // if the card hasn't been used yet, then select this random card
            if(randomCard < card)
                break;

            // otherwise, move onto the next possible color to see if that is not chosen
            randomCard++;
        }

        usedCards.add(randomCard);

        return randomCard;
    }

    /**
     * A method that sets an image for the CPU that hasn't been used yet
     *
     * @return a random image that has not been used yet
     */
    private int getRandomUnusedImage() {

        // sorts ArrayList in ascending order so rand num generation properly works
        Collections.sort(usedImages);

        // RNG
        Random randomNumberGenerator = new Random();

        // generate a random number that aligns with the the number of images there are and excludes numbers already used
        int randomImage = randomNumberGenerator.nextInt(ViewUtility.CPU_IMAGE_NAMES.length - usedImages.size());

        // look at each image in the unused images, if that image has already been used, simply look for the next number possible
        for(int image : usedImages) {

            // if the image hasn't been used yet, then select this random image
            if(randomImage < image)
                break;

            // otherwise, move onto the next possible image to see if that is not chosen
            randomImage++;
        }

        usedImages.add(randomImage);

        return randomImage;
    }

    /**
     * A method that properly displays a popup box allowing a user to make a bet or raise
     *
     * @param action - String that designates what action (betting or raising) is currently taking place
     */
    public void displayAmountPopUp(String action) {

        getAmountPopUp().setTitle(action + " Window");

        amountRoot.getChildren().removeAll(currentNumOfChips, amountText, amountTextField, amountButtonsHbox);

        currentNumOfChips = new Text("Current Number of Chips: " + PokerMain.getGameController().getPlayerChipsArray()[0].getPlayerAmount());

        amountText = new Text(action + " Amount:");

        actionButton.setText(action);

        amountRoot.getChildren().addAll(currentNumOfChips, amountText, amountTextField, amountButtonsHbox);

        amountPopUp.setScene(amountScene);
        amountPopUp.show();
    }

    /**
     * A method that sets up the objects that compose the layout of the poker game GUI
     */
    private void setUpLayout() {
        gameRoot = new HBox(ViewUtility.NORMAL_VBOX_SPACING);
        getGameRoot().setPadding(new Insets(ViewUtility.PADDING));
        getGameRoot().setPrefWidth(ViewUtility.GAME_ROOT_WIDTH);
        getGameRoot().setPrefHeight(ViewUtility.GAME_ROOT_HEIGHT);

        gameplayVbox = new VBox(ViewUtility.NORMAL_VBOX_SPACING);
        gameplayVbox.setAlignment(Pos.CENTER);
        gameplayVbox.setPadding(new Insets(ViewUtility.PADDING));

        cardVbox = new VBox(ViewUtility.NORMAL_VBOX_SPACING);
        cardVbox.setAlignment(Pos.CENTER);
        cardVbox.setPadding(new Insets(ViewUtility.PADDING));

        playersHbox = new HBox(ViewUtility.PLAYER_HBOX_SPACING);
        playersHbox.setAlignment(Pos.CENTER);

        playerAndCpuCardsHbox = new HBox(ViewUtility.PLAYER_AND_CPU_CARD_HBOX_SPACING);
        playerAndCpuCardsHbox.setAlignment(Pos.CENTER);
        playerAndCpuCardsHbox.setPadding(new Insets(ViewUtility.PADDING));

        pokerTableStackPane = new StackPane();
        pokerTableStackPane.setAlignment(Pos.CENTER);

        playerCardsHbox = new HBox(ViewUtility.NORMAL_HBOX_SPACING);
        playerCardsHbox.setAlignment(Pos.CENTER);
        playerCardsHbox.setPadding(new Insets(ViewUtility.PADDING));

        dealerCardsHbox = new HBox(ViewUtility.NORMAL_HBOX_SPACING);
        dealerCardsHbox.setAlignment(Pos.CENTER);
        dealerCardsHbox.setPadding(new Insets(ViewUtility.PADDING));

        buttonsHbox = new HBox(ViewUtility.NORMAL_HBOX_SPACING);
        buttonsHbox.setAlignment(Pos.CENTER);
        buttonsHbox.setPadding(new Insets(ViewUtility.PADDING));

        playerVbox = new VBox();
        playerVbox.setAlignment(Pos.CENTER);

        cpuPlayersVboxes = new VBox[PokerMain.getSettingsController().getNumOfCpus()];

        dealerStackPane = new StackPane();

        playerStackPane = new StackPane();

        cpuPlayersStackPanes = new StackPane[PokerMain.getSettingsController().getNumOfCpus()];

        // Creating StackPane for every CPU player
        for(int i = 0; i < PokerMain.getSettingsController().getNumOfCpus(); i++) {
            cpuPlayersStackPanes[i] = new StackPane();

            cpuPlayersVboxes[i] = new VBox();
            cpuPlayersVboxes[i].setAlignment(Pos.CENTER);
        }
    }

    /**
     * A method that sets up the items that compose the poker game GUI
     */
    private void setUpItems() {
        backToMenuButton = new Button("Back");
        getBackToMenuButton().setMinWidth(ViewUtility.BUTTON_WIDTH);
        getBackToMenuButton().setAlignment(Pos.TOP_CENTER);

        gameHeaderText = new Text("Texas Hold 'Em Poker Game");
        gameHeaderText.setFont(Font.font(ViewUtility.TEXT_FONT_FAMILY, ViewUtility.HEADER_TEXT_FONT_WEIGHT, ViewUtility.HEADER_TEXT_FONT_SIZE));

        setPlayerText(new Text(PokerMain.getMenuView().getNameTextField().getText()));

        dropShadow = new DropShadow();
        dropShadow.setRadius(ViewUtility.DROP_SHADOW_RADIUS);
        dropShadow.setColor(ViewUtility.DROP_SHADOW_COLOR);

        pokerTable = new Rectangle(ViewUtility.POKER_TABLE_WIDTH, ViewUtility.POKER_TABLE_HEIGHT);
        pokerTable.setFill(PokerTableEnum.valueOf(PokerMain.getSettingsController().getColorOfPokerTable()).getColor());
        pokerTable.setStroke(ViewUtility.POKER_TABLE_STROKE_COLOR);
        pokerTable.setStrokeWidth(ViewUtility.POKER_TABLE_STROKE_WIDTH);
        pokerTable.setArcWidth(ViewUtility.POKER_TABLE_ARC_WIDTH);
        pokerTable.setArcHeight(ViewUtility.POKER_TABLE_ARC_HEIGHT);
        pokerTable.setEffect(dropShadow);

        cpuCardsHboxArray = new HBox[PokerMain.getSettingsController().getNumOfCpus()];

        usedColors = new ArrayList<>();
        usedColors.add(PokerMain.getSettingsView().getColorOfPlayerDropdown().getSelectionModel().getSelectedIndex());

        //TODO - Need to add ability for showing the CPU players' hand but face down
        playerCardImagesArray = new Image[ViewUtility.NUM_OF_PLAYER_CPU_CARDS];

        usedCards = new ArrayList<>();

        usedImages = new ArrayList<>();

        for(int i = 0; i < ViewUtility.NUM_OF_PLAYER_CPU_CARDS; i++)
            playerCardImagesArray[i] = new Image(getClass().getResourceAsStream("/resources/" + ViewUtility.CARD_NAMES[getRandomUnusedCard()] + ".png"));

        dealerCardImagesArray = new Image[ViewUtility.NUM_OF_DEALER_CARDS];

        //TODO - Need to add turn logic so that cards (flop, river, turn) can correctly appear on the table
        for(int i = 0; i < ViewUtility.NUM_OF_DEALER_CARDS; i++)
            dealerCardImagesArray[i] = new Image(getClass().getResourceAsStream("/resources/" + ViewUtility.CARD_NAMES[getRandomUnusedCard()] + ".png"));

        dealerText = new Text("Dealer");
        dealerText.setFont(Font.font(ViewUtility.TEXT_FONT_FAMILY, ViewUtility.REGULAR_TEXT_FONT_WEIGHT, ViewUtility.DEALER_TEXT_FONT_SIZE));

        dealerCircle = new Circle(ViewUtility.DEALER_CIRCLE_RADIUS, getRandomUnusedColor());
        dealerCircle.setStroke(ViewUtility.DEALER_PLAYER_CPU_STROKE_COLOR);
        dealerCircle.setStrokeWidth(ViewUtility.DEALER_STROKE_WIDTH);

        playerImage = new Image(getClass().getResourceAsStream("/resources/pokerface.png"));

        playerImageView = new ImageView();
        playerImageView.setImage(playerImage);
        playerImageView.setPreserveRatio(true);
        playerImageView.setFitHeight(ViewUtility.PLAYER_IMAGE_HEIGHT);

        dealerImage = new Image(getClass().getResourceAsStream("/resources/King.png"));

        dealerImageView = new ImageView();
        dealerImageView.setImage(dealerImage);
        dealerImageView.setPreserveRatio(true);
        dealerImageView.setFitHeight(ViewUtility.DEALER_IMAGE_HEIGHT);

        playerCircle = new Circle(ViewUtility.PLAYER_CPU_CIRCLE_RADIUS, PlayerEnum.valueOf(PokerMain.getSettingsController().getColorOfPlayer()).getColor());
        playerCircle.setStroke(ViewUtility.DEALER_PLAYER_CPU_STROKE_COLOR);
        playerCircle.setStrokeWidth(ViewUtility.PLAYER_CPU_STROKE_WIDTH);

        setPlayerChipText(new Text("Chips: " + PokerMain.getSettingsController().getStartingChipAmount()));

        setPotText(new Text("Pot Amount: " + PokerMain.getGamePot().getGameAmount()));

        cpuPlayersText = new Text[PokerMain.getSettingsController().getNumOfCpus()];

        cpuPlayersCircle = new Circle[PokerMain.getSettingsController().getNumOfCpus()];

        cpuPlayersChipText = new Text[PokerMain.getSettingsController().getNumOfCpus()];

        cpuPlayersImage = new ImageView[PokerMain.getSettingsController().getNumOfCpus()];

        // Creating text and circle for every CPU player, along with the chip amount that goes above each CPU player
        for(int i = 0; i < PokerMain.getSettingsController().getNumOfCpus(); i++) {
            String cpuName = ViewUtility.CPU_IMAGE_NAMES[getRandomUnusedImage()];

            cpuPlayersImage[i] = new ImageView();
            cpuPlayersImage[i].setImage(new Image(getClass().getResourceAsStream("/resources/" + cpuName + ".png")));
            cpuPlayersImage[i].setPreserveRatio(true);
            cpuPlayersImage[i].setFitHeight(ViewUtility.CPU_IMAGE_HEIGHT);

            cpuPlayersText[i] = new Text(cpuName + " (CPU)");
            cpuPlayersText[i].setFont(Font.font(ViewUtility.TEXT_FONT_FAMILY, ViewUtility.REGULAR_TEXT_FONT_WEIGHT, ViewUtility.PLAYER_CPU_TEXT_FONT_SIZE));

            cpuPlayersCircle[i] = new Circle(ViewUtility.PLAYER_CPU_CIRCLE_RADIUS, getRandomUnusedColor());
            cpuPlayersCircle[i].setStroke(ViewUtility.DEALER_PLAYER_CPU_STROKE_COLOR);
            cpuPlayersCircle[i].setStrokeWidth(ViewUtility.PLAYER_CPU_STROKE_WIDTH);

            if(PokerMain.getSettingsController().showCpuChipAmount()) {
                cpuPlayersChipText[i] = new Text("Chips: " + PokerMain.getSettingsController().getStartingChipAmount());
                cpuPlayersChipText[i].setFont(Font.font(ViewUtility.TEXT_FONT_FAMILY, ViewUtility.REGULAR_TEXT_FONT_WEIGHT, ViewUtility.PLAYER_CPU_TEXT_FONT_SIZE));
            }

            else
                cpuPlayersChipText[i] = new Text("");
        }

        //TODO - Need to add logic so that certain buttons may be disabled depending on the turn or the amount of chips the player has
        betButton = new Button("Bet");
        betButton.setMinWidth(ViewUtility.BUTTON_WIDTH);
        betButton.setAlignment(Pos.TOP_CENTER);

        raiseButton = new Button("Raise");
        raiseButton.setMinWidth(ViewUtility.BUTTON_WIDTH);
        raiseButton.setAlignment(Pos.TOP_CENTER);

        callButton = new Button("Call");
        callButton.setMinWidth(ViewUtility.BUTTON_WIDTH);
        callButton.setAlignment(Pos.TOP_CENTER);

        checkButton = new Button("Check");
        checkButton.setMinWidth(ViewUtility.BUTTON_WIDTH);
        checkButton.setAlignment(Pos.TOP_CENTER);

        foldButton = new Button("Fold");
        foldButton.setMinWidth(ViewUtility.BUTTON_WIDTH);
        foldButton.setAlignment(Pos.TOP_CENTER);
    }

    /** A method that properly sets up the layout and items that will go in the popup window */
    private void setUpPopUps() {
        amountPopUp = new Stage();
        getAmountPopUp().initModality(Modality.APPLICATION_MODAL);

        amountRoot = new VBox(ViewUtility.NORMAL_VBOX_SPACING);
        amountRoot.setAlignment(Pos.CENTER);
        amountRoot.setPadding(new Insets(ViewUtility.PADDING));

        amountButtonsHbox = new HBox(ViewUtility.NORMAL_HBOX_SPACING);
        amountButtonsHbox.setAlignment(Pos.CENTER);
        amountButtonsHbox.setPadding(new Insets(ViewUtility.PADDING));

        currentNumOfChips = new Text();

        amountText = new Text();

        amountTextField = new TextField();
        getAmountTextField().setMaxWidth(ViewUtility.TEXT_FIELD_WIDTH);

        actionButton = new Button();
        getActionButton().setMinWidth(ViewUtility.BUTTON_WIDTH);
        getActionButton().setAlignment(Pos.TOP_CENTER);

        cancelButton = new Button("Cancel");
        getCancelButton().setMinWidth(ViewUtility.BUTTON_WIDTH);
        getCancelButton().setAlignment(Pos.TOP_CENTER);

        amountButtonsHbox.getChildren().addAll(actionButton, cancelButton);
        amountButtonsHbox.setAlignment(Pos.CENTER);

        amountRoot.getChildren().addAll(currentNumOfChips, amountText, amountTextField, amountButtonsHbox);
        amountRoot.setAlignment(Pos.CENTER);

        amountScene = new Scene(amountRoot, ViewUtility.POP_UP_WIDTH, ViewUtility.POP_UP_HEIGHT);
    }

    /**
     * A method that relates the layout objects to the items to make a functional poker game GUI
     */
    private void setUpFunctionality() {
        dealerStackPane.getChildren().addAll(dealerCircle, dealerImageView);

        playerStackPane.getChildren().addAll(playerCircle, playerImageView);

        playerVbox.getChildren().addAll(playerChipText, playerStackPane, playerText);

        playersHbox.getChildren().add(playerVbox);

        // Adding the CPU players to the GUI
        for(int i = 0; i < PokerMain.getSettingsController().getNumOfCpus(); i++) {
            cpuPlayersStackPanes[i].getChildren().addAll(cpuPlayersCircle[i], cpuPlayersImage[i]);
            cpuPlayersVboxes[i].getChildren().addAll(cpuPlayersChipText[i], cpuPlayersStackPanes[i], cpuPlayersText[i]);
            playersHbox.getChildren().add(cpuPlayersVboxes[i]);
        }

        for(int i = 0; i < ViewUtility.NUM_OF_PLAYER_CPU_CARDS; i++) {
            ImageView cardImage = new ImageView();
            cardImage.setImage(playerCardImagesArray[i]);
            cardImage.setPreserveRatio(true);
            cardImage.setFitHeight(ViewUtility.PLAYER_CPU_CARD_HEIGHT);
            cardImage.setEffect(dropShadow);
            playerCardsHbox.getChildren().add(cardImage);
        }

        playerAndCpuCardsHbox.getChildren().add(playerCardsHbox);

        for(int i = 0; i < ViewUtility.NUM_OF_PLAYER_CPU_CARDS * PokerMain.getSettingsController().getNumOfCpus(); i++) {

            if(i % ViewUtility.NUM_OF_PLAYER_CPU_CARDS == 0) {
                cpuCardsHboxArray[i / ViewUtility.NUM_OF_PLAYER_CPU_CARDS] = new HBox(ViewUtility.NORMAL_HBOX_SPACING);
                cpuCardsHboxArray[i / ViewUtility.NUM_OF_PLAYER_CPU_CARDS].setAlignment(Pos.CENTER);
                cpuCardsHboxArray[i / ViewUtility.NUM_OF_PLAYER_CPU_CARDS].setPadding(new Insets(ViewUtility.PADDING));
            }

            ImageView cardImage = new ImageView();
            cardImage.setImage(new Image(getClass().getResourceAsStream("/resources/cardBack.png")));
            cardImage.setPreserveRatio(true);
            cardImage.setFitHeight(ViewUtility.PLAYER_CPU_CARD_HEIGHT);
            cardImage.setEffect(dropShadow);

            cpuCardsHboxArray[i / ViewUtility.NUM_OF_PLAYER_CPU_CARDS].getChildren().add(cardImage);

            if(i % ViewUtility.NUM_OF_PLAYER_CPU_CARDS == ViewUtility.NUM_OF_PLAYER_CPU_CARDS - 1) {
                playerAndCpuCardsHbox.getChildren().add(cpuCardsHboxArray[i / ViewUtility.NUM_OF_PLAYER_CPU_CARDS]);
            }
        }

        for(int i = 0; i < ViewUtility.NUM_OF_DEALER_CARDS; i++) {
            ImageView cardImage = new ImageView();
            cardImage.setImage(dealerCardImagesArray[i]);
            cardImage.setPreserveRatio(true);
            cardImage.setFitHeight(ViewUtility.DEALER_CARD_HEIGHT);
            cardImage.setEffect(dropShadow);
            dealerCardsHbox.getChildren().add(cardImage);
        }

        cardVbox.getChildren().addAll(playerAndCpuCardsHbox, dealerCardsHbox, potText);

        pokerTableStackPane.getChildren().addAll(pokerTable, cardVbox);

        buttonsHbox.getChildren().addAll(betButton, raiseButton, callButton, checkButton, foldButton);

        gameplayVbox.getChildren().addAll(gameHeaderText, playersHbox, pokerTableStackPane, dealerStackPane, dealerText, buttonsHbox);
        getGameRoot().getChildren().addAll(getBackToMenuButton(), gameplayVbox);
    }
}