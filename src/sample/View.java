package sample;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class View implements IView {
    Stage st;
    ArrayList<String> liste_affichage;
    Label affichage_erreur = new Label("..");
    Label affichage_direct = new Label("..");
    Label affichage_pre = new Label("..");
    Label affichage_2_pre = new Label("..");

    Controller view_control;

    public View(Stage st, Controller controller) throws Exception {
        //Definition de la page
        this.st = st;
        view_control = controller;
    }

    @Override
    public void affiche() {
        st.setTitle("Calculatrice");
        //Création de l'architecture de la page
        VBox calculatrice = new VBox();
        VBox calcultrice_affichage = new VBox();
        GridPane calculatrice_boutons = new GridPane();

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
        Button b_sub = new Button("-");
        Button b_mult = new Button("x");
        Button b_div = new Button("/");
        Button b_push = new Button("⏎");
        Button b_backspace = new Button("⌫");
        Button b_swap = new Button("↔");
        Button b_drop = new Button("⏏");
        Button b_clear = new Button("⌧");
        Button b_dot = new Button(".");
        Button b_cos = new Button("cos°");
        Button b_sin = new Button("sin°");
        Button b_tan = new Button("tan°");

        //Implémentation des touches ( calculatrice.add(column, row) )
        calculatrice_boutons.add(b7, 0, 1);
        calculatrice_boutons.add(b8, 1, 1);
        calculatrice_boutons.add(b9, 2, 1);
        calculatrice_boutons.add(b4, 0, 2);
        calculatrice_boutons.add(b5, 1, 2);
        calculatrice_boutons.add(b6, 2, 2);
        calculatrice_boutons.add(b1, 0, 3);
        calculatrice_boutons.add(b2, 1, 3);
        calculatrice_boutons.add(b3, 2, 3);
        calculatrice_boutons.add(b0, 0, 4);
        calculatrice_boutons.add(b_dot, 1, 4);
        calculatrice_boutons.add(b_backspace, 4, 1);
        calculatrice_boutons.add(b_add, 3, 1);
        calculatrice_boutons.add(b_sub, 3, 2);
        calculatrice_boutons.add(b_mult, 3, 3);
        calculatrice_boutons.add(b_div, 3, 4);
        calculatrice_boutons.add(b_neg, 2, 4);
        calculatrice_boutons.add(b_push, 4, 2);
        calculatrice_boutons.add(b_swap, 4, 3);
        calculatrice_boutons.add(b_drop, 4, 4);
        calculatrice_boutons.add(b_clear, 5, 1);
        calculatrice_boutons.add(b_cos, 5, 2);
        calculatrice_boutons.add(b_sin, 5, 3);
        calculatrice_boutons.add(b_tan, 5, 4);

        //Création des actions des boutons
        b0.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton(0);
                });
        b1.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton(1);
                });
        b2.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton(2);
                });
        b3.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton(3);
                });
        b4.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton(4);
                });
        b5.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton(5);
                });
        b6.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton(6);
                });
        b7.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton(7);
                });
        b8.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton(8);
                });
        b9.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton(9);
                });
        b_add.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton("+");
                });
        b_backspace.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton("back");
                });
        b_div.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton("/");
                });
        b_mult.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton("*");
                });
        b_neg.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton("(-)");
                });
        b_push.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton("push");
                });
        b_sub.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton("-");
                });
        b_swap.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton("swap");
                });
        b_drop.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton("drop");
                });
        b_clear.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton("clear");
                });
        b_dot.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton(".");
                });

        b_cos.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton("cos");
                });

        b_sin.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton("sin");
                });

        b_tan.addEventHandler(ActionEvent.ACTION,
                e -> {
                    view_control.gestion_bouton("tan");
                });




        //Style des boutons
        b0.getStyleClass().add("glass-grey");
        b1.getStyleClass().add("glass-grey");
        b2.getStyleClass().add("glass-grey");
        b3.getStyleClass().add("glass-grey");
        b4.getStyleClass().add("glass-grey");
        b5.getStyleClass().add("glass-grey");
        b6.getStyleClass().add("glass-grey");
        b7.getStyleClass().add("glass-grey");
        b8.getStyleClass().add("glass-grey");
        b9.getStyleClass().add("glass-grey");
        b_dot.getStyleClass().add("glass-grey");
        b_add.getStyleClass().add("glass-grey");
        b_neg.getStyleClass().add("glass-grey");
        b_mult.getStyleClass().add("glass-grey");
        b_backspace.getStyleClass().add("glass-grey");
        b_div.getStyleClass().add("glass-grey");
        b_push.getStyleClass().add("glass-grey");
        b_sub.getStyleClass().add("glass-grey");
        b_swap.getStyleClass().add("glass-grey");
        b_drop.getStyleClass().add("glass-grey");
        b_clear.getStyleClass().add("glass-grey");
        b_cos.getStyleClass().add("glass-grey");
        b_sin.getStyleClass().add("glass-grey");
        b_tan.getStyleClass().add("glass-grey");

        //Style des Label
        calculatrice.setAlignment(Pos.CENTER);
        calculatrice.setStyle("-fx-font-size: 1.5em ; ");
        calcultrice_affichage.setAlignment(Pos.CENTER_RIGHT);

        //Gestion du style de la GridPane
        calculatrice_boutons.getStylesheets().add("sample/calculatrice.css");
        calculatrice_boutons.getStyleClass().add("main");
        calculatrice_boutons.setHgap(20);
        calculatrice_boutons.setVgap(20);


        //Incrémentation dans la page
        calculatrice.getChildren().add(new Label("Calculatrice de Mario et Rémi"));
        calcultrice_affichage.getChildren().add(affichage_erreur);
        calcultrice_affichage.getChildren().add(affichage_2_pre);
        calcultrice_affichage.getChildren().add(affichage_pre);
        calcultrice_affichage.getChildren().add(affichage_direct);
        calculatrice.getChildren().add(calcultrice_affichage);
        calculatrice.getChildren().add(calculatrice_boutons);
        Scene scene_principal = new Scene(calculatrice);
        st.setScene(scene_principal);
        st.show();
    }

    @Override
    public void change(ArrayList<Double> liste_affichage) {
        int len = liste_affichage.size();
        if (len > 1) {
            this.affichage_pre.setText(String.valueOf(liste_affichage.get(len - 1)));
            this.affichage_2_pre.setText(String.valueOf(liste_affichage.get(len - 2)));
        }
        if (len > 0 & len < 2) {
            this.affichage_2_pre.setText("..");
            this.affichage_pre.setText(String.valueOf(liste_affichage.get(len - 1)));
        }
        if (len == 0) {
            this.affichage_pre.setText("..");
            this.affichage_2_pre.setText("..");
        }
    }

    @Override
    public void change(String affichage_direct) {
        this.affichage_direct.setText(affichage_direct);
    }

}
