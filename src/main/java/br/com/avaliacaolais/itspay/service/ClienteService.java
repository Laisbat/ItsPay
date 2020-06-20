package br.com.avaliacaolais.itspay.service;


import br.com.avaliacaolais.itspay.dto.ClienteDTO;
import br.com.avaliacaolais.itspay.mapper.ClienteMapper;
import br.com.avaliacaolais.itspay.repository.ClienteRepository;
import br.com.avaliacaolais.itspay.service.base.AbstractServiceBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import util.ValidatorUtil;

@Slf4j
@Service
public class ClienteService extends AbstractServiceBase {


    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteDTO buscarPorCpf(String cpf){
        return clienteMapper.toDto(clienteRepository.findByCPF(cpf));
    }

    public ResponseEntity cadastrar(ClienteDTO clienteDTO) {
        if(tratarCampos(clienteDTO) != null){
            return tratarCampos(clienteDTO);
        }

        if (clienteRepository.findByCPF(clienteDTO.getCpf()) != null) {
            return new ResponseEntity("Cliente já existe.", HttpStatus.CONFLICT);
        }

        return new ResponseEntity(clienteRepository.save((clienteMapper.toEntity(clienteDTO))), HttpStatus.CREATED);
    }

    private ResponseEntity tratarCampos(ClienteDTO clienteDTO) {
        if (validarCampoVazio(clienteDTO.getNome()) && validarCampoVazio(clienteDTO.getCpf())) {
            return mensagemErro("Os campos cpf e nome são obrigatórios");
        } else if (validarCampoVazio(clienteDTO.getCpf())) {
            return mensagemErro("Campo Obrigatório: " + "cpf");
        } else if (validarCampoVazio(clienteDTO.getNome())) {
            return mensagemErro("Campo Obrigatório: " + "nome");
        } else if (!ValidatorUtil.verificarCpf(clienteDTO.getCpf())) {
            return mensagemErro("CPF inválido: " + clienteDTO.getCpf());
        }else{
            return null;
        }
    }

    private boolean validarCampoVazio(String valor) {
        if (valor == null) {
            return true;
        }
        return false;
    }

    private ResponseEntity mensagemErro(String mensagem) {
        return new ResponseEntity(mensagem, HttpStatus.BAD_REQUEST);
    }
}
