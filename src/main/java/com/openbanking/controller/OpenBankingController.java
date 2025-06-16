package com.openbanking.controller;

import com.openbanking.model.dto.ClienteDTO;
import com.openbanking.model.dto.ContaDTO;
import com.openbanking.model.dto.LimiteCreditoDTO;
import com.openbanking.model.dto.TransacaoDTO;
import com.openbanking.model.request.TransferenciaPixRequest;
import com.openbanking.model.response.TransferenciaPixResponse;
import com.openbanking.service.ClienteService;
import com.openbanking.service.ContaService;
import com.openbanking.service.PixService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/open-banking")
public class OpenBankingController {

    private final ContaService contaService;
    private final ClienteService clienteService;
    private final PixService pixService;

    public OpenBankingController(ContaService contaService,
                                 ClienteService clienteService,
                                 PixService pixService) {
        this.contaService = contaService;
        this.clienteService = clienteService;
        this.pixService = pixService;
    }

    @GetMapping("/contas/{contaId}/saldo")
    public ContaDTO consultarSaldo(@PathVariable String contaId) {
        return contaService.consultarSaldo(contaId);
    }

    @GetMapping("/clientes/{clienteId}/dados")
    public ClienteDTO consultarDadosCliente(@PathVariable String clienteId) {
        return clienteService.consultarDadosCliente(clienteId);
    }

    @GetMapping("/clientes/{clienteId}/contas")
    public List<ContaDTO> listarContasCliente(@PathVariable String clienteId) {
        return contaService.listarContasCliente(clienteId);
    }

    @GetMapping("/contas/{contaId}/transacoes")
    public List<TransacaoDTO> listarTransacoes(@PathVariable String contaId) {
        return contaService.listarTransacoes(contaId);
    }

    @PostMapping("/pix/transferencias")
    public TransferenciaPixResponse realizarTransferenciaPix(
            @RequestBody TransferenciaPixRequest request) {
        return pixService.realizarTransferencia(request);
    }

    @GetMapping("/clientes/{clienteId}/limite-credito")
    public LimiteCreditoDTO consultarLimiteCredito(@PathVariable String clienteId) {
        return clienteService.consultarLimiteCredito(clienteId);
    }
}