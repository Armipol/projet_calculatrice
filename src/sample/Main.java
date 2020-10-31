package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main {

    public static void main(String[] args) {
        Pile pile = new Pile();
        pile.push(3);
        System.out.println(pile);
        pile.drop();
        System.out.println(pile);
        pile.push(2);
        System.out.println(pile);
        System.out.println(pile.pop());
        System.out.println(pile);
        pile.push(4);
        System.out.println(pile);
        pile.push(1);
        pile.swap();
        System.out.println(pile);
        pile.pop();
        System.out.println(pile.pop());
        System.out.println(pile);
        pile.push(2.1);
        System.out.println(pile);
        pile.clear();
        System.out.println(pile);
        System.out.println(pile.empty());
        System.out.println(pile.pop());
    }
}
