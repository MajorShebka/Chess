package org.chess.usecase.exceptions;

public class IncorrectTakeException extends Exception{
    public IncorrectTakeException() {
    }

    public IncorrectTakeException(String message) {
        super(message);
    }
}
