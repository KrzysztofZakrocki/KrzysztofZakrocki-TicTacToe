package com.kodilla;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    Player whoStart = null;
    Player secondPlayer = null;

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
            whoStart = new User();
            secondPlayer = new Computer();
        } else if(toggleGroupWhoStart.getSelectedToggle() == computerStarts) {
            whoStart = new Computer();
            secondPlayer = new User();
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
            whoStart.setActualShape(new Circle());
            secondPlayer.setActualShape(new Cross());
        }else if(toggleGroupWhatShape.getSelectedToggle() == chooseCross) {
            whoStart.setActualShape(new Cross());
            secondPlayer.setActualShape(new Circle());
        }

        GameMechanics myGame = new GameMechanics(whoStart);

        Button button1 = new Button("");
        button1.setMinSize(116,108);
        button1.setId("1");
        button1.setOnMousePressed((event) -> myGame.clickButton(button1));

        Button button2 = new Button("");
        button2.setMinSize(116,108);
        button2.setId("2");
        button2.setOnMousePressed((event) -> myGame.clickButton(button2));

        Button button3 = new Button("");
        button3.setMinSize(116,108);
        button3.setId("3");
        button3.setOnMousePressed((event) -> myGame.clickButton(button3));

        Button button4 = new Button("");
        button4.setMinSize(116,108);
        button4.setId("4");
        button4.setOnMousePressed((event) -> myGame.clickButton(button4));

        Button button5 = new Button("");
        button5.setMinSize(116,108);
        button5.setId("5");
        button5.setOnMousePressed((event) -> myGame.clickButton(button5));

        Button button6 = new Button("");
        button6.setMinSize(116,108);
        button6.setId("6");
        button6.setOnMousePressed((event) -> myGame.clickButton(button6));

        Button button7 = new Button("");
        button7.setMinSize(116,108);
        button7.setId("7");
        button7.setOnMousePressed((event) -> myGame.clickButton(button7));

        Button button8 = new Button("");
        button8.setMinSize(116,108);
        button8.setId("8");
        button8.setOnMousePressed((event) -> myGame.clickButton(button8));

        Button button9 = new Button("");
        button9.setMinSize(116,108);
        button9.setId("9");
        button9.setOnMousePressed((event) -> myGame.clickButton(button9));

        Button newGameButton = new Button("Rozpocznij nowa gre");
        newGameButton.setFont(fontInApplication());

        Label helloLabel = new Label("Witaj w grze w kolko i krzyzyk!");
        helloLabel.setFont(new Font("Arial", 18));
        helloLabel.setPadding(new Insets(10,10,10,60));


        ImageView currentRound = new ImageView(whoStart.getActualShape().getShape());

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

        return grid;
    }

    private Font fontInApplication() {

        Font applicationFont = new Font("Arial", 13);
        return applicationFont;
    }
}