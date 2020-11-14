package sample;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Stack;

public class Pile extends Stack {

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    public ArrayList<Double> liste_valeur = new ArrayList<>();

    public void push(double nombre) {
        liste_valeur.add(nombre);
        super.push(nombre);
        transferer();
    }

    public Object pop() {
        if (!super.empty()) {
            liste_valeur.remove(liste_valeur.size()-1);
            transferer();
            return super.pop();
        } else {
            return "La pile est vide";
        }
    }

    public void drop() {
        if (!super.empty()) {
            liste_valeur.remove(liste_valeur.size()-1);
            transferer();
            super.pop();
        } else {
            System.out.println("La pile est vide");
        }
    }

    public void swap() {
        if (super.size() > 1) {
            double d1 = (double) super.pop();
            double d2 = (double) super.pop();
            liste_valeur.remove(d1);
            liste_valeur.remove(d2);
            liste_valeur.add(d2);
            liste_valeur.add(d1);
            transferer();
            super.push(d1);
            super.push(d2);
        } else {
            System.out.println("Impossible de swaper, il manque des opérandes");
        }
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
        pcs.firePropertyChange("modification","","modification");
    }


}

