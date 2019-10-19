package com.kodilla;

import java.util.HashMap;
import java.util.Map;

public class GameStatus {

    private Player actualPlayer;
    private Map<Integer, Player> gameBoard;

    public GameStatus(Player whoseRound) {
        this.actualPlayer = whoseRound;

        gameBoard = new HashMap<>();
    }

    public Player getWhoseRound() {
        return actualPlayer;
    }

    public void setWhoseRound(Player whoseRound) {
        this.actualPlayer = whoseRound;
    }

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
