package org.chess.usecase.services.moveServiceImpl;

import org.chess.entity.FigureManager;
import org.chess.entity.FigureManagerFactory;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;
import org.chess.usecase.exceptions.IncorrectMoveException;
import org.chess.usecase.models.Board;
import org.chess.usecase.models.dto.CoordDTO;
import org.chess.usecase.models.dto.FigureDTO;
import org.chess.usecase.services.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ClassicChessMoveService extends MoveService {

    public ClassicChessMoveService(Board board, FigureManagerFactory figureManagerFactory) {
        super(board, figureManagerFactory);
    }

    public ClassicChessMoveService(FigureManagerFactory factory){
        super(factory);
    }

    @Override
    public void makeMove(FigureDTO figureDTO, CoordDTO coordDTO) throws IncorrectMoveException {
        Figure movingFigure = initFigureFromDTO(figureDTO);
        Coord moveCoord = initCoordFromDTO(coordDTO);
        FigureManager figureManager = figureManagerFactory.create(movingFigure.getType());
        Set<Figure> figures = convertFigureDTOtoFigure(board.getFiguresOnTheBoard());

        if(figureManager.isCanMove(movingFigure, moveCoord, figures)
                && movingFigure.getColor().equals(board.getMovingColor())){
            figureManager.moveOn(movingFigure, moveCoord);
        } else {
            throw new IncorrectMoveException(movingFigure.toString() + " cant move on " + moveCoord.toString());
        }

        board.setFiguresOnTheBoard(
                convertFigureToFigureDTO(figures)
        );
    }

    @Override
    public String toString() {
        return "ClassicChessMoveService{" +
                "board=" + board +
                ", figureManagerFactory=" + figureManagerFactory +
                '}';
    }
}
