package org.bluebird.App;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    private int turn = 0;
    private final int MAX_TURNS = 9;
    private BoardModel boardModel = new BoardModel();
    private static String user1;
    private static String user2;

    @FXML
    private Label playerTurnStatus;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    public static String getUser1() {
        return user1;
    }

    public static void setUser1(String user1) {
        BoardController.user1 = user1;
    }

    public static String getUser2() {
        return user2;
    }

    public static void setUser2(String user2) {
        BoardController.user2 = user2;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.playerTurnStatus.setText("Turno: " + BoardController.user1);
    }

    @FXML
    public void square1() {
        play(this.button1);
    }

    @FXML
    public void square2() {
        play(this.button2);
    }

    @FXML
    public void square3() {
        play(this.button3);
    }

    @FXML
    public void square4() {
        play(this.button4);
    }

    @FXML
    public void square5() {
        play(this.button5);
    }

    @FXML
    public void square6() {
        play(this.button6);
    }

    @FXML
    public void square7() {
        play(this.button7);
    }

    @FXML
    public void square8() {
        play(this.button8);
    }

    @FXML
    public void square9() {
        play(this.button9);
    }

    private void play(Button button) {
        if (this.turn % 2 == 0) {
            button.setText("X");
        } else {
            button.setText("O");
        }

        button.setDisable(true);

        this.turn++;
        if (this.turn % 2 == 0) {
            this.playerTurnStatus.setText("Turno: " + BoardController.user1);
        } else {
            this.playerTurnStatus.setText("Turno: " + BoardController.user2);
        }

        checkBoard();
    }

    private void resetBoard() {
        boardModel.resetButton(button1);
        boardModel.resetButton(button2);
        boardModel.resetButton(button3);
        boardModel.resetButton(button4);
        boardModel.resetButton(button5);
        boardModel.resetButton(button6);
        boardModel.resetButton(button7);
        boardModel.resetButton(button8);
        boardModel.resetButton(button9);
        this.turn = 0;
        this.playerTurnStatus.setText("Turno: " + BoardController.user1);
    }

    private void checkBoard() {
        int player;

        if ((player = boardModel.checkWinner(this.button1, this.button5, this.button9)) != -1) {
            boardModel.winner(player);
            resetBoard();
        } else if ((player = boardModel.checkWinner(this.button3, this.button5, this.button7)) != -1) {
            boardModel.winner(player);
            resetBoard();
        } else if ((player = boardModel.checkWinner(this.button1, this.button2, this.button3)) != -1) {
            boardModel.winner(player);
            resetBoard();
        } else if ((player = boardModel.checkWinner(this.button4, this.button5, this.button6)) != -1) {
            boardModel.winner(player);
            resetBoard();
        } else if ((player = boardModel.checkWinner(this.button7, this.button8, this.button9)) != -1) {
            boardModel.winner(player);
            resetBoard();
        } else if ((player = boardModel.checkWinner(this.button1, this.button4, this.button7)) != -1) {
            boardModel.winner(player);
            resetBoard();
        } else if ((player = boardModel.checkWinner(this.button2, this.button5, this.button8)) != -1) {
            boardModel.winner(player);
            resetBoard();
        } else if ((player = boardModel.checkWinner(this.button3, this.button6, this.button9)) != -1) {
            boardModel.winner(player);
            resetBoard();
        } else if (this.turn == this.MAX_TURNS) {
            boardModel.winner(2);
            resetBoard();
        }
    }
}
