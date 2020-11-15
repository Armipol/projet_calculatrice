package sample;

import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * <h3>L'Accumulateur</h3>
 * <p>
 * En plus des informations fournis par le Javadoc de l'interface Accumulateur, ce Javadoc va décrire la relation avec la Pile et le Controlleur.
 *
 * @author Mario
 * @see Pile
 * @see Controller
 * </p>
 */


public class Accumulateur implements IAccumulateur {

    private String value = "";
    private String nombre = "";
    public Pile pile;
    private String error = "";
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private PropertyChangeSupport pcs2 = new PropertyChangeSupport(this);

    /**
     * Le constructeur affecte à l'Accumulateur la Pile dont il à besoin pour stocker ses résultats.
     *
     * @param pile une pile définit par la classe Pile.
     */
    public Accumulateur(Pile pile) {
        this.pile = pile;
    }

    @Override
    public void push() {
        if (nombre.length() > 0) {
            pile.push(Double.parseDouble(nombre));
            setValue("");
            nombre = "";
            error = "";
        } else {
            error = "Impossible de push car aucun chiffre";
            afficher_error(error);
        }
    }

    @Override
    public void drop() {
        if (pile.size() < 1) {
            error = "Impossible, rien à droper";
            afficher_error(error);
        } else {
            pile.drop();
            error = "";
        }
    }

    @Override
    public void swap() {
        if (pile.size() < 2) {
            error = "Impossible de swapper, il manque des chiffres";
            afficher_error(error);
        } else {
            pile.swap();
            error = "";
        }
    }

    @Override
    public void add() {
        if (pile.size() < 2) {
            error = "Impossible d'additioner, il manque des opérandes";
            afficher_error(error);
        } else {
            double d1 = (double) pile.pop();
            double d2 = (double) pile.pop();
            pile.push(d1 + d2);
            error = "";
        }
    }

    @Override
    public void sub() {
        if (pile.size() < 2) {
            error = "Impossible de soustraire, il manque des opérandes";
            afficher_error(error);
        } else {
            double d1 = (double) pile.pop();
            double d2 = (double) pile.pop();
            pile.push(d1 - d2);
            error = "";
        }
    }

    @Override
    public void mult() {
        if (pile.size() < 2) {
            error = "Impossible de multiplier, il manque des opérandes";
            afficher_error(error);
        } else {
            double d1 = (double) pile.pop();
            double d2 = (double) pile.pop();
            pile.push(d1 * d2);
            error = "";
        }
    }

    @Override
    public void div() {
        if (pile.est_nul()) {
            error = "On ne divise pas par 0";
            afficher_error(error);
        } else {
            if (pile.size() < 2) {
                error = "Impossible de diviser, il manque des opérandes";
                afficher_error(error);
            } else {
                double d1 = (double) pile.pop();
                double d2 = (double) pile.pop();
                pile.push(d1 / d2);
                error = "";
            }
        }
    }

    @Override
    public void neg() {
        if (pile.size() < 1) {
            error = "Impossible, rien à négativer";
            afficher_error(error);
        } else {
            double db = (double) pile.pop();
            pile.push(-db);
            error = "";
        }
    }

    /**
     * La méthode cos permet de faire calculer la valeur du cosinus associé à la dernière valeur push dans la Pile.
     */
    public void cos() {
        if (pile.size() < 1) {
            error = "Impossible, rien à mettre dans le cos";
            afficher_error(error);
        } else {
            double db = (double) pile.pop();
            pile.push(Math.cos(db));
            error = "";
        }
    }

    /**
     * La méthode sin permet de faire calculer la valeur du sinus associé à la dernière valeur push dans la Pile.
     */
    public void sin() {
        if (pile.size() < 1) {
            error = "Impossible, rien à mettre dans le sin";
            afficher_error(error);
        } else {
            double db = (double) pile.pop();
            pile.push(Math.sin(db));
            error = "";
        }
    }

    /**
     * La méthode tan permet de faire calculer la valeur du tangeante associé à la dernière valeur push dans la Pile.
     */
    public void tan() {
        if (pile.size() < 1) {
            error = "Impossible, rien à mettre dans le tan";
            afficher_error(error);
        } else {
            double db = (double) pile.pop();
            pile.push(Math.tan(db));
            error = "";
        }
    }

    @Override
    public void backspace() {
        if (nombre.length() < 1) {
            error = "Impossible de backspace car pas de chiffre";
            afficher_error(error);
        } else {
            nombre = nombre.substring(0, nombre.length() - 1);
            setValue(nombre);
            error = "";
        }
    }

    @Override
    public void accumuler(int chiffre) {
        nombre += Integer.toString(chiffre);
        setValue(nombre);
    }

    public void accumuler(String dot) {
        nombre += dot;
        setValue(nombre);
    }

    @Override
    public void clear() {
        pile.clear();
    }

    /**
     * @param listener
     * @see PropertyChangeListener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public String getValue() {
        return value;
    }

    /**
     * La méthode setValue permet de prévenir l'Accumulateur des changements pour l'affichage direct.
     *
     * @param s_affiche la valeur de l'affichage direct. Il est l'équivalent de nombre mais pour être envoyé à l'Accumulateur.
     */
    public void setValue(String s_affiche) {
        String oldValue = this.value;
        this.value = s_affiche;
        pcs.firePropertyChange("value", oldValue, s_affiche);
    }

    /**
     * La méthode afficher_error est celle qui va permettre au Controlleur de savoir si des erreurs sont repérées dans l'Accumulateur pour ensuite les faire parvenir à la View et avertir l'utilisateur.
     *
     * @param err une String représentant l'erreur à afficher
     */
    public void afficher_error(String err) {
        pcs.firePropertyChange("error", "", err);
    }

    public void addKeyListener (PropertyChangeListener key) {
        this.pcs2.addPropertyChangeListener(key);
    }


}
