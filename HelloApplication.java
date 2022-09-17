package com.example.restaurant;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloApplication extends Application {
    static Stage loginStage = new Stage();
    @Override
    public void start(Stage myStage) throws IOException {
        Text username_lbl = new Text("Username: ");
        Text password_lbl = new Text("Password: ");
        Text calltoaction = new Text("Don't have an account?");

        TextField username_tf = new TextField();
        PasswordField pass_tf = (PasswordField) new PasswordField();

        Button login_btn = new Button("LOGIN");
        Button register = new Button("REGISTER");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(800,400);
        gridPane.setVgap(20);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(username_lbl,1,1);
        gridPane.add(password_lbl,1,2);
        gridPane.add(username_tf,2,1);
        gridPane.add(pass_tf,2,2);
        gridPane.add(login_btn,1,3);
        gridPane.add(calltoaction,1,4);
        gridPane.add(register,2,4);

        register.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Registration r = new Registration();
                try {
                    r.start(Registration.registerStage);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }));
        login_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {

                String username = username_tf.getText();
                String password = pass_tf.getText();


                try
                {
                    //Step One - Register the driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    //Step Two - Creating the connection
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/project?","root","");

                    //Step Three - Create the statement object
                    Statement st= con.createStatement();

                    //Step Four - Execute your queries
                    String query = "SELECT * FROM restaurant.user Where Name = '"+username+"' AND Password = '"+password+"' ";
                    ResultSet rs = st.executeQuery(query);

                    if(rs.next())
                    {
                        //You can replace this code with ANY code to be executed after a successfull login
                        //Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                        //al.setContentText("Successful Login");
                        //al.show();
                        System.out.println("Successful Login");
                        Prices p = new Prices();
                        p.start(myStage);
                    }

                    else
                    {
                        Alert al = new Alert(Alert.AlertType.WARNING);
                        al.setContentText("Invalid Credentials");
                        al.show();

                    }

                    //Step five - Closing the connection
                    con.close();

                }
                catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
                {

                }
            }
        }));


        myStage.setTitle("LOGIN");

        Scene my_scene = new Scene(gridPane);

        myStage.setScene(my_scene);
        myStage.show();


    }

//    public static void main(String[] args) {
//        launch();
//   }
}