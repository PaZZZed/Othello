package esi.atl.g53204.cards;

import static java.lang.Integer.parseInt;

/**
 *
 * @author g53204
 */
public class Main {

    public static void main(String[] args) {

        try {
            // APA : Vérifier que 0<n<53
            int n = parseInt(args[0]);
            if (args.length > 1) {
                throw new IllegalStateException("un seul argument necessaire");
            }

            Deck test = new Deck();
            System.out.println(test);
            test.shuffle();
            System.out.println(test);

            for (int i = 0; i < n; i++) {
                System.out.println(test.hit());
            }
            System.out.println(test);
        } catch (IllegalStateException | NullPointerException | NumberFormatException e) {
            System.out.println("changer les arguments svp ");
        }

    }
}
