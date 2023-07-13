package org.chess.entity.models;

import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;

public class Figure {
    private FigureColor color;
    private FigureType type;
    private Coord figureCoord;
    private Coord maxCoord;
    private Coord minCoord;

    public Figure(FigureColor color, FigureType type, Coord figureCoord, Coord maxCoord, Coord minCoord) {
        this.color = color;
        this.type = type;
        this.figureCoord = figureCoord;
    }

    public Coord getPosition() {
        return figureCoord;
    }

    public void setPosition(Coord figureCoord) {
        this.figureCoord = figureCoord;
    }

    public void setType(FigureType type) {
        this.type = type;
    }

    public FigureType getType() {
        return type;
    }

    public FigureColor getColor() {
        return color;
    }

    public void setColor(FigureColor color) {
        this.color = color;
    }

    public Coord getMaxCoord() {
        return maxCoord;
    }

    public Coord getMinCoord() {
        return minCoord;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "color=" + color +
                ", type=" + type +
                ", figureCoord=" + figureCoord +
                '}';
    }
}