package org.chess.entity.figureManagerImpl;

import org.chess.entity.FigureManager;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class KingManager implements FigureManager {
    @Override
    public List<Coord> getCoordsBetween(Figure figure, Coord coord) {
        return new ArrayList<>();
    }

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

        return newCoord.getYCoord() == newCoord.getYCoord()
                && Math.abs(currentYCoord - futureYCoord) == 1;
    }

    private boolean checkVertical(Coord newCoord, Figure figure) {
        int currentXCoord = figure.getPosition().getXCoord();
        int futureXCoord = newCoord.getXCoord();

        return newCoord.getXCoord() == newCoord.getXCoord()
                && Math.abs(currentXCoord - futureXCoord) == 1;
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
        takenFigure.setPosition(new Coord(0, 0));
    }

    public List<Coord> getMoveCoords(Figure king, Set<Figure> figures){
        final int[][] moveCoffs = new int[][]{{1, 0}, {0, 1}, {1, 1}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        List<Coord> coords = new ArrayList<>();

        for(int i = 0; i < moveCoffs.length; i++){
            int newXCoord = king.getPosition().getXCoord() + moveCoffs[i][0];
            int newYCoord = king.getPosition().getYCoord() + moveCoffs[i][1];
            Coord moveCoord = new Coord(newXCoord, newYCoord);

            if(newXCoord > king.getMaxCoord().getXCoord() || newXCoord < king.getMinCoord().getXCoord()
                    || newYCoord > king.getMaxCoord().getYCoord() || newYCoord < king.getMinCoord().getYCoord()){
                continue;
            }

            if(isCanMove(king, moveCoord, figures)){
                coords.add(moveCoord);
            }

            Figure figure = getFigureByCoord(moveCoord, figures);

            if (figure != null && isCanTake(king, figure, figures)){
                coords.add(moveCoord);
            }
        }

        return coords;
    }

    private Figure getFigureByCoord(Coord coord, Set<Figure> figures){
        for (Figure figure : figures) {
            if(figure.getPosition().equals(coord)){
                return figure;
            }
        }

        //TODO: do something with this!!!
        return null;
    }
}
