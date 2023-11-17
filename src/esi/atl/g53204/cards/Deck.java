package esi.atl.g53204.cards;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author g53204
 */
public class Deck {

    private final List<Card> deck;

    /**
     * Deck constructor initialize deck
     */
    public Deck() {
        // APA : Pourquoi une arraylist  this.deck = new ArrayList<>(52);?
        // APA : Définir la taille
        this.deck = new LinkedList<>();

        for (Color color : Color.values()) {
            for (Value valeurs : Value.values()) {

                deck.add(new Card(valeurs, color));

            }
        }
    }


    /**
     * shuffle the deck
     */
    public void shuffle() {
        /*Random rand = new Random();
        for (int i = 0; i < 52; i++) {
            int r = i + rand.nextInt(52 - i);
            Card temp = deck.get(r);
            deck.set(i, deck.get(i));
            deck.set(i, temp);
        }*/
        Collections.shuffle(deck);

    }

    /**
     * verify if the deck is empty or not
     *
     * @return true is the deck is empty ,if not return false
     */
    public boolean isEmpty() {
        // APA : return deck.isEmpty()

        /*boolean isEmpty = false;
        if (deck.isEmpty()) {
            isEmpty = true;
        }
        return isEmpty;*/
        return deck.isEmpty();
    }

    /**
     * take the first card from the deck and remove it
     *
     * @return the card that got removed
     */
    public Card hit() {
        // APA : Qu'est ce qui se passe si la liste est vide
        // APA : Pourquoi retirer la carte 0 ?
        if (deck.isEmpty()) {
            throw new NullPointerException();
        }
        Card picohe = deck.get(deck.size() - 1);
        return deck.remove(deck.size() - 1);
        // APA : return deck.remove(0)
        //return picohe;
    }

    @Override
    public String toString() {
        return "Deck: " + deck;
    }

}
