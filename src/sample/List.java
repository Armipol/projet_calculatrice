package sample;

import java.util.ArrayList;

public class List {

    private ArrayList liste_affichage;

    public List() {
        liste_affichage = new ArrayList();
    }

    public void add(String str) {
        liste_affichage.add(str);
    }

    public void remove() {
        liste_affichage.remove(liste_affichage.size() - 1);
    }
}
