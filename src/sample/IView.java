package sample;

import java.util.List;

public interface IView {

    void affiche();
    void change(List<String> liste_affichage);
    void change(String affichage_direct);
}
