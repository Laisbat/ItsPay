package br.com.avaliacaolais.itspay.controller.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/validation")
@Api("Serviços para validações")
public class Validation {

    @GetMapping("/validaCPF/{cpf}")
    @ApiOperation("Valida CPF")
    public String validaCPF(@PathVariable String cpf) {
        if(cpf.length() != 11){
            return "CPF deve conter 11 dígitos";
        }
        return "CPF válido!";
    }
    @GetMapping("/validaCNPJ/{cnpj}")
    @ApiOperation("Valida CNPJ")
    public String validaCNPJ(@PathVariable String cnpj) {
        if(cnpj.length() != 14){
            return "CNPJ deve conter 14 dígitos";
        }
        return "CNPJ válido!";
    }
}