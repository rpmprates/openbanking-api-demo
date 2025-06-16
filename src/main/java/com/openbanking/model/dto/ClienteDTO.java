package com.openbanking.model.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class ClienteDTO {
    private String clienteId;
    private String nome;
    private String cpf;
    private String email;
}

