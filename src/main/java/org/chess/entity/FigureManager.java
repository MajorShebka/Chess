package org.chess.entity;

import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;

import java.util.Set;

public interface FigureManager{
boolean isCanMove(Figure movingFigure, Coord moveCoord, Set<Figure> figures);
boolean isCanTake(Figure takingFigure, Figure takenFigure, Set<Figure> figures);
void moveOn(Figure movingFigure, Coord moveCoord);
void takeFigure(Figure takingFigure, Figure takenFigure);
}