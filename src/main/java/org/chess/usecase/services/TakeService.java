package org.chess.usecase.services;

import org.chess.entity.FigureManagerFactory;
import org.chess.usecase.exceptions.IncorrectMoveException;
import org.chess.usecase.exceptions.IncorrectTakeException;
import org.chess.usecase.models.Board;
import org.chess.usecase.models.dto.FigureDTO;

public abstract class TakeService extends Service {
    public TakeService(Board board, FigureManagerFactory figureManagerFactory) {
        super(board, figureManagerFactory);
    }

    public abstract void take(FigureDTO takingFigureDTO, FigureDTO takenFigureDTO) throws IncorrectMoveException, IncorrectTakeException;
}
