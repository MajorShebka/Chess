package org.chess.figureManagerTest;

import org.chess.entity.FigureManager;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.entity.figureManagerImpl.HorseManager;
import org.chess.entity.figureManagerImpl.TowerManager;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class HorseManagerTest {
    private Figure horse;
    private FigureManager manager = new HorseManager();
    Set<Figure> figures = new HashSet<Figure>();

    private Figure initHorse(FigureColor color, Coord startCoord){
        return new Figure(color, FigureType.HORSE, startCoord,
                new Coord(8, 8), new Coord(1, 1));
    }

    @Test
    public void isCanMoveTest(){
        horse = initHorse(FigureColor.WHITE, new Coord(3, 3));

        boolean result = manager.isCanMove(horse, new Coord(4, 5), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(horse, new Coord(2, 5), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(horse, new Coord(1, 4), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(horse, new Coord(1, 2), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(horse, new Coord(2, 1), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(horse, new Coord(4, 1), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(horse, new Coord(5, 2), figures);
        Assertions.assertTrue(result);
        result = manager.isCanMove(horse, new Coord(5, 4), figures);
        Assertions.assertTrue(result);

        result = manager.isCanMove(horse, new Coord(3, 4), figures);
        Assertions.assertFalse(result);
    }

    @Test
    public void isCanTakeTest(){
        horse = initHorse(FigureColor.WHITE, new Coord(3, 3));

        Figure f1 = new Figure(FigureColor.BLACK, null, new Coord(4, 5), null, null);
        Figure f2 = new Figure(FigureColor.BLACK, null, new Coord(1, 4), null, null);
        Figure f3 = new Figure(FigureColor.BLACK, null, new Coord(2, 5), null, null);
        Figure f4 = new Figure(FigureColor.BLACK, null, new Coord(1, 4), null, null);
        Figure f5 = new Figure(FigureColor.BLACK, null, new Coord(1, 2), null, null);
        Figure f6 = new Figure(FigureColor.BLACK, null, new Coord(2, 1), null, null);
        Figure f7 = new Figure(FigureColor.BLACK, null, new Coord(4, 1), null, null);
        Figure f8 = new Figure(FigureColor.BLACK, null, new Coord(5, 2), null, null);
        Figure f9 = new Figure(FigureColor.BLACK, null, new Coord(3, 4), null, null);

        boolean result = manager.isCanTake(horse, f1, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(horse, f2, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(horse, f3, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(horse, f4, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(horse, f5, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(horse, f6, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(horse, f7, figures);
        Assertions.assertTrue(result);
        result = manager.isCanTake(horse, f8, figures);
        Assertions.assertTrue(result);

        result = manager.isCanTake(horse, f9, figures);
        Assertions.assertFalse(result);
    }

    @Test
    public void moveOnTest(){
        horse = initHorse(FigureColor.WHITE, new Coord(3, 3));

        manager.moveOn(horse, new Coord(4, 5));

        Assertions.assertEquals(new Coord(4, 5), horse.getPosition());
    }

    @Test
    public void takeTest(){
        horse = initHorse(FigureColor.WHITE, new Coord(3, 3));
        Figure enemyFigure = new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(4, 5), null, null);

        manager.takeFigure(horse, enemyFigure);
        Assertions.assertEquals(new Coord(4, 5), horse.getPosition());
    }
}
