package org.example.figureManagerTest;

import org.chess.entity.FigureManager;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.entity.figureManagerImpl.QueenManager;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class QueenManagerTest {
    private Figure queen;
    private FigureManager manager = new QueenManager();
    Set<Figure> figures = new HashSet<Figure>();

    private Figure initQueen(FigureColor color, Coord startCoord){
        return new Figure(color, FigureType.QUEEN, startCoord,
                new Coord(8, 8), new Coord(1, 1));
    }

    @Test
    public void isCanMoveTest(){
        queen = initQueen(FigureColor.WHITE, new Coord(3, 3));

        boolean result = manager.isCanMove(queen, new Coord(1, 1), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(queen, new Coord(5, 5), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(queen, new Coord(1, 5), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(queen, new Coord(5, 1), figures);
        Assertions.assertTrue(result);

        figures.addAll(Arrays.asList(
                new Figure(null, null, new Coord(2, 4), null, null),
                new Figure(null, null, new Coord(2, 2), null, null),
                new Figure(null, null, new Coord(4, 4), null, null),
                new Figure(null, null, new Coord(4, 2), null, null)));

        result = manager.isCanMove(queen, new Coord(1, 1), figures);
        Assertions.assertFalse(result);
        result = manager.isCanMove(queen, new Coord(5, 5), figures);
        Assertions.assertFalse(result);
        result = manager.isCanMove(queen, new Coord(1, 5), figures);
        Assertions.assertFalse(result);
        result = manager.isCanMove(queen, new Coord(5, 1), figures);
        Assertions.assertFalse(result);

        figures = new HashSet<>();

        queen = initQueen(FigureColor.WHITE, new Coord(1, 1));
        figures.add(new Figure(FigureColor.WHITE,
                FigureType.PAWN, new Coord(2, 2), null, null));

        result = manager.isCanMove(queen, new Coord(1, 8), figures);
        Assertions.assertTrue(result);

        figures.add(new Figure(FigureColor.WHITE,
                FigureType.PAWN, new Coord(1, 2), null, null));

        result = manager.isCanMove(queen, new Coord(1, 8), figures);
        Assertions.assertFalse(result);

        result = manager.isCanMove(queen, new Coord(8, 1), figures);
        Assertions.assertTrue(result);

        figures.add(new Figure(FigureColor.WHITE,
                FigureType.BISHOP, new Coord(3, 1), null, null));

        result = manager.isCanMove(queen, new Coord(3, 2), figures);
        Assertions.assertFalse(result);
    }

    @Test
    public void isCanTakeTest(){
        queen = initQueen(FigureColor.WHITE, new Coord(3, 3));

        Figure f1 = new Figure(FigureColor.BLACK, null, new Coord(1, 1), null, null);
        Figure f2 = new Figure(FigureColor.BLACK, null, new Coord(5, 5), null, null);
        Figure f3 = new Figure(FigureColor.BLACK, null, new Coord(5, 1), null, null);
        Figure f4 = new Figure(FigureColor.BLACK, null, new Coord(1, 5), null, null);
        Figure f5 = new Figure(FigureColor.WHITE, null, new Coord(1, 4), null, null);
        Figure f6 = new Figure(FigureColor.BLACK, null, new Coord(5, 4), null, null);

        boolean result = manager.isCanTake(queen, f1, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(queen, f2, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(queen, f3, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(queen, f4, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(queen, f5, figures);
        Assertions.assertFalse(result);
        result = manager.isCanTake(queen, f6, figures);
        Assertions.assertFalse(result);

        figures.addAll(Arrays.asList(
                new Figure(null, null, new Coord(2, 4), null, null),
                new Figure(null, null, new Coord(2, 2), null, null),
                new Figure(null, null, new Coord(4, 4), null, null),
                new Figure(null, null, new Coord(4, 2), null, null)));

        result = manager.isCanTake(queen, f1, figures);
        Assertions.assertFalse(result);
        result = manager.isCanTake(queen, f2, figures);
        Assertions.assertFalse(result);
        result = manager.isCanTake(queen, f3, figures);
        Assertions.assertFalse(result);
        result = manager.isCanTake(queen, f4, figures);
        Assertions.assertFalse(result);

        figures = new HashSet<>();

        queen = initQueen(FigureColor.WHITE, new Coord(1, 1));
        Figure enemyFigure = new Figure(FigureColor.BLACK,
                FigureType.PAWN, new Coord(1, 2), null, null);
        figures.add(enemyFigure);

        result = manager.isCanTake(queen, enemyFigure, figures);
        Assertions.assertTrue(result);
        enemyFigure.setColor(FigureColor.WHITE);

        result = manager.isCanTake(queen, enemyFigure, figures);
        Assertions.assertFalse(result);

        Figure figure = new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(1, 3), null, null);
        figures.add(figure);
        result = manager.isCanTake(queen, figure, figures);
        Assertions.assertFalse(result);
    }

    @Test
    public void moveOnTest(){
        queen = initQueen(FigureColor.WHITE, new Coord(3, 3));

        manager.moveOn(queen, new Coord(4, 4));

        Assertions.assertEquals(new Coord(4, 4), queen.getPosition());
    }

    @Test
    public void takeTest(){
        queen = initQueen(FigureColor.WHITE, new Coord(3, 3));
        Figure enemyFigure = new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(4, 4), null, null);

        manager.takeFigure(queen, enemyFigure);
        Assertions.assertEquals(new Coord(4, 4), queen.getPosition());
    }
}
