package br.com.avaliacaolais.itspay.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class HistoricoRequisicaoDTO {
    private Date data;
    private String valor;
}
