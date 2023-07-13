package org.chess.entity;

import org.chess.entity.enums.FigureType;

public interface FigureManagerFactory{
FigureManager create(FigureType figureType);
}