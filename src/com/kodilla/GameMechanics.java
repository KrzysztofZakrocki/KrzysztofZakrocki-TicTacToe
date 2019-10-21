package com.kodilla;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import java.util.Map;
import java.util.Random;

public class GameMechanics {

    private GameStatus gameStatus;

    public GameMechanics(Player actualPlayer) {
        this.gameStatus = new GameStatus(actualPlayer);
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void clickButton(Button button) {

        int id = Integer.parseInt(button.getId());

        button.setGraphic(new ImageView(gameStatus.getActualPlayer().getActualShape().getShape()));
        setCrossAndCircleInButtonsBasedId(id);

        gameStatus.setActualPlayer(new Computer());
        gameStatus.setSecondPlayer(new User());
    }

    public void setCrossAndCircleInButtonsBasedId(int buttonID) {

        Map temporaryMap = gameStatus.getGameBoard();
        temporaryMap.put(buttonID, gameStatus.getActualPlayer());
        gameStatus.setGameBoard(temporaryMap);
    }

    public boolean whoWin() {

        boolean endGame = false;
        Map temporaryMap = gameStatus.getGameBoard();

        if (temporaryMap.get(1).equals(temporaryMap.get(2)) && temporaryMap.get(1).equals(temporaryMap.get(3)) ||
                temporaryMap.get(4).equals(temporaryMap.get(5)) && temporaryMap.get(4).equals(temporaryMap.get(6)) ||
                temporaryMap.get(7).equals(temporaryMap.get(8)) && temporaryMap.get(7).equals(temporaryMap.get(9)) ||
                temporaryMap.get(1).equals(temporaryMap.get(4)) && temporaryMap.get(1).equals(temporaryMap.get(7)) ||
                temporaryMap.get(2).equals(temporaryMap.get(5)) && temporaryMap.get(2).equals(temporaryMap.get(8)) ||
                temporaryMap.get(3).equals(temporaryMap.get(6)) && temporaryMap.get(3).equals(temporaryMap.get(9)) ||
                temporaryMap.get(1).equals(temporaryMap.get(5)) && temporaryMap.get(1).equals(temporaryMap.get(9)) ||
                temporaryMap.get(3).equals(temporaryMap.get(5)) && temporaryMap.get(3).equals(temporaryMap.get(7))) {
            endGame = true;
        }
        return endGame;
    }

    public int computerMoveGenerator() {
        Random computerMoveGenerator = new Random();
        int computerMove = computerMoveGenerator.nextInt(9) +1;
        return computerMove;
    }

    public int computerMove() {

        boolean correctMove = false;
        Map<Integer, Player> temporaryMap = gameStatus.getGameBoard();
        int computerMoveInInt = 0;

        while(correctMove != true) {

            computerMoveInInt = computerMoveGenerator();

            for(Map.Entry<Integer, Player> entry : temporaryMap.entrySet()){
                if(entry.getKey() != computerMoveInInt) {
                    correctMove = true;
                }
            }
        }
        setCrossAndCircleInButtonsBasedId(computerMoveInInt);
        gameStatus.setActualPlayer(new User());
        gameStatus.setSecondPlayer(new Computer());
        return computerMoveInInt;
    }
}