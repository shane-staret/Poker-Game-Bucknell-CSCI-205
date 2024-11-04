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
 * Class: ViewUtility
 *
 * Description:
 * A utility class that holds constants that all other classes in the view package can make use of
 * ****************************************
 */
package view;

import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

/** A utility class that holds constants that all other classes in the view package can make use of
 *
 * @author sfs015
 */
public final class ViewUtility {

    /** private Constructor to prevent instantiation from outside the class */
    private ViewUtility() {

    }

    /** The width of all buttons */
    public static final int BUTTON_WIDTH = 80;

    /** The spacing of all VBoxes */
    public static final int NORMAL_VBOX_SPACING = 10;

    /** The spacing of all HBoxes */
    public static final int NORMAL_HBOX_SPACING = 10;

    /** The spacing of the HBox that holds the players */
    public static final int PLAYER_HBOX_SPACING = 48;

    /** The spacing of the HBox that holds the player and CPU cards */
    public static final int PLAYER_AND_CPU_CARD_HBOX_SPACING = 15;

    /** The hgap in all gridpanes */
    public static final int GRIDPANE_HGAP = 25;

    /** The vgap in all gridpanes */
    public static final int GRIDPANE_VGAP = 10;

    /** The padding on layouts */
    public static final int PADDING = 15;

    /** The height to be set for the root layout for the menu & settings GUI */
    public static final int MENU_AND_SETTINGS_ROOT_HEIGHT = 250;

    /** The width to be set for the root layout for the menu & settings GUI */
    public static final int MENU_AND_SETTINGS_ROOT_WIDTH = 725;

    /** The height to be set for the root layout for the game GUI */
    public static final int GAME_ROOT_HEIGHT = 625;

    /** The width to be set for the root layout for the game GUI */
    public static final int GAME_ROOT_WIDTH = 775;

    /** The width of all dropdown menus */
    public static final int DROPDOWN_WIDTH = 200;

    /** The height of all dropdown menus */
    public static final int DROPDOWN_HEIGHT = 30;

    /** The font family that all text should be */
    public static final String TEXT_FONT_FAMILY = "Verdana";

    /** The font weight all header text should be */
    public static final FontWeight HEADER_TEXT_FONT_WEIGHT = FontWeight.BOLD;

    /** The font weight all regular text should be */
    public static final FontWeight REGULAR_TEXT_FONT_WEIGHT = FontWeight.NORMAL;

    /** The font weight all text should be for the player */
    public static final FontWeight PLAYER_TEXT_FONT_WEIGHT = FontWeight.BOLD;

    /** The font size all header text should be */
    public static final int HEADER_TEXT_FONT_SIZE = 14;

    /** The font size all regular text should be */
    public static final int REGULAR_TEXT_FONT_SIZE = 12;

    /** The size of all textfields */
    public static final int TEXT_FIELD_WIDTH = 100;

    /** The index of the num of CPUs dropdown menu that should be the default choice */
    public static final int NUM_OF_CPUS_DEFAULT_CHOICE = 0;

    /** The index of the color of the poker table dropdown menu that should be the default choice */
    public static final int COLOR_OF_POKER_TABLE_DEFAULT_CHOICE = 0;

    /** The index of the color of the player dropdown menu that should be the default choice */
    public static final int COLOR_OF_PLAYER_DEFAULT_CHOICE = 0;

    /** The index of the starting chip amount dropdown menu that should be the default choice */
    public static final int STARTING_CHIP_AMOUNT_DEFAULT_CHOICE = 0;

    /** The index of the show CPU chips dropdown menu that should be the default choice */
    public static final int SHOW_CPU_CHIP_AMOUNT_DEFAULT_CHOICE = 0;

    /** The index of the show CPU hand dropdown menu that should be the default choice */
    public static final int SHOW_CPU_HAND_DEFAULT_CHOICE = 0;

    /** The designated width of the poker table */
    public static final double POKER_TABLE_WIDTH = 850.0;

    /** The designated height of the poker table */
    public static final double POKER_TABLE_HEIGHT = 350.0;

    /** The designated width of the poker table rounded corners */
    public static final double POKER_TABLE_ARC_WIDTH = 50.0;

    /** The designated height of the poker table rounded corners */
    public static final double POKER_TABLE_ARC_HEIGHT = 50.0;

    /** The color of the stroke for the poker table */
    public static final Color POKER_TABLE_STROKE_COLOR = Color.BLACK;

    /** The width of the stroke for the poker table */
    public static final int POKER_TABLE_STROKE_WIDTH = 8;

    /** The text size of the dealer text */
    public static final int DEALER_TEXT_FONT_SIZE = 16;

    /** The text size of the dealer text */
    public static final int PLAYER_CPU_TEXT_FONT_SIZE = 12;

    /** The radius of the dealer circle */
    public static final double DEALER_CIRCLE_RADIUS = 70.0;

    /** The radius of the CPU circle */
    public static final double PLAYER_CPU_CIRCLE_RADIUS = 55.0;

    /** The stroke color of the dealer, player, and CPUs */
    public static final Color DEALER_PLAYER_CPU_STROKE_COLOR = Color.BLACK;

    /** The stroke width of the dealer */
    public static final int DEALER_STROKE_WIDTH = 5;

    /** The stroke width of the CPUs and the player */
    public static final int PLAYER_CPU_STROKE_WIDTH = 3;

    /** The popup window width */
    public static final int POP_UP_WIDTH = 225;

    /** The popup window height */
    public static final int POP_UP_HEIGHT = 175;

    /** The number of cards that the player and the CPUs are dealt */
    public static final int NUM_OF_PLAYER_CPU_CARDS = 2;

    /** The number of total cards that the dealer will deal for the flop, turn, and river combined */
    public static final int NUM_OF_DEALER_CARDS = 5;

    /** The array that holds the name of all cards (used primarily to randomly select an image from the "resources" directory */
    public static final String[] CARD_NAMES = {"2C", "2D", "2H", "2S", "3C", "3D", "3H", "3S", "4C", "4D", "4H", "4S", "5C", "5D", "5H", "5S", "6C", "6D", "6H", "6S", "7C", "7D", "7H", "7S", "8C", "8D", "8H", "8S", "9C", "9D", "9H", "9S", "10C", "10D", "10H", "10S", "AC", "AD", "AH", "AS", "JC", "JD", "JH", "JS", "KC", "KD", "KH", "KS", "QC", "QD", "QH", "QS"};

    /** The array that holds the name of all the CPU images (used primarily to randomly select an image for the CPU players */
    public static final String[] CPU_IMAGE_NAMES = {"Shane", "Sami", "Mike", "John"};

    /** The size of the card that the dealer has on the table */
    public static final int DEALER_CARD_HEIGHT = 125;

    /** The size of the card that the player and CPUs have on the table */
    public static final int PLAYER_CPU_CARD_HEIGHT = 75;

    /** The size of the image of the CPUs */
    public static final int CPU_IMAGE_HEIGHT = 75;

    /** The size of the image of the player */
    public static final int PLAYER_IMAGE_HEIGHT = 85;

    /** The size of the image of the dealer */
    public static final int DEALER_IMAGE_HEIGHT = 125;

    /** The weight of the text that displays the pot total */
    public static final FontWeight POT_TEXT_FONT_WEIGHT = FontWeight.BOLD;

    /** The size of the text that displays the pot total */
    public static final int POT_TEXT_FONT_SIZE = 14;

    /** The radius of the drop shadow */
    public static final double DROP_SHADOW_RADIUS = 25.0;

    /** The color of the drop shadow */
    public static final Color DROP_SHADOW_COLOR = Color.BLACK;

    /** The maximum name length allowed for a player */
    public static final int MAX_NAME_LENGTH = 10;
}