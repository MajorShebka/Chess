package org.chess.entity.models;

import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;

import java.util.Objects;

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
        this.maxCoord = maxCoord;
        this.minCoord = minCoord;
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

    public void setFigureCoord(Coord figureCoord) {
        this.figureCoord = figureCoord;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "color=" + color +
                ", type=" + type +
                ", figureCoord=" + figureCoord +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return figureCoord.equals(figure.getPosition());
    }

    @Override
    public int hashCode() {
        return figureCoord.hashCode();
    }
}