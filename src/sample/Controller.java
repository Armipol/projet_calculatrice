package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.beans.*;
import java.util.ArrayList;

/**
 * <h3>Le Controlleur</h3>
 * <p>
 * Le Controlleur est la pièce maitresse de notre Calculatrice dans notre modèle : MCV (Model - Controller - View). Il permet la discussion entre les 2 interfaces et assure la transmission des informations en effectuant des redirections.
 * De plus, il extends la classe Application afin de pouvoir lancer directement la Calculatrice lorsque qu'on l'éxecute.
 * Il est celui qui va créer la View, la Pile et l'Accumulateur dès le début afin de pouvoir controller les 2.
 *
 * @author Rémi
 * @author Mario
 * @see Pile
 * @see Accumulateur
 * @see View
 * @see Application
 * @see PropertyChangeListener
 * </p>
 */

public class Controller extends Application implements PropertyChangeListener, KeyListener {
    Accumulateur accumulateur;
    View view;
    Pile pile;

    @Override
    public void start(Stage primaryStage) throws Exception {
        view = new View(primaryStage, this);
        pile = new Pile();
        accumulateur = new Accumulateur(pile);
        view.affiche();
        accumulateur.addPropertyChangeListener(this);
        pile.addPropertyChangeListener(this);
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * La méthode gestion_bouton permet de recevoir les informations depuis la View pour ensuite les transmettre à l'Accumulateur.
     * C'est une méthode de redirection du flux d'information.
     *
     * @param s Une String de la fonction associée au différent bouton de la View.
     */
    public void gestion_bouton(String s) {
        if (s == "(-)") {
            accumulateur.neg();
        } else if (s == "+") {
            accumulateur.add();
        } else if (s == "-") {
            accumulateur.sub();
        } else if (s == "*") {
            accumulateur.mult();
        } else if (s == "/") {
            accumulateur.div();
        } else if (s == "back") {
            accumulateur.backspace();
        } else if (s == "push") {
            accumulateur.push();
        } else if (s == ".") {
            accumulateur.accumuler(".");
        } else if (s == "swap") {
            accumulateur.swap();
        } else if (s == "drop") {
            accumulateur.drop();
        } else if (s == "clear") {
            accumulateur.clear();
        } else if (s == "cos") {
            accumulateur.cos();
        } else if (s == "sin") {
            accumulateur.sin();
        } else if (s == "tan") {
            accumulateur.tan();
        }
    }

    /**
     * La méthode gestion_bouton permet de recevoir les informations depuis la View pour ensuite les transmettre à l'Accumulateur.
     * C'est une méthode de redirection du flux d'information.
     *
     * @param i Un int qui doit être accumulé.
     */
    public void gestion_bouton(int i) {
        accumulateur.accumuler(i);
    }

    /**
     * Cette méthode permet l'écoute des modifications dans l'Accumulateur et la Pile.
     *
     * @param propertyChangeEvent qui contient les valeurs à communiquer à la View.
     * @see PropertyChangeListener
     */
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (propertyChangeEvent.getPropertyName() == "value") {
            view.change((String) propertyChangeEvent.getNewValue());
        }
        if (propertyChangeEvent.getPropertyName() == "error") {
            view.change((String) propertyChangeEvent.getNewValue());
        }
        if (propertyChangeEvent.getPropertyName() == "modification") {
            view.change((ArrayList<Double>) propertyChangeEvent.getNewValue());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("YOOO");

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("YOOO");

    }


    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("YOOO");
    }

}