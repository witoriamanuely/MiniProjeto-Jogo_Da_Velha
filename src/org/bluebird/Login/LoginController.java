package org.bluebird.Login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.bluebird.Utils.PrimaryWindowsInit;
import org.bluebird.Utils.WindowsInit;

public class LoginController {

    private LoginModel loginModel = new LoginModel();
    private static String User1;
    private static String User2;

    @FXML
    private TextField player1Name;

    @FXML
    private TextField player2Name;

    @FXML
    private Button loginButton;

    @FXML
    private Label player1Status;

    @FXML
    private Label player2Status;

    public static String getUser1() {
        return User1;
    }

    public static String getUser2() {
        return User2;
    }

    @FXML
    public void login() {
        player1Status.setText("");
        player2Status.setText("");

        if (this.loginModel.usernameIsEmpty(this.player1Name.getText())) {
            player1Status.setText("Change username");
        } else if (this.loginModel.usernameIsEmpty(this.player2Name.getText())) {
            player2Status.setText("Change username");
        } else if(this.loginModel.isEqual(this.player1Name.getText(), this.player2Name.getText())) {
            player1Status.setText("Same username");
            player2Status.setText("Same username");
        } else {
            LoginController.User1 = this.player1Name.getText();
            LoginController.User2 = this.player2Name.getText();
            loginModel.checkAccount(User1);
            loginModel.checkAccount(User2);
            WindowsInit.closeCurrentWindow(this.loginButton);
            PrimaryWindowsInit.statsWindow();
        }
    }


}
