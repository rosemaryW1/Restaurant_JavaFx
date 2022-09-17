package com.example.restaurant;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Prices extends Application {
    static Stage priceStage = new Stage();
    public void start(Stage stage) {
        Text text = new Text("Eggs ksh25");
        Text text1 = new Text("Buttered Bread ksh50");
        Text text2 = new Text("Black coffee ksh200");
        Text text3 = new Text("Bacon ksh50");
        Text text4 = new Text("White coffee ksh250");
        Text text5 = new Text("Chapati ksh20");
        Text text6 = new Text("Smocha ksh100");


        text.setText("Eggs ksh25");
        text1.setText("Buttered Bread ksh50");
        text2.setText("Black coffee ksh200");
        text3.setText("Bacon ksh50");
        text4.setText("White coffee ksh250");
        text5.setText("Chapati ksh20");
        text6.setText("Smocha ksh100");
        Button ordernow = new Button("ORDER NOW");
        VBox root=new VBox();
        root.getChildren().addAll(text,text1,text2,text3,text4,text5,text6,ordernow);
        root.setSpacing(10);
        root.setStyle("-fx-padding:10;"+
                "-fx_border-style:solid inside;"+
                "-fx-border-width:2;"+
                "-fx-border-insets:2;"+
                "-fx-border-radius:2;"+
                "-fx-border-color:yellow;");

        ordernow.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Menu m = new Menu();
                try {
                    m.start(stage);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }));
        Scene scene=new Scene(root,600,400);
        stage.setScene(scene);
        stage.setTitle("Menu Prices");
        stage.show();
    }
//    public  static void main(String args[]){
//        launch(args);
//    }
}
