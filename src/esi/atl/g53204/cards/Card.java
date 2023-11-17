package esi.atl.g53204.cards;

import java.util.Objects;

/**
 *
 * @author g53204
 */
public class Card {

    private final Color couleur;
    private final Value valeur;

    /**
     * Card constructor throw an exception if the parameters are null
     *
     * @param couleur color of the card
     * @param valeur value of the card
     */
    public Card(Value valeur, Color couleur) {
        if (couleur == null || valeur == null) {
            throw new NullPointerException("valeur inadéquate");
        }
        this.couleur = couleur;
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return couleur + " " + valeur;
    }

    /**
     *
     * @param objet
     * @return
     */
    @Override
    public boolean equals(Object objet) {
        if (this == objet) {
            return true;
        }
        if (objet == null) {
            return false;
        }
        if (getClass() != objet.getClass()) {
            return false;
        }
        final Card other = (Card) objet;
        if (this.couleur != other.couleur) {
            return false;
        }
        if (this.valeur != other.valeur) {
            return false;
        }
        return true;
    }
    // APA : Methode equals

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.couleur);
        hash = 47 * hash + Objects.hashCode(this.valeur);
        return hash;
    }
}
