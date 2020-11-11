package sample;

import java.util.ArrayList;

public interface IView {

    void affiche();
    void change(ArrayList<String> liste_affichage);
    void change(String affichage_direct);
}
