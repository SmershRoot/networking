package ru.sbt.test.refactoring;

public class Tractor {

    Position position = new Position(0,0);

    int[] field = new int[] { 10, 10 };
    Orientation orientation = Orientation.NORTH;

    public void move(String command) {
        if (command == "F") {
            moveForwards();
        } else if (command == "T") {
            turnClockwise();
        }
    }

    private void moveForwards() {
        position.moveForwards(orientation);

        if (position.getX() > field[0] || position.getY() > field[1] || position.getX()<0 ||
                position.getY()<0) {
            throw new TractorInDitchException();
        }
    }

    private void turnClockwise() {
        orientation = Orientation.getOrienatationNextByCode(orientation.getCode());
    }

    public int getPositionX() {
        return position.getX();
    }

    public int getPositionY() {
        return position.getY();
    }

    public Orientation getOrientation() {
        return orientation;
    }

}