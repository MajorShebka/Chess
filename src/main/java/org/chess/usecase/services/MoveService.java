package org.chess.usecase.services;

import org.chess.entity.FigureManagerFactory;
import org.chess.usecase.exceptions.IncorrectMoveException;
import org.chess.usecase.models.Board;
import org.chess.usecase.models.dto.CoordDTO;
import org.chess.usecase.models.dto.FigureDTO;

public abstract class MoveService extends Service{
    public MoveService(Board board, FigureManagerFactory figureManagerFactory) {
        super(board, figureManagerFactory);
    }

    public abstract void makeMove(FigureDTO figureDTO, CoordDTO coordDTO) throws IncorrectMoveException;
}
