/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2019
 * Instructor: Prof. Brian King
 *
 * Name: Shane Staret
 * Section: 01
 * Date: 11/22/19
 * Time: 11 - 11:52
 *
 * Project: csci205_Kings_Disciples
 * Package: game
 * Class: PokerTableEnum
 *
 * Description:
 * Enum used to properly determine the color of the poker table
 * ****************************************
 */
package game;

import javafx.scene.paint.Color;

/** Enum used to properly determine the color of the poker table
 *
 * @author sfs015
 */
public enum PokerTableEnum {
    Green("Green", Color.GREEN),
    Blue("Blue", Color.BLUE),
    White("White", Color.WHITE),
    Red("Red", Color.RED),
    Purple("Purple", Color.PURPLE),
    Yellow("Yellow", Color.YELLOW),
    Orange("Orange", Color.ORANGE),
    Brown("Brown", Color.BROWN),
    Gray("Gray", Color.GRAY);

    private String stringColor;
    private Color color;

    private PokerTableEnum(String stringColor, Color color) {
        this.stringColor = stringColor;
        this.color = color;
    }

    public String getStringColor() {
        return stringColor;
    }

    public Color getColor() {
        return color;
    }
}