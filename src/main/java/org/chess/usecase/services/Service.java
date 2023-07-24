package org.chess.usecase.services;

import org.chess.entity.FigureManagerFactory;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;
import org.chess.usecase.models.Board;
import org.chess.usecase.models.dto.CoordDTO;
import org.chess.usecase.models.dto.FigureDTO;

import java.util.HashSet;
import java.util.Set;

//TODO: refactor this! There are some fields and methods, that not used in some extensions
@org.springframework.stereotype.Service
public abstract class Service {
    protected Board board;
    protected FigureManagerFactory figureManagerFactory;

    public FigureManagerFactory getFigureManagerFactory() {
        return figureManagerFactory;
    }

    public Service(Board board, FigureManagerFactory figureManagerFactory) {
        this.board = board;
        this.figureManagerFactory = figureManagerFactory;
    }

    public Service(FigureManagerFactory factory) {
        figureManagerFactory = factory;
    }

    protected Figure initFigureFromDTO(FigureDTO figureDTO) {
        Coord coord = new Coord(figureDTO.getFigureCoord().getXCoord(), figureDTO.getFigureCoord().getYCoord());
        Figure returnFigure = new Figure(figureDTO.getColor(), figureDTO.getType(), coord,
                board.getMaxCoord(), board.getMinCoord());

        return returnFigure;
    }

    protected Coord initCoordFromDTO(CoordDTO coordDTO) {
        Coord returnCoord = new Coord(coordDTO.getXCoord(), coordDTO.getYCoord());

        return returnCoord;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setFigureManagerFactory(FigureManagerFactory figureManagerFactory) {
        this.figureManagerFactory = figureManagerFactory;
    }

    protected Set<Figure> convertFigureDTOtoFigure(Set<FigureDTO> figureDTOS) {
        Set<Figure> figures = new HashSet<>();

        for (FigureDTO dto : figureDTOS) {
            figures.add(new Figure(dto.getColor(), dto.getType(), new Coord(dto.getFigureCoord().getXCoord(),
                    dto.getFigureCoord().getYCoord()),
                    board.getMaxCoord(),
                    board.getMinCoord()));
        }

        return figures;
    }

    protected Set<FigureDTO> convertFigureToFigureDTO(Set<Figure> figures) {
        Set<FigureDTO> figureDTOs = new HashSet<>();

        for (Figure figure : figures) {
            figureDTOs.add(new FigureDTO(
                    figure.getColor(),
                    figure.getType(),
                    new CoordDTO(figure.getPosition().getXCoord(), figure.getPosition().getYCoord()))
            );
        }

        return figureDTOs;
    }
}
