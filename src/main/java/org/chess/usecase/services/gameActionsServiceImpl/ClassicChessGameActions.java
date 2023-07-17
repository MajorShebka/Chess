package org.chess.usecase.services.gameActionsServiceImpl;

import org.chess.entity.FigureManagerFactory;
import org.chess.entity.GameManager;
import org.chess.usecase.models.Board;
import org.chess.usecase.services.GameActionsService;

public class ClassicChessGameActions extends GameActionsService {
    public ClassicChessGameActions(Board board, FigureManagerFactory figureManagerFactory, GameManager gameManager) {
        super(board, figureManagerFactory, gameManager);
    }

    @Override
    public boolean isCheck() {
        return gameManager.isCheck(board.getFiguresOnTheBoard(), board.getMovingColor());
    }

    @Override
    public boolean isMate() {
        return gameManager.isMate(board.getFiguresOnTheBoard(), board.getMovingColor());
    }
}
