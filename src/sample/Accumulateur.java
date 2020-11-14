package sample;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Accumulateur implements IAccumulateur {

    private String value = "";
    private String nombre = "";
    public Pile pile;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Accumulateur(Pile pile){
        this.pile = pile;    }

    @Override
    public void push() {
        if (nombre.length() > 0) {
            pile.push(Double.parseDouble(nombre));
            setValue("");
            nombre = "";
        } else {
            System.out.println("Impossible de push car aucun chiffre");
        }
    }

    @Override
    public void drop() {
        if (pile.size() < 1) {
            System.out.println("Impossible, rien à droper");
        } else
            pile.drop();
    }

    @Override
    public void swap() {
        pile.swap();
    }

    @Override
    public void add() {
        if (pile.size() < 2) {
            System.out.println("Impossible d'additioner, il manque des opérandes");
        } else {
            double d1 = (double) pile.pop();
            double d2 = (double) pile.pop();
            pile.push(d1 + d2);
        }
    }

    @Override
    public void sub() {
        if (pile.size() < 2) {
            System.out.println("Impossible de soustraire, il manque des opérandes");
        } else {
            double d1 = (double) pile.pop();
            double d2 = (double) pile.pop();
            pile.push(d1 - d2);
        }
    }

    @Override
    public void mult() {
        if (pile.size() < 2) {
            System.out.println("Impossible de multiplier, il manque des opérandes");
        } else {
            double d1 = (double) pile.pop();
            double d2 = (double) pile.pop();
            pile.push(d1 * d2);
        }
    }

    @Override
    public void div() {
        if (pile.size() < 2) {
            System.out.println("Impossible de diviser, il manque des opérandes");
        } else {
            double d1 = (double) pile.pop();
            double d2 = (double) pile.pop();
            pile.push(d1 / d2);
        }
    }

    @Override
    public void neg() {
        if (pile.size() < 1) {
            System.out.println("Impossible, rien à négativer");
        } else {
            double db = (double) pile.pop();
            pile.push(-db);
        }
    }

    @Override
    public void backspace() {
        if (nombre.length() < 1) {
            System.out.println("Impossible de backspace car pas de chiffre");
        } else {
            nombre = nombre.substring(0, nombre.length() - 1);
            setValue(nombre);
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



}
