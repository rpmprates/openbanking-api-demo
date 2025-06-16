package com.openbanking.service;


import com.openbanking.exceptions.PixInvalidoException;
import com.openbanking.model.request.TransferenciaPixRequest;
import com.openbanking.model.response.TransferenciaPixResponse;
import org.springframework.stereotype.Service;







import java.math.BigDecimal;
import java.util.UUID;

@Service
public class PixService {

    private final ContaService contaService;

    // injeta o mock de contas para validação
    public PixService(ContaService contaService) {
        this.contaService = contaService;
    }

    public TransferenciaPixResponse realizarTransferencia(TransferenciaPixRequest request) {
        // valida conta de origem
        if (request.getContaOrigemId() == null || request.getContaOrigemId().isBlank()) {
            throw new PixInvalidoException("Conta de origem inválida.");
        }
        // valida conta destino
        if (request.getContaDestinoId() == null || request.getContaDestinoId().isBlank()) {
            throw new PixInvalidoException("Conta de destino inválida.");
        }
        // verifica existência das contas
        contaService.consultarSaldo(request.getContaOrigemId());  // lança ContaNaoEncontradaException se não existir
        contaService.consultarSaldo(request.getContaDestinoId());

        // valida valor
        BigDecimal valor = request.getValor();
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new PixInvalidoException("Valor da transferência deve ser maior que zero.");
        }

        // simula débito e crédito (não persiste no mock)
        // retorna response com transactionId
        String transactionId = UUID.randomUUID().toString();
        return new TransferenciaPixResponse(
                transactionId,
                "Transferência PIX realizada com sucesso",
                request.getContaOrigemId(),
                request.getContaDestinoId(),
                valor,
                request.getMoeda()
        );
    }
}
