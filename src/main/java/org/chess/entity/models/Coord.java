package org.chess.entity.models;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return xCoord == coord.xCoord && yCoord == coord.yCoord;
    }

    @Override
    public int hashCode() {
        return xCoord + 10 * yCoord;
    }
}