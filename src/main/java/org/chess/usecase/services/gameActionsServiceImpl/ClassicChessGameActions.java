package org.chess.usecase.services.gameActionsServiceImpl;

import org.chess.entity.FigureManagerFactory;
import org.chess.entity.GameManager;
import org.chess.entity.gameManagerImpl.ClassicChessManager;
import org.chess.usecase.models.Board;
import org.chess.usecase.services.GameActionsService;

public class ClassicChessGameActions extends GameActionsService {
    public ClassicChessGameActions(Board board, FigureManagerFactory figureManagerFactory, GameManager gameManager) {
        super(board, figureManagerFactory, gameManager);
    }

    public ClassicChessGameActions(FigureManagerFactory factory) {
        super(factory);
        gameManager = new ClassicChessManager();
    }

    @Override
    public boolean isCheck() {
        return gameManager.isCheck(convertFigureDTOtoFigure(board.getFiguresOnTheBoard()), board.getMovingColor());
    }

    @Override
    public boolean isMate() {
        return gameManager.isMate(convertFigureDTOtoFigure(board.getFiguresOnTheBoard()), board.getMovingColor());
    }
}
