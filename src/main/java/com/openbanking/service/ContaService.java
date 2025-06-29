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

    private final Map<String, ContaDTO> contas = new HashMap<>();
    private final Map<String, List<TransacaoDTO>> transacoesPorConta = new HashMap<>();

    public ContaService() {
        // Mock de contas
        contas.put("123", new ContaDTO("123", "Corrente", new BigDecimal("1500.00"), "BRL"));
        contas.put("124", new ContaDTO("124", "Poupança", new BigDecimal("2300.00"), "BRL"));
        contas.put("555", new ContaDTO("555", "Poupança", new BigDecimal("10.00"), "BRL"));

        // Mock de transações por conta
        transacoesPorConta.put("123", Arrays.asList(
                new TransacaoDTO(LocalDate.now().minusDays(2), "Pagamento de boleto", new BigDecimal("-200.00"), "BRL"),
                new TransacaoDTO(LocalDate.now().minusDays(5), "Recebimento de salário", new BigDecimal("5000.00"), "BRL")
        ));

        transacoesPorConta.put("124", Arrays.asList(
                new TransacaoDTO(LocalDate.now().minusDays(2), "Pagamento de boleto p/ conta LUZ", new BigDecimal("-50.00"), "BRL"),
                new TransacaoDTO(LocalDate.now().minusDays(5), "Recebimento de salário", new BigDecimal("1500.00"), "BRL")
        ));

        transacoesPorConta.put("555", Arrays.asList(
                new TransacaoDTO(LocalDate.now().minusDays(2), "Pagamento fatura cartão de crédito", new BigDecimal("-230.00"), "BRL"),
                new TransacaoDTO(LocalDate.now().minusDays(5), "Recebimento de salário", new BigDecimal("10000.00"), "BRL"),
                new TransacaoDTO(LocalDate.now().minusDays(4), "Saque caixa eletrônico", new BigDecimal("20.00"), "BRL"),
                new TransacaoDTO(LocalDate.now().minusDays(3), "Transferência PIX", new BigDecimal("123.00"), "BRL")
        ));
    }

    /**
     * Consulta o saldo da conta.
     *
     * @param contaId ID da conta
     * @return dados da conta com saldo
     */
    public ContaDTO consultarSaldo(String contaId) {
        ContaDTO conta = contas.get(contaId);
        if (conta == null) {
            throw new ContaNaoEncontradaException("Saldo não encontrado para a conta: " + contaId);
        }
        return conta;
    }

    /**
     * Retorna a lista de contas do cliente.
     * (Mock simplificado: retorna todas as contas cadastradas, sem filtro por cliente)
     *
     * @param clienteId ID do cliente
     * @return lista de contas
     */
    public List<ContaDTO> listarContasCliente(String clienteId) {
        return new ArrayList<>(contas.values());
    }

    /**
     * Retorna as transações da conta informada.
     *
     * @param contaId ID da conta
     * @return lista de transações
     */
    public List<TransacaoDTO> listarTransacoes(String contaId) {
        if (!contas.containsKey(contaId)) {
            throw new ContaNaoEncontradaException("Conta não encontrada para extrato: " + contaId);
        }

        List<TransacaoDTO> transacoes = transacoesPorConta.get(contaId);
        if (transacoes == null || transacoes.isEmpty()) {
            throw new TransacaoNaoEncontradaException(contaId);
        }

        return transacoes;
    }
}
