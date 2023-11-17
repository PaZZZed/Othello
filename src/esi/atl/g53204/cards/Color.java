package esi.atl.g53204.cards;

/**
 *
 * @author g53204
 */
public enum Color {
    // APA : ToString ?
    CLUB("treffle"), DIAMOND("carré"), HEART("coeur"), SPADE("pique");

    private final String type;

    private Color(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type +" de";
    }
}
