package br.com.avaliacaolais.itspay.repository;

import br.com.avaliacaolais.itspay.entity.ClienteEntity;
import br.com.avaliacaolais.itspay.entity.RequisicaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisicaoRepository extends JpaRepository<RequisicaoEntity, Long> {

    @Query(value="SELECT count(*) FROM RequisicaoEntity requisicao WHERE requisicao.clienteEntity.cpf =:cpf")
    Integer recuperarQuantidade(@Param("cpf") String cpf);
}
