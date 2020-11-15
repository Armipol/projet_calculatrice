package sample;

import java.util.ArrayList;

/**
 * <h3>Interface de la View -- Interface graphique de notre calculatrice</h3>
 * <p>
 * L'interface View définie les standards de la partie affichage de notre calculatrice. Elle définie les méthodes nécessaires pour le bon fonctionnement de cette dernière.
 * L'interface possède un constructeur par d * De plus, il fonctionne avec un Controlleur.
éfaut.
 * Une classe implémentée par cette interface fonctionne de pair avec un Controlleur.
 *
 * @author Rémi
 * @author Mario
 * @see Controller
 * </p>
 */


public interface IView {
    /**
     * La méthode affiche permet de lancer l'interface graphique au lancement de la Calculatrice.
     */
    void affiche();

    /**
     * La méthode change permet de faire les changements en direct sur l'interface graphique lorsque la Pile ou l'Accumulateur est modifié.
     * Cette méthode ci est utilisé pour afficher les derniers résultats, ceux qui ont déjà été push dans la Pile.
     *
     * @param liste_affichage une ArrayList des valeurs dans la Pile.
     */
    void change(ArrayList<Double> liste_affichage);

    /**
     * La méthode change permet de faire les changements en direct sur l'interface graphique lorsque la Pile ou l'Accumulateur est modifié.
     * Cette méthode ci est utilisé pour afficher le nombre qui est crée en direct avec les boutons de la View, celui qu'on souhaite push par la suite.
     *
     * @param affichage_direct une String qui représente la valeur accumulée dans l'Accumulateur.
     */
    void change(String affichage_direct);
}
