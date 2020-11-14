package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main {

    public static void main(String[] args) {

        Pile pile = new Pile();
        pile.push(3);
        System.out.println(pile);
        pile.push(4);
        pile.push(5);
        System.out.println(pile);
        pile.swap();
        System.out.println(pile);
        pile.swap();
        System.out.println(pile);
        pile.push(6);
        System.out.println(pile);
        pile.swap();
        System.out.println(pile);
        pile.swap();
        System.out.println(pile);
    }
}
