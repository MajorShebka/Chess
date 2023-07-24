package org.chess.usecase.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.models.Coord;
import org.chess.usecase.models.dto.FigureDTO;

import java.util.Set;

public class Board {
    private FigureColor movingColor;
    private Coord maxCoord;
    private Coord minCoord;
    private Set<FigureDTO> figuresOnTheBoard;

    public Board(Coord MAX_COORD, Coord MIN_COORD, Set<FigureDTO> figuresOnTheBoard, FigureColor movingColor) {
        this.maxCoord = MAX_COORD;
        this.minCoord = MIN_COORD;
        this.figuresOnTheBoard = figuresOnTheBoard;
        this.movingColor = movingColor;
    }

    public Coord getMaxCoord() {
        return maxCoord;
    }

    public Coord getMinCoord() {
        return minCoord;
    }

    public Set<FigureDTO> getFiguresOnTheBoard() {
        return figuresOnTheBoard;
    }

    public void setFiguresOnTheBoard(Set<FigureDTO> figuresOnTheBoard) {
        this.figuresOnTheBoard = figuresOnTheBoard;
    }
    public FigureColor getMovingColor() {
        return movingColor;
    }

    public void setMovingColor(String movingColor) {
        this.movingColor = FigureColor.valueOf(movingColor);
    }

    public void changeMovingColor(){
        movingColor = movingColor == FigureColor.BLACK ? FigureColor.WHITE : FigureColor.BLACK;
    }

//    @Override
//    public String toString() {
//        return "Board{" +
//                "movingColor=" + movingColor +
//                ", MAX_COORD=" + maxCoord +
//                ", MIN_COORD=" + minCoord +
//                ", figuresOnTheBoard=" + figuresOnTheBoard +
//                '}';
//    }
}
