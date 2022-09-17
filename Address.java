package com.example.restaurant;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author wakab
 */
public class Address extends Application {
    static Stage addressStage = new Stage();
    @Override
    public void start(Stage myStage) throws Exception {
        Text care_lbl=new Text("HOPE YOU ENJOY OUR DELICACIES!");
        Text delivery_lbl=new Text("**KINDLY PROVIDE US WITH YOUR ADDRESS DETAILS FOR YOUR DELIVERY** ");
        Text Address_lbl=new Text("ADDRESS:"); //Address label
        Text City_lbl=new Text("CITY:"); //City label
        Text State_lbl=new Text("STATE:");//State Label
        Text post_lbl=new Text("POSTAL CODE:"); //Postal Code label
        Text Location_lbl=new Text("LOCATION:"); //Location label


        TextField Address_tf=new TextField(); //User Address text field
        TextField City_tf = new TextField(); //User city text field
        TextField State_tf = new TextField(); //User state text field
        TextField post_tf = new TextField(); //User postal code text field
        TextField Location_tf = new TextField(); //User Location text field

        Button exit_btn = new Button("PROCEED"); //EXIT Button

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(800,800);
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        exit_btn.setAlignment(Pos.CENTER);

        gridPane.add(care_lbl, 1, 1);
        gridPane.add(delivery_lbl, 1, 2);
        gridPane.add(Address_lbl, 1, 3);
        gridPane.add(City_lbl, 1, 4);
        gridPane.add(State_lbl, 1, 5);
        gridPane.add(Location_lbl, 1, 6);
        gridPane.add(exit_btn, 1, 7);

        gridPane.add(Address_tf, 2, 3);
        gridPane.add(City_tf, 2, 4);
        gridPane.add(State_tf, 2, 5);
        gridPane.add(post_tf, 2, 6);

        exit_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Thank t = new Thank();
                t.start(myStage);

            }
        }));

        myStage.setTitle("THE RED GINGER HOTEL");

        Scene my_scene=new Scene(gridPane); //This is our scene

        myStage.setScene(my_scene);
        myStage.show();

    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        launch(args);
//    }
//
}
