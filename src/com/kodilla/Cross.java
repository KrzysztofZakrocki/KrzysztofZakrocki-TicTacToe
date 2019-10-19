package com.kodilla;

import javafx.scene.image.Image;

public class Cross implements Shape {

    public static final Image Cross = new Image("file:resources/cross.png");

    @Override
    public Image getShape() {
        return Cross;
    }
}
