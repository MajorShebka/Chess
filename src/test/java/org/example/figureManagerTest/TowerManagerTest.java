package org.example.figureManagerTest;

import org.chess.entity.FigureManager;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.entity.figureManagerImpl.PawnManager;
import org.chess.entity.figureManagerImpl.TowerManager;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class TowerManagerTest {
    private Figure pawn;
    private FigureManager manager = new TowerManager();
    Set<Figure> figures = new HashSet<Figure>();

    private Figure initTower(FigureColor color, Coord startCoord){
        return new Figure(color, FigureType.TOWER, startCoord,
                new Coord(8, 8), new Coord(1, 1));
    }

    @Test
    public void isCanMoveTest(){

    }
}
