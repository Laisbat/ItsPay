package br.com.avaliacaolais.itspay.controller.v1;

import br.com.avaliacaolais.itspay.dto.ClienteDTO;
import br.com.avaliacaolais.itspay.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cliente")
@Api("Serviços relacionados ao cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/cadastrar")
    @ApiOperation("Método para cadastrar cliente")
    public ResponseEntity cadastraCliente(ClienteDTO clienteDTO){


        return clienteService.cadastrar(clienteDTO);
    }
}
