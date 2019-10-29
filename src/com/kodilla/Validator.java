package com.kodilla;

public class Validator {

    public boolean checkDidYouWin(Shape[] gameBoard) {
        if (checkFirstRow(gameBoard) == true || checkSecondRow(gameBoard) == true || checkThirdRow(gameBoard) == true ||
                checkFirstCol(gameBoard) == true || checkSecondCol(gameBoard) == true || checkThirdCol(gameBoard) == true ||
                checkFirstSlant(gameBoard) == true || checkSecondSlant(gameBoard) == true) {
            return true;
        } else {
            return false;
        }
    }


    private Boolean checkFirstRow(Shape[] gameBoard) {
        if(gameBoard[0] == gameBoard[1] && gameBoard[1] == gameBoard[2] && gameBoard[0] != null) {
            return true;
        }else {
            return false;
        }
    }

    private Boolean checkSecondRow(Shape[] gameBoard) {
        if(gameBoard[3] == gameBoard[4] && gameBoard[3] == gameBoard[5] && gameBoard[3] != null) {
            return true;
        }else {
            return false;
        }
    }

    private Boolean checkThirdRow(Shape[] gameBoard) {
        if(gameBoard[6] == gameBoard[7] && gameBoard[6] == gameBoard[8] && gameBoard[6] != null) {
            return true;
        }else {
            return false;
        }
    }

    private Boolean checkFirstCol(Shape[] gameBoard) {
        if(gameBoard[0] == gameBoard[3] && gameBoard[0] == gameBoard[6] && gameBoard[0] != null) {
            return true;
        }else {
            return false;
        }
    }

    private Boolean checkSecondCol(Shape[] gameBoard) {
        if(gameBoard[1] == gameBoard[4] && gameBoard[1] == gameBoard[7] && gameBoard[1] != null) {
            return true;
        }else {
            return false;
        }
    }

    private Boolean checkThirdCol(Shape[] gameBoard) {
        if(gameBoard[2] == gameBoard[5] && gameBoard[2] == gameBoard[8] && gameBoard[2] != null) {
            return true;
        }else {
            return false;
        }
    }

    private Boolean checkFirstSlant(Shape[] gameBoard) {
        if(gameBoard[0] == gameBoard[4] && gameBoard[0] == gameBoard[8] && gameBoard[0] != null) {
            return true;
        }else {
            return false;
        }
    }

    private Boolean checkSecondSlant(Shape[] gameBoard) {
        if(gameBoard[2] == gameBoard[4] && gameBoard[2] == gameBoard[6] && gameBoard[2] != null) {
            return true;
        }else {
            return false;
        }
    }
}
