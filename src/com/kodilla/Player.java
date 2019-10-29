package com.kodilla;

public interface Player {

    void setActualShape (Shape shape);
    Shape getActualShape ();

    @Override
    String toString();
}
