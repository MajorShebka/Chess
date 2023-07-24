package org.chess.controller.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.chess.usecase.models.Board;
import org.chess.usecase.models.dto.CoordDTO;
import org.chess.usecase.models.dto.FigureDTO;
import org.chess.usecase.services.MoveService;

public class MoveConfigure extends Configure{
    public MoveConfigure(String json) throws JsonProcessingException {
        super(json);
    }

    public MoveService configMoveService(Board board){
        MoveService service = context.getBean(MoveService.class);
        service.setBoard(board);

        return service;
    }

    public FigureDTO configFigureDTO(){
        FigureDTO figure = mapper.convertValue(node.get("movingFigure"), FigureDTO.class);

        return figure;
    }

    public CoordDTO configCoordDTO(){
        CoordDTO coord = mapper.convertValue(node.get("moveCoord"), CoordDTO.class);

        return coord;
    }
}
