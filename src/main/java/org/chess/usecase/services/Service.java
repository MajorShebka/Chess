package org.chess.usecase.services;

import org.chess.entity.FigureManagerFactory;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;
import org.chess.usecase.models.Board;
import org.chess.usecase.models.dto.CoordDTO;
import org.chess.usecase.models.dto.FigureDTO;

//TODO: refactor this! There are some fields and methods, that not used in some extensions
public abstract class Service {
    protected Board board;
    protected FigureManagerFactory figureManagerFactory;

    public Service(Board board, FigureManagerFactory figureManagerFactory) {
        this.board = board;
        this.figureManagerFactory = figureManagerFactory;
    }

    protected Figure initFigureFromDTO(FigureDTO figureDTO){
        Figure returnFigure = new Figure(figureDTO.getColor(), figureDTO.getType(), figureDTO.getFigureCoord(),
                board.getMAX_COORD(), board.getMIN_COORD());

        board.getFiguresOnTheBoard().remove(returnFigure);
        board.getFiguresOnTheBoard().add(returnFigure);

        return returnFigure;
    }

    protected Coord initCoordFromDTO(CoordDTO coordDTO){
        Coord returnCoord = new Coord(coordDTO.getXCoord(), coordDTO.getYCoord());

        return returnCoord;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setFigureManagerFactory(FigureManagerFactory figureManagerFactory) {
        this.figureManagerFactory = figureManagerFactory;
    }
}
