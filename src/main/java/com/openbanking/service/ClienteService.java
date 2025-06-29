package com.openbanking.service;


import com.openbanking.exceptions.ClienteNaoEncontradoException;
import com.openbanking.model.dto.ClienteDTO;
import com.openbanking.model.dto.LimiteCreditoDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ClienteService {

    public ClienteDTO consultarDadosCliente(String cliente) {
        if (!"c123".equals(cliente)) {
            throw new ClienteNaoEncontradoException(cliente);
        }
        return new ClienteDTO(cliente, "João da Silva", "123.456.789-00", "joao@email.com");
    }

    public LimiteCreditoDTO consultarLimiteCredito(String clienteId) {
        if (!"c123".equals(clienteId)) {
            throw new ClienteNaoEncontradoException(clienteId);
        }
        // Dados mockados
        return new LimiteCreditoDTO(
                clienteId,
                new BigDecimal("15000.00"),  // limite
                "BRL",                       // moeda
                new BigDecimal("3.5")       // taxa de juros
        );
    }
}

