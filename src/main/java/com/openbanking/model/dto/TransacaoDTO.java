package com.openbanking.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TransacaoDTO {
    private LocalDate data;
    private String descricao;
    private BigDecimal valor;
    private String moeda;

}