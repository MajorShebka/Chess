package org.chess.entity.models;

import com.fasterxml.jackson.annotation.*;

public class Coord {
    @JsonProperty("xCoord")
    private int xCoord;
    @JsonProperty("yCoord")
    private int yCoord;

    public Coord(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    @JsonGetter("xCoord")
    public int getXCoord() {
        return xCoord;
    }

    @JsonGetter("yCoord")
    public int getYCoord() {
        return yCoord;
    }

//    @Override
//    public String toString() {
//        return "Coord{" +
//                "xCoord=" + xCoord +
//                ", yCoord=" + yCoord +
//                '}';
//    }

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

    @JsonSetter("xCoord")
    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    @JsonSetter("yCoord")
    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
}