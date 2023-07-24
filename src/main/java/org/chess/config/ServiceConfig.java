package org.chess.config;

import org.chess.entity.figureManagerFactoryImpl.ClassicChessFigureManagerFactory;
import org.chess.usecase.services.GameActionsService;
import org.chess.usecase.services.MoveService;
import org.chess.usecase.services.TakeService;
import org.chess.usecase.services.gameActionsServiceImpl.ClassicChessGameActions;
import org.chess.usecase.services.moveServiceImpl.ClassicChessMoveService;
import org.chess.usecase.services.takeServiceImpl.ClassicChessTakeService;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.chess.usecase.services")
public class ServiceConfig {
    @Bean
    @Profile("classicChess")
    public MoveService getClassicChessMoveService() {
        MoveService service = new ClassicChessMoveService(new ClassicChessFigureManagerFactory());

        return service;
    }

    @Bean
    @Profile("classicChess")
    public TakeService getClassicChessTakeService(){
        TakeService service = new ClassicChessTakeService(new ClassicChessFigureManagerFactory());

        return service;
    }

    @Bean
    @Profile("classicChess")
    public GameActionsService getClassicChessGameActionsService(){
        GameActionsService service = new ClassicChessGameActions(new ClassicChessFigureManagerFactory());

        return service;
    }
}
