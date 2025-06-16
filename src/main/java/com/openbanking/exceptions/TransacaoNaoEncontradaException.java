package com.openbanking.exceptions;

public class TransacaoNaoEncontradaException extends RuntimeException {
    public TransacaoNaoEncontradaException(String contaId) {
        super("Transações não encontradas para a conta: " + contaId);
    }
}