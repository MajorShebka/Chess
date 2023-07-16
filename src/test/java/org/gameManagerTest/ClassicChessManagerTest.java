package org.gameManagerTest;

import org.chess.entity.GameManager;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.entity.gameManagerImpl.ClassicChessManager;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class ClassicChessManagerTest {
    @Test
    public void isCheckTest(){
        HashSet<Figure> figures = new HashSet<>();
        GameManager gm = new ClassicChessManager();

        figures.addAll(Arrays.asList(
                new Figure(FigureColor.WHITE, FigureType.HORSE, new Coord(4, 4), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.KING, new Coord(3, 2), new Coord(8, 8), new Coord(1, 1))
        ));

        boolean result = gm.isCheck(figures, FigureColor.BLACK);
        Assertions.assertTrue(result);
    }

    @Test
    public void isMateTest(){
        HashSet<Figure> figures = new HashSet<>();
        GameManager gm = new ClassicChessManager();

        figures.addAll(Arrays.asList(
                new Figure(FigureColor.WHITE, FigureType.HORSE, new Coord(6, 6), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.WHITE, FigureType.TOWER, new Coord(7, 8), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.WHITE, FigureType.TOWER, new Coord(7, 5), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(7, 6), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.HORSE, new Coord(6, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(8, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.KING, new Coord(7, 7), new Coord(8, 8), new Coord(1, 1))
        ));

        boolean result = gm.isMate(figures, FigureColor.BLACK);
        Assertions.assertTrue(result);

        figures = new HashSet<>();

        figures.addAll(Arrays.asList(
                new Figure(FigureColor.WHITE, FigureType.HORSE, new Coord(6, 6), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.WHITE, FigureType.TOWER, new Coord(7, 8), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.WHITE, FigureType.TOWER, new Coord(7, 5), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(7, 6), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(8, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.KING, new Coord(7, 7), new Coord(8, 8), new Coord(1, 1))
        ));

        result = gm.isMate(figures, FigureColor.BLACK);
        Assertions.assertTrue(result);
    }
}
