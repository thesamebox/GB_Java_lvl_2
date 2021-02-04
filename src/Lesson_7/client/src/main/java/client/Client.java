package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("ChatMe");
        primaryStage.setScene(new Scene(root, 600, 800));
        primaryStage.show();
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(600);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
