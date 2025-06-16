package com.openbanking.handler;

import com.openbanking.exceptions.ClienteNaoEncontradoException;
import com.openbanking.exceptions.ContaNaoEncontradaException;
import com.openbanking.exceptions.PixInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ContaNaoEncontradaException.class)
    public ResponseEntity<Map<String, String>> handleContaNaoEncontrada(ContaNaoEncontradaException ex) {
        Map<String, String> erro = new HashMap<>();
        erro.put("codigoErro", "404");
        erro.put("mensagem", ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> tratarClienteNaoEncontrado(ClienteNaoEncontradoException ex) {
        Map<String, String> erro = new HashMap<>();
        erro.put("codigoErro", "404");
        erro.put("mensagem", ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PixInvalidoException.class)
    public ResponseEntity<Map<String, String>> tratarPixInvalido(PixInvalidoException ex) {
        Map<String, String> erro = new HashMap<>();
        erro.put("codigoErro", "400");
        erro.put("mensagem", ex.getMessage());
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }
}