package com.openbanking.service;


import com.openbanking.exceptions.ContaNaoEncontradaException;
import com.openbanking.exceptions.TransacaoNaoEncontradaException;
import com.openbanking.model.dto.ContaDTO;
import com.openbanking.model.dto.TransacaoDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
public class ContaService {

    private Map<String, ContaDTO> contas = new HashMap<>();
    private Map<String, List<TransacaoDTO>> transacoesPorConta = new HashMap<>();

    public ContaService() {
        // Mock de contas
        contas.put("123", new ContaDTO("123", "Corrente", new BigDecimal("1500.00"), "BRL"));
        contas.put("124", new ContaDTO("124", "Poupança", new BigDecimal("2300.00"), "BRL"));

        // Mock de transações reais para a conta "123"
        List<TransacaoDTO> transacoesConta123 = Arrays.asList(
                new TransacaoDTO(LocalDate.now().minusDays(2), "Pagamento de boleto", new BigDecimal("-200.00"), "BRL"),
                new TransacaoDTO(LocalDate.now().minusDays(5), "Recebimento de salário", new BigDecimal("5000.00"), "BRL")
        );

        transacoesPorConta.put("123", transacoesConta123);
        transacoesPorConta.put("124", Collections.emptyList());
    }

    public ContaDTO consultarSaldo(String contaId) {
        ContaDTO conta = contas.get(contaId);
        if (conta == null) {
            throw new ContaNaoEncontradaException("Saldo não encontrado para a conta: " + contaId);
        }
        return conta;
    }

    public List<ContaDTO> listarContasCliente(String clienteId) {
        return new ArrayList<>(contas.values());
    }

    public List<TransacaoDTO> listarTransacoes(String contaId) {
        if (!contas.containsKey(contaId)) {
            throw new ContaNaoEncontradaException("Conta não encontrada para extrato: " + contaId);
        }
        List<TransacaoDTO> transacoes = transacoesPorConta.get(contaId);
        if (transacoes == null) {
            throw new TransacaoNaoEncontradaException(contaId);
        }
        return transacoes;
    }
}
