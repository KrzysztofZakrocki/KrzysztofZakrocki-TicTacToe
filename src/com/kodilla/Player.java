package com.kodilla;

public interface Player {

    public void setActualShape (Shape shape);
    public Shape getActualShape ();

    @Override
    public String toString();
}
