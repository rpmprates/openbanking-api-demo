package com.openbanking.model.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
public class TransferenciaPixRequest {
    private String contaOrigemId;
    private String contaDestinoId;
    private BigDecimal valor;
    private String moeda;

}