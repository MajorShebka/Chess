package org.chess.entity.gameManagerImpl;

import org.chess.entity.GameManager;
import org.chess.entity.models.Figure;

import java.util.Set;

public class ClassicChessManager implements GameManager {
    @Override
    public boolean isCheck(Set<Figure> figures) {
        return false;
    }

    @Override
    public boolean isMate(Set<Figure> figures) {
        return false;
    }
}
