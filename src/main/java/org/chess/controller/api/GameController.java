package org.chess.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.chess.controller.models.Configure;
import org.chess.controller.models.GameConfigure;
import org.chess.usecase.models.Board;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/game")
public class GameController {
    @GetMapping("/board")
    public String createBoard(@RequestBody String json) {
        Configure configure = null;

        try {
            configure = new GameConfigure(json);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }

        Board board = ((GameConfigure) configure).configNewBoard();

        ObjectMapper mapper = new ObjectMapper();
        try {
            String newJson = mapper.writeValueAsString(board);
            return newJson;
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }
}
