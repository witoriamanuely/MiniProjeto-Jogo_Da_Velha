package org.bluebird.App;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.bluebird.Login.LoginController;

import java.net.URL;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    private int turn = 0;
    private final int MAXTURNS = 9;
    private BoardModel boardModel = new BoardModel();

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.playerTurnStatus.setText("Turno: " + LoginController.getUser1());
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
            this.playerTurnStatus.setText("Turno: " + LoginController.getUser2());
            button.setText("X");
        } else {
            this.playerTurnStatus.setText("Turno: " + LoginController.getUser1());
            button.setText("O");
        }
        button.setDisable(true);
        this.turn++;
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
        this.playerTurnStatus.setText("Turno: " + LoginController.getUser1());
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
        } else if (this.turn == this.MAXTURNS) {
            boardModel.winner(2);
            resetBoard();
        }
    }
}
