package org.chess.usecase.validators;

import org.chess.entity.models.Figure;
import org.chess.usecase.models.Board;

public class CoordValidator {
    public boolean validate(Board board){
        for (Figure nextFigure : board.getFiguresOnTheBoard()) {
            if (nextFigure.getPosition())
        }
    }
}
