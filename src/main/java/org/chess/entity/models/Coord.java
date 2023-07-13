package org.chess.entity.models;

public class Coord {
    private int xCoord;
    private int yCoord;

    public Coord(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public boolean isOutOfBounds(Coord boundCoord){
        if( xCoord > boundCoord.getXCoord() || xCoord < boundCoord.getXCoord()
                || yCoord > boundCoord.getYCoord() || yCoord < boundCoord.getYCoord()){
            return true;
        }

        return false;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                '}';
    }
}