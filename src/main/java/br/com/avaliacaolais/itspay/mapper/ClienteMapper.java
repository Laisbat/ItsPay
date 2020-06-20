package br.com.avaliacaolais.itspay.mapper;

import br.com.avaliacaolais.itspay.dto.ClienteDTO;
import br.com.avaliacaolais.itspay.entity.ClienteEntity;
import br.com.avaliacaolais.itspay.mapper.base.BaseMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface ClienteMapper extends BaseMapper<ClienteEntity, ClienteDTO> {
}
