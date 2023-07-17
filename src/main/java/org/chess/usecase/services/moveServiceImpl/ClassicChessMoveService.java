package org.chess.usecase.services.moveServiceImpl;

import org.chess.entity.FigureManager;
import org.chess.entity.FigureManagerFactory;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;
import org.chess.usecase.exceptions.IncorrectMoveException;
import org.chess.usecase.models.Board;
import org.chess.usecase.models.dto.CoordDTO;
import org.chess.usecase.models.dto.FigureDTO;
import org.chess.usecase.services.MoveService;

public class ClassicChessMoveService extends MoveService {
    public ClassicChessMoveService(Board board, FigureManagerFactory figureManagerFactory) {
        super(board, figureManagerFactory);
    }

    @Override
    public void makeMove(FigureDTO figureDTO, CoordDTO coordDTO) throws IncorrectMoveException {
        Figure movingFigure = initFigureFromDTO(figureDTO);
        Coord moveCoord = initCoordFromDTO(coordDTO);
        FigureManager figureManager = figureManagerFactory.create(movingFigure.getType());

        if(figureManager.isCanMove(movingFigure, moveCoord, board.getFiguresOnTheBoard())
                && movingFigure.getColor().equals(board.getMovingColor())){
            figureManager.moveOn(movingFigure, moveCoord);
        } else {
            throw new IncorrectMoveException(movingFigure.toString() + " cant move on " + moveCoord.toString());
        }
    }

}
