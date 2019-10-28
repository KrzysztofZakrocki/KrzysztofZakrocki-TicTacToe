package com.kodilla;

public class GameStatus {

    private Player actualPlayer;
    private Player secondPlayer;
    private Shape[] gameBoard;
    private int roundNumber;

    public GameStatus(Player actualPlayer) {
        this.actualPlayer = actualPlayer;

        if(actualPlayer instanceof User) {
            this.secondPlayer = new Computer();
        }else if(actualPlayer instanceof Computer){
            this.secondPlayer = new User();
        }
        roundNumber = 0;
        gameBoard = new Shape[9];
    }

    public Player getActualPlayer() {
        return actualPlayer;
    }

    public void setActualPlayer(Player actualPlayer) {
        this.actualPlayer = actualPlayer;
    }

    public Player getSecondPlayer() {return secondPlayer;}

    public void setSecondPlayer(Player secondPlayer) { this.secondPlayer = secondPlayer;}

    public Shape[] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Shape[] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}
