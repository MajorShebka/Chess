package org.chess.entity.figureManagerImpl;

import org.chess.entity.FigureManager;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HorseManager implements FigureManager {
    @Override
    public List<Coord> getCoordsBetween(Figure figure, Coord coord) {
        return new ArrayList<>();
    }

    public boolean isCanMove(Figure movingFigure, Coord moveCoord, Set<Figure> figures) {
        return checkMove(moveCoord, movingFigure);
    }

    private boolean checkMove(Coord moveCoord, Figure movingFigure) {
        int currentXCoord = moveCoord.getXCoord();
        int currentYCoord = moveCoord.getYCoord();
        int futureXCoord = movingFigure.getPosition().getXCoord();
        int futureYCoord = movingFigure.getPosition().getYCoord();

        return (Math.abs(currentXCoord - futureXCoord) == 1 && Math.abs(currentYCoord - futureYCoord) == 2) 
                || (Math.abs(currentXCoord - futureXCoord) == 2 && Math.abs(currentYCoord - futureYCoord) == 1); 
    }

    public boolean isCanTake(Figure takingFigure, Figure takenFigure, Set<Figure> figures) {
        FigureColor takingFigureColor = takingFigure.getColor();
        return checkTake(takenFigure.getPosition(), takingFigure) 
                && !takingFigureColor.equals(takenFigure.getColor());
    }
    
    private boolean checkTake(Coord takeCoord, Figure takingFigure){
        return checkMove(takeCoord, takingFigure);
    }

    public void moveOn(Figure movingFigure, Coord moveCoord) {
        movingFigure.setPosition(moveCoord);
    }

    public void takeFigure(Figure takingFigure, Figure takenFigure) {
        takingFigure.setPosition(takenFigure.getPosition());
    }
}
