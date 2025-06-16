package com.openbanking.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class TransferenciaPixResponse {
    private String transactionId;
    private String mensagem;
    private String contaOrigemId;
    private String contaDestinoId;
    private BigDecimal valor;
    private String moeda;
}