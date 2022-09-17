package com.example.restaurant;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author wakab
 */
public class Payment extends Application {
    static Stage paymentStage = new Stage();
    @Override
    public void start(Stage myStage) throws Exception {
        Text care_lbl = new Text("HOPE YOU ENJOY OUR DELICACIES!");
        Text pay_lbl = new Text("PLEASE CHOOSE ONE OF THE PAYMENT METHODS BELOW");
        Text mpesa_lbl = new Text("MPESA"); //Mpesa label
        Text till_lbl = new Text("TILL NUMBER"); //Till label
        Text tillNo_lbl = new Text("020345");
        Text visa_lbl = new Text("VISA"); //VISA label
        Text cardN_lbl = new Text("CARD NUMBER:"); //Card No  label
        Text zip_lbl = new Text("ZIP CODE:"); //Zip code label
        Text master_lbl = new Text("MASTERCARD"); //VISA label


        TextField cardN_tf = new TextField(); //User Card No text field
        TextField zip_tf = new TextField(); //User zip code text field

        Button exit_btn = new Button("PROCEED"); //EXIT Button

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(800, 800);
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        exit_btn.setAlignment(Pos.CENTER);


        gridPane.add(care_lbl, 1, 1);
        gridPane.add(pay_lbl, 1, 2);
        gridPane.add(mpesa_lbl, 1, 3);
        gridPane.add(till_lbl, 1, 4);
        gridPane.add(tillNo_lbl, 2, 4);
        gridPane.add(visa_lbl, 1, 5);
        gridPane.add(cardN_lbl, 1, 6);
        gridPane.add(zip_lbl, 1, 7);
        gridPane.add(master_lbl, 1, 8);
        gridPane.add(exit_btn, 1, 9);

        gridPane.add(cardN_tf, 2, 6);
        gridPane.add(zip_tf, 2, 7);

        exit_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Address a = new Address();
                try {
                    a.start(myStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }));

        myStage.setTitle("THE RED GINGER HOTEL");

        Scene my_scene = new Scene(gridPane); //This is our scene

        myStage.setScene(my_scene);
        myStage.show();

    }

    /**
     * @param args
     */
//    public static void main(String args[]) {
//        launch(args);
//    }
}
