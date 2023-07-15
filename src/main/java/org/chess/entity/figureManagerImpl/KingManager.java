package org.chess.entity.figureManagerImpl;

import org.chess.entity.FigureManager;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;

import java.util.Set;

public class KingManager implements FigureManager {

    public boolean isCanMove(Figure movingFigure, Coord moveCoord, Set<Figure> figures) {
        return checkMove(moveCoord, movingFigure);
    }

    private boolean checkMove(Coord moveCoord, Figure movingFigure) {
        return checkHorizontal(moveCoord, movingFigure)
                || checkVertical(moveCoord, movingFigure)
                || checkDiagonals(moveCoord, movingFigure);
    }

    private boolean checkHorizontal(Coord newCoord, Figure figure) {
        int currentYCoord = figure.getPosition().getYCoord();
        int futureYCoord = newCoord.getYCoord();
        int currentXCoord = figure.getPosition().getXCoord();
        int futureXCoord = newCoord.getXCoord();

        return currentYCoord == futureYCoord
                && Math.abs(currentXCoord - futureXCoord) == 1;
    }

    private boolean checkVertical(Coord newCoord, Figure figure) {
        int currentXCoord = figure.getPosition().getXCoord();
        int futureXCoord = newCoord.getXCoord();
        int currentYCoord = figure.getPosition().getYCoord();
        int futureYCoord = newCoord.getYCoord();

        return currentXCoord == futureXCoord
                && Math.abs(currentYCoord - futureYCoord) == 1;
    }

    private boolean checkDiagonals(Coord newCoord, Figure figure){
        int currentXCoord = figure.getPosition().getXCoord();
        int futureXCoord = newCoord.getXCoord();
        int currentYCoord = figure.getPosition().getYCoord();
        int futureYCoord = newCoord.getYCoord();

        return  Math.abs(currentXCoord - futureXCoord) == 1
                && Math.abs(currentYCoord - futureYCoord) == 1;
    }

    public boolean isCanTake(Figure takingFigure, Figure takenFigure, Set<Figure> figures) {
        FigureColor takingFigureColor = takingFigure.getColor();

        return checkTake(takenFigure.getPosition(), takingFigure)
                && !takingFigureColor.equals(takenFigure.getColor());
    }

    private boolean checkTake(Coord takeCoord, Figure takingFigure){
        return checkHorizontal(takeCoord, takingFigure)
                || checkVertical(takeCoord, takingFigure)
                || checkDiagonals(takeCoord, takingFigure);
    }

    public void moveOn(Figure movingFigure, Coord moveCoord) {
        movingFigure.setPosition(moveCoord);
    }

    public void takeFigure(Figure takingFigure, Figure takenFigure) {
        takingFigure.setPosition(takenFigure.getPosition());
    }
}
