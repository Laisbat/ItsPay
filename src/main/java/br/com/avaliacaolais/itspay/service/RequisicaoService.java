package br.com.avaliacaolais.itspay.service;

import br.com.avaliacaolais.itspay.dto.ClienteDTO;
import br.com.avaliacaolais.itspay.entity.ClienteEntity;
import br.com.avaliacaolais.itspay.entity.RequisicaoEntity;
import br.com.avaliacaolais.itspay.mapper.ClienteMapper;
import br.com.avaliacaolais.itspay.repository.RequisicaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Slf4j
@Service
public class RequisicaoService {

    @Autowired
    RequisicaoRepository requisicaoRepository;

    @Autowired
    ClienteMapper clienteMapper;

    @Autowired
    ClienteService clienteService;

    public RequisicaoEntity salvarRequisicao(String cpf){
        ClienteDTO cliente = clienteService.buscarPorCpf(cpf);

        RequisicaoEntity requisicaoEntity = new RequisicaoEntity();
        requisicaoEntity.setClienteEntity(clienteMapper.toEntity(cliente));
        requisicaoEntity.setData(new Date());

        return requisicaoRepository.save(requisicaoEntity);
    }
}
