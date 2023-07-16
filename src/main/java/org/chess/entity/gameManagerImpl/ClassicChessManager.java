package org.chess.entity.gameManagerImpl;

import org.chess.entity.FigureManager;
import org.chess.entity.FigureManagerFactory;
import org.chess.entity.GameManager;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.entity.figureManagerFactoryImpl.ClassicalChessFigureManagerFactory;
import org.chess.entity.figureManagerImpl.KingManager;
import org.chess.entity.models.Coord;
import org.chess.entity.models.Figure;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClassicChessManager implements GameManager {
    private final FigureManagerFactory factory = new ClassicalChessFigureManagerFactory();

    @Override
    public boolean isCheck(Set<Figure> figures, FigureColor movingColor) {
        Figure king = detectKing(figures, movingColor);

        return getFigureThatAttack(king, figures) != null;
    }

    private Figure detectKing(Set<Figure> figures, FigureColor movingColor) {
        for (Figure figure : figures) {
            if (figure.getType().equals(FigureType.KING)
                    && figure.getColor().equals(movingColor)) {
                return figure;
            }
        }

        //TODO: u must refactor this fucking piece of shit!!!
        return null;
    }

    private Figure getFigureThatAttack(Figure king, Set<Figure> figures) {
        for (Figure figure : figures) {
            FigureManager manager = factory.create(figure.getType());
            if (manager.isCanTake(figure, king, figures)) {
                return figure;
            }
        }

        //TODO: refactor this!
        return null;
    }

    @Override
    public boolean isMate(Set<Figure> figures, FigureColor movingColor) {
        return isCheck(figures, movingColor)
                && !isKingHaveUsefulMove(figures, movingColor)
                && !isAnyoneCanSave(figures, movingColor)
                && !isAnyoneCanTakeEnemy(figures, movingColor);
    }

    private boolean isKingHaveUsefulMove(Set<Figure> figures, FigureColor movingColor) {
        Figure king = detectKing(figures, movingColor);
        KingManager manager = new KingManager();
        List<Coord> moveCoords = manager.getMoveCoords(king, figures);

        for (Coord nextCoord : moveCoords) {
            Set<Figure> intermediateFigures = new HashSet<>(figures);
            king = detectKing(intermediateFigures, movingColor);
            Figure figure = getFigureByCoord(intermediateFigures, nextCoord);

            if (manager.isCanMove(king, nextCoord, intermediateFigures)) {
                manager.moveOn(king, nextCoord);
            } else if (figure != null && manager.isCanTake(king, figure, intermediateFigures)) {
                manager.takeFigure(king, figure);
                intermediateFigures.remove(figure);
            }

            if (!isCheck(intermediateFigures, movingColor)) {
                return true;
            }
        }

        return false;
    }

    private Figure getFigureByCoord(Set<Figure> figures, Coord coord) {
        for (Figure figure : figures) {
            if (figure.getPosition().equals(coord)) {
                return figure;
            }
        }

        //TODO: refactor this!
        return null;
    }

    private boolean isAnyoneCanSave(Set<Figure> figures, FigureColor movingColor) {
        Figure king = detectKing(figures, movingColor);
        //Can be null
        Figure attackFigure = getFigureThatAttack(king, figures);
        FigureManager manager = factory.create(attackFigure.getType());
        Set<Figure> intermediateFigures = new HashSet<>(figures);

        List<Coord> coordsBetween = manager.getCoordsBetween(attackFigure, king.getPosition());

        for (Coord nextCoord : coordsBetween) {
            for (Figure figure : intermediateFigures) {
                king = detectKing(intermediateFigures, movingColor);

                if (manager.isCanMove(figure, nextCoord, intermediateFigures) && figure.getColor().equals(movingColor)) {
                    manager.moveOn(figure, nextCoord);
                } else if (manager.isCanTake(figure, getFigureByCoord(figures, nextCoord), intermediateFigures)
                        && figure.getColor().equals(movingColor)) {
                    manager.takeFigure(king, figure);
                    figures.remove(figure);
                }

                if (!isCheck(intermediateFigures, movingColor)) {
                    return true;
                }

                intermediateFigures = new HashSet<>(figures);
            }
        }

        return false;
    }

    private boolean isAnyoneCanTakeEnemy(Set<Figure> figures, FigureColor movingColor) {
        Figure king = detectKing(figures, movingColor);
        //Can be null
        Figure attackFigure = getFigureThatAttack(king, figures);
        Set<Figure> intermediateFigures = new HashSet<>(figures);

        for (Figure nextFigure : intermediateFigures) {
            FigureManager manager = factory.create(nextFigure.getType());

            if (manager.isCanTake(nextFigure, attackFigure, figures)) {
                manager.takeFigure(nextFigure, attackFigure);
                figures.remove(attackFigure);
            }

            if (!isCheck(intermediateFigures, movingColor)) {
                return true;
            }

            intermediateFigures = new HashSet<>(figures);
        }

        return false;
    }
}
