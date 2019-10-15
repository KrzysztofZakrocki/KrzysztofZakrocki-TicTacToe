package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;

public class TicTacToe extends Application {

    private Image cross = new Image("file:resources/cross.png");
    private Image circle = new Image("file:resources/circle.png");

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

        Button button1 = new Button("", new ImageView(circle));
        Button button2 = new Button("", new ImageView(cross));
        Button button3 = new Button("", new ImageView(circle));
        Button button4 = new Button("", new ImageView(cross));
        Button button5 = new Button("", new ImageView(circle));
        Button button6 = new Button("", new ImageView(cross));
        Button button7 = new Button("", new ImageView(circle));
        Button button8 = new Button("", new ImageView(cross));
        Button button9 = new Button("", new ImageView(circle));

        Button cleanButton = new Button("Rozpocznij nowa gre");
        cleanButton.setFont(fontInApplication());

        Label helloLabel = new Label("Witaj w grze w kolko i krzyzyk!");
        helloLabel.setFont(new Font("Arial", 18));
        helloLabel.setPadding(new Insets(10,10,10,60));

        ImageView currentRound = new ImageView(circle);

        Label currentRoundLabel = new Label("Tura gracza: ");
        currentRoundLabel.setFont(fontInApplication());
        currentRoundLabel.setPadding(new Insets(0,10,0,10));

        Label whoStartsLabel = new Label("Kto rozpoczyna kolejna runde?");
        whoStartsLabel.setFont(fontInApplication());
        RadioButton playerStarts = new RadioButton("Gracz");
        playerStarts.fire();
        playerStarts.setFont(fontInApplication());
        RadioButton computerStarts = new RadioButton("Komputer");
        computerStarts.setFont(fontInApplication());
        ToggleGroup toggleGroup = new ToggleGroup();
        playerStarts.setToggleGroup(toggleGroup);
        computerStarts.setToggleGroup(toggleGroup);

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

        grid.add(cleanButton,4,3,1,1);

        return grid;
    }

    private Font fontInApplication() {

        Font applicationFont = new Font("Arial", 13);
        return applicationFont;
    }
}