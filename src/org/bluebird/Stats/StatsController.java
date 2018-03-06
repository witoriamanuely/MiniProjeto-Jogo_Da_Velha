package org.bluebird.Stats;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.bluebird.App.BoardController;
import org.bluebird.Login.LoginController;
import org.bluebird.Utils.PrimaryWindowsInit;
import org.bluebird.Utils.WindowsInit;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StatsController implements Initializable {

    private StatsModel statsModel = new StatsModel();

    @FXML
    private Label player1Stats;

    @FXML
    private Label player2Stats;

    @FXML
    private Button start;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int[] temp;

        int maior = 0;

        try {
            temp = statsModel.returnStats(LoginController.getUser1());
            maior = temp[0];
            player1Stats.setText(LoginController.getUser1() + ": " + temp[0] + " Vitorias, " + temp[1] + " Derrotas, " + temp[2] + " Empates");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            temp = statsModel.returnStats(LoginController.getUser2());
            if (maior > temp[0]){
                BoardController.setUser1(LoginController.getUser2());
                BoardController.setUser2(LoginController.getUser1());
            } else {
                BoardController.setUser1(LoginController.getUser1());
                BoardController.setUser2(LoginController.getUser2());
            }
            player2Stats.setText(LoginController.getUser2() + ": " + temp[0] + " Vitorias, " + temp[1] + " Derrotas, " + temp[2] + " Empates");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void play() {
        WindowsInit.closeCurrentWindow(this.start);
        PrimaryWindowsInit.appWindow();
    }
}
