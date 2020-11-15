package sample;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Stack;

public class Pile extends Stack {

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private ArrayList<Double> liste_valeur = new ArrayList<>();

    public void push(double nombre) {
        liste_valeur.add(nombre);
        super.push(nombre);
        transferer();
    }

    public Object pop() {
        liste_valeur.remove(liste_valeur.size()-1);
        transferer();
        return super.pop();
    }

    public void drop() {
        transferer();
        pop();
    }



    public void swap() {
        double d1 = (double) pop();
        double d2 = (double) pop();
        transferer();
        push(d1);
        push(d2);
    }

    public Boolean est_nul(){
        try {
            if (liste_valeur.get(liste_valeur.size() - 2) == 0) {
                return true;
            }
        } catch(Exception e) {
            return false;
            }
        return false;
    }

    public void clear() {
        liste_valeur.clear();
        transferer();
        super.clear();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void transferer() {
        pcs.firePropertyChange("modification","",liste_valeur);
    }


}

