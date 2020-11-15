package sample;

/**
 * <h3>Interface de l'Accumulateur</h3>
 * <p>
 * L'interface Accumulateur définie les standards de la partie réflexive de notre calculatrice. Elle définie les méthodes nécessaires pour le bon fonctionnement de cette dernière.
 * L'interface possède un constructeur par défaut.
 * Une classe implémentée par cette interface fonctionne de pair avec une Pile.
 * De plus, il fonctionne avec un Controlleur.
 *
 * @author Rémi
 * @author Mario
 * @see Pile
 * @see Controller
 * </p>
 */

interface IAccumulateur {
    /**
     * La méthode push permet de faire rentrer une valeur dans la Pile associée à l'Accumulateur.
     */
    void push();

    /**
     * La méthode drop permet de supprimer le dernier élément de la Pile associée à l'Accumulateur.
     */
    void drop();

    /**
     * La méthode swap permet d'inverser les 2 derniers éléments de la Pile associée à l'Accumulateur.
     */
    void swap();

    /**
     * La méthode add permet d'additionner les 2 derniers éléments de la Pile associée à l'Accumulateur.
     */
    void add();

    /**
     * La méthode sub permet de soustraire les 2 derniers éléments de la Pile associée à l'Accumulateur.
     */
    void sub();

    /**
     * La méthode mult permet de multiplier les 2 derniers éléments de la Pile associée à l'Accumulateur.
     */
    void mult();

    /**
     * La méthode div permet de diviser le dernier élément par l'avant dernier élément de la Pile associée à l'Accumulateur.
     */
    void div();

    /**
     * La méthode neg permet de négativer le dernier élément de la Pile associée à l'Accumulateur.
     */
    void neg();

    /**
     * La méthode backspace permet de modifier le nombre que l'on va push dans la Pile associée à l'Accumulateur. Il s'agit d'une méthode de suppression du dernier chiffre entré avant le push dans la Pile.
     */
    void backspace();

    /**
     * La méthode accumuler permet de créer le nombre que l'on souhaite faire entrer dans la Pile associée à l'Accumulateur.
     *
     * @param chiffre un entier naturel pour créer les nombres souhaités.
     */
    void accumuler(int chiffre);

    /**
     * La méthode accumuler permet de créer le nombre que l'on souhaite faire entrer dans la Pile associée à l'Accumulateur.
     *
     * @param dot un String qui est le plus souvent un point pour créer des nomrbes réels.
     */
    void accumuler(String dot);

    /**
     * La méthode clear permet de vider la Pile associée à l'Accumulateur.
     */
    void clear();
}
