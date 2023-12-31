package org.chess.usecase.services.takeServiceImpl;

import org.chess.entity.FigureManager;
import org.chess.entity.FigureManagerFactory;
import org.chess.entity.models.Figure;
import org.chess.usecase.exceptions.IncorrectMoveException;
import org.chess.usecase.exceptions.IncorrectTakeException;
import org.chess.usecase.models.Board;
import org.chess.usecase.models.dto.FigureDTO;
import org.chess.usecase.services.TakeService;

public class ClassicChessTakeService extends TakeService {
    public ClassicChessTakeService(Board board, FigureManagerFactory figureManagerFactory) {
        super(board, figureManagerFactory);
    }

    @Override
    public void take(FigureDTO takingFigureDTO, FigureDTO takenFigureDTO) throws IncorrectTakeException {
        Figure takingFigure = initFigureFromDTO(takingFigureDTO);
        Figure takenFigure = initFigureFromDTO(takenFigureDTO);
        FigureManager figureManager = figureManagerFactory.create(takingFigure.getType());

        if(figureManager.isCanTake(takingFigure, takenFigure, board.getFiguresOnTheBoard())
                && takingFigure.getColor().equals(board.getMovingColor())){
            board.getFiguresOnTheBoard().remove(takenFigure);
            figureManager.takeFigure(takingFigure, takenFigure);
            board.changeMovingColor();
        } else {
            throw new IncorrectTakeException(takingFigure.toString() + " cant take " + takenFigure.toString());
        }
    }
}
