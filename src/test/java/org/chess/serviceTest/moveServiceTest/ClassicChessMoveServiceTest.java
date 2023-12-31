package org.chess.serviceTest.moveServiceTest;

import org.chess.entity.FigureManagerFactory;
import org.chess.entity.GameManager;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.entity.figureManagerFactoryImpl.ClassicalChessFigureManagerFactory;
import org.chess.entity.gameManagerImpl.ClassicChessManager;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;
import org.chess.usecase.exceptions.IncorrectMoveException;
import org.chess.usecase.models.Board;
import org.chess.usecase.models.dto.CoordDTO;
import org.chess.usecase.models.dto.FigureDTO;
import org.chess.usecase.services.gameActionsServiceImpl.ClassicChessGameActions;
import org.chess.usecase.services.moveServiceImpl.ClassicChessMoveService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class ClassicChessMoveServiceTest {
    @Test
    public void makeMoveByQueenTest() throws IncorrectMoveException {
        HashSet<Figure> figures = new HashSet<>();
        FigureManagerFactory factory = new ClassicalChessFigureManagerFactory();

        figures.addAll(Arrays.asList(
                new Figure(FigureColor.WHITE, FigureType.HORSE, new Coord(4, 4), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.KING, new Coord(2, 2), new Coord(8, 8), new Coord(1, 1))
        ));

        Board board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.WHITE);

        ClassicChessMoveService moveService = new ClassicChessMoveService(board, factory);

        moveService.makeMove(new FigureDTO(FigureColor.WHITE, FigureType.HORSE, new Coord(4, 4)), new CoordDTO(3, 6));

        Figure figure = board.getFiguresOnTheBoard().stream().filter(figure1 -> figure1.getType().equals(FigureType.HORSE)).findFirst().get();

        Assertions.assertEquals(new Coord(3, 6), figure.getPosition());


        figures = new HashSet<>();
        figures.addAll(Arrays.asList(
                new Figure(FigureColor.BLACK, FigureType.HORSE, new Coord(4, 4), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.KING, new Coord(2, 2), new Coord(8, 8), new Coord(1, 1))
        ));

        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.WHITE);

        moveService = new ClassicChessMoveService(board, factory);

        try {
            moveService.makeMove(new FigureDTO(FigureColor.BLACK, FigureType.HORSE, new Coord(4, 4)), new CoordDTO(3, 6));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        figure = board.getFiguresOnTheBoard()
                .stream().filter(figure1 -> figure1.getType().equals(FigureType.HORSE)).findFirst().get();

        Assertions.assertEquals(new Coord(4, 4), figure.getPosition());
    }
}
