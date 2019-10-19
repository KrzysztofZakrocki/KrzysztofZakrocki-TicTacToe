package com.kodilla;

import javafx.scene.image.Image;

public class Circle implements Shape {

    public static final Image circle = new Image("file:resources/circle.png");

    @Override
    public Image getShape() {
        return circle;
    }
}
