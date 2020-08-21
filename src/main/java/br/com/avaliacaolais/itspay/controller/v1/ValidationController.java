package br.com.avaliacaolais.itspay.controller.v1;

import br.com.avaliacaolais.itspay.service.RequisicaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import util.ValidatorUtil;

@RestController
@RequestMapping("/v1/validation")
@Api("Serviços para validações")
public class ValidationController {

    @Autowired
    RequisicaoService requisicaoService;

    @GetMapping("/cpf/{cpf}/{cpfUsuarioLogado}")
    @ApiOperation("Valida CPF")
    public ResponseEntity<String> validaCPF(@PathVariable final String cpfUsuarioLogado, @PathVariable final String cpf) {

        if(requisicaoService.salvar(cpfUsuarioLogado) == null){
            return new ResponseEntity<>("Usuário não possui cadastro.", HttpStatus.OK);
        }

        if(!ValidatorUtil.verificarCpf(cpf)){
            return new ResponseEntity<>("Cpf inválido", HttpStatus.OK);
        }

        return new ResponseEntity<>("Cpf válido", HttpStatus.OK);
    }

    @GetMapping("/cnpj/{cnpj}/{cpfUsuarioLogado}")
    @ApiOperation("Valida CNPJ")
    public ResponseEntity<String> validaCNPJ(@PathVariable final String cpfUsuarioLogado, @PathVariable final String cnpj) {
        if(requisicaoService.salvar(cpfUsuarioLogado) == null){
            return new ResponseEntity<>("Usuário não possui cadastro.", HttpStatus.OK);
        }

        if(!ValidatorUtil.verificarCNPJ(cnpj)){
            return new ResponseEntity<>("Cnpj inválido", HttpStatus.OK);
        }

        return new ResponseEntity<>("Cnpj válido", HttpStatus.OK);
    }
}