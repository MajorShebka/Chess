package org.chess.entity.figureManagerFactoryImpl;

import org.chess.entity.FigureManager;
import org.chess.entity.FigureManagerFactory;
import org.chess.entity.enums.FigureType;
import org.chess.entity.figureManagerImpl.*;

public class ClassicChessFigureManagerFactory implements FigureManagerFactory {
    public FigureManager create(FigureType figureType) {
        switch (figureType) {
            case PAWN:
                return new PawnManager();
            case TOWER:
                return new TowerManager();
            case HORSE:
                return new HorseManager();
            case BISHOP:
                return new BishopManager();
            case QUEEN:
                return new QueenManager();
            case KING:
                return new KingManager();
            default:
                //TODO: refactor this piece of shit! u must not return null
                return null;
        }
    }

    @Override
    public String toString() {
        return "ClassicalChessFigureManagerFactory{}";
    }
}
