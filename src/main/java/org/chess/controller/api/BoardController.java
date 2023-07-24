package org.chess.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.chess.controller.models.Configure;
import org.chess.controller.models.MoveConfigure;
import org.chess.controller.models.TakeConfigure;
import org.chess.usecase.exceptions.*;
import org.chess.usecase.models.Board;
import org.chess.usecase.models.dto.*;
import org.chess.usecase.services.GameActionsService;
import org.chess.usecase.services.MoveService;
import org.chess.usecase.services.TakeService;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardController {
    @PostMapping("/move")
    public String move(@RequestBody String json) {
        try {
            MoveConfigure moveConfigure = new MoveConfigure(json);
            FigureDTO figure = moveConfigure.configFigureDTO();
            CoordDTO coord = moveConfigure.configCoordDTO();

            Board board = moveConfigure.configBoard();
            MoveService service = moveConfigure.configMoveService(board);

            try {
                service.makeMove(figure, coord);

                changeMoveColor(moveConfigure, board);

                return board.getMovingColor().toString();
            } catch (Exception e) {
                return e.getMessage();
            }
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }

    private void changeMoveColor(Configure configure, Board board) throws ActionException {
        GameActionsService actionsService = configure.configGameActionsService(board);

        if (actionsService.isCheck()) {
            throw new CheckAfterReplaceException("check");
        }

        board.changeMovingColor();

        if (actionsService.isMate()) {
            throw new MateAfterReplaceException("mate");
        }
    }

    @PostMapping("/take")
    public String take(@RequestBody String json) {
        try {
            TakeConfigure takeConfigure = new TakeConfigure(json);
            FigureDTO takingFigure = takeConfigure.configTakingFigureDTO();
            FigureDTO takenFigure = takeConfigure.configTakenFigureDTO();
            Board board = takeConfigure.configBoard();
            TakeService service = takeConfigure.configTakeService(board);

            try {
                service.take(takingFigure, takenFigure);

                changeMoveColor(takeConfigure, board);

                return board.getMovingColor().toString();
            } catch (Exception e) {
                return e.getMessage();
            }
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }
}
