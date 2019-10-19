package com.kodilla;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameMechanics {

    private GameStatus gameStatus;

    public GameMechanics(Player actualPlayer) {
        this.gameStatus = new GameStatus(actualPlayer);
    }

    public void clickButton(Button button) {
        int id = 0;

        id = Integer.parseInt(button.getId());

        button.setGraphic(new ImageView(gameStatus.getWhoseRound().getActualShape().getShape()));
        setCrossAndCircleInButtonsBasedId(id);
    }

    public void setCrossAndCircleInButtonsBasedId(int buttonID) {

        Map temporaryMap = gameStatus.getGameBoard();
        temporaryMap.put(buttonID, gameStatus.getWhoseRound());
        gameStatus.setGameBoard(temporaryMap);
    }

    /*public void whoWin() {
        Map temporaryMap = gameStatus.getGameBoard();

        if (temporaryMap.get(1) == temporaryMap.get(2) && temporaryMap.get(1) == temporaryMap.get(3) ||
                temporaryMap.get(4) == temporaryMap.get(5) && temporaryMap.get(4) == temporaryMap.get(6) ||
                temporaryMap.get(7) == temporaryMap.get(8) && temporaryMap.get(7) == temporaryMap.get(9) ||
                temporaryMap.get(1) == temporaryMap.get(4) && temporaryMap.get(1) == temporaryMap.get(7) ||
                temporaryMap.get(2) == temporaryMap.get(5) && temporaryMap.get(2) == temporaryMap.get(8) ||
                temporaryMap.get(3) == temporaryMap.get(6) && temporaryMap.get(3) == temporaryMap.get(9) ||
                temporaryMap.get(1) == temporaryMap.get(5) && temporaryMap.get(1) == temporaryMap.get(9) ||
                temporaryMap.get(3) == temporaryMap.get(5) && temporaryMap.get(3) == temporaryMap.get(7)){

        }
    }*/

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
        return computerMoveInInt;
    }
}
