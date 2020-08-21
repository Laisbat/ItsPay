package br.com.avaliacaolais.itspay.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HistoricoResumoRequisicaoDTO {
    private String mes;
    private Integer quantidade;
    private String valor;
    private List<HistoricoRequisicaoDTO> historicoRequisicaoDTO;
}
