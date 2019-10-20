package com.kodilla;

import java.util.HashMap;
import java.util.Map;

public class GameStatus {

    private Player actualPlayer;
    private Player secondPlayer;
    private Map<Integer, Player> gameBoard;

    public GameStatus(Player actualPlayer) {
        this.actualPlayer = actualPlayer;

        if(actualPlayer instanceof User) {
            this.secondPlayer = new Computer();
        }else if(actualPlayer instanceof Computer){
            this.secondPlayer = new User();
        }
        gameBoard = new HashMap<>();
    }

    public Player getActualPlayer() {
        return actualPlayer;
    }

    public void setActualPlayer(Player actualPlayer) {
        this.actualPlayer = actualPlayer;
    }

    public Player getSecondPlayer() {return secondPlayer;}

    public void setSecondPlayer(Player secondPlayer) { this.secondPlayer = secondPlayer;}

    public Map<Integer, Player> getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Map<Integer, Player> gameBoard) {
        this.gameBoard = gameBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameStatus that = (GameStatus) o;

        return gameBoard != null ? gameBoard.equals(that.gameBoard) : that.gameBoard == null;
    }

    @Override
    public int hashCode() {
        return gameBoard != null ? gameBoard.hashCode() : 0;
    }
}
