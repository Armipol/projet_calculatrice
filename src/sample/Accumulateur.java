package sample;

import javafx.scene.control.skin.TooltipSkin;

import java.util.ArrayList;
import java.util.Stack;

public class Accumulateur implements IAccumulateur {

    //Attribut pour la réalisation de la calculatrice
    String nombre = "";
    Stack pile = new Stack();

    @Override
    public void push() {
        pile.push(Double.parseDouble(nombre));
        nombre = "";
    }

    @Override
    public void drop() {
        pile.pop();
    }

    @Override
    public void swap() {
        if (nombre.length() < 2) {
        } else {
            double d1 = (double) pile.pop();
            double d2 = (double) pile.pop();
            pile.push(d1);
            pile.push(d2);
        }
    }

    @Override
    public void add() {
         double d1 = (double) pile.pop();
         double d2 = (double) pile.pop();
         pile.push(d1+d2);
         System.out.println(d1+d2);
    }

    @Override
    public void sub() {
        if (nombre.length() < 2) {
        } else {
            double d1 = (double) pile.pop();
            double d2 = (double) pile.pop();
            pile.push(d1-d2);
        }
    }

    @Override
    public void mult() {
        double d1 = (double) pile.pop();
        double d2 = (double) pile.pop();
        pile.push(d1*d2);
        System.out.println(d1*d2);
    }

    @Override
    public void div() {
        if (nombre.length() < 2) {
        } else {
            double d1 = (double) pile.pop();
            double d2 = (double) pile.pop();
            pile.push(d1/d2);
        }
    }

    @Override
    public void neg() {
        double db = (double) pile.pop();
        pile.push(-db);
    }

    @Override
    public void backspace() {
        if (nombre.length()<1){
        }else{
            nombre = nombre.substring(0, nombre.length() - 1);
        }
    }

    @Override
    public void accumuler(int chiffre) {
        nombre += Integer.toString(chiffre);
    }

    public void accumuler(String dot) {
        nombre+= dot;
    }

    @Override
    public void reset() {
        pile.empty();
    }
}
