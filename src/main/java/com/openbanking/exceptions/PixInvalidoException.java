package com.openbanking.exceptions;

public class PixInvalidoException extends RuntimeException {
    public PixInvalidoException(String mensagem) {
        super(mensagem);
    }
}