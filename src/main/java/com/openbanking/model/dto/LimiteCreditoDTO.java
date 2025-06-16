package com.openbanking.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LimiteCreditoDTO {
    private String clienteId;
    private BigDecimal limiteCredito;
    private String moeda;
    private BigDecimal taxaJuros;

    public LimiteCreditoDTO(String clienteId, BigDecimal bigDecimal, String brl, BigDecimal bigDecimal1) {
    }
}