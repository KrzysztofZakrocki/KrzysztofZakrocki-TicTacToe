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

        Button[] buttonsArray = new Button[9];

        for(int i = 0; i < 9; i++) {
            Button button = new Button("");
            button.setMinSize(116, 108);
            button.setId(String.valueOf(i + 1));
            buttonsArray[i] = button;
        }

        Button newGameButton = new Button("Rozpocznij nowa gre");
        newGameButton.setFont(fontInApplication());
        newGameButton.setId("100");

        Label helloLabel = new Label("Witaj w grze w kolko i krzyzyk!");
        helloLabel.setFont(new Font("Arial", 18));
        helloLabel.setPadding(new Insets(10,10,10,60));

        ImageView currentRound = new ImageView(myGame.getGameStatus().getActualPlayer().getActualShape().getShape());

        Label currentRoundLabel = new Label("Tura gracza: ");
        currentRoundLabel.setFont(fontInApplication());
        currentRoundLabel.setPadding(new Insets(0,10,0,10));

        GridPane grid = new GridPane();

        grid.add(buttonsArray[0], 0, 1);
        grid.add(buttonsArray[1], 1,1);
        grid.add(buttonsArray[2], 2,1);
        grid.add(buttonsArray[3], 0,2);
        grid.add(buttonsArray[4], 1,2);
        grid.add(buttonsArray[5], 2,2);
        grid.add(buttonsArray[6], 0,3);
        grid.add(buttonsArray[7], 1,3);
        grid.add(buttonsArray[8], 2,3);


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

        GameMechanics finalMyGame = myGame;

        for(int i = 0; i < 9; i++) {
            Button button = buttonsArray[i];
            button.setOnMousePressed((event) -> finalMyGame.clickButton(button, grid));
        }
        return grid;
    }

    private Font fontInApplication() {

        Font applicationFont = new Font("Arial", 13);
        return applicationFont;
    }
}