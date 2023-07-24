package org.chess.controller.models;

import org.chess.entity.enums.FigureColor;
import org.chess.entity.enums.FigureType;
import org.chess.usecase.models.dto.CoordDTO;
import org.chess.usecase.models.dto.FigureDTO;

import java.util.Arrays;
import java.util.HashSet;

public class BoardConfig {
    private static HashSet<FigureDTO> CLASSIC_CHESS_FIGURES = new HashSet<>();

    static {
        CLASSIC_CHESS_FIGURES.addAll(Arrays.asList(
                new FigureDTO(FigureColor.WHITE, FigureType.PAWN, new CoordDTO(1, 2)),
                new FigureDTO(FigureColor.WHITE, FigureType.PAWN, new CoordDTO(2, 2)),
                new FigureDTO(FigureColor.WHITE, FigureType.PAWN, new CoordDTO(3, 2)),
                new FigureDTO(FigureColor.WHITE, FigureType.PAWN, new CoordDTO(4, 2)),
                new FigureDTO(FigureColor.WHITE, FigureType.PAWN, new CoordDTO(5, 2)),
                new FigureDTO(FigureColor.WHITE, FigureType.PAWN, new CoordDTO(6, 2)),
                new FigureDTO(FigureColor.WHITE, FigureType.PAWN, new CoordDTO(7, 2)),
                new FigureDTO(FigureColor.WHITE, FigureType.PAWN, new CoordDTO(8, 2)),
                new FigureDTO(FigureColor.WHITE, FigureType.TOWER, new CoordDTO(1, 1)),
                new FigureDTO(FigureColor.WHITE, FigureType.TOWER, new CoordDTO(8, 1)),
                new FigureDTO(FigureColor.WHITE, FigureType.HORSE, new CoordDTO(2, 1)),
                new FigureDTO(FigureColor.WHITE, FigureType.HORSE, new CoordDTO(7, 1)),
                new FigureDTO(FigureColor.WHITE, FigureType.BISHOP, new CoordDTO(3, 1)),
                new FigureDTO(FigureColor.WHITE, FigureType.BISHOP, new CoordDTO(6, 1)),
                new FigureDTO(FigureColor.WHITE, FigureType.QUEEN, new CoordDTO(4, 1)),
                new FigureDTO(FigureColor.WHITE, FigureType.KING, new CoordDTO(5, 1)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(1, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(2, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(3, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(4, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(5, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(6, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(7, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.PAWN, new CoordDTO(8, 7)),
                new FigureDTO(FigureColor.BLACK, FigureType.TOWER, new CoordDTO(1, 8)),
                new FigureDTO(FigureColor.BLACK, FigureType.TOWER, new CoordDTO(8, 8)),
                new FigureDTO(FigureColor.BLACK, FigureType.HORSE, new CoordDTO(2, 8)),
                new FigureDTO(FigureColor.BLACK, FigureType.HORSE, new CoordDTO(7, 8)),
                new FigureDTO(FigureColor.BLACK, FigureType.BISHOP, new CoordDTO(3, 8)),
                new FigureDTO(FigureColor.BLACK, FigureType.BISHOP, new CoordDTO(6, 8)),
                new FigureDTO(FigureColor.BLACK, FigureType.QUEEN, new CoordDTO(4, 8)),
                new FigureDTO(FigureColor.BLACK, FigureType.KING, new CoordDTO(5, 8))
                )
        );
    }

    public static HashSet<FigureDTO> getFiguresOnTheBoard(String game){
        if(game.equals("classicChess")){
            return CLASSIC_CHESS_FIGURES;
        }

        return CLASSIC_CHESS_FIGURES;
    }
}
