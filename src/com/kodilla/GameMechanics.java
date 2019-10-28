package com.kodilla;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.util.Random;

public class GameMechanics {

    private GameStatus gameStatus;

    public GameMechanics(Player actualPlayer) {
        this.gameStatus = new GameStatus(actualPlayer);
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void clickButton(Button button, GridPane gridPane) {

        int id = Integer.parseInt(button.getId());
        button.setGraphic(new ImageView(gameStatus.getActualPlayer().getActualShape().getShape()));
        setCrossAndCircleInButtonsBasedId(id);
        gameStatus.setRoundNumber(gameStatus.getRoundNumber() + 1);

        if(didYouWin() == true) {
            createMessageBox();
        }

        changePlayer();

        if (gameStatus.getRoundNumber() != 9) {
            Button computerButton = (Button) gridPane.lookup(computerMove());
            computerButton.setGraphic(new ImageView(gameStatus.getActualPlayer().getActualShape().getShape()));
            gameStatus.setRoundNumber(gameStatus.getRoundNumber()+1);

            if(didYouWin() == true) {
                createMessageBox();
            }

            changePlayer();
        }
    }

    public void setCrossAndCircleInButtonsBasedId(int buttonID) {

        Shape[] temporaryArray = gameStatus.getGameBoard();
        temporaryArray[buttonID-1] = gameStatus.getActualPlayer().getActualShape();
        gameStatus.setGameBoard(temporaryArray);
    }

    public boolean didYouWin() {

        boolean endGame = false;
        Shape[] temporaryArray = gameStatus.getGameBoard();

        if (temporaryArray[0] == temporaryArray[1] && temporaryArray[1] == temporaryArray[2] && temporaryArray[0] != null ||
                temporaryArray[3] == temporaryArray[4] && temporaryArray[3] == temporaryArray[5] && temporaryArray[3] != null ||
                temporaryArray[6] == temporaryArray[7] && temporaryArray[6] == temporaryArray[8] && temporaryArray[6] != null ||
                temporaryArray[0] == temporaryArray[3] && temporaryArray[0] == temporaryArray[6] && temporaryArray[0] != null ||
                temporaryArray[1] == temporaryArray[4] && temporaryArray[1] == temporaryArray[7] && temporaryArray[1] != null ||
                temporaryArray[2] == temporaryArray[5] && temporaryArray[2] == temporaryArray[8] && temporaryArray[2] != null ||
                temporaryArray[0] == temporaryArray[4] && temporaryArray[0] == temporaryArray[8] && temporaryArray[0] != null ||
                temporaryArray[2] == temporaryArray[4] && temporaryArray[2] == temporaryArray[6]&& temporaryArray[2] != null) {

            endGame = true;
        }
        return endGame;
    }

    public int computerMoveGenerator() {
        Random computerMoveGenerator = new Random();
        int computerMove = computerMoveGenerator.nextInt(9) +1;
        return computerMove;
    }

    public String computerMove() {

        boolean correctMove = false;
        Shape[] temporaryArray = gameStatus.getGameBoard();
        int computerMoveInInt = computerMoveGenerator();

        while(!correctMove) {
            if (temporaryArray[computerMoveInInt-1] != null) {
                    computerMoveInInt = computerMoveGenerator();
            }else {
                correctMove = true;
            }
        }

        setCrossAndCircleInButtonsBasedId(computerMoveInInt);
        return "#" + computerMoveInInt;
    }

    public void changePlayer() {
        Player temporaryPlayer = gameStatus.getActualPlayer();

        gameStatus.setActualPlayer(gameStatus.getSecondPlayer());
        gameStatus.setSecondPlayer(temporaryPlayer);
    }

    public void createMessageBox() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Rozpocznij nowa gre", ButtonType.OK);
        alert.setTitle("Koniec gry");
        alert.setHeaderText("Koniec gry");
        alert.setContentText("Wygral " + gameStatus.getActualPlayer());
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {

            }
        });
    }
}