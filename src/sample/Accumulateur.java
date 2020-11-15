package sample;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Accumulateur implements IAccumulateur {

    private String value = "";
    private String nombre = "";
    public Pile pile;
    private String error = "";
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

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
            error="";
        }
    }

    @Override
    public void swap() {
        if (pile.size() < 2) {
            error = "Impossible de swapper, il manque des chiffres";
            afficher_error(error);
        } else {
            pile.swap();
            error="";
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
            error="";
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
            error="";
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
            error="";
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
                error="";
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
            error="";
        }
    }

    public void cos() {
        if (pile.size() < 1) {
            error = "Impossible, rien à mettre dans le cos";
            afficher_error(error);
        } else {
            double db = (double) pile.pop();
            pile.push(Math.cos(db));
            error="";
        }
    }

    public void sin() {
        if (pile.size() < 1) {
            error = "Impossible, rien à mettre dans le sin";
            afficher_error(error);
        } else {
            double db = (double) pile.pop();
            pile.push(Math.sin(db));
            error="";
        }
    }

    public void tan() {
        if (pile.size() < 1) {
            error = "Impossible, rien à mettre dans le tan";
            afficher_error(error);
        } else {
            double db = (double) pile.pop();
            pile.push(Math.tan(db));
            error="";
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
            error="";
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
    public void reset() {
        pile.clear();
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String s_affiche) {
        String oldValue = this.value;
        this.value = s_affiche;
        pcs.firePropertyChange("value", oldValue, s_affiche);
    }

    public void afficher_error(String err) {
        pcs.firePropertyChange("error", "", err);
    }


}
