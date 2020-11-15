package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.beans.*;
import java.sql.SQLOutput;
import java.util.ArrayList;


public class Controller extends Application implements ActionListener, PropertyChangeListener, EventHandler, KeyListener {
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println(key);
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}