package org.chess.serviceTest.gameActionTest;

import org.chess.entity.FigureManagerFactory;
import org.chess.entity.GameManager;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.entity.figureManagerFactoryImpl.ClassicalChessFigureManagerFactory;
import org.chess.entity.gameManagerImpl.ClassicChessManager;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;
import org.chess.usecase.models.Board;
import org.chess.usecase.services.gameActionsServiceImpl.ClassicChessGameActions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class ClassicChessGameActionsTest {
    @Test
    public void isCheckTest(){
        HashSet<Figure> figures = new HashSet<>();
        GameManager gm = new ClassicChessManager();
        FigureManagerFactory factory = new ClassicalChessFigureManagerFactory();

        figures.addAll(Arrays.asList(
                new Figure(FigureColor.WHITE, FigureType.HORSE, new Coord(4, 4), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.KING, new Coord(3, 2), new Coord(8, 8), new Coord(1, 1))
        ));

        Board board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        ClassicChessGameActions gameActions = new ClassicChessGameActions(board, factory, gm);

        boolean result = gameActions.isCheck();
        Assertions.assertTrue(result);
    }

    @Test
    public void isMateTest(){
        HashSet<Figure> figures = new HashSet<>();
        GameManager gm = new ClassicChessManager();
        FigureManagerFactory factory = new ClassicalChessFigureManagerFactory();

        figures.addAll(Arrays.asList(
                new Figure(FigureColor.WHITE, FigureType.HORSE, new Coord(6, 6), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.WHITE, FigureType.TOWER, new Coord(7, 8), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.WHITE, FigureType.PAWN, new Coord(7, 5), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(7, 6), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.HORSE, new Coord(6, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(8, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.KING, new Coord(7, 7), new Coord(8, 8), new Coord(1, 1))
        ));

        Board board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        ClassicChessGameActions gameActions = new ClassicChessGameActions(board, factory, gm);

        boolean result = gameActions.isMate();
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

        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        gameActions = new ClassicChessGameActions(board, factory, gm);

        result = gameActions.isMate();
        Assertions.assertFalse(result);

        figures = new HashSet<>();

        figures.addAll(Arrays.asList(
                new Figure(FigureColor.WHITE, FigureType.HORSE, new Coord(3, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(1, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(2, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.TOWER, new Coord(2, 8), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.KING, new Coord(1, 8), new Coord(8, 8), new Coord(1, 1))
        ));

        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        gameActions = new ClassicChessGameActions(board, factory, gm);

        result = gameActions.isMate();
        Assertions.assertTrue(result);

        figures = new HashSet<>();

        figures.addAll(Arrays.asList(
                new Figure(FigureColor.WHITE, FigureType.HORSE, new Coord(3, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(1, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(2, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.KING, new Coord(1, 8), new Coord(8, 8), new Coord(1, 1))
        ));

        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        gameActions = new ClassicChessGameActions(board, factory, gm);

        result = gameActions.isMate();
        Assertions.assertFalse(result);

        figures = new HashSet<>();

        figures.addAll(Arrays.asList(
                new Figure(FigureColor.WHITE, FigureType.HORSE, new Coord(3, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(1, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.WHITE, FigureType.PAWN, new Coord(2, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.TOWER, new Coord(2, 8), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.KING, new Coord(1, 8), new Coord(8, 8), new Coord(1, 1))
        ));

        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        gameActions = new ClassicChessGameActions(board, factory, gm);

        result = gameActions.isMate();
        Assertions.assertFalse(result);

        figures = new HashSet<>();

        figures.addAll(Arrays.asList(
                new Figure(FigureColor.WHITE, FigureType.HORSE, new Coord(4, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.WHITE, FigureType.TOWER, new Coord(1, 5), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(2, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.KING, new Coord(1, 7), new Coord(8, 8), new Coord(1, 1))
        ));

        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        gameActions = new ClassicChessGameActions(board, factory, gm);

        result = gameActions.isMate();
        Assertions.assertTrue(result);

        figures = new HashSet<>();

        figures.addAll(Arrays.asList(
                new Figure(FigureColor.WHITE, FigureType.HORSE, new Coord(4, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.WHITE, FigureType.TOWER, new Coord(1, 5), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(2, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.QUEEN, new Coord(1, 1), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.KING, new Coord(1, 7), new Coord(8, 8), new Coord(1, 1))
        ));

        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        gameActions = new ClassicChessGameActions(board, factory, gm);

        result = gameActions.isMate();
        Assertions.assertFalse(result);

        figures = new HashSet<>();

        figures.addAll(Arrays.asList(
                new Figure(FigureColor.WHITE, FigureType.HORSE, new Coord(4, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.WHITE, FigureType.TOWER, new Coord(1, 5), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(2, 7), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.BISHOP, new Coord(6, 1), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.KING, new Coord(1, 7), new Coord(8, 8), new Coord(1, 1))
        ));

        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        gameActions = new ClassicChessGameActions(board, factory, gm);

        result = gameActions.isMate();
        Assertions.assertFalse(result);
    }
}
