package com.openbanking.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ContaDTO {
    private String contaId;
    private String tipoConta;
    private BigDecimal saldoDisponivel;
    private String moeda;
}