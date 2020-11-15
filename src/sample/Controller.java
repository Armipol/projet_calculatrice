package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import java.awt.event.KeyListener;

import java.beans.*;
import java.util.ArrayList;

public class Controller extends Application implements PropertyChangeListener, EventHandler {
    Accumulateur accumulateur;
    View view;
    Pile pile;

    @Override
    public void start(Stage primaryStage) throws Exception{
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
            accumulateur.reset();
        } else if (s == "cos") {
            accumulateur.cos();
        } else if (s == "sin") {
            accumulateur.sin();
        } else if (s == "tan") {
            accumulateur.tan();
        }
    }

    public void gestion_bouton(int i) {
        accumulateur.accumuler(i);
    }

    public void gestion_clavier (String c){
        if (c == "(-)") {
            accumulateur.neg();
        } else if (c == "+") {
            accumulateur.add();
        } else if (c == "-") {
            accumulateur.sub();
        } else if (c == "*") {
            accumulateur.mult();
        } else if (c == "/") {
            accumulateur.div();
        } else if (c == "back") {
            accumulateur.backspace();
        } else if (c == "push") {
            accumulateur.push();
        } else if (c == ".") {
            accumulateur.accumuler(".");
        } else if (c == "swap") {
            accumulateur.swap();
        } else if (c == "drop") {
            accumulateur.drop();
        } else if (c == "clear") {
            accumulateur.reset();
        }
    }
    public void gestion_clavier(int i) {
        accumulateur.accumuler(i);
    }


    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (propertyChangeEvent.getPropertyName()=="value") {
            view.change((String) propertyChangeEvent.getNewValue());
        }
        if (propertyChangeEvent.getPropertyName()=="error") {
            view.change((String) propertyChangeEvent.getNewValue());
        }
        if (propertyChangeEvent.getPropertyName()=="modification") {
            view.change((ArrayList<Double>) propertyChangeEvent.getNewValue());
        }
    }

    @Override
    public void handle(Event event) {

    }
}