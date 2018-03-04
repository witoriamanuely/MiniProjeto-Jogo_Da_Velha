package org.bluebird.Utils;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public interface WindowsInit {

    void WindowsInitializer(String path);

    static void closeCurrentWindow(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
}
