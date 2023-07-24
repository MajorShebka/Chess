package org.chess.usecase.models.dto;

import com.fasterxml.jackson.annotation.*;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;

public class FigureDTO {
    @JsonProperty("color")
    private FigureColor color;
    @JsonProperty("type")
    private FigureType type;
    @JsonProperty("figureCoord")
    private CoordDTO figureCoord;

    public FigureDTO(FigureColor color, FigureType type, CoordDTO figureCoord) {
        this.color = color;
        this.type = type;
        this.figureCoord = figureCoord;
    }

    public FigureColor getColor() {
        return color;
    }

    @JsonSetter("color")
    public void setColor(FigureColor color) {
        this.color = color;
    }

    public FigureType getType() {
        return type;
    }

    @JsonSetter("type")
    public void setType(FigureType type) {
        this.type = type;
    }

    public CoordDTO getFigureCoord() {
        return figureCoord;
    }

    @JsonSetter("figureCoord")
    public void setFigureCoord(CoordDTO figureCoord) {
        this.figureCoord = figureCoord;
    }

    @Override
    public String toString() {
        return "FigureDTO{" +
                "color=" + color +
                ", type=" + type +
                ", figureCoord=" + figureCoord +
                '}';
    }
}
