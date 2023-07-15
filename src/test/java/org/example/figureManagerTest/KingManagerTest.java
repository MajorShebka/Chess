package org.example.figureManagerTest;

import org.chess.entity.FigureManager;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.entity.figureManagerImpl.KingManager;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KingManagerTest {
    private Figure king;
    private FigureManager manager = new KingManager();
    Set<Figure> figures = new HashSet<Figure>();

    private Figure initKing(FigureColor color, Coord startCoord) {
        return new Figure(color, FigureType.KING, startCoord,
                new Coord(8, 8), new Coord(1, 1));
    }

    @Test
    public void isCanMoveTest() {
        king = initKing(FigureColor.WHITE, new Coord(3, 3));

        boolean result = manager.isCanMove(king, new Coord(3, 4), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(king, new Coord(4, 4), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(king, new Coord(4, 3), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(king, new Coord(4, 2), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(king, new Coord(3, 2), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(king, new Coord(2, 2), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(king, new Coord(2, 3), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(king, new Coord(2, 4), figures);
        Assertions.assertTrue(result);

        result = manager.isCanMove(king, new Coord(3, 1), figures);
        Assertions.assertFalse(result);
    }

    @Test
    public void isCanTakeTest() {
        king = initKing(FigureColor.WHITE, new Coord(3, 3));

        Figure f1 = new Figure(FigureColor.BLACK, null, new Coord(3, 4), null, null);
        Figure f2 = new Figure(FigureColor.BLACK, null, new Coord(4, 4), null, null);
        Figure f3 = new Figure(FigureColor.BLACK, null, new Coord(4, 3), null, null);
        Figure f4 = new Figure(FigureColor.BLACK, null, new Coord(4, 2), null, null);
        Figure f5 = new Figure(FigureColor.BLACK, null, new Coord(3, 2), null, null);
        Figure f6 = new Figure(FigureColor.BLACK, null, new Coord(2, 2), null, null);
        Figure f7 = new Figure(FigureColor.BLACK, null, new Coord(2, 3), null, null);
        Figure f8 = new Figure(FigureColor.BLACK, null, new Coord(2, 4), null, null);
        Figure f9 = new Figure(FigureColor.BLACK, null, new Coord(1, 1), null, null);

        boolean result = manager.isCanTake(king, f1, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(king, f2, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(king, f3, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(king, f4, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(king, f5, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(king, f6, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(king, f7, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(king, f8, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(king, f9, figures);
        Assertions.assertFalse(result);

        f1 = new Figure(FigureColor.WHITE, null, new Coord(3, 4), null, null);
        f2 = new Figure(FigureColor.WHITE, null, new Coord(4, 4), null, null);
        f3 = new Figure(FigureColor.WHITE, null, new Coord(4, 3), null, null);
        f4 = new Figure(FigureColor.WHITE, null, new Coord(4, 2), null, null);
        f5 = new Figure(FigureColor.WHITE, null, new Coord(3, 2), null, null);
        f6 = new Figure(FigureColor.WHITE, null, new Coord(2, 2), null, null);
        f7 = new Figure(FigureColor.WHITE, null, new Coord(2, 3), null, null);
        f8 = new Figure(FigureColor.WHITE, null, new Coord(2, 4), null, null);

        result = manager.isCanTake(king, f1, figures);
        Assertions.assertFalse(result);
        result = manager.isCanTake(king, f2, figures);
        Assertions.assertFalse(result);
        result = manager.isCanTake(king, f3, figures);
        Assertions.assertFalse(result);
        result = manager.isCanTake(king, f4, figures);
        Assertions.assertFalse(result);
        result = manager.isCanTake(king, f5, figures);
        Assertions.assertFalse(result);
        result = manager.isCanTake(king, f6, figures);
        Assertions.assertFalse(result);
        result = manager.isCanTake(king, f7, figures);
        Assertions.assertFalse(result);
        result = manager.isCanTake(king, f8, figures);
        Assertions.assertFalse(result);
    }

    @Test
    public void moveOnTest(){
        king = initKing(FigureColor.WHITE, new Coord(3, 3));

        manager.moveOn(king, new Coord(4, 4));

        Assertions.assertEquals(new Coord(4, 4), king.getPosition());
    }

    @Test
    public void takeTest(){
        king = initKing(FigureColor.WHITE, new Coord(3, 3));
        Figure enemyFigure = new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(4, 4), null, null);

        manager.takeFigure(king, enemyFigure);
        Assertions.assertEquals(new Coord(4, 4), king.getPosition());
    }
}
