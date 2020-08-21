package br.com.avaliacaolais.itspay.service;

import br.com.avaliacaolais.itspay.dto.ClienteDTO;
import br.com.avaliacaolais.itspay.dto.HistoricoRequisicaoDTO;
import br.com.avaliacaolais.itspay.dto.HistoricoResumoRequisicaoDTO;
import br.com.avaliacaolais.itspay.entity.ClienteEntity;
import br.com.avaliacaolais.itspay.entity.RequisicaoEntity;
import br.com.avaliacaolais.itspay.mapper.ClienteMapper;
import br.com.avaliacaolais.itspay.repository.RequisicaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import util.ValidatorUtil;

import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Slf4j
@Service
public class RequisicaoService {

    @Autowired
    RequisicaoRepository requisicaoRepository;

    @Autowired
    ClienteMapper clienteMapper;

    @Autowired
    ClienteService clienteService;

    public RequisicaoEntity salvar(String cpf){
        ClienteDTO cliente = clienteService.buscarPorCpf(cpf);

        if(cliente == null){
            return null;
        }

        RequisicaoEntity requisicaoEntity = new RequisicaoEntity();
        requisicaoEntity.setClienteEntity(clienteMapper.toEntity(cliente));
        requisicaoEntity.setData(new Date());

        return requisicaoRepository.save(requisicaoEntity);
    }

    private Integer recuperarQuantidadePorCpf(String cpf){
        return requisicaoRepository.recuperarQuantidadePorCpfMes(cpf, Integer.parseInt(recuperarMes(new Date())));
    }

    private List<RequisicaoEntity> listarRequisicoesPorCPF(String cpf){
        return requisicaoRepository.recuperarRequisicoesPorCpf(cpf);
    }

    public List<HistoricoResumoRequisicaoDTO> retornarHistoricoMes(String cpf){
        List<RequisicaoEntity> requisicoes = listarRequisicoesPorCPF(cpf);
        List<HistoricoResumoRequisicaoDTO> historico = new ArrayList<>();
        List<HistoricoRequisicaoDTO> historicoRequisicaoDTOS = new ArrayList<>();

        for(RequisicaoEntity requisicao : requisicoes){
            if(recuperarMes(requisicao.getData()).equals(recuperarMes(new Date()))){
                HistoricoResumoRequisicaoDTO historicoResumoRequisicaoDTO = new HistoricoResumoRequisicaoDTO();
                if(historico.isEmpty()){
                    historico.add(popularHistorico(historicoResumoRequisicaoDTO, requisicao,recuperarQuantidadePorCpf(cpf), calcularValorTotal(recuperarQuantidadePorCpf(cpf))));
                    historicoRequisicaoDTOS.add(popularHistoricoRequisicaoDTO(requisicao));
                }else{
                    historicoRequisicaoDTOS.add(popularHistoricoRequisicaoDTO(requisicao));
                }
            }
        }


        historico.get(0).setHistoricoRequisicaoDTO(historicoRequisicaoDTOS);
        return historico;
    }

    private HistoricoResumoRequisicaoDTO popularHistorico(HistoricoResumoRequisicaoDTO historicoResumoRequisicaoDTO, RequisicaoEntity requisicao, Integer quantidade, String valor){
        historicoResumoRequisicaoDTO.setMes(ValidatorUtil.getMesExtenso(recuperarMes(requisicao.getData())));
        historicoResumoRequisicaoDTO.setQuantidade(quantidade);
        historicoResumoRequisicaoDTO.setValor(valor);
        return  historicoResumoRequisicaoDTO;
    }

    private HistoricoRequisicaoDTO popularHistoricoRequisicaoDTO(RequisicaoEntity requisicao){
        HistoricoRequisicaoDTO historicoRequisicaoDTO = new HistoricoRequisicaoDTO();
        historicoRequisicaoDTO.setValor("0,10");
        historicoRequisicaoDTO.setData(requisicao.getData());
        return historicoRequisicaoDTO;
    }

    private String recuperarMes(Date data){
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        return sdf.format(data);
    }

    private String calcularValorTotal(Integer quantidade){
        DecimalFormat df = new DecimalFormat("###,##0.00");
        return df.format(quantidade * 0.10);
    }
}