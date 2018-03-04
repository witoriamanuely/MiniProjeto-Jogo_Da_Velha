package org.bluebird.App;

import javafx.scene.control.Button;
import org.bluebird.Login.LoginController;
import org.bluebird.Utils.SecondaryWindowsInit;

class BoardModel {

    int checkWinner(Button btn1, Button btn2, Button btn3) {
        if (btn1.getText().equals("X") && btn2.getText().equals("X") && btn3.getText().equals("X")) {
            return 0;
        } else if (btn1.getText().equals("O") && btn2.getText().equals("O") && btn3.getText().equals("O")) {
            return 1;
        } else {
            return -1;
        }
    }

    void winner(int player) {
        if (player == 0) {
            SecondaryWindowsInit.winnerWindow(LoginController.getUser1() + " é o Vencedor");
        } else if (player == 1) {
            SecondaryWindowsInit.winnerWindow(LoginController.getUser2() + " é o Vencedor");
        } else {
            SecondaryWindowsInit.winnerWindow("Jogo deu Empate");
        }
    }

    void resetButton(Button btn) {
        btn.setText("");
        btn.setDisable(false);
    }
}
