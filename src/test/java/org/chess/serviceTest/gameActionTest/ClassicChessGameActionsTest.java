package org.chess.serviceTest.gameActionTest;

import org.chess.entity.FigureManagerFactory;
import org.chess.entity.GameManager;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.entity.figureManagerFactoryImpl.ClassicChessFigureManagerFactory;
import org.chess.entity.gameManagerImpl.ClassicChessManager;
import org.chess.entity.models.Coord;
import org.chess.usecase.models.Board;
import org.chess.usecase.models.dto.CoordDTO;
import org.chess.usecase.models.dto.FigureDTO;
import org.chess.usecase.services.gameActionsServiceImpl.ClassicChessGameActions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class ClassicChessGameActionsTest {
    @Test
    public void isCheckTest(){
        HashSet<FigureDTO> figures = new HashSet<>();
        GameManager gm = new ClassicChessManager();
        FigureManagerFactory factory = new ClassicChessFigureManagerFactory();

        figures.addAll(Arrays.asList(
                new FigureDTO(FigureColor.WHITE, FigureType.HORSE, new CoordDTO(4, 4)),
                new FigureDTO(FigureColor.BLACK, FigureType.KING, new CoordDTO(3, 2))
        ));

        Board board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        ClassicChessGameActions gameActions = new ClassicChessGameActions(board, factory, gm);

        boolean result = gameActions.isCheck();
        Assertions.assertTrue(result);
    }

    @Test
    public void isMateTest(){
        HashSet<FigureDTO> figures = new HashSet<>();
        GameManager gm = new ClassicChessManager();
        FigureManagerFactory factory = new ClassicChessFigureManagerFactory();

        figures.addAll(Arrays.asList(
                new FigureDTO(FigureColor.WHITE, FigureType.HORSE, new CoordDTO(6, 6)),
                new FigureDTO(FigureColor.WHITE, FigureType.TOWER, new CoordDTO(7, 8)),
                new FigureDTO(FigureColor.WHITE, FigureType.PAWN, new CoordDTO(7, 5)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(7, 6)),
                new FigureDTO(FigureColor.BLACK, FigureType.HORSE, new CoordDTO(6, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(8, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.KING, new CoordDTO(7, 7))
        ));

        Board board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        ClassicChessGameActions gameActions = new ClassicChessGameActions(board, factory, gm);

        boolean result = gameActions.isMate();
        Assertions.assertTrue(result);

        figures = new HashSet<>();

        figures.addAll(Arrays.asList(
                new FigureDTO(FigureColor.WHITE, FigureType.HORSE, new CoordDTO(6, 6)),
                new FigureDTO(FigureColor.WHITE, FigureType.TOWER, new CoordDTO(7, 8)),
                new FigureDTO(FigureColor.WHITE, FigureType.TOWER, new CoordDTO(7, 5)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(7, 6)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(8, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.KING, new CoordDTO(7, 7))
        ));

        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        gameActions = new ClassicChessGameActions(board, factory, gm);

        result = gameActions.isMate();
        Assertions.assertFalse(result);

        figures = new HashSet<>();

        figures.addAll(Arrays.asList(
                new FigureDTO(FigureColor.WHITE, FigureType.HORSE, new CoordDTO(3, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(1, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(2, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.TOWER, new CoordDTO(2, 8)),
                new FigureDTO(FigureColor.BLACK, FigureType.KING, new CoordDTO(1, 8))
        ));

        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        gameActions = new ClassicChessGameActions(board, factory, gm);

        result = gameActions.isMate();
        Assertions.assertTrue(result);

        figures = new HashSet<>();

        figures.addAll(Arrays.asList(
                new FigureDTO(FigureColor.WHITE, FigureType.HORSE, new CoordDTO(3, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(1, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(2, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.KING, new CoordDTO(1, 8))
        ));

        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        gameActions = new ClassicChessGameActions(board, factory, gm);

        result = gameActions.isMate();
        Assertions.assertFalse(result);

        figures = new HashSet<>();

        figures.addAll(Arrays.asList(
                new FigureDTO(FigureColor.WHITE, FigureType.HORSE, new CoordDTO(3, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(1, 7)),
                new FigureDTO(FigureColor.WHITE, FigureType.PAWN, new CoordDTO(2, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.TOWER, new CoordDTO(2, 8)),
                new FigureDTO(FigureColor.BLACK, FigureType.KING, new CoordDTO(1, 8))
        ));

        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        gameActions = new ClassicChessGameActions(board, factory, gm);

        result = gameActions.isMate();
        Assertions.assertFalse(result);

        figures = new HashSet<>();

        figures.addAll(Arrays.asList(
                new FigureDTO(FigureColor.WHITE, FigureType.HORSE, new CoordDTO(4, 7)),
                new FigureDTO(FigureColor.WHITE, FigureType.TOWER, new CoordDTO(1, 5)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(2, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.KING, new CoordDTO(1, 7))
        ));

        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        gameActions = new ClassicChessGameActions(board, factory, gm);

        result = gameActions.isMate();
        Assertions.assertTrue(result);

        figures = new HashSet<>();

        figures.addAll(Arrays.asList(
                new FigureDTO(FigureColor.WHITE, FigureType.HORSE, new CoordDTO(4, 7)),
                new FigureDTO(FigureColor.WHITE, FigureType.TOWER, new CoordDTO(1, 5)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(2, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.QUEEN, new CoordDTO(1, 1)),
                new FigureDTO(FigureColor.BLACK, FigureType.KING, new CoordDTO(1, 7))
        ));

        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        gameActions = new ClassicChessGameActions(board, factory, gm);

        result = gameActions.isMate();
        Assertions.assertFalse(result);

        figures = new HashSet<>();

        figures.addAll(Arrays.asList(
                new FigureDTO(FigureColor.WHITE, FigureType.HORSE, new CoordDTO(4, 7)),
                new FigureDTO(FigureColor.WHITE, FigureType.TOWER, new CoordDTO(1, 5)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(2, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.BISHOP, new CoordDTO(6, 1)),
                new FigureDTO(FigureColor.BLACK, FigureType.KING, new CoordDTO(1, 7))
        ));

        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.BLACK);

        gameActions = new ClassicChessGameActions(board, factory, gm);

        result = gameActions.isMate();
        Assertions.assertFalse(result);
    }
}
