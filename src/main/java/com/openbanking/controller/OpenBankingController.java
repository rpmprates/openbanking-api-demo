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

    @GetMapping("/saldo")
    public ContaDTO consultarSaldo(@RequestParam("conta") String contaId) {
        return contaService.consultarSaldo(contaId);
    }

    @GetMapping("/dados-cliente")
    public ClienteDTO consultarDadosCliente(@RequestParam("cliente") String clienteId) {
        return clienteService.consultarDadosCliente(clienteId);
    }

    @GetMapping("/contas-cliente")
    public List<ContaDTO> listarContasCliente(@RequestParam("cliente") String clienteId) {
        return contaService.listarContasCliente(clienteId);
    }

    @GetMapping("/transacoes")
    public List<TransacaoDTO> listarTransacoes(@RequestParam("conta") String contaId) {
        return contaService.listarTransacoes(contaId);
    }

    @PostMapping("/pix/transferencias")
    public TransferenciaPixResponse realizarTransferenciaPix(@RequestBody TransferenciaPixRequest request) {
        return pixService.realizarTransferencia(request);
    }

    @GetMapping("/limite-credito")
    public LimiteCreditoDTO consultarLimiteCredito(@RequestParam("cliente") String clienteId) {
        return clienteService.consultarLimiteCredito(clienteId);
    }
}
