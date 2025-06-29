package com.openbanking.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "#0.00")
    private BigDecimal valor;
    private String moeda;
}