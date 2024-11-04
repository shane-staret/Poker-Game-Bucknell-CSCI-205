package game;

/**
 * Enum for the poker chips that will be used to make bets and control the monetary flow of the game
 *
 * @author sd043
 */
public enum PokerChip {
    /** Chip enums and their monetary values */
    WHITE(1),
    RED(5),
    BLUE(10),
    GREY(20),
    GREEN(25),
    ORANGE(50),
    BLACK(100);

    /** Final integer to hold the enum value */
    private final int amount;

    /** Constructor for the enums */
    PokerChip(int amount) {
        this.amount = amount;
    }

    /** Getter method in order to retrieve the poker chip value */
    public int getAmount() {
        return amount;
    }
}
