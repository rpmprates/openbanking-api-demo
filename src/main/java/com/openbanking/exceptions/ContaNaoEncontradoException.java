package com.openbanking.exceptions;

public class ContaNaoEncontradoException extends RuntimeException {

    public ContaNaoEncontradoException(String mensagem) {

        super(mensagem);
    }
}