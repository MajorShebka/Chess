package org.chess.entity;

import org.chess.entity.models.Figure;

import java.util.Set;

public interface GameManager{
boolean isCheck(Set<Figure> figures);
boolean isMate(Set<Figure> figures);
}