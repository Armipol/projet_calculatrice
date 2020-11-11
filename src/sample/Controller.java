package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.beans.*;

public class Controller extends Application  implements PropertyChangeListener, EventHandler {
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
        }
    }


    public void gestion_bouton(int i) {
        accumulateur.accumuler(i);
    }


    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (propertyChangeEvent.getPropertyName()=="value") {
            view.change((String) propertyChangeEvent.getNewValue());
        }
    }


    @Override
    public void handle(Event event) {

    }
}