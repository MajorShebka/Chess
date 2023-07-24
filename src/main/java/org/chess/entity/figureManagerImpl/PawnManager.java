package org.chess.entity.figureManagerImpl;

import org.chess.entity.*;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PawnManager implements FigureManager {
    @Override
    public List<Coord> getCoordsBetween(Figure figure, Coord coord) {
        return new ArrayList<Coord>();
    }

    public boolean isCanMove(Figure movingFigure, Coord moveCoord, Set<Figure> figures) {
        return checkMove(moveCoord, movingFigure);
    }

    private boolean checkMove(Coord moveCoord, Figure movingFigure) {
        return checkDefaultMove(moveCoord, movingFigure) || checkDoubleMove(moveCoord, movingFigure);
    }

    private boolean checkDefaultMove(Coord moveCoord, Figure movingFigure) {
        Coord startCoord = movingFigure.getPosition();
        FigureColor color = movingFigure.getColor();

        if (startCoord.getYCoord() == moveCoord.getYCoord() - getCoff(color)
                && startCoord.getXCoord() == moveCoord.getXCoord()) {
            return true;
        }

        return false;
    }

    private boolean checkDoubleMove(Coord moveCoord, Figure movingFigure) {
        Coord startCoord = movingFigure.getPosition();
        FigureColor color = movingFigure.getColor();

        if (startCoord.getYCoord() == moveCoord.getYCoord() - 2 * getCoff(color)
                && startCoord.getXCoord() == moveCoord.getXCoord()
                && startCoord.getYCoord() == 4.5 - 2.5 * getCoff(color))
            return true;

        return false;
    }

    private int getCoff(FigureColor color) {
        if (color.equals(FigureColor.WHITE)) {
            return 1;
        }

        return -1;
    }

    public boolean isCanTake(Figure takingFigure, Figure takenFigure, Set<Figure> figures) {
        return checkTake(takingFigure, takenFigure)
                && !takingFigure.getColor().equals(takenFigure.getColor());
    }

    private boolean checkTake(Figure takingFigure, Figure takenFigure) {
        return checkDefaultTake(takingFigure, takenFigure);
    }

    private boolean checkDefaultTake(Figure takingFigure, Figure takenFigure) {
        Coord startCoord = takingFigure.getPosition();
        Coord takeCoord = takenFigure.getPosition();
        FigureColor color = takingFigure.getColor();

        return startCoord.getYCoord() == takeCoord.getYCoord() - getCoff(color)
                && Math.abs(startCoord.getXCoord() - takeCoord.getXCoord()) == 1;
    }

    public void moveOn(Figure movingFigure, Coord moveCoord) {
        movingFigure.setPosition(moveCoord);

        if (isTheLastCoord(movingFigure)) {
            movingFigure.setType(FigureType.NON);
        }
    }

    private boolean isTheLastCoord(Figure figure) {
        Coord startCoord = figure.getPosition();
        FigureColor color = figure.getColor();
        Coord maxCoord = figure.getMaxCoord();
        Coord minCoord = figure.getMinCoord();

        return (color.equals(FigureColor.WHITE) && startCoord.getYCoord() == maxCoord.getYCoord())
                || (color.equals(FigureColor.BLACK) && startCoord.getYCoord() == minCoord.getYCoord());
    }

    public void takeFigure(Figure takigFigure, Figure takenFigure) {
        Coord takenCoord = takenFigure.getPosition();

        takigFigure.setPosition(takenCoord);

        if (isTheLastCoord(takigFigure)) {
            takigFigure.setType(FigureType.NON);
        }
    }
}