package org.bluebird.Utils;

import javafx.scene.control.Alert;

public class SecondaryWindowsInit implements WindowsInit{

    private SecondaryWindowsInit(String msg) {
        WindowsInitializer(msg);
    }

    @Override
    public void WindowsInitializer(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info do Jogo");
        alert.setContentText(msg);
        alert.setHeaderText("Fim de Jogo");
        alert.show();
    }

    public static void winnerWindow(String msg) {
        new SecondaryWindowsInit(msg);
    }
}
