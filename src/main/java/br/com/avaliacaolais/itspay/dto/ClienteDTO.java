package br.com.avaliacaolais.itspay.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    private Long codigoCliente;
    private String nome;
    private String cpf;
}
