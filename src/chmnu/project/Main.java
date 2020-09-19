package chmnu.project;

import com.opencsv.CSVWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gui/initialize.fxml"));
        primaryStage.setTitle("Data Manager");
        primaryStage.setScene(new Scene(root, 385, 600));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
