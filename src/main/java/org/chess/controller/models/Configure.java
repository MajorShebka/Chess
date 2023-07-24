package org.chess.controller.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.chess.config.ModelConfig;
import org.chess.config.ServiceConfig;
import org.chess.usecase.models.Board;
import org.chess.usecase.models.dto.FigureDTO;
import org.chess.usecase.services.GameActionsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashSet;

public abstract class Configure {
    protected String profile;
    protected JsonNode node;
    protected AnnotationConfigApplicationContext context;
    protected ObjectMapper mapper = new ObjectMapper();

    public Configure(String json) throws JsonProcessingException {
        node = mapper.readTree(json);
        profile = mapper.convertValue(node.get("game"), String.class);

        context  = new AnnotationConfigApplicationContext();
        context.register(ServiceConfig.class, ModelConfig.class);
        context.getEnvironment().setActiveProfiles(profile);
        context.refresh();
    }

    public Configure() {}

    public Board configBoard(){
        HashSet<FigureDTO> figures = mapper.convertValue(node.get("figures"), new TypeReference<HashSet<FigureDTO>>() {});
        String movingColor = mapper.convertValue(node.get("movingColor"), String.class);

        Board board = context.getBean(Board.class);

        board.setFiguresOnTheBoard(figures);
        board.setMovingColor(movingColor);

        return board;
    }

    public GameActionsService configGameActionsService(Board board) {
        GameActionsService service = context.getBean(GameActionsService.class);
        service.setBoard(board);

        return service;
    }
}
