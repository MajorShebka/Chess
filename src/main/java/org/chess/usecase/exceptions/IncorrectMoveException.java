package org.chess.usecase.exceptions;

public class IncorrectMoveException extends Exception{
    public IncorrectMoveException() {
    }

    public IncorrectMoveException(String message) {
        super(message);
    }
}
