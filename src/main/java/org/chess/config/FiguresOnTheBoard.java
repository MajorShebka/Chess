package org.chess.config;

public class FiguresOnTheBoard {
    private static String figuresOnTheClassicChessBoard = "" +
            "{\"figures\": [\n" +
            "  {\"color\":\"WHITE\", \"type\":\"PAWN\", \"figureCoord\":{\"xCoord\":1, \"yCoord\":2}},\n" +
            "  {\"color\":\"WHITE\", \"type\":\"PAWN\", \"figureCoord\":{\"xCoord\":2, \"yCoord\":2}},\n" +
            "  {\"color\":\"WHITE\", \"type\":\"PAWN\", \"figureCoord\":{\"xCoord\":3, \"yCoord\":2}},\n" +
            "  {\"color\":\"WHITE\", \"type\":\"PAWN\", \"figureCoord\":{\"xCoord\":4, \"yCoord\":2}},\n" +
            "  {\"color\":\"WHITE\", \"type\":\"PAWN\", \"figureCoord\":{\"xCoord\":5, \"yCoord\":2}},\n" +
            "  {\"color\":\"WHITE\", \"type\":\"PAWN\", \"figureCoord\":{\"xCoord\":6, \"yCoord\":2}},\n" +
            "  {\"color\":\"WHITE\", \"type\":\"PAWN\", \"figureCoord\":{\"xCoord\":7, \"yCoord\":2}},\n" +
            "  {\"color\":\"WHITE\", \"type\":\"PAWN\", \"figureCoord\":{\"xCoord\":8, \"yCoord\":2}},\n" +
            "  {\"color\":\"WHITE\", \"type\":\"TOWER\", \"figureCoord\":{\"xCoord\":1, \"yCoord\":1}},\n" +
            "  {\"color\":\"WHITE\", \"type\":\"TOWER\", \"figureCoord\":{\"xCoord\":8, \"yCoord\":1}},\n" +
            "  {\"color\":\"WHITE\", \"type\":\"HORSE\", \"figureCoord\":{\"xCoord\":2, \"yCoord\":1}},\n" +
            "  {\"color\":\"WHITE\", \"type\":\"HORSE\", \"figureCoord\":{\"xCoord\":7, \"yCoord\":1}},\n" +
            "  {\"color\":\"WHITE\", \"type\":\"BISHOP\", \"figureCoord\":{\"xCoord\":3, \"yCoord\":1}},\n" +
            "  {\"color\":\"WHITE\", \"type\":\"BISHOP\", \"figureCoord\":{\"xCoord\":6, \"yCoord\":1}},\n" +
            "  {\"color\":\"WHITE\", \"type\":\"QUEEN\", \"figureCoord\":{\"xCoord\":4, \"yCoord\":1}},\n" +
            "  {\"color\":\"WHITE\", \"type\":\"KING\", \"figureCoord\":{\"xCoord\":5, \"yCoord\":1}},\n" +
            "  {\"color\":\"BLACK\", \"type\":\"PAWN\", \"figureCoord\":{\"xCoord\":1, \"yCoord\":7}},\n" +
            "  {\"color\":\"BLACK\", \"type\":\"PAWN\", \"figureCoord\":{\"xCoord\":2, \"yCoord\":7}},\n" +
            "  {\"color\":\"BLACK\", \"type\":\"PAWN\", \"figureCoord\":{\"xCoord\":3, \"yCoord\":7}},\n" +
            "  {\"color\":\"BLACK\", \"type\":\"PAWN\", \"figureCoord\":{\"xCoord\":4, \"yCoord\":7}},\n" +
            "  {\"color\":\"BLACK\", \"type\":\"PAWN\", \"figureCoord\":{\"xCoord\":5, \"yCoord\":7}},\n" +
            "  {\"color\":\"BLACK\", \"type\":\"PAWN\", \"figureCoord\":{\"xCoord\":6, \"yCoord\":7}},\n" +
            "  {\"color\":\"BLACK\", \"type\":\"PAWN\", \"figureCoord\":{\"xCoord\":7, \"yCoord\":7}},\n" +
            "  {\"color\":\"BLACK\", \"type\":\"PAWN\", \"figureCoord\":{\"xCoord\":8, \"yCoord\":7}},\n" +
            "  {\"color\":\"BLACK\", \"type\":\"TOWER\", \"figureCoord\":{\"xCoord\":1, \"yCoord\":8}},\n" +
            "  {\"color\":\"BLACK\", \"type\":\"TOWER\", \"figureCoord\":{\"xCoord\":8, \"yCoord\":8}},\n" +
            "  {\"color\":\"BLACK\", \"type\":\"HORSE\", \"figureCoord\":{\"xCoord\":2, \"yCoord\":8}},\n" +
            "  {\"color\":\"BLACK\", \"type\":\"HORSE\", \"figureCoord\":{\"xCoord\":7, \"yCoord\":8}},\n" +
            "  {\"color\":\"BLACK\", \"type\":\"BISHOP\", \"figureCoord\":{\"xCoord\":3, \"yCoord\":8}},\n" +
            "  {\"color\":\"BLACK\", \"type\":\"BISHOP\", \"figureCoord\":{\"xCoord\":6, \"yCoord\":8}},\n" +
            "  {\"color\":\"BLACK\", \"type\":\"QUEEN\", \"figureCoord\":{\"xCoord\":4, \"yCoord\":8}},\n" +
            "  {\"color\":\"BLACK\", \"type\":\"KING\", \"figureCoord\":{\"xCoord\":5, \"yCoord\":8}}\n" +
            "]}";
    public static String getFiguresOnTheBoard(String profile){
        if(profile == "classicChess") {
            return figuresOnTheClassicChessBoard;
        }

        return figuresOnTheClassicChessBoard;
    }
}
