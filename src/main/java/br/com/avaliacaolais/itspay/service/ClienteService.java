package br.com.avaliacaolais.itspay.service;


import br.com.avaliacaolais.itspay.dto.ClienteDTO;
import br.com.avaliacaolais.itspay.mapper.ClienteMapper;
import br.com.avaliacaolais.itspay.repository.ClienteRepository;
import br.com.avaliacaolais.itspay.service.base.AbstractServiceBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClienteService extends AbstractServiceBase {


    private final ClienteRepository clienteRepository;

    private  final ClienteMapper clienteMapper;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public void cadastrar(ClienteDTO clienteDTO){

        if(clienteRepository.findByCPF(clienteDTO.getCpf()).isPresent()){
            clienteRepository.save((clienteMapper.toEntity(clienteDTO)));
        }

         clienteRepository.save((clienteMapper.toEntity(clienteDTO)));
    }
}
