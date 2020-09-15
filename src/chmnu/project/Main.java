package chmnu.project;

import chmnu.project.utils.PageParser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gui/initialize.fxml"));
        primaryStage.setTitle("Data Manager");
        primaryStage.setScene(new Scene(root, 385, 505));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
