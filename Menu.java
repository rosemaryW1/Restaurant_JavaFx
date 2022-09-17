package com.example.restaurant;

import java.io.IOException;
import javafx.application.Application;

import static com.example.restaurant.Test.*;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menu extends Application {
    static Stage menuStage = new Stage();
 @Override
    public void start(Stage stage) throws IOException {
        Label Breakfast_lbl=new Label("BREAKFAST");
        CheckBox eggBox=new CheckBox("Eggs");
        CheckBox breadBox=new CheckBox("Buttered Bread");
        CheckBox blackBox=new CheckBox("Black Coffee");
        CheckBox baconBox=new CheckBox("Bacon");
        CheckBox freshBox=new CheckBox("Fresh juice");
        CheckBox whiteBox=new CheckBox("White Coffee");
        Label lbl = new Label();

        CheckBox chapoBox=new CheckBox("Chapati");
        //CheckBox pilauBox=new CheckBox("Pilau");
        //CheckBox riceBox=new CheckBox("Plain rice and Beef stew");
        //CheckBox chomaBox=new CheckBox("Nyama Choma");
        // CheckBox fishBox=new CheckBox("Ugali and fish");
        //CheckBox mashedBox=new CheckBox("Mashed Potatoes and minced meat ");

        //CheckBox sausageBox=new CheckBox("Sausage");
        CheckBox smochaBox=new CheckBox("Smocha");
        //CheckBox biscuitBox=new CheckBox("Biscuits");
        //CheckBox friesBox=new CheckBox("Fries");
        //CheckBox shakeBox=new CheckBox("Milkshake");

        Button order_btn = new Button("ORDER");
        Button proceed = new Button("PROCEED");

        HBox hbox=new HBox();
        hbox.setSpacing(30);
        hbox.setPadding(new Insets(0,0,0,0));
        hbox.getChildren().addAll(eggBox,breadBox,blackBox,baconBox,whiteBox,chapoBox,smochaBox);




        GridPane gridPane = new GridPane();
        gridPane.setMinSize(750,750);
        gridPane.setVgap(20);
        gridPane.setHgap(40);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(order_btn, 6, 3);

        gridPane.add(hbox,2,3,2,1);
        gridPane.add(eggBox, 1, 1);
        gridPane.add(breadBox, 2, 1);
        gridPane.add(blackBox, 3, 1);
        gridPane.add(baconBox, 4, 1);
        //gridPane.add(friesBox, 5, 1);
        gridPane.add(whiteBox, 6, 1);

        gridPane.add(chapoBox, 1, 2);
        //gridPane.add(pilauBox, 2, 2);
        //gridPane.add(riceBox, 3, 2);
        //gridPane.add(chomaBox, 4, 2);
        //gridPane.add(fishBox, 5, 2);
        //gridPane.add(mashedBox, 6, 2);

        //gridPane.add(sausageBox, 1, 3);
        gridPane.add(smochaBox, 2, 2);


        //gridPane.add(biscuitBox, 3, 3);
        //gridPane.add(friesBox, 4, 3);
        //gridPane.add(shakeBox, 5, 3);


        //To Pilau checkbox
//        eggBox.setOnAction((new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//
//
//            }
//        }));
     EventHandler<ActionEvent> ev = new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
             if (chapoBox.isSelected()) {
                 chapati.amount = 1;

             }

         }
     };
     chapoBox.setOnAction(ev);


        //To smocha checkbox
//        breadBox.setOnAction((new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//
//
//            }
//        }));

     EventHandler<ActionEvent> ev1 = new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
             if (eggBox.isSelected()) {
                 eggs.amount = 1;

             }

         }
     };
     eggBox.setOnAction(ev1);


     EventHandler<ActionEvent> ev2 = new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
             if (breadBox.isSelected()) {
                 butteredbread.amount = 1;

             }

         }
     };
     breadBox.setOnAction(ev2);

     EventHandler<ActionEvent> ev3 = new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
             if (blackBox.isSelected()) {
                 black_coffee.amount = 1;

             }

         }
     };
     blackBox.setOnAction(ev3);

     EventHandler<ActionEvent> ev4 = new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
             if (baconBox.isSelected()) {
                 Bacon.amount = 1;

             }

         }
     };
     baconBox.setOnAction(ev4);

     EventHandler<ActionEvent> ev5 = new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
             if (whiteBox.isSelected()) {
                 white_coffee.amount = 1;

             }

         }
     };
     whiteBox.setOnAction(ev5);

     EventHandler<ActionEvent> ev6 = new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
             if (smochaBox.isSelected()) {
                 smocha.amount = 1;

             }

         }
     };
     smochaBox.setOnAction(ev6);


     order_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
         public void handle(MouseEvent event) {
             int total;
             total = (eggs.amount*eggs.cost) + (butteredbread.amount* butteredbread.cost) + (black_coffee.amount* black_coffee.cost) + (Bacon.amount* Bacon.cost)+(white_coffee.cost* white_coffee.amount) +(chapati.amount* chapati.cost)+(smocha.amount* smocha.cost);
             lbl.setText("Your total is: "+String.valueOf(total));
             gridPane.add(lbl,3,5);
             gridPane.add(proceed,3,6);
         }
     }));

     proceed.setOnMouseClicked((new EventHandler<MouseEvent>() {
         public void handle(MouseEvent event) {
             Payment p = new Payment();
             try {
                 p.start(Payment.paymentStage);
             } catch (Exception e) {
                 e.printStackTrace();
             }

         }
     }));




        // to ensure only one checkbox is selected ??


        Scene scene = new Scene(gridPane);
        stage.setTitle("MENU");
        stage.setScene(scene);
        stage.show();
    }

//    public static void main(String[] args) {
//        launch();
//    }
}
