package ru.sbt.test.refactoring;

public class Position {
    private int x;
    private int y;

    Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveForwards(Orientation orientation){
        this.x+=orientation.getStepX();
        this.y+=orientation.getStepY();
    }
}
