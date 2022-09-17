package com.example.restaurant;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Thank extends Application{
    static Stage thankStage = new Stage();
    public void start(Stage stage) {
        Text text = new Text();


        text.setText("THANK YOU FOR DINING WITH US. " +
                "WELCOME BACK");


        text.setX(50);
        text.setY(50);

        Group root = new Group(text);
        Scene scene = new Scene(root, 600, 300);


        stage.setTitle("RED GINGER");
        stage.setScene(scene);

        stage.show();
    }
//    public static void main(String args []){
//        launch(args);
//    }
}
