package org.chess.usecase.models.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.chess.entity.models.Coord;

public class CoordDTO {
    @JsonProperty("xCoord")
    private int xCoord;
    @JsonProperty("yCoord")
    private int yCoord;

    public CoordDTO(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public CoordDTO() {
    }

    public int getXCoord() {
        return xCoord;
    }

    @JsonSetter("xCoord")
    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    @JsonSetter("yCoord")
    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordDTO coord = (CoordDTO) o;
        return xCoord == coord.xCoord && yCoord == coord.yCoord;
    }

    @Override
    public int hashCode() {
        return xCoord + 10 * yCoord;
    }
}
