package org.chess.figureManagerTest;

import org.chess.entity.FigureManager;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.entity.figureManagerImpl.PawnManager;
import org.chess.entity.figureManagerImpl.TowerManager;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TowerManagerTest {
    private Figure tower;
    private FigureManager manager = new TowerManager();
    Set<Figure> figures = new HashSet<Figure>();

    private Figure initTower(FigureColor color, Coord startCoord){
        return new Figure(color, FigureType.TOWER, startCoord,
                new Coord(8, 8), new Coord(1, 1));
    }

    @Test
    public void isCanMoveTest(){
        tower = initTower(FigureColor.WHITE, new Coord(1, 1));
        figures.add(new Figure(FigureColor.WHITE,
                FigureType.PAWN, new Coord(2, 2), null, null));

        boolean result = manager.isCanMove(tower, new Coord(1, 8), figures);
        Assertions.assertTrue(result);

        figures.add(new Figure(FigureColor.WHITE,
                FigureType.PAWN, new Coord(1, 2), null, null));

        result = manager.isCanMove(tower, new Coord(1, 8), figures);
        Assertions.assertFalse(result);

        result = manager.isCanMove(tower, new Coord(8, 1), figures);
        Assertions.assertTrue(result);

        figures.add(new Figure(FigureColor.WHITE,
                FigureType.BISHOP, new Coord(3, 1), null, null));

        result = manager.isCanMove(tower, new Coord(8, 1), figures);
        Assertions.assertFalse(result);
    }

    @Test
    public void isCanTakeTest(){
        tower = initTower(FigureColor.WHITE, new Coord(1, 1));
        Figure enemyFigure = new Figure(FigureColor.BLACK,
                FigureType.PAWN, new Coord(1, 2), null, null);
        figures.add(enemyFigure);

        boolean result = manager.isCanTake(tower, enemyFigure, figures);
        Assertions.assertTrue(result);
        enemyFigure.setColor(FigureColor.WHITE);

        result = manager.isCanTake(tower, enemyFigure, figures);
        Assertions.assertFalse(result);

        Figure figure = new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(1, 3), null, null);
        figures.add(figure);
        result = manager.isCanTake(tower, figure, figures);
        Assertions.assertFalse(result);
    }

    @Test
    public void moveOnTest(){
        tower = initTower(FigureColor.WHITE, new Coord(3, 3));

        manager.moveOn(tower, new Coord(3, 4));

        Assertions.assertEquals(new Coord(3, 4), tower.getPosition());
    }

    @Test
    public void takeTest(){
        tower = initTower(FigureColor.WHITE, new Coord(3, 3));
        Figure enemyFigure = new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(3, 4), null, null);

        manager.takeFigure(tower, enemyFigure);
        Assertions.assertEquals(new Coord(3, 4), tower.getPosition());
    }
}
