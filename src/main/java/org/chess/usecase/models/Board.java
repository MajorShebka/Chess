package org.chess.usecase.models;

import org.chess.entity.enums.FigureColor;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;

import java.util.Set;

public class Board {
    private FigureColor movingColor;
    private final Coord MAX_COORD;
    private final Coord MIN_COORD;
    private Set<Figure> figuresOnTheBoard;

    public Board(Coord MAX_COORD, Coord MIN_COORD, Set<Figure> figuresOnTheBoard, FigureColor movingColor) {
        this.MAX_COORD = MAX_COORD;
        this.MIN_COORD = MIN_COORD;
        this.figuresOnTheBoard = figuresOnTheBoard;
        this.movingColor = movingColor;
    }

    public Coord getMAX_COORD() {
        return MAX_COORD;
    }

    public Coord getMIN_COORD() {
        return MIN_COORD;
    }

    public Set<Figure> getFiguresOnTheBoard() {
        return figuresOnTheBoard;
    }

    public void setFiguresOnTheBoard(Set<Figure> figuresOnTheBoard) {
        this.figuresOnTheBoard = figuresOnTheBoard;
    }

    public FigureColor getMovingColor() {
        return movingColor;
    }

    public void changeMovingColor(){
        movingColor = movingColor == FigureColor.BLACK ? FigureColor.WHITE : FigureColor.BLACK;
    }
}
