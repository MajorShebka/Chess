package org.chess.controller.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.chess.config.FiguresOnTheBoard;
import org.chess.entity.enums.FigureColor;
import org.chess.entity.models.Coord;
import org.chess.usecase.models.Board;
import org.chess.usecase.models.dto.FigureDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.stream.Collectors;

public class GameConfigure extends Configure{
    public GameConfigure(String json) throws JsonProcessingException {
        super(json);
    }

    public Board configNewBoard() {
        Board board = context.getBean(Board.class);
        HashSet<FigureDTO> figures = BoardConfig.getFiguresOnTheBoard(profile);

        board.setFiguresOnTheBoard(figures);
        board.setMovingColor("WHITE");

        return board;
    }
}