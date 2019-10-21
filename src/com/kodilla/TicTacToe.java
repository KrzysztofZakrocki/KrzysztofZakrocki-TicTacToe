package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(createBoard());

        primaryStage.setTitle("TicTacToe");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Parent createBoard() {

        GameMechanics myGame = null;

        Label whoStartsLabel = new Label("Kto rozpoczyna kolejna runde?");
        whoStartsLabel.setFont(fontInApplication());

        RadioButton playerStarts = new RadioButton("Gracz");
        playerStarts.fire();
        playerStarts.setFont(fontInApplication());

        RadioButton computerStarts = new RadioButton("Komputer");
        computerStarts.setFont(fontInApplication());

        ToggleGroup toggleGroupWhoStart = new ToggleGroup();
        playerStarts.setToggleGroup(toggleGroupWhoStart);
        computerStarts.setToggleGroup(toggleGroupWhoStart);

        if(toggleGroupWhoStart.getSelectedToggle() == playerStarts) {
            myGame = new GameMechanics(new User());
        }else if(toggleGroupWhoStart.getSelectedToggle() == computerStarts) {
            myGame = new GameMechanics(new Computer());
        }

        Label whatShape = new Label("Wybierz ksztalt: ");
        whatShape.setFont(fontInApplication());

        RadioButton chooseCross = new RadioButton("Krzyzyk");
        chooseCross.fire();
        chooseCross.setFont(fontInApplication());

        RadioButton chooseCircle = new RadioButton("Kolko");
        chooseCircle.setFont(fontInApplication());

        ToggleGroup toggleGroupWhatShape = new ToggleGroup();
        chooseCircle.setToggleGroup(toggleGroupWhatShape);
        chooseCross.setToggleGroup(toggleGroupWhatShape);

        if(toggleGroupWhatShape.getSelectedToggle() == chooseCircle) {
            myGame.getGameStatus().getActualPlayer().setActualShape(new Circle());
            myGame.getGameStatus().getSecondPlayer().setActualShape(new Cross());
        }else if(toggleGroupWhatShape.getSelectedToggle() == chooseCross) {
            myGame.getGameStatus().getActualPlayer().setActualShape(new Cross());
            myGame.getGameStatus().getSecondPlayer().setActualShape(new Circle());
        }

        Button button1 = new Button("");
        button1.setMinSize(116,108);
        button1.setId("1");

        Button button2 = new Button("");
        button2.setMinSize(116,108);
        button2.setId("2");

        Button button3 = new Button("");
        button3.setMinSize(116,108);
        button3.setId("3");

        Button button4 = new Button("");
        button4.setMinSize(116,108);
        button4.setId("4");

        Button button5 = new Button("");
        button5.setMinSize(116,108);
        button5.setId("5");

        Button button6 = new Button("");
        button6.setMinSize(116,108);
        button6.setId("6");

        Button button7 = new Button("");
        button7.setMinSize(116,108);
        button7.setId("7");

        Button button8 = new Button("");
        button8.setMinSize(116,108);
        button8.setId("8");

        Button button9 = new Button("");
        button9.setMinSize(116,108);
        button9.setId("9");

        Button newGameButton = new Button("Rozpocznij nowa gre");
        newGameButton.setFont(fontInApplication());

        Label helloLabel = new Label("Witaj w grze w kolko i krzyzyk!");
        helloLabel.setFont(new Font("Arial", 18));
        helloLabel.setPadding(new Insets(10,10,10,60));

        ImageView currentRound = new ImageView(myGame.getGameStatus().getActualPlayer().getActualShape().getShape());

        Label currentRoundLabel = new Label("Tura gracza: ");
        currentRoundLabel.setFont(fontInApplication());
        currentRoundLabel.setPadding(new Insets(0,10,0,10));

        GridPane grid = new GridPane();

        grid.add(button1, 0, 1);
        grid.add(button2, 1,1);
        grid.add(button3, 2,1);
        grid.add(button4, 0,2);
        grid.add(button5, 1,2);
        grid.add(button6, 2,2);
        grid.add(button7, 0,3);
        grid.add(button8, 1,3);
        grid.add(button9, 2,3);


        grid.add(helloLabel, 0, 0, 3,1);

        grid.add(whoStartsLabel, 3,2,1,1);
        grid.add(playerStarts, 3, 2,1,2);
        grid.add(computerStarts,3,3,1,1);

        grid.add(currentRoundLabel, 3, 1, 1, 1);
        grid.add(currentRound, 4, 1, 1, 1);

        grid.add(whatShape, 5, 2,1,1);
        grid.add(chooseCircle, 5, 2,1, 2);
        grid.add(chooseCross, 5, 3,1,1);

        grid.add(newGameButton,5,0,1,1);

        if (myGame.getGameStatus().getActualPlayer() instanceof User) {
            GameMechanics finalMyGame = myGame;
            button1.setOnMousePressed((event) -> finalMyGame.clickButton(button1));
            button2.setOnMousePressed((event) -> finalMyGame.clickButton(button2));
            button3.setOnMousePressed((event) -> finalMyGame.clickButton(button3));
            button4.setOnMousePressed((event) -> finalMyGame.clickButton(button4));
            button5.setOnMousePressed((event) -> finalMyGame.clickButton(button5));
            button6.setOnMousePressed((event) -> finalMyGame.clickButton(button6));
            button7.setOnMousePressed((event) -> finalMyGame.clickButton(button7));
            button8.setOnMousePressed((event) -> finalMyGame.clickButton(button8));
            button9.setOnMousePressed((event) -> finalMyGame.clickButton(button9));

                //endGame = myGame.whoWin();
        } else if (myGame.getGameStatus().getActualPlayer() instanceof Computer) {
            Button button = (Button) grid.lookup(Integer.toString(myGame.computerMove()));
            button.setGraphic(new ImageView(myGame.getGameStatus().getActualPlayer().getActualShape().getShape()));
            //endGame = myGame.whoWin();
        }
        return grid;
    }

    private Font fontInApplication() {

        Font applicationFont = new Font("Arial", 13);
        return applicationFont;
    }
}