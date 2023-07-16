package org.chess.entity;

import org.chess.entity.enums.FigureColor;
import org.chess.entity.models.Figure;

import java.util.Set;

public interface GameManager{
boolean isCheck(Set<Figure> figures, FigureColor movingColor);
boolean isMate(Set<Figure> figures, FigureColor movingColor);
}