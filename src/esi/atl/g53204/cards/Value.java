
package esi.atl.g53204.cards;

/**
 *
 * @author g53204
 */
public enum Value {
    ACE("as"),TWO("deux"),THREE("trois"),FOUR("quatre"),FIVE("cinq"),SIX("six"),
    SEVEN("sept"),EIGHT("huit"),NINE("neuf"),TEN("dix"),JACK("vallet"),QUEEN("reine"),KING("roi");
     private final String type;

    private Value(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
