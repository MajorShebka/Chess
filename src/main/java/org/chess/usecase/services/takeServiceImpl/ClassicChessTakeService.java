package org.chess.usecase.services.takeServiceImpl;

import org.chess.entity.FigureManager;
import org.chess.entity.FigureManagerFactory;
import org.chess.entity.models.Figure;
import org.chess.usecase.exceptions.IncorrectMoveException;
import org.chess.usecase.exceptions.IncorrectTakeException;
import org.chess.usecase.models.Board;
import org.chess.usecase.models.dto.FigureDTO;
import org.chess.usecase.services.TakeService;

import java.util.Set;

public class ClassicChessTakeService extends TakeService {
    public ClassicChessTakeService(Board board, FigureManagerFactory figureManagerFactory) {
        super(board, figureManagerFactory);
    }

    public ClassicChessTakeService(FigureManagerFactory factory) {
        super(factory);
    }

    @Override
    public void take(FigureDTO takingFigureDTO, FigureDTO takenFigureDTO) throws IncorrectTakeException {
        Figure takingFigure = initFigureFromDTO(takingFigureDTO);
        Figure takenFigure = initFigureFromDTO(takenFigureDTO);
        FigureManager figureManager = figureManagerFactory.create(takingFigure.getType());
        Set<Figure> figures = convertFigureDTOtoFigure(board.getFiguresOnTheBoard());

        if(figureManager.isCanTake(takingFigure, takenFigure, figures)
                && takingFigure.getColor().equals(board.getMovingColor())){
            board.getFiguresOnTheBoard().remove(takenFigure);
            figureManager.takeFigure(takingFigure, takenFigure);
        } else {
            throw new IncorrectTakeException(takingFigure.toString() + " cant take " + takenFigure.toString());
        }
    }
}
