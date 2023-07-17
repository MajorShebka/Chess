package org.chess.usecase.services;

import org.chess.entity.FigureManagerFactory;
import org.chess.entity.GameManager;
import org.chess.usecase.models.Board;

public abstract class GameActionsService extends Service{
    protected GameManager gameManager;
    public GameActionsService(Board board, FigureManagerFactory figureManagerFactory, GameManager gameManager) {
        super(board, figureManagerFactory);
        this.gameManager = gameManager;
    }

    public abstract boolean isCheck();

    public abstract boolean isMate();
}
