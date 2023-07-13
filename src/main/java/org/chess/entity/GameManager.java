package org.chess.entity;

import org.chess.entity.models.Figure;

interface GameManager{
boolean isCheck(Figure[] figures);
boolean isMate(Figure[] figures);
}