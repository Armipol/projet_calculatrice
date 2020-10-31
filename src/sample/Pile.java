package sample;

import java.util.Stack;

public class Pile extends Stack {

    public void push (double nombre) {
            super.push(nombre);
    }

    public Object pop() {
        if (super.empty()==false) {
            return super.pop();
        } else {
            return "La pile est vide";
        }
    }

    public void drop(){
        if (super.empty()==false) {
            super.pop();
        } else {
            System.out.println("La pile est vide");
        }
    }

    public void swap() {
        if (super.size() > 1) {
            double d1 = (double) super.pop();
            double d2 = (double) super.pop();
            super.push(d1);
            super.push(d2);
        } else {
            System.out.println("Impossible de swaper, il manque des opérandes");
        }
    }

    public void clear(){
        super.clear();
    }

}

