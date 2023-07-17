package org.chess.usecase.models.dto;

import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.entity.models.Coord;

public class FigureDTO {
    private FigureColor color;
    private FigureType type;
    private Coord figureCoord;

    public FigureDTO(FigureColor color, FigureType type, Coord figureCoord) {
        this.color = color;
        this.type = type;
        this.figureCoord = figureCoord;
    }

    public FigureColor getColor() {
        return color;
    }

    public void setColor(FigureColor color) {
        this.color = color;
    }

    public FigureType getType() {
        return type;
    }

    public void setType(FigureType type) {
        this.type = type;
    }

    public Coord getFigureCoord() {
        return figureCoord;
    }

    public void setFigureCoord(Coord figureCoord) {
        this.figureCoord = figureCoord;
    }
}
