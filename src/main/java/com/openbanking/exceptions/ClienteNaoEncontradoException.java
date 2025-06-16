package com.openbanking.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException {
    public ClienteNaoEncontradoException(String clienteId) {
        super("Cliente com id '" + clienteId + "' não encontrado.");
    }
}