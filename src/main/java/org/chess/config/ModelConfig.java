package org.chess.config;

import org.chess.entity.enums.FigureColor;
import org.chess.entity.models.Coord;
import org.chess.usecase.models.Board;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.HashSet;

@Configuration
@ComponentScan("org.usecase.models")
public class ModelConfig {
    @Bean
    @Profile("classicChess")
    public Board getClassicChessBoard(){
        Board board = new Board(new Coord(8, 8),
                new Coord(1, 1), new HashSet<>(), FigureColor.WHITE);
        return board;
    }
}
