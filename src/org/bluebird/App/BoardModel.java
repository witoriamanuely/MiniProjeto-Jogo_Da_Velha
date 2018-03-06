package org.bluebird.App;

import javafx.scene.control.Button;
import org.bluebird.FileUtils.ConexaoBD;
import org.bluebird.Login.LoginController;
import org.bluebird.Utils.SecondaryWindowsInit;

import java.sql.*;

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
            try {
                this.updateDB(LoginController.getUser1(), 1, 0, 0);
                this.updateDB(LoginController.getUser2(), 0, 1, 0);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Problema com BD " + e.getMessage());
            }
        } else if (player == 1) {
            SecondaryWindowsInit.winnerWindow(LoginController.getUser2() + " é o Vencedor");
            try {
                this.updateDB(LoginController.getUser1(), 0, 1, 0);
                this.updateDB(LoginController.getUser2(), 1, 0, 0);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Problema com BD " + e.getMessage());
            }
        } else {
            SecondaryWindowsInit.winnerWindow("Jogo deu Empate");
            try {
                this.updateDB(LoginController.getUser1(), 0, 0, 1);
                this.updateDB(LoginController.getUser2(), 0, 0, 1);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Problema com BD " + e.getMessage());
            }
        }
    }

    void resetButton(Button btn) {
        btn.setText("");
        btn.setDisable(false);
    }

    private void updateDB(String user, int vict, int def, int tied) throws SQLException {
        Connection connection;
        PreparedStatement stmt;

        connection = ConexaoBD.bdConnection();

        String sql = "UPDATE users SET victory = victory + " + vict + ", defeat = defeat + " + def + ", tie = tie + " + tied + " WHERE username = ? ";
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, user);

        stmt.executeUpdate();

        stmt.close();
        connection.close();
    }
}
