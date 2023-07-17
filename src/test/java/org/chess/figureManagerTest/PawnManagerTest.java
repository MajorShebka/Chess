package org.chess.figureManagerTest;

import org.chess.entity.FigureManager;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.entity.figureManagerImpl.PawnManager;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class PawnManagerTest {
    private Figure pawn;
    private FigureManager manager = new PawnManager();
    Set<Figure> figures = new HashSet<Figure>();

    private Figure initPawn(FigureColor color, Coord startCoord){
        return new Figure(color, FigureType.PAWN, startCoord,
                new Coord(8, 8), new Coord(1, 1));
    }

    @Test
    public void isCanMoveOnOneSquareAheadByWhitePawnTest(){
        pawn = initPawn(FigureColor.WHITE, new Coord(1, 2));

        boolean result = manager.isCanMove(pawn, new Coord(1, 3), figures);
        Assertions.assertTrue(result);

        pawn = initPawn(FigureColor.WHITE, new Coord(2, 5));

        result = manager.isCanMove(pawn, new Coord(2, 6), figures);
        Assertions.assertTrue(result);

        result = manager.isCanMove(pawn, new Coord(2, 4), figures);
        Assertions.assertFalse(result);
    }

    @Test
    public void isCanMoveOnTwoSquaresAheadByWhitePawnFromTest(){
        pawn = initPawn(FigureColor.WHITE, new Coord(1, 2));

        boolean result = manager.isCanMove(pawn, new Coord(1, 4), figures);
        Assertions.assertTrue(result);

        pawn = initPawn(FigureColor.WHITE, new Coord(1,3));

        result = manager.isCanMove(pawn, new Coord(1,5), figures);
        Assertions.assertFalse(result);

        pawn = initPawn(FigureColor.WHITE, new Coord(1,4));

        result = manager.isCanMove(pawn, new Coord(1,2), figures);
        Assertions.assertFalse(result);
    }

    @Test
    public void isCanMoveOnOneSquareAheadByBlackPawnTest(){
        pawn = initPawn(FigureColor.BLACK, new Coord(2, 7));

        boolean result = manager.isCanMove(pawn, new Coord(2, 6), figures);
        Assertions.assertTrue(result);

        result = manager.isCanMove(pawn, new Coord(2, 4), figures);
        Assertions.assertFalse(result);

        result = manager.isCanMove(pawn, new Coord(2, 8), figures);
        Assertions.assertFalse(result);
    }

    @Test
    public void isCanMoveOnTwoSquaresAheadByBlackPawnFromTest(){
        pawn = initPawn(FigureColor.BLACK, new Coord(2, 7));

        boolean result = manager.isCanMove(pawn, new Coord(2, 5), figures);
        Assertions.assertTrue(result);

        pawn = initPawn(FigureColor.BLACK, new Coord(2,6));

        result = manager.isCanMove(pawn, new Coord(2,4), figures);
        Assertions.assertFalse(result);

        result = manager.isCanMove(pawn, new Coord(2,7), figures);
        Assertions.assertFalse(result);
    }

    @Test
    public void isCanTakeWhitePawnTheBlackPawnTest(){
        pawn = initPawn(FigureColor.WHITE, new Coord(2,3));
        Figure takenPawn = initPawn(FigureColor.BLACK, new Coord(3, 4));

        boolean result = manager.isCanTake(pawn, takenPawn, figures);
        Assertions.assertTrue(result);

        pawn = initPawn(FigureColor.WHITE, new Coord(2,3));
        takenPawn = initPawn(FigureColor.BLACK, new Coord(1, 4));

        result = manager.isCanTake(pawn, takenPawn, figures);
        Assertions.assertTrue(result);

        pawn = initPawn(FigureColor.WHITE, new Coord(2,3));
        takenPawn = initPawn(FigureColor.BLACK, new Coord(3, 5));

        result = manager.isCanTake(pawn, takenPawn, figures);
        Assertions.assertFalse(result);

        pawn = initPawn(FigureColor.WHITE, new Coord(2,3));
        takenPawn = initPawn(FigureColor.BLACK, new Coord(2, 4));

        result = manager.isCanTake(pawn, takenPawn, figures);
        Assertions.assertFalse(result);
    }

    @Test
    public void isCanTakeBlackPawnTheWhitePawnTest(){
        pawn = initPawn(FigureColor.BLACK, new Coord(2,3));
        Figure takenPawn = initPawn(FigureColor.WHITE, new Coord(3, 2));

        boolean result = manager.isCanTake(pawn, takenPawn, figures);
        Assertions.assertTrue(result);

        takenPawn = initPawn(FigureColor.WHITE, new Coord(1, 2));

        result = manager.isCanTake(pawn, takenPawn, figures);
        Assertions.assertTrue(result);

        takenPawn = initPawn(FigureColor.BLACK, new Coord(3, 4));

        result = manager.isCanTake(pawn, takenPawn, figures);
        Assertions.assertFalse(result);

        takenPawn = initPawn(FigureColor.BLACK, new Coord(2, 2));

        result = manager.isCanTake(pawn, takenPawn, figures);
        Assertions.assertFalse(result);
    }

    @Test
    public void moveOnTest(){
        pawn = initPawn(FigureColor.WHITE, new Coord(1, 2));

        manager.moveOn(pawn, new Coord(1, 3));
        Assertions.assertEquals(new Coord(1, 3), pawn.getPosition());

        pawn = initPawn(FigureColor.BLACK, new Coord(1, 3));

        manager.moveOn(pawn, new Coord(1, 2));
        Assertions.assertEquals(new Coord(1, 2), pawn.getPosition());
    }

    @Test
    public void moveOnLastCoordTest(){
        pawn = initPawn(FigureColor.WHITE, new Coord(1, 7));

        manager.moveOn(pawn, new Coord(1, 8));
        Assertions.assertEquals(FigureType.NON, pawn.getType());

        pawn = initPawn(FigureColor.BLACK, new Coord(1, 2));

        manager.moveOn(pawn, new Coord(1, 1));
        Assertions.assertEquals(FigureType.NON, pawn.getType());
    }

    @Test
    public void takeTest(){
        pawn = initPawn(FigureColor.WHITE, new Coord(1, 2));
        Figure takenFigure = initPawn(FigureColor.BLACK, new Coord(2, 3));

        manager.takeFigure(pawn, takenFigure);
        Assertions.assertEquals(new Coord(2, 3), pawn.getPosition());

        pawn = initPawn(FigureColor.BLACK, new Coord(1, 3));
        takenFigure = initPawn(FigureColor.WHITE, new Coord(2, 2));

        manager.takeFigure(pawn, takenFigure);
        Assertions.assertEquals(new Coord(2, 2), pawn.getPosition());
    }

    @Test
    public void takeOnLastCoordTest(){
        pawn = initPawn(FigureColor.WHITE, new Coord(1, 7));
        Figure takenFigure = initPawn(FigureColor.BLACK, new Coord(2, 8));

        manager.takeFigure(pawn, takenFigure);
        Assertions.assertEquals(FigureType.NON, pawn.getType());

        pawn = initPawn(FigureColor.BLACK, new Coord(1, 2));
        takenFigure = initPawn(FigureColor.WHITE, new Coord(2, 1));

        manager.takeFigure(pawn, takenFigure);
        Assertions.assertEquals(FigureType.NON, pawn.getType());
    }
}
