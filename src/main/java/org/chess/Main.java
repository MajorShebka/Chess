package org.chess;

import org.chess.entity.FigureManager;
import org.chess.entity.FigureManagerFactory;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.entity.figureManagerFactoryImpl.ClassicalChessFigureManagerFactory;
import org.chess.entity.figureManagerImpl.PawnManager;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        FigureManagerFactory factory = new ClassicalChessFigureManagerFactory();
        Figure pawn = new Figure(FigureColor.WHITE, FigureType.PAWN,
                new Coord(1, 2), new Coord(8, 8), new Coord(1,1));
        FigureManager manager = factory.create(pawn.getType());
        System.out.println(manager.isCanMove(pawn, new Coord(1, 3), new HashSet<Figure>()));
    }
}
