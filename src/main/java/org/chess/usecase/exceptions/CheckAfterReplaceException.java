package org.chess.usecase.exceptions;

public class CheckAfterReplaceException extends ActionException{
    public CheckAfterReplaceException(String check) {
        super(check);
    }
}
