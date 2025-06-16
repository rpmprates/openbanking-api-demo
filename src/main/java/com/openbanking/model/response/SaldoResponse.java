package com.openbanking.model.response;

import lombok.Getter;

public class SaldoResponse {
    private String accountId;
    @Getter
    private Double saldoDisponivel;

    public SaldoResponse(String accountId, Double saldoDisponivel) {
        this.accountId = accountId;
        this.saldoDisponivel = saldoDisponivel;
    }

    public String getContaId() {
        return accountId;
    }

}
