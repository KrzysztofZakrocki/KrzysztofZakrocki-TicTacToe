package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private GameMechanics myGame;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(createBoard());
        primaryStage.setTitle("TicTacToe");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Parent createBoard() {
        GridPane grid = new GridPane();

        Label helloLabel = new Label("Witaj w grze w kolko i krzyzyk!");
        helloLabel.setFont(new Font("Arial", 18));
        helloLabel.setPadding(new Insets(10,10,10,60));

        grid.add(helloLabel, 0, 0, 3,1);

        Label whoStartsLabel = new Label("Kto rozpoczyna kolejna runde?");
        whoStartsLabel.setFont(fontInApplication());

        RadioButton playerStarts = new RadioButton("Gracz");
        playerStarts.setFont(fontInApplication());

        RadioButton computerStarts = new RadioButton("Komputer");
        computerStarts.setFont(fontInApplication());

        ToggleGroup toggleGroupWhoStart = new ToggleGroup();
        playerStarts.setToggleGroup(toggleGroupWhoStart);
        computerStarts.setToggleGroup(toggleGroupWhoStart);

        grid.add(whoStartsLabel, 3,1,1,1);
        grid.add(playerStarts, 3, 1,1,2);
        grid.add(computerStarts,3,2,1,1);

        Label whatShape = new Label("Wybierz ksztalt: ");
        whatShape.setFont(fontInApplication());

        RadioButton chooseCross = new RadioButton("Krzyzyk");
        chooseCross.setFont(fontInApplication());

        RadioButton chooseCircle = new RadioButton("Kolko");
        chooseCircle.setFont(fontInApplication());

        ToggleGroup toggleGroupWhatShape = new ToggleGroup();
        chooseCircle.setToggleGroup(toggleGroupWhatShape);
        chooseCross.setToggleGroup(toggleGroupWhatShape);

        grid.add(whatShape, 3, 2,1,2);
        grid.add(chooseCircle, 3, 3,1, 1);
        grid.add(chooseCross, 3, 4,1,1);

        Button[] buttonsArray = new Button[9];

        for(int i = 0; i < 9; i++) {
            Button button = new Button("");
            button.setMinSize(116, 108);
            button.setId(String.valueOf(i + 1));
            button.setDisable(true);
            buttonsArray[i] = button;
        }

        grid.add(buttonsArray[0], 0, 1);
        grid.add(buttonsArray[1], 1,1);
        grid.add(buttonsArray[2], 2,1);
        grid.add(buttonsArray[3], 0,2);
        grid.add(buttonsArray[4], 1,2);
        grid.add(buttonsArray[5], 2,2);
        grid.add(buttonsArray[6], 0,3);
        grid.add(buttonsArray[7], 1,3);
        grid.add(buttonsArray[8], 2,3);

        for(int i = 0; i < 9; i++) {
            int finalI = i;
            buttonsArray[i].setOnAction((event) -> {
                myGame.clickButton(buttonsArray[finalI], grid);
                buttonsArray[finalI].setDisable(true);
            });
        }

        Button newGameButton = new Button("Rozpocznij nowa gre");
        newGameButton.setFont(fontInApplication());
        newGameButton.setId("100");

        grid.add(newGameButton,3,0,1,1);

        newGameButton.setOnAction((event) -> cleanup(buttonsArray, (RadioButton) toggleGroupWhoStart.getSelectedToggle(),
                (RadioButton) toggleGroupWhatShape.getSelectedToggle(), grid));

        createHelloBox();

        return grid;
    }

    private void cleanup(Button[] buttonsArray, RadioButton selectedButtonWhoStart, RadioButton selectedButtonWhatShape, GridPane grid) {

        setWhoStart(selectedButtonWhoStart, selectedButtonWhatShape);

        for(int i = 0; i < 9; i ++) {
            buttonsArray[i].setGraphic(null);
            buttonsArray[i].setDisable(false);
        }

        if (myGame.getGameStatus().getActualPlayer() instanceof Computer) {
            myGame.computerClickButton(grid);
        }
    }

    private void setWhoStart(RadioButton selectedButtonWhoStart, RadioButton selectedButtonWhatShape) {

        if(selectedButtonWhoStart.getText().equals("Gracz")) {
            myGame = new GameMechanics(new User());
        } else if(selectedButtonWhoStart.getText().equals("Komputer")) {
            myGame = new GameMechanics(new Computer());
        }

        if(selectedButtonWhatShape.getText().equals("Kolko")) {
            myGame.getGameStatus().getActualPlayer().setActualShape(new Circle());
            myGame.getGameStatus().getSecondPlayer().setActualShape(new Cross());
        }else if(selectedButtonWhatShape.getText().equals("Krzyzyk")) {
            myGame.getGameStatus().getActualPlayer().setActualShape(new Cross());
            myGame.getGameStatus().getSecondPlayer().setActualShape(new Circle());
        }
    }

    public void createHelloBox() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Hello", ButtonType.OK);
        alert.setTitle("Witaj!");
        alert.setHeaderText("Witaj w grze w kolko i krzyzyk");
        alert.setContentText("Przed rozpoczeciem gry wybierz gracza rozpoczynajacego oraz jego symbol. Nastepnie kliknij przycisk nowej gry.");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {}
        });
    }

    private Font fontInApplication() {

        Font applicationFont = new Font("Arial", 13);
        return applicationFont;
    }
}