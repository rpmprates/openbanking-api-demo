package com.openbanking.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
public class TransferenciaPixRequest {
    private String contaOrigemId;
    private String contaDestinoId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "#0.00")
    private BigDecimal valor;
    private String moeda;

}