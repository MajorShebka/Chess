package org.chess.serviceTest.takeServiceTest;

import org.chess.entity.FigureManagerFactory;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.entity.figureManagerFactoryImpl.ClassicalChessFigureManagerFactory;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;
import org.chess.usecase.exceptions.IncorrectMoveException;
import org.chess.usecase.exceptions.IncorrectTakeException;
import org.chess.usecase.models.Board;
import org.chess.usecase.models.dto.FigureDTO;
import org.chess.usecase.services.takeServiceImpl.ClassicChessTakeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class ClassicChessTakeServiceTest {
    @Test
    public void makeMoveByQueenTest() throws IncorrectTakeException {
        HashSet<Figure> figures = new HashSet<>();
        FigureManagerFactory factory = new ClassicalChessFigureManagerFactory();

        figures.addAll(Arrays.asList(
                new Figure(FigureColor.WHITE, FigureType.HORSE, new Coord(4, 4), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(3, 6), new Coord(8, 8), new Coord(1, 1))
        ));

        Board board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.WHITE);

        ClassicChessTakeService takeService = new ClassicChessTakeService(board, factory);

        takeService.take(new FigureDTO(FigureColor.WHITE, FigureType.HORSE, new Coord(4, 4)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new Coord(3, 6)));

        Figure figure = board.getFiguresOnTheBoard().stream().filter(figure1 -> figure1.getType().equals(FigureType.HORSE)).findFirst().get();

        Assertions.assertEquals(new Coord(3, 6), figure.getPosition());


        figures = new HashSet<>();
        figures.addAll(Arrays.asList(
                new Figure(FigureColor.BLACK, FigureType.HORSE, new Coord(4, 4), new Coord(8, 8), new Coord(1, 1)),
                new Figure(FigureColor.BLACK, FigureType.PAWN, new Coord(2, 2), new Coord(8, 8), new Coord(1, 1))
        ));

        board = new Board(new Coord(8,8), new Coord(1, 1), figures, FigureColor.WHITE);

        takeService = new ClassicChessTakeService(board, factory);

        try {
            takeService.take(new FigureDTO(FigureColor.BLACK, FigureType.HORSE, new Coord(4, 4))
                    , new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new Coord(2, 2)));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        figure = board.getFiguresOnTheBoard()
                .stream().filter(figure1 -> figure1.getType().equals(FigureType.HORSE)).findFirst().get();

        Assertions.assertEquals(new Coord(4, 4), figure.getPosition());
    }
}
