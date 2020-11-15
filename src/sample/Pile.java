package sample;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Stack;

/**
 * <h3>La Pile de la Calculatrice</h3>
 * <p>
 * La Pile définit par la suite est le coeur du stockage de notre Calculatrice en notation polonaise inversée. Elle extend la classe Stack et utilise ses méthodes de push, pop et clear en redéfinissant ces dernières pour une utilisation dans l'Accumulateur.
 * De plus, puisqu'elle est le stockage de notre Calculatrice, elle est aussi celle qui va avertir le Controlleur d'une modification éventuelle de son état de stockage, à l'aide des propertyChange.
 *
 * @author Rémi
 * @see Stack
 * @see Controller
 * @see PropertyChangeSupport
 * </p>
 */
public class Pile extends Stack {

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private PropertyChangeSupport pcs2 = new PropertyChangeSupport(this);
    private ArrayList<Double> liste_valeur = new ArrayList<>();

    /**
     * La méthode push permet de faire rentrer une valeur dans la Stack associée.
     * De plus, elle gère l'entrée de la valeur dans la liste des valeurs (liste_valeur).
     *
     * @param nombre un double que l'on souhaite faire entrer dans le stockage de la Pile.
     */
    public void push(double nombre) {
        liste_valeur.add(nombre);
        super.push(nombre);
        transferer();
    }

    /**
     * La méthode pop permet de retirer le dernier élément de la Stack associée afin de le réutiliser.
     * De plus, elle gère la suppression de la valeur dans la liste des valeurs (liste_valeur).
     *
     * @return Un double que l'Accumulateur peut utiliser.
     */
    public Object pop() {
        liste_valeur.remove(liste_valeur.size() - 1);
        transferer();
        return super.pop();
    }

    /**
     * La méthode pop permet de retirer le dernier élément de la Stack associée sans le réutiliser.
     */
    public void drop() {
        transferer();
        pop();
    }

    /**
     * La méthode swap permet permutter les 2 derniers éléments de la Stack associée.
     */
    public void swap() {
        double d1 = (double) pop();
        double d2 = (double) pop();
        transferer();
        push(d1);
        push(d2);
    }

    /**
     * La méthode est_nul est une méthdoe utilisée dans l'Accumulateur pour tester l'avant dernière valeur la Stack.
     * Elle renverra true si l'élément est nul afin d'avertir le test fait de l'Accumulateur.
     *
     * @return boolean représentant l'état de l'avant dernière valeur.
     * @throws Exception e une exception de type OutOfBounds puisque le test peut être appelé pour une Stack vide. Il a donc été choisi de l'encadrer par un try and catch pour bloquer cette exception.
     */
    public Boolean est_nul() {
        try {
            if (liste_valeur.get(liste_valeur.size() - 2) == 0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * La méthode clear permet de vider la Stack associée.
     * De plus, elle gère la suppression des valeurs dans la liste des valeurs (liste_valeur).
     */
    public void clear() {
        liste_valeur.clear();
        transferer();
        super.clear();
    }

    /**
     * @param listener
     * @see PropertyChangeListener
     */

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    /**
     * La méthode transferer permet d'avertir le Controlleur d'une modification dans la liste des valeurs.
     */

    public void transferer() {
        pcs.firePropertyChange("modification", "", liste_valeur);
    }

    public void addKeyListener (PropertyChangeListener key) {
        this.pcs2.addPropertyChangeListener(key);
    }
}

