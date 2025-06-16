package com.openbanking.service;

import com.openbanking.exceptions.ClienteNaoEncontradoException;
import com.openbanking.model.dto.LimiteCreditoDTO;
import com.openbanking.model.dto.ClienteDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ClienteService {

    public ClienteDTO consultarDadosCliente(String clienteId) {
        if (!"c123".equals(clienteId)) {
            throw new ClienteNaoEncontradoException(clienteId);
        }
        return new ClienteDTO(clienteId, "João da Silva", "123.456.789-00", "joao@email.com");
    }

    public LimiteCreditoDTO consultarLimiteCredito(String clienteId) {
        if (!"c123".equals(clienteId)) {
            throw new ClienteNaoEncontradoException(clienteId);
        }
        return new LimiteCreditoDTO(clienteId, new BigDecimal("10000.00"), "BRL", new BigDecimal("2.5"));
    }
}
