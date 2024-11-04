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
 * Class: SettingsController
 *
 * Description:
 * The class that will contain the actual code that allows the GUI of the settings to interact with the data so that
 * the logic of the settings GUI may work properly
 * ****************************************
 */
package controller;

import main.PokerMain;

/**
 * The class that will contain the actual code that allows the GUI of the settings to interact with the data so that
 * the logic of the settings GUI may work properly
 *
 * @author sfs015
 */
public class SettingsController {

    /** The number of CPUs the user will play against */
    private int numOfCpus = Integer.parseInt(PokerMain.getSettingsView().getNumOfCpusDropdown().getValue().toString());

    /** The color of the poker table */
    private String colorOfPokerTable = PokerMain.getSettingsView().getColorOfPokerTableDropdown().getValue().toString();

    /** The color of the player */
    private String colorOfPlayer = PokerMain.getSettingsView().getColorOfPlayerDropdown().getValue().toString();

    /** The starting chip amount for all players */
    private int startingChipAmount = Integer.parseInt(PokerMain.getSettingsView().getStartingChipAmountDropdown().getValue().toString());

    /** Yes/No if CPUs' chip amount should be shown */
    private String stringShowCpuChipAmount = PokerMain.getSettingsView().getShowCpuChipAmountDropdown().getValue().toString();

    /** The boolean that is set based on if the user chose Yes/No for if the CPUs' chip amount should be shown */
    private boolean booleanShowCpuChipAmount;

    /** Yes/No if CPUs' hand should be shown after the hand is over */
    private String stringShowCpuHand = PokerMain.getSettingsView().getShowCpuChipAmountDropdown().getValue().toString();

    /** The boolean that is set based on if the user chose Yes/No for if the CPUs' hand should be shown after the hand is over */
    private boolean booleanShowCpuHand;

    public int getNumOfCpus() {
        return numOfCpus;
    }

    public String getColorOfPokerTable() {
        return colorOfPokerTable;
    }

    public String getColorOfPlayer() {
        return colorOfPlayer;
    }

    public int getStartingChipAmount() {
        return startingChipAmount;
    }

    /** Private getter because this variable only needs to be internal to this class */
    private String getStringShowCpuChipAmount() {
        return stringShowCpuChipAmount;
    }

    public boolean showCpuChipAmount() {
        return booleanShowCpuChipAmount;
    }

    /** Private getter because this variable only needs to be internal to this class */
    private String getStringShowCpuHand() {
        return stringShowCpuHand;
    }

    public boolean showCpuHand() {
        return booleanShowCpuHand;
    }

    public void setNumOfCpus(int numOfCpus) {
        this.numOfCpus = numOfCpus;
    }

    public void setColorOfPokerTable(String colorOfPokerTable) {
        this.colorOfPokerTable = colorOfPokerTable;
    }

    public void setColorOfPlayer(String colorOfPlayer) {
        this.colorOfPlayer = colorOfPlayer;
    }

    public void setStartingChipAmount(int startingChipAmount) {
        this.startingChipAmount = startingChipAmount;
    }

    /** Private setter because this variable only needs to be internal to this class */
    public void setStringShowCpuChipAmount(String stringShowCpuChipAmount) {
        this.stringShowCpuChipAmount = stringShowCpuChipAmount;
    }

    public void setShowCpuChipAmount(boolean showCpuChipAmount) {
        booleanShowCpuChipAmount = showCpuChipAmount;
    }

    /** Private getter because this variable only needs to be internal to this class */
    public void setStringShowCpuHand(String stringShowCpuHand) {
        this.stringShowCpuHand = stringShowCpuHand;
    }

    public void setShowCpuHand(boolean showCpuHand) {
        booleanShowCpuHand = showCpuHand;
    }

    /**
     * Constructor that properly sets up the controller of the settings
     */
    public SettingsController() {
        setupBooleans();
        setupHandlers();
    }

    /** A method that sets up the boolean variables */
    private void setupBooleans() {

        if(stringShowCpuChipAmount.equalsIgnoreCase("Yes"))
            setShowCpuChipAmount(true);

        else if(stringShowCpuChipAmount.equalsIgnoreCase("No"))
            setShowCpuChipAmount(false);

        if(stringShowCpuHand.equalsIgnoreCase("Yes"))
            setShowCpuHand(true);

        else if(stringShowCpuHand.equalsIgnoreCase("No"))
            setShowCpuHand(false);
    }

    /** A method that sets up the event handlers associated with the settings */
    private void setupHandlers() {
        PokerMain.getSettingsView().getSaveButton().setOnMouseClicked(event -> {
            setNumOfCpus(Integer.parseInt(PokerMain.getSettingsView().getNumOfCpusDropdown().getValue().toString()));

            setColorOfPokerTable(PokerMain.getSettingsView().getColorOfPokerTableDropdown().getValue().toString());

            setColorOfPlayer(PokerMain.getSettingsView().getColorOfPlayerDropdown().getValue().toString());

            setStartingChipAmount(Integer.parseInt(PokerMain.getSettingsView().getStartingChipAmountDropdown().getValue().toString()));

            setStringShowCpuChipAmount(PokerMain.getSettingsView().getShowCpuChipAmountDropdown().getValue().toString());

            setStringShowCpuHand(PokerMain.getSettingsView().getShowCpuHandDropdown().getValue().toString());

            setupBooleans();

            PokerMain.getMenuView().createMenuSceneGraph(PokerMain.getPrimaryStage());
        });
    }
}