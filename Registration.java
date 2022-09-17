package com.example.restaurant;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import java.sql.Statement;

public class Registration extends Application {
    static Stage registerStage = new Stage();
    @Override
    public void start(Stage myStage) throws IOException {
        Text username_lbl = new Text("Username: ");
        Text password_lbl = new Text(" Set Password: ");
        Text fname_lbl = new Text("First Name: ");
        Text sname_lbl = new Text("Surname: ");
        Text email_lbl = new Text("Email: ");

        TextField username_tf = new TextField();
        TextField fname_tf = new TextField();
        TextField sname_tf = new TextField();
        TextField email_tf = new TextField();

        PasswordField password = new PasswordField();

        Button register_btn = new Button("REGISTER");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(800,400);
        gridPane.setVgap(20);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(fname_lbl,1,1);
        gridPane.add(sname_lbl,1,2);
        gridPane.add(username_lbl,1,3);
        gridPane.add(email_lbl,1,4);
        gridPane.add(password_lbl,1,5);
        gridPane.add(register_btn,1,6);
        gridPane.add(fname_tf,2,1);
        gridPane.add(sname_tf,2,2);
        gridPane.add(username_tf,2,3);
        gridPane.add(email_tf,2,4);
        gridPane.add(password,2,5);

        register_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {

                String username = username_tf.getText();
                String pass = password.getText();


                try
                {
                    //Step One - Register the driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    //Step Two - Creating the connection
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/project?","root","");

                    //Step Three - Create the statement object
                    Statement st= con.createStatement();

                    //Step Four - Execute your queries
                    String query = "INSERT INTO restaurant.user (Name,Password) VALUES ('"+username+"','"+pass+"') ";
                    boolean rs = st.execute(query);

                    if(rs=true){
                        System.out.println("Update Successful.");
                        HelloApplication login = new HelloApplication();
                        login.start(HelloApplication.loginStage);
                    }

//                    if(rs.next())
//                    {
//                        //You can replace this code with ANY code to be executed after a successfull login
//                        //Alert al = new Alert(Alert.AlertType.CONFIRMATION);
//                        //al.setContentText("Successful Login");
//                        //al.show();
//                        System.out.println("Successful Update");
//                    }
//
//                    else
//                    {
//                        Alert al = new Alert(Alert.AlertType.WARNING);
//                        al.setContentText("Invalid Credentials");
//                        al.show();
//
//                    }

                    //Step five - Closing the connection
                    con.close();

                }
                catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
                {

                }
            }
        }));

        myStage.setTitle("REGISTER");

        Scene my_scene = new Scene(gridPane);

        myStage.setScene(my_scene);
        myStage.show();


    }
}
