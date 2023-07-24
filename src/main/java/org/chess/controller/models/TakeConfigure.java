package org.chess.controller.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.chess.usecase.models.Board;
import org.chess.usecase.models.dto.CoordDTO;
import org.chess.usecase.models.dto.FigureDTO;
import org.chess.usecase.services.MoveService;
import org.chess.usecase.services.TakeService;

public class TakeConfigure extends Configure{
    public TakeConfigure(String json) throws JsonProcessingException {
        super(json);
    }

    public TakeService configTakeService(Board board){
        TakeService service = context.getBean(TakeService.class);
        service.setBoard(board);

        return service;
    }

    public FigureDTO configTakingFigureDTO(){
        FigureDTO figure = mapper.convertValue(node.get("takingFigure"), FigureDTO.class);

        return figure;
    }

    public FigureDTO configTakenFigureDTO(){
        FigureDTO figure = mapper.convertValue(node.get("takenFigure"), FigureDTO.class);

        return figure;
    }
}
