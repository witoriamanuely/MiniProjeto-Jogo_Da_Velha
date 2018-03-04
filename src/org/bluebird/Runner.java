package org.bluebird;

import javafx.application.Application;
import javafx.stage.Stage;
import org.bluebird.Utils.PrimaryWindowsInit;

public class Runner extends Application {

    public void start(Stage primaryStage) {
        PrimaryWindowsInit.loginWindow();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
