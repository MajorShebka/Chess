package org.chess.entity.figureManagerImpl;

import org.chess.entity.FigureManager;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class QueenManager implements FigureManager {
    @Override
    public List<Coord> getCoordsBetween(Figure figure, Coord coord) {
        return getCoords(coord, figure);
    }

    public boolean isCanMove(Figure movingFigure, Coord moveCoord, Set<Figure> figures) {
        return checkMove(moveCoord, movingFigure) && !checkFigureOnTheWay(figures, movingFigure, moveCoord);
    }

    private boolean checkMove(Coord newCoord, Figure movingFigure){
        return checkHorizontal(newCoord, movingFigure)
                || checkVertical(newCoord, movingFigure)
                || checkRightDiagonal(newCoord, movingFigure)
                || checkLeftDiagonal(newCoord, movingFigure);
    }

    private boolean checkHorizontal(Coord newCoord, Figure figure){
        Coord figureCoord = figure.getPosition();
        return newCoord.getYCoord() == figureCoord.getYCoord();
    }

    private boolean checkVertical(Coord newCoord, Figure figure){
        Coord figureCoord = figure.getPosition();
        return newCoord.getXCoord() == figureCoord.getXCoord();
    }

    private boolean checkRightDiagonal(Coord newCoord, Figure figure){
        Coord figureCoord = figure.getPosition();

        return newCoord.getXCoord() - figureCoord.getXCoord() == figureCoord.getYCoord() - newCoord.getYCoord();
    }

    private boolean checkLeftDiagonal(Coord newCoord, Figure figure){
        Coord figureCoord = figure.getPosition();

        return newCoord.getXCoord() - figureCoord.getXCoord() == newCoord.getYCoord() - figureCoord.getYCoord();
    }

    public boolean checkFigureOnTheWay(Set<Figure> figures, Figure figure, Coord newCoord){
        List<Coord> coords = getCoords(newCoord, figure);

        for (Figure nextFigure : figures) {
            for (Coord nextCoord : coords) {
                if(nextCoord.getXCoord() == nextFigure.getPosition().getXCoord()
                        && nextCoord.getYCoord() == nextFigure.getPosition().getYCoord()){
                    return true;
                }
            }
        }
        return false;
    }

    private List<Coord> getCoords(Coord newCoord, Figure figure){
        List<Coord> coords = new ArrayList<Coord>();
        Coord coff = getCoff(newCoord, figure);
        Coord figureCoord = figure.getPosition();

        Coord presentCoord = new Coord(figureCoord.getXCoord() + coff.getXCoord(),
                figureCoord.getYCoord() + coff.getYCoord());

        while(presentCoord.getXCoord() != newCoord.getXCoord()
                || presentCoord.getYCoord() != newCoord.getYCoord()){
            coords.add(presentCoord);
            presentCoord = new Coord(presentCoord.getXCoord() + coff.getXCoord(), presentCoord.getYCoord() + coff.getYCoord());
        }

        return coords;
    }

    private Coord getCoff(Coord newCoord, Figure figure){
        Coord figureCoord = figure.getPosition();

        int bX = figureCoord.getXCoord() < newCoord.getXCoord()
                ? 1
                : (figureCoord.getXCoord() == newCoord.getXCoord() ? 0 : -1);
        int bY = figureCoord.getYCoord() < newCoord.getYCoord()
                ? 1
                : (figureCoord.getYCoord() == newCoord.getYCoord() ? 0 : -1);

        return new Coord(bX, bY);
    }

    public boolean isCanTake(Figure takingFigure, Figure takenFigure, Set<Figure> figures) {
        FigureColor takingFigureColor = takingFigure.getColor();

        return checkTake(takenFigure.getPosition(), takingFigure)
                && !takingFigureColor.equals(takenFigure.getColor())
                && !checkFigureOnTheWay(figures, takingFigure, takenFigure.getPosition());
    }

    private boolean checkTake(Coord newCoord, Figure takingFigure){
        return checkHorizontal(newCoord, takingFigure)
                || checkVertical(newCoord, takingFigure)
                || checkLeftDiagonal(newCoord, takingFigure)
                || checkRightDiagonal(newCoord, takingFigure);
    }

    public void moveOn(Figure movingFigure, Coord moveCoord) {
        movingFigure.setPosition(moveCoord);
    }

    public void takeFigure(Figure takingFigure, Figure takenFigure) {
        takingFigure.setPosition(takingFigure.getPosition());
    }
}
