package br.com.avaliacaolais.itspay.repository;

import br.com.avaliacaolais.itspay.entity.RequisicaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequisicaoRepository extends JpaRepository<RequisicaoEntity, Long> {
    @Query(value="SELECT count(*) FROM RequisicaoEntity requisicao WHERE requisicao.clienteEntity.cpf =:cpf and MONTH(requisicao.data) = :mes")
    Integer recuperarQuantidadePorCpfMes(@Param("cpf") String cpf, @Param("mes") Integer mes);

    @Query(value="SELECT requisicao FROM RequisicaoEntity requisicao WHERE requisicao.clienteEntity.cpf =:cpf")
    List<RequisicaoEntity> recuperarRequisicoesPorCpf(@Param("cpf") String cpf);
}
