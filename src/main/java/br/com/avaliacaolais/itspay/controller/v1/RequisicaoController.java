package br.com.avaliacaolais.itspay.controller.v1;

import br.com.avaliacaolais.itspay.dto.HistoricoRequisicaoDTO;
import br.com.avaliacaolais.itspay.dto.HistoricoResumoRequisicaoDTO;
import br.com.avaliacaolais.itspay.service.RequisicaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/requisicao")
@Api("Serviços relacionados a requisição")
public class RequisicaoController {

    @Autowired
    RequisicaoService requisicaoService;

    @GetMapping("/{cpfUsuarioLogado}")
    @ApiOperation("Recuperar histórico de requisições do mês")
    public List<HistoricoResumoRequisicaoDTO> recuperarHistorico(@PathVariable final String cpfUsuarioLogado){
        return requisicaoService.retornarHistoricoMes(cpfUsuarioLogado);
    }
}
