package sample;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {
    Stage st;

    public View(Stage stage) throws Exception {
        //Définition de la page
        st = stage;
        st.setTitle("Calculatrice");

        //Création de l'architecture de la page
        GridPane calculatrice = new GridPane();

        //Création de l'un label général de la page
        Label bienvenue = new Label("Bienvenue sur la calculatrice de Rémi & Mario");

        //Création des boutons
        Button b1 = new Button("1");
        Button b2 = new Button("2");
        Button b3 = new Button("3");
        Button b4 = new Button("4");
        Button b5 = new Button("5");
        Button b6 = new Button("6");
        Button b7 = new Button("7");
        Button b8 = new Button("8");
        Button b9 = new Button("9");
        Button b0 = new Button("0");
        Button b_neg = new Button("(-)");
        Button b_add = new Button("+");
        Button b_sub = new Button ("-");
        Button b_mult = new Button ("x");
        Button b_div = new Button ("/");
        Button b_push = new Button ("⏎");
        Button b_backspace = new Button ("⌫");

        //Implémentation des touches ( calculatrice.add(column, row) )
        calculatrice.add(b7, 0, 0);
        calculatrice.add(b8, 1, 0);
        calculatrice.add(b9, 2, 0);
        calculatrice.add(b4, 0, 1);
        calculatrice.add(b5, 1, 1);
        calculatrice.add(b6, 2, 1);
        calculatrice.add(b1, 0, 2);
        calculatrice.add(b2, 1, 2);
        calculatrice.add(b3, 2, 2);
        calculatrice.add(b0,0, 3);
        calculatrice.add(b_backspace, 4,0);
        calculatrice.add(b_add,3,0);
        calculatrice.add(b_sub,3,1);
        calculatrice.add(b_mult,3,2);;
        calculatrice.add(b_div,3,3);;
        calculatrice.add(b_neg,2,3);
        calculatrice.add(b_push,4,1);


        //Implementation dans la VBOx
        ;

        //Création des actions des bouttons


        //Incrémentation dans la page
        Scene scene_principal = new Scene(calculatrice);
        stage.setScene(scene_principal);
        stage.show();
    }
}
