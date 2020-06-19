package br.com.avaliacaolais.itspay.service;


import br.com.avaliacaolais.itspay.dto.ClienteDTO;
import br.com.avaliacaolais.itspay.dto.ErroDTO;
import br.com.avaliacaolais.itspay.mapper.ClienteMapper;
import br.com.avaliacaolais.itspay.repository.ClienteRepository;
import br.com.avaliacaolais.itspay.service.base.AbstractServiceBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public ResponseEntity cadastrar(ClienteDTO clienteDTO) {

        if (!validarCampoVazio(clienteDTO.getNome()) || !validarCampoVazio(clienteDTO.getCpf())){
            if (clienteDTO.getNome() != null) {
                return mensagemErro("Campo Obrigatório:" + "cpf");
            }
            return mensagemErro("Campo Obrigatório:" + "nome");
        }

        if (!validarTamanhoCampo(clienteDTO.getCpf(), 11) || !validarTamanhoCampo(clienteDTO.getCnpj(), 14) && clienteDTO.getCnpj() != null) {
            if (!validarTamanhoCampo(clienteDTO.getCpf(), 11)) {
                return mensagemErro("CPF deve conter 11 dígitos: " + clienteDTO.getCpf());
            }
            return mensagemErro("CPNJ deve conter 14 dígitos: " + clienteDTO.getCnpj());
        }

        if (clienteRepository.findByCPF(clienteDTO.getCpf()).isPresent()) {
            return new ResponseEntity(null, HttpStatus.CONFLICT);
        }
        return new ResponseEntity(clienteRepository.save((clienteMapper.toEntity(clienteDTO))), HttpStatus.CREATED);

    }

    private ErroDTO popularErro(String mensagem) {
        ErroDTO erroDTO = new ErroDTO();
        erroDTO.setMensagemErro(mensagem);
        return erroDTO;
    }

    private boolean validarTamanhoCampo(String valor, Integer numero) {
        if (valor.length() != numero) {
            return false;
        }
        return true;
    }

    private boolean validarCampoVazio(String valor) {
        if (valor == null) {
            return false;
        }
        return true;
    }

    private ResponseEntity mensagemErro(String mensagem) {
        return new ResponseEntity(mensagem, HttpStatus.BAD_REQUEST);
    }
}
