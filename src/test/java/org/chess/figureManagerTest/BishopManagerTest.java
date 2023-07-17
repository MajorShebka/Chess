package org.chess.figureManagerTest;

import org.chess.entity.FigureManager;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.entity.figureManagerImpl.BishopManager;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BishopManagerTest {
    private Figure bishop;
    private FigureManager manager = new BishopManager();
    Set<Figure> figures = new HashSet<Figure>();

    private Figure initBishop(FigureColor color, Coord startCoord){
        return new Figure(color, FigureType.BISHOP, startCoord,
                new Coord(8, 8), new Coord(1, 1));
    }

    @Test
    public void isCanMoveTest(){
        bishop = initBishop(FigureColor.WHITE, new Coord(3, 3));

        boolean result = manager.isCanMove(bishop, new Coord(1, 1), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(bishop, new Coord(5, 5), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(bishop, new Coord(1, 5), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(bishop, new Coord(5, 1), figures);
        Assertions.assertTrue(result);

        figures.addAll(Arrays.asList(
                new Figure(null, null, new Coord(2, 4), null, null),
                new Figure(null, null, new Coord(2, 2), null, null),
                new Figure(null, null, new Coord(4, 4), null, null),
                new Figure(null, null, new Coord(4, 2), null, null)));

        result = manager.isCanMove(bishop, new Coord(1, 1), figures);
        Assertions.assertFalse(result);
        result = manager.isCanMove(bishop, new Coord(5, 5), figures);
        Assertions.assertFalse(result);
        result = manager.isCanMove(bishop, new Coord(1, 5), figures);
        Assertions.assertFalse(result);
        result = manager.isCanMove(bishop, new Coord(5, 1), figures);
        Assertions.assertFalse(result);

        result = manager.isCanMove(bishop, new Coord(3, 4), figures);
        Assertions.assertFalse(result);
    }

    @Test
    public void isCanTakeTest(){
        bishop = initBishop(FigureColor.WHITE, new Coord(3, 3));

        Figure f1 = new Figure(FigureColor.BLACK, null, new Coord(1, 1), null, null);
        Figure f2 = new Figure(FigureColor.BLACK, null, new Coord(5, 5), null, null);
        Figure f3 = new Figure(FigureColor.BLACK, null, new Coord(5, 1), null, null);
        Figure f4 = new Figure(FigureColor.BLACK, null, new Coord(1, 5), null, null);
        Figure f5 = new Figure(FigureColor.WHITE, null, new Coord(1, 4), null, null);
        Figure f6 = new Figure(FigureColor.BLACK, null, new Coord(3, 2), null, null);

        boolean result = manager.isCanTake(bishop, f1, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(bishop, f2, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(bishop, f3, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(bishop, f4, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(bishop, f5, figures);
        Assertions.assertFalse(result);
        result = manager.isCanTake(bishop, f6, figures);
        Assertions.assertFalse(result);

        figures.addAll(Arrays.asList(
                new Figure(null, null, new Coord(2, 4), null, null),
                new Figure(null, null, new Coord(2, 2), null, null),
                new Figure(null, null, new Coord(4, 4), null, null),
                new Figure(null, null, new Coord(4, 2), null, null)));

        result = manager.isCanTake(bishop, f1, figures);
        Assertions.assertFalse(result);
        result = manager.isCanTake(bishop, f2, figures);
        Assertions.assertFalse(result);
        result = manager.isCanTake(bishop, f3, figures);
        Assertions.assertFalse(result);
        result = manager.isCanTake(bishop, f4, figures);
        Assertions.assertFalse(result);
    }

    @Test
    public void moveOnTest(){
        bishop = initBishop(FigureColor.WHITE, new Coord(3, 3));

        manager.moveOn(bishop, new Coord(4, 4));

        Assertions.assertEquals(new Coord(4, 4), bishop.getPosition());
    }

    @Test
    public void takeTest(){
        bishop = initBishop(FigureColor.WHITE, new Coord(3, 3));
        Figure enemyFigure = new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(4, 4), null, null);

        manager.takeFigure(bishop, enemyFigure);
        Assertions.assertEquals(new Coord(4, 4), bishop.getPosition());
    }
}
