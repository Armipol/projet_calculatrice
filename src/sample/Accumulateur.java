package sample;

import java.util.Stack;

public class Accumulateur implements IAccumulateur {

    //Attribut pour la réalisation de la calculatrice
    String nombre = "";
    Stack pile = new Stack();

    @Override
    public void push() {
        if (nombre.length() > 0) {
            pile.push(Double.parseDouble(nombre));
            nombre = "";
        } else {
            System.out.println("Impossible de push car aucun chiffre");
        }
    }

    @Override
    public void drop() {
        if (pile.size() < 1) {
            System.out.println("Impossible, rien à droper");
        } else
            pile.pop();
    }

    @Override
    public void swap() {
        if (pile.size() < 2) {
            System.out.println("Impossible de swaper, il manque des opérandes");
        } else {
            double d1 = (double) pile.pop();
            double d2 = (double) pile.pop();
            pile.push(d1);
            pile.push(d2);
        }
    }

    @Override
    public void add() {
        if (pile.size() < 2) {
            System.out.println("Impossible d'additioner, il manque des opérandes");
        } else {
            double d1 = (double) pile.pop();
            double d2 = (double) pile.pop();
            pile.push(d1 + d2);
            System.out.println(d1 + d2);
        }
    }

    @Override
    public void sub() {
        if (pile.size() < 2) {
            System.out.println("Impossible de soustraire, il manque des opérandes");
        } else {
            double d1 = (double) pile.pop();
            double d2 = (double) pile.pop();
            pile.push(d1 - d2);
        }
    }

    @Override
    public void mult() {
        if (pile.size() < 2) {
            System.out.println("Impossible de multiplier, il manque des opérandes");
        } else {
            double d1 = (double) pile.pop();
            double d2 = (double) pile.pop();
            pile.push(d1 * d2);
        }
    }

    @Override
    public void div() {
        if (pile.size() < 2) {
            System.out.println("Impossible de diviser, il manque des opérandes");
        } else {
            double d1 = (double) pile.pop();
            double d2 = (double) pile.pop();
            pile.push(d1 / d2);
        }
    }

    @Override
    public void neg() {
        if (pile.size() < 1) {
            System.out.println("Impossible, rien à négativer");
        } else {
            double db = (double) pile.pop();
            pile.push(-db);
        }
    }

    @Override
    public void backspace() {
        if (nombre.length() < 1) {
            System.out.println("Impossible de backspace car pas de chiffre");
        } else {
            nombre = nombre.substring(0, nombre.length() - 1);
        }
    }

    @Override
    public void accumuler(int chiffre) {
        nombre += Integer.toString(chiffre);
    }

    public void accumuler(String dot) {
        nombre += dot;
    }

    @Override
    public void reset() {
        pile.empty();
    }
}
