package ru.sbt.test.refactoring;

public enum Orientation {
    NORTH(1,0,1),
    WEST(2,-1,0),
    SOUTH(3,0,-1),
    EAST(4,1,0);


    private final int code;
    private final int stepX;
    private final int stepY;

    private Orientation(int code, int stepX, int stepY) {
        this.code = code;
        this.stepX = stepX;
        this.stepY = stepY;
    }

    public int getCode() {
        return this.code;
    }

    public int getStepX() {
        return stepX;
    }

    public int getStepY() {
        return stepY;
    }

    public static Orientation getOrienatationByCode(int code){
        for (Orientation orientation : Orientation.values()) {
            if (code == orientation.code) {
                return orientation;
            }
        }
        return null;
    }

    public static Orientation getOrienatationNextByCode(int code){
        int codeNext = (code>=Orientation.values().length)?1:(code+1);
        for (Orientation orientation : Orientation.values()) {
            if (orientation.getCode() == codeNext) {
                return orientation;
            }
        }
        return null;
    }
}